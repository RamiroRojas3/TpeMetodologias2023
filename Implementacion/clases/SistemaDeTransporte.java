package clases;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class SistemaDeTransporte {
    private List<Pasajero> pasajeros;

    public SistemaDeTransporte() {
        pasajeros = new ArrayList<>();
    }

    public void aniadirPasajero(Pasajero pasajero) {
        pasajeros.add(pasajero);
    }

    public boolean verificarPasajeroEnSistema(String dni){
        for (Pasajero pasajero : pasajeros){
            if (pasajero.getDNI().equals(dni)){
                return true;
            }
        }
        return false;
    }

    public boolean verificarContraseña(String contraseña){
        for (Pasajero pasajero : pasajeros){
            if (pasajero.getContraseña().equals(contraseña)){
                return true;
            }
        }
        return false;
    }

    public String obtenerNombrePasajeroPorDNI(String dni) {
        for (Pasajero pasajero : pasajeros) {
            if (pasajero.getDNI().equals(dni)) {
                return pasajero.getNombre();
            }
        }
        return null; 
    }

    public String obtenerApellidoPasajeroPorDNI(String dni) {
        for (Pasajero pasajero : pasajeros) {
            if (pasajero.getDNI().equals(dni)) {
                return pasajero.getApellido();
            }
        }
        return null; 
    }
    
    public void mostrarListaPasajeros(){
        for (Pasajero p:pasajeros)
        {
            System.out.println(p);
        }
    }
    
}