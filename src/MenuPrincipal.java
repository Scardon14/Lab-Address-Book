import java.util.Scanner;
public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();
        int opcion;
        do {
            System.out.println("\n===== AGENDA DE CONTACTOS =====");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Listar contactos");
            System.out.println("5. Listar historial");
            System.out.println("6. Agregar grupo");
            System.out.println("7. Agregar contacto a grupo");
            System.out.println("8. Listar grupos");
            System.out.println("9. Mostrar contactos por grupo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    Contacto contacto =
                            new Contacto(nombre, telefono, email);
                    agenda.agregarContacto(contacto);
                    break;
                case 2:
                    System.out.print("Nombre a buscar: ");
                    nombre = scanner.nextLine();
                    Contacto encontrado =
                            agenda.buscarContacto(nombre);
                    if (encontrado != null) {
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Nombre a eliminar: ");
                    nombre = scanner.nextLine();
                    if (agenda.eliminarContacto(nombre)) {
                        System.out.println("Contacto eliminado.");
                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;
                case 4:
                    agenda.listarContactos();
                    break;
                case 5:
                    agenda.listarHistorial();
                    break;
                case 6:
                    System.out.print("Nombre del grupo: ");
                    String nombreGrupo = scanner.nextLine();
                    agenda.agregarGrupo(nombreGrupo);
                    break;
                case 7:
                    System.out.print("Nombre del contacto: ");
                    nombre = scanner.nextLine();
                    System.out.print("Nombre del grupo: ");
                    nombreGrupo = scanner.nextLine();
                    agenda.agregarContactoAGrupo(
                            nombre, nombreGrupo
                    );
                    break;
                case 8:
                    agenda.listarGrupos();
                    break;
                case 9:
                    System.out.print("Nombre del grupo: ");
                    nombreGrupo = scanner.nextLine();
                    agenda.mostrarContactosPorGrupo(nombreGrupo);
                    break;
                case 0:
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
        scanner.close();
    }
}