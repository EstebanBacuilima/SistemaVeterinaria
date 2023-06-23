package Modelo;

import java.time.LocalDate;

public class Medico extends Persona{
    
    private int idMedico;
    private String especialidad;
    private int servicio_id;
    private int consultorio_id;
    private String imagen;

    public Medico() {
        super();
    }

    public Medico(int idMedico) {
        this.idMedico = idMedico;
    }

    public Medico(int idMedico,String especialidad,int servicio_id,int consultorio_id,String imagen,int persona_id, String cedula, String Pri_nombre, String Seg_nombre, String Pat_apellido, String Mat_apellido, LocalDate fecha_nacimiento, String correo, String direccion, String genero, String telefono, String movil) {
        super(persona_id, cedula, Pri_nombre, Seg_nombre, Pat_apellido, Mat_apellido, fecha_nacimiento, correo, direccion, genero, telefono, movil);
        this.idMedico = idMedico;
        this.especialidad = especialidad;
        this.servicio_id= servicio_id;
        this.consultorio_id=consultorio_id;
        this.imagen = imagen;
        
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }
   
   
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getServicio_id() {
        return servicio_id;
    }

    public void setServicio_id(int servicio_id) {
        this.servicio_id = servicio_id;
    }

    public int getConsultorio_id() {
        return consultorio_id;
    }

    public void setConsultorio_id(int consultorio_id) {
        this.consultorio_id = consultorio_id;
    }
    
      public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
}
