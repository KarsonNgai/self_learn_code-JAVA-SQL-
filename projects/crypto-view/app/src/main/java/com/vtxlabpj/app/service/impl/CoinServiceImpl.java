package com.vtxlabpj.app.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vtxlabpj.app.api_utility.API_URI;
import com.vtxlabpj.app.dto.CoinMarketAPI;
import com.vtxlabpj.app.service.CoinService;

@Service
public class CoinServiceImpl implements CoinService{

  @Autowired
  API_URI api;

  @Value("${API.Crypto.how_many_elements}")
  int targetedElement;

  @Override
  public List<CoinMarketAPI> coinMarket(String coinId, String currency) {
    //construct api uri
    String uri = api.generateAPI(coinId, currency);

    ////@SuppressWarnings("unchecked") //只可於百分百ensure係咁先用, first way to NOT handle the type safety
    //get it with rest template with type safety
    //List<Object> getApi = this.checkApi(uri);
    RestTemplate restTemplate = new RestTemplate();
    List<Object> getApi = castList(Object.class,restTemplate.getForObject(uri, List.class));
    //loop and map the object to the model, then return
    return getTargetAmountElement(getApi);
    

  }

  
  private List<CoinMarketAPI> getTargetAmountElement(List<Object> getApiFromRestTemplate){
    ModelMapper mapper = new ModelMapper();
    List<CoinMarketAPI> coinMarketAPIs = new ArrayList<>();
    int maxSize=Math.min(targetedElement, getApiFromRestTemplate.size());
    for(int i=0;i<maxSize;i++){
      coinMarketAPIs.add(mapper.map(getApiFromRestTemplate.get(i),CoinMarketAPI.class));
    }
    return coinMarketAPIs;
  }
  
  // second way to handle the safety
  private <T> List<T> castList(Class<? extends T> clazz, Collection<?> rawCollection) throws ClassCastException {
    if(Objects.isNull(rawCollection)) throw new NullPointerException(); 

    List<T> result = new ArrayList<>(rawCollection.size());
    for (Object o : rawCollection) {
    result.add(clazz.cast(o));
    }
    return result;
  }
    
}
