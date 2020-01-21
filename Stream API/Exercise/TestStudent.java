import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestStudent {  

    public static void main(String[] args) {
    
        List<Student> studentList = new ArrayList<>();  
        
        studentList.add(new Employee("Jonny",90));  
        studentList.add(new Employee("Mike",85));  
        studentList.add(new Employee("Leena",92));  
        studentList.add(new Employee("Alice", 55));  
        studentList.add(new Employee("Bob", 77));   
        
        List<Student> mapStudent = studentList.stream()
                        .map(s -> new Student(e.getName(), e.getMarks() ))
                        .filter(s -> s.getMarks() > 60 )
                        .sorted(Comparator.comparing(Student::getName))
                        .collect(Collection.toList() );

        System.out.print(mapStudent);     
    }  
}  