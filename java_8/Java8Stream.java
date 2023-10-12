import java.util.*;
import java.util.stream.*;


public class MyClass {
    public static void main(String args[]) {
        List<String> lstr = Arrays.asList("this", "is", "stream", "a", "example");
        
        String reducedIntoString = lstr.stream().reduce("/", String::concat);
        Set<String> collectToTreeSet = lstr.stream().collect(Collectors.toCollection(TreeSet::new));
        String collectIntoString = lstr.stream().map((str) -> str + ">>").collect(Collectors.joining("--"));
        
        System.out.println(collectIntoString);
    }
}
