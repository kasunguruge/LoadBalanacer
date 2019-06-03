import java.util.List;
import java.util.stream.Collectors;

public class FilterAndProcess {

    public static void main(String[] args) {
        List<Employee> employeeList=Employee.getEmployees().stream()
                .filter(e->e.getName().contains("i"))
                .collect(Collectors.toList());


        List<Employee> employees=employeeList.stream()
                .map((e->new Employee(e.getName(),e.getMarks()*3))).collect(Collectors.toList());


        Long count = employeeList.stream()
                .map((e->new Employee(e.getName(),e.getMarks()*3))).count();



        System.out.println(employees);
        System.out.println("count"+count);
    }
}
