package clases;

import java.util.Scanner;

public class TarjetaCredito {
    private String numeroTarjeta;
    private String bancoEmisor;
    private String marcaTarjeta;


    public TarjetaCredito(String numeroTarjeta, String bancoEmisor, String marcaTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
        this.bancoEmisor = bancoEmisor;
        this.marcaTarjeta = marcaTarjeta;
    }


    @Override
    public String toString() {
        return "TarjetaCredito{" +
                "numeroTarjeta='" + numeroTarjeta + '\'' +
                ", bancoEmisor='" + bancoEmisor + '\'' +
                ", marcaTarjeta='" + marcaTarjeta + '\'' +
                '}';
    }

    public TarjetaCredito() {
    }



    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }



    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }



    public String getBancoEmisor() {
        return bancoEmisor;
    }



    public void setBancoEmisor(String bancoEmisor) {
        this.bancoEmisor = bancoEmisor;
    }



    public String getMarcaTarjeta() {
        return marcaTarjeta;
    }



    public void setMarcaTarjeta(String marcaTarjeta) {
        this.marcaTarjeta = marcaTarjeta;
    }



    public TarjetaCredito registrarTarjetaCredito() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el número de tarjeta de crédito: ");
        String numeroTarjeta = scanner.nextLine();
        System.out.println("Ingrese el banco emisor: ");
        String bancoEmisor = scanner.nextLine();
        System.out.println("Ingrese la marca de la tarjeta de crédito: ");
        String marcaTarjeta = scanner.nextLine();
        return new TarjetaCredito(numeroTarjeta, bancoEmisor, marcaTarjeta);
    }


}