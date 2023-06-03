package clases.Filtros;

import clases.ServicioTransporte;

public class FiltroEmpresa implements Filtro {
    private String empresa;

    public FiltroEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public boolean cumpleFiltro(ServicioTransporte servicio){
        if(servicio.getEmpresa().equals(empresa)){
            return true;
        }
        else{
            return false;
        }
    }
}