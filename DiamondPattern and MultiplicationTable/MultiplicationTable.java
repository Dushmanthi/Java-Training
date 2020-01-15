class MultiplicationTable{
	public static void main(String args[]){
		 
      System.out.println("Enter an integer variable : ");
      int num ;
	  for(num =1; num<10;num++){
		  
			System.out.print("     "+num+"   ");
			
	  }
	  System.out.println(" ");
	  System.out.print("-------------------------------------------------------------------------");
	  System.out.println(" ");
	  
	  for(num =1; num<10;num++){
		  System.out.print(num+" | " );
			  for(int i=1; i< 10; i++) {
				System.out.print("   "+(num*i)+"    ");
			}
			
			System.out.println(" ");
	  }
      
   }

	
}

/*class Multiplication{
	public void print(int n){
		
	
} 

}*/
