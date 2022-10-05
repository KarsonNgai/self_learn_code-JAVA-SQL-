public class GenericInMethodOnly {
  public static <T> void printing (T value){
    System.out.println(value);
  }
  public static void main(String[] arg) {
    printing("John");
    printing(123);
    printing(true);
  } 
}
