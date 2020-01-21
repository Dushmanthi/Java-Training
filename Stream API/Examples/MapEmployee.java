import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MapEmployee {  

    public static void main(String[] args) {
    
        List<Employee> employeeList = new ArrayList<>();  
        
        employeeList.add(new Employee(110,"Jonny"));  
        employeeList.add(new Employee(402,"Mike"));  
        employeeList.add(new Employee(105,"Leena"));  
        employeeList.add(new Employee(205,"Alice"));  
        employeeList.add(new Employee(356,"Bob"));   
        
        List<Employee> mapedEmployee = employeeList.stream()
                    .map(e -> new Employee("Dr." + e.getName(), e.getId()))
                    collect(Collectors.toList());

                    
        System.out.print(mapedEmployee); 
                  
    }  
}  