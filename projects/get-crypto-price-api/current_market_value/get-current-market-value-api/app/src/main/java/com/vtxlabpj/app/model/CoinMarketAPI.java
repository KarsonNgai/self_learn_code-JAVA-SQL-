package com.vtxlabpj.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"id","symbol","name","image","current_price","market_cap","market_cap_rank",
"fully_diluted_valuation","total_volume","high_24h","low_24h","price_change_24h","price_change_percentage_24h","market_cap_change_24h",
"market_cap_change_percentage_24h","circulating_supply","total_supply","max_supply","ath","ath_change_percentage","ath_date","atl","atl_change_percentage",
"atl_date","roi","last_updated"})
//可以排先後,個string用咩就唔知
public class CoinMarketAPI {
  @JsonProperty(namespace = "id" , value = "id") 
  //可有可無,如果exactly一樣就唔洗
  //namespace,個response get番來時,會係咩名, 如果有namespace,下面variable可改名,display個名會係variable個名
  //value 指match完之後,個json個名改成咩名,如果有,就唔會用variable個名
  String id;

  @JsonProperty(namespace = "symbol", value = "symbol")
  String symbol;

  @JsonProperty(namespace = "name",value = "name")
  String name;

  @JsonProperty(namespace = "image", value = "image")
  String image; //url

  @JsonProperty(namespace = "current_price",value = "current_price")
  Double current_price;

  @JsonProperty(namespace = "market_cap", value = "market_cap")
  Long market_cap;

  @JsonProperty(namespace = "market_cap_rank", value = "market_cap_rank")
  Long market_cap_rank;

  @JsonProperty(namespace = "fully_diluted_valuation",value = "fully_diluted_valuation")
  Long fully_diluted_valuation;

  @JsonProperty(namespace = "total_volume",value = "total_volume")
  Long total_volume;

  @JsonProperty(namespace = "high_24h",value = "high_24h")
  Double high_24h;

  @JsonProperty(namespace = "low_24h",value = "low_24h")
  Double low_24h;

  @JsonProperty(namespace = "price_change_24h" ,value = "price_change_24h")
  Double price_change_24h;

  @JsonProperty(namespace = "price_change_percentage_24h", value = "price_change_percentage_24h")
  Double price_change_percentage_24h;

  @JsonProperty(namespace = "market_cap_change_24h", value = "market_cap_change_24h")
  Double market_cap_change_24h;

  @JsonProperty(namespace = "market_cap_change_percentage_24h", value = "market_cap_change_percentage_24h")
  Double market_cap_change_percentage_24h;

  @JsonProperty(namespace = "circulating_supply", value = "circulating_supply")
  Long circulating_supply;

  @JsonProperty(namespace = "total_supply", value = "total_supply")
  Long total_supply;

  @JsonProperty(namespace = "max_supply", value = "max_supply")
  Long max_supply;

  @JsonProperty
  Long ath;

  @JsonProperty(namespace = "ath_change_percentage", value = "ath_change_percentage")
  Double ath_change_percentage;

  @JsonProperty(namespace = "ath_date", value = "ath_date")
  String ath_date; //date "2021-11-10T14:24:11.849Z"

  @JsonProperty
  Double atl;

  @JsonProperty(namespace = "atl_change_percentage",value = "atl_change_percentage")
  Double atl_change_percentage;

  @JsonProperty(namespace = "atl_date",value = "atl_date")
  String atl_date; //date "2013-07-06T00:00:00.000Z"

  @JsonProperty
  String roi; // null 左

  @JsonProperty(namespace = "last_updated",value = "last_updated")
  String last_updated;

}
