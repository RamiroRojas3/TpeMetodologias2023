package clases;

import java.time.LocalDate;
import java.time.LocalTime;

public class ServicioTransporte {
    private String empresa;
    private String origen;
    private String destino;
    private LocalDate fechaViaje;
    private LocalTime horaSalida;
    private LocalTime horaLlegada;
    private double costo;
    private int asientosDisponibles;

    

    public ServicioTransporte(String empresa,String origen, String destino, LocalDate fechaViaje, LocalTime horaSalida,
            LocalTime horaLlegada, double costo, int asientosDisponibles) {
        this.empresa=empresa;
        this.origen = origen;
        this.destino = destino;
        this.fechaViaje = fechaViaje;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.costo = costo;
        this.asientosDisponibles = asientosDisponibles;
    }
    
    
    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public LocalTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(LocalTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDate getFechaViaje() {
        return fechaViaje;
    }

    public void setFechaViaje(LocalDate fechaViaje) {
        this.fechaViaje = fechaViaje;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getAsientosDisponibles() {
        return asientosDisponibles;
    }

    public void setAsientosDisponibles(int asientosDisponibles) {
        this.asientosDisponibles = asientosDisponibles;
    }


    @Override
    public String toString() {
        return "ServicioTransporte [empresa=" + empresa + ", origen=" + origen + ", destino=" + destino
                + ", fechaViaje=" + fechaViaje + ", horaSalida=" + horaSalida + ", horaLlegada=" + horaLlegada
                + ", costo=" + costo + ", asientosDisponibles=" + asientosDisponibles + "]";
    }


    public String getEmpresa() {
        return empresa;
    }
    
    public int getTiempoDeViaje(){
        if(this.horaSalida.getHour()>this.horaLlegada.getHour()){
            return(horaLlegada.getHour()+(24-horaSalida.getHour()));
        }
        else{
            return horaLlegada.getHour()-horaSalida.getHour();
        }
    }
    
}