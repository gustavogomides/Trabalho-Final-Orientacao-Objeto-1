package Controle;

import Modelo.Cliente;
import java.io.*;
import java.util.*;

public class ControleCliente {

    private ArrayList<Cliente> listaCliente = new ArrayList();

    public int numClientes() throws Exception {
        this.recuperaCliente();
        return (int) listaCliente.size();
    }

    public boolean cadastrarCliente(String pNome, String pEndereço, String pTelefone, String pCPF) throws Exception {
        boolean retorno = false;
        boolean consCPF = consultarCPF(pCPF);
        if (consCPF == true) {
            retorno = false;
        } else {
            listaCliente.add(new Cliente(pNome, pEndereço, pTelefone, pCPF));
            gravaCliente();
            retorno = true;
        }
        return retorno;
    }

    public String[] listarClientes() throws Exception {
        recuperaCliente();

        String[] saida = new String[this.numClientes()];
        int i = 0;

        for (Cliente q : listaCliente) {
            saida[i++] = "CPF: " + q.getCPF();
        }

        return saida;
    }

    public String[] listarCPFs() throws Exception {
        recuperaCliente();

        String[] saida = new String[this.numClientes()];
        int i = 0;

        for (Cliente q : listaCliente) {
            saida[i++] = q.getCPF();
        }

        return saida;
    }

    public String dadosCliente(int pIndex) throws Exception {
        recuperaCliente();

        int i = 0;
        String saida = "";

        for (Cliente c : listaCliente) {
            if (i++ == pIndex) {
                saida = "Nome: " + c.getNome() + "\nEndereço: " + c.getEndereço()
                        + "\nCPF: " + c.getCPF() + "\nTelefone: " + c.getTelefone() + "\n\n";
            }
        }
        return saida;
    }

    public Cliente dadosClienteCPF(int pIndex) throws Exception {
        recuperaCliente();
        Cliente cliente = null;
        int i = 0;

        for (Cliente c : listaCliente) {
            if (i++ == pIndex) {
                cliente = c;
            }
        }
        return cliente;
    }

    // Consultar Cliente
    public String consultarCliente(String pCPF) throws Exception {
        recuperaCliente();
        String saida = "";
        for (Cliente c : listaCliente) {
            if (c.getCPF().equals(pCPF)) {
                saida += "Nome: " + c.getNome() + "\nEndereço: " + c.getEndereço()
                        + "\nCPF: " + c.getCPF() + "\nTelefone: " + c.getTelefone() + "\n";
            }
        }
        return saida;
    }

    // Selecionar Cliente
    public Cliente selecionarCliente(String pCPF) throws Exception {
        recuperaCliente();
        Cliente cliente = null;
        for (int i = 0; i < listaCliente.size(); i++) {
            if (((Cliente) listaCliente.get(i)).getCPF().equals(pCPF)) {
                cliente = (Cliente) listaCliente.get(i);
            }
        }
        return cliente;
    }

    // Remover Cliente
    public boolean removerCliente(String pCPF) throws Exception {
        boolean retorno = false;
        for (int indice = 0; indice < listaCliente.size(); indice++) {
            if (((Cliente) listaCliente.get(indice)).getCPF().equals(pCPF)) {
                listaCliente.remove(indice);
                gravaCliente();
                retorno = true;
            }
        }
        return retorno;
    }

    // Altera Cliente
    public boolean alterarCliente(String pNome, String pEndereço, String pTelefone, String pCPF) throws Exception {
        boolean retorno = false;
        recuperaCliente();
        for (int indice = 0; indice < listaCliente.size(); indice++) {
            if ((((Cliente) listaCliente.get(indice)).getCPF().equals(pCPF))) {
                ((Cliente) listaCliente.get(indice)).setNome(pNome);
                ((Cliente) listaCliente.get(indice)).setEndereço(pEndereço);
                ((Cliente) listaCliente.get(indice)).setTelefone(pTelefone);
                gravaCliente();
                retorno = true;
            }
        }
        return retorno;
    }

    public boolean consultarCPF(String pCPF) throws Exception {
        recuperaCliente();
        boolean retorno = false;
        for (Cliente c : listaCliente) {
            if (c.getCPF().equals(pCPF)) {
                retorno = true;
            }
        }
        return retorno;
    }

    public void gravaCliente() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream("Cliente.txt");
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(listaCliente);
        objOS.flush();
        objOS.close();
    }

    public void recuperaCliente() throws Exception {
        File objFile = new File("Cliente.txt");
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream("Cliente.txt");
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            listaCliente = (ArrayList) objIS.readObject();
            objIS.close();
        }
    }
}
