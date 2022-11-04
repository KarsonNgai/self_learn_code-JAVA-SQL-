import java.util.ArrayList;
/*output:
Print all Elements in ArrayList integers:
10
14
Duplicate the Even number from ArrayList
[ 10, 13, 14, 29, 10, 14 ]
Print the Odd Numbers from the new ArrayList
[ 11, 13, 15, 29 ]
 */

 //#Exercise 34
public class LamdbaTry {
    private static boolean isNegative = false;
    private static boolean isEven = false;
    private static int sizeCounter=0;

    private static int checkNegativeAndEven(int e){
            isNegative=false; 
            isEven=true;                           
            if(e<0){//negative cannot be module
                e=e*-1;
                isNegative=true;
            }
            if(e%2!=0)isEven=false;
            return e;
    }

    private static void addValueToArray_EvenPlueOne(int value, ArrayList<Integer> arrayList){
        if(isEven)value+=1;
        if(isNegative)value*=-1;
        arrayList.add(value);
    }
    
    private static void duplicateEvenNumber(int value, ArrayList<Integer> arrayList){
        if(isEven){
            if(isNegative)value*=-1;
            arrayList.add(value);
        }
    }
    
    private static void printArray(ArrayList<Integer> arrayList) throws NullPointerException{ //not ready for null, cause self use,ensure it must be notnull
        sizeCounter = arrayList.size();
        if (sizeCounter==0){
            System.out.println("[]");
            return;
        }
        
        System.out.print("[ ");
        arrayList.forEach(e->{
            if(sizeCounter==1){
                System.out.print(e+" ");
            }else{
                System.out.print(e+", ");
            }
            sizeCounter--;
        });
        System.out.println("]");
    }
    
    public static void main(String args[]) {
        // Creating an ArrayList with elements
        // {1, 2, 3, 4}
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(10);
        integers.add(13);
        integers.add(14);
        integers.add(29);
        
        ArrayList<Integer> integersDuplicateEven = new ArrayList<>(integers);
        ArrayList<Integer> integersEvenPlusOne = new ArrayList<>();
        
        // Using lambda expression to invoke forEach() method to print all elements in ArrayList integers
        System.out.println("Print all Elements in ArrayList integers:");

        // Using lambda expression to invoke forEach() method
        integers.forEach(e->{
            int tempInt=checkNegativeAndEven(e);
            // Print Odd Number in the ArrayList integers
            if(isEven)System.out.println(e);
            // For example, [2, 3, 4] -> [2, 3, 4, 3, 5], because 2 and 4 are even numbers, 3=2+1, 5=4+1.
            // Thus, we add 3 and 5 to the arraylist.
            addValueToArray_EvenPlueOne(tempInt, integersEvenPlusOne);
            duplicateEvenNumber(tempInt, integersDuplicateEven);
        });
        //finish both within the one off lamdba to void multiple loop
        
        System.out.println("Duplicate the Even number from ArrayList:");
        printArray(integersDuplicateEven);
        System.out.println("Print the Odd Numbers from the new ArrayList:");
        printArray(integersEvenPlusOne);
        
    }
}
