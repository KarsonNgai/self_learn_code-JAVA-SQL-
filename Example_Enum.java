/**
 * author:THINK
 * version: 2018/7/16.
 */
enum Color {

    RED(0,"紅色"),
    BLUE(1,"藍色"),
    GREEN(2,"綠色"),

    ;

//    可以看出这在枚举类型里定义变量和方法和在普通类里面定义方法和变量没有什么区别。唯一要注意的只是变量和方法定义必须放在所有枚举值定义的后面，否则编译器会给出一个错误。
    private int code;
    private String desc;

    Color(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 自己定义一个静态方法,通过code返回枚举常量对象
     * @param code
     * @return
     */
    public static Color getValue(int WantedCode){

        for (Color  color: values()) {
            if(color.getCode() == WantedCode){
                System.out.println("code number: "+color.code);
                return  color;
            }
        }
        return null;

    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}


/**
 * author:THINK
 * version: 2018/7/16.
 */
public class Example_Enum {
    public static void main(String[] args){
        /**
         * 测试枚举的values()
         *
         */
        String s = Color.getValue(0).getDesc();
        System.out.println("獲取的值為:"+ s);



        /**
         * 测试枚举的valueof,里面的值可以是自己定义的枚举常量的名称
         * 其中valueOf方法会把一个String类型的名称转变成枚举项，也就是在枚举项中查找字面值和该参数相等的枚举项。
         */

        Color color =Color.valueOf("GREEN");
        System.out.println(color.getDesc());
        System.out.println(Color.GREEN);
        System.out.println(Color.valueOf("GREEN").getDesc());
        /**
         * 测试枚举的toString()方法
         */

        Color s2 = Color.getValue(0) ;
        System.out.println("獲取的值為:"+ s2.toString());

    }
}

