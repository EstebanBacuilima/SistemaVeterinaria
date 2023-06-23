package Modelo;

import java.time.LocalDate;

public class Secretaria extends Persona{
    
    private int Id_secretaria;
    private int numero_ventanilla;
    private String imagene;

    public Secretaria() {
        super();
    }

    public Secretaria(int Id_secretaria, int numero_ventanilla, String imagene, int persona_id, String cedula, String Pri_nombre, String Seg_nombre, String Pat_apellido, String Mat_apellido, LocalDate fecha_nacimiento, String correo, String direccion, String genero, String telefono, String movil) {
        super(persona_id, cedula, Pri_nombre, Seg_nombre, Pat_apellido, Mat_apellido, fecha_nacimiento, correo, direccion, genero, telefono, movil);
        this.Id_secretaria = Id_secretaria;
        this.numero_ventanilla = numero_ventanilla;
        this.imagene = imagene;
    }

    public String getImagene() {
        return imagene;
    }

    public void setImagene(String imagene) {
        this.imagene = imagene;
    }

    public int getId_secretaria() {
        return Id_secretaria;
    }

    public void setId_secretaria(int Id_secretaria) {
        this.Id_secretaria = Id_secretaria;
    }

    public int getNumero_ventanilla() {
        return numero_ventanilla;
    }

    public void setNumero_ventanilla(int numero_ventanilla) {
        this.numero_ventanilla = numero_ventanilla;
    }
    
    
}
