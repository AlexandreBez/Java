import java.io.*;

public class PrintStream {
    
    public static void main(String[] args) {
        
        try {
            PrintStream outs = new PrintStream();
            int var1 = 10;

            System.out.println(var1);

            outs.prinln(var1);

            outs.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}