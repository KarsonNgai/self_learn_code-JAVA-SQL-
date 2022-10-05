//Try to use interface
//require to override the method from super class
interface typeA{
  int fly();
}

class Bird implements typeA {
  @Override
  public int fly() {
    return 1;
  }

  public void life() {
    System.out.println("this is creature");
  }
}

class robotBird implements typeA{
  @Override
  public int fly() {
    return 100;
  }

  public void life() {
    System.out.println("this is artifact");
  }
}

class Animal{
  public void execute() {
    typeA x = new Bird();
    typeA y = new robotBird();
    int number = x.fly();
    int number2 = y.fly();
    new Animal().runThis(number,number2);
    ObjIn(x);
    ObjIn(y);
  }

  public void runThis (int value1, int value2) {
    System.out.println(value1+value2);
  }

  public void ObjIn(typeA obj) {
    System.out.println("here I want");
    System.out.println(obj.fly());
    //typeA lifing = obj;
  }
}

public class TryForInterface{
  public static void main(String[] arg) {
    new Animal().execute();
  }
}
