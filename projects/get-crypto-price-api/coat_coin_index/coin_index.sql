CREATE SCHEMA `project1_db` ;

-- crypto
-- this is the coin table
-- include: id and crypto id name from another company

-- CREATE SCHEMA `project1_db` ;
use project1_db;

create table channels(
	-- third party info, which channel we want to call (select which company)
	id int not null auto_increment,
    channel_code varchar(30), -- can be better as int, this can be the foreign key in a table with the api provider info
    channel_url varchar(100),
    last_updDate datetime default(now()),
    primary key(id)
);

insert into channels (channel_code,channel_url) values
	('CoinGecko','localhost:8085/crypto/coingecko'),
    ('Polygon','localhostL8086/crypto/polygon');

create table channel_transaction( 
	-- method third party api info, the way we want to use for (select which method/way)
	id int not null auto_increment,
    channel_id int not null,
    domain_version varchar(50),
    domain_url	varchar(70),
    source_app varchar(70),
    tran_type varchar(70),
    tran_status varchar(2),
    primary key(id),
    foreign key(channel_id) references channels(id)
);

insert into channel_transaction(channel_id,domain_version,domain_url,source_app,tran_type,tran_status)
values
	(1,'api/v1','simple-price','crypto-web','exchange rate between crypto and currency(usd)','A'),
	(1,'api/v1','exchange-rate','crypto-web','exchange rate between crypto and currencies(unclear)','N'),
    (2,'api/v1','simple-price','crypto-web','exchange rate between crypto and currency(usd)','A'),
    (1,'api/v1','market-price','crypto-web','show the market price of the crypto','N');

create table coin_mapping(
	id int auto_increment not null,
    channel_id int not null,
    coin_code varchar(30), 
    coin_id varchar(30), -- could be better, for instance: create a table to describe the coin, then it can be number and foreign key
    coin_status varchar(2),
    primary key(id),
    foreign key(channel_id) references channels(id)
);

insert into coin_mapping(channel_id, coin_code,coin_id,coin_status) values
	(1,'bitcoin','BTC','A'),
    (1,'ethereum','ETH','A'),
    (1,'tether','USDT','A'),
    (1,'dogecoin','DOGE','A'),
    (1,'ripple','XRP','A'),
    (2,'X:BTCUSD','BTC','A'),
    (2,'X:ETHUSD','ETH','A'),
    (2,'X:USDTUSD','USDT','A'),
    (2,'X:DOGEUSD','DOGE','A'),
    (2,'X:XRPUSD','XRPBTC','A');
    select * from coin_mapping;
/*
drop table coin_mapping;
drop table channels_transaction;
drop table channels;
*/
