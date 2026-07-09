package pack_logica;

public class Cita {
    protected String idCita;
    protected String fecha;
    protected String hora;
    protected String medico;
    protected String motivo;
    protected String estado;

        //Constructor para establecer los datos dados como atributos
    public Cita(String idCita, String fecha, String hora, String medico, String motivo, String estado) {
        this.idCita = idCita;
        this.fecha = fecha;
        this.hora = hora;
        this.medico = medico;
        this.motivo = motivo;
        this.estado = estado;
    }

        //Getter y Setters para mantener la integridad de los datos
        public String getIdCita() { return idCita; }
        public String getFecha() { return fecha; }
        public String getHora() { return hora; }
        public String getMedico() { return medico; }
        public String getMotivo() { return motivo; }
        public String getEstado() { return estado; }
        public void setEstado(String estado) { this.estado = estado; }
        }