package Modelo;

import java.time.LocalDate;

public class Auxiliar extends Persona{
    
    private int auxiliar_id;
    private String labores;
    private int id_servicio;
    private String imagen;

    public Auxiliar() {
        super();
    }

    public Auxiliar(int auxiliar_id) {
        this.auxiliar_id = auxiliar_id;
    }

    public Auxiliar(int auxiliar_id,String labores,int id_servicio,String imagen,int persona_id, String cedula, String Pri_nombre, String Seg_nombre, String Pat_apellido, String Mat_apellido, LocalDate fecha_nacimiento, String correo, String direccion, String genero, String telefono, String movil) {
        super(persona_id, cedula, Pri_nombre, Seg_nombre, Pat_apellido, Mat_apellido, fecha_nacimiento, correo, direccion, genero, telefono, movil);
        this.auxiliar_id = auxiliar_id;
        this.labores = labores;
        this.id_servicio= id_servicio;
        this.imagen = imagen;
    }

    public int getAuxiliar_id() {
        return auxiliar_id;
    }

    public void setAuxiliar_id(int auxiliar_id) {
        this.auxiliar_id = auxiliar_id;
    }

    public String getLabores() {
        return labores;
    }

    public void setLabores(String labores) {
        this.labores = labores;
    }


      public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }
    
    
}
