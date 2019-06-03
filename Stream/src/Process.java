import java.util.List;
import java.util.stream.Collectors;

public class Process {

    public static void main(String[] args) {


        List<Employee> employees=Employee.getEmployees().stream()
                .map((e->new Employee(e.getName(),e.getMarks()*5))).collect(Collectors.toList());


        System.out.println(employees);
    }
}
