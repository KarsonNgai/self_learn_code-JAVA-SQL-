//Test case for interface

//Sum: interface do not have diamond problem, override would solve the problem, the method would be applied the near one.
//in interface, ignore the requirement of abstract

interface First {
  static int index = 10; // diamond question: since both second and third contain same static method, no conflict
}

interface Second extends First{
  void run(); //abstract method
}

interface Third extends First{
  void run();
  //diamond question, same method with interface Second

  static void swim(){ //static method
    System.out.println("Just swim");
  }
}

interface inThis extends Second, Third {
  int NonStaticInt = 100; //const 
}

class InterfaceNotes implements inThis{
  @Override //diamond question: Since Java trace the last interpreted method, overriding the method with same number would avoid the exception
  public void run(){
      System.out.println("running");
  }

  public static void main(String[] arg){
    //static
    System.out.println(Demo.index);
    Third.swim();

    //instance
    new Demo().run();
    System.out.println(new Demo().NonStaticInt);
  }
}
