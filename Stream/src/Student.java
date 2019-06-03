import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student {


    private String name;

    private Date age;

    public Student(String name, Date age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public  static List<Student> getStudents(){
        List<Student> students=new ArrayList<Student>();


        students.add(new Student("Kasun",new Date(1993 ,01, 03,2,3,4)));
        students.add(new Student("Rajitha",new Date(1993 ,01, 03,2,3,4)));
        students.add(new Student("Guruge",new Date(1993 ,01, 03)));
        students.add(new Student("Tharindu",new Date(1993 ,01, 03)));
        students.add(new Student("Pasindu",new Date(1993 ,01, 03)));
        students.add(new Student("Hashan",new Date(1993 ,01, 03)));

        return students;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
