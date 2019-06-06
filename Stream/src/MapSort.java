import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapSort {
    static int passMark=60;
    public static void main(String[] args) {
        Map<String, Integer> students=new HashMap<>();
        students.put("kasun", 33);
        students.put("rajith", 67);
        students.put("abb", 23);
        students.put("acc", 98);
        students.put("erfere", 100);
        students.put("gan", 56);
        students.put("lk", 69);



//    List<String> student= students.entrySet().stream()
//                .filter(e -> e.getValue()>=passMark)
//                .sorted((e1,e2)->e1.getKey().compareTo(e2.getKey()))
//                .map(e->e.getKey())
//                .collect(Collectors.toList());
//
//        student.forEach(System.out::println);
//
//        List<String> strings=new ArrayList<>();
//
//
//        students.entrySet().stream()
//                .filter(e -> e.getValue()>=passMark)
//                .sorted((e1,e2)->e1.getKey().compareTo(e2.getKey()))
//                .peek(e-> strings.add(e.getKey()))
//                .collect(Collectors.toList())
//
//            .forEach(System.out::println);


        Map<Integer, String> vehicles=new HashMap<>();

        vehicles.put(10, "car");
        vehicles.put(50, "SUV");
        vehicles.put(20, "Jeep");
        vehicles.put(12, "Bus");
        vehicles.put(15, "Ship");
        vehicles.put(16, "Lorry");
        vehicles.put(4, "Cycle");




        List<String> string1=new ArrayList<>();
        List<Integer> integer1=new ArrayList<>();

        vehicles.entrySet().stream()

                .sorted((e3,e4)->-e3.getKey().compareTo(e4.getKey()))
                .peek(e-> integer1.add(e.getKey()))
                .collect(Collectors.toList()).stream()

                 .sorted((e1,e2)->e1.getValue().compareTo(e2.getValue()))

                .filter(e -> e.getValue()!="Ship")
                .peek(e-> string1.add(e.getValue()))
                .collect(Collectors.toList()).stream();

        System.out.println(string1);
        System.out.println(integer1);

       // vehicle.forEach(System.out::println);
    }

}
