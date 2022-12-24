package com.crypto_backend.polygon_call.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.crypto_backend.polygon_call.api_utility.API_URI;
import com.crypto_backend.polygon_call.dto.CoinToListDto;
import com.crypto_backend.polygon_call.model.PreviousCloseAPI;
import com.crypto_backend.polygon_call.service.CryptoServiceInter;

@Service
public class CryptoService implements CryptoServiceInter{

  @Autowired
  API_URI api;

  private List<String> arrayToList (String[] arr){
    return Arrays.asList(arr);
  }

  private PreviousCloseAPI getCoinInfoHelper(String coinId){
    RestTemplate restTemplate = new RestTemplate();
    String url = api.generateAPIPreviousClose(coinId);
    PreviousCloseAPI previousCloseAPI = restTemplate.getForObject(url, PreviousCloseAPI.class);
    //previousCloseApiResultChecker(previousCloseAPI)
    if(Objects.isNull(previousCloseAPI))throw new NullPointerException();
    return previousCloseAPI;
  }

  //好快
  private void previousCloseApiResultChecker(PreviousCloseAPI previousCloseAPI){
    if(previousCloseAPI.getResults().isEmpty()) throw new NullPointerException(); //there is no result, the id is wrong
    if(previousCloseAPI.getResults().get(0).getVw()==null) throw new NullPointerException(); //冇vm,錯info
  }

  private Double getRateFromPreviousCloseHelper(PreviousCloseAPI previousCloseAPI){
    previousCloseApiResultChecker(previousCloseAPI);
    return previousCloseAPI.getResults().get(0).getVw();
  }

  @Override
  // tbc, since it would not be call, I just leave alone until it will be used
  public PreviousCloseAPI getCoinInfoById(String[] coinIds) {  
    List<String> coinList = arrayToList(coinIds);
    if(Objects.isNull(coinList))throw new NullPointerException();
    return getCoinInfoHelper(coinList.get(0));

    }

  @Override
  public CoinToListDto getCoinInfoByIdInlist(List<String> coins) {
    CoinToListDto returnedList = new CoinToListDto();
    for(int i=0;i<coins.size();i++){
      PreviousCloseAPI singleElement = getCoinInfoHelper(coins.get(i));
      //getTicker would never be null, even though we input the wrong result,still get the ticker
      CoinToListDto.convertToDtoAndAddInList(singleElement.getTicker(), getRateFromPreviousCloseHelper(singleElement), returnedList);
    }
    return returnedList;
  }

  
  
}
