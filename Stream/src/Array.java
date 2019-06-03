public class Array {
    public static void main(String[] args) {



        Employee[] employees=Employee.getEmployees().stream().toArray(Employee[]::new);


    }
}
