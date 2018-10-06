import java.lang.*;
import java.util.*;

public class HelloWorld{

     public static void main(String []args){
        System.out.println("Hello World");
        
        ArrayList<Integer> fib = new ArrayList();
        fib.add(0);
        fib.add(1);
        int lmt = 13;
        while(true)
        {
            fib.add(fib.get(fib.size()-1) + fib.get(fib.size()-2));
            if(fib.get(fib.size()-1) >= lmt){
                System.out.print(fib);
                return;
            }
        }
        
     }
}

/**
** Python solution:
** ----------------
**
** def fibonaci():
** ls = [0,1]
** lmt=13
** while(True):
**   ls.append(ls[len(ls)-1] + ls[len(ls)-2])
**   if(ls[len(ls)-1] >= lmt):
**     print(ls)
**     break

** if '__main__' == __name__:
**  fibonaci()
**  
*/
