package com.crypto_backend.polygon_call.api_utility;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;
//link:https://polygon.io/docs/crypto/get_v2_aggs_ticker__cryptoticker__prev
@Component
public class API_URI {
  @Value("${API.Crypto.baseUrl}")
  private String baseUrl;

  @Value("${API.Crypto.serviceVers}")
  private String serviceVers;

  //api
  @Value("${API.Crypto.serviceUrl.previous_close.path1}")
  private String serviceUrlPreviousClose;

  @Value("${API.Crypto.serviceUrl.previous_close.path3}")
  private String serviceUrlPreviousClosePrev;

  @Value("${API.api_key}")
  private String key;

  private UriComponentsBuilder callCryptoUriComponentsBuilder(){
    return UriComponentsBuilder.fromUriString(baseUrl)
                                      //.pathSegment(new String[]{"api/v3","coins/markets"})
                                      //.path("api/v3/")
                                      //.path("coins/markets")
                                      .pathSegment(serviceVers);
  }

  public String generateAPIPreviousClose(String coinId){
    return  callCryptoUriComponentsBuilder()
            .pathSegment(serviceUrlPreviousClose)
            .pathSegment("X:"+coinId+"USD") //tbc  "X:BTCUSD"  
            .path(serviceUrlPreviousClosePrev)
            .queryParam("ajusted", true)
            .queryParam("apiKey",key)
            .build().toString();
  }
}
