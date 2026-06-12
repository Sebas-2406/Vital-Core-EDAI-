package pack_logica;

import java.time.LocalDate;
import java.util.List;
import pack_estructuras.ListaEnlazada;

public abstract class HistoriaClinica {
    protected String numeroHistoria;
    protected LocalDate fechaCreacion;
    protected ListaEnlazada<RegistroMedico> registros;
    protected ListaEnlazada<Diagnostico> diagnosticos;

    public HistoriaClinica(String numeroHistoria, LocalDate fechaCreacion, ListaEnlazada<RegistroMedico> registros, ListaEnlazada<Diagnostico> diagnosticos) {
        this.numeroHistoria = numeroHistoria;
        this.fechaCreacion = fechaCreacion;
        this.registros = registros;
        this.diagnosticos = diagnosticos;
    }

    public abstract void agregarDiagnostico(Diagnostico diagnostico);
    public abstract List<Diagnostico> obtenerHistorialCompleto();
    public abstract List<Diagnostico> buscarPorFecha(LocalDate fecha);

    public String getNumeroHistoria() {return numeroHistoria;}
    public void setNumeroHistoria(String numeroHistoria) {this.numeroHistoria = numeroHistoria;}
    public LocalDate getFechaCreacion() {return fechaCreacion;}
    public void setFechaCreacion(LocalDate fechaCreacion) {this.fechaCreacion = fechaCreacion;}
    public ListaEnlazada<RegistroMedico> getRegistros() {return registros;}
    public void setRegistros(List<RegistroMedico> registros) {this.registros = (ListaEnlazada<RegistroMedico>) registros;}
    public ListaEnlazada<Diagnostico> getDiagnosticos() {return diagnosticos;}
    public void setDiagnosticos(List<Diagnostico> diagnosticos) {this.diagnosticos = (ListaEnlazada<Diagnostico>) diagnosticos;}
}
