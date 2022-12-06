package com.example.callweatherservice.entity.elements;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rain implements Serializable{
  @JsonProperty(value = "1h")
  Integer oneHour;

  @JsonProperty(value = "3h")
  Integer threeHour;
}
