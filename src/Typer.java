class Typer extends Thread{
    String message;
    static String lock = "Lock";
    public Typer(String message) {
        this.message = message;
    }
    @Override
    public void run() {
        synchronized (lock){
        for (int i = 0; i < message.length(); i++) {
            System.out.print(message.charAt(i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }}
    }
}