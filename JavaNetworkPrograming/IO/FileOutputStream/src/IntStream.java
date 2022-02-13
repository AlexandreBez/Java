import java.io.*;

public class IntStream {
    public static void main(String[] args) throws Exception {
        
        try {
            FileInputStream inputStream = new FileInputStream("C:/Users/Lucas/Desktop/Java/JavaNetworkPrograming/IO/FileOutputStream/src/example.txt");
            
            int data = inputStream.read();

            while (data != -1) {
                System.out.println((char)data);

                data = inputStream.read();
            }

            inputStream.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
}
