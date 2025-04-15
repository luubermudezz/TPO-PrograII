package Ejercicio4;

import Ejercicio2.Stack;

public class VersionedStack implements Stack {
    // Seteamos el INITIAL_SIZE en 1 porque elegimos seguir el ejercicio 2. P(a)
    private static final int INITIAL_SIZE = 1;
    private int[] array; // version actual
    private int count;
    private int[][] versions; // historial de versiones
    private int[] versionSizes;
    private int currentVersion;
    private int versionCount; // cantidad total de versiones


    public VersionedStack() {
        this.array = new int[INITIAL_SIZE];
        this.count = 0;
        this.versions = new int[INITIAL_SIZE][INITIAL_SIZE];
        this.versionSizes = new int[INITIAL_SIZE];
        this.currentVersion = 0; // no hay una version actual
        this.versionCount = 0;


    }


    @Override
    public void add(int a) {
        // Redimensionar el arreglo si es necesario
        if (count >= array.length) {
            // Duplicar el tamaño del arreglo
            int[] newArray = new int[array.length * 2];
            // Copiar los elementos del arreglo antiguo al nuevo
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }


        // Agregar el nuevo elemento
        array[count] = a;
        count++;


        // Guardar la nueva versión
        saveVersion();
    }


    @Override
    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar una pila vacía.");
        }
        count--;
        saveVersion();
    }

    @Override
    public int getTop() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope de una pila vacía.");
        }
        return this.array[count - 1];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }
    // Guarda una versión de la pila
    private void saveVersion() {
        // Crear un nuevo arreglo de versiones con tamaño incrementado
        int[][] newVersions = new int[versionCount + 1][];
        // Copiar versiones anteriores al nuevo arreglo
        for (int i = 0; i < versionCount; i++) {
            newVersions[i] = versions[i];
        }
        // Crear una nueva versión con el tamaño exacto de la pila
        int[] versionCopy = new int[count];
        for (int i = 0; i < count; i++) {
            versionCopy[i] = array[i];
        }
        newVersions[versionCount] = versionCopy;
        // Reemplazar el arreglo viejo por el nuevo
        versions = newVersions;
        // Guardar el tamaño de la nueva versión
        int[] newVersionSizes = new int[versionCount + 1];
        for (int i = 0; i < versionCount; i++) {
            newVersionSizes[i] = versionSizes[i];
        }
        newVersionSizes[versionCount] = count;
        versionSizes = newVersionSizes;
        // Actualizar estado
        currentVersion = versionCount;
        versionCount++;
    }

    // Devuelve una versión específica de la pila
    public void goToVersion(int version) {
        if (version < 0 || version >= versionCount) {
            throw new IllegalArgumentException("Versión inválida.");
        }

        // Restaurar el tamaño de la pila
        count = versionSizes[version];
        // Restaurar el contenido de la pila
        for (int i = 0; i < count; i++) {
            array[i] = versions[version][i];
        }

        currentVersion = version;
    }

    // crea una nueva version a partir de otra existente
    public void createVersionFrom(int version) {
        goToVersion(version);  // Restaurar la versión
        saveVersion();          // Crear una nueva versión a partir de la restaurada
    }


    public int getCurrentVersion() {
        return currentVersion;
    }

    // Devuelve la pila de una versión específica
    public int[] getVersionStack(int version) {
        if (version < 0 || version >= versionCount) {
            throw new IllegalArgumentException("Versión inválida.");
        }
        return versions[version]; // Devuelve la pila de la versión solicitada
    }



    /**
     * Convierte una instancia de VersionedStack a una instancia de Stack.
     * @param versionedStack La pila versionada a convertir.
     * @return Una nueva instancia de Stack con los mismos elementos.
     */
    public static Ejercicio4.Stack mapToStack(VersionedStack versionedStack) {
        Ejercicio4.Stack result = new StaticStack();
        for (int i = 0; i < versionedStack.count; i++) {
            result.add(versionedStack.array[i]);
        }
        return result;
    }


    /**
     * Convierte una instancia de Stack a una instancia de VersionedStack.
     * @param stack La pila a convertir.
     * @return Una nueva instancia de VersionedStack con los mismos elementos.
     */
    public static VersionedStack mapToVersionedStack(Ejercicio4.Stack stack) {
        VersionedStack versionedStack = new VersionedStack();
        Ejercicio4.Stack aux = StackUtil.copy(stack); // Copiamos la pila para no modificar la original.
        while (!aux.isEmpty()) {
            versionedStack.add(aux.getTop());
            aux.remove();
        }
        return versionedStack;
    }

}
