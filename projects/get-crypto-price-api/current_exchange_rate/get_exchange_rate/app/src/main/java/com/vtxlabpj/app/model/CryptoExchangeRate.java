package com.vtxlabpj.app.model;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CryptoExchangeRate {
  @JsonProperty
  String name;

  @JsonProperty
  String unit;

  @JsonProperty
  BigDecimal value;

  @JsonProperty
  String type;
}
