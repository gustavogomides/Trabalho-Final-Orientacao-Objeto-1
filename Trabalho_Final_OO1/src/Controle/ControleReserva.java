package Controle;

import Modelo.*;
import Controle.*;
import java.util.*;
import java.io.*;
import java.text.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.*;
import Relatorio.*;

public class ControleReserva {

    public ArrayList<Reserva> listaReserva = new ArrayList();
    public ArrayList<Reserva> reservasCanceladas = new ArrayList<>();

    // Número de reservas
    public int numReservas() throws Exception {
        recuperaReserva();
        int tamanho = listaReserva.size();
        return tamanho;
    }

    // Número de reservas canceladas
    public int numReservasCanceladas() throws Exception {
        recuperaReservasCanceladas();
        int tamanho = reservasCanceladas.size();
        return tamanho;
    }

    // Número de reservas não pagas
    public int numReservasNaoPagas() throws Exception {
        recuperaReserva();
        int tamanho = 0;
        for (Reserva r : listaReserva) {
            if (r.getCancelada() == false) {
                if (r.getValorPago() < r.getValorTotal()) {
                    tamanho++;
                }
            }
        }
        return tamanho;
    }

    // Número de reservas a serem efetivadas no dia
    public int numReservasDia() throws Exception {
        recuperaReserva();
        int tamanho = 0;
        Date data = new Date();
        for (Reserva r : listaReserva) {
            long dif = ((r.getEntrada().getTime() - data.getTime()) / 86400000L);
            if (dif == 0) {
                tamanho++;
            }
        }
        return tamanho;

    }

    public String dadosReservasDias(int pIndex) throws Exception {
        recuperaReserva();

        int i = 0;
        String saida = "";

        for (Reserva r : listaReserva) {
            if (r.getCancelada() == true) {
                pIndex++;
            }
            if (i++ == pIndex) {
                Cliente cliente = r.getCliente();
                Quarto quarto = r.getQuarto();
                //int sub = (int) ((r.getEntrada().getTime() - r.getSaida().getTime()) / 86400000L);
                long diferenca = ((r.getSaida().getTime() - r.getEntrada().getTime()) / 86400000L);
                if (diferenca < 0) {
                    diferenca *= -1;
                }

                boolean canc = r.getCancelada();

                if (canc == false) {
                    saida = "\t         Dados da Reserva:"
                            + "\nCódigo: " + r.getCodigo()
                            + "\nData de Entrada: " + r.getEntrada()
                            + "\nData de Saida: " + r.getSaida()
                            + "\nDesconto: " + r.getDesconto() + " %"
                            + "\n\n         Dados do Cliente:"
                            + "\nNome do Cliente: " + cliente.getNome()
                            + "\nCPF: " + cliente.getCPF()
                            + "\nEndereço: " + cliente.getEndereço()
                            + "\nTelefone: " + cliente.getTelefone()
                            + "\n\n         Dados do Quarto:"
                            + "\nCódigo: " + quarto.getNumero()
                            + "\nDescrição: " + quarto.getDecricao()
                            + "\nPreço da Diária: R$ " + quarto.getPreco()
                            + "\n\nDias de Hospedagem: " + diferenca
                            + "\nValor sem Desconto: R$ " + r.getPreco()
                            + "\nVALOR TOTAL: R$ " + r.getValorTotal()
                            + "\nValor Pago: R$ " + r.getValorPago()
                            + "\n\n";
                }

            }
        }
        return saida;
    }

    // Verificar Disponibilidade de Quartos
    public boolean VerificarDisponibilidade(Date pEntrada, Date pSaida) throws ParseException, Exception {
        //numero de quartos
        ControleQuarto q = new ControleQuarto();
        int numQuartos = q.numQuartos();

        //recupera array de reservas
        this.recuperaReserva();

        //numero de reservas
        int numReservas = listaReserva.size();

        if (numReservas < numQuartos) {
            return true;
        } else {
            for (Reserva r : listaReserva) {
                if (pEntrada.before(r.getEntrada()) && pSaida.before(r.getEntrada())) {
                    return true;
                } else if (pEntrada.after(r.getSaida()) && pSaida.after(r.getSaida())) {
                    return true;
                }
            }
        }
        return false;
    }

    // Fazer Reserva
    public void FazerReserva(Date pEntrada, Date pSaida, double pDesconto, int pCodigo, Quarto pQuarto, Cliente pCliente) throws Exception {

        listaReserva.add(
                new Reserva(
                        pEntrada, pSaida, pDesconto, pCodigo, pQuarto, pCliente,
                        CalcularDesconto(pEntrada, pSaida, pDesconto, pQuarto),
                        Preco(pEntrada, pSaida, pQuarto), false, false, 0.0));
        gravaReserva();
    }

    public boolean verificaCodigos(int pCodigo) throws Exception {
        int c = 0;
        recuperaReserva();
        for (Reserva r : listaReserva) {
            if (r.getCodigo() == pCodigo) {
                c++;
            }
        }
        return c == 0;
    }

    public boolean verificaCodigo(Date pEntrada, Date pSaida, double pDesconto, int pCodigo, Quarto pQuarto, Cliente pCliente) throws Exception {
        int c = 0;
        recuperaReserva();
        for (Reserva r : listaReserva) {
            if (r.getCodigo() == pCodigo) {
                c++;
            }
        }
        if (c == 0) {
            FazerReserva(pEntrada, pSaida, pDesconto, pCodigo, pQuarto, pCliente);
            return true;
        } else {
            return false;
        }
    }

    public String[] relatorioReservasDia() throws Exception {
        recuperaReserva();
        String[] saida = new String[this.numReservasDia()];
        int i = 0;

        for (Reserva q : listaReserva) {
            saida[i++] = "Código da Reserva: " + q.getCodigo();
        }

        return saida;
    }

    // Listar Reservas
    public String[] listarReservas() throws Exception {
        recuperaReserva();

        String[] saida = new String[this.numReservas()];
        int i = 0;

        for (Reserva q : listaReserva) {
            saida[i++] = "Código da Reserva: " + q.getCodigo();
        }

        return saida;
    }

    // Dados da Reserva
    public String dadosReserva(int pIndex) throws Exception {
        recuperaReserva();

        int i = 0;
        String saida = "";

        for (Reserva r : listaReserva) {
            if (i++ == pIndex) {
                Cliente cliente = r.getCliente();
                Quarto quarto = r.getQuarto();
                //int sub = (int) ((r.getEntrada().getTime() - r.getSaida().getTime()) / 86400000L);
                long diferenca = ((r.getSaida().getTime() - r.getEntrada().getTime()) / 86400000L);
                if (diferenca < 0) {
                    diferenca *= -1;
                }
                boolean sit = r.getSituacao();
                String situacao;
                if (sit == true) {
                    situacao = "CONFIRMADA";
                } else {
                    situacao = "NÃO CONFIRMADA";
                }
                boolean canc = r.getCancelada();
                String cancelada;
                if (canc == true) {
                    cancelada = "CANCELADA";
                } else {
                    cancelada = "ATIVA";
                }
                saida = "\t         Dados da Reserva:"
                        + "\nCódigo: " + r.getCodigo()
                        + "\nData de Entrada: " + r.getEntrada()
                        + "\nData de Saida: " + r.getSaida()
                        + "\nDesconto: " + r.getDesconto() + " %"
                        + "\n\n         Dados do Cliente:"
                        + "\nNome do Cliente: " + cliente.getNome()
                        + "\nCPF: " + cliente.getCPF()
                        + "\nEndereço: " + cliente.getEndereço()
                        + "\nTelefone: " + cliente.getTelefone()
                        + "\n\n         Dados do Quarto:"
                        + "\nCódigo: " + quarto.getNumero()
                        + "\nDescrição: " + quarto.getDecricao()
                        + "\nPreço da Diária: R$ " + quarto.getPreco()
                        + "\n\nDias de Hospedagem: " + diferenca
                        + "\nValor sem Desconto: R$ " + r.getPreco()
                        + "\nVALOR TOTAL: R$ " + r.getValorTotal()
                        + "\nValor Pago: R$ " + r.getValorPago()
                        + "\n\nStatus da Reserva: " + situacao + " e " + cancelada
                        + "\n\n";

            }
        }
        return saida;
    }

    // Listar Reserva
    public String ListarReserva(int pCodigo) throws Exception {
        recuperaReserva();
        String saida = "";
        for (Reserva r : listaReserva) {
            if (r.getCodigo() == pCodigo) {
                Cliente cliente = r.getCliente();
                Quarto quarto = r.getQuarto();
                long sub = ((r.getSaida().getTime() - r.getEntrada().getTime()) / 86400000L);
                if (sub < 0) {
                    sub *= -1;
                }

                boolean sit = r.getSituacao();
                String situacao;
                if (sit == true) {
                    situacao = "CONFIRMADA";
                } else {
                    situacao = "NÃO CONFIRMADA";
                }
                boolean canc = r.getCancelada();
                String cancelada;
                if (canc == true) {
                    cancelada = "CANCELADA";
                } else {
                    cancelada = "ATIVA";
                }
                saida = "\t         Dados da Reserva:"
                        + "\nCódigo: " + r.getCodigo()
                        + "\nData de  Entrada: " + r.getEntrada()
                        + "\nData de Saida: " + r.getSaida()
                        + "\nDesconto: " + r.getDesconto() + " %"
                        + "\n\n         Dados do Cliente:"
                        + "\nNome do Cliente: " + cliente.getNome()
                        + "\nCPF: " + cliente.getCPF()
                        + "\nEndereço: " + cliente.getEndereço()
                        + "\nTelefone: " + cliente.getTelefone()
                        + "\n\n         Dados do Quarto:"
                        + "\nCódigo: " + quarto.getNumero()
                        + "\nDescrição: " + quarto.getDecricao()
                        + "\nPreço da Diária: R$ " + quarto.getPreco()
                        + "\n\nDias de Hospedagem: " + sub
                        + "\nValor sem Desconto: R$ " + r.getPreco()
                        + "\nVALOR TOTAL: R$ " + r.getValorTotal()
                        + "\nValor Pago: R$ " + r.getValorPago()
                        + "\n\nStatus da Reserva: " + situacao + " e " + cancelada
                        + "\n\n";
            }
        }
        return saida;
    }

    // Calcular Preco sem Desconto
    public double Preco(Date pEntrada, Date pSaida, Quarto pQuarto) {
        long sub = ((pSaida.getTime() - pEntrada.getTime()) / 86400000L);
        if (sub < 0) {
            sub *= -1;
        }
        return (pQuarto.getPreco() * sub);
    }

    // Calcular Preço com Desconto
    public double CalcularDesconto(Date pEntrada, Date pSaida, double pDesconto, Quarto pQuarto) {
        double valorTotal = 0;

        long sub = ((pSaida.getTime() - pEntrada.getTime()) / 86400000L);
        if (sub < 0) {
            sub *= -1;
        }
        double desconto = pDesconto / 100;
        double preco = (pQuarto.getPreco() * sub);
        valorTotal = preco - (desconto * preco);

        return valorTotal;
    }

    // Cancelar Reserva
    public void CancelarReserva() throws Exception {
        Date data = new Date();
        recuperaReserva();
        recuperaReservasCanceladas();
        for (Reserva r : listaReserva) {
            long dif = ((r.getEntrada().getTime() - data.getTime()) / 86400000L);
            if (dif < 3) {
                if (r.getValorPago() < r.getQuarto().getPreco()) {
                    r.setCancelada(true);
                    if (reservasCanceladas.isEmpty()) {
                        reservasCanceladas.add(r);
                    } else {
                        for (int i = 0; i < reservasCanceladas.size(); i++) {
                            if (r.getCodigo() != reservasCanceladas.get(i).getCodigo()) {
                                reservasCanceladas.add(r);
                            }
                        }
                    }
                    gravaReserva();
                }
            }
        }
        gravaReservasCanceladas();
    }

    // Listar Reservas Canceladas
    public String[] listarReservasCanceladas() throws Exception {
        recuperaReservasCanceladas();
        String[] saida = new String[this.numReservasCanceladas()];
        int i = 0;

        for (Reserva q : reservasCanceladas) {
            saida[i++] = "Código da Reserva: " + q.getCodigo();
        }

        return saida;
    }

    // Dados Reservas Canceladas 
    public String dadosReservaCanceladas(int pIndex) throws Exception {
        recuperaReservasCanceladas();

        int i = 0;
        String saida = "";

        for (Reserva r : reservasCanceladas) {
            if (i++ == pIndex) {
                Cliente cliente = r.getCliente();
                Quarto quarto = r.getQuarto();

                long diferenca = ((r.getSaida().getTime() - r.getEntrada().getTime()) / 86400000L);
                if (diferenca < 0) {
                    diferenca *= -1;
                }

                boolean canc = r.getCancelada();
                String cancelada;
                if (canc == true) {
                    cancelada = "CANCELADA";
                } else {
                    cancelada = "ATIVA";
                }
                saida = "\t         Dados da Reserva:"
                        + "\nCódigo: " + r.getCodigo()
                        + "\nData de Entrada: " + r.getEntrada()
                        + "\nData de Saida: " + r.getSaida()
                        + "\nDesconto: " + r.getDesconto() + " %"
                        + "\n\n         Dados do Cliente:"
                        + "\nNome do Cliente: " + cliente.getNome()
                        + "\nCPF: " + cliente.getCPF()
                        + "\nEndereço: " + cliente.getEndereço()
                        + "\nTelefone: " + cliente.getTelefone()
                        + "\n\n         Dados do Quarto:"
                        + "\nCódigo: " + quarto.getNumero()
                        + "\nDescrição: " + quarto.getDecricao()
                        + "\nPreço da Diária: R$ " + quarto.getPreco()
                        + "\n\nDias de Hospedagem: " + diferenca
                        + "\nValor sem Desconto: R$ " + r.getPreco()
                        + "\nVALOR TOTAL: R$ " + r.getValorTotal()
                        + "\nValor Pago: R$ " + r.getValorPago()
                        + "\n\nStatus da Reserva: " + cancelada
                        + "\n\n";

            }
        }
        return saida;
    }

    // Dados das Reservas Não Pagas
    public String dadosReservasNaoPagas(int pIndex) throws Exception {
        recuperaReserva();

        int i = 0;
        String saida = "";

        for (Reserva r : listaReserva) {
            if (r.getCancelada() == true) {
                pIndex++;
            }
            if (i++ == pIndex) {
                Cliente cliente = r.getCliente();
                Quarto quarto = r.getQuarto();
                //int sub = (int) ((r.getEntrada().getTime() - r.getSaida().getTime()) / 86400000L);
                long diferenca = ((r.getSaida().getTime() - r.getEntrada().getTime()) / 86400000L);
                if (diferenca < 0) {
                    diferenca *= -1;
                }

                boolean canc = r.getCancelada();

                if (canc == false) {
                    saida = "\t         Dados da Reserva:"
                            + "\nCódigo: " + r.getCodigo()
                            + "\nData de Entrada: " + r.getEntrada()
                            + "\nData de Saida: " + r.getSaida()
                            + "\nDesconto: " + r.getDesconto() + " %"
                            + "\n\n         Dados do Cliente:"
                            + "\nNome do Cliente: " + cliente.getNome()
                            + "\nCPF: " + cliente.getCPF()
                            + "\nEndereço: " + cliente.getEndereço()
                            + "\nTelefone: " + cliente.getTelefone()
                            + "\n\n         Dados do Quarto:"
                            + "\nCódigo: " + quarto.getNumero()
                            + "\nDescrição: " + quarto.getDecricao()
                            + "\nPreço da Diária: R$ " + quarto.getPreco()
                            + "\n\nDias de Hospedagem: " + diferenca
                            + "\nValor sem Desconto: R$ " + r.getPreco()
                            + "\nVALOR TOTAL: R$ " + r.getValorTotal()
                            + "\nValor Pago: R$ " + r.getValorPago()
                            + "\n\n";
                }

            }
        }
        return saida;
    }

    // Selecionar Reserva
    public Reserva selecionarReserva(int pCodigo) throws Exception {
        recuperaReserva();
        Reserva reserva = null;
        for (int i = 0; i < listaReserva.size(); i++) {
            if (((Reserva) listaReserva.get(i)).getCodigo() == pCodigo) {
                reserva = (Reserva) listaReserva.get(i);
            }
        }
        return reserva;
    }

    // Atualizar Valor Pago na Reserva
    public void atualizarValorPago(int pCodigo, double pValorPago) throws Exception {
        recuperaReserva();
        for (Reserva r : listaReserva) {
            if (r.getCodigo() == pCodigo) {
                double valor = r.getValorPago();
                r.setValorPago(pValorPago + valor);
            }
        }
        gravaReserva();
    }

    // Realizar CheckOut
    public void realizarCheckOut(int pCodigo) throws Exception {
        recuperaReserva();
        for (Reserva r : listaReserva) {
            if (r.getCodigo() == pCodigo) {
                listaReserva.remove(r);
                gravaReserva();
            }
        }
    }

    // Alterar Situação Pagamento Diária Reserva
    public void situacaoPagamentoDiariaReserva(int pCodigo) throws Exception {
        recuperaReserva();
        for (Reserva r : listaReserva) {
            if (r.getCodigo() == pCodigo) {
                r.setSituacao(true);
                gravaReserva();
            }
        }
    }

    // Serializar Dados Reservas Canceladas
    public void gravaReservasCanceladas() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream("ReservaCancelada.txt");
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(reservasCanceladas);
        objOS.flush();
        objOS.close();
    }

    // Recuperar Dados Reservas Canceladas
    public void recuperaReservasCanceladas() throws Exception {
        File objFile = new File("ReservaCancelada.txt");
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream("ReservaCancelada.txt");
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            reservasCanceladas = (ArrayList) objIS.readObject();
            objIS.close();
        }
    }

    //Relatorio Reservas Canceladas
    public String relatorioReservasCanceladas() throws JRException, Exception {

        recuperaReservasCanceladas();
        String saida = "Gerando relatório...";

        List modelo = new ArrayList();

        for (int i = 0; i < reservasCanceladas.size(); i++) {

            String valorTotal = String.valueOf(reservasCanceladas.get(i).getValorTotal());
            String desconto = String.valueOf(reservasCanceladas.get(i).getDesconto());
            String quarto = String.valueOf(reservasCanceladas.get(i).getQuarto().getNumero());
            String situacao = String.valueOf(reservasCanceladas.get(i).getSituacao());
            String cpf = reservasCanceladas.get(i).getCliente().getCPF();
            String nome = reservasCanceladas.get(i).getCliente().getNome();

            modelo.add(new modeloRR(nome, cpf, quarto, valorTotal, desconto, reservasCanceladas.get(i).getEntrada().toString(), reservasCanceladas.get(i).getSaida().toString()));

        }
        // Nome do arquivo com a base na data do sistema
        Date data = new Date();
        String nomeArquivo = "relatorio_reservas_Canceladas_" + data.getTime() + ".pdf";
        // lista com os nossos clientes 
        // compilacao do JRXML 
        JasperReport report = JasperCompileManager.compileReport("relatorio_RC.jrxml");

        // JRBeanCollectionDataSource 
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(modelo));

        // exportacao do relatorio para outro formato, no caso PDF 
        JasperExportManager.exportReportToPdfFile(print, nomeArquivo);
        saida += "\nRelatório gerado.";
        return saida;
    }

    //Relatorio Reservas Não Pagas
    public String relatorioReservasNaoPagas() throws JRException, Exception {

        recuperaReserva();
        String saida = "Gerando relatório...";

        List modeloNP = new ArrayList();

        for (int i = 0; i < listaReserva.size(); i++) {
            if (listaReserva.get(i).getCancelada() == false) {
                if (listaReserva.get(i).getValorPago() < listaReserva.get(i).getValorTotal()) {
                    String valorTotal = String.valueOf(listaReserva.get(i).getValorTotal());
                    String desconto = String.valueOf(listaReserva.get(i).getDesconto());
                    String quarto = String.valueOf(listaReserva.get(i).getQuarto().getNumero());
                    String cpf = listaReserva.get(i).getCliente().getCPF();
                    String nome = listaReserva.get(i).getCliente().getNome();

                    modeloNP.add(new modeloRR(nome, cpf, quarto, valorTotal, desconto, listaReserva.get(i).getEntrada().toString(), listaReserva.get(i).getSaida().toString()));
                }
            }
        }
        // Nome do arquivo com a base na data do sistema
        Date data = new Date();
        String nomeArquivo = "relatorio_NaoPagas_" + data.getTime() + ".pdf";
        System.out.println(nomeArquivo);
        // lista com os nossos clientes 
        // compilacao do JRXML 
        JasperReport report = JasperCompileManager.compileReport("relatorio_NP.jrxml");

        // JRBeanCollectionDataSource 
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(modeloNP));

        // exportacao do relatorio para outro formato, no caso PDF 
        JasperExportManager.exportReportToPdfFile(print, nomeArquivo);
        saida += "\nRelatório gerado.";
        return saida;
    }

    //Relatorio Reservas a serem efetivadas no dia
    public String relatorioReservasDias() throws JRException, Exception {
        recuperaReserva();
        String saida = "Gerando relatório...";

        List modeloRD = new ArrayList();
        Date data = new Date();

        for (int i = 0; i < listaReserva.size(); i++) {
            long diff = ((data.getTime() - listaReserva.get(i).getEntrada().getTime()) / 86400000L);
            if (diff < 0) {
                diff *= -1;
            }
            if (diff == 0) {
                String valorTotal = String.valueOf(listaReserva.get(i).getValorTotal());
                String desconto = String.valueOf(listaReserva.get(i).getDesconto());
                String quarto = String.valueOf(listaReserva.get(i).getQuarto().getNumero());
                String cpf = listaReserva.get(i).getCliente().getCPF();
                String nome = listaReserva.get(i).getCliente().getNome();

                modeloRD.add(new modeloRR(nome, cpf, quarto, valorTotal, desconto, listaReserva.get(i).getEntrada().toString(), listaReserva.get(i).getSaida().toString()));
            }
        }
        // Nome do arquivo com a base na data do sistema

        String nomeArquivo = "relatorio_Reservas_Dias_" + data.getTime() + ".pdf";
        System.out.println(nomeArquivo);
        // lista com os nossos clientes 
        // compilacao do JRXML 
        JasperReport report = JasperCompileManager.compileReport("relatorio_RD.jrxml");

        // JRBeanCollectionDataSource 
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(modeloRD));

        // exportacao do relatorio para outro formato, no caso PDF 
        JasperExportManager.exportReportToPdfFile(print, nomeArquivo);
        saida += "\nRelatório gerado.";
        return saida;

    }

    //Relatorio Reservas a serem efetivadas no dia
    public String relatorioReservasPeriodo(Date pEntrada, Date pSaida) throws JRException, Exception {
        recuperaReserva();
        String saida = "Gerando relatório...";

        List modeloRP = new ArrayList();
        Date data = new Date();

        for (int i = 0; i < listaReserva.size(); i++) {
            long entradaReserva = listaReserva.get(i).getEntrada().getTime();
            long saidaReserva = listaReserva.get(i).getSaida().getTime();

            long dataInicial = pEntrada.getTime();
            long dataFinal = pSaida.getTime();

            if (entradaReserva >= dataInicial && saidaReserva <= dataFinal) {
                String valorTotal = String.valueOf(listaReserva.get(i).getValorTotal());
                String desconto = String.valueOf(listaReserva.get(i).getDesconto());
                String quarto = String.valueOf(listaReserva.get(i).getQuarto().getNumero());
                String cpf = listaReserva.get(i).getCliente().getCPF();
                String nome = listaReserva.get(i).getCliente().getNome();

                modeloRP.add(new modeloRR(nome, cpf, quarto, valorTotal, desconto, listaReserva.get(i).getEntrada().toString(), listaReserva.get(i).getSaida().toString()));
            }
        }
        // Nome do arquivo com a base na data do sistema

        String nomeArquivo = "relatorio_Reservas_Periodo_" + data.getTime() + ".pdf";
        System.out.println(nomeArquivo);
        // lista com os nossos clientes 
        // compilacao do JRXML 
        JasperReport report = JasperCompileManager.compileReport("relatorio_RP.jrxml");

        // JRBeanCollectionDataSource 
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(modeloRP));

        // exportacao do relatorio para outro formato, no caso PDF 
        JasperExportManager.exportReportToPdfFile(print, nomeArquivo);
        saida += "\nRelatório gerado.";
        return saida;

    }

    // Serializar Reserva
    public void gravaReserva() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream("Reserva.txt");
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(listaReserva);
        objOS.flush();
        objOS.close();
    }

    // Desserializar Reserva
    public void recuperaReserva() throws Exception {
        File objFile = new File("Reserva.txt");
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream("Reserva.txt");
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            listaReserva = (ArrayList) objIS.readObject();
            objIS.close();
        }
    }

}
