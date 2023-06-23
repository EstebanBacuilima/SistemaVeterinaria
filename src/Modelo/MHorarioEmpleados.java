package Modelo;

public class MHorarioEmpleados {
    private int id_horarioemp;
    private int id_horario;
    private int id_medico;
    private String situacion;

    public MHorarioEmpleados() {
    }

    public MHorarioEmpleados(int id_horarioemp, int id_horario, int id_medico, String situacion) {
        this.id_horarioemp = id_horarioemp;
        this.id_horario = id_horario;
        this.id_medico = id_medico;
        this.situacion = situacion;
    }

    public int getId_horarioemp() {
        return id_horarioemp;
    }

    public void setId_horarioemp(int id_horarioemp) {
        this.id_horarioemp = id_horarioemp;
    }

    public int getId_horario() {
        return id_horario;
    }

    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }
}
