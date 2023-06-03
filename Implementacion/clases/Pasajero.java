package clases;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Pasajero {
    private String nombre;
    private String apellido;
    private String DNI;
    private String contraseña;
    private TarjetaCredito tarjetaCredito;
    private List<Asiento> asientosSeleccionados;
    private boolean estaSuscripto;
    private String origenSuscripcion;
    private String destinoSuscripcion;

    
    public Pasajero(String nombre, String apellido, String DNI, String contraseña, TarjetaCredito tarjetaCredito) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.contraseña = contraseña;
        this.tarjetaCredito = tarjetaCredito;
        this.estaSuscripto = false;
    }

    public Pasajero(){

    }

    

    public boolean isEstaSuscripto() {
        return estaSuscripto;
    }

    public String getOrigenSuscripcion() {
        return origenSuscripcion;
    }

    public String getDestinoSuscripcion() {
        return destinoSuscripcion;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getDNI() {
        return DNI;
    }

    @Override
    public String toString() {
        return "Pasajero{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", DNI='" + DNI + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", tarjetaCredito=" + tarjetaCredito +
                ", asientosSeleccionados=" + asientosSeleccionados +
                '}';
    }

    private boolean esContraseñaValida(String contraseña) {
        if (contraseña.length() < 8) {
            return false;
        }

        boolean tieneMinuscula = false;
        boolean tieneMayuscula = false;
        boolean tieneDigito = false;

        for (char c : contraseña.toCharArray()) {
            if (Character.isLowerCase(c)) {
                tieneMinuscula = true;
            } else if (Character.isUpperCase(c)) {
                tieneMayuscula = true;
            } else if (Character.isDigit(c)) {
                tieneDigito = true;
            }
        }

        return tieneMinuscula && tieneMayuscula && tieneDigito;
    }
    
    public Pasajero RegistrarPasajero(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su apellido: ");
        String apellido = scanner.nextLine();
        System.out.println("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese su DNI: ");
        String dni = scanner.nextLine();
        String contraseña;
    do {
        System.out.println("Ingrese una contraseña: ");
        contraseña = scanner.nextLine();
        if (!esContraseñaValida(contraseña)) {
            System.out.println("La contraseña no cumple con los requisitos.");
            System.out.println("Desea ingresar otra contraseña? (s/n)");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                return null;
            }
        }
    } while (!esContraseñaValida(contraseña));
      System.out.println("¿Desea asociar una tarjeta de crédito? (s/n)");
      String eleccion = scanner.nextLine();
      if (eleccion.equalsIgnoreCase("s")) {
        tarjetaCredito = new TarjetaCredito();
        tarjetaCredito = tarjetaCredito.registrarTarjetaCredito();
    }
      else tarjetaCredito = null;
    return new Pasajero(apellido, nombre, dni, contraseña, tarjetaCredito);
  }

  public void seleccionarAsiento(Asiento asiento) {
    if (asientosSeleccionados == null) {
        asientosSeleccionados = new ArrayList<>();
        asiento.setDniPasajero(this.DNI);
        asientosSeleccionados.add (asiento);
    }
    else{
        asientosSeleccionados.add(asiento);
    }
  }

  public void notificarPasajero(String nombre,String apellido){
    System.out.println("Estimado pasajero, su DNI ha sido encontrado en el sistema.");
    System.out.println("Su nombre completo es: " + nombre + " " + apellido);
  }

  public void completarCompra(SistemaDeTransporte sistemaDeTransporte) { 
     if (!asientosSeleccionados.isEmpty()) {
         for (Asiento asiento : asientosSeleccionados) {
             if (asiento.getDniPasajero() == null) {
                  Scanner scanner = new Scanner(System.in);
                  System.out.println("Ingrese dni de la persona asociada a este asiento: ");
                  String dni = scanner.nextLine();
                  String dniPasajero = dni;
                  asiento.setDniPasajero(dniPasajero);
                  if(sistemaDeTransporte.verificarPasajeroEnSistema(dniPasajero)){
                    String nombre = sistemaDeTransporte.obtenerNombrePasajeroPorDNI(asiento.getDniPasajero());
                    String apellido = sistemaDeTransporte.obtenerApellidoPasajeroPorDNI(asiento.getDniPasajero());
                    notificarPasajero(nombre,apellido);
                  }
                  else{
                    System.out.println("Ingrese su nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese su apellido: ");
                    String apellido = scanner.nextLine();
                  }
            } else {
                    String nombre = sistemaDeTransporte.obtenerNombrePasajeroPorDNI(asiento.getDniPasajero());
                    String apellido = sistemaDeTransporte.obtenerApellidoPasajeroPorDNI(asiento.getDniPasajero());
                    notificarPasajero(nombre, apellido);
                }
            }
        } else {
            System.out.println("No se han seleccionado asientos.");
        }

    if (tarjetaCredito != null) {
        System.out.println("Realizando el pago con la tarjeta de crédito asociada...");
        System.out.println("Cargando el costo del pasaje a la tarjeta...");
        System.out.println("Pago realizado");
    } else {
        TarjetaCredito tarjetaCreditoManual = new TarjetaCredito();
        tarjetaCreditoManual = tarjetaCreditoManual.registrarTarjetaCredito();
        System.out.println("Realizando el pago con la tarjeta de crédito...");
        System.out.println("Cargando el costo del pasaje a la tarjeta ...");
        System.out.println("Pago realizado");
    }

  }

  public void suscribirse(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("elija ciudad de origen:");
    this.origenSuscripcion= scanner.nextLine();
    System.out.println("elija ciudad de destino:");
    this.destinoSuscripcion= scanner.nextLine();
    this.estaSuscripto=true;
  }

}