public class ImplRunnable implements Runnable{

    private int threadIndex;

    public ImplRunnable(int index){
        this.threadIndex = index;
    }
    
    public void run() {
        int clientNumber = 0;

        while (clientNumber != 100) {
            System.out.println("Server " + this.threadIndex + " sent data to client " + clientNumber);
            clientNumber++;
        }
    }

    public void start(){
        Thread thread = new Thread(this);
        thread.start();
    }
    
}