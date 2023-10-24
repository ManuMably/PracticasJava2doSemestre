
package bancoMariem;


public class Cliente {
    private int clienteId;
    private String nombre;

    // Constructor
    public Cliente(int clienteId, String nombre) {
        this.clienteId = clienteId;
        this.nombre = nombre;
    }

    // Getter para clienteId
    public int getClienteId() {
        return clienteId;
    }

    // Setter para clienteId
    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    // Getter para nombre
    public String getNombre() {
        return nombre;
    }

    // Setter para nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
