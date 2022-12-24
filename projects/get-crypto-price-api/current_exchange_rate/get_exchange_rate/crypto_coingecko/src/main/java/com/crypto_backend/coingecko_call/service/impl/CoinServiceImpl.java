package com.crypto_backend.coingecko_call.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.crypto_backend.coingecko_call.api_utility.API_URI;
import com.crypto_backend.coingecko_call.dto.CoinToListDto;
import com.crypto_backend.coingecko_call.dto.CoinToUsdDto;
import com.crypto_backend.coingecko_call.dto.ExchangeRate;
import com.crypto_backend.coingecko_call.model.CoinMarketAPI;
import com.crypto_backend.coingecko_call.model.CryptoExchangeRate;
import com.crypto_backend.coingecko_call.model.SimplePriceAPI;
import com.crypto_backend.coingecko_call.problem.self_define_exception.DeserializeFailure;
import com.crypto_backend.coingecko_call.service.CoinService;

@Service
public class CoinServiceImpl implements CoinService{

  @Autowired
  API_URI api;

  @Value("${API.Crypto.parm.elements_numbers}")
  int targetedElement;

  
  // list of all coin market
  @Override
  public List<CoinMarketAPI> coinMarket(String coinId, String currency) {
    //construct api uri
    String uri = api.generateAPICoinMarkets(coinId, currency);

    ////@SuppressWarnings("unchecked") //只可於百分百ensure係咁先用, first way to NOT handle the type safety
    //get it with rest template with type safety
    //List<Object> getApi = this.checkApi(uri)
    RestTemplate restTemplate = new RestTemplate();
    List<Object> getApi = castList(Object.class,restTemplate.getForObject(uri, List.class));
    //loop and map the object to the model, then return

    return getTargetAmountElement(getApi); //應該開個新既class 去行
    

  }

  //exchange rate in bitcoin to different country currency
  //這個 url有過長問題(?)
  @Override
  public Map<String, CryptoExchangeRate> getexchangeRate() {
    RestTemplate restTemplate = new RestTemplate();
    ModelMapper mapper = new ModelMapper();
    
    @SuppressWarnings("unchecked") //sure it is map<string,map<String,Object>>
    Map<String, Map<String,Object>> x = restTemplate.getForObject(api.generateAPIExchangeRate(), Map.class);
    
    Map<String, Object>newMap;
    if(Objects.isNull(x)) {
      throw new NullPointerException();
    }else{
     newMap= x.get("rates");
    }
 
    Map<String, CryptoExchangeRate> returned = new HashMap<>();
    for(Map.Entry<String,Object> o: newMap.entrySet()){
      returned.put(o.getKey(), mapper.map(o.getValue(), CryptoExchangeRate.class));
    }
    return returned;
  }

  /**
   * 
   * @param getApiFromRestTemplate
   * @return
   */
  private List<CoinMarketAPI> getTargetAmountElement(List<Object> getApiFromRestTemplate){
    ModelMapper mapper = new ModelMapper();
    List<CoinMarketAPI> coinMarketAPIs = new ArrayList<>();
    int maxSize=Math.min(targetedElement, getApiFromRestTemplate.size());
  
    for(int i=0;i<maxSize;i++){
      coinMarketAPIs.add(mapper.map(getApiFromRestTemplate.get(i),CoinMarketAPI.class));
    }
    return coinMarketAPIs;
  }
  

  /**
   * way to handle the type safe
   * @param <T> since we serialize the json to object, this should be ok in any class.
   * @param clazz class that we want to down casting.
   * @param rawCollection collect, which would be List of object.
   * @return  list of class that we expected.
   * @throws ClassCastException handle exception.
   */
  private <T> List<T> castList(Class<? extends T> clazz, Collection<?> rawCollection) throws ClassCastException {
    if(Objects.isNull(rawCollection)) throw new NullPointerException(); 

    List<T> result = new ArrayList<>(rawCollection.size());
    for (Object o : rawCollection) {
    result.add(clazz.cast(o));
    }
    return result;
  }

  //simple price
  /**
   * 
   * it used to get the deserialize the json into map and do the checking
   * @param ids string that contain list of coins which seperate in with',' .
   * @param currencies default and suppose to be "usd", mean currency.
   * @return map, require a further mapping like model mapper.
   * @throws DeserializeFailure
   */
  private Map<String, Object> getSimplePriceExchangeRateHelper(String ids, String currencies) throws DeserializeFailure{
    RestTemplate restTemplate = new RestTemplate();

    @SuppressWarnings("unchecked")
    Map<String, Object> deserFromJson = restTemplate.getForObject(api.generateAPISimplePrice(ids,currencies), Map.class);  
    
    if(Objects.isNull(deserFromJson))throw new DeserializeFailure();
    
    return deserFromJson;
  }

  /**
   * construct the list of string to be a string, seperate by ','.
   * @param listOfString list of string.
   * @return string.
   */
  private String contructListOfStringToString(String[] listOfString){
    StringBuilder str = new StringBuilder();
    for(String e: listOfString){
      str.append(e);
      str.append(",");
    }
    return str.substring(0, str.length()-1);

  }

  @Override
  public Map<String, SimplePriceAPI> getSimplePriceExchangeRate(String[] coinIds, String[] currencies) {
    String ids = this.contructListOfStringToString(coinIds);
    String currenciesToString = this.contructListOfStringToString(currencies);
    Map<String, Object> deserFromJson = getSimplePriceExchangeRateHelper(ids, currenciesToString);
    
    ModelMapper mapper = new ModelMapper();
    Map<String, SimplePriceAPI> simplePriceMap = new HashMap<>();

    for(Map.Entry<String,Object> i:deserFromJson.entrySet()){
      simplePriceMap.put(i.getKey(), mapper.map(i.getValue(), SimplePriceAPI.class));
    }
    
    return simplePriceMap;
  }

  @Override
  public Map<String, CoinToUsdDto> getSimplePriceExchangeRateInUsd(String[] coinIds, String[] currencies) {
    String ids = this.contructListOfStringToString(coinIds);
    String currenciesToString = this.contructListOfStringToString(currencies);
    Map<String, Object> deserFromJson = getSimplePriceExchangeRateHelper(ids, currenciesToString);
    ModelMapper mapper =new ModelMapper();
    
    Map<String, CoinToUsdDto> returnedMap = new HashMap<>();
    for(Map.Entry<String,Object> i:deserFromJson.entrySet()){
      returnedMap.put(i.getKey(), new CoinToUsdDto(i.getKey(),mapper.map(i.getValue(), SimplePriceAPI.class).getUsd()));
    }
    
    return returnedMap;
  }



  @Override
  public CoinToListDto getSimplePriceExchangeRateToListInUsd(String[] coins, String[] currencies) {
    String ids = this.contructListOfStringToString(coins);
    String currenciesToString = this.contructListOfStringToString(currencies);
    Map<String, Object> deserFromJson = getSimplePriceExchangeRateHelper(ids, currenciesToString);
    ModelMapper mapper =new ModelMapper();
    CoinToListDto returnedList = new CoinToListDto();

    for(Map.Entry<String,Object> i:deserFromJson.entrySet()){
      SimplePriceAPI temp = mapper.map(i.getValue(),SimplePriceAPI.class);
      //可以咁寫,但因為個dto入面冇依個method,所以要加番入去
      //CoinToListDto.convertToDtoAndAddInList(i.getKey(), temp.getUsd(), returnedList)

      returnedList.addList(ExchangeRate.fromCoinToCurrencyInUsd(i.getKey(), temp.getUsd()));
      returnedList.addList(ExchangeRate.fromCurrencyToCoinInUsd(i.getKey(), temp.getUsd()));
    }
    
    return returnedList;

  }


    
}
