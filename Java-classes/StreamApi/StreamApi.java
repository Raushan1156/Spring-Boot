import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;

public class StreamApi{
    public static void main(String[] args){
        System.out.println("Hello World");

        List<Integer> list2= List.of(1,2,3,4,5,6,7,8,9,10);

        // Sequential stream() is used for small data set with maintained order and single thread.
        Stream<Integer> stream2 = list2.stream();
        List<Integer> evenNumbers = stream2.filter(i -> i % 2 == 0).collect(Collectors.toList());
        //System.out.println(list2);
        list2.stream().forEach(System.out::println);
        //System.out.println(list2.getClass());
        
        //System.out.println(evenNumbers);
        // Parallel stream() is used for large data set wit multi thread.
        list2.parallelStream()
                .filter(i->i%2==0)
                .forEach(i->System.out.println(i));



        // Example of large data set
        int total= IntStream.rangeClosed(1,1_00_00_00)
                .parallel()
                .filter(i->i%2!=0)
                .sum();
        System.out.println(total);
    }
}