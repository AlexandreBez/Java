public class App {
    public static void main(String[] args) throws Exception {
        ServerThread thread = new ServerThread("Server 1");
        thread.start();
    }
}
