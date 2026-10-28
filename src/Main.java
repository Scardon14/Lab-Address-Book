public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        System.out.println("===== 1. AGREGAR CONTACTOS =====");
        agenda.agregarContacto(
                new Contacto("Carlos", "3001111111", "carlos@gmail.com")
        );
        agenda.agregarContacto(
                new Contacto("Ana", "3002222222", "ana@gmail.com")
        );
        agenda.agregarContacto(
                new Contacto("Gabriela", "3003333333", "gabriela@gmail.com")
        );
        System.out.println("\n=== CONTACTOS AGREGADOS ===");
        agenda.listarContactos();
        // Intentar agregar un contacto con nombre duplicado
        System.out.println("\n=== INTENTAR AGREGAR UN CONTACTO CON NOMBRE DUPLICADO ===");
        agenda.agregarContacto(
                new Contacto("Ana", "3119999999", "ana2@gmail.com")
        );
        System.out.println("\n===== 2. CONTACTOS EN ORDEN ALFABÉTICO =====");
        agenda.listarContactos();
        System.out.println("\n===== 3. HISTORIAL DE INSERCIÓN =====");
        agenda.listarHistorial();
        System.out.println("\n===== 4. BUSCAR CONTACTO =====");
        Contacto encontrado = agenda.buscarContacto("Gabriela");
        if (encontrado != null) {
            System.out.println("Contacto encontrado: " + encontrado);
        } else {
            System.out.println("Contacto no encontrado.");
        }
        Contacto inexistente = agenda.buscarContacto("Pedro");
        if (inexistente == null) {
            System.out.println("Pedro no existe en la agenda.");
        }
        System.out.println("\n===== 5. CREAR GRUPOS =====");
        agenda.agregarGrupo("Trabajo");
        agenda.agregarGrupo("Amigos");
        agenda.agregarGrupo("Familia");
        // Intentar crear un grupo duplicado
        agenda.agregarGrupo("Amigos");
        System.out.println("\n===== 6. LISTAR GRUPOS =====");
        agenda.listarGrupos();
        System.out.println("\n===== 7. AGREGAR CONTACTOS A GRUPOS =====");
        agenda.agregarContactoAGrupo("Carlos", "Amigos");
        agenda.agregarContactoAGrupo("Ana", "Amigos");
        agenda.agregarContactoAGrupo("Gabriela", "Trabajo");
        agenda.agregarContactoAGrupo("Carlos", "Trabajo");
        System.out.println("\n===== 8. CONTACTOS DEL GRUPO AMIGOS =====");
        agenda.mostrarContactosPorGrupo("Amigos");
        System.out.println("\n===== 9. ELIMINAR CONTACTO =====");
        boolean eliminado = agenda.eliminarContacto("Carlos");
        if (eliminado) {
            System.out.println("Carlos fue eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar a Carlos.");
        }
        System.out.println("\n===== 10. CONTACTOS DESPUÉS DE ELIMINAR =====");
        agenda.listarContactos();
        System.out.println("\n===== 11. HISTORIAL DESPUÉS DE ELIMINAR =====");
        agenda.listarHistorial();
        System.out.println("\n===== 12. GRUPO TRABAJO DESPUÉS DE ELIMINAR =====");
        agenda.mostrarContactosPorGrupo("Trabajo");
        System.out.println("\n===== 13. INTENTAR ELIMINAR OTRA VEZ =====");
        boolean eliminadoNuevamente = agenda.eliminarContacto("Carlos");
        System.out.println("¿Se eliminó?: " + eliminadoNuevamente);
    }
}