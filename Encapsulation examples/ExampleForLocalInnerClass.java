public class ExampleForLocalInnerClass{  
	 private int marks=80;
	 
	 void display(){ 
	 
		class Local{  
		  void print(){
			System.out.println(" Marks is: "+marks);
			}   
		}	
		  Local local=new Local();  
		  local.print();  
		}  
			
	 public static void main(String args[]){
		 
	  ExampleForLocalInnerClass exampleForLocalInnerClass=new ExampleForLocalInnerClass();  
	  exampleForLocalInnerClass.display();  
	 }  
} 