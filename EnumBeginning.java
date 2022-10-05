enum Color {
  RED(10),
  GREEN(20),
  BLUE(30);

  int price;
  Color (int value) {
    this.price = value;
  }
}

public class Test {
  static Color chooseColor(int value) {
    if (value == 1){
      return Color.RED;
    } else {
      return Color.BLUE;
    }
  }
  public static void main(String[] args)
  {
    Color myColor = Test.chooseColor(1);
    System.out.println(myColor);
    System.out.println(myColor.price);
  }
}
