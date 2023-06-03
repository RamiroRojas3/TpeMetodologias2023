package clases.Filtros;

import clases.ServicioTransporte;

public interface Filtro {
    boolean cumpleFiltro(ServicioTransporte servicio);
}
