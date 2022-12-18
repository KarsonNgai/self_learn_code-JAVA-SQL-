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

  //api
  @Value("${API.Crypto.serviceUrl.coins_markets}")
  private String serviceUrlCoinMarkets;

  @Value("${API.Crypto.serviceUrl.exchange_rates}")
  private String serviceUrlExchangeRates;

  @Value("${API.Crypto.serviceUrl.simple_price}")
  private String serviceUrlSimplePrice;

  /**
   * the url must be contructed in this method, it is the baseUrl and serviceVers.
   * @return
   */
  private UriComponentsBuilder callCryptoUriComponentsBuilder(){
    return UriComponentsBuilder.fromOriginHeader(baseUrl)
                                      //.pathSegment(new String[]{"api/v3","coins/markets"})
                                      //.path("api/v3/")
                                      //.path("coins/markets")
                                      .pathSegment(serviceVers);
  }

  /**
   * Coin/Market key.
   * @param coinId String of coin id, empty refer all.
   * @param currency String contain currency, default and suppose to "usd".
   * @return
   */
  public String generateAPICoinMarkets(String coinId, String currency){
    return  callCryptoUriComponentsBuilder()
            .path(serviceUrlCoinMarkets)
            .queryParam("vs_currency", currency)
            .queryParam("ids", coinId)
            .queryParam("order","market_cap_desc")
            .queryParam("per_page", 100)
            .queryParam("page", 1)
            .queryParam("sparkline", false)
            .build().toString();
  
  }

  /**
   * exhange rate key.
   * @return
   */
  public String generateAPIExchangeRate(){
    return callCryptoUriComponentsBuilder()
          .path(serviceUrlExchangeRates)
          .build().toString();
  }

  /**
   * simple/price key.
   * @param ids String contain list of coinIds which seperate in ',' .
   * @param currencies String contain list of currency which seperate in ',' .
   * @return
   */
  public String generateAPISimplePrice(String ids, String currencies){
    return callCryptoUriComponentsBuilder()
          .path(serviceUrlSimplePrice)
          .queryParam("ids", ids)
          .queryParam("vs_currencies", currencies)
          .build().toString();
  }
}
