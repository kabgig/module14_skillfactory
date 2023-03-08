public class Main {
    public static void main(String[] args) {
        LoadingThread LT = new LoadingThread();
        LT.start();
        try {
            LT.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print("Images are loaded");
    }
}