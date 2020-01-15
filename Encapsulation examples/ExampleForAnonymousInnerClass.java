class ExampleForAnonymousInnerClass{  
	public static void main(String args[]){  
		Singer singer=new Singer(){  
			void sing(){
				System.out.println("Sang a new song");
				}  
		};  
		singer.sing();  
	}  
}  
	 
abstract class Singer{  
  abstract void sing();  
}  
