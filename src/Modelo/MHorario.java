package Modelo;

public class MHorario {
    private int id_horario;
    private String hora_inicio;
    private String hora_fin;
    private String dia;

    public MHorario() {
    }

    public MHorario(int id_horario, String hora_inicio, String hora_fin, String dia) {
        this.id_horario = id_horario;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.dia = dia;
    }

    public int getId_horario() {
        return id_horario;
    }

    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
}
