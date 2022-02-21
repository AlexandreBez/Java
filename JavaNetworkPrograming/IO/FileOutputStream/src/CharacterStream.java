import java.io.*;

public class CharacterStream {

    public static void main(String[] args) {
        try {
            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("example4.txt"));
            InputStreamReader in = new InputStreamReader(new FileInputStream("example4.txt"));

            // System.out.println(out.getEncoding());

            out.write("jfhgddhqjkdfldkjsd");

            // out.write("Helllooooooooo");
            // out.flush();

            // out.write("Heloooooo againnnnnn");
            out.flush();
            out.close();

            int data = in.read();
            while(data != -1){
                System.out.println((char)data);
                data = in.read();
            }

            in.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}