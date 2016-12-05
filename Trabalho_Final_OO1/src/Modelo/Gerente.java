package Modelo;

import java.io.Serializable;

public class Gerente implements Serializable {

    private String aRegistro;
    private String aSenha;

    public Gerente(String pRegistro, String pSenha) {
        setRegistro(pRegistro);
        setSenha(pSenha);
    }

    public void setRegistro(String pRegistro) {
        aRegistro = pRegistro;
    }

    public void setSenha(String pSenha) {
        aSenha = pSenha;
    }

    public String getRegistro() {
        return aRegistro;
    }

    public String getSenha() {
        return aSenha;
    }

}
