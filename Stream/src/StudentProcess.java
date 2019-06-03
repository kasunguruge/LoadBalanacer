import java.util.List;
import java.util.stream.Collectors;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentProcess {
    static  Date today = new Date();



    public static void main(String[] args) {

        System.out.println(today);
    List<Student> studentList = Student.getStudents().stream().filter(s -> (today.compareTo(s.getAge()))<18)
            .collect(Collectors.toList());


    System.out.println(studentList);
}



    }

