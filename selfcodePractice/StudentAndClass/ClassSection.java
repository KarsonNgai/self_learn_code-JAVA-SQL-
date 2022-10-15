import java.util.ArrayList;

public abstract class ClassSection {
  private ArrayList<Student> studentArrs = new ArrayList<>();
  private String food;
  private Boolean isBoy;

  public void setFood(String food){
    this.food=food;
  }

  public void setIsBoy(Boolean isBoy){
    this.isBoy = isBoy;
  }

  public String getFood(){
    return this.food;
  }
  public Boolean getIsBoy(){
    return this.isBoy;
  }

  public void setStudentArrs(Student student){
    this.studentArrs.add(student);
  }

  public ArrayList<Student> getStudentArrs(){
    return this.studentArrs;
  }
}
