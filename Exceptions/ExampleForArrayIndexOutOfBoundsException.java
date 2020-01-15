import java.io.*;

class ArrayOutOfBoundsExample{
    public static void main(String args[]){
        try {
            int array[] = new int[10];
            array[15]=5;
            System.out.print(array[15]);
            }
         catch(ArrayIndexOutOfBoundsException   e) {
            System.out.print("This exception is called as Array Index Out Of Bounds Exception ");
        }
    }

}