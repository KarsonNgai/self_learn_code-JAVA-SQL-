class Computer{
  private int number;
  private String name;

  private Computer(Builder builder){
    this.number=builder.number;
    this.name=builder.name;
  }

  public void setNumber(int newNumber){
      this.number=newNumber;
  }
  
  public void setName(String newName){
      this.name=newName;
  }

  public int getNumber(){
      return this.number;
  }
  public String getName(){
      return this.name;
  }

  public void printStatus(){
      System.out.println("Status:\n\tname:" +this.name + "\n\tnumber: "+this.number+"\n============");
  }

  public Builder builder(){
    return new Builder();
  }
  //builder class
  public static class Builder{
    private int number;
    private String name;

    public Builder assignNumber(int value){
      this.number=value;
      return this;
    }

    public Builder assignName(String value){
      this.name=value;
      return this;
    }

    public Computer build(){
      return new Computer(this);
    }
  }
}

//other user info, not gonna change very easily
enum AnotherUser{
  KARSON(11,"Karson"),
  PETER(28,"Peter"),
  JOHN(1,"John");

  int number=-1;
  String name="unknown";

  AnotherUser(int number, String name){
    this.number=number;
    this.name=name;
  }
  
}

public class BuilderPatternInComputerExample{
  public static void main(String[] arg){
      Computer myComp = new Computer.Builder() 
                      .assignNumber(AnotherUser.KARSON.number)
                      .assignName(AnotherUser.KARSON.name)
                      .build();
                
      myComp.printStatus();

      Computer peterComp = new Computer.Builder()
                      .assignNumber(AnotherUser.PETER.number)
                      .assignName(AnotherUser.PETER.name)
                      .build();
      peterComp.printStatus();

      Computer johnComp = new Computer.Builder()
                      .assignNumber(AnotherUser.JOHN.number)
                      .assignName(AnotherUser.JOHN.name)
                      .build();
      johnComp.printStatus();
  }
}
