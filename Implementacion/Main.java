import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import clases.EmpresaTransporte;
import clases.Pasajero;
import clases.ServicioTransporte;
import clases.SistemaDeTransporte;
import clases.TarjetaCredito;
import clases.Filtros.Filtro;
import clases.Filtros.FiltroCosto;
import clases.Filtros.FiltroEmpresa;
import clases.Filtros.FiltroHora;
import clases.Filtros.FiltroMes;

public class Main{
    public static void main(String[] args){
        //Generacion de datos 

        SistemaDeTransporte sistema=new SistemaDeTransporte();
        TarjetaCredito t1=new TarjetaCredito();
        TarjetaCredito t2=new TarjetaCredito();
        TarjetaCredito t3=new TarjetaCredito();

        Pasajero p1=new Pasajero("Luciano","Rizzi","43247119","Richi123",t1);
        Pasajero p2=new Pasajero("Pablo","Rivas","42630980","Pablo179",t2);
        Pasajero p3=new Pasajero("Valentin","Diaz","43560800","Valentin16",t3);

        sistema.aniadirPasajero(p1);
        sistema.aniadirPasajero(p2);
        sistema.aniadirPasajero(p3);

        EmpresaTransporte listaServicios=new EmpresaTransporte();
        EmpresaTransporte serviciosBuscados;
        EmpresaTransporte serviciosFiltrados;

        String[] nombresEmpresas = {"El Rapido", "Rio Parana", "Via Tac", "Platabus", "Condor Estrella"};
        String[] ciudades = {"Tandil","Mar del Plata","Rauch","Buenos Aires", "Olavarria"};
            // Generar servicios aleatorios
        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            String nombreEmpresa = nombresEmpresas[random.nextInt(nombresEmpresas.length)];
            String origen = ciudades[random.nextInt(ciudades.length)];
            String destino = ciudades[random.nextInt(ciudades.length)];
            while(origen==destino){
                if (origen==destino){
                    destino=ciudades[random.nextInt(ciudades.length)];
                }
                }
            double costo = random.nextDouble()*100;
            LocalDate fecha = LocalDate.now().plusDays(i);
            LocalTime horaSalida = LocalTime.of(random.nextInt(24), 0).truncatedTo(ChronoUnit.HOURS);
            LocalTime horaLlegada = horaSalida.plusHours(random.nextInt(6) + 1).truncatedTo(ChronoUnit.HOURS);
            int asientosDisponibles = random.nextInt(40) + 10;
            ServicioTransporte servicio = new ServicioTransporte(nombreEmpresa, origen, destino, fecha,
                    horaSalida, horaLlegada,costo, asientosDisponibles);
            listaServicios.agregarServicio(servicio);
        }




        System.out.println("Menu login");
        System.out.println("================");
        System.out.println("1-Iniciar sesion");
        System.out.println("2-Registrarse");
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        int opcionLogueo=scanner.nextInt();
        switch(opcionLogueo){
            case 1:
                System.out.println("Ingrese Dni: ");
                String Dni=scanner.next();
                scanner.nextLine();
                System.out.println("Ingrese una contraseña");
                String contraseña=scanner.nextLine();
                if(sistema.verificarPasajeroEnSistema(Dni)){
                  if(sistema.verificarContraseña(contraseña)){
                    System.out.println("Opciones plataforma 9 3/4");
                    System.out.println("==========================");
                    System.out.println("1-Buscar servicios");
                    System.out.println("2-Generar estadisticas");
                    System.out.println("");
                    System.out.println("Ingrese la opcion que quiera ejecutar:");

                    int opcionMenu=scanner.nextInt();
                    switch(opcionMenu){
                    case 1:

                        listaServicios.devolverLista();

                        System.out.println("Ingrese ciudad origen del viaje");
                        String origen = scanner.nextLine();
                        scanner.nextLine();
                        System.out.println("Ingrese ciudad de destino");
                        String destino = scanner.nextLine();
                        System.out.print("Ingrese la fecha de salida (formato yyyy-mm-dd-): ");
                        String fechaSalidaStr = scanner.nextLine();
                        LocalDate fechaSalida = LocalDate.parse(fechaSalidaStr);
                        serviciosBuscados=new EmpresaTransporte(listaServicios.buscarServicios(origen, destino, fechaSalida));

                        serviciosBuscados.devolverLista();

                        System.out.println("Desea utilizar algun filtro para la busqueda? (s/n)");
                            String respuesta = scanner.nextLine();
                            if (!respuesta.equalsIgnoreCase("s")) {
                                return;
                            }
                        System.out.println("");
                        System.out.println("===Filtros de busqueda===");
                        System.out.println("");
                        System.out.println("1-Por costo");
                        System.out.println("2-Por empresa");
                        System.out.println("3-Por horarios");
            

                        int opcion = scanner.nextInt();
                    
                        switch (opcion) {
                            case 1:
                                System.out.println("Ingrese costo maximo");
                                double costo=scanner.nextDouble();
                                FiltroCosto filtroC=new FiltroCosto(costo);
                                serviciosFiltrados=new EmpresaTransporte(serviciosBuscados.aplicarFiltro(filtroC));
                                serviciosFiltrados.devolverLista();
                                break;
                            case 2:
                                System.out.println("Ingrese Empresa deseada");
                                String empresa=scanner.nextLine();
                                FiltroEmpresa filtroE=new FiltroEmpresa(empresa);
                                serviciosFiltrados=new EmpresaTransporte(serviciosBuscados.aplicarFiltro(filtroE));
                                serviciosFiltrados.devolverLista();
                                break;
                            case 3:
                                int min=0;
                                int seg=0;
                                System.out.println("Ingrese la hora de salida minima");
                                int horaSalidaMin=scanner.nextInt();
                                System.out.println("Ingrese hora de salida maxima");
                                int horaSalidaMax=scanner.nextInt();
                                System.out.println("Ingrese hora de llegada minima");
                                int horaLlegadaMin=scanner.nextInt();
                                System.out.println("Ingrese hora de llegada maxima");
                                int horaLlegadaMax=scanner.nextInt();
                                LocalTime horaSMin = LocalTime.of(horaSalidaMin,min,seg);
                                LocalTime horaSMax = LocalTime.of(horaSalidaMax,min,seg);
                                LocalTime horaLMin = LocalTime.of(horaLlegadaMin,min,seg);
                                LocalTime horaLMax = LocalTime.of(horaLlegadaMax,min,seg);
                                FiltroHora filtroH= new FiltroHora(horaSMin, horaSMax, horaLMin, horaLMax);
                                serviciosFiltrados=new EmpresaTransporte(serviciosBuscados.aplicarFiltro(filtroH));
                                serviciosFiltrados.devolverLista();
                                break;
                                }
                    case 2:
                            System.out.println("Usted selecciono generar estadisticas, se le mandara al sistema su ubicacion actual en el viaje cada 10 minutos y recibira un bono de 10$ para su proxima compra por su ayuda");
                            LocalDate fechaActual=LocalDate.now();
                            FiltroMes filtro=new FiltroMes(fechaActual.getMonthValue());
                            EmpresaTransporte serviciosMesActual=new EmpresaTransporte(listaServicios.aplicarFiltro(filtro));
                            double duracionPromedio=serviciosMesActual.generarEstadisticas();
                            System.out.println("La duracion promedio de los servicios del mes fue de "+duracionPromedio+" horas");
                            break;
                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                        break;
                        }
                }
                    else{
                    System.out.println("La contraseña es incorrecta");
                    }
                }
                
                else{
                    System.out.println("El dni no se encuentra en el sistema");
                }
            }
        }
    }
       
                        