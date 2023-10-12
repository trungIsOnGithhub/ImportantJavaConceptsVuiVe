import java.util.List;
import java.util.ArrayList;

import java.util.Optional;

/ * optional - forEach, Lambda

public static void main(String[] args) { 
    String[] str = new String[10]; 
    Optional<String>checkNull = Optional.ofNullable(str[5]); 

    if (checkNull.isPresent()) { 
        String word = str[5].toLowerCase(); 
        System.out.print(str); 
     } else
       System.out.println("string is null"); 
} 

interface Java8Interface {
     default void demethod(){
         System.out.println("I am the default method of interface");
    }
}

class Derived implements Java8Interface {
 
}

public class MyClass {
    public static void main(String args[]) {
        int[] arr = { 1,2,3,4,5,6,7,8,9 };
        
        List<Integer> list = new ArrayList<>();
        
        for(var num : arr) {
            list.add(num);
        }
        
       list.forEach( (num) -> {
            System.out.println("|" + num + "|");
        });
        
        derived_obj1 = new derived_class();
        obj1.method();
    }
}
