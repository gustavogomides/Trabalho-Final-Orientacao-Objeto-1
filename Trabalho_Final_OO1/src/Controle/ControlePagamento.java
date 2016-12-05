package Controle;

import Modelo.*;
import java.util.*;
import java.io.*;

public class ControlePagamento {

    public ArrayList<Pagamento> listaPagamento = new ArrayList<>();

    // Cadastrar Pagamento Diaria
    public void pagarDiaria(double pValorTotal, Reserva reserva, double pValorPago) throws Exception {
        listaPagamento.add(new Pagamento(
                atualizaValorTotal(pValorTotal, reserva, pValorPago),
                reserva, true, pValorPago));

        gravaPagamento();
    }

    // Atualiza Valor Restante do Pagamento
    public double atualizaValorTotal(double pValorTotal, Reserva reserva, double pValorPago) {
        return pValorTotal - pValorPago;
    }

    // Valor Pago
    public double valorPago(int pReserva) throws Exception {
        recuperaPagamento();
        double valor = 0.0;
        for (Pagamento p : listaPagamento) {
            if (p.getReserva().getCodigo() == pReserva) {
                valor = p.getValorPago();
            }
        }
        return valor;
    }

    // Valor Restante do Pagamento
    public double restantePagamento(int pReserva) throws Exception {
        recuperaPagamento();
        double valor = 0.0;
        for (Pagamento p : listaPagamento) {
            if (p.getReserva().getCodigo() == pReserva) {
                valor = p.getValorTotal();
            }
        }
        return valor;
    }

    // Realizar Pagamento Restante
    public void realizarPagamentoRestante(int pReserva, double pValor) throws Exception {
        recuperaPagamento();
        for (int i = 0; i < listaPagamento.size(); i++) {
            if (listaPagamento.get(i).getReserva().getCodigo() == pReserva) {
                double valorAntigo = listaPagamento.get(i).getValorTotal();
                double valorNovo = valorAntigo - pValor;
                double valorPagoAntigo = listaPagamento.get(i).getValorPago();
                double valorPagoNovo = valorPagoAntigo + pValor;
                if (valorNovo > 0 && valorPagoNovo < listaPagamento.get(i).getReserva().getPreco()) {
                    listaPagamento.get(i).setValorTotal(valorNovo);
                    listaPagamento.get(i).setValorPago(valorPagoNovo);
                } else {
                    listaPagamento.get(i).setValorTotal(0);
                    listaPagamento.get(i).setValorPago(listaPagamento.get(i).getReserva().getValorTotal());
                }
            }
        }
        gravaPagamento();
    }

    // Verificar Pagamento Diária
    public String verificarPagamentoDiaria(int pReserva) throws Exception {
        recuperaPagamento();
        String saida = "";
        for (Pagamento p : listaPagamento) {
            if (p.getReserva().getCodigo() == pReserva) {
                if (p.getSituacao() == false) {
                    saida += "Valor Pago: R$ " + p.getValorPago()
                            + "\nSituação: Não Paga" + "\n";
                } else {
                    saida += "Valor Pago: R$ " + p.getValorPago()
                            + "\nSituação: Paga" + "\n";
                }

            }
        }
        return saida;
    }

    // Pagamento para Chek-out
    public int check_out(int pReserva) throws Exception {
        recuperaPagamento();
        ControleReserva reserva = new ControleReserva();
        reserva.recuperaReserva();
        int contador = 0;
        double valor = valorPago(pReserva);
        for (Pagamento p : listaPagamento) {
            if (p.getReserva().getCodigo() == pReserva) {
                if (p.getValorPago() == valor) {
                    listaPagamento.remove(p);
                    reserva.realizarCheckOut(pReserva);
                    gravaPagamento();
                    reserva.gravaReserva();
                    contador++;
                }
            }

        }

        return contador;
    }

    // Serializar Dados Pagamento
    public void gravaPagamento() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream("Pagamento.txt");
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(listaPagamento);
        objOS.flush();
        objOS.close();
    }

    // Recuperar Dados Pagamento
    public void recuperaPagamento() throws Exception {
        File objFile = new File("Pagamento.txt");
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream("Pagamento.txt");
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            listaPagamento = (ArrayList) objIS.readObject();
            objIS.close();
        }
    }

}
