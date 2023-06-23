package Modelo;

public class Mascota extends Propietario{
    
    private int id_mascota;
    private String nombre_pac;
    private int edad;
    private int peso;
    private String sexo;
    private String especie;
    private String raza;
    private String tamaño;
    private String observaciones;
    private String imagene;
    private String mascota_clave;

    public Mascota() {
        super();
    }

    public Mascota(int id_mascota, String nombre_pac, int edad, int peso, String sexo, String especie, String raza, String tamaño, String observaciones, String imagene, String mascota_clave, int id_propietario) {
        super(id_propietario);
        this.id_mascota = id_mascota;
        this.nombre_pac = nombre_pac;
        this.edad = edad;
        this.peso = peso;
        this.sexo = sexo;
        this.especie = especie;
        this.raza = raza;
        this.tamaño = tamaño;
        this.observaciones = observaciones;
        this.imagene = imagene;
        this.mascota_clave = mascota_clave;
    }

    public String getMascota_clave() {
        return mascota_clave;
    }

    public void setMascota_clave(String mascota_clave) {
        this.mascota_clave = mascota_clave;
    }

    

    public String getImagene() {
        return imagene;
    }

    public void setImagene(String imagene) {
        this.imagene = imagene;
    }

    public int getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
    }

    public String getNombre_pac() {
        return nombre_pac;
    }

    public void setNombre_pac(String nombre_pac) {
        this.nombre_pac = nombre_pac;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    
    
    
}
