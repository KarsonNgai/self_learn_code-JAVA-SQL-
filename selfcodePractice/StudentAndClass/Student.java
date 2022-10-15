import java.util.HashMap;

public class Student {
  HashMap<String,String> dicts = new HashMap<>();

  Student(String firstname, String lastName){
    dicts.put(firstname, lastName);
  }
}
