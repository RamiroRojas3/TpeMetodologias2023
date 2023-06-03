package clases;

public class Asiento {
    private int numeroAsiento;
    private String dniPasajero;
    
    
    public Asiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }


    public int getNumeroAsiento() {
        return numeroAsiento;
    }


    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }


    public String getDniPasajero() {
        return dniPasajero;
    }


    public void setDniPasajero(String dniPasajero) {
        this.dniPasajero = dniPasajero;
    }

    

    
}
