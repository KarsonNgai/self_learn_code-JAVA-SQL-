//Extends inheritance the super class, the only use of super would be apply in constructor.
//the different between super() and new ParentClass would be if we want to create a instance or not

class Country {
  String name;

  void setCountryName (String name){
    this.name=name;
  }
}

class SuperClass extends Country {
  //String name;

  String getName(){
    return super.name;
  }

  public static void main(String[] args) {
     SuperClass c=new SuperClass();
     c.setCountryName("New Place");
     System.out.println(c.name);
     System.out.println(c.getName());
     }
}
