class AccessThis<T>{
  private T selfWord;
  AccessThis (T anotherValue) {
    this.selfWord=anotherValue;
  }
  public T getWord() { 
    //<<<<<<
    return this.selfWord;
  }

  public static <T> void printThis (T value) {
    System.out.print(value);
  }

}

public class TryGenericClass {
  public static void main (String[] arg) {
    AccessThis<String> x = new AccessThis<>("Peter");
    //x.printThis("ERE");
    String myName=x.getWord();
    System.out.print(myName);
  }
}


