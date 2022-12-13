package com.vtxlabpj.app.api_utility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class API_URI {
  @Value("${API.Crypto.baseUrl}")
  private String baseUrl;

  @Value("${API.Crypto.serviceVers}")
  private String serviceVers;

  @Value("${API.Crypto.serviceUrl}")
  private String serviceUrl;

  private UriComponentsBuilder callCryptoUriComponentsBuilder(){
    return UriComponentsBuilder.fromOriginHeader(baseUrl)
                                      //.pathSegment(new String[]{"api/v3","coins/markets"})
                                      //.path("api/v3/")
                                      //.path("coins/markets")
                                      .pathSegment(serviceVers);
  }

  public String generateAPI(String coinId, String currency){

    return  callCryptoUriComponentsBuilder()
            .path(serviceUrl)
            .queryParam("vs_currency", currency)
            .queryParam("ids", coinId)
            .queryParam("order","market_cap_desc")
            .queryParam("per_page", 100)
            .queryParam("page", 1)
            .queryParam("sparkline", false)
            .build().toString();
  
  }
}
