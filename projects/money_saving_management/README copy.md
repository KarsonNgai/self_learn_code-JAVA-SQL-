<h3>database:</h3>  

>design  
>create table  
>insert fake data for function test
>money_management.sql

<h3>API:</h3>  

design and code  

<h4>POST</h4>

>insert record  
>1. create type
>2. base on type, create category 
>3. base on category, create transaction (instance)

<h4>GET</h4>  

read record...  
>ALL  
>by year  
>by month  
---note---  
may show the sum  


<h4>PATCH/PUT</h4>

>update status by id  
>check if the data exist->insert the transaction-> update status (delete in client side)  


<h4>delete:</h4>

>update status by id  
>check if the data exist-> update status (delete in client side)    

<h3>more function:</h3>

-call exchange api and change it to target currency  
-using redis for caching to as the saving is relativly stable within a day (redis call on every single morning)  
-or using a observer to notice there is a change and call redis to get data (upgrade, redis call when notice there is a change in db)  
-make this app on cloud  
-frontend(web) : expect using react  
-mobile(ISO)  

