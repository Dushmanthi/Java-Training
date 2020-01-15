import java.util.Scanner;

public class FrogQuestion{
    public static void main(String args[]) {
        
        try{
            int input=0;
            int distance[] = {5,3,1};
            int time[] = {1,2,5};
            int timeSpent = 0;
            int distanceTraveled = 0;
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter 'd' to get distance(meter) or enter 't' to get time(second) :");
            String s =scanner.next();

            if(s.equals("d")){
                try{
                    System.out.print("Enter traveled distance by frog:  ");
                    input = scanner.nextInt();
                }
                catch(NumberFormatException e){
                    System.out.print("Entered value is not a Number, please enter a number: ");
                }
                
                distanceTraveled = input;
                for(int index =0; index <= distance.length; index++){
                    if(distanceTraveled <= 0){
                        break;
                    }
                    if(index == 3){
                        index = 0;
                    }
        
                    distanceTraveled -= distance[index];
        
                    if(distanceTraveled > 0){
                        timeSpent += time[index];
                    }
                }
                System.out.println("Frog spent "+timeSpent+" seconds to go "+input+" meters");
           }
            
           if(s.equals("t")){
            System.out.print("Enter spent time by frog:  ");
            input = scanner.nextInt();
            timeSpent = input;
    
            for(int index =0; index <= time.length; index++){
                if(timeSpent <= 0){
                    break;
                }
                if(index == 3){
                    index = 0;
                }
                if(timeSpent > 0){
                    distanceTraveled += distance[index];
                }
                timeSpent -= time[index];
                
            }
            System.out.println("Frog spent "+input+" seconds to go "+distanceTraveled+" meters");
       }
        
        }
        catch(Exception e){
            System.out.print("Entered value is not correct, please enter correct input.");
        }
        
    
    }

}