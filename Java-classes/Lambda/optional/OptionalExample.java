package optional;

import java.util.Optional;
import java.util.OptionalInt;

public class OptionalExample {
    public static void main(String[] args) {
        String str="This is just a string.";
        String str1=null;
        Optional<Integer> obj=Optional.empty();
        Optional<String> opt = Optional.ofNullable(str1);
        System.out.println(opt.isPresent()); // will return boolean value.
        System.out.println(opt.get()); // This line will throw exception with NosuchElementException in case of empty string.
    }

}