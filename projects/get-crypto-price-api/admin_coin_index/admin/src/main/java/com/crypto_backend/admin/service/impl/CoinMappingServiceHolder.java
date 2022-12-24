package com.crypto_backend.admin.service.impl;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.crypto_backend.admin.dto.CoinAndTransactionInfo;
import com.crypto_backend.admin.entity.ChannelTransaction;
import com.crypto_backend.admin.entity.Channels;
import com.crypto_backend.admin.entity.CoinMapping;
import com.crypto_backend.admin.entity.UpdatedId;
import com.crypto_backend.admin.problem.self_define_exception.PostRejectDataAlreadyExist;
import com.crypto_backend.admin.problem.self_define_exception.UUIDCannotSaveInDataBase;
import com.crypto_backend.admin.repository.ChannelTransactionRepository;
import com.crypto_backend.admin.repository.ChannelsRepository;
import com.crypto_backend.admin.repository.CoinMappingRepository;
import com.crypto_backend.admin.repository.UpdatedIdRepository;
import com.crypto_backend.admin.service.CoinMappingService;

@Service
public class CoinMappingServiceHolder implements CoinMappingService{

    @Autowired
    CoinMappingRepository coinMappingRepository;

    @Autowired
    ChannelTransactionRepository channelTransactionRepository;

    @Autowired
    ChannelsRepository channelsRepository;

    @Autowired
    UpdatedIdRepository updatedIdRepository;

    @Autowired
    RedisTemplate<String,CoinAndTransactionInfo> redisTemplate;
    
    // select * from
    /**
     * find the data only exclude id
     * select channel_transaction where domain_url=?, cource_app=? and channel_id =?
     * @param domainUrl url
     * @param sourceApp source app
     * @param channelId channel id, which is foreign key of channel
     * @return transaction
     */
    private Optional<ChannelTransaction> getChannelTransactionByChannelIdAndDomainUrl(String domainUrl, String sourceApp,Long channelId){
        return channelTransactionRepository.findByDomainUrlAndSourceAppAndChannelId(domainUrl, sourceApp,channelId);
    }

    /**
     * aim to locate the coin code
     * jpa
     * @param channelId channel id
     * @param coinId coin id
     * @return list of coinmapping
     */
    private List<CoinMapping> getCoinMappingWithChannelByCoinIdAndChannelId(Long channelId,List<String> coinId){
        return coinMappingRepository.findByCoinIdInAndChannelId(coinId, channelId);
    }

    /**
     * it is one-to-many relation in channel and coinmapping, coinmapping contain many id about channel, but we only need one
     * @param coinMappings
     * @return
     */
    private Channels getChannelsFromCoinMappingWithSameChannelId(List<CoinMapping> coinMappings){
        return coinMappings.get(0).getChannelsForCoin();
    }

    // get and construct to dto
    @Override
    public CoinAndTransactionInfo getAllWithDto(Long channelId, String domainUrl, String sourceApp, List<String> coinId) {
        String redisKey = this.generatedRedisKey(channelId, domainUrl, sourceApp, coinId);
        if(redisTemplate.opsForValue().get(redisKey)!=null){
            return redisTemplate.opsForValue().get(redisKey);
        }
       
        //looking for channel transaction version and domain
        Optional<ChannelTransaction> channelTran = getChannelTransactionByChannelIdAndDomainUrl(domainUrl,sourceApp, channelId);
        
        //looking for coinCode
        List<CoinMapping> coinMappings = getCoinMappingWithChannelByCoinIdAndChannelId(channelId, coinId);
        
        //looking channel to decide call which base url/host(decide which url to call third party)
        Channels channelForCoin = getChannelsFromCoinMappingWithSameChannelId(coinMappings);

        //to dto
        CoinAndTransactionInfo returned = CoinAndTransactionInfo.toDto(channelTran, coinMappings, channelForCoin);

        redisTemplate.opsForValue().set(redisKey, returned,Duration.ofMinutes(10L)); //can be better with async

        return returned;
    }

    /**
     * set redis key
     * @param channelId channel id
     * @param domainUrl domain url
     * @param sourceApp source app
     * @param coinId coin id
     * @return String key
     */
    private String generatedRedisKey(Long channelId, String domainUrl, String sourceApp, List<String> coinId){
        StringBuilder key = new StringBuilder();
        return key.append("channelId:")
            .append(channelId)
            .append("domainUrl:")
            .append(domainUrl)
            .append("sourceApp:")
            .append(sourceApp)
            .append("coinId:")
            .append(String.join(",", coinId)).toString();        
    }


    /**
     * check if uuid is already existed, that mean the transaction is already execute
     * @param uuid
     * @return boolean
     */
    private boolean isUpdated(UUID uuid){
        return updatedIdRepository.findById(uuid).isPresent();
    }

    /**
     * insert into (jpa)
     * @param channelCode channelCode
     * @param channelUrl channelUrl
     */
    private void insertChannelsHelper(String channelCode, String channelUrl){
        
        Channels channel = new Channels();
        channel.setChannelCode(channelCode);
        channel.setChannelUrl(channelUrl);
        //channel.setId(null) 加左都係null
        //channel.setLastUpdatedDate(null) 加左都係null
        channelsRepository.save(channel);
    }

    //overloading
    /**
     * insert into v2, it may not be very useful, just a demo that we can use dto as param and handle in this method
     * @param coinAndTransactionInfo dto
     */
    private void insertChannelsHelper (CoinAndTransactionInfo coinAndTransactionInfo){
        insertChannelsHelper(coinAndTransactionInfo.getChannelCode(),coinAndTransactionInfo.getChannelUrl());
    }

    /**
     * insert into(jpa)
     * @param channelId channelId 
     * @param domainVersion domainVersion
     * @param domainUrl domainUrl
     * @param sourceApp SourceApp
     * @param transactionType TransactionType
     * @param transactionStatus TransactionStatus
     */
    private void insertChannelTransactionHelper(Long channelId, String domainVersion, String domainUrl, String sourceApp,
        String transactionType, String transactionStatus){

        ChannelTransaction channelTransaction = new ChannelTransaction();
        channelTransaction.setId(null);
        channelTransaction.setChannelId(channelId);
        channelTransaction.setDomainVersion(domainVersion);
        channelTransaction.setDomainUrl(domainUrl);
        channelTransaction.setSourceApp(sourceApp);
        channelTransaction.setTransactionType(transactionType);
        channelTransaction.setTransactionStatus(transactionStatus);

        channelTransactionRepository.save(channelTransaction);
    }
    
    /**
     * insert into
     * @param channelId channelId
     * @param coinCode coinCode
     * @param coinId coinId 
     * @param coinStatus coinStatus
     */
    private void insertCoinMappingHelper(Long channelId, String coinCode, String coinId,String coinStatus){
        CoinMapping insertEntity = new CoinMapping();
        insertEntity.setChannelId(channelId);
        insertEntity.setCoinCode(coinCode);
        insertEntity.setCoinId(coinId);
        insertEntity.setCoinStatus(coinStatus);
        
        coinMappingRepository.save(insertEntity);
    }

    /**
     * check if the uuid is exist at the beginning, ensure the transaction is new and idempotent (冪等)
     * https://matthung0807.blogspot.com/2019/02/http-idempotent-methods.html
     * @param uuid uuid
     */
    private void beforePostCheckHelper(UUID uuid){
        if(isUpdated(uuid))throw new PostRejectDataAlreadyExist();
        
    }

    /**
     * check if the data is insert/update/delete from table, then save the uuid code
     * @param isExist isExist: 
     * @param uuid uuid
     */
    private void afterPostCheckHelper(boolean isExist, UUID uuid){
        if(!isExist) throw new NullPointerException(); // 

        //save uuid after check
        updatedIdRepository.save(new UpdatedId(uuid));
        if(!isUpdated(uuid)) throw new UUIDCannotSaveInDataBase();
    }

    @Override
    public void insertCoinMapping(Long channelId, String coinCode, String coinId, String coinStatus, UUID uuid) {
        beforePostCheckHelper(uuid);
        
        insertCoinMappingHelper(channelId, coinCode, coinId, coinStatus);
        
        boolean updatedInInsert = coinMappingRepository.existsByChannelIdAndCoinCodeAndCoinIdAndCoinStatus(channelId, coinCode,coinId,coinStatus);
        afterPostCheckHelper(updatedInInsert, uuid);
    }

    @Override
    public void insertChannels(String channelCode, String channelUrl, UUID uuid) {
        beforePostCheckHelper(uuid);
        
        insertChannelsHelper(channelCode, channelUrl);
        
        boolean updatedInInsert = channelsRepository.existsByChannelCodeAndChannelUrl(channelCode,channelUrl);
        afterPostCheckHelper(updatedInInsert, uuid);       
    }

    @Override
    public void insertChannelTransaction(Long channelId, String domainVersion, String domainUrl, String sourceApp,
                                        String transactionType, String transactionStatus, UUID uuid) {
       
        beforePostCheckHelper(uuid);

        insertChannelTransactionHelper(channelId, domainVersion, domainUrl, sourceApp, transactionType, transactionStatus);

        boolean updatedInInsert = channelTransactionRepository.existsByChannelIdAndDomainVersionAndDomainUrlAndSourceAppAndTransactionTypeAndTransactionStatus(channelId,domainVersion,domainUrl,sourceApp,transactionType,transactionStatus);
        afterPostCheckHelper(updatedInInsert, uuid);         
    }





    @Override
    //tbc
    //require check for the new entity
    public void insertWholeNewInfo(CoinAndTransactionInfo coinAndTransactionInfo) {
        for(CoinMapping coinM: coinAndTransactionInfo.getCoinMappings()){
            coinM.setId(null);
            coinMappingRepository.save(coinM);
        }

        channelTransactionRepository.save(coinAndTransactionInfo.getChannelTransaction());

        insertChannelsHelper(coinAndTransactionInfo);


        
    }



    @Override
    //tbc
    public void updateWholeInfo(CoinAndTransactionInfo coinAndTransactionInfo) {
        //missing find by
        //if not exist, then it should not be save
        insertChannelsHelper(coinAndTransactionInfo); //save 

        for(CoinMapping coinM: coinAndTransactionInfo.getCoinMappings()){
            coinMappingRepository.save(coinM);
        }

        channelTransactionRepository.save(coinAndTransactionInfo.getChannelTransaction());
    }

}
