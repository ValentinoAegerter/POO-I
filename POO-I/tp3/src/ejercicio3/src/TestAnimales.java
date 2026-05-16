package ejercicio3.src;

public class TestAnimales {

    public static void main(String[] args) {
        System.out.println("--- Creando Perro ---");
        Perro p = new Perro("Rex", 2, "Labrador");

        System.out.println();
        System.out.println("--- Referencias a Perro con distintos tipos ---");
        Animal a = p; // referencia de tipo Animal
        Mamifero m = p; // referencia de tipo Mamifero

        System.out.println("Animal referencia hacerSonido(): " + a.hacerSonido());
        System.out.println("Mamifero referencia hacerSonido(): " + m.hacerSonido());
        System.out.println("Perro hacerSonido(): " + p.hacerSonido());

        System.out.println();
        System.out.println("toString acumulado: " + p.toString());

        System.out.println();
        System.out.println("--- Creando Mamifero y Animal genérico ---");
        Mamifero mm = new Mamifero("Mami", 3);
        Animal aa = new Animal("Gen");

        System.out.println("Mamifero toString: " + mm.toString());
        System.out.println("Animal toString: " + aa.toString());
    }

}
