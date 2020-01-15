class LoginProcess{  
	public static void main(String[] args){  
	 
	User user=new User();   
	user.setEmail("admin@gmail.com");
	System.out.println("user name is : "+user.getEmail());  
	
	user.setPassword("admin@123"); 
	System.out.println("user password is : "+user.getPassword()); 
	}  
}  

class User{  
  
	private String email;  
	private String password;
 
	public String getEmail(){  
		return email;  
	}  
  
	public void setEmail(String email){  
		this.email=email;  
	}  
	
	public String getPassword(){  
		return password;  
	}  
  
	public void setPassword(String password){  
		this.password=password;  
	}  
}  