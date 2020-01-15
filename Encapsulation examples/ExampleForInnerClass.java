class OuterClass{  
	private int marks=80;  
	
	 class InnerClass{  
		void print(){
			System.out.println(" Marks is: "+marks);
			}  
	 }  
	 
 public static void main(String args[]){  
 
	  OuterClass outerClass=new OuterClass();  
	  OuterClass.InnerClass innerClass=outerClass.new InnerClass();  
	  innerClass.print();  
	}  
}  