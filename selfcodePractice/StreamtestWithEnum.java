//for study: not useful
//looping the stream to find exact value, using find first to get the value that we want
//logic: make enum to be stream with ->> Arrays.stream(Enum.value)
//       filer out the mismatch word, still have a chance that there contain a bound of values in the stream, (that why using stream to find one value is worse)
//       we only seek for first element. Use findFirst method

import java.util.Arrays;

enum OrderStatus {
    FIRST(1),SECOND(2),UNKNOWN(0);

    int index;

    OrderStatus(int index){
      this.index = index;
    }
}

public class StreamtestWithEnum {

  public static OrderStatus fromCode1(int index){
    for(OrderStatus i : OrderStatus.values()){
      if (i.index == index){
        return i;
      }
    }
    return OrderStatus.UNKNOWN;
  }
  
  public static OrderStatus fromCode2(int index){
    return Arrays.stream(OrderStatus.values())
                  .filter(e -> e.index == index)
                  .findFirst().orElse(OrderStatus.UNKNOWN);
  }
  public static void main(String[] args) {
    
    System.out.println(fromCode1(1));
    System.out.println(fromCode2(1));//same code, different style
  }
}
