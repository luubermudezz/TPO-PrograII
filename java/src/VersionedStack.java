
import java.util.ArrayList;
import java.util.List;


public class VersionedStack implements Stack {
    private static final int MAX_SIZE = 10000;
    private final int[] array; // version actual
    private int count; // cantidad de elementos de la version actual

    private final int[][] versions; // historial de versiones
    private final int[] versionSizes;
    
    private int indexCurrentVersion;
    
    private int versionCount; // cantidad total de versiones

    public VersionedStack() {
        this.array = new int[MAX_SIZE];
        this.count = 0;
        this.versions = new int[MAX_SIZE][MAX_SIZE];
        this.versionSizes = new int[MAX_SIZE];
        this.indexCurrentVersion = -1; // no hay una version actual
        this.versionCount = 0;
    }

    @Override
    public void add(int a) {
        if(count == MAX_SIZE) {
            throw new RuntimeException("Stack is full");
        }
        array[count] = a;
        count++;
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
        if (versionCount >= MAX_SIZE) {
            throw new RuntimeException("No se pueden crear mas versiones");
        }

        for (int i = 0; i < count; i++) {
            versions[versionCount][i] = array[i];
        }
        versionSizes[versionCount] = count;
        indexCurrentVersion = versionCount;
        versionCount++;
    }

    // Devuelve una versión específica de la pila
    public void goToVersion(int version) {
        if (version < 0 || version >= MAX_SIZE) {
            throw new IllegalArgumentException("No existe esa version");
        }

        count = versionSizes[version];

        for (int i = 0; i < count; i++) {
            array[i] = versions[version][i];
        }

        indexCurrentVersion = version;
    }

    // crea una nueva version a partir de otra existente
    public void createVersionFrom(int version) {
        if (version < 0 || version >= MAX_SIZE) {
            throw new IllegalArgumentException("No existe esa version");
        }

        goToVersion(version);
        saveVersion();
    }
}
