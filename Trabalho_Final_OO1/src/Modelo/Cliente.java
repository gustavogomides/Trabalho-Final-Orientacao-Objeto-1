package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable {

    private String aNome;
    private String aEndereço;
    private String aTelefone;
    private String aCPF;
    private ArrayList<Reserva> reservas = new ArrayList<>();

    public Cliente(String pNome, String pEndereço, String pTelefone, String pCPF) {
        setNome(pNome);
        setEndereço(pEndereço);
        setTelefone(pTelefone);
        setCPF(pCPF);
    }

    public void setCPF(String pCPF) {
        aCPF = pCPF;
    }

    public void setNome(String pNome) {
        aNome = pNome;
    }

    public void setEndereço(String pEndereço) {
        aEndereço = pEndereço;
    }

    public void setTelefone(String pTelefone) {
        aTelefone = pTelefone;
    }

    public void setReservas(ArrayList<Reserva> pReservas) {
        reservas = pReservas;
    }

    public String getCPF() {
        return aCPF;
    }

    public String getNome() {
        return aNome;
    }

    public String getEndereço() {
        return aEndereço;
    }

    public String getTelefone() {
        return aTelefone;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }
}
