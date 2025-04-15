package Ejercicio2;

public class Main {
    public static void main(String[] args) {
        VersionedStack stack = new VersionedStack();


        // Agregar elementos
        stack.add(1);
        stack.add(2);
        stack.add(3);


        // Verificar el estado de la pila
        System.out.println("Top: " + stack.getTop());  // Debería imprimir 3


        // Eliminar el último elemento
        stack.remove();
        System.out.println("Top after remove: " + stack.getTop());  // Debería imprimir 2


        // Ir a la versión 0 (agregamos valor 1)
        stack.goToVersion(0);
        System.out.println("Top at version 0: " + stack.getTop());  // Debería imprimir 1




        // Ir a la versión 1 (agregamos valor 2)
        stack.goToVersion(1);
        System.out.println("Top at version 1: " + stack.getTop());  // Debería imprimir 2


        // Ir a la versión 2 (agregamos valor 3)
        stack.goToVersion(2);
        System.out.println("Top at version 2: " + stack.getTop());  // Debería imprimir 3


        // Ir a la versión 3 (Eliminamos elemento de valor 3 --> debería devolver 2)
        stack.goToVersion(3);
        System.out.println("Top at version 3: " + stack.getTop());  // Debería imprimir 2


        // Verificar la versión actual
        System.out.println("Current version: " + stack.getCurrentVersion());  // Debería imprimir 3 (última versión)
    }
}

