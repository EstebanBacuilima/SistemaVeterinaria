package Modelo;

public class MUsuarios {
    
    private int id_user;
    private int id_empleado;
    private String tipo;
    private String usuario;
    private String contraseña;

    public MUsuarios() {
    }

    public MUsuarios(int id_user, int id_empleado, String tipo, String usuario, String contraseña) {
        this.id_user = id_user;
        this.id_empleado = id_empleado;
        this.tipo = tipo;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }    
}
