//demo to custome a simple exception

public class CustomException extends RuntimeException{
  CustomException(String msg){
    super(msg);
  }
}
