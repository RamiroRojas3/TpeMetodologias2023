package clases.Filtros;


import clases.ServicioTransporte;

public class FiltroCosto implements Filtro {
    private double costoMaximo;

    public FiltroCosto(double costoMaximo) {
        this.costoMaximo = costoMaximo;
    }

    @Override
    public boolean cumpleFiltro(ServicioTransporte servicio) {
        if(servicio.getCosto()<=costoMaximo){
            return true;
        }
        else{
            return false;
        }
    }

    

}