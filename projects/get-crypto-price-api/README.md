Project:
A simple project that call the third party api and send it to frontend.
> current_market_value


Project
It target to call the third party api with flexable that we decide who to call
1.frontend  
2.channel()   
3.api that connect the database(with jpa)  
4.call third party api(we can decide the flow)    

        
URL:    
-channel_for_manage_call  
> url:localhost:8087/crypto/admin/api/v1
  
-coat_coin_index  
mapping coin: 
> url: localhost:8083/crypto/coincode/api/v1 
> CRUD:tbc  
> coin_info: getInfo(DTO)  
    
-current_exchange_rate  
coingecko:  
> url: localhost:8085/crypto/coingecko/api/v1  
> simple_price/list: to channel(contract V)  

polygon:   
> url: localhost:8086/crypto/polygon/api/v1  
> previous_back/list: to channel(contract V)  
    
---  
*third party url, construct within yml

