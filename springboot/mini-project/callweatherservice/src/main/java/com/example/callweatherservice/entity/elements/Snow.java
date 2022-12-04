package com.example.callweatherservice.entity.elements;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//有寫但唔JSON有, 應該冇左,北極都唔見有
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Snow {

  @JsonProperty(value = "3h")
  Integer oneHour;

  @JsonProperty(value = "3h")
  Integer threeHour;
}
