package Modelo;
import java.time.LocalDate;
public class Receta{

    private String receta_id;
    private int mascota_id;
    private int medico_id;
    private LocalDate receta_fechaEmision;
    private String receta_diagnostico;
    private String receta_indicaciones;

    public Receta() {
    }

    public Receta(String receta_id, int mascota_id, int medico_id, LocalDate receta_fechaEmision, String receta_diagnostico, String receta_indicaciones) {
        this.receta_id = receta_id;
        this.mascota_id = mascota_id;
        this.medico_id = medico_id;
        this.receta_fechaEmision = receta_fechaEmision;
        this.receta_diagnostico = receta_diagnostico;
        this.receta_indicaciones = receta_indicaciones;
    }

 
    public String getReceta_id() {
        return receta_id;
    }

    public void setReceta_id(String receta_id) {
        this.receta_id = receta_id;
    }

    public int getMascota_id() {
        return mascota_id;
    }

    public void setMascota_id(int mascota_id) {
        this.mascota_id = mascota_id;
    }

    public int getMedico_id() {
        return medico_id;
    }

    public void setMedico_id(int medico_id) {
        this.medico_id = medico_id;
    }

     public LocalDate getReceta_fechaEmision() {
        return receta_fechaEmision;
    }

    public void setReceta_fechaEmision(LocalDate receta_fechaEmision) {
        this.receta_fechaEmision = receta_fechaEmision;
    }

    public String getReceta_indicaciones() {
        return receta_indicaciones;
    }

    public void setReceta_indicaciones(String receta_indicaciones) {
        this.receta_indicaciones = receta_indicaciones;
    }

    public String getReceta_diagnostico() {
        return receta_diagnostico;
    }

    public void setReceta_diagnostico(String receta_diagnostico) {
        this.receta_diagnostico = receta_diagnostico;
    }
    
    
    
    
}
