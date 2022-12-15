since api may not have the same coin in index,which we use them as parm to in url, we may need a space to store the index
also, we(or company itselves) may also have their own index as well, there we would have another api to get the coin index so as to prepare to construct third party api

mysql:
  store coin index

api:
  get coin index(company version) and provide the coin index(third party version)
