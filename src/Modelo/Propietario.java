package Modelo;

import java.time.LocalDate;

public class Propietario extends Persona{
    
    private int id_propietario;

    public Propietario() {
        super();
    }

    public Propietario(int id_propietario) {
        this.id_propietario = id_propietario;
    }
    
    public Propietario(int id_propietario, int persona_id, String cedula, String Pri_nombre, String Seg_nombre, String Pat_apellido, String Mat_apellido, LocalDate fecha_nacimiento, String correo, String direccion, String genero, String telefono, String movil) {
        super(persona_id, cedula, Pri_nombre, Seg_nombre, Pat_apellido, Mat_apellido, fecha_nacimiento, correo, direccion, genero, telefono, movil);
        this.id_propietario = id_propietario;
    }

    public int getId_propietario() {
        return id_propietario;
    }

    public void setId_propietario(int id_propietario) {
        this.id_propietario = id_propietario;
    }

    
}
