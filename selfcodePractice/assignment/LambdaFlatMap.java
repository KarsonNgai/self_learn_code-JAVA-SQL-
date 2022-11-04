import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Exercise: Deal with common data structures, using stream flatmap() to restructure the data
 */
/**
 * Expected Output:
 * Writer: Susan
 * Writer: Tracy
 * Book Name: Book A, Book Price: 34.9
 * Book Name: Book B, Book Price: 78.9
 * Book Name: Book C, Book Price: 104.9
 * Book Name: Book D, Book Price: 449.9
 * The Most Expensive Book: Name=Book D, Price=449.9
 */
// Implement Book class
// Code here ...

// Implement Wrtier Class
// Code here ...

// Implement a Comparator to compare the book price
// Code here ...
class Book{
    String name;
    double price;

    Book(double price,String name){
        this.price = price;
        this.name = name;
    }
}

class Writer{
    String author;
    List<Book> books;
    Writer(String author,List<Book> books){
        this.author=author;
        this.books=books;
    }
}

public class LambdaFlatMap {
    public static void main(String[] args) {
        // Create Books1 and Writer1
        List<Book> books1 = Arrays.asList(new Book(34.9, "Book A"), new Book(78.9, "Book B"));
        Writer w1 = new Writer("Susan", books1);

        // Create Books2 and Writer2
        List<Book> books2 = Arrays.asList(new Book(104.9, "Book C"), new Book(449.9, "Book D"));

        System.out.println(books1); //only show reference
        // List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3));
        // integers.add(2);
        // System.out.println(integers);

        Writer w2 = new Writer("Tracy", books2);

        List<Writer> writers = Arrays.asList(w1, w2);
        // Print all Writers names
        writers.stream().forEach(e->System.out.println(e.author));

        // Use flatMap method to return all books written by our writers, storing in a
        // List<Book>
        // Just return the Books!
        List<Book> allBook = writers.stream().flatMap(e->e.books.stream()).collect(Collectors.toList());

        // Print out all books' Name and Price.
        allBook.stream().forEach(e->System.out.println("Book name: "+e.name+"Book price: "+e.price));


        // Create Comparator for stream max() method use, aims to find the most
        // expensive book
        Book maxPriceBook = allBook.stream().max((x,y)->Double.compare(x.price, y.price)).get();

        // Print out the most expensive book
        System.out.println("Name:" + maxPriceBook.name + ", Price:" + maxPriceBook.price);
    }
}
