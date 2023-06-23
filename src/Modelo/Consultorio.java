package Modelo;

public class Consultorio {
    int id;
    String nom;
    String desc;

    public Consultorio() {
    }

    public Consultorio(int id, String nom, String desc) {
        this.id = id;
        this.nom = nom;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    
    
    
    
}
