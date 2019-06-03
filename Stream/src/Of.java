import java.util.stream.Stream;

public class Of {
    public static void main(String[] args) {
        Stream.of(1,2,3,5,2,5,6).sorted().forEach(System.out::println);


        Integer[] integers={4,2,6,8,9,4};
        Stream<Integer> stream= Stream.of(integers);

        stream.sorted().forEach(System.out::println);

    }
}
