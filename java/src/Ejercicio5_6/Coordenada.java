package Ejercicio5_6;

public class Coordenada {
    private final double x;
    private final double y;
    private final double z;


    public Coordenada(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }


    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Coordenada)) return false;
        Coordenada other = (Coordenada) obj;
        return this.x == other.x && this.y == other.y && this.z == other.z;
    }
}
