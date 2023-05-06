// Chec
import java.io.FileReader;
import java.io.FileNotFoundException;

public class MyClass {
    // Checked Exception ~ Compile Time Exception ~ throw by definition
    private static FileReader getFileReader(String fileName) throws Exception { // Have to catch generic Exception finally after Specific type if we specify this
        FileReader fr = new FileReader(fileName);
        return fr;
    }

    // Unchecked Exception ~ Runtime Exception ~ NullPointerException, ArithmeticException, NumberFormatExeption....
    private static void printStringLength(String str) {
        System.out.println(str.length());
    }

    public static void main(String args[]) {
      //Have to catch Checked Exception to be compiled
      try {
        getFileReader("12345.txt");
      } catch(FileNotFoundException fnfe) {
          System.out.println("fnfe");
      } catch(Exception e) {
          System.out.println("e");
      }
      
      //Have to catch Unchecked Exception to run
      printStringLength(null);  // Execption Thrown
    }
}
