package ProductorConsumidor;

import java.util.LinkedList;

public class Buffer {
    private LinkedList<Integer> buffer;
    private int capacidad;

    public Buffer(int capacidad) {
        this.buffer = new LinkedList<>();
        this.capacidad = capacidad;
    }

    // Método para el productor (añadir al final)
    public synchronized void producir(int item) throws InterruptedException {
        while (buffer.size() == capacidad) {
            System.out.println("Buffer lleno, productor espera...");
            wait();
        }

        buffer.addLast(item);  // Agregar al final
        System.out.println("Producido: " + item);
        notifyAll();  // Despertar a los consumidores
    }

    // Método para el consumidor (remover del inicio)
    public synchronized int consumidor() throws InterruptedException {
        while (buffer.isEmpty()) {
            System.out.println("Buffer vacío, consumidor espera...");
            wait();
        }

        int item = buffer.removeFirst();  // Remover del inicio
        System.out.println("Consumido: " + item);
        notifyAll();  // Despertar a los productores
        return item;
    }
}