import java.util.ArrayList;
import java.util.List;

public class Employee {


    private String name;

    private int marks;

    public Employee(String name, int marks){
        this.name=name;
        this.marks=marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", marks=" + marks ;
    }

    public  static List<Employee> getEmployees(){
        List<Employee> employees=new ArrayList<Employee>();


        employees.add(new Employee("Kasun",89));
        employees.add(new Employee("Rajitha",45));
        employees.add(new Employee("Guruge",64));
        employees.add(new Employee("Tharindu",97));
        employees.add(new Employee("Pasindu",55));
        employees.add(new Employee("Hashan",66));

        return employees;
    }
}
