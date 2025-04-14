
import java.util.ArrayList;
import java.util.List;


public class VersionedStack implements Stack {
    private static final int MAX_SIZE = 10000;
    private final int[] array;
    private int count;
    private final List<Stack> versions; // Historial de versiones


    public VersionedStack() {
        array = new int[MAX_SIZE];
        count = 0;
        versions = new ArrayList<>();
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
        Stack version = StackUtil.copy(array);
        return;




    }


    // Devuelve una versión específica de la pila
    public VersionedStack getVersion(int version) {
        if (version < 0 || version >= versions.size()) {
            throw new IllegalArgumentException("Version not found");
        }
        VersionedStack versionedStack = new VersionedStack();
        versionedStack.array = versions.get(version);
        versionedStack.count = versions.get(version).length;
        return versionedStack;
    }


    // Elimina una versión específica
    public void removeVersion(int version) {
        if (version < 0 || version >= versions.size()) {
            throw new IllegalArgumentException("Version not found");
        }
        versions.remove(version);
    }
}
