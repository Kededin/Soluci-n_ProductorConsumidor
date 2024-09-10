package ProductorConsumidor;

public class AppProductorConsumidor {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(5);  // Buffer de tamaño 5

        Productor productor = new Productor(buffer);
        Consumidor consumidor = new Consumidor(buffer);

        Thread Productor = new Thread(productor);
        Thread Consumidor = new Thread(consumidor);

        Productor.start();
        Consumidor.start();
    }
}
