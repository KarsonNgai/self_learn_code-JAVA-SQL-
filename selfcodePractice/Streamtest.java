//Stream
//sorted is a very mystery method, I cannot find which class implement this method, but when used, it apply array sort (when use array), guess it is collection sort.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streamtest {

  public static void printList(List<String> list){    
    for(String i:list){
      System.out.print(i+" ");
    }
  }
  public static void main(String[] args) {
    List<String> names = new ArrayList<>();
    names.add("123Peter");
    names.add("Carl");
    names.add("Benny");
    names.add("Alex");
    System.out.println(names);
    printList(names);

    List<Integer> values = new ArrayList<>(Arrays.asList(1,2,3));
    values.add(0);

    Predicate<String> p1 = (e)-> Pattern.matches("^[a-zA-Z].*", e);
    Predicate<String> p2 = (e)-> e.length()<20;

    Function<String,String> returnSelf=(e)->e.toUpperCase()+":";

    List<String> filterName = names.stream()
                              .map(returnSelf)
                              .filter(p1.and(p2))
                              .sorted()
                              .collect(Collectors.toList());

    System.out.println(filterName);

    System.out.println("=================");

    long streamCount = Stream.of(1,2,3).map(i->{
      System.out.println(i);
      return i;
    }).count();
    
    System.out.println("here is the count:" +streamCount);

  }
}
