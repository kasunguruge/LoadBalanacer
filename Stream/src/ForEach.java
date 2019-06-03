public class ForEach {
    public static void main(String[] args) {
        Employee.getEmployees().forEach(e->
                System.out.println(e.getName()));


        Employee.getEmployees().forEach(System.out::println);
    }


}
