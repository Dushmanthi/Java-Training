import java.io.*;

class NumberFormatExample{
    public static void main(String args[]){
        try {
            int marks = Integer.parseInt("Jonny");
            System.out.print("Maths marks: "+marks);
        } catch(NumberFormatException  e) {
            System.out.print("This exception is called as Number Format Exception");
        }
    }

}