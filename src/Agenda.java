
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Agenda {

    private Map<String, Contacto> contactos;
    private Set<String> grupos;
    private Map<String, Set<String>> relacionNombres;
    private List<Contacto> historialContactos;

    public Agenda() {
        this.contactos = new TreeMap<>();
        this.grupos = new TreeSet<>();
        this.relacionNombres = new TreeMap<>();
        this.historialContactos = new ArrayList<>();
    }
    // Agregar contacto
    public void agregarContacto(Contacto c) {
        if (contactos.containsKey(c.getNombre())) {
            System.out.println(
                    "Ya existe un contacto con el nombre: " + c.getNombre()
            );
        } else {
            contactos.put(c.getNombre(), c);
            historialContactos.add(c);
        }
    }
    // Buscar contacto
    public Contacto buscarContacto(String nombre) {
        return contactos.get(nombre);
    }
    // Eliminar contacto
    public boolean eliminarContacto(String nombre) {
        if (!contactos.containsKey(nombre)) {
            return false;
        }
        // Eliminar el nombre de todos los grupos
        for (Set<String> nombres : relacionNombres.values()) {
            nombres.remove(nombre);
        }
        // Eliminar del historial y del mapa
        historialContactos.remove(contactos.get(nombre));
        contactos.remove(nombre);
        return true;
    }
    // Listar contactos en orden alfabético
    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos registrados.");
            return;
        }
        for (Contacto contacto : contactos.values()) {
            System.out.println(contacto);
        }
    }
    // Listar historial en orden de inserción
    public void listarHistorial() {
        if (historialContactos.isEmpty()) {
            System.out.println("El historial está vacío.");
            return;
        }
        for (Contacto contacto : historialContactos) {
            System.out.println(contacto);
        }
    }
    // Agregar grupo
    public void agregarGrupo(String nombreGrupo) {
        if (grupos.contains(nombreGrupo)) {
            System.out.println("El grupo ya existe.");
        } else {
            grupos.add(nombreGrupo);
            relacionNombres.put(nombreGrupo, new TreeSet<>());
            System.out.println("Grupo agregado correctamente.");
        }
    }
    // Agregar contacto a un grupo
    public void agregarContactoAGrupo(
            String nombreContacto, String nombreGrupo) {
        if (!contactos.containsKey(nombreContacto)) {
            System.out.println("El contacto no existe.");
            return;
        }
        if (!grupos.contains(nombreGrupo)) {
            System.out.println("El grupo no existe.");
            return;
        }
        relacionNombres.get(nombreGrupo).add(nombreContacto);
        System.out.println("Contacto agregado al grupo.");
    }
    // Listar grupos en orden alfabético
    public void listarGrupos() {
        if (grupos.isEmpty()) {
            System.out.println("No hay grupos registrados.");
            return;
        }
        for (String grupo : grupos) {
            System.out.println(grupo);
        }
    }
    // Mostrar contactos de un grupo
    public void mostrarContactosPorGrupo(String nombreGrupo) {
        if (!grupos.contains(nombreGrupo)) {
            System.out.println("El grupo no existe.");
            return;
        }
        Set<String> nombres = relacionNombres.get(nombreGrupo);
        if (nombres.isEmpty()) {
            System.out.println("El grupo no tiene contactos.");
            return;
        }
        for (String nombre : nombres) {
            System.out.println(contactos.get(nombre));
        }
    }
}
