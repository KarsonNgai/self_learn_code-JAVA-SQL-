//when object as the input as parameter, the change would directly change the to adress instead of just local value, hence, the instance would be modified
class NewNumber {
  public int value;
  public NewNumber(int value){
    this.value=value;
  }
  public int getNumber(){
    return this.value;
  }
}

public class MethodParameter { 
  public static void main(String[] arg){
    NewNumber x = new NewNumber(1);
    doSomething(x); 
    System.out.println("Here is the new value: "+x.getNumber()); //output is 3
  }
  public static void doSomething(NewNumber num){
    num.value=3;
  }
}
