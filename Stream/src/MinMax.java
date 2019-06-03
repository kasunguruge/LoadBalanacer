import java.util.Comparator;
import java.util.Optional;

public class MinMax {


    public static void main(String[] args) {
        Optional<Employee> employee=Employee.getEmployees().stream()
                .min(Comparator.comparing(Employee::getMarks));

        System.out.println(employee.get());


        Optional<Employee> employee1=Employee.getEmployees().stream()
                .max(Comparator.comparing(Employee::getMarks));

        System.out.println(employee1.get());
    }
}
