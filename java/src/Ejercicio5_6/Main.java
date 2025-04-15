package Ejercicio5_6;

public class Main {
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

