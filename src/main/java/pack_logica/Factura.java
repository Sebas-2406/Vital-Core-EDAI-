package pack_logica;

import java.time.LocalDate;
import java.util.List;
import pack_estructuras.ListaEnlazada;

public abstract class Factura {
     protected String idFactura;
     protected LocalDate fecha;
     protected ListaEnlazada<String> conceptos;
     protected ListaEnlazada<Medicina> medicinas;
     protected double subtotal;
     protected double iva;
     protected double total;

    public Factura(String idFactura, LocalDate fecha, ListaEnlazada<String> conceptos, ListaEnlazada<Medicina> medicinas, double subtotal, double iva, double total) {
        this.idFactura = idFactura;
        this.fecha = fecha;
        this.conceptos = conceptos;
        this.medicinas = medicinas;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
    }

    public abstract void agregarConcepto(String concepto, double monto);
    public abstract void agregarMedicina(Medicina medicina);
    public abstract double calcularTotal();
    public abstract String generarComprobante();

    public String getIdFactura() {return idFactura;}
    public void setIdFactura(String idFactura) {this.idFactura = idFactura;}
    public LocalDate getFecha() {return fecha;}
    public void setFecha(LocalDate fecha) {this.fecha = fecha;}
    public ListaEnlazada<String> getConceptos() {return conceptos;}
    public void setConceptos(ListaEnlazada<String> conceptos) {this.conceptos = conceptos;}
    public ListaEnlazada<Medicina> getMedicinas() {return medicinas;}
    public void setMedicinas(ListaEnlazada<Medicina> medicinas) {this.medicinas = medicinas;}
    public double getSubtotal() {return subtotal;}
    public void setSubtotal(double subtotal) {this.subtotal = subtotal;}
    public double getIva() {return iva;}
    public void setIva(double iva) {this.iva = iva;}
    public double getTotal() {return total;}
    public void setTotal(double total) {this.total = total;}
}
