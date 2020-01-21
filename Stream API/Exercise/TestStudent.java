import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestStudent {  

    public static void main(String[] args) {
    
        List<Student> studentList = new ArrayList<Student>();  
        
        studentList.add(new Student("Jonny",90));  
        studentList.add(new Student("Mike",85));  
        studentList.add(new Student("Leena",92));  
        studentList.add(new Student("Alice", 55));  
        studentList.add(new Student("Bob", 77));   
        
        List<Student> mapStudent = studentList.stream()
                        .map(s -> new Student(s.getName(), s.getMarks() ))
                        .filter(s -> s.getMarks() > 60 )
                        .sorted(Comparator.comparing(Student::getName))
                        .collect(Collection.toList() );

        System.out.print(mapStudent);     
    }  
}  
