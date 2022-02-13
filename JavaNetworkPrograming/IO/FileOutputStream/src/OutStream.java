import java.io.*;

public class OutStream {
    public static void main(String[] args) {
        try {
            FileOutputStream outStream = new FileOutputStream("C:/Users/Lucas/Desktop/Java/JavaNetworkPrograming/IO/FileOutputStream/src/example.txt", true);
        
            char H = 'H';

            outStream.write((char)H);

            String string = "Hello World";

            outStream.write(string.getBytes());

            outStream.close();
        
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}