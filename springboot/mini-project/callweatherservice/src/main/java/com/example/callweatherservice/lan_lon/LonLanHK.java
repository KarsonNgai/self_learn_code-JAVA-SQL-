package com.example.callweatherservice.lan_lon;

//HK lan lon code for suggestion
public enum LonLanHK {
  //https://www.mtr.com.hk/en/customer/services/system_map.html
  TiuKengLeng("Tiu Keng Leng","調景嶺",114.1,22.55),
  YauTong("Yau Tong","油塘",22.29569,114.23599);
  //Lam Tin
  //Kwun Tong
  

  String engName;
  String chineseName;
  Double longitude; //經度
  Double latitude; //緯度


  LonLanHK(String engName, String chineseName, Double longitude, Double latitude){
    this.engName = engName;
    this.chineseName = chineseName;
    this.longitude = longitude;
    this.latitude = latitude;
  }
}
