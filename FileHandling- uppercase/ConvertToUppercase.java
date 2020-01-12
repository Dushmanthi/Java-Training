import java.io.FileWriter; 
import java.io.FileReader; 
import java.io.IOException; 
class ConvertToUppercase{ 
    public static void main(String[] args) throws IOException{ 
		FileReader();
		FileWriter();
	}
		
		static void FileReader() throws IOException{
			
			FileReader fileReader = new FileReader("output.txt");
			int i;    
			while((i=fileReader.read())!=-1){
				if((i>96) && (i<123)){
					System.out.print((char)(i-32));
				}
			}     
			fileReader.close();    
		}
		
		static void FileWriter() throws IOException{
			FileWriter fileWriter = new FileWriter("output.txt");
			String fileLength = "hello";
			String word = "";
			for (int i = 0; i < fileLength.length(); i++) {
				char c = fileLength.charAt(i);
				int n = (int) c;
				if (97 <= n && n <= 122) {
                n = n - 32;
            }
            word = word + (char) n;
			System.out.print(word);
        }
			fileWriter.close();  
		}

	
}