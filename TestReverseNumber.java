import java.util.Scanner;

class TestReverseNumber{
	public static void main(String args[]){
		int input;
		
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter an Integer Number: ");
		
		
		try{
			input=scan.nextInt();
			Reverse reverse = new Reverse();
			reverse.ReverseNumber(input);
				
		}
		catch(Exception e){
			System.out.print("Input value you entered is not an Integer. ");
		}
		
			
	}

}

class Reverse{
	public void ReverseNumber(int input){
		int reversedNum=0;
			while(input>0){
			reversedNum=(input%10)+(reversedNum*10);
			input= input/10;
			
			}
			System.out.println("Reversed Number is: "+reversedNum);
	}
}