package Modelo;

public class Examen {
    
    private int examen_id;
    private int medico_id;
    private int mascota_id;
    private String nombre_examen;
    private String tipo_examen;
    private String observaciones;
    private String resutaldo_exa;

    public Examen() {
    }

    public Examen(int examen_id, int medico_id, int mascota_id, String nombre_examen, String tipo_examen, String observaciones, String resutaldo_exa) {
        this.examen_id = examen_id;
        this.medico_id = medico_id;
        this.mascota_id = mascota_id;
        this.nombre_examen = nombre_examen;
        this.tipo_examen = tipo_examen;
        this.observaciones = observaciones;
        this.resutaldo_exa = resutaldo_exa;
    }

    public int getExamen_id() {
        return examen_id;
    }

    public void setExamen_id(int examen_id) {
        this.examen_id = examen_id;
    }

    public int getMedico_id() {
        return medico_id;
    }

    public void setMedico_id(int medico_id) {
        this.medico_id = medico_id;
    }

    public int getMascota_id() {
        return mascota_id;
    }

    public void setMascota_id(int mascota_id) {
        this.mascota_id = mascota_id;
    }

    public String getNombre_examen() {
        return nombre_examen;
    }

    public void setNombre_examen(String nombre_examen) {
        this.nombre_examen = nombre_examen;
    }

    public String getTipo_examen() {
        return tipo_examen;
    }

    public void setTipo_examen(String tipo_examen) {
        this.tipo_examen = tipo_examen;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getResutaldo_exa() {
        return resutaldo_exa;
    }

    public void setResutaldo_exa(String resutaldo_exa) {
        this.resutaldo_exa = resutaldo_exa;
    }

}
