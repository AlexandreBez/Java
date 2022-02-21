import java.io.*;

public class BufferedStream {

    public static void main(String[] args) {
        try {

            BufferedReader reader = new BufferedReader(new FileReader("Example6.txt"));            
            BufferedWriter writer = new BufferedWriter(new FileWriter("Example7.txt"));            

            String line = null;

            while((line = reader.readLine()) != null){
                writer.write(line);
                writer.newLine();
            }

            writer.close();
            reader.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}