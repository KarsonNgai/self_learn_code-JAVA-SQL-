#simple controller-service-repository  
-forumpost  
-bookstore  

#more on JOIN TABLE  
#@OneToMany, @ManyToMany, @JSONIGNORE  
-shop_testdb  

#more on how to call another api  
#beside using the html and call, we use restTemple.read(url, class_name.class), deserialize  
#redis  
-callweatherservice  

#try to request in html form(as a normal user), type the word in the search bar and press search button, then we get the result  
#@many-to-many, @many-to-one 
-lib-search   
book_info is a table that describe the many to many relationship between book and author- there one book can be written by many author, an anthor also can write many book.  
--note:  
@many-to-many use to link the table, there should be define one as owner and one should be inverse side(which will be mapped by owner)  
!!!@jsonIgnore is a must in book and author  
@many-to-one in book_info refer that we can use bookInfoRepository to get the data from both side, since I want to have a access to read the whole table,   @jsonignore did not add in book_info  
:html-map:  
  |home->book list-> get all the book book with id  
       ->typy the book name and click search->result found, get the info of book->back to home  
                                            ->result not found message->back to home  
