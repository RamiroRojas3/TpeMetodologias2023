 package clases.Filtros;
 import java.time.LocalTime;
 import java.util.ArrayList;
 import java.util.List;
 import clases.ServicioTransporte;

 public class FiltroHora implements Filtro {
     private LocalTime horaSalidaMin;
     private LocalTime horaSalidaMax;
     private LocalTime horaLlegadaMin;
     private LocalTime horaLlegadaMax;

     public FiltroHora(LocalTime horaSalidaMin, LocalTime horaSalidaMax, LocalTime horaLlegadaMin, LocalTime horaLlegadaMax) {
         this.horaSalidaMin = horaSalidaMin;
         this.horaSalidaMax = horaSalidaMax;
         this.horaLlegadaMin = horaLlegadaMin;
         this.horaLlegadaMax = horaLlegadaMax;
     }

     @Override

     public boolean cumpleFiltro(ServicioTransporte servicio){
        if ((((servicio.getHoraSalida().getHour()>= horaSalidaMin.getHour())&&(servicio.getHoraSalida().getHour()<=horaLlegadaMax.getHour())))&&(((servicio.getHoraSalida().getHour()>= horaSalidaMin.getHour())&&(servicio.getHoraSalida().getHour()<=horaLlegadaMax.getHour())))){
            return true;
        }
        else{
            return false;
        }
     }

    }