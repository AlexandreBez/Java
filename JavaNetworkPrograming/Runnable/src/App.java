public class App {
    public static void main(String[] args) throws Exception {
        
        ImplRunnable runnable1 = new ImplRunnable(1);
        Thread thread1 = new Thread(runnable1, "Server 1");

        System.out.println(thread1.getName());

        thread1.start();

        ImplRunnable runnable2 = new ImplRunnable(2);
        Thread thread2 = new Thread(runnable2, "Server 2");

        System.out.println(thread2.getName());

        thread2.start();

        ImplRunnable runnable3 = new ImplRunnable(3);
        runnable3.start();
    }
}
