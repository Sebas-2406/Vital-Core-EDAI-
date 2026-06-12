package pack_logica;

import java.time.LocalDate;
import java.util.List;
import pack_estructuras.ListaEnlazada;

public abstract class Farmaceutico extends PersonalMedico{
    protected String licenciaFarmaceutica, turno;
    protected ListaEnlazada<Medicina> inventarioMedicinas;

    public Farmaceutico(String id, String nombre, String apellido, LocalDate fechaNacimiento,
                     String numeroLicencia, int[] horario, String licenciaFarmaceutica, String turno, ListaEnlazada<Medicina> inventarioMedicinas){
        super(id, nombre, apellido, fechaNacimiento, numeroLicencia, horario);
        this.licenciaFarmaceutica = licenciaFarmaceutica;
        this.turno = turno;
        this.inventarioMedicinas = inventarioMedicinas;
    }

    public abstract void dispensarMedicamento(Receta receta);
    public abstract boolean verificarReceta(Receta receta);
    public abstract boolean verificarStock(Medicina medicina);
    public abstract Factura generarFactura(Receta receta);

    public String getLicenciaFarmaceutica() {return licenciaFarmaceutica;}
    public void setLicenciaFarmaceutica(String licenciaFarmaceutica) {this.licenciaFarmaceutica = licenciaFarmaceutica;}
    public ListaEnlazada<Medicina> getInventarioMedicinas() {return inventarioMedicinas;}
    public void setInventarioMedicinas(ListaEnlazada<Medicina> inventarioMedicinas) {this.inventarioMedicinas = inventarioMedicinas;}
    public String getTurno() {return turno;}
    public void setTurno(String turno) {this.turno = turno;}
}
