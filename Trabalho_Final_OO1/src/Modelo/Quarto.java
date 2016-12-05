package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Quarto implements Serializable {

    private double aPreco;
    private String aDecricao;
    private int aNumero;

    public Quarto(double pPreco, String pDescricao, int pNumero) {
        setPreco(pPreco);
        setDecricao(pDescricao);
        setNumero(pNumero);
    }

    public void setPreco(double pPreco) {
        aPreco = pPreco;
    }

    public void setDecricao(String pDecricao) {
        aDecricao = pDecricao;
    }

    public void setNumero(int pNumero) {
        aNumero = pNumero;
    }

    public double getPreco() {
        return aPreco;
    }

    public String getDecricao() {
        return aDecricao;
    }

    public int getNumero() {
        return aNumero;
    }

}
