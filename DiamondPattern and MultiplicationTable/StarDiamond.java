import java.util.Scanner;

public class StarDiamond
{
    public static void main(String args[]) 
    {	Scanner s = new Scanner(System.in);
	
        int n, i, j, space = 1;
		System.out.print("Please enter number of rows : ");
        n = s.nextInt();
		
        space = n;
		
        for (j = 1; j < n+1; j++) 
        {
            for (i = 1; i < space; i++) 
            {
                System.out.print(" ");
            }
			
            space--;
			
            for (i = 1; i <= (2 * j) - 1 ; i++) 
            {
                System.out.print("*");                
            }
            System.out.println("");
        }
		
			space = 1;
		
        for (j = 1; j < n ; j++) 
        {
            for (i = 1; i < space+1; i++) 
            {
                System.out.print(" ");
            }
            space++;
            for (i = 1; i <= 2 * (n - j) - 1; i++) 
            {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
/*
output:-
Please enter number of rows : 7
      *
     ***
    *****
   *******
  *********
 ***********
*************
 ***********
  *********
   *******
    *****
     ***
      *
	  
*/	  
	  