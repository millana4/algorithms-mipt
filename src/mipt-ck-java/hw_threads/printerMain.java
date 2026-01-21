class NumberPrinter implements Runnable {
    private String threadName;
    private int start;
    private int end;
    
    public NumberPrinter(String threadName, int start, int end) {
        this.threadName = threadName;
        this.start = start;
        this.end = end;
    }
    
    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            System.out.println("Поток " + threadName + ": " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class printerMain {
    public static void main(String[] args) {
        // Создаем и запускаем первый поток (числа 1-10)
        Thread thread1 = new Thread(new NumberPrinter("1", 1, 10));
        
        // Создаем и запускаем второй поток (числа 11-20)
        Thread thread2 = new Thread(new NumberPrinter("2", 11, 20));
        
        thread1.start();
        thread2.start();
    }
}