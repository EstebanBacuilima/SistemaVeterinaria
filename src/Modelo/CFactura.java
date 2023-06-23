
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author ediss
 */
public class CFactura {
    private int ID_FACTURA;
    private int ID_PROPIETARIO;
    private LocalDate FECHA; 
    private double TOTAL;

    public CFactura() {
    }

    public CFactura(int ID_FACTURA, int ID_PROPIETARIO, LocalDate FECHA, double TOTAL) {
        this.ID_FACTURA = ID_FACTURA;
        this.ID_PROPIETARIO = ID_PROPIETARIO;
        this.FECHA = FECHA;
        this.TOTAL = TOTAL;
    }

    public int getID_FACTURA() {
        return ID_FACTURA;
    }

    public void setID_FACTURA(int ID_FACTURA) {
        this.ID_FACTURA = ID_FACTURA;
    }

    public int getID_PROPIETARIO() {
        return ID_PROPIETARIO;
    }

    public void setID_PROPIETARIO(int ID_PROPIETARIO) {
        this.ID_PROPIETARIO = ID_PROPIETARIO;
    }

    public LocalDate getFECHA() {
        return FECHA;
    }

    public void setFECHA(LocalDate FECHA) {
        this.FECHA = FECHA;
    }

    public double getTOTAL() {
        return TOTAL;
    }

    public void setTOTAL(double TOTAL) {
        this.TOTAL = TOTAL;
    }

    
}