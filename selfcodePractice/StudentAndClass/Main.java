//for testing
import java.util.ArrayList;

public class Main {
  public static void main(String[] arg){
    Tool.createClass("A");

    //create student instance
    Tool.studentJoin("Peter", "Wong");
    Tool.studentJoin("John", "Yu");
    Tool.studentJoin("Ken", "Ng");
    
  
    Tool.printDict();
    
    //create List
    ArrayList<Student> arr = Tool.classList();
  }
}
