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


public class CoordenadaUtils {
    /**
     * Proyecta la i-ésima componente de una coordenada.
     * Precondición: i debe ser 0 (x), 1 (y) o 2 (z)
     * Postcondición: devuelve la componente correspondiente
     */
    public static double proyectar(Coordenada coord, int i) {
        switch (i) {
            case 0: return coord.getX();
            case 1: return coord.getY();
            case 2: return coord.getZ();
            default:
                throw new IllegalArgumentException("Índice inválido: debe ser 0, 1 o 2.");
        }
    }
    public static double distancia(Coordenada c1, Coordenada c2) {
        double dx = c1.getX() - c2.getX();
        double dy = c1.getY() - c2.getY();
        double dz = c1.getZ() - c2.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }


    // Calcula la distancia euclidiana entre dos coordenadas
    public static double calcularDistancia(Coordenada a, Coordenada b) {
        double dx = a.getX() - b.getX();
        double dy = a.getY() - b.getY();
        double dz = a.getZ() - b.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }


    /**
     * Verifica si dos coordenadas son iguales.
     * Precondición: coord1 y coord2 no deben ser null
     * Postcondición: devuelve true si las tres componentes son iguales
     */
    public static boolean sonIguales(Coordenada c1, Coordenada c2) {
        return c1.equals(c2);
    }


    // Verifica si una coordenada está en el primer octante (x, y, z > 0)
    public static boolean estaEnPrimerOctante(Coordenada c) {
        return c.getX() > 0 && c.getY() > 0 && c.getZ() > 0;
    }
}

public class App {
    public static void main(String[] args) {
        Coordenada a = new Coordenada(3, 4, 5);
        Coordenada b = new Coordenada(6, 8, 10);


        System.out.println("a: " + a);
        System.out.println("b: " + b);


        System.out.println("Distancia entre a y b: " + CoordenadaUtils.distancia(a, b));
        System.out.println("¿Son iguales? " + CoordenadaUtils.sonIguales(a, b));
        System.out.println("¿'a' está en el primer octante? " + CoordenadaUtils.estaEnPrimerOctante(a));
        System.out.println("Componente 0 de 'b': " + CoordenadaUtils.proyectar(b, 0));
    }
}
