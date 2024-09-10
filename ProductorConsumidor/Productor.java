package ProductorConsumidor;

public class Productor implements Runnable {
    private Buffer buffer;

    public Productor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                buffer.producir(i);
                Thread.sleep(500);  // Simula el tiempo que tarda en producir
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}