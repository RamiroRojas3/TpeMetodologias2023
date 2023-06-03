package clases.Filtros;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import clases.ServicioTransporte;

public class FiltroHora implements Filtro {
    private LocalTime horaSalidaMin;
    private LocalTime horaSalidaMax;

    public FiltroHora(LocalTime horaSalidaMin, LocalTime horaSalidaMax) {
        this.horaSalidaMin = horaSalidaMin;
        this.horaSalidaMax = horaSalidaMax;
    }

    @Override
    public List<ServicioTransporte> filtrar(List<ServicioTransporte> servicios) {
        List<ServicioTransporte> serviciosFiltrados = new ArrayList<>();
        for (ServicioTransporte servicio : servicios) {
            if ((servicio.getHoraSalida().getHour()>=horaSalidaMin.getHour())&&(servicio.getHoraLlegada().getHour()<=horaSalidaMax.getHour())) {
                serviciosFiltrados.add(servicio);
            }
        }
        return serviciosFiltrados;
    }
}