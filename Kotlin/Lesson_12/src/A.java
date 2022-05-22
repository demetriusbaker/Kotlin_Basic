public class A {
    private int count = 0;
    Boolean isLocked = false;

    private void in(){
        lock();
        count++;
        unLock();
    }

    void lock() {
        synchronized (this){
            while (isLocked){
                try {
                    wait();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            isLocked = true;
        }
    }

    void unLock() {
        synchronized (this){
            isLocked = false;
            notify();
        }
    }

    public static void main(String[] args) {
        A a = new A();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500000; i++)
                    a.in();
                System.out.println(a.count);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500000; i++)
                    a.in();
                System.out.println(a.count);
            }
        });

        t1.start();
        t2.start();
    }
}
