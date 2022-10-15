#Java
#Using to interface and abstract class to make the future extension more easier
#Student and Class relation

Student.java:
  HashMap<firstName[String], LastName,[String]>


ClassSection.java [abstract class]:
  private:
    studentArrs [ArrayList<Student>] 
    food [String]
    isBoy [Boolean]
  public:
    getter
    setter
-may contain different Class in future


ClassASection.java: (extends ClassSection):
  represent one object (may have one more Class)


ClassWhich.java: (interface) <<<< no use >>>>
  decideWhichClass(void)


ClassA.java: (***)
  kind of the factory pattern
  fixed startDate[String] (there may have a lot of class in start from that day)
  getTutor[String]
    

VtxClass: (extends ClassA)
  reduce the chance of modify the code
  -prepare for the future expension, there may not only have one class forever

Tool.java:
  create a object that can contain the group of student throught providing the Group Code
  before using it, require to add the group code [String]
  only contain three function
    
    1. add the student (first_name and last_name) both are [String]
    2. print the all student who in this class information(size of the array, first_name and last_name)
    3. get the ArrayList<Student>

Main.java:
  Main function, test the code here
