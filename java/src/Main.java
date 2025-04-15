
/**
 * Clase para probar las implementaciones de los ejercicios 1, 2 y 3
 */
public class Main {
    public static void main(String[] args) {
        // Prueba del ejercicio 1: VersionedStack básico (P(b))
        System.out.println("=== PRUEBA EJERCICIO 1: VersionedStack (P(b)) ===");
        testVersionedStack();

//        // Prueba del ejercicio 2: Modificación de VersionedStack
//        System.out.println("\n=== PRUEBA EJERCICIO 2: Modificación de VersionedStack ===");
//        testVersionedStackModification();

        // Prueba del ejercicio 3: Queue con VersionedStack
        System.out.println("\n=== PRUEBA EJERCICIO 3: Queue con VersionedStack ===");
        testQueueWithVersionedStack();
    }

    /**
     * Prueba de VersionedStack básico (Ejercicio 1)
     */
    private static void testVersionedStack() {
        VersionedStack stack = new VersionedStack();

        // Comprobar si está vacía inicialmente
        System.out.println("La pila está vacía? " + stack.isEmpty());

        // Agregar elementos
        System.out.println("\nAgregando elementos...");
        stack.add(10);
        System.out.println("Agregado: 10");
        stack.add(20);
        System.out.println("Agregado: 20");
        stack.add(30);
        System.out.println("Agregado: 30");

        // Obtener el tope
        System.out.println("\nTope actual: " + stack.getTop());
//        System.out.println("Versión actual: " + stack.indexCurrentVersion);
//        System.out.println("Total de versiones: " + stack.versionCount);

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
     * Prueba de la modificación de VersionedStack (Ejercicio 2)
     */
//    private static void testVersionedStackModification() {
//        // Esta prueba depende de la implementación específica de P(a), P(b) o P(c)
//        // Como ejemplo, probaré el crecimiento del arreglo de versiones (P(a))
//
//        VersionedStack stack = new VersionedStack();
//
//        System.out.println("Capacidad inicial del arreglo de versiones: " + stack.versions.length);
//
//        // Crear varias versiones
//        System.out.println("\nCreando múltiples versiones...");
//        for (int i = 1; i <= 5; i++) {
//            stack.add(i * 10);
//            System.out.println("Agregado: " + (i * 10) + ", Versión: " + stack.indexCurrentVersion);
//        }
//
//        System.out.println("\nTotal de versiones creadas: " + stack.versionCount);
//
//        // Para P(a) deberíamos poder verificar si el arreglo crece correctamente
//        // Para P(c) podríamos verificar si cada versión tiene el tamaño óptimo
//    }

    /**
     * Prueba de Queue implementada con VersionedStack (Ejercicio 3)
     */
    private static void testQueueWithVersionedStack() {
        // Implementación con dos pilas para una cola correcta
        StaticQueue queue = new StaticQueue();

        // Comprobar si está vacía inicialmente
        System.out.println("La cola está vacía? " + queue.isEmpty());

        // Encolar elementos
        System.out.println("\nEncolando elementos...");
        queue.add(10);
        System.out.println("Encolado: 10");
        queue.add(20);
        System.out.println("Encolado: 20");
        queue.add(30);
        System.out.println("Encolado: 30");

        // Obtener el frente
        System.out.println("\nFrente de la cola: " + queue.getFirst());

        // Desencolar un elemento
        System.out.println("\nDesencolando un elemento...");
        queue.remove();
        System.out.println("Nuevo frente: " + queue.getFirst());

        // Encolar más elementos
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
