public class Contacto {
    private String nombre;
    private String telefono;
    private String email;

    public Contacto(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public String getNombre(){
        return nombre;
    }
    // void significa que el método no devuelve ningún valor. Simplemente asigna el dato recibido al atributo.
    public void setNombre(String nombre){ // En los paréntesis del setter colocamos el parámetro que recibirá el nuevo valor que queremos asignar al atributo.
        this.nombre = nombre; // this.nombre es el atributo de la clase y = nombre, asigna el nuevo valor al atributo.
    }
    public String getTelefono(){
        return telefono;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String toString(){
        return nombre + " | Teléfono: " + telefono + " | Email: " + email;
    }
}
