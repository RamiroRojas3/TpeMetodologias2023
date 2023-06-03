package clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import clases.Filtros.Filtro;

public class EmpresaTransporte {
    private String nombre;
    private List<ServicioTransporte> servicios;

    public EmpresaTransporte(String nombre) {
        this.nombre = nombre;
        this.servicios = new ArrayList<>();
    }

    public void agregarServicio(ServicioTransporte servicio) {
        servicios.add(servicio);
    }

    public List<ServicioTransporte> buscarServicios(String origen, String destino, LocalDate fechaViaje) {
        List<ServicioTransporte> serviciosFiltrados = new ArrayList<>();
        
        for (ServicioTransporte servicio : servicios) {
            if (servicio.getOrigen().equalsIgnoreCase(origen) &&
                servicio.getDestino().equalsIgnoreCase(destino) &&
                servicio.getFechaViaje().isEqual(fechaViaje)) {
                serviciosFiltrados.add(servicio);
            }
        }
        
        return serviciosFiltrados;
    }
    
    public List<ServicioTransporte> aplicarFiltro(Filtro filtro) {
        List<ServicioTransporte> serviciosFiltrados = new ArrayList<>();
        for (ServicioTransporte servicio : servicios) {
            if (filtro.cumpleFiltro(servicio)) {
                serviciosFiltrados.add(servicio);
            }
        }
        return serviciosFiltrados;
    }

    public List<ServicioTransporte> devolverPromosSuscripcion(Pasajero p){
        List<ServicioTransporte> serviciosPromocion = new ArrayList<>();
        for (ServicioTransporte servicio : servicios){
            if((p.isEstaSuscripto())&& (servicio.getAsientosDisponibles()>20)&&(servicio.getOrigen()==p.getOrigenSuscripcion())&&(servicio.getDestino()==p.getDestinoSuscripcion())){
                serviciosPromocion.add(servicio);
            }
        }
        return serviciosPromocion;
    }
    
}
