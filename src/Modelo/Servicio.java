
package Modelo;


/**
 *
 * @author ediss
 */
public class Servicio {
    int id;
    String nom;
    String desc;
    double precio;

    public Servicio() {
    }

    public Servicio(int id, String nom, String desc, double precio) {
        this.id = id;
        this.nom = nom;
        this.desc = desc;
        this.precio = precio;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
