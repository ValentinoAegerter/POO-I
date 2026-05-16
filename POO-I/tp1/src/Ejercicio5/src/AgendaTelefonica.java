class Contacto {
    private String nombre;
    private String telefono;

    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (esTelefonoValido(telefono)) {
            this.telefono = telefono;
        }
    }

    public static boolean esTelefonoValido(String telefono) {
        if (telefono == null || telefono.length() != 10) {
            return false;
        }
        for (int i = 0; i < telefono.length(); i++) {
            if (!Character.isDigit(telefono.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return "Contacto{nombre='" + nombre + "', telefono='" + telefono + "'}";
    }
}

class AgendaTelefonica {
    private static final int CAPACIDAD_MAXIMA = 10;
    private Contacto[] contactos;
    private int cantidadContactos;

    public AgendaTelefonica() {
        this.contactos = new Contacto[CAPACIDAD_MAXIMA];
        this.cantidadContactos = 0;
    }

    public boolean agregarContacto(String nombre, String telefono) {
        if (cantidadContactos >= CAPACIDAD_MAXIMA) {
            System.out.println("Error: Agenda llena");
            return false;
        }
        if (!Contacto.esTelefonoValido(telefono)) {
            System.out.println("Error: Telefono invalido (debe tener 10 digitos)");
            return false;
        }
        for (int i = 0; i < cantidadContactos; i++) {
            if (contactos[i].getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Error: Ya existe un contacto con ese nombre");
                return false;
            }
        }
        contactos[cantidadContactos] = new Contacto(nombre, telefono);
        cantidadContactos++;
        return true;
    }

    public Contacto buscarPorNombre(String nombre) {
        for (int i = 0; i < cantidadContactos; i++) {
            if (contactos[i].getNombre().equalsIgnoreCase(nombre)) {
                return contactos[i];
            }
        }
        return null;
    }

    public Contacto buscarPorTelefono(String telefono) {
        for (int i = 0; i < cantidadContactos; i++) {
            if (contactos[i].getTelefono().equals(telefono)) {
                return contactos[i];
            }
        }
        return null;
    }

    public String[] buscarPorNombreParcial(String prefijo) {
        int coincidencias = 0;
        for (int i = 0; i < cantidadContactos; i++) {
            if (contactos[i].getNombre().toLowerCase().contains(prefijo.toLowerCase())) {
                coincidencias++;
            }
        }
        String[] resultados = new String[coincidencias];
        int indice = 0;
        for (int i = 0; i < cantidadContactos; i++) {
            if (contactos[i].getNombre().toLowerCase().contains(prefijo.toLowerCase())) {
                resultados[indice] = contactos[i].getNombre();
                indice++;
            }
        }
        return resultados;
    }

    public boolean actualizarTelefono(String nombre, String nuevoTelefono) {
        Contacto c = buscarPorNombre(nombre);
        if (c == null) {
            System.out.println("Error: Contacto no encontrado");
            return false;
        }
        if (!Contacto.esTelefonoValido(nuevoTelefono)) {
            System.out.println("Error: Nuevo telefono invalido");
            return false;
        }
        c.setTelefono(nuevoTelefono);
        return true;
    }

    public boolean eliminarContacto(String nombre) {
        int indice = -1;
        for (int i = 0; i < cantidadContactos; i++) {
            if (contactos[i].getNombre().equalsIgnoreCase(nombre)) {
                indice = i;
                break;
            }
        }
        if (indice == -1) {
            System.out.println("Error: Contacto no encontrado");
            return false;
        }
        for (int i = indice; i < cantidadContactos - 1; i++) {
            contactos[i] = contactos[i + 1];
        }
        contactos[cantidadContactos - 1] = null;
        cantidadContactos--;
        return true;
    }

    public void listarContactos() {
        System.out.println("=== Lista de Contactos ===");
        for (int i = 0; i < cantidadContactos; i++) {
            System.out.println(contactos[i].toString());
        }
    }

    public boolean estaLlena() {
        return cantidadContactos >= CAPACIDAD_MAXIMA;
    }

    public int obtenerCantidad() {
        return cantidadContactos;
    }

    public int obtenerEspaciosDisponibles() {
        return CAPACIDAD_MAXIMA - cantidadContactos;
    }

    public static void main(String[] args) {
        AgendaTelefonica agenda = new AgendaTelefonica();

        System.out.println("=== Prueba 1: Agregar 3 contactos validos ===");
        System.out.println("Agregar Juan: " + agenda.agregarContacto("Juan", "1234567890"));
        System.out.println("Agregar Maria: " + agenda.agregarContacto("Maria", "2345678901"));
        System.out.println("Agregar Carlos: " + agenda.agregarContacto("Carlos", "3456789012"));

        System.out.println("\n=== Prueba 2: Agregar contacto con telefono invalido ===");
        System.out.println("Agregar Pedro (telefono invalido): " + agenda.agregarContacto("Pedro", "12345"));

        System.out.println("\n=== Prueba 3: Agregar contacto con nombre duplicado ===");
        System.out.println("Agregar JUAN (duplicado): " + agenda.agregarContacto("JUAN", "5678901234"));
        System.out.println("Agregar juan (duplicado): " + agenda.agregarContacto("juan", "5678901234"));

        System.out.println("\n=== Prueba 4: Listar todos los contactos ===");
        agenda.listarContactos();

        System.out.println("\n=== Prueba 5: Buscar por nombre ===");
        Contacto c1 = agenda.buscarPorNombre("juan");
        System.out.println("Buscar 'juan': " + (c1 != null ? c1.toString() : "null"));
        Contacto c2 = agenda.buscarPorNombre("MARIA");
        System.out.println("Buscar 'MARIA': " + (c2 != null ? c2.toString() : "null"));

        System.out.println("\n=== Prueba 6: Buscar por telefono ===");
        Contacto c3 = agenda.buscarPorTelefono("2345678901");
        System.out.println("Buscar telefono 2345678901: " + (c3 != null ? c3.toString() : "null"));

        System.out.println("\n=== Prueba 7: Actualizar telefono ===");
        System.out.println("Actualizar Juan: " + agenda.actualizarTelefono("Juan", "1111111111"));
        System.out.println("Actualizar Maria: " + agenda.actualizarTelefono("Maria", "9999999999"));

        System.out.println("\n=== Prueba 8: Actualizar con telefono invalido ===");
        System.out.println("Actualizar Carlos con telefono invalido: " + agenda.actualizarTelefono("Carlos", "123"));

        System.out.println("\n=== Prueba 9: Buscar por nombre parcial ===");
        String[] resultados = agenda.buscarPorNombreParcial("ar");
        System.out.println("Buscar 'ar': ");
        for (String nombre : resultados) {
            System.out.println("  - " + nombre);
        }

        System.out.println("\n=== Prueba 10: Estadisticas ===");
        System.out.println("Cantidad de contactos: " + agenda.obtenerCantidad());
        System.out.println("Espacios disponibles: " + agenda.obtenerEspaciosDisponibles());
        System.out.println("Esta llena: " + agenda.estaLlena());

        System.out.println("\n=== Prueba 11: Eliminar contacto ===");
        System.out.println("Eliminar MARIA: " + agenda.eliminarContacto("MARIA"));

        System.out.println("\n=== Prueba 12: Listar tras eliminacion ===");
        agenda.listarContactos();

        System.out.println("\n=== Prueba 13: Agregar hasta llenar ===");
        agenda.agregarContacto("Ana", "4567890123");
        agenda.agregarContacto("Luis", "5678901234");
        agenda.agregarContacto("Rosa", "6789012345");
        agenda.agregarContacto("Jorge", "7890123456");
        agenda.agregarContacto("Sofia", "8901234567");
        agenda.agregarContacto("Miguel", "9012345678");
        System.out.println("Cantidad tras agregar: " + agenda.obtenerCantidad());

        System.out.println("\n=== Prueba 14: Verificar agenda llena ===");
        System.out.println("Esta llena: " + agenda.estaLlena());
        System.out.println("Agregar cuando esta llena: " + agenda.agregarContacto("Nuevo", "0123456789"));
    }
}