package com.example.callweatherservice.entity.elements;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cloud implements Serializable{
  Integer all;
  
}
