//factory pattern?
public class ClassA {
  //can rename, cause I cannot use Class to name it, it may look very confuse when calling it. So I name it as ClassA, but it may seems bad.
  public static final String startDate = "26-Sep-2022";
  private String tutor = "Vincent";
  private static ClassSection section; //interface 

  ClassA(String wantedSection){
    //String regex = "//[a||A]//";
    switch (wantedSection){
      case "A":
      case "Section A":
        ClassA.section=new ClassASection();
        break;
      case "B":
        break;
      default:
        System.out.println("not found");
    }
  }

  ClassSection getSection(){
    return ClassA.section;
  }

  public String getTutor(){
    return this.tutor;
  }

  public void setTutor(String value){
    this.tutor = value;
  }

}
//factory?
public class ClassA {
  public static final String startDate = "26-Sep-2022";
  private String tutor = "Vincent";
  private static ClassSection section; //interface 

  ClassA(String wantedSection){
    //String regex = "//[a||A]//";
    switch (wantedSection){
      case "A":
      case "Section A":
        ClassA.section=new ClassASection();
        break;
      case "B":
        break;
      default:
        System.out.println("not found");
    }
  }

  ClassSection getSection(){
    return ClassA.section;
  }

  public String getTutor(){
    return this.tutor;
  }

  public void setTutor(String value){
    this.tutor = value;
  }

}
