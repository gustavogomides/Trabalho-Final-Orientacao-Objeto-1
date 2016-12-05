package Controle;

import Modelo.Gerente;
import java.io.*;
import java.util.*;

public class ControleGerente {

    private ArrayList<Gerente> listaGerente = new ArrayList();

    public int numGerentes() throws Exception {
        this.recuperaGerente();
        return (int) listaGerente.size();
    }

    // Cadastrar Gerente
    public void cadastrarGerente(String pRegistro, String pSenha) throws Exception {
        listaGerente.add(new Gerente(pRegistro, pSenha));
        gravaGerente();
    }

    // Verificar Login
    public boolean verificarLogin(String pRegistro, String pSenha) throws Exception {
        recuperaGerente();
        int contador = 0;

        for (int indice = 0; indice < listaGerente.size(); indice++) {
            if (((Gerente) listaGerente.get(indice)).getRegistro().equals(pRegistro)
                    && ((Gerente) listaGerente.get(indice)).getSenha().equals(pSenha)) {
                contador++;
            }
        }

        return contador != 0;
    }

    // Remover Gerente
    public boolean removerGerente(String pRegistro) throws Exception {
        boolean retorno = false;
        for (int indice = 0; indice < listaGerente.size(); indice++) {
            if (((Gerente) listaGerente.get(indice)).getRegistro().equals(pRegistro)) {
                listaGerente.remove(indice);
                gravaGerente();
                retorno = true;
            }
        }
        return retorno;
    }

    public String[] listarGerentes() throws Exception {
        recuperaGerente();

        String[] saida = new String[this.numGerentes()];
        int i = 0;

        for (Gerente q : listaGerente) {
            saida[i++] = "Registro: " + q.getRegistro();
        }

        return saida;
    }

    public String dadosGerente(int pIndex) throws Exception {
        recuperaGerente();

        int i = 0;
        String saida = "";

        for (Gerente g : listaGerente) {
            if (i++ == pIndex) {
                saida = "Registro: " + g.getRegistro() + "\nSenha: " + g.getSenha() + "\n\n";
            }
        }
        return saida;
    }

    public String consultarGerente(String pRegistro) throws Exception {
        recuperaGerente();
        String saida = "";
        for (Gerente g : listaGerente) {
            if (g.getRegistro().equals(pRegistro)) {
                saida += "Registro: " + g.getRegistro() + "\nSenha: " + g.getSenha() + "\n";
            }
        }
        return saida;
    }

    // Serializar Dados Gerente
    public void gravaGerente() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream("Gerente.txt");
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(listaGerente);
        objOS.flush();
        objOS.close();
    }

    // Recuperar Dados Gerente
    public void recuperaGerente() throws Exception {
        File objFile = new File("Gerente.txt");
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream("Gerente.txt");
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            listaGerente = (ArrayList) objIS.readObject();
            objIS.close();
        }
    }

}
