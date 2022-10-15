import java.util.ArrayList;

public class Tool{
  //no constuctor//All static 
  static VtxClass vtxClass; 


  //this is ClassA
  public static void studentJoin(String first, String last){
    insertStudentInClass(new Student(first, last));
  }

  public static void createClass(String classCode){
    Tool.vtxClass = new VtxClass(classCode);
  }

  private static void insertStudentInClass(Student studentNotYetAdd){
    Tool.vtxClass.getSection().getStudentArrs().add(studentNotYetAdd);

    //ClassASection newClass = (ClassASection) classA.section;  //if we do not use super in ClassASection, we need to down casting the instance
    //System.out.println(classA.section.getFood());//food
    //classA.section.studentArrs.add(studentA); //in Tool
  }
  public static void printDict(){
    for (Student i : Tool.classList()){
      System.out.println(i.dicts);
    }
    System.out.println(Tool.classList().size());
  }

  public static ArrayList<Student> classList(){
    return Tool.vtxClass.getSection().getStudentArrs();
  }
}
