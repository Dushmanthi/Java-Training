import java.io.*;

class NullExample{
    public static void main(String args[]){
        try {
            String word= null;
            if(word.equals("hi")){
                System.out.print("words are same");
            }
            else{
                System.out.print("words are not same");
            }
        } catch(NullPointerException  e) {
            System.out.print("This exception is called as Null Pointer Exception");
        }
    }

}