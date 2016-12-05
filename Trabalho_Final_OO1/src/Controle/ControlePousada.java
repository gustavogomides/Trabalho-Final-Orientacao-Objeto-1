package Controle;

import Modelo.*;
import Visao.LimitePousada;
import java.text.*;
import net.sf.jasperreports.engine.JRException;

public class ControlePousada {

    private LimitePousada objCLimitePousada;
    private ControleCliente objCtrCliente;
    private ControleGerente objCtrGerente;
    private ControleQuarto objCtrQuarto;
    private ControleReserva objCtrReserva;
    private ControlePagamento objCtrPagamento;

    /*     CONSTRUTOR     */
    public ControlePousada() throws Exception {
        objCLimitePousada = new LimitePousada(this);

        try {
            objCtrCliente = new ControleCliente();
            objCtrGerente = new ControleGerente();
            objCtrQuarto = new ControleQuarto();
            objCtrReserva = new ControleReserva();
            objCtrPagamento = new ControlePagamento();
        } catch (Exception e) {
            System.out.println("Erro na abertura de arquivo");
        }
    }

    /*     GERENTE     */
    // Cadastrar Gerente
    public void cadGerente(String pRegistro, String pSenha) throws Exception {
        objCtrGerente.cadastrarGerente(pRegistro, pSenha); // Chama o método de cadastrar Gerente no controle do Gerente
    }

    // Verificar Login
    public boolean verificaLogin(String pRegistro, String pSenha) throws Exception {
        return objCtrGerente.verificarLogin(pRegistro, pSenha); // Chama o método de verificar login no controle do Gerente
    }

    // Remover Gerente
    public boolean remGerente(String pRegistro) throws Exception {
        return objCtrGerente.removerGerente(pRegistro); // Chama o método de remover Gerente no controle do Gerente
    }

    // Lista todos os Gerentes cadastrados no sistema
    public String[] listaGerentes() throws Exception {
        return objCtrGerente.listarGerentes();
    }

    // Dados do Gerente
    public String dadoGerentes(int pIndex) throws Exception {
        return objCtrGerente.dadosGerente(pIndex);
    }

    // Mostra as informações de um gerente a partir de seu registro
    public String consultarGerente(String pRegistro) throws Exception {
        return objCtrGerente.consultarGerente(pRegistro);
    }

    /*     QUARTO     */
    // Cadastrar Quarto
    public void cadQuarto(double pPreco, String pDescricao, int pNumero) throws Exception {
        objCtrQuarto.cadastrarQuarto(pPreco, pDescricao, pNumero); // Chama o método de cadastrar Quarto no controle do Quarto
    }

    // Lista todos os Quartos cadastrados no sistema
    public String[] listaQuartos() throws Exception {
        return objCtrQuarto.listarQuartos();
    }

    // Lista todos os Quartos Numeros
    public String[] listaQuartosNumeros() throws Exception {
        return objCtrQuarto.listarQuartosNumeros();
    }

    // Dados do Quarto
    public String dadoQuartos(int pIndex) throws Exception {
        return objCtrQuarto.dadosQuarto(pIndex);
    }

    // Dados do Quarto Numero
    public Quarto dadoQuartosNumero(int pIndex) throws Exception {
        return objCtrQuarto.dadosQuartoNumero(pIndex);
    }

    // Mostra as informações de um quarto a partir de seu número
    public String consultarQuarto(int pNumero) throws Exception {
        return objCtrQuarto.consultarQuarto(pNumero);
    }

    // Remover Quarto
    public boolean remQuarto(int pNumero) throws Exception {
        return objCtrQuarto.removerQuarto(pNumero); // Chama o método de remover Quarto no controle do Quarto
    }

    // Verificar Quarto Codigo
    public boolean verificarQuarto(int pNumero) throws Exception {
        return objCtrQuarto.verificarQuarto(pNumero);
    }

    // Alterar Quarto
    public void altQuarto(int pNumero, double pPreco, String pDescricao) throws Exception {
        objCtrQuarto.alterarQuarto(pNumero, pPreco, pDescricao);
    }

    // Selecionar Quarto
    public Quarto selQuarto(int pNumero) throws Exception {
        return objCtrQuarto.selecionarQuarto(pNumero);
    }

    /*     CLIENTE     */
    // Cadastrar Cliente
    public boolean cadCliente(String pNome, String pEndereço, String pTelefone, String pCPF) throws Exception {
        return objCtrCliente.cadastrarCliente(pNome, pEndereço, pTelefone, pCPF); // Chama o método de cadastrar Cliente no controle do Cliente
    }

    // Lista todos os Clientes cadastrados no sistema
    public String[] listaClientes() throws Exception {
        return objCtrCliente.listarClientes();
    }

    // Lista todos os CPFs cadastrados no sistema
    public String[] listaCPFs() throws Exception {
        return objCtrCliente.listarCPFs();
    }

    // Dados do Cliente
    public String dadoClientes(int pIndex) throws Exception {
        return objCtrCliente.dadosCliente(pIndex);
    }

    // Dados do Cliente
    public Cliente dadoClientesCPF(int pIndex) throws Exception {
        return objCtrCliente.dadosClienteCPF(pIndex);
    }

    // Mostra as informações de um cliente a partir de seu CPF
    public String consultarCliente(String pCPF) throws Exception {
        return objCtrCliente.consultarCliente(pCPF);
    }

    // Alterar Cliente
    public boolean altCliente(String pNome, String pEndereço, String pTelefone, String pCPF) throws Exception {
        return objCtrCliente.alterarCliente(pNome, pEndereço, pTelefone, pCPF);
    }

    // Remover Cliente
    public boolean remCliente(String pCPF) throws Exception {
        return objCtrCliente.removerCliente(pCPF); // Chama o método de remover Cliente no controle do Cliente
    }

    // Consultar CPF cliente
    public boolean consCPF(String pCPF) throws Exception {
        return objCtrCliente.consultarCPF(pCPF);
    }

    // Selecionar Cliente
    public Cliente selCliente(String pCPF) throws Exception {
        return objCtrCliente.selecionarCliente(pCPF);
    }

    /*     RESERVA     */
    // Verificar Disponibilidade Quartos
    public boolean verificaQuartos(String pEntrada, String pSaida) throws ParseException, Exception {
        DateFormat f = DateFormat.getDateInstance();
        return objCtrReserva.VerificarDisponibilidade(f.parse(pEntrada), f.parse(pSaida));
    }

    // Realizar Reserva
    public boolean realizarReserva(String pEntrada, String pSaida, double pDesconto, int pCodigo, Quarto pQuarto, Cliente pCliente) throws Exception {
        DateFormat f = DateFormat.getDateInstance();

        return objCtrReserva.verificaCodigo(f.parse(pEntrada), f.parse(pSaida), pDesconto, pCodigo, pQuarto, pCliente);
    }

    // Verifica Código Reservas
    public boolean verificaCodigo(int pCodigo) throws Exception {
        return objCtrReserva.verificaCodigos(pCodigo);
    }

    // Lista todos as Reservas cadastrados no sistema
    public String[] listaReservas() throws Exception {
        return objCtrReserva.listarReservas();
    }

    // Dados da Reserva
    public String dadoReservas(int pIndex) throws Exception {
        return objCtrReserva.dadosReserva(pIndex);
    }

    // Lista todos as Reservas a serem efetivadas no dia
    public String[] listaReservasDias() throws Exception {
        return objCtrReserva.relatorioReservasDia();
    }

    // Dados da Reserva a serem efetivadas no dia
    public String dadoReservasDias(int pIndex) throws Exception {
        return objCtrReserva.dadosReservasDias(pIndex);
    }

    // Consultar Reserva
    public String consultarReserva(int pCodigo) throws Exception {
        return objCtrReserva.ListarReserva(pCodigo);
    }

    // Selecionar Reserva
    public Reserva selReserva(int pCodigo) throws Exception {
        return objCtrReserva.selecionarReserva(pCodigo);
    }

    // Realizar Check-out Reserva
    public void realizarCheckOutReserva(int pCodigo) throws Exception {
        objCtrReserva.realizarCheckOut(pCodigo);
    }

    // Situação Pagamento Reserva
    public void sitPagReserva(int pCodigo) throws Exception {
        objCtrReserva.situacaoPagamentoDiariaReserva(pCodigo);
    }

    // Verificar tempo de expiração reserva
    public void cancelarReserva() throws Exception {
        objCtrReserva.CancelarReserva();
    }

    // Atualizar Valor Pago Reserva
    public void atualizaReservaValorPago(int pCodigo, double pValorPago) throws Exception {
        objCtrReserva.atualizarValorPago(pCodigo, pValorPago);
    }

    // Lista todos as Reservas canceladas 
    public String[] listaReservasCanceladas() throws Exception {
        return objCtrReserva.listarReservasCanceladas();
    }

    // Dados da Reserva Canceladas
    public String dadoReservasCanceladas(int pIndex) throws Exception {
        return objCtrReserva.dadosReservaCanceladas(pIndex);
    }

    /*     PAGAMENTO     */
    // Cadastrar Pagamento
    public void pagDiaria(double pValorTotal, Reserva reserva, double pValorPago) throws Exception {
        objCtrPagamento.pagarDiaria(pValorTotal, reserva, pValorPago);
    }

    // Restante do Pagamento
    public double restPagamento(int pReserva) throws Exception {
        return objCtrPagamento.restantePagamento(pReserva);
    }

    // Valor Pago
    public double valorPago(int pReserva) throws Exception {
        return objCtrPagamento.valorPago(pReserva);
    }

    // Verificar Pagamento
    public String verificarPagamentoDiaria(int pReserva) throws Exception {
        return objCtrPagamento.verificarPagamentoDiaria(pReserva);
    }

    // Realizar Pagamento Restante
    public void realizarPagamento(int pReserva, double pValor) throws Exception {
        objCtrPagamento.realizarPagamentoRestante(pReserva, pValor);
    }

    // Pagamento Check-out
    public int check_out(int pReserva) throws Exception {
        return objCtrPagamento.check_out(pReserva);
    }
    
    /*     RELATÓRIO     */
    // Relatório de reservas canceladas
    public String relatorioCanceladas() throws JRException, Exception{
        return objCtrReserva.relatorioReservasCanceladas();
    }
    
    // Relatório de reservas não pagas
    public String relatorioNaoPagas() throws JRException, Exception{
        return objCtrReserva.relatorioReservasNaoPagas();
    }

    // Relatório das reservas a serem efetivadas no dia
    public String relatorioReservasDias() throws JRException, Exception{
        return objCtrReserva.relatorioReservasDias();
    }
    
    // Relatório das reservas periodo
    public String relatorioReservasPeriodo(String pEntrada, String pSaida) throws JRException, Exception{
        DateFormat f = DateFormat.getDateInstance();
        return objCtrReserva.relatorioReservasPeriodo(f.parse(pEntrada), f.parse(pSaida));
    }
    
    /*     MAIN     */
    public static void main(String[] args) throws Exception {
        new ControlePousada();
    }
}
