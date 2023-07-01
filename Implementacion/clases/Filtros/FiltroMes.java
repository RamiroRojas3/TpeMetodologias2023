package clases.Filtros;

import clases.ServicioTransporte;

public class FiltroMes implements Filtro{
    
    private int mes;

    public FiltroMes(int mes){
        this.mes=mes;
    }

    @Override
    public boolean cumpleFiltro(ServicioTransporte servicio) {
        return(servicio.getFechaViaje().getMonthValue()==mes);
    }
}