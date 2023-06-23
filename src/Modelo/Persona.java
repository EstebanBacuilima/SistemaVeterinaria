package Modelo;

import java.time.LocalDate;

public class Persona {

    private int persona_id;
    private String cedula;
    private String Pri_nombre;
    private String Seg_nombre;
    private String Pat_apellido;
    private String Mat_apellido;
    private LocalDate fecha_nacimiento;
    private String correo;
    private String direccion;
    private String genero;
    private String telefono;
    private String movil;

    public Persona() {
    }

    public Persona(int persona_id, String cedula, String Pri_nombre, String Seg_nombre, String Pat_apellido, String Mat_apellido, LocalDate fecha_nacimiento, String correo, String direccion, String genero, String telefono, String movil) {
        this.persona_id = persona_id;
        this.cedula = cedula;
        this.Pri_nombre = Pri_nombre;
        this.Seg_nombre = Seg_nombre;
        this.Pat_apellido = Pat_apellido;
        this.Mat_apellido = Mat_apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo = correo;
        this.direccion = direccion;
        this.genero = genero;
        this.telefono = telefono;
        this.movil = movil;
    }

    public int getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPri_nombre() {
        return Pri_nombre;
    }

    public void setPri_nombre(String Pri_nombre) {
        this.Pri_nombre = Pri_nombre;
    }

    public String getSeg_nombre() {
        return Seg_nombre;
    }

    public void setSeg_nombre(String Seg_nombre) {
        this.Seg_nombre = Seg_nombre;
    }

    public String getPat_apellido() {
        return Pat_apellido;
    }

    public void setPat_apellido(String Pat_apellido) {
        this.Pat_apellido = Pat_apellido;
    }

    public String getMat_apellido() {
        return Mat_apellido;
    }

    public void setMat_apellido(String Mat_apellido) {
        this.Mat_apellido = Mat_apellido;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

   
}
