package Ejercicio1_3;

public class Main {
    public static void main(String[] args) {
        // Prueba del ejercicio 1: VersionedStack básico (P(b))
        System.out.println("=== PRUEBA EJERCICIO 1: VersionedStack (P(b)) ===");
        testVersionedStack();

        // Prueba del ejercicio 3: Queue con VersionedStack
        System.out.println("\n=== PRUEBA EJERCICIO 3: Queue con VersionedStack ===");
        testQueueWithVersionedStack();
    }

    /**
     * Prueba de VersionedStack
     */
    private static void testVersionedStack() {
        VersionedStack stack = new VersionedStack();

        System.out.println("La pila está vacía? " + stack.isEmpty());

        System.out.println("\nAgregando elementos...");
        stack.add(10);
        System.out.println("Agregado: 10");
        stack.add(20);
        System.out.println("Agregado: 20");
        stack.add(30);
        System.out.println("Agregado: 30");

        // Obtener el tope
        System.out.println("\nTope actual: " + stack.getTop());

        // Eliminar un elemento
        System.out.println("\nEliminando elemento del tope...");
        stack.remove();
        System.out.println("Nuevo tope: " + stack.getTop());

        // Agregar más elementos
        System.out.println("\nAgregando más elementos...");
        stack.add(40);
        System.out.println("Agregado: 40");

        // Ir a una versión anterior
        System.out.println("\nVolviendo a versión 1...");
        stack.goToVersion(1);
        System.out.println("Tope después de ir a versión 1: " + stack.getTop());

        // Crear nueva versión a partir de una existente (P(b))
        System.out.println("\nCreando nueva versión desde versión 1...");
        stack.createVersionFrom(1);
        System.out.println("Agregando 50 a la nueva rama...");
        stack.add(50);
        System.out.println("Tope después de agregar en nueva rama: " + stack.getTop());

        // Volver a otra versión
        System.out.println("\nVolviendo a versión 3...");
        stack.goToVersion(3);
        System.out.println("Tope en versión 3: " + stack.getTop());
    }
    /**
     * Prueba de Queue implementada con VersionedStack (Ejercicio 3)
     */
    private static void testQueueWithVersionedStack() {
        StaticQueue queue = new StaticQueue();

        System.out.println("La cola está vacía? " + queue.isEmpty());

        System.out.println("\nEncolando elementos...");
        queue.add(10);
        System.out.println("Encolado: 10");
        queue.add(20);
        System.out.println("Encolado: 20");
        queue.add(30);
        System.out.println("Encolado: 30");

        System.out.println("\nFrente de la cola: " + queue.getFirst());

        System.out.println("\nDesencolando un elemento...");
        queue.remove();
        System.out.println("Nuevo frente: " + queue.getFirst());

        System.out.println("\nEncolando más elementos...");
        queue.add(40);
        System.out.println("Encolado: 40");
        queue.add(50);
        System.out.println("Encolado: 50");

        // Desencolar hasta vaciar
        System.out.println("\nDesencolando todos los elementos en orden:");
        while (!queue.isEmpty()) {
            System.out.println("Desencolado: " + queue.getFirst());
            queue.remove();
        }

        System.out.println("\nLa cola está vacía? " + queue.isEmpty());
    }
}