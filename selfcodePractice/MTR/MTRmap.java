enum MTRmap{
  TUNGCHUNG(0,"Tung Chung",'A'),
  SUNNYBAY(1,"Sunny Bay",'B'),
  TSINGYI(2,"Tsing Yi",'C'),
  LAIKING(3,"Lai King",'D'),
  NAMCHEONG(4,"Nam Cheong",'E'),
  OLYMPIC(5,"Olympic",'F'),
  KOWLOON(6,"Kowloon",'G'),
  HONGKONG(7,"Hong Kong",'H'),
  MEIFOO(8,"Mei Foo",'I'),
  CHEUNGSHAWAN(9,"Cheun Sha Wan",'J');

  int index;
  String name;
  char shortname;

  MTRmap(int index,String name,char shortname){
    this.index=index;
    this.name=name;
    this.shortname=shortname;
  }

  public static void printAll(){
    for (MTRmap i: MTRmap.values()){
      System.out.println("index: "+i.index+" station name: " + i.name+" shortname: " + i.shortname);
    }
  }
}
