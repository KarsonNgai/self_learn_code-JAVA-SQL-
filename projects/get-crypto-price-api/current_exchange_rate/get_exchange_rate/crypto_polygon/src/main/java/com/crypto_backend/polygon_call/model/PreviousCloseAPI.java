package com.crypto_backend.polygon_call.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PreviousCloseAPI {

  @JsonProperty
  String ticker;

  @JsonProperty
  Long queryCount;

  @JsonProperty
  Long resultsCount;
  

  @JsonProperty
  Boolean adjusted;

  @JsonProperty
  List<Result> results;
  
  @JsonProperty
  String status;

  @JsonProperty
  String request_id;

  @JsonProperty
  Long count;

  
}