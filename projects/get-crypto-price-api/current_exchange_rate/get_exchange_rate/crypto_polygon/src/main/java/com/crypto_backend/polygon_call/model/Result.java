package com.crypto_backend.polygon_call.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result{
  @JsonProperty
  //The exchange symbol that this item is traded under.
  String T;
  //tbc: display有問題

  @JsonProperty
  //The trading volume of the symbol in the given time period.
  Double v;

  @JsonProperty
  //The volume weighted average price.
  Double vw;

  @JsonProperty
  //The open price for the symbol in the given time period.
  Double o;

  @JsonProperty
  //The close price for the symbol in the given time period.
  Double c;

  @JsonProperty
  //The highest price for the symbol in the given time period.
  Long h;

  @JsonProperty
  //The lowest price for the symbol in the given time period.
  Double l;
  
  @JsonProperty
  //The Unix Msec timestamp for the start of the aggregate window.
  Long t;
  
  @JsonProperty
  //The number of transactions in the aggregate window.
  Long n;


}
