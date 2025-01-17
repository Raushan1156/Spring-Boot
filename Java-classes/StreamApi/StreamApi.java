import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

public class StreamApi{
    public static void main(String[] args){
        System.out.println("Hello World");

        List<Integer> list2= List.of(1,2,3,4,5,6,7,8,9,10);
        Stream<Integer> stream2 = list2.stream();
        List<Integer> evenNumbers = stream2.filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println(list2);
        
        // Create a new stream for the forEach operation
//        list2.stream().forEach(System.out::println);
        System.out.println(list2.getClass());
        
        System.out.println(evenNumbers);
    }
}