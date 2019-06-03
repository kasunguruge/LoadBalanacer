import java.util.List;
import java.util.stream.Collectors;

public class SortExample {


    public static void main(String[] args) {



        Employee.getEmployees().stream()

                .filter(e -> e.getName().length()>=5)
                .map(e-> new Employee(e.getName(),e.getMarks()).toString().toUpperCase())
                .sorted((e1,e2)-> e1.getName().compareTo(-(e2.getName())))


                .forEach(System.out::println);


    }

}
