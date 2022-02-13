public class App {
    public static void main(String[] args) throws Exception {
        ServerThread thread = new ServerThread("Server 1");
        ServerThread thread2 = new ServerThread("Server 2");

        thread2.setPriority(Thread.MAX_PRIORITY);

        thread2.start();
        thread.start();
    }
}
