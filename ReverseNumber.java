import java.util.Scanner;

public class ReverseNumber{
	public static void main(String args[]){
		int num=0,reverseNum=0;
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter an Integer Number: ");
		num=scan.nextInt();

		while(num>0){
			reverseNum=(num%10)+(reverseNum*10);
			num= num/10;
		}
		System.out.println("Reverse Number is: "+reverseNum);
	}

}