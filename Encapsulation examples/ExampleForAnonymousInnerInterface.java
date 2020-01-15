interface Singer{  
 void sing();  
}
  
class ExampleForAnonymousInnerInterface{ 
 
	 public static void main(String args[]){  
		Singer singer=new Singer(){  
			public void sing(){
				System.out.println("Sang a new song");
			}  
		}; 
			singer.sing(); 
	 }  
}  