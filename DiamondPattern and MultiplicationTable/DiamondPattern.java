class DiamondPattern{
	public static void main(String args[]){
		Diamond diamond = new Diamond();
		diamond.print(10);
	}
	
}
class Diamond{
	public void print(int n){
		
	int space = n - 1; 
	for (int row = 0; row < n; row++) 
	{ 
		for (int col = 0; col< space; col++){
			System.out.print(" "); 
		} 
			
		for (int j = 0; j <= row; j++){
			System.out.print("* "); 
		}
			
		System.out.println(" "); 
		space--; 
	} 

	space = 0; 
 
	for (int row = n; row > 0; row--) 
	{ 
		for (int col= 0; col < space; col++){
			System.out.print(" "); 
		}
			
		for (int j = 0;j <row;j++){
			System.out.print("* "); 
		}
		
		System.out.println(" "); 
		space++; 
	} 
} 

}
