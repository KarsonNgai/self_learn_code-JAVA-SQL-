//guide: build a class with private attribute, public getter and setter

//generic
class PrintSomething<T>{ 
  T printedWord;

  public PrintSomething(T thing){
    this.printedWord=thing;
  }
  public void printThing(){
      System.out.println(printedWord);
  }
}

//computer class
class Computer{
//attribute
  private int number;
  private String name;

//empty constructor
  public Computer(){};

//method/ behavior
//setter
  public void setNumber(int newNumber){
      this.number=newNumber;
  }
  
  public void setName(String newName){
      this.name=newName;
  }

//getter
  public int getNumber(){
      return this.number;
  }
  public String getName(){
      return this.name;
  }

//
    public void printStatus(){
        System.out.println("Status:\n\tname:" +this.name + "\n\tnumber: "+this.number+"\n============");
    }
}


public class ClassMethodConstructor {
//MAIN 
  public static void main(String[] arg){
      Computer myComp = new Computer(); //create new instance
      //run method/behavior
      myComp.setNumber(11); 
      myComp.setName("Computer"); 
      myComp.printStatus();

      //print with method/behavior
      System.out.println(myComp.getNumber());
      System.out.println(myComp.getName());

      //two way to call the generic class and use it method, different is instance or not.
      PrintSomething<String>x = new PrintSomething<>("Hello World");
      x.printThing();
      new PrintSomething<String>("Hello again").printThing();
  }
}
