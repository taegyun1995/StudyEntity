package moderJava.동작파라미터;

public class RunnableThread {

    Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Hello world");
        }
    });

    Thread t2 = new Thread(() -> System.out.println("Hello world"));

}