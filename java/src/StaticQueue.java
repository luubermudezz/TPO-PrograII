public class StaticQueue implements Queue {
    private VersionedStack inStack;  // encolar elementos
    private VersionedStack outStack; // desencolar elementos

    public StaticQueue() {
        this.inStack = new VersionedStack();
        this.outStack = new VersionedStack();
    }

    @Override
    public void add(int a) {
        inStack.add(a);
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("La cola está vacía");
        }

        if (outStack.isEmpty()) {
            transferElements();
        }

        outStack.remove();
    }

    @Override
    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    @Override
    public int getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("La cola está vacía");
        }

        if (outStack.isEmpty()) {
            transferElements();
        }

        return outStack.getTop();
    }

    private void transferElements() {
        while (!inStack.isEmpty()) {
            int value = inStack.getTop();
            outStack.add(value);
            inStack.remove();
        }
    }
}