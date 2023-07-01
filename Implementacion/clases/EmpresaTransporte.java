package clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import clases.Filtros.Filtro;

public class EmpresaTransporte {
    private List<ServicioTransporte> servicios;

    public EmpresaTransporte() {
        this.servicios = new ArrayList<>();
    }

    public EmpresaTransporte(List<ServicioTransporte> servicios){
        this.servicios=new ArrayList<>();
        this.servicios.addAll(servicios);
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
            if((p.isEstaSuscripto())&& (servicio.getAsientosDisponibles()>20)){
                serviciosPromocion.add(servicio);
            }
        }
        return serviciosPromocion;
    }



    public void devolverLista(){
        if (this.servicios.size()==0){
            System.out.println("No se encontraron transportes");
        }
        for (ServicioTransporte s:servicios)
        {
            System.out.println(s);
        }
    }

    public double generarEstadisticas(){
        int cantidadServicios=this.servicios.size();
        int duracionServicios=0;
        for (ServicioTransporte s : servicios) {
            duracionServicios+=s.getTiempoDeViaje();
        }
        return (duracionServicios/cantidadServicios);
    }
    
}
