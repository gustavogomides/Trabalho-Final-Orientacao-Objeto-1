package Controle;

import Modelo.Quarto;
import java.io.*;
import java.util.*;

public class ControleQuarto {

    private ArrayList<Quarto> listaQuarto = new ArrayList();

    // Número de quartos no ArrayList listaQuarto
    public int numQuartos() throws Exception {
        this.recuperaQuarto();
        return (int) listaQuarto.size();
    }

    // Cadastrar Quarto
    public void cadastrarQuarto(double pPreco, String pDescricao, int pNumero) throws Exception {
        listaQuarto.add(new Quarto(pPreco, pDescricao, pNumero));
        gravaQuarto();
    }

    public boolean verificarQuarto(int pNumero) throws Exception{
        boolean retorno = false;
        recuperaQuarto();
        for(Quarto q: listaQuarto){
            if(q.getNumero() == pNumero){
                retorno = true;
            }
        }
        return retorno;
    }
    
    // Listar Quartos
    public String[] listarQuartos() throws Exception {
        recuperaQuarto();

        String[] saida = new String[this.numQuartos()];
        int i = 0;

        for (Quarto q : listaQuarto) {
            saida[i++] = "Quarto número: " + q.getNumero();
        }

        return saida;
    }

    // Listar Quartos Numeros
    public String[] listarQuartosNumeros() throws Exception {
        recuperaQuarto();

        String[] saida = new String[this.numQuartos()];
        int i = 0;

        for (Quarto q : listaQuarto) {
            saida[i++] = String.valueOf(q.getNumero());
        }

        return saida;
    }

    // Dados do Quarto
    public String dadosQuarto(int pIndex) throws Exception {
        recuperaQuarto();

        int i = 0;
        String saida = "";

        for (Quarto q : listaQuarto) {
            if (i++ == pIndex) {
                saida = "Número do Quarto: " + q.getNumero() + "\n"
                        + "Preço do Quarto: " + q.getPreco() + "\n"
                        + "Descrição do Quarto: " + q.getDecricao();

            }
        }
        return saida;
    }

    // Dados do Quarto Numero
    public Quarto dadosQuartoNumero(int pIndex) throws Exception {
        recuperaQuarto();

        int i = 0;
        Quarto quarto = null;

        for (Quarto q : listaQuarto) {
            if (i++ == pIndex) {
                quarto = q;
            }
        }
        return quarto;
    }

    // Consultar Quarto
    public String consultarQuarto(int pNumero) throws Exception {
        recuperaQuarto();
        String saida = "";
        for (Quarto q : listaQuarto) {
            if (q.getNumero() == (pNumero)) {
                saida += "Número: " + q.getNumero()
                        + "\nDescrição: " + q.getDecricao() + "\nPreço: R$ " + q.getPreco() + "\n";
            }
        }
        return saida;
    }

    // Remover Quarto
    public boolean removerQuarto(int pNumero) throws Exception {
        boolean retorno = false;
        for (int indice = 0; indice < listaQuarto.size(); indice++) {
            if (((Quarto) listaQuarto.get(indice)).getNumero() == pNumero) {
                listaQuarto.remove(indice);
                gravaQuarto();
                retorno = true;
            }
        }
        return retorno;
    }

    // Altera Quarto
    public void alterarQuarto(int pNumero, double pPreco, String pDescricao) throws Exception {
        recuperaQuarto();
        for (int indice = 0; indice < listaQuarto.size(); indice++) {
            if ((((Quarto) listaQuarto.get(indice)).getNumero() == pNumero)) {

                ((Quarto) listaQuarto.get(indice)).setPreco(pPreco);
                ((Quarto) listaQuarto.get(indice)).setDecricao(pDescricao);
                gravaQuarto();
            }
        }
    }

    // Selecionar Quarto
    public Quarto selecionarQuarto(int pNumero) throws Exception {
        recuperaQuarto();
        Quarto quarto = null;
        for (int i = 0; i < listaQuarto.size(); i++) {
            if (((Quarto) listaQuarto.get(i)).getNumero() == pNumero) {
                quarto = (Quarto) listaQuarto.get(i);
            }
        }
        return quarto;
    }

    // Serializar Quarto
    public void gravaQuarto() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream("Quarto.txt");
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(listaQuarto);
        objOS.flush();
        objOS.close();
    }

    // Desserializar Quarto
    public void recuperaQuarto() throws Exception {
        File objFile = new File("Quarto.txt");
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream("Quarto.txt");
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            listaQuarto = (ArrayList) objIS.readObject();
            objIS.close();
        }
    }
}
