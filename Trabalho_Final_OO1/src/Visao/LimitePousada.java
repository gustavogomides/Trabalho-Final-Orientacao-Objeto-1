package Visao;

import Controle.*;
import Modelo.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.event.*;

public class LimitePousada {

    // Controle Pousada
    private ControlePousada ctrPousada;
    private Cliente cliente;
    private Quarto quarto;
    private Reserva reserva;

    //JLabel
    private JLabel labelRegistroGerente, NovoLabelRegistroGerente, labelNomeCliente, labelTelefoneCliente, labelNumeroQuarto, labelNumeroQuartoAlterar, labelNomeClienteAlterar, labelTelefoneClienteAlterar, labelBackground;
    private JLabel labelSenhaGerente, NovoLabelSenhaGerente, labelEnderecoCliente, labelEnderecoClienteAlterar, labelPrecoQuarto, labelDescricao, labelPrecoQuartoAlterar, labelDescricaoAlterar;
    private JLabel labelDataEntrada, labelDataSaida, labelCPFCliente, labelCPFClienteAlterar, EscolhaGerente, EscolhaReserva, RGRegistroGerente, EscolhaQuarto, EscolhaRelatorio;
    private JLabel EscolhaCliente, labelCPFRemocao, labelCPFConsulta, labelCPFAlterar, labelNumeroRemocao, labelNumeroConsulta, labelPagamento, labelValorPago;
    private JLabel labelNumeroAlterar, NumQuartoAlterar, CPFalterar, labelDesconto, EscolhaPagamento, labelNumeroReservaVQ, labelClienteReserva, labelDescricaoQuarto, labelQPreco;
    private JLabel labelCliente, labelCPF, labelNum, labelQuarto, labelNumReserva, NovoLabelReservaPagamento, NovoLabelValorPagamento, labelPreco, labelValorPagar;
    private JLabel labelEntrada, labelSaida, labelCodigo, labelClienteNome, labelClienteCPF, labelQuartoNumero, labelQuartoPreco, labelValorDesconto, labelValorPagamento;

    // JTextField
    private JTextField textRegistroGerente, NovoTextRegistroGerente, textNomeCliente, textNomeClienteAlterar, textTelefoneCliente, textTelefoneClienteAlterar, textDataEntrada, textRegistroConsulta;
    private JTextField textEnderecoCliente, textEnderecoClienteAlterar, textNumQuarto, textPrecoQuarto, textPrecoQuartoAlterar, textDataSaida, textCPFCliente;
    private JTextField textCPFRemocao, textCPFConsulta, textCPFAlterar, textNumeroRemocao, textNumeroConsulta, textNumeroAlterar, textDesconto, textValorPago;
    private JTextField textCPF, textNum, textNumReserva, NovoTextValorPagamento, NovoTextReservaPagamento, textReservaConsultaVQ;
    private JTextField textEntrada, textSaida, textCodigo, textClienteNome, textClienteCPF, textQuartoNumero, textQuartoPreco, textValorDesconto, textPreco, textValorPagamento;
    private JTextField textValorPagar, textNum2, textNomeClienteReserva, textDescricaoQuarto, textCodigoReserva;

    // JPasswordField
    private JPasswordField SenhaGerente, NovoSenhaGerente;

    // JButton
    private JButton b1, b2, botaoCliente, botaoReserva, botaoQuarto, botaoGerente, botaoAdicionarGerente, botaoRemoverGerente, botaoListarGerentes, botaoListarGerente, botaoConsultaGerente, botaoRelatorio, botaoSair;
    private JButton botaoRemoverG, botaoAdicionarQuarto, botaoRemoverQuarto, botaoConsultarQuarto, botaoAlterarQuarto, botaoListarQuartos, botaoVerificarCodigoReserva;
    private JButton botaoRemoverCliente, botaoConsultarCliente, botaoAlterarCliente, botaoRemoverQuarto2, botaoListarCliente;
    private JButton botaoRemoverCliente2, botaoConsultarCliente2, botaoAlterarCliente2, botaoConsultarQuarto2, botaoAlterarQuarto2, botaoRelatorioPeriodo;
    private JButton botaoVerificaQuartos, botaoFazerReserva, botaoListarReservas, botaoListarReserva, botaoVerificarReservaCancelada;
    private JButton bCliente, bQuarto, botaoRegistrarPagamento, botaoVerificarPagamentoDiaria, botaoPagamento, botaoRegistrarPagamento2;
    private JButton botaoVerificarPagamento2, botaoConsultReserva, bPagamento, botaoRealizarPagamentoDiaria, botaoVerificarPagamento, botaoCheckOut;
    private JButton botaoRelatorioReservasCanceladas, botaoRelatoioReservasNaoPagas, botaoRelatorioReservasdia, botaoRelatorioReservaPeriodo;

    // JPanel
    private JPanel iconPanel, acaoPanel, panelPrincipal;

    // JFrame
    private JFrame framePrincipal;

    // JTextArea
    private JTextArea textAreaQuartoDescricao, textAreaQuartoDescricaoAlterar;

    // JList
    private JList lstQuarto, lstCliente, lstGerente, lstReserva, lstCPF, lstNumeroQuartos;

    public LimitePousada(ControlePousada objPControlePousada) {
        ctrPousada = objPControlePousada;
        Login();
    }

    /*     LOGIN     */
    private void Login() {
        //Frame Login
        framePrincipal = new JFrame();

        //Criando panelPrincipal e ajustando  GridBag
        panelPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.insets = new Insets(5, 0, 5, 5);

        gbc1.gridx = 1;
        gbc1.gridy = 1;
        labelBackground = new JLabel(new ImageIcon("src\\Imagens\\logo_login.jpg"));
        panelPrincipal.add(labelBackground, gbc1);

        //criando labelRegistroGerente e adicionando para o panel
        gbc1.gridx = 0;
        gbc1.gridy = 4;
        labelRegistroGerente = new JLabel("Registro: ");
        panelPrincipal.add(labelRegistroGerente, gbc1);

        //criando textRegistroGerente,posicionamento e adicionado ao panel
        textRegistroGerente = new JTextField(20);
        textRegistroGerente.setHorizontalAlignment(textRegistroGerente.CENTER);
        gbc1.gridy = 4;
        gbc1.gridx = 1;
        panelPrincipal.add(textRegistroGerente, gbc1);

        //criando labelSenhaGerentee adicionando para o panel
        labelSenhaGerente = new JLabel("Senha: ");
        gbc1.gridx = 0;
        gbc1.gridy = 5;
        panelPrincipal.add(labelSenhaGerente, gbc1);

        //criando SenhaGerente ,posicionamento e adicionado ao panel
        SenhaGerente = new JPasswordField(20);
        SenhaGerente.setHorizontalAlignment(SenhaGerente.CENTER);
        gbc1.gridx = 1;
        gbc1.gridy = 5;
        panelPrincipal.add(SenhaGerente, gbc1);

        //Botão confirmar Login
        b1 = new JButton("Confirmar  ");
        gbc1.gridx = 1;
        gbc1.gridy = 6;
        panelPrincipal.add(b1, gbc1);
        //adicionar ActionListener
        b1.addActionListener(e -> {
            if (textRegistroGerente.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor preencha os campos!");
            } else {
                try {
                    //verificando o login
                    boolean verifica;
                    verifica = ctrPousada.verificaLogin(textRegistroGerente.getText(), SenhaGerente.getText());
                    if (verifica == true) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Bem-Vindo ao Sistema de Reservas da Pousada do Parque!",
                                "Pousada do Parque - Um presente da natureza para você!",
                                JOptionPane.INFORMATION_MESSAGE);
                        JanelaPrincipal();
                    } else {
                        JOptionPane.showMessageDialog(null, "Gerente não cadastrado no sistema!" + "\n" + "Tente Novamente!");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro na leitura do arquivo dos Gerentes!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //Setando as cores
        panelPrincipal.setBackground(new Color(0, 67, 68));

        labelRegistroGerente.setFont(new Font("SansSerif", Font.BOLD, 14));
        labelRegistroGerente.setForeground(Color.WHITE);

        labelSenhaGerente.setFont(new Font("SansSerif", Font.BOLD, 14));
        labelSenhaGerente.setForeground(Color.WHITE);

        textRegistroGerente.setFont(new Font("SansSerif", Font.TRUETYPE_FONT, 14));
        SenhaGerente.setFont(new Font("SansSerif", Font.TRUETYPE_FONT, 14));

        textRegistroGerente.setPreferredSize(new Dimension(350, 30));
        SenhaGerente.setPreferredSize(new Dimension(350, 30));

        b1.setBackground(new Color(183, 221, 120));
        b1.setFont(new Font("SansSerif", Font.BOLD, 15));

        //adicionando o panel no frame
        framePrincipal.add(panelPrincipal);
        framePrincipal.setSize(600, 500);
        //Frame aparecer centralizado
        framePrincipal.setLocationRelativeTo(null);
        framePrincipal.setVisible(true);
        framePrincipal.setResizable(false);
        framePrincipal.setDefaultCloseOperation(framePrincipal.EXIT_ON_CLOSE);
        framePrincipal.setTitle("Login ");

    }

    /*     JANELA PRINCIPAL     */
    private void JanelaPrincipal() {
        //removendo elementos do panel princípal
        panelPrincipal.removeAll();
        //o panel principal é mudado
        panelPrincipal.setLayout(new BorderLayout());

        //Panel acao
        acaoPanel = new JPanel(new GridBagLayout());
        acaoPanel.setBackground(new Color(0, 67, 68));

        //Logo na página principal
        JLabel logo = new JLabel(new ImageIcon("src\\Imagens\\LogoGrande.jpg"));
        acaoPanel.add(logo);

        panelPrincipal.add(acaoPanel, BorderLayout.CENTER);

        //Icon panel
        iconPanel = new JPanel(new GridBagLayout());
        iconPanel.setBackground(new Color(0, 67, 68));
        panelPrincipal.add(iconPanel, BorderLayout.PAGE_START);
        //ajustando  GridBag
        GridBagConstraints gbcpp = new GridBagConstraints();
        gbcpp.insets = new Insets(5, 10, 5, 10);

        //botao Cliente
        gbcpp.gridx = 0;
        gbcpp.gridy = 0;
        Icon icone1 = new ImageIcon("src\\Imagens\\7824_64x64.png");
        botaoCliente = new JButton("CLIENTE", icone1);
        botaoCliente.setBackground(new Color(183, 221, 120));
        iconPanel.add(botaoCliente, gbcpp);
        gbcpp.gridx = 0;
        gbcpp.gridy = 1;
        botaoCliente.addActionListener(a -> {
            acaoPanel.removeAll();
            EscolhaCliente();
        });

        //botao Reserva
        gbcpp.gridx = 1;
        gbcpp.gridy = 0;
        Icon icone2 = new ImageIcon("src\\Imagens\\Calendario.png");
        botaoReserva = new JButton("RESERVA", icone2);
        botaoReserva.setBackground(new Color(183, 221, 120));
        iconPanel.add(botaoReserva, gbcpp);
        gbcpp.gridx = 1;
        gbcpp.gridy = 1;
        botaoReserva.addActionListener(a -> {
            acaoPanel.removeAll();
            EscolhaReserva();
        });

        //botao Quarto
        gbcpp.gridx = 2;
        gbcpp.gridy = 0;
        Icon icone3 = new ImageIcon("src\\Imagens\\quarto.png");
        botaoQuarto = new JButton("QUARTO", icone3);
        botaoQuarto.setBackground(new Color(183, 221, 120));
        iconPanel.add(botaoQuarto, gbcpp);
        botaoQuarto.addActionListener(b -> {
            acaoPanel.removeAll();
            EscolhaQuarto();
        });
        gbcpp.gridx = 2;
        gbcpp.gridy = 1;

        //Botao Gerente
        gbcpp.gridx = 3;
        gbcpp.gridy = 0;
        Icon icone4 = new ImageIcon("src\\Imagens\\gerente.png");
        botaoGerente = new JButton("GERENTE", icone4);
        botaoGerente.setBackground(new Color(183, 221, 120));
        iconPanel.add(botaoGerente, gbcpp);
        botaoGerente.addActionListener(a -> {
            EscolhaGerente();
        });
        gbcpp.gridx = 3;
        gbcpp.gridy = 1;

        //botao relatório
        gbcpp.gridx = 4;
        gbcpp.gridy = 0;
        Icon icone6 = new ImageIcon("src\\Imagens\\relatorio.png");
        botaoRelatorio = new JButton("RELATÓRIO", icone6);
        botaoRelatorio.setBackground(new Color(183, 221, 120));
        iconPanel.add(botaoRelatorio, gbcpp);
        gbcpp.gridx = 4;
        gbcpp.gridy = 1;
        botaoRelatorio.addActionListener(a -> {
            acaoPanel.removeAll();
            EscolhaRelatorio();
        });

        //botao Pagamento
        gbcpp.gridx = 5;
        gbcpp.gridy = 0;
        Icon icone5 = new ImageIcon("src\\Imagens\\iconPagamentos.png");
        botaoPagamento = new JButton("PAGAMENTO", icone5);
        botaoPagamento.setBackground(new Color(183, 221, 120));
        iconPanel.add(botaoPagamento, gbcpp);
        gbcpp.gridx = 5;
        gbcpp.gridy = 1;
        botaoPagamento.addActionListener(a -> {
            EscolhaPagamento();
        });

        //botao Sair
        gbcpp.gridx = 6;
        gbcpp.gridy = 0;
        Icon icone7 = new ImageIcon("src\\Imagens\\sair.png");
        botaoSair = new JButton("SAIR", icone7);
        botaoSair.setBackground(new Color(183, 221, 120));
        iconPanel.add(botaoSair, gbcpp);
        gbcpp.gridx = 5;
        gbcpp.gridy = 1;
        botaoSair.addActionListener(a -> {
            JOptionPane.showMessageDialog(
                    null,
                    "Pousada do Parque - Um presente da natureza para você!",
                    "Obrigado!",
                    JOptionPane.INFORMATION_MESSAGE);
            //Ação para fechar o frame
            framePrincipal.dispose();
        });

        //frame
        framePrincipal.setResizable(true);
        framePrincipal.setExtendedState(framePrincipal.MAXIMIZED_BOTH);
        framePrincipal.setTitle("Pousada do Parque - Um presente da natureza para você!");
    }

    /*     CLIENTE     */
    private void EscolhaCliente() {
        //limpar frame
        acaoPanel.removeAll();
        acaoPanel.setBackground(new Color(238, 238, 238));

        //Panel -> escolha
        //ajustando  GridBag
        GridBagConstraints gbcEscolhaCliente = new GridBagConstraints();
        gbcEscolhaCliente.insets = new Insets(5, 5, 5, 5);

        //criando label EscolhaCliente
        gbcEscolhaCliente.gridx = 0;
        gbcEscolhaCliente.gridy = 0;
        EscolhaCliente = new JLabel("Escolha a opção desejada:");
        EscolhaCliente.setFont(new Font("Calibri", Font.PLAIN, 40));
        //adicionar o label no panel
        acaoPanel.add(EscolhaCliente, gbcEscolhaCliente);

        //Criar botão Remover cliente
        gbcEscolhaCliente.gridx = 0;
        gbcEscolhaCliente.gridy = 1;
        botaoRemoverCliente = new JButton("Remover Cliente");
        botaoRemoverCliente.setBackground(new Color(183, 221, 120));
        botaoRemoverCliente.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoRemoverCliente.setPreferredSize(new Dimension(250, 30));
        botaoRemoverCliente.addActionListener(b -> {
            acaoPanel.removeAll();
            RemoverCliente();
        });
        //adicinar botao
        acaoPanel.add(botaoRemoverCliente, gbcEscolhaCliente);

        //Criar botão Consultar Cliente
        gbcEscolhaCliente.gridx = 0;
        gbcEscolhaCliente.gridy = 2;
        botaoConsultarCliente = new JButton("Consultar Cliente");
        botaoConsultarCliente.setBackground(new Color(183, 221, 120));
        botaoConsultarCliente.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoConsultarCliente.setPreferredSize(new Dimension(250, 30));
        botaoConsultarCliente.addActionListener(b -> {
            acaoPanel.removeAll();
            ConsultarCliente();
        });
        //adicinar botao
        acaoPanel.add(botaoConsultarCliente, gbcEscolhaCliente);

        //Criar botão Listar Clientes
        gbcEscolhaCliente.gridx = 0;
        gbcEscolhaCliente.gridy = 3;
        botaoListarCliente = new JButton("Listar Clientes");
        botaoListarCliente.setBackground(new Color(183, 221, 120));
        botaoListarCliente.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoListarCliente.setPreferredSize(new Dimension(250, 30));
        botaoListarCliente.addActionListener(b -> {
            acaoPanel.removeAll();
            try {
                ListarClientes();
                // volta para a tela EscolhaCliente
                EscolhaCliente();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro!");
                // volta para a tela EscolhaCliente
                EscolhaCliente();
            }
        });
        //adicinar botao
        acaoPanel.add(botaoListarCliente, gbcEscolhaCliente);

        //Criar botão Alterar cliente
        gbcEscolhaCliente.gridx = 0;
        gbcEscolhaCliente.gridy = 4;
        botaoAlterarCliente = new JButton("Alterar Cliente");
        botaoAlterarCliente.setBackground(new Color(183, 221, 120));
        botaoAlterarCliente.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoAlterarCliente.setPreferredSize(new Dimension(250, 30));
        botaoAlterarCliente.addActionListener(b -> {
            acaoPanel.removeAll();
            EscolheCPFCliente();
        });
        //adicinar botao
        acaoPanel.add(botaoAlterarCliente, gbcEscolhaCliente);

        //Clean
        acaoPanel.validate();
        acaoPanel.repaint();
        framePrincipal.validate();

        framePrincipal.setTitle("Cliente ");

    }

    private void RegistrarCliente(String pCPF) {
        //limpar frame
        acaoPanel.removeAll();

        //ajustando  GridBag
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.insets = new Insets(5, 5, 5, 5);

        //criando labelNomeCliente e adicionando para o panel
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        labelNomeCliente = new JLabel("Nome: ");
        labelNomeCliente.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelNomeCliente, gbc2);

        //criando textNomeCliente,posicionamento e adicionado ao panel
        textNomeCliente = new JTextField(20);
        textNomeCliente.setHorizontalAlignment(textNomeCliente.CENTER);
        labelNomeCliente.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        gbc2.gridy = 0;
        gbc2.gridx = 1;
        acaoPanel.add(textNomeCliente, gbc2);

        //criando labelEndereçoCliente e adicionando para o panel
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        labelEnderecoCliente = new JLabel("Endereço: ");
        labelEnderecoCliente.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelEnderecoCliente, gbc2);

        //criando  textEndereçoCliente,posicionamento e adicionado ao panel
        textEnderecoCliente = new JTextField(20);
        textEnderecoCliente.setHorizontalAlignment(textEnderecoCliente.CENTER);
        textEnderecoCliente.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        gbc2.gridy = 1;
        gbc2.gridx = 1;
        acaoPanel.add(textEnderecoCliente, gbc2);

        //criando labeltelefoneCliente e adicionando para o panel
        gbc2.gridx = 0;
        gbc2.gridy = 2;
        labelTelefoneCliente = new JLabel("Telefone: ");
        labelTelefoneCliente.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelTelefoneCliente, gbc2);

        //criando textTelefoneCliente,posicionamento e adicionado ao panel
        textTelefoneCliente = new JTextField(20);
        textTelefoneCliente.setHorizontalAlignment(textTelefoneCliente.CENTER);
        textTelefoneCliente.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        gbc2.gridy = 2;
        gbc2.gridx = 1;
        acaoPanel.add(textTelefoneCliente, gbc2);

        //criando labelCPFCliente adicionando para o panel
        gbc2.gridx = 0;
        gbc2.gridy = 3;
        labelCPFCliente = new JLabel("CPF : ");
        labelCPFCliente.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelCPFCliente, gbc2);

        //criando textCPFCliente ,posicionamento e adicionado ao panel
        textCPFCliente = new JTextField(20);
        textCPFCliente.setHorizontalAlignment(textCPFCliente.CENTER);
        textCPFCliente.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textCPFCliente.setEditable(false);
        textCPFCliente.setText(pCPF);
        gbc2.gridy = 3;
        gbc2.gridx = 1;
        acaoPanel.add(textCPFCliente, gbc2);

        //Botão cadastrar cliente
        b2 = new JButton("Cadastrar  Cliente");
        gbc2.gridx = 1;
        gbc2.gridy = 4;
        acaoPanel.add(b2, gbc2);
        b2.setBackground(new Color(183, 221, 120));
        b2.setFont(new Font("SansSerif", Font.BOLD, 15));
        b2.addActionListener(a -> {
            try {
                boolean retorno = ctrPousada.cadCliente(textNomeCliente.getText(),
                        textEnderecoCliente.getText(),
                        textTelefoneCliente.getText(),
                        pCPF);
                if (retorno == true) {
                    JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                    // volta para a tela EscolhaCliente
                    EscolhaReserva();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Já existe Cliente cadastrado com sucesso de CPF "
                            + textCPFCliente.getText());
                    EscolhaReserva();
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro!");
                // volta para a tela EscolhaCliente
                EscolhaReserva();
            }

        });

        //update
        acaoPanel.validate();
        acaoPanel.repaint();
        framePrincipal.validate();
        framePrincipal.setTitle("Cadastrar Cliente ");
    }

    private void RemoverCliente() {
        //limpar frame
        acaoPanel.removeAll();

        //ajustando  GridBag
        GridBagConstraints gbcClienteRemocao = new GridBagConstraints();
        gbcClienteRemocao.insets = new Insets(5, 5, 5, 5);

        //criando labelCPFRemocao
        gbcClienteRemocao.gridx = 0;
        gbcClienteRemocao.gridy = 0;
        labelCPFRemocao = new JLabel("CPF: ");
        labelCPFRemocao.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelCPFRemocao, gbcClienteRemocao);

        //criando textfield para digitar o CPF
        textCPFRemocao = new JTextField(20);
        textCPFRemocao.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textCPFRemocao.setHorizontalAlignment(textCPFRemocao.CENTER);
        gbcClienteRemocao.gridy = 0;
        gbcClienteRemocao.gridx = 1;
        acaoPanel.add(textCPFRemocao, gbcClienteRemocao);

        //Criar botaoRemoverCliente2
        gbcClienteRemocao.gridx = 1;
        gbcClienteRemocao.gridy = 2;
        botaoRemoverCliente2 = new JButton("Remover Cliente");
        botaoRemoverCliente2.setBackground(new Color(183, 221, 120));
        botaoRemoverCliente2.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoRemoverCliente2.addActionListener(b -> {
            //Ação
            try {
                boolean retorno = ctrPousada.remCliente(textCPFRemocao.getText());
                if (retorno == true) {
                    JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
                    // volta para a tela EscolhaCliente
                    EscolhaCliente();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Cliente não foi removido  - não existe cliente de "
                            + "CPF " + textCPFRemocao.getText());
                    // volta para a tela EscolhaCliente
                    EscolhaCliente();
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro!" + "\n" + "Cliente não foi removido!");
                // volta para a tela EscolhaCliente
                EscolhaCliente();
            }
        });
        acaoPanel.add(botaoRemoverCliente2, gbcClienteRemocao);

        //update
        acaoPanel.validate();
        acaoPanel.repaint();
        framePrincipal.validate();
        framePrincipal.setTitle("Remover Cliente ");
    }

    private void ConsultarCliente() {
        //limpar frame
        acaoPanel.removeAll();

        //ajustando  GridBag
        GridBagConstraints gbcClienteConsultar = new GridBagConstraints();
        gbcClienteConsultar.insets = new Insets(5, 5, 5, 5);

        //criando labelCPFConsulta
        gbcClienteConsultar.gridx = 0;
        gbcClienteConsultar.gridy = 0;
        labelCPFConsulta = new JLabel("CPF: ");
        labelCPFConsulta.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelCPFConsulta, gbcClienteConsultar);

        //criando textfield para digitar o CPF
        textCPFConsulta = new JTextField(20);
        textCPFConsulta.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textCPFConsulta.setHorizontalAlignment(textCPFConsulta.CENTER);
        gbcClienteConsultar.gridy = 0;
        gbcClienteConsultar.gridx = 1;
        acaoPanel.add(textCPFConsulta, gbcClienteConsultar);

        //Criar botaoConsultarCliente
        gbcClienteConsultar.gridx = 1;
        gbcClienteConsultar.gridy = 2;
        botaoConsultarCliente2 = new JButton("Consultar Cliente");
        botaoConsultarCliente2.setBackground(new Color(183, 221, 120));
        botaoConsultarCliente2.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoConsultarCliente2.addActionListener(b -> {
            //Ação
            try {
                String cliente = ctrPousada.consultarCliente(textCPFConsulta.getText());
                if (cliente.equals("")) {
                    JOptionPane.showMessageDialog(null,
                            "Não existe cliente com CPF "
                            + textCPFConsulta.getText());
                    // volta para a tela EscolhaCliente
                    EscolhaCliente();
                } else {
                    JOptionPane.showMessageDialog(null, cliente);
                    // volta para a tela EscolhaCliente
                    EscolhaCliente();
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro!");
                // volta para a tela EscolhaCliente
                EscolhaCliente();
            }
        });
        acaoPanel.add(botaoConsultarCliente2, gbcClienteConsultar);

        //update
        acaoPanel.validate();
        acaoPanel.repaint();
        framePrincipal.validate();
        framePrincipal.setTitle("Consultar Cliente ");
    }

    private void EscolheCPFCliente() {
        //limpar frame
        acaoPanel.removeAll();

        //ajustando  GridBag
        GridBagConstraints gbcClienteAlterar = new GridBagConstraints();
        gbcClienteAlterar.insets = new Insets(5, 5, 5, 5);

        //criando label CPF
        gbcClienteAlterar.gridx = 0;
        gbcClienteAlterar.gridy = 0;
        labelCPFAlterar = new JLabel("CPF: ");
        labelCPFAlterar.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelCPFAlterar, gbcClienteAlterar);

        //criando textfield para digitar o CPF
        textCPFAlterar = new JTextField(20);
        textCPFAlterar.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textCPFAlterar.setHorizontalAlignment(textCPFAlterar.CENTER);
        gbcClienteAlterar.gridy = 0;
        gbcClienteAlterar.gridx = 1;
        acaoPanel.add(textCPFAlterar, gbcClienteAlterar);

        //Criar botaoAlterarCliente2
        gbcClienteAlterar.gridx = 1;
        gbcClienteAlterar.gridy = 2;
        botaoAlterarCliente2 = new JButton("Alterar Cliente");
        botaoAlterarCliente2.setBackground(new Color(183, 221, 120));
        botaoAlterarCliente2.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoAlterarCliente2.addActionListener(b -> {
            //Ação

            try {
                boolean retorno = ctrPousada.consCPF(textCPFAlterar.getText());
                if (retorno == true) {
                    AlterCliente(textCPFAlterar.getText());
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Não existe cliente com CPF "
                            + textCPFAlterar.getText());
                    EscolhaCliente();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "ERRO! ");
                EscolhaCliente();
            }

        });
        acaoPanel.add(botaoAlterarCliente2, gbcClienteAlterar);

        //update
        acaoPanel.validate();
        acaoPanel.repaint();
        framePrincipal.validate();
        framePrincipal.setTitle("Alterar Cliente ");
    }

    private void AlterCliente(String pCPF) {
        //limpar frame
        acaoPanel.removeAll();

        //ajustando  GridBag
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.insets = new Insets(5, 5, 5, 5);

        //criando labelCPFCliente adicionando para o panel
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        labelCPFClienteAlterar = new JLabel("CPF: ");
        labelCPFClienteAlterar.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelCPFClienteAlterar, gbc2);

        gbc2.gridy = 0;
        gbc2.gridx = 1;
        CPFalterar = new JLabel(pCPF);
        CPFalterar.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(CPFalterar, gbc2);

        //criando labelNomeClienteAlterar e adicionando para o panel
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        labelNomeClienteAlterar = new JLabel("Nome: ");
        labelNomeClienteAlterar.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelNomeClienteAlterar, gbc2);

        //criando textNomeClienteAlterar,posicionamento e adicionado ao panel
        textNomeClienteAlterar = new JTextField(20);
        textNomeClienteAlterar.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textNomeClienteAlterar.setHorizontalAlignment(textNomeClienteAlterar.CENTER);
        gbc2.gridy = 1;
        gbc2.gridx = 1;
        acaoPanel.add(textNomeClienteAlterar, gbc2);

        //criando labelEndereçoClienteAlterar e adicionando para o panel
        gbc2.gridx = 0;
        gbc2.gridy = 2;
        labelEnderecoClienteAlterar = new JLabel("Endereço: ");
        labelEnderecoClienteAlterar.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelEnderecoClienteAlterar, gbc2);

        //criando textEndereçoClienteAlterar,posicionamento e adicionado ao panel
        textEnderecoClienteAlterar = new JTextField(20);
        textEnderecoClienteAlterar.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textEnderecoClienteAlterar.setHorizontalAlignment(textEnderecoClienteAlterar.CENTER);
        gbc2.gridy = 2;
        gbc2.gridx = 1;
        acaoPanel.add(textEnderecoClienteAlterar, gbc2);

        //criando  labelTelefoneClienteAlterar e adicionando para o panel
        gbc2.gridx = 0;
        gbc2.gridy = 3;
        labelTelefoneClienteAlterar = new JLabel("Telefone: ");
        labelTelefoneClienteAlterar.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelTelefoneClienteAlterar, gbc2);

        //criando textTelefoneClienteAlterar,posicionamento e adicionado ao panel
        textTelefoneClienteAlterar = new JTextField(20);
        textTelefoneClienteAlterar.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textTelefoneClienteAlterar.setHorizontalAlignment(textTelefoneClienteAlterar.CENTER);
        gbc2.gridy = 3;
        gbc2.gridx = 1;
        acaoPanel.add(textTelefoneClienteAlterar, gbc2);

        //Botão alterar cliente
        b2 = new JButton("Alterar  Cliente");
        b2.setBackground(new Color(183, 221, 120));
        b2.setFont(new Font("SansSerif", Font.BOLD, 15));
        gbc2.gridx = 1;
        gbc2.gridy = 4;
        acaoPanel.add(b2, gbc2);
        b2.addActionListener(a -> {
            try {
                ctrPousada.altCliente(textNomeClienteAlterar.getText(),
                        textEnderecoClienteAlterar.getText(),
                        textTelefoneClienteAlterar.getText(), pCPF);
                JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
                // volta para a tela EscolhaCliente
                EscolhaCliente();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro!");
                // volta para a tela EscolhaCliente
                EscolhaCliente();
            }

        });

        //update
        acaoPanel.validate();
        acaoPanel.repaint();
        framePrincipal.validate();
        framePrincipal.setTitle("Alterar Cliente ");
    }

    private void ConsultarCPF() {
        //limpar frame
        acaoPanel.removeAll();

        //ajustando  GridBag
        GridBagConstraints gbcClienteConsultar = new GridBagConstraints();
        gbcClienteConsultar.insets = new Insets(5, 5, 5, 5);

        //criando labelCPFConsulta
        gbcClienteConsultar.gridx = 0;
        gbcClienteConsultar.gridy = 0;
        labelCPFConsulta = new JLabel("CPF: ");
        labelCPFConsulta.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelCPFConsulta, gbcClienteConsultar);

        //criando textfield para digitar o CPF
        textCPFConsulta = new JTextField(20);
        textCPFConsulta.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textCPFConsulta.setHorizontalAlignment(textCPFConsulta.CENTER);
        gbcClienteConsultar.gridy = 0;
        gbcClienteConsultar.gridx = 1;
        acaoPanel.add(textCPFConsulta, gbcClienteConsultar);

        //Criar botaoConsultarCliente
        gbcClienteConsultar.gridx = 1;
        gbcClienteConsultar.gridy = 2;
        botaoConsultarCliente2 = new JButton("Consultar CPF");
        botaoConsultarCliente2.setBackground(new Color(183, 221, 120));
        botaoConsultarCliente2.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoConsultarCliente2.addActionListener(b -> {
            //Ação
            try {
                boolean retorno;
                retorno = ctrPousada.consCPF(textCPFConsulta.getText());
                if (retorno == true) {
                    JOptionPane.showMessageDialog(null, "Cliente já cadastrado no sistema!");
                    EscolhaReserva();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Cliente não cadastrado no sistema!\n"
                            + "Faça o cadastro do cliente");
                    RegistrarCliente(textCPFConsulta.getText());
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro!");

            }
        });
        acaoPanel.add(botaoConsultarCliente2, gbcClienteConsultar);

        //update
        acaoPanel.validate();
        acaoPanel.repaint();
        framePrincipal.validate();
        framePrincipal.setTitle("Consultar CPF ");
    }

    private void ListarClientes() throws Exception {
        String[] clientes = ctrPousada.listaClientes();
        //list = new DefaultListModel();
        lstCliente = new JList(clientes);

        lstCliente.addListSelectionListener((ListSelectionEvent e) -> {
            int index = lstCliente.getSelectedIndex();
            try {
                JOptionPane.showMessageDialog(null,
                        ctrPousada.dadoClientes(index),
                        "Dados do Cliente",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {

            }
        });

        JScrollPane scroll1 = new JScrollPane(lstCliente, // componente
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, // scroll vertical
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // scrollhorizontal
        scroll1.setPreferredSize(new Dimension(320, 120));

        JOptionPane.showMessageDialog(null, scroll1);
    }

    private void ListarCPFs() throws Exception {
        String[] cpf = ctrPousada.listaCPFs();

        JOptionPane.showMessageDialog(null, "Escolha um dos CPFs da lista", "CPFs dos Clientes", JOptionPane.INFORMATION_MESSAGE);

        lstCPF = new JList(cpf);

        lstCPF.addListSelectionListener((ListSelectionEvent e) -> {
            int index = lstCPF.getSelectedIndex();
            try {
                cliente = ctrPousada.dadoClientesCPF(index);
                textNomeClienteReserva.setText(cliente.getNome());
                textCPF.setText(cliente.getCPF());
            } catch (Exception ex) {

            }
        });

        JScrollPane scroll1 = new JScrollPane(lstCPF, // componente
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, // scroll vertical
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // scrollhorizontal
        scroll1.setPreferredSize(new Dimension(320, 120));

        JOptionPane.showMessageDialog(null, scroll1, "CPFs", JOptionPane.INFORMATION_MESSAGE);
    }

    /*     GERENTE     */
    private void EscolhaGerente() {
        //limpar frame
        acaoPanel.removeAll();
        acaoPanel.setBackground(new Color(238, 238, 238));

        //Panel -> escolha
        //ajustando  GridBag
        GridBagConstraints gbcEscolhaGerente = new GridBagConstraints();
        gbcEscolhaGerente.insets = new Insets(5, 5, 5, 5);

        //criando labelEscolha
        gbcEscolhaGerente.gridx = 0;
        gbcEscolhaGerente.gridy = 0;
        EscolhaGerente = new JLabel("Escolha a opção desejada: ");
        EscolhaGerente.setFont(new Font("Calibri", Font.PLAIN, 40));
        //adicionar o label no panel
        acaoPanel.add(EscolhaGerente, gbcEscolhaGerente);

        //Criar botão Adicionar gerente
        gbcEscolhaGerente.gridx = 0;
        gbcEscolhaGerente.gridy = 1;
        botaoAdicionarGerente = new JButton("Adicionar Gerente");
        botaoAdicionarGerente.setBackground(new Color(183, 221, 120));
        botaoAdicionarGerente.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoAdicionarGerente.setPreferredSize(new Dimension(250, 30));
        botaoAdicionarGerente.addActionListener(a -> {
            acaoPanel.removeAll();
            try {
                RegistrarGerente();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro na gravação do Gerente no arquivo", JOptionPane.ERROR_MESSAGE);
            }
        });
        //adicinar botao
        acaoPanel.add(botaoAdicionarGerente, gbcEscolhaGerente);

        //Criar botão Listar gerente
        gbcEscolhaGerente.gridx = 0;
        gbcEscolhaGerente.gridy = 2;
        botaoListarGerentes = new JButton("Listar Gerentes");
        botaoListarGerentes.setBackground(new Color(183, 221, 120));
        botaoListarGerentes.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoListarGerentes.setPreferredSize(new Dimension(250, 30));
        botaoListarGerentes.addActionListener(b -> {
            acaoPanel.removeAll();
            try {
                ListarGerentes();
                //Chamando para "voltar" para a tela escolagerente
                EscolhaGerente();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro!");
            }
        });
        //adicinar botao
        acaoPanel.add(botaoListarGerentes, gbcEscolhaGerente);

        //Criar botão Listar gerente
        gbcEscolhaGerente.gridx = 0;
        gbcEscolhaGerente.gridy = 3;
        botaoListarGerente = new JButton("Consultar Gerente");
        botaoListarGerente.setBackground(new Color(183, 221, 120));
        botaoListarGerente.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoListarGerente.setPreferredSize(new Dimension(250, 30));
        botaoListarGerente.addActionListener(b -> {
            acaoPanel.removeAll();
            ConsultarGerente();
        });
        //adicinar botao
        acaoPanel.add(botaoListarGerente, gbcEscolhaGerente);

        //Criar botão Remover gerente
        gbcEscolhaGerente.gridx = 0;
        gbcEscolhaGerente.gridy = 4;
        botaoRemoverGerente = new JButton("Remover Gerente");
        botaoRemoverGerente.setBackground(new Color(183, 221, 120));
        botaoRemoverGerente.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoRemoverGerente.setPreferredSize(new Dimension(250, 30));
        botaoRemoverGerente.addActionListener(b -> {
            acaoPanel.removeAll();
            RemoverGerente();
        });
        //adicinar botao
        acaoPanel.add(botaoRemoverGerente, gbcEscolhaGerente);

        //Clean
        acaoPanel.validate();
        acaoPanel.repaint();
        framePrincipal.validate();

        framePrincipal.setTitle("Gerente ");

    }

    private void RegistrarGerente() throws Exception {
        //limpar frame
        acaoPanel.removeAll();

        //ajustando  GridBag
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.insets = new Insets(5, 5, 5, 5);

        //criando NovolabelRegistroGerente e adicionando para o panel
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        NovoLabelRegistroGerente = new JLabel("Registro: ");
        NovoLabelRegistroGerente.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(NovoLabelRegistroGerente, gbc2);

        //criando NovoTextRegistroGerente,posicionamento e adicionado ao panel
        NovoTextRegistroGerente = new JTextField(20);
        NovoTextRegistroGerente.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        NovoTextRegistroGerente.setHorizontalAlignment(NovoTextRegistroGerente.CENTER);
        gbc2.gridy = 0;
        gbc2.gridx = 1;
        acaoPanel.add(NovoTextRegistroGerente, gbc2);

        //criando NovoLabelSenhaGerente adicionando para o panel
        NovoLabelSenhaGerente = new JLabel("Senha: ");
        NovoLabelSenhaGerente.setFont(new Font("SansSerif", Font.BOLD, 15));
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        acaoPanel.add(NovoLabelSenhaGerente, gbc2);

        //criando NovoSenhaGerente,posicionamento e adicionado ao panel
        NovoSenhaGerente = new JPasswordField(20);
        NovoSenhaGerente.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        NovoSenhaGerente.setHorizontalAlignment(NovoSenhaGerente.CENTER);
        gbc2.gridx = 1;
        gbc2.gridy = 1;
        acaoPanel.add(NovoSenhaGerente, gbc2);

        //Botão cadastrar gerente
        b2 = new JButton("Cadastrar Gerente ");
        b2.setBackground(new Color(183, 221, 120));
        b2.setFont(new Font("SansSerif", Font.BOLD, 15));
        gbc2.gridx = 1;
        gbc2.gridy = 2;
        acaoPanel.add(b2, gbc2);
        b2.addActionListener(a -> {
            try {
                ctrPousada.cadGerente(NovoTextRegistroGerente.getText(), NovoSenhaGerente.getText());
                JOptionPane.showMessageDialog(null, "Gerente cadastrado com sucesso!");
                // voltar para a tela EscolhaGerente
                EscolhaGerente();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro!");
                // voltar para a tela EscolhaGerente
                EscolhaGerente();
            }

        });

        acaoPanel.validate();
        acaoPanel.repaint();
        framePrincipal.validate();
        framePrincipal.setTitle("Cadastrar gerente ");

    }

    private void RemoverGerente() {
        //limpar frame
        acaoPanel.removeAll();

        //ajustando  GridBag
        GridBagConstraints gbcRemoverGerente = new GridBagConstraints();
        gbcRemoverGerente.insets = new Insets(5, 5, 5, 5);

        //criando RegistroGerente e adicionando para o panel
        gbcRemoverGerente.gridx = 0;
        gbcRemoverGerente.gridy = 0;
        RGRegistroGerente = new JLabel("Registro: ");
        RGRegistroGerente.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(RGRegistroGerente, gbcRemoverGerente);

        //criando RegistroGerente,posicionamento e adicionado ao panel
        NovoTextRegistroGerente = new JTextField(20);
        NovoTextRegistroGerente.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        NovoTextRegistroGerente.setHorizontalAlignment(NovoTextRegistroGerente.CENTER);
        gbcRemoverGerente.gridy = 0;
        gbcRemoverGerente.gridx = 1;
        acaoPanel.add(NovoTextRegistroGerente, gbcRemoverGerente);

        //Botão remover gerente
        botaoRemoverG = new JButton("Remover Gerente  ");
        botaoRemoverG.setBackground(new Color(183, 221, 120));
        botaoRemoverG.setFont(new Font("SansSerif", Font.BOLD, 15));
        gbcRemoverGerente.gridx = 1;
        gbcRemoverGerente.gridy = 2;
        botaoRemoverG.addActionListener(a -> {
            try {
                boolean retorno = ctrPousada.remGerente(NovoTextRegistroGerente.getText());
                if (retorno == true) {
                    JOptionPane.showMessageDialog(null, "Gerente removido com sucesso!");
                    // voltar para a tela EscolhaGerente
                    EscolhaGerente();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Gerente não foi removido, ele não existe!");
                    // voltar para a tela EscolhaGerente
                    EscolhaGerente();
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro!" + "\n" + "Gerente não foi removido!");
                // voltar para a tela EscolhaGerente
                EscolhaGerente();
            }
        });
        acaoPanel.add(botaoRemoverG, gbcRemoverGerente);

        //update
        acaoPanel.validate();
        acaoPanel.repaint();
        framePrincipal.validate();
        framePrincipal.setTitle("Remover gerente ");

    }

    private void ConsultarGerente() {

        //limpar frame
        acaoPanel.removeAll();

        //ajustando  GridBag
        GridBagConstraints gbcQuartoConsultar = new GridBagConstraints();
        gbcQuartoConsultar.insets = new Insets(5, 5, 5, 5);

        //criando label Numero
        gbcQuartoConsultar.gridx = 0;
        gbcQuartoConsultar.gridy = 0;
        labelNumeroConsulta = new JLabel("Registro: ");
        labelNumeroConsulta.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelNumeroConsulta, gbcQuartoConsultar);

        //criando textfield para digitar o Número
        textRegistroConsulta = new JTextField(20);
        textRegistroConsulta.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textRegistroConsulta.setHorizontalAlignment(textRegistroConsulta.CENTER);
        gbcQuartoConsultar.gridy = 0;
        gbcQuartoConsultar.gridx = 1;
        acaoPanel.add(textRegistroConsulta, gbcQuartoConsultar);

        //Criar botão Consultar Gerente
        //o botao é chamado botaoConsultarQuarto, pois na função escolha já utiliza o  botaoConsultarQuarto2
        gbcQuartoConsultar.gridx = 1;
        gbcQuartoConsultar.gridy = 2;
        botaoConsultaGerente = new JButton("Consultar Gerente");
        botaoConsultaGerente.setBackground(new Color(183, 221, 120));
        botaoConsultaGerente.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoConsultaGerente.addActionListener(b -> {
            //Ação
            try {
                String gerente = ctrPousada.consultarGerente(textRegistroConsulta.getText());
                if (gerente.equals("")) {
                    JOptionPane.showMessageDialog(null,
                            "Não existe gerente com registro "
                            + textRegistroConsulta.getText());
                    // voltar para a tela EscolhaGerente
                    EscolhaGerente();
                } else {
                    JOptionPane.showMessageDialog(null, gerente);
                    // voltar para a tela EscolhaGerente
                    EscolhaGerente();
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro!");
                // voltar para a tela EscolhaGerente
                EscolhaGerente();
            }
        });
        acaoPanel.add(botaoConsultaGerente, gbcQuartoConsultar);

        //update
        acaoPanel.validate();
        acaoPanel.repaint();
        framePrincipal.validate();
        framePrincipal.setTitle("Consultar Gerente ");

    }

    private void ListarGerentes() throws Exception {
        String[] clientes = ctrPousada.listaGerentes();

        lstGerente = new JList(clientes);

        lstGerente.addListSelectionListener((ListSelectionEvent e) -> {
            int index = lstGerente.getSelectedIndex();
            try {
                JOptionPane.showMessageDialog(null,
                        ctrPousada.dadoGerentes(index),
                        "Dados do Gerente",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {

            }
        });

        JScrollPane scroll1 = new JScrollPane(lstGerente, // componente
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, // scroll vertical
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // scrollhorizontal
        scroll1.setPreferredSize(new Dimension(320, 120));

        JOptionPane.showMessageDialog(null, scroll1);
    }

    /*     PAGAMENTO     */
    private void EscolhaPagamento() {
        //limpar frame
        acaoPanel.removeAll();
        acaoPanel.setBackground(new Color(238, 238, 238));

        //Panel -> escolha
        //ajustando  GridBag
        GridBagConstraints gbcEscolhaPagamento = new GridBagConstraints();
        gbcEscolhaPagamento.insets = new Insets(5, 5, 5, 5);

        //criando labelEscolha
        gbcEscolhaPagamento.gridx = 0;
        gbcEscolhaPagamento.gridy = 0;
        EscolhaPagamento = new JLabel("Escolha a opção desejada: ");
        EscolhaPagamento.setFont(new Font("Calibri", Font.PLAIN, 40));
        //adicionar o label no panel
        acaoPanel.add(EscolhaPagamento, gbcEscolhaPagamento);

        //Criar botão Registrar Pagamento
        gbcEscolhaPagamento.gridx = 0;
        gbcEscolhaPagamento.gridy = 1;
        botaoRegistrarPagamento = new JButton("Pagar Diária");
        botaoRegistrarPagamento.setBackground(new Color(183, 221, 120));
        botaoRegistrarPagamento.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoRegistrarPagamento.setPreferredSize(new Dimension(300, 30));
        botaoRegistrarPagamento.addActionListener(a -> {
            try {
                //chamando RegistrarPagamento
                SelecionarReservaDiaria();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro no registro do pagamento!");
            }
        });
        //adicinar botao
        acaoPanel.add(botaoRegistrarPagamento, gbcEscolhaPagamento);

        //Criar botão VerificarPagamentoDiaria
        gbcEscolhaPagamento.gridx = 0;
        gbcEscolhaPagamento.gridy = 2;
        botaoVerificarPagamentoDiaria = new JButton("Verificar Pagamento Diária");
        botaoVerificarPagamentoDiaria.setBackground(new Color(183, 221, 120));
        botaoVerificarPagamentoDiaria.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoVerificarPagamentoDiaria.setPreferredSize(new Dimension(300, 30));
        botaoVerificarPagamentoDiaria.addActionListener(b -> {
            acaoPanel.removeAll();
            //chamada VerificarPagamento
            VerificarPagamentoDiaria();

        });
        //adicinar botao
        acaoPanel.add(botaoVerificarPagamentoDiaria, gbcEscolhaPagamento);

        //Criar botão VerificarPagamento
        gbcEscolhaPagamento.gridx = 0;
        gbcEscolhaPagamento.gridy = 3;
        botaoVerificarPagamento = new JButton("Realizar Pagamento");
        botaoVerificarPagamento.setBackground(new Color(183, 221, 120));
        botaoVerificarPagamento.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoVerificarPagamento.setPreferredSize(new Dimension(300, 30));
        botaoVerificarPagamento.addActionListener(b -> {
            acaoPanel.removeAll();
            //chamada RealizarPagamento
            SelecionarReservaPagamento();

        });
        //adicinar botao
        acaoPanel.add(botaoVerificarPagamento, gbcEscolhaPagamento);

        //Criar botaoCheckIN
        gbcEscolhaPagamento.gridx = 0;
        gbcEscolhaPagamento.gridy = 4;
        botaoCheckOut = new JButton("Check-out");
        botaoCheckOut.setBackground(new Color(183, 221, 120));
        botaoCheckOut.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoCheckOut.setPreferredSize(new Dimension(300, 30));
        botaoCheckOut.addActionListener(b -> {
            acaoPanel.removeAll();
            //chamada Realizar Check-Out
            SelecionarReservaCheckOut();

        });
        //adicinar botao
        acaoPanel.add(botaoCheckOut, gbcEscolhaPagamento);

        //Criar botaoVerificarReservaCancelada
        gbcEscolhaPagamento.gridx = 0;
        gbcEscolhaPagamento.gridy = 5;
        botaoVerificarReservaCancelada = new JButton("Verificar Reserva(s) Cancelada(s)");
        botaoVerificarReservaCancelada.setBackground(new Color(183, 221, 120));
        botaoVerificarReservaCancelada.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoVerificarReservaCancelada.setPreferredSize(new Dimension(300, 30));
        botaoVerificarReservaCancelada.addActionListener(b -> {
            acaoPanel.removeAll();
            try {
                ctrPousada.cancelarReserva();
                JOptionPane.showMessageDialog(null, "Reserva(s) Verificada(s)!");
                EscolhaPagamento();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro!");
                EscolhaPagamento();
            }

        });
        //adicinar botao
        acaoPanel.add(botaoVerificarReservaCancelada, gbcEscolhaPagamento);

        //Clean
        acaoPanel.validate();
        acaoPanel.repaint();
        framePrincipal.validate();

        framePrincipal.setTitle("Pagamento ");

    }

    private void RealizarPagamentoRestante(Reserva reserva) throws Exception {
        //limpar frame
        acaoPanel.removeAll();

        //ajustando  GridBag
        GridBagConstraints gbcResgistrarPagamento = new GridBagConstraints();
        gbcResgistrarPagamento.insets = new Insets(5, 5, 5, 5);

        //criando labelEscolha
        gbcResgistrarPagamento.gridx = 0;
        gbcResgistrarPagamento.gridy = 0;
        labelPagamento = new JLabel("Informações da Reserva: ");
        labelPagamento.setFont(new Font("Calibri", Font.PLAIN, 30));
        //adicionar o label no panel
        acaoPanel.add(labelPagamento, gbcResgistrarPagamento);

        //criando labelCodigo
        gbcResgistrarPagamento.gridx = 0;
        gbcResgistrarPagamento.gridy = 1;
        labelCodigo = new JLabel("Código da Reserva: ");
        labelCodigo.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelCodigo, gbcResgistrarPagamento);

        //criando textCodigo,posicionamento e adicionado ao panel
        textCodigo = new JTextField(20);
        textCodigo.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textCodigo.setEditable(false);
        String codigo = String.valueOf(reserva.getCodigo());
        textCodigo.setText(codigo);
        textCodigo.setHorizontalAlignment(textCodigo.CENTER);
        gbcResgistrarPagamento.gridy = 1;
        gbcResgistrarPagamento.gridx = 2;
        acaoPanel.add(textCodigo, gbcResgistrarPagamento);

        //criando labelEntrada
        gbcResgistrarPagamento.gridx = 0;
        gbcResgistrarPagamento.gridy = 2;
        labelEntrada = new JLabel("Data de Entrada: ");
        labelEntrada.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelEntrada, gbcResgistrarPagamento);

        //criando textEntrada,posicionamento e adicionado ao panel
        textEntrada = new JTextField(20);
        textEntrada.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textEntrada.setEditable(false);
        String entrada = String.valueOf(reserva.getEntrada());
        textEntrada.setText(entrada);
        textEntrada.setHorizontalAlignment(textEntrada.CENTER);
        gbcResgistrarPagamento.gridy = 2;
        gbcResgistrarPagamento.gridx = 2;
        acaoPanel.add(textEntrada, gbcResgistrarPagamento);

        //criando labelSaida
        gbcResgistrarPagamento.gridx = 0;
        gbcResgistrarPagamento.gridy = 3;
        labelSaida = new JLabel("Data de Saída: ");
        labelSaida.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelSaida, gbcResgistrarPagamento);

        //criando textSaida,posicionamento e adicionado ao panel
        textSaida = new JTextField(20);
        textSaida.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textSaida.setEditable(false);
        String saida = String.valueOf(reserva.getSaida());
        textSaida.setText(saida);
        textSaida.setHorizontalAlignment(textSaida.CENTER);
        gbcResgistrarPagamento.gridy = 3;
        gbcResgistrarPagamento.gridx = 2;
        acaoPanel.add(textSaida, gbcResgistrarPagamento);

        //criando labelClienteNome
        gbcResgistrarPagamento.gridx = 0;
        gbcResgistrarPagamento.gridy = 4;
        labelClienteNome = new JLabel("Nome do Cliente: ");
        labelClienteNome.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelClienteNome, gbcResgistrarPagamento);

        //criando textClienteNome,posicionamento e adicionado ao panel
        textClienteNome = new JTextField(20);
        textClienteNome.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textClienteNome.setEditable(false);
        textClienteNome.setText(reserva.getCliente().getNome());
        textClienteNome.setHorizontalAlignment(textClienteNome.CENTER);
        gbcResgistrarPagamento.gridy = 4;
        gbcResgistrarPagamento.gridx = 2;
        acaoPanel.add(textClienteNome, gbcResgistrarPagamento);

        //criando labelClienteCPF
        gbcResgistrarPagamento.gridx = 0;
        gbcResgistrarPagamento.gridy = 5;
        labelClienteCPF = new JLabel("CPF do Cliente: ");
        labelClienteCPF.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelClienteCPF, gbcResgistrarPagamento);

        //criando textClienteCPF,posicionamento e adicionado ao panel
        textClienteCPF = new JTextField(20);
        textClienteCPF.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textClienteCPF.setEditable(false);
        textClienteCPF.setText(reserva.getCliente().getCPF());
        textClienteCPF.setHorizontalAlignment(textClienteCPF.CENTER);
        gbcResgistrarPagamento.gridy = 5;
        gbcResgistrarPagamento.gridx = 2;
        acaoPanel.add(textClienteCPF, gbcResgistrarPagamento);

        //criando labelQuartoNumero
        gbcResgistrarPagamento.gridx = 0;
        gbcResgistrarPagamento.gridy = 6;
        labelQuartoNumero = new JLabel("Número do Quarto: ");
        labelQuartoNumero.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelQuartoNumero, gbcResgistrarPagamento);

        //criando textQuartoNumero,posicionamento e adicionado ao panel
        textQuartoNumero = new JTextField(20);
        textQuartoNumero.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textQuartoNumero.setEditable(false);
        String numero = String.valueOf(reserva.getQuarto().getNumero());
        textQuartoNumero.setText(numero);
        textQuartoNumero.setHorizontalAlignment(textQuartoNumero.CENTER);
        gbcResgistrarPagamento.gridy = 6;
        gbcResgistrarPagamento.gridx = 2;
        acaoPanel.add(textQuartoNumero, gbcResgistrarPagamento);

        //criando labelQuartoPreco
        gbcResgistrarPagamento.gridx = 0;
        gbcResgistrarPagamento.gridy = 7;
        labelQuartoPreco = new JLabel("Preço do Quarto: ");
        labelQuartoPreco.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelQuartoPreco, gbcResgistrarPagamento);

        //criando textQuartoPreco,posicionamento e adicionado ao panel
        textQuartoPreco = new JTextField(20);
        textQuartoPreco.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textQuartoPreco.setEditable(false);
        String precoQuarto = String.valueOf(reserva.getQuarto().getPreco());
        textQuartoPreco.setText("R$ " + precoQuarto);
        textQuartoPreco.setHorizontalAlignment(textQuartoPreco.CENTER);
        gbcResgistrarPagamento.gridy = 7;
        gbcResgistrarPagamento.gridx = 2;
        acaoPanel.add(textQuartoPreco, gbcResgistrarPagamento);

        //criando labelValorDesconto
        gbcResgistrarPagamento.gridx = 0;
        gbcResgistrarPagamento.gridy = 8;
        labelValorDesconto = new JLabel("Desconto: ");
        labelValorDesconto.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelValorDesconto, gbcResgistrarPagamento);

        //criando textValorDesconto,posicionamento e adicionado ao panel
        textValorDesconto = new JTextField(20);
        textValorDesconto.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textValorDesconto.setEditable(false);
        String desconto = String.valueOf(reserva.getDesconto());
        textValorDesconto.setText(desconto + " %");
        textValorDesconto.setHorizontalAlignment(textValorDesconto.CENTER);
        gbcResgistrarPagamento.gridy = 8;
        gbcResgistrarPagamento.gridx = 2;
        acaoPanel.add(textValorDesconto, gbcResgistrarPagamento);

        //criando labelPreco
        gbcResgistrarPagamento.gridx = 0;
        gbcResgistrarPagamento.gridy = 9;
        labelPreco = new JLabel("Valor Total sem Desconto: ");
        labelPreco.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelPreco, gbcResgistrarPagamento);

        //criando textPreco,posicionamento e adicionado ao panel
        textPreco = new JTextField(20);
        textPreco.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textPreco.setEditable(false);
        String precoParcial = String.valueOf(reserva.getPreco());
        textPreco.setText("R$ " + precoParcial);
        textPreco.setHorizontalAlignment(textPreco.CENTER);
        gbcResgistrarPagamento.gridy = 9;
        gbcResgistrarPagamento.gridx = 2;
        acaoPanel.add(textPreco, gbcResgistrarPagamento);

        //criando label valorPagamento
        gbcResgistrarPagamento.gridx = 0;
        gbcResgistrarPagamento.gridy = 10;
        NovoLabelValorPagamento = new JLabel("Valor Total da Reserva: ");
        NovoLabelValorPagamento.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(NovoLabelValorPagamento, gbcResgistrarPagamento);

        //criando NovoTextValorPagamento,posicionamento e adicionado ao panel
        NovoTextValorPagamento = new JTextField(20);
        NovoTextValorPagamento.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        NovoTextValorPagamento.setEditable(false);
        String preco = String.valueOf(reserva.getValorTotal());
        NovoTextValorPagamento.setText("R$ " + preco);
        NovoTextValorPagamento.setHorizontalAlignment(NovoTextValorPagamento.CENTER);
        gbcResgistrarPagamento.gridy = 10;
        gbcResgistrarPagamento.gridx = 2;
        acaoPanel.add(NovoTextValorPagamento, gbcResgistrarPagamento);

        //criando labelValorPago
        gbcResgistrarPagamento.gridx = 0;
        gbcResgistrarPagamento.gridy = 11;
        labelValorPago = new JLabel("Valor Pago: ");
        labelValorPago.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelValorPago, gbcResgistrarPagamento);

        //criando textValorPago,posicionamento e adicionado ao panel
        textValorPago = new JTextField(20);
        textValorPago.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textValorPago.setEditable(false);
        String valorPago = String.valueOf(ctrPousada.valorPago(reserva.getCodigo()));
        textValorPago.setText("R$ " + valorPago);
        textValorPago.setHorizontalAlignment(textValorPago.CENTER);
        gbcResgistrarPagamento.gridy = 11;
        gbcResgistrarPagamento.gridx = 2;
        acaoPanel.add(textValorPago, gbcResgistrarPagamento);

        //criando labelValorPagar
        gbcResgistrarPagamento.gridx = 0;
        gbcResgistrarPagamento.gridy = 12;
        labelValorPagar = new JLabel("Valor Restante a Pagar: ");
        labelValorPagar.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelValorPagar, gbcResgistrarPagamento);

        //criando textValorPagar,posicionamento e adicionado ao panel
        textValorPagar = new JTextField(20);
        textValorPagar.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textValorPagar.setEditable(false);
        String valorRestante = String.valueOf(ctrPousada.restPagamento(reserva.getCodigo()));
        textValorPagar.setText("R$ " + valorRestante);
        textValorPagar.setHorizontalAlignment(textValorPagar.CENTER);
        gbcResgistrarPagamento.gridy = 12;
        gbcResgistrarPagamento.gridx = 2;
        acaoPanel.add(textValorPagar, gbcResgistrarPagamento);

        //criando labelValorPagamento
        gbcResgistrarPagamento.gridx = 0;
        gbcResgistrarPagamento.gridy = 13;
        labelValorPagamento = new JLabel("Valor a Pagar: ");
        labelValorPagamento.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelValorPagamento, gbcResgistrarPagamento);

        //criando textValorPagamento,posicionamento e adicionado ao panel
        textValorPagamento = new JTextField(20);
        textValorPagamento.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textValorPagamento.setHorizontalAlignment(textValorPagar.CENTER);
        gbcResgistrarPagamento.gridy = 13;
        gbcResgistrarPagamento.gridx = 2;
        acaoPanel.add(textValorPagamento, gbcResgistrarPagamento);

        //Botão botaoRegistrarPagamento2- o botao botaoRegistrarPagamento está sendo usado no EscolhaPagamento
        botaoRealizarPagamentoDiaria = new JButton("Realizar Pagamento ");
        botaoRealizarPagamentoDiaria.setBackground(new Color(183, 221, 120));
        botaoRealizarPagamentoDiaria.setFont(new Font("SansSerif", Font.BOLD, 15));
        gbcResgistrarPagamento.gridx = 2;
        gbcResgistrarPagamento.gridy = 16;
        acaoPanel.add(botaoRealizarPagamentoDiaria, gbcResgistrarPagamento);
        botaoRealizarPagamentoDiaria.addActionListener(a -> {
            try {
                //ctrPousada.pagDiaria(reserva.getValorTotal(), reserva, reserva.getQuarto().getPreco());
                ctrPousada.atualizaReservaValorPago(reserva.getCodigo(), Double.parseDouble(textValorPagamento.getText()));
                ctrPousada.realizarPagamento(reserva.getCodigo(), Double.parseDouble(textValorPagamento.getText()));
                //ctrPousada.cadPagamentoCodigo(reserva.getCodigo());
                JOptionPane.showMessageDialog(null,
                        "Pagamento no valor de "
                        + textValorPagamento.getText()
                        + " da reserva "
                        + reserva.getCodigo()
                        + " efetuado!");
                EscolhaPagamento();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro!");
                EscolhaPagamento();
            }

        });

        acaoPanel.validate();
        acaoPanel.repaint();
        framePrincipal.validate();
        framePrincipal.setTitle("Realizar Pagamento");
    }

    private void RealizarPagamentoCheckOut(int pReserva) throws Exception {
        int situacao = ctrPousada.check_out(pReserva);
        if (situacao != 0) {
            JOptionPane.showMessageDialog(null, "Não existem Pagamentos Pendentes na Reserva " + pReserva + " !");
            try {
                ctrPousada.realizarCheckOutReserva(pReserva);
                JOptionPane.showMessageDialog(null, "Check-out efetuado com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Check-out não foi efetuado!");
            }
            EscolhaPagamento();
        } else {
            //limpar frame
            acaoPanel.removeAll();

            //ajustando  GridBag
            GridBagConstraints gbcResgistrarPagamento = new GridBagConstraints();
            gbcResgistrarPagamento.insets = new Insets(5, 5, 5, 5);

            //criando labelEscolha
            gbcResgistrarPagamento.gridx = 0;
            gbcResgistrarPagamento.gridy = 0;
            labelPagamento = new JLabel("Informações da Reserva: ");
            labelPagamento.setFont(new Font("Calibri", Font.PLAIN, 30));
            //adicionar o label no panel
            acaoPanel.add(labelPagamento, gbcResgistrarPagamento);

            //criando labelCodigo
            gbcResgistrarPagamento.gridx = 0;
            gbcResgistrarPagamento.gridy = 1;
            labelCodigo = new JLabel("Código da Reserva: ");
            labelCodigo.setFont(new Font("SansSerif", Font.BOLD, 15));
            acaoPanel.add(labelCodigo, gbcResgistrarPagamento);

            //criando textCodigo,posicionamento e adicionado ao panel
            textCodigo = new JTextField(20);
            textCodigo.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
            textCodigo.setEditable(false);
            String codigo = String.valueOf(reserva.getCodigo());
            textCodigo.setText(codigo);
            textCodigo.setHorizontalAlignment(textCodigo.CENTER);
            gbcResgistrarPagamento.gridy = 1;
            gbcResgistrarPagamento.gridx = 2;
            acaoPanel.add(textCodigo, gbcResgistrarPagamento);

            //criando labelEntrada
            gbcResgistrarPagamento.gridx = 0;
            gbcResgistrarPagamento.gridy = 2;
            labelEntrada = new JLabel("Data de Entrada: ");
            labelEntrada.setFont(new Font("SansSerif", Font.BOLD, 15));
            acaoPanel.add(labelEntrada, gbcResgistrarPagamento);

            //criando textEntrada,posicionamento e adicionado ao panel
            textEntrada = new JTextField(20);
            textEntrada.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
            textEntrada.setEditable(false);
            String entrada = String.valueOf(reserva.getEntrada());
            textEntrada.setText(entrada);
            textEntrada.setHorizontalAlignment(textEntrada.CENTER);
            gbcResgistrarPagamento.gridy = 2;
            gbcResgistrarPagamento.gridx = 2;
            acaoPanel.add(textEntrada, gbcResgistrarPagamento);

            //criando labelSaida
            gbcResgistrarPagamento.gridx = 0;
            gbcResgistrarPagamento.gridy = 3;
            labelSaida = new JLabel("Data de Saída: ");
            labelSaida.setFont(new Font("SansSerif", Font.BOLD, 15));
            acaoPanel.add(labelSaida, gbcResgistrarPagamento);

            //criando textSaida,posicionamento e adicionado ao panel
            textSaida = new JTextField(20);
            textSaida.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
            textSaida.setEditable(false);
            String saida = String.valueOf(reserva.getSaida());
            textSaida.setText(saida);
            textSaida.setHorizontalAlignment(textSaida.CENTER);
            gbcResgistrarPagamento.gridy = 3;
            gbcResgistrarPagamento.gridx = 2;
            acaoPanel.add(textSaida, gbcResgistrarPagamento);

            //criando labelClienteNome
            gbcResgistrarPagamento.gridx = 0;
            gbcResgistrarPagamento.gridy = 4;
            labelClienteNome = new JLabel("Nome do Cliente: ");
            labelClienteNome.setFont(new Font("SansSerif", Font.BOLD, 15));
            acaoPanel.add(labelClienteNome, gbcResgistrarPagamento);

            //criando textClienteNome,posicionamento e adicionado ao panel
            textClienteNome = new JTextField(20);
            textClienteNome.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
            textClienteNome.setEditable(false);
            textClienteNome.setText(reserva.getCliente().getNome());
            textClienteNome.setHorizontalAlignment(textClienteNome.CENTER);
            gbcResgistrarPagamento.gridy = 4;
            gbcResgistrarPagamento.gridx = 2;
            acaoPanel.add(textClienteNome, gbcResgistrarPagamento);

            //criando labelClienteCPF
            gbcResgistrarPagamento.gridx = 0;
            gbcResgistrarPagamento.gridy = 5;
            labelClienteCPF = new JLabel("CPF do Cliente: ");
            labelClienteCPF.setFont(new Font("SansSerif", Font.BOLD, 15));
            acaoPanel.add(labelClienteCPF, gbcResgistrarPagamento);

            //criando textClienteCPF,posicionamento e adicionado ao panel
            textClienteCPF = new JTextField(20);
            textClienteCPF.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
            textClienteCPF.setEditable(false);
            textClienteCPF.setText(reserva.getCliente().getCPF());
            textClienteCPF.setHorizontalAlignment(textClienteCPF.CENTER);
            gbcResgistrarPagamento.gridy = 5;
            gbcResgistrarPagamento.gridx = 2;
            acaoPanel.add(textClienteCPF, gbcResgistrarPagamento);

            //criando labelQuartoNumero
            gbcResgistrarPagamento.gridx = 0;
            gbcResgistrarPagamento.gridy = 6;
            labelQuartoNumero = new JLabel("Número do Quarto: ");
            labelQuartoNumero.setFont(new Font("SansSerif", Font.BOLD, 15));
            acaoPanel.add(labelQuartoNumero, gbcResgistrarPagamento);

            //criando textQuartoNumero,posicionamento e adicionado ao panel
            textQuartoNumero = new JTextField(20);
            textQuartoNumero.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
            textQuartoNumero.setEditable(false);
            String numero = String.valueOf(reserva.getQuarto().getNumero());
            textQuartoNumero.setText(numero);
            textQuartoNumero.setHorizontalAlignment(textQuartoNumero.CENTER);
            gbcResgistrarPagamento.gridy = 6;
            gbcResgistrarPagamento.gridx = 2;
            acaoPanel.add(textQuartoNumero, gbcResgistrarPagamento);

            //criando labelQuartoPreco
            gbcResgistrarPagamento.gridx = 0;
            gbcResgistrarPagamento.gridy = 7;
            labelQuartoPreco = new JLabel("Preço do Quarto: ");
            labelQuartoPreco.setFont(new Font("SansSerif", Font.BOLD, 15));
            acaoPanel.add(labelQuartoPreco, gbcResgistrarPagamento);

            //criando textQuartoPreco,posicionamento e adicionado ao panel
            textQuartoPreco = new JTextField(20);
            textQuartoPreco.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
            textQuartoPreco.setEditable(false);
            String precoQuarto = String.valueOf(reserva.getQuarto().getPreco());
            textQuartoPreco.setText("R$ " + precoQuarto);
            textQuartoPreco.setHorizontalAlignment(textQuartoPreco.CENTER);
            gbcResgistrarPagamento.gridy = 7;
            gbcResgistrarPagamento.gridx = 2;
            acaoPanel.add(textQuartoPreco, gbcResgistrarPagamento);

            //criando labelValorDesconto
            gbcResgistrarPagamento.gridx = 0;
            gbcResgistrarPagamento.gridy = 8;
            labelValorDesconto = new JLabel("Desconto: ");
            labelValorDesconto.setFont(new Font("SansSerif", Font.BOLD, 15));
            acaoPanel.add(labelValorDesconto, gbcResgistrarPagamento);

            //criando textValorDesconto,posicionamento e adicionado ao panel
            textValorDesconto = new JTextField(20);
            textValorDesconto.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
            textValorDesconto.setEditable(false);
            String desconto = String.valueOf(reserva.getDesconto());
            textValorDesconto.setText(desconto + " %");
            textValorDesconto.setHorizontalAlignment(textValorDesconto.CENTER);
            gbcResgistrarPagamento.gridy = 8;
            gbcResgistrarPagamento.gridx = 2;
            acaoPanel.add(textValorDesconto, gbcResgistrarPagamento);

            //criando labelPreco
            gbcResgistrarPagamento.gridx = 0;
            gbcResgistrarPagamento.gridy = 9;
            labelPreco = new JLabel("Valor Total sem Desconto: ");
            labelPreco.setFont(new Font("SansSerif", Font.BOLD, 15));
            acaoPanel.add(labelPreco, gbcResgistrarPagamento);

            //criando textPreco,posicionamento e adicionado ao panel
            textPreco = new JTextField(20);
            textPreco.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
            textPreco.setEditable(false);
            String precoParcial = String.valueOf(reserva.getPreco());
            textPreco.setText("R$ " + precoParcial);
            textPreco.setHorizontalAlignment(textPreco.CENTER);
            gbcResgistrarPagamento.gridy = 9;
            gbcResgistrarPagamento.gridx = 2;
            acaoPanel.add(textPreco, gbcResgistrarPagamento);

            //criando label valorPagamento
            gbcResgistrarPagamento.gridx = 0;
            gbcResgistrarPagamento.gridy = 10;
            NovoLabelValorPagamento = new JLabel("Valor Total da Reserva: ");
            NovoLabelValorPagamento.setFont(new Font("SansSerif", Font.BOLD, 15));
            acaoPanel.add(NovoLabelValorPagamento, gbcResgistrarPagamento);

            //criando NovoTextValorPagamento,posicionamento e adicionado ao panel
            NovoTextValorPagamento = new JTextField(20);
            NovoTextValorPagamento.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
            NovoTextValorPagamento.setEditable(false);
            String preco = String.valueOf(reserva.getValorTotal());
            NovoTextValorPagamento.setText("R$ " + preco);
            NovoTextValorPagamento.setHorizontalAlignment(NovoTextValorPagamento.CENTER);
            gbcResgistrarPagamento.gridy = 10;
            gbcResgistrarPagamento.gridx = 2;
            acaoPanel.add(NovoTextValorPagamento, gbcResgistrarPagamento);

            //criando labelValorPago
            gbcResgistrarPagamento.gridx = 0;
            gbcResgistrarPagamento.gridy = 11;
            labelValorPago = new JLabel("Valor Pago: ");
            labelValorPago.setFont(new Font("SansSerif", Font.BOLD, 15));
            acaoPanel.add(labelValorPago, gbcResgistrarPagamento);

            //criando textValorPago,posicionamento e adicionado ao panel
            textValorPago = new JTextField(20);
            textValorPago.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
            textValorPago.setEditable(false);
            String valorPago = String.valueOf(ctrPousada.valorPago(reserva.getCodigo()));
            textValorPago.setText("R$ " + valorPago);
            textValorPago.setHorizontalAlignment(textValorPago.CENTER);
            gbcResgistrarPagamento.gridy = 11;
            gbcResgistrarPagamento.gridx = 2;
            acaoPanel.add(textValorPago, gbcResgistrarPagamento);

            //criando labelValorPagar
            gbcResgistrarPagamento.gridx = 0;
            gbcResgistrarPagamento.gridy = 12;
            labelValorPagar = new JLabel("Valor Restante a Pagar: ");
            labelValorPagar.setFont(new Font("SansSerif", Font.BOLD, 15));
            acaoPanel.add(labelValorPagar, gbcResgistrarPagamento);

            //criando textValorPagar,posicionamento e adicionado ao panel
            textValorPagar = new JTextField(20);
            textValorPagar.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
            textValorPagar.setEditable(false);
            String valorRestante = String.valueOf(ctrPousada.restPagamento(reserva.getCodigo()));
            textValorPagar.setText("R$ " + valorRestante);
            textValorPagar.setHorizontalAlignment(textValorPagar.CENTER);
            gbcResgistrarPagamento.gridy = 12;
            gbcResgistrarPagamento.gridx = 2;
            acaoPanel.add(textValorPagar, gbcResgistrarPagamento);

            //criando labelValorPagamento
            gbcResgistrarPagamento.gridx = 0;
            gbcResgistrarPagamento.gridy = 13;
            labelValorPagamento = new JLabel("Valor a Pagar: ");
            labelValorPagamento.setFont(new Font("SansSerif", Font.BOLD, 15));
            acaoPanel.add(labelValorPagamento, gbcResgistrarPagamento);

            //criando textValorPagamento,posicionamento e adicionado ao panel
            textValorPagamento = new JTextField(20);
            textValorPagamento.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
            textValorPagamento.setHorizontalAlignment(textValorPagar.CENTER);
            gbcResgistrarPagamento.gridy = 13;
            gbcResgistrarPagamento.gridx = 2;
            acaoPanel.add(textValorPagamento, gbcResgistrarPagamento);

            //Botão botaoRegistrarPagamento2- o botao botaoRegistrarPagamento está sendo usado no EscolhaPagamento
            botaoRealizarPagamentoDiaria = new JButton("Realizar Pagamento ");
            botaoRealizarPagamentoDiaria.setBackground(new Color(183, 221, 120));
            botaoRealizarPagamentoDiaria.setFont(new Font("SansSerif", Font.BOLD, 15));
            gbcResgistrarPagamento.gridx = 2;
            gbcResgistrarPagamento.gridy = 16;
            acaoPanel.add(botaoRealizarPagamentoDiaria, gbcResgistrarPagamento);
            botaoRealizarPagamentoDiaria.addActionListener(a -> {
                try {
                    //ctrPousada.pagDiaria(reserva.getValorTotal(), reserva, reserva.getQuarto().getPreco());
                    ctrPousada.realizarPagamento(reserva.getCodigo(), Double.parseDouble(textValorPagamento.getText()));
                    //ctrPousada.cadPagamentoCodigo(reserva.getCodigo());
                    JOptionPane.showMessageDialog(null,
                            "Pagamento no valor de "
                            + textValorPagamento.getText()
                            + " da reserva "
                            + reserva.getCodigo()
                            + " efetuado!");
                    EscolhaPagamento();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro!");
                    EscolhaPagamento();
                }

            });

            acaoPanel.validate();
            acaoPanel.repaint();
            framePrincipal.validate();
            framePrincipal.setTitle("Realizar Pagamento");
        }

    }

    private void RealizarPagamentoDiaria(Reserva reserva) {
        //limpar frame
        acaoPanel.removeAll();

        //ajustando  GridBag
        GridBagConstraints gbcResgistrarPagamento = new GridBagConstraints();
        gbcResgistrarPagamento.insets = new Insets(5, 5, 5, 5);

        //criando labelEscolha
        gbcResgistrarPagamento.gridx = 0;
        gbcResgistrarPagamento.gridy = 0;
        labelPagamento = new JLabel("Informações da Reserva: ");
        labelPagamento.setFont(new Font("Calibri", Font.PLAIN, 30));
        //adicionar o label no panel
        acaoPanel.add(labelPagamento, gbcResgistrarPagamento);

        //criando labelCodigo
        gbcResgistrarPagamento.gridx = 0;
        gbcResgistrarPagamento.gridy = 1;
        labelCodigo = new JLabel("Código da Reserva: ");
        labelCodigo.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelCodigo, gbcResgistrarPagamento);

        //criando textCodigo,posicionamento e adicionado ao panel
        textCodigo = new JTextField(20);
        textCodigo.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textCodigo.setEditable(false);
        String codigo = String.valueOf(reserva.getCodigo());
        textCodigo.setText(codigo);
        textCodigo.setHorizontalAlignment(textCodigo.CENTER);
        gbcResgistrarPagamento.gridy = 1;
        gbcResgistrarPagamento.gridx = 2;
        acaoPanel.add(textCodigo, gbcResgistrarPagamento);

        //criando labelEntrada
        gbcResgistrarPagamento.gridx = 0;
        gbcResgistrarPagamento.gridy = 2;
        labelEntrada = new JLabel("Data de Entrada: ");
        labelEntrada.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelEntrada, gbcResgistrarPagamento);

        //criando textEntrada,posicionamento e adicionado ao panel
        textEntrada = new JTextField(20);
        textEntrada.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textEntrada.setEditable(false);
        String entrada = String.valueOf(reserva.getEntrada());
        textEntrada.setText(entrada);
        textEntrada.setHorizontalAlignment(textEntrada.CENTER);
        gbcResgistrarPagamento.gridy = 2;
        gbcResgistrarPagamento.gridx = 2;
        acaoPanel.add(textEntrada, gbcResgistrarPagamento);

        //criando labelSaida
        gbcResgistrarPagamento.gridx = 0;
        gbcResgistrarPagamento.gridy = 3;
        labelSaida = new JLabel("Data de Saída: ");
        labelSaida.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelSaida, gbcResgistrarPagamento);

        //criando textSaida,posicionamento e adicionado ao panel
        textSaida = new JTextField(20);
        textSaida.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textSaida.setEditable(false);
        String saida = String.valueOf(reserva.getSaida());
        textSaida.setText(saida);
        textSaida.setHorizontalAlignment(textSaida.CENTER);
        gbcResgistrarPagamento.gridy = 3;
        gbcResgistrarPagamento.gridx = 2;
        acaoPanel.add(textSaida, gbcResgistrarPagamento);

        //criando labelClienteNome
        gbcResgistrarPagamento.gridx = 0;
        gbcResgistrarPagamento.gridy = 4;
        labelClienteNome = new JLabel("Nome do Cliente: ");
        labelClienteNome.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelClienteNome, gbcResgistrarPagamento);

        //criando textClienteNome,posicionamento e adicionado ao panel
        textClienteNome = new JTextField(20);
        textClienteNome.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textClienteNome.setEditable(false);
        textClienteNome.setText(reserva.getCliente().getNome());
        textClienteNome.setHorizontalAlignment(textClienteNome.CENTER);
        gbcResgistrarPagamento.gridy = 4;
        gbcResgistrarPagamento.gridx = 2;
        acaoPanel.add(textClienteNome, gbcResgistrarPagamento);

        //criando labelClienteCPF
        gbcResgistrarPagamento.gridx = 0;
        gbcResgistrarPagamento.gridy = 5;
        labelClienteCPF = new JLabel("CPF do Cliente: ");
        labelClienteCPF.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelClienteCPF, gbcResgistrarPagamento);

        //criando textClienteCPF,posicionamento e adicionado ao panel
        textClienteCPF = new JTextField(20);
        textClienteCPF.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textClienteCPF.setEditable(false);
        textClienteCPF.setText(reserva.getCliente().getCPF());
        textClienteCPF.setHorizontalAlignment(textClienteCPF.CENTER);
        gbcResgistrarPagamento.gridy = 5;
        gbcResgistrarPagamento.gridx = 2;
        acaoPanel.add(textClienteCPF, gbcResgistrarPagamento);

        //criando labelQuartoNumero
        gbcResgistrarPagamento.gridx = 0;
        gbcResgistrarPagamento.gridy = 6;
        labelQuartoNumero = new JLabel("Número do Quarto: ");
        labelQuartoNumero.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelQuartoNumero, gbcResgistrarPagamento);

        //criando textQuartoNumero,posicionamento e adicionado ao panel
        textQuartoNumero = new JTextField(20);
        textQuartoNumero.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textQuartoNumero.setEditable(false);
        String numero = String.valueOf(reserva.getQuarto().getNumero());
        textQuartoNumero.setText(numero);
        textQuartoNumero.setHorizontalAlignment(textQuartoNumero.CENTER);
        gbcResgistrarPagamento.gridy = 6;
        gbcResgistrarPagamento.gridx = 2;
        acaoPanel.add(textQuartoNumero, gbcResgistrarPagamento);

        //criando labelQuartoPreco
        gbcResgistrarPagamento.gridx = 0;
        gbcResgistrarPagamento.gridy = 7;
        labelQuartoPreco = new JLabel("Preço do Quarto: ");
        labelQuartoPreco.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelQuartoPreco, gbcResgistrarPagamento);

        //criando textQuartoPreco,posicionamento e adicionado ao panel
        textQuartoPreco = new JTextField(20);
        textQuartoPreco.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textQuartoPreco.setEditable(false);
        String precoQuarto = String.valueOf(reserva.getQuarto().getPreco());
        textQuartoPreco.setText("R$ " + precoQuarto);
        textQuartoPreco.setHorizontalAlignment(textQuartoPreco.CENTER);
        gbcResgistrarPagamento.gridy = 7;
        gbcResgistrarPagamento.gridx = 2;
        acaoPanel.add(textQuartoPreco, gbcResgistrarPagamento);

        //criando labelValorDesconto
        gbcResgistrarPagamento.gridx = 0;
        gbcResgistrarPagamento.gridy = 8;
        labelValorDesconto = new JLabel("Desconto: ");
        labelValorDesconto.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelValorDesconto, gbcResgistrarPagamento);

        //criando textValorDesconto,posicionamento e adicionado ao panel
        textValorDesconto = new JTextField(20);
        textValorDesconto.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textValorDesconto.setEditable(false);
        String desconto = String.valueOf(reserva.getDesconto());
        textValorDesconto.setText(desconto + " %");
        textValorDesconto.setHorizontalAlignment(textValorDesconto.CENTER);
        gbcResgistrarPagamento.gridy = 8;
        gbcResgistrarPagamento.gridx = 2;
        acaoPanel.add(textValorDesconto, gbcResgistrarPagamento);

        //criando labelPreco
        gbcResgistrarPagamento.gridx = 0;
        gbcResgistrarPagamento.gridy = 9;
        labelPreco = new JLabel("Valor Total sem Desconto: ");
        labelPreco.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelPreco, gbcResgistrarPagamento);

        //criando textPreco,posicionamento e adicionado ao panel
        textPreco = new JTextField(20);
        textPreco.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textPreco.setEditable(false);
        String precoParcial = String.valueOf(reserva.getPreco());
        textPreco.setText("R$ " + precoParcial);
        textPreco.setHorizontalAlignment(textPreco.CENTER);
        gbcResgistrarPagamento.gridy = 9;
        gbcResgistrarPagamento.gridx = 2;
        acaoPanel.add(textPreco, gbcResgistrarPagamento);

        //criando label valorPagamento
        gbcResgistrarPagamento.gridx = 0;
        gbcResgistrarPagamento.gridy = 10;
        NovoLabelValorPagamento = new JLabel("Valor Total da Reserva: ");
        NovoLabelValorPagamento.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(NovoLabelValorPagamento, gbcResgistrarPagamento);

        //criando NovoTextValorPagamento,posicionamento e adicionado ao panel
        NovoTextValorPagamento = new JTextField(20);
        NovoTextValorPagamento.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        NovoTextValorPagamento.setEditable(false);
        String preco = String.valueOf(reserva.getValorTotal());
        NovoTextValorPagamento.setText("R$ " + preco);
        NovoTextValorPagamento.setHorizontalAlignment(NovoTextValorPagamento.CENTER);
        gbcResgistrarPagamento.gridy = 10;
        gbcResgistrarPagamento.gridx = 2;
        acaoPanel.add(NovoTextValorPagamento, gbcResgistrarPagamento);

        //criando labelValorPago
        gbcResgistrarPagamento.gridx = 0;
        gbcResgistrarPagamento.gridy = 11;
        labelValorPago = new JLabel("Valor da Diária: ");
        labelValorPago.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelValorPago, gbcResgistrarPagamento);

        //criando textValorPago,posicionamento e adicionado ao panel
        textValorPago = new JTextField(20);
        textValorPago.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textValorPago.setEditable(false);
        String diaria = String.valueOf(reserva.getQuarto().getPreco());
        textValorPago.setText("R$ " + diaria);
        textValorPago.setHorizontalAlignment(textValorPago.CENTER);
        gbcResgistrarPagamento.gridy = 11;
        gbcResgistrarPagamento.gridx = 2;
        acaoPanel.add(textValorPago, gbcResgistrarPagamento);

        //Botão botaoRegistrarPagamento2- o botao botaoRegistrarPagamento está sendo usado no EscolhaPagamento
        botaoRealizarPagamentoDiaria = new JButton("Realizar Pagamento Diária  ");
        botaoRealizarPagamentoDiaria.setBackground(new Color(183, 221, 120));
        botaoRealizarPagamentoDiaria.setFont(new Font("SansSerif", Font.BOLD, 15));
        gbcResgistrarPagamento.gridx = 2;
        gbcResgistrarPagamento.gridy = 13;
        acaoPanel.add(botaoRealizarPagamentoDiaria, gbcResgistrarPagamento);
        botaoRealizarPagamentoDiaria.addActionListener(a -> {
            try {
                ctrPousada.sitPagReserva(reserva.getCodigo());
                ctrPousada.atualizaReservaValorPago(reserva.getCodigo(), reserva.getQuarto().getPreco());
                ctrPousada.pagDiaria(reserva.getValorTotal(), reserva, reserva.getQuarto().getPreco());
                //ctrPousada.cadPagamentoCodigo(reserva.getCodigo());
                JOptionPane.showMessageDialog(null,
                        "Pagamento da diária da reserva "
                        + reserva.getCodigo()
                        + " efetuado!");
                EscolhaPagamento();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro!");
                EscolhaPagamento();
            }

        });

        acaoPanel.validate();
        acaoPanel.repaint();
        framePrincipal.validate();
        framePrincipal.setTitle("Realizar Pagamento Diária");
    }

    private void SelecionarReservaCheckOut() {
        //limpar frame
        acaoPanel.removeAll();

        //ajustando  GridBag
        GridBagConstraints gbcResgistrarPagamento = new GridBagConstraints();
        gbcResgistrarPagamento.insets = new Insets(5, 5, 5, 5);

        //criando NovoLabelReservaPagamento adicionando para o panel
        NovoLabelReservaPagamento = new JLabel("Número da Reserva: ");
        NovoLabelReservaPagamento.setFont(new Font("SansSerif", Font.BOLD, 15));
        gbcResgistrarPagamento.gridx = 0;
        gbcResgistrarPagamento.gridy = 0;
        acaoPanel.add(NovoLabelReservaPagamento, gbcResgistrarPagamento);

        //criando NovoTextReservaPagamento,posicionamento e adicionado ao panel
        NovoTextReservaPagamento = new JTextField(20);
        NovoTextReservaPagamento.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        NovoTextReservaPagamento.setHorizontalAlignment(NovoTextReservaPagamento.CENTER);
        gbcResgistrarPagamento.gridy = 0;
        gbcResgistrarPagamento.gridx = 1;
        acaoPanel.add(NovoTextReservaPagamento, gbcResgistrarPagamento);

        //Botão Quarto
        bPagamento = new JButton("Verificar Reserva");
        bPagamento.setBackground(new Color(183, 221, 120));
        bPagamento.setFont(new Font("SansSerif", Font.BOLD, 15));
        gbcResgistrarPagamento.gridx = 5;
        gbcResgistrarPagamento.gridy = 0;
        acaoPanel.add(bPagamento, gbcResgistrarPagamento);
        bPagamento.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    reserva = ctrPousada.selReserva(Integer.parseInt(NovoTextReservaPagamento.getText()));
                    JOptionPane.showMessageDialog(null,
                            "Reserva "
                            + NovoTextReservaPagamento.getText()
                            + " registrada!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro - Selecionar Reserva!");
                }
            }
        });

        //Botão botaoRegistrarPagamento2- o botao botaoRegistrarPagamento está sendo usado no EscolhaPagamento
        botaoRegistrarPagamento2 = new JButton("Realizar Check-out");
        botaoRegistrarPagamento2.setBackground(new Color(183, 221, 120));
        botaoRegistrarPagamento2.setFont(new Font("SansSerif", Font.BOLD, 15));
        gbcResgistrarPagamento.gridx = 1;
        gbcResgistrarPagamento.gridy = 3;
        acaoPanel.add(botaoRegistrarPagamento2, gbcResgistrarPagamento);
        botaoRegistrarPagamento2.addActionListener(a -> {
            try {
                RealizarPagamentoCheckOut(Integer.parseInt(NovoTextReservaPagamento.getText()));

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro! - CheckOut");
                EscolhaPagamento();
            }

        });

        acaoPanel.validate();
        acaoPanel.repaint();
        framePrincipal.validate();
        framePrincipal.setTitle("Realizar Check-out");
    }

    private void SelecionarReservaPagamento() {
        //limpar frame
        acaoPanel.removeAll();

        //ajustando  GridBag
        GridBagConstraints gbcResgistrarPagamento = new GridBagConstraints();
        gbcResgistrarPagamento.insets = new Insets(5, 5, 5, 5);

        //criando NovoLabelReservaPagamento adicionando para o panel
        NovoLabelReservaPagamento = new JLabel("Número da Reserva: ");
        NovoLabelReservaPagamento.setFont(new Font("SansSerif", Font.BOLD, 15));
        gbcResgistrarPagamento.gridx = 0;
        gbcResgistrarPagamento.gridy = 0;
        acaoPanel.add(NovoLabelReservaPagamento, gbcResgistrarPagamento);

        //criando NovoTextReservaPagamento,posicionamento e adicionado ao panel
        NovoTextReservaPagamento = new JTextField(20);
        NovoTextReservaPagamento.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        NovoTextReservaPagamento.setHorizontalAlignment(NovoTextReservaPagamento.CENTER);
        gbcResgistrarPagamento.gridy = 0;
        gbcResgistrarPagamento.gridx = 1;
        acaoPanel.add(NovoTextReservaPagamento, gbcResgistrarPagamento);

        //Botão Quarto
        bPagamento = new JButton("Verificar Reserva");
        bPagamento.setBackground(new Color(183, 221, 120));
        bPagamento.setFont(new Font("SansSerif", Font.BOLD, 15));
        gbcResgistrarPagamento.gridx = 5;
        gbcResgistrarPagamento.gridy = 0;
        acaoPanel.add(bPagamento, gbcResgistrarPagamento);
        bPagamento.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    reserva = ctrPousada.selReserva(Integer.parseInt(NovoTextReservaPagamento.getText()));
                    JOptionPane.showMessageDialog(null,
                            "Reserva "
                            + NovoTextReservaPagamento.getText()
                            + " registrada!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro - Selecionar Reserva!");
                }
            }
        });

        //Botão botaoRegistrarPagamento2- o botao botaoRegistrarPagamento está sendo usado no EscolhaPagamento
        botaoRegistrarPagamento2 = new JButton("Registrar Pagamento");
        botaoRegistrarPagamento2.setBackground(new Color(183, 221, 120));
        botaoRegistrarPagamento2.setFont(new Font("SansSerif", Font.BOLD, 15));
        gbcResgistrarPagamento.gridx = 1;
        gbcResgistrarPagamento.gridy = 3;
        acaoPanel.add(botaoRegistrarPagamento2, gbcResgistrarPagamento);
        botaoRegistrarPagamento2.addActionListener(a -> {
            try {
                RealizarPagamentoRestante(reserva);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro! - Final");
                EscolhaPagamento();
            }

        });

        acaoPanel.validate();
        acaoPanel.repaint();
        framePrincipal.validate();
        framePrincipal.setTitle("Registrar Pagamento");
    }

    private void SelecionarReservaDiaria() throws Exception {
        //limpar frame
        acaoPanel.removeAll();

        //ajustando  GridBag
        GridBagConstraints gbcResgistrarPagamento = new GridBagConstraints();
        gbcResgistrarPagamento.insets = new Insets(5, 5, 5, 5);

        //criando NovoLabelReservaPagamento adicionando para o panel
        NovoLabelReservaPagamento = new JLabel("Número da Reserva: ");
        NovoLabelReservaPagamento.setFont(new Font("SansSerif", Font.BOLD, 15));
        gbcResgistrarPagamento.gridx = 0;
        gbcResgistrarPagamento.gridy = 0;
        acaoPanel.add(NovoLabelReservaPagamento, gbcResgistrarPagamento);

        //criando NovoTextReservaPagamento,posicionamento e adicionado ao panel
        NovoTextReservaPagamento = new JTextField(20);
        NovoTextReservaPagamento.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        NovoTextReservaPagamento.setHorizontalAlignment(NovoTextReservaPagamento.CENTER);
        gbcResgistrarPagamento.gridy = 0;
        gbcResgistrarPagamento.gridx = 1;
        acaoPanel.add(NovoTextReservaPagamento, gbcResgistrarPagamento);

        //Botão Quarto
        bPagamento = new JButton("Verificar Reserva");
        bPagamento.setBackground(new Color(183, 221, 120));
        bPagamento.setFont(new Font("SansSerif", Font.BOLD, 15));
        gbcResgistrarPagamento.gridx = 5;
        gbcResgistrarPagamento.gridy = 0;
        acaoPanel.add(bPagamento, gbcResgistrarPagamento);
        bPagamento.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    reserva = ctrPousada.selReserva(Integer.parseInt(NovoTextReservaPagamento.getText()));
                    boolean retorno = ctrPousada.verificaCodigo(reserva.getCodigo());
                    if (retorno == true) {
                        JOptionPane.showMessageDialog(null,
                                "Não existe Reserva "
                                + NovoTextReservaPagamento.getText());
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Reserva "
                                + NovoTextReservaPagamento.getText()
                                + " registrada!");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro - Selecionar Reserva!");
                }
            }
        });

        //Botão botaoRegistrarPagamento2- o botao botaoRegistrarPagamento está sendo usado no EscolhaPagamento
        botaoRegistrarPagamento2 = new JButton("Registrar Pagamento Diária ");
        botaoRegistrarPagamento2.setBackground(new Color(183, 221, 120));
        botaoRegistrarPagamento2.setFont(new Font("SansSerif", Font.BOLD, 15));
        gbcResgistrarPagamento.gridx = 1;
        gbcResgistrarPagamento.gridy = 3;
        acaoPanel.add(botaoRegistrarPagamento2, gbcResgistrarPagamento);
        botaoRegistrarPagamento2.addActionListener(a -> {
            try {
                RealizarPagamentoDiaria(reserva);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro! - Final");
                EscolhaPagamento();
            }

        });

        acaoPanel.validate();
        acaoPanel.repaint();
        framePrincipal.validate();
        framePrincipal.setTitle("Registrar Pagamento Diária");

    }

    private void VerificarPagamentoDiaria() {

        //limpar frame
        acaoPanel.removeAll();

        //ajustando  GridBag
        GridBagConstraints gbcVerificarPagamento = new GridBagConstraints();
        gbcVerificarPagamento.insets = new Insets(5, 5, 5, 5);

        //criando label Número da Reserva
        gbcVerificarPagamento.gridx = 0;
        //Criar botão verificar reserva Pagamento
        gbcVerificarPagamento.gridy = 0;
        labelNumeroReservaVQ = new JLabel("Reserva: ");
        labelNumeroReservaVQ.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelNumeroReservaVQ, gbcVerificarPagamento);

        //criando textfield para digitar o Número da reserva 
        textReservaConsultaVQ = new JTextField(20);
        textReservaConsultaVQ.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textReservaConsultaVQ.setHorizontalAlignment(textReservaConsultaVQ.CENTER);
        gbcVerificarPagamento.gridy = 0;
        gbcVerificarPagamento.gridx = 1;
        acaoPanel.add(textReservaConsultaVQ, gbcVerificarPagamento);

        //Criar botão verificar reserva Pagamento
        //o botao é chamado  botaoVerificarPagamento2 pois na EscolhaPagamento já tem um botaoVerificarPagamento
        gbcVerificarPagamento.gridx = 1;
        gbcVerificarPagamento.gridy = 2;
        botaoVerificarPagamento2 = new JButton("Verificar Pagamento Diária");
        botaoVerificarPagamento2.setBackground(new Color(183, 221, 120));
        botaoVerificarPagamento2.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoVerificarPagamento2.addActionListener(b -> {
            //Ação
            try {
                String pagamento;
                pagamento = ctrPousada.verificarPagamentoDiaria(Integer.parseInt(textReservaConsultaVQ.getText()));
                if (pagamento.equals("")) {
                    JOptionPane.showMessageDialog(null, "Diária da Reserva "
                            + textReservaConsultaVQ.getText()
                            + " ainda não foi paga!");
                } else {
                    JOptionPane.showMessageDialog(null, pagamento);
                }

                // voltar para a tela EscolhaPagamento
                EscolhaPagamento();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro!");
                // voltar para a tela EscolhaPagamento
                EscolhaPagamento();
            }
        });
        acaoPanel.add(botaoVerificarPagamento2, gbcVerificarPagamento);

        //update
        acaoPanel.validate();
        acaoPanel.repaint();
        framePrincipal.validate();
        framePrincipal.setTitle("Verificar Pagamento Diária");

    }

    /*     QUARTO     */
    private void EscolhaQuarto() {
        //limpar frame
        acaoPanel.removeAll();
        acaoPanel.setBackground(new Color(238, 238, 238));

        //Panel -> escolha
        //ajustando  GridBag
        GridBagConstraints gbcEscolhaQuaro = new GridBagConstraints();
        gbcEscolhaQuaro.insets = new Insets(5, 5, 5, 5);

        //criando labelEscolha
        gbcEscolhaQuaro.gridx = 0;
        gbcEscolhaQuaro.gridy = 0;
        EscolhaQuarto = new JLabel("Escolha a opção desejada:");
        EscolhaQuarto.setFont(new Font("Calibri", Font.PLAIN, 40));
        //adicionar o label no panel
        acaoPanel.add(EscolhaQuarto, gbcEscolhaQuaro);

        //Criar botão Adicionar quarto
        gbcEscolhaQuaro.gridx = 0;
        gbcEscolhaQuaro.gridy = 1;
        botaoAdicionarQuarto = new JButton("Adicionar Quarto");
        botaoAdicionarQuarto.setBackground(new Color(183, 221, 120));
        botaoAdicionarQuarto.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoAdicionarQuarto.setPreferredSize(new Dimension(250, 30));
        botaoAdicionarQuarto.addActionListener(a -> {
            acaoPanel.removeAll();
            try {
                RegistrarQuarto();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro na gravação do Quarto no arquivo", JOptionPane.ERROR_MESSAGE);
            }
        });
        //adicinar botao
        acaoPanel.add(botaoAdicionarQuarto, gbcEscolhaQuaro);

        //Criar botão Remover quarto
        gbcEscolhaQuaro.gridx = 0;
        gbcEscolhaQuaro.gridy = 2;
        botaoRemoverQuarto = new JButton("Remover Quarto");
        botaoRemoverQuarto.setBackground(new Color(183, 221, 120));
        botaoRemoverQuarto.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoRemoverQuarto.setPreferredSize(new Dimension(250, 30));
        botaoRemoverQuarto.addActionListener(b -> {
            acaoPanel.removeAll();
            RemoverQuarto();
        });
        //adicinar botao
        acaoPanel.add(botaoRemoverQuarto, gbcEscolhaQuaro);

        //Criar botão Consultar quarto
        gbcEscolhaQuaro.gridx = 0;
        gbcEscolhaQuaro.gridy = 3;
        botaoConsultarQuarto = new JButton("Consultar Quarto");
        botaoConsultarQuarto.setBackground(new Color(183, 221, 120));
        botaoConsultarQuarto.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoConsultarQuarto.setPreferredSize(new Dimension(250, 30));
        botaoConsultarQuarto.addActionListener(b -> {
            acaoPanel.removeAll();
            ConsultarQuarto();
        });
        //adicinar botao
        acaoPanel.add(botaoConsultarQuarto, gbcEscolhaQuaro);

        //Criar botão Listar quartos
        gbcEscolhaQuaro.gridx = 0;
        gbcEscolhaQuaro.gridy = 4;
        botaoListarQuartos = new JButton("Listar Quartos");
        botaoListarQuartos.setBackground(new Color(183, 221, 120));
        botaoListarQuartos.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoListarQuartos.setPreferredSize(new Dimension(250, 30));
        botaoListarQuartos.addActionListener(b -> {
            acaoPanel.removeAll();
            try {
                ListarQuartos();
                EscolhaQuarto();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro!");
                EscolhaQuarto();
            }
        });
        //adicinar botao
        acaoPanel.add(botaoListarQuartos, gbcEscolhaQuaro);

        //Criar botão alterar quarto
        gbcEscolhaQuaro.gridx = 0;
        gbcEscolhaQuaro.gridy = 5;
        botaoAlterarQuarto = new JButton("Alterar Quarto");
        botaoAlterarQuarto.setBackground(new Color(183, 221, 120));
        botaoAlterarQuarto.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoAlterarQuarto.setPreferredSize(new Dimension(250, 30));
        botaoAlterarQuarto.addActionListener(b -> {
            acaoPanel.removeAll();
            EscolheNumeroQuarto();
        });
        //adicinar botao
        acaoPanel.add(botaoAlterarQuarto, gbcEscolhaQuaro);

        //Clean
        acaoPanel.validate();
        acaoPanel.repaint();
        framePrincipal.validate();

        framePrincipal.setTitle("Quarto ");

    }

    private void RegistrarQuarto() throws Exception {
        //limpar frame
        acaoPanel.removeAll();

        //ajustando  GridBag
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.insets = new Insets(5, 5, 5, 5);

        //criando labelNumeroQuarto e adicionando para o panel
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        labelNumeroQuarto = new JLabel("Número: ");
        labelNumeroQuarto.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelNumeroQuarto, gbc2);

        //criando textNumQuarto,posicionamento e adicionado ao panel
        textNumQuarto = new JTextField(20);
        textNumQuarto.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textNumQuarto.setHorizontalAlignment(textNumQuarto.CENTER);
        gbc2.gridy = 0;
        gbc2.gridx = 1;
        acaoPanel.add(textNumQuarto, gbc2);

        //criando labelPrecoQuarto adicionando para o panel
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        labelPrecoQuarto = new JLabel("Preço: ");
        labelPrecoQuarto.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelPrecoQuarto, gbc2);

        //criando textPrecoQuarto,posicionamento e adicionado ao panel
        textPrecoQuarto = new JTextField(20);
        textPrecoQuarto.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textPrecoQuarto.setHorizontalAlignment(textPrecoQuarto.CENTER);
        gbc2.gridy = 1;
        gbc2.gridx = 1;
        acaoPanel.add(textPrecoQuarto, gbc2);

        //criando labelDescricao adicionando para o panel
        gbc2.gridx = 0;
        gbc2.gridy = 2;
        labelDescricao = new JLabel("Descrição : ");
        labelDescricao.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelDescricao, gbc2);

        //criando textAreaQuartoDescricao,posicionamento e adicionado ao panel
        textAreaQuartoDescricao = new JTextArea(5, 20);
        gbc2.gridy = 2;
        gbc2.gridx = 1;
        acaoPanel.add(textAreaQuartoDescricao, gbc2);

        //Botão cadastrar gerente
        b2 = new JButton("Cadastrar  Quarto");
        b2.setBackground(new Color(183, 221, 120));
        b2.setFont(new Font("SansSerif", Font.BOLD, 15));
        gbc2.gridx = 1;
        gbc2.gridy = 3;
        acaoPanel.add(b2, gbc2);
        b2.addActionListener(a -> {
            try {
                ctrPousada.cadQuarto(
                        Double.parseDouble(textPrecoQuarto.getText().trim()),
                        textAreaQuartoDescricao.getText(),
                        Integer.parseInt(textNumQuarto.getText().trim()));
                JOptionPane.showMessageDialog(null, "Quarto cadastrado com sucesso!");
                EscolhaQuarto();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro!");
                EscolhaQuarto();
            }
        });

        acaoPanel.validate();
        acaoPanel.repaint();
        framePrincipal.validate();
        framePrincipal.setTitle("Cadastrar Quarto ");
    }

    private void RemoverQuarto() {
        //limpar frame
        acaoPanel.removeAll();

        //ajustando  GridBag
        GridBagConstraints gbcQuartoRemover = new GridBagConstraints();
        gbcQuartoRemover.insets = new Insets(5, 5, 5, 5);

        //criando labelNumeroRemocao
        gbcQuartoRemover.gridx = 0;
        gbcQuartoRemover.gridy = 0;
        labelNumeroRemocao = new JLabel("Número: ");
        labelNumeroRemocao.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelNumeroRemocao, gbcQuartoRemover);

        //criando textNumeroRemocao para digitar o Numero para a remoção
        textNumeroRemocao = new JTextField(20);
        textNumeroRemocao.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textNumeroRemocao.setHorizontalAlignment(textNumeroRemocao.CENTER);
        gbcQuartoRemover.gridy = 0;
        gbcQuartoRemover.gridx = 1;
        acaoPanel.add(textNumeroRemocao, gbcQuartoRemover);

        //Criar botaoRemoverQuarto
        gbcQuartoRemover.gridx = 1;
        gbcQuartoRemover.gridy = 2;
        botaoRemoverQuarto2 = new JButton("Remover Quarto");
        botaoRemoverQuarto2.setBackground(new Color(183, 221, 120));
        botaoRemoverQuarto2.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoRemoverQuarto2.addActionListener(b -> {
            //Ação
            try {
                boolean retorno = ctrPousada.remQuarto(Integer.parseInt(textNumeroRemocao.getText()));

                if (retorno == true) {
                    JOptionPane.showMessageDialog(null, "Quarto removido com sucesso!");
                    EscolhaQuarto();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Quarto não removido!\nNão existe quarto "
                            + textNumeroRemocao.getText());
                    EscolhaQuarto();
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro!" + "\n" + "Quarto não foi removido!");
                EscolhaQuarto();
            }
        });
        acaoPanel.add(botaoRemoverQuarto2, gbcQuartoRemover);

        //update
        acaoPanel.validate();
        acaoPanel.repaint();
        framePrincipal.validate();
        framePrincipal.setTitle("Remover Quarto ");
    }

    private void ConsultarQuarto() {

        //limpar frame
        acaoPanel.removeAll();

        //ajustando  GridBag
        GridBagConstraints gbcQuartoConsultar = new GridBagConstraints();
        gbcQuartoConsultar.insets = new Insets(5, 5, 5, 5);

        //criando label Numero
        gbcQuartoConsultar.gridx = 0;
        gbcQuartoConsultar.gridy = 0;
        labelNumeroConsulta = new JLabel("Número: ");
        labelNumeroConsulta.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelNumeroConsulta, gbcQuartoConsultar);

        //criando textfield para digitar o Número
        textNumeroConsulta = new JTextField(20);
        textNumeroConsulta.setHorizontalAlignment(textNumeroConsulta.CENTER);
        gbcQuartoConsultar.gridy = 0;
        gbcQuartoConsultar.gridx = 1;
        acaoPanel.add(textNumeroConsulta, gbcQuartoConsultar);

        //Criar botão Excluir Cliente
        //o botao é chamado botaoConsultarQuarto, pois na função escolha já utiliza o  botaoConsultarQuarto2
        gbcQuartoConsultar.gridx = 1;
        gbcQuartoConsultar.gridy = 2;
        botaoConsultarQuarto2 = new JButton("Consultar Quarto");
        botaoConsultarQuarto2.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoConsultarQuarto2.setBackground(new Color(183, 221, 120));
        botaoConsultarQuarto2.addActionListener(b -> {
            //Ação
            try {
                String quarto = ctrPousada.consultarQuarto(Integer.parseInt(textNumeroConsulta.getText()));
                if (quarto == "") {
                    JOptionPane.showMessageDialog(null,
                            "Não existe quarto de número "
                            + textNumeroConsulta.getText());
                } else {
                    JOptionPane.showMessageDialog(null, quarto);
                    EscolhaQuarto();
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro!");
                EscolhaQuarto();
            }
        });
        acaoPanel.add(botaoConsultarQuarto2, gbcQuartoConsultar);

        //update
        acaoPanel.validate();
        acaoPanel.repaint();
        framePrincipal.validate();
        framePrincipal.setTitle("Consultar Quarto ");
    }

    private void EscolheNumeroQuarto() {

        //limpar frame
        acaoPanel.removeAll();

        //ajustando  GridBag
        GridBagConstraints gbcQuartoAlterar = new GridBagConstraints();
        gbcQuartoAlterar.insets = new Insets(5, 5, 5, 5);

        //criando label Numero
        gbcQuartoAlterar.gridx = 0;
        gbcQuartoAlterar.gridy = 0;
        labelNumeroAlterar = new JLabel("Número: ");
        labelNumeroAlterar.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelNumeroAlterar, gbcQuartoAlterar);

        //criando textfield para digitar o Número
        textNumeroAlterar = new JTextField(20);
        textNumeroAlterar.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textNumeroAlterar.setHorizontalAlignment(textNumeroAlterar.CENTER);
        gbcQuartoAlterar.gridy = 0;
        gbcQuartoAlterar.gridx = 1;
        acaoPanel.add(textNumeroAlterar, gbcQuartoAlterar);

        //Criar botão Alterar Quarto
        //o botao é chamado botaoAlterarQuarto, pois na função escolha já utiliza o  botaoAlterarQuarto2
        gbcQuartoAlterar.gridx = 1;
        gbcQuartoAlterar.gridy = 2;
        botaoAlterarQuarto2 = new JButton("Alterar Quarto");
        botaoAlterarQuarto2.setBackground(new Color(183, 221, 120));
        botaoAlterarQuarto2.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoAlterarQuarto2.addActionListener(b -> {
            try {
                //Ação
                boolean retorno = ctrPousada.verificarQuarto(Integer.parseInt(textNumeroAlterar.getText()));
                if (retorno == true) {
                    AlterarQuarto(Integer.parseInt(textNumeroAlterar.getText()));
                    //EscolhaQuarto();
                } else {
                    JOptionPane.showMessageDialog(null, "Não existe quarto com o código " + textNumeroAlterar.getText());
                    EscolhaQuarto();
                }
            } catch (Exception ex) {

            }

        });
        acaoPanel.add(botaoAlterarQuarto2, gbcQuartoAlterar);

        //update
        acaoPanel.validate();
        acaoPanel.repaint();
        framePrincipal.validate();
        framePrincipal.setTitle("Alterar Quarto ");
    }

    private void AlterarQuarto(int pNumero) {
        //limpar frame
        acaoPanel.removeAll();

        //ajustando  GridBag
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.insets = new Insets(5, 5, 5, 5);

        //criando labelNumeroQuarto e adicionando para o panel
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        labelNumeroQuartoAlterar = new JLabel("Número: ");
        labelNumeroQuartoAlterar.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelNumeroQuartoAlterar, gbc2);

        //criando textPreçoQuarto,posicionamento e adicionado ao panel
        //textNumQuartoAlterar = new JTextField(20);
        gbc2.gridy = 0;
        gbc2.gridx = 1;
        String numero = Integer.toString(pNumero);
        NumQuartoAlterar = new JLabel(numero);
        NumQuartoAlterar.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(NumQuartoAlterar, gbc2);

        //criando labelPreçoQuarto adicionando para o panel
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        labelPrecoQuartoAlterar = new JLabel("Preço: ");
        labelPrecoQuartoAlterar.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelPrecoQuartoAlterar, gbc2);

        //criando  textPreçoQuarto,posicionamento e adicionado ao panel
        textPrecoQuartoAlterar = new JTextField(20);
        textPrecoQuartoAlterar.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textPrecoQuartoAlterar.setHorizontalAlignment(textPrecoQuartoAlterar.CENTER);
        gbc2.gridy = 1;
        gbc2.gridx = 1;
        acaoPanel.add(textPrecoQuartoAlterar, gbc2);

        //criando labelDescriçao adicionando para o panel
        gbc2.gridx = 0;
        gbc2.gridy = 2;
        labelDescricaoAlterar = new JLabel("Descrição : ");
        labelDescricaoAlterar.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelDescricaoAlterar, gbc2);

        //criando   textTelefoneCliente,posicionamento e adicionado ao panel
        textAreaQuartoDescricaoAlterar = new JTextArea(5, 20);
        textAreaQuartoDescricaoAlterar.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        gbc2.gridy = 2;
        gbc2.gridx = 1;
        acaoPanel.add(textAreaQuartoDescricaoAlterar, gbc2);

        //Botão cadastrar gerente
        b2 = new JButton("Alterar  Quarto");
        b2.setBackground(new Color(183, 221, 120));
        b2.setFont(new Font("SansSerif", Font.BOLD, 15));
        gbc2.gridx = 1;
        gbc2.gridy = 3;
        acaoPanel.add(b2, gbc2);
        b2.addActionListener(a -> {
            try {
                ctrPousada.altQuarto(pNumero,
                        Double.parseDouble(textPrecoQuartoAlterar.getText().trim()),
                        textAreaQuartoDescricaoAlterar.getText());
                JOptionPane.showMessageDialog(null, "Quarto alterado com sucesso!");
                EscolhaQuarto();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro!");
                EscolhaQuarto();
            }

        });

        acaoPanel.validate();
        acaoPanel.repaint();
        framePrincipal.validate();
        framePrincipal.setTitle("Alterar Quarto ");
    }

    private void ListarQuartos() throws Exception {
        String[] quartos = ctrPousada.listaQuartos();

        lstQuarto = new JList(quartos);

        lstQuarto.addListSelectionListener((ListSelectionEvent e) -> {
            int index = lstQuarto.getSelectedIndex();
            try {
                JOptionPane.showMessageDialog(null,
                        ctrPousada.dadoQuartos(index),
                        "Dados do Quarto",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {

            }
        });

        JScrollPane scroll1 = new JScrollPane(lstQuarto, // componente
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, // scroll vertical
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // scrollhorizontal
        scroll1.setPreferredSize(new Dimension(320, 120));

        JOptionPane.showMessageDialog(null, scroll1);
    }

    private void ListarQuartosNumero() throws Exception {
        String[] numero = ctrPousada.listaQuartosNumeros();

        JOptionPane.showMessageDialog(null, "Escolha um dos Quartos da lista", "Números dos Quartos", JOptionPane.INFORMATION_MESSAGE);

        lstNumeroQuartos = new JList(numero);

        lstNumeroQuartos.addListSelectionListener((ListSelectionEvent e) -> {
            int index = lstNumeroQuartos.getSelectedIndex();
            try {
                quarto = ctrPousada.dadoQuartosNumero(index);
                textDescricaoQuarto.setText(quarto.getDecricao());
                String str = String.valueOf(quarto.getNumero());
                textNum.setText(str);
                textNum2.setText("R$ " + quarto.getPreco());
            } catch (Exception ex) {

            }
        });

        JScrollPane scroll1 = new JScrollPane(lstNumeroQuartos, // componente
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, // scroll vertical
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // scrollhorizontal
        scroll1.setPreferredSize(new Dimension(320, 120));

        JOptionPane.showMessageDialog(null, scroll1, "CPFs", JOptionPane.INFORMATION_MESSAGE);
    }

    /*     RESERVA     */
    private void EscolhaReserva() {
        //limpar frame
        acaoPanel.removeAll();
        acaoPanel.setBackground(new Color(238, 238, 238));

        //Panel -> escolha
        //ajustando  GridBag
        GridBagConstraints gbcEscolhaReserva = new GridBagConstraints();
        gbcEscolhaReserva.insets = new Insets(5, 5, 5, 5);

        //criando labelEscolha
        gbcEscolhaReserva.gridx = 0;
        gbcEscolhaReserva.gridy = 0;
        EscolhaReserva = new JLabel("Escolha a opção desejada: ");
        EscolhaReserva.setFont(new Font("Calibri", Font.PLAIN, 40));
        //adicionar o label no panel
        acaoPanel.add(EscolhaReserva, gbcEscolhaReserva);

        //Criar botão Verificar Disponibilidade de Quartos
        gbcEscolhaReserva.gridx = 0;
        gbcEscolhaReserva.gridy = 1;
        botaoVerificaQuartos = new JButton("Verificar Disponibilidade de Quartos");
        botaoVerificaQuartos.setBackground(new Color(183, 221, 120));
        botaoVerificaQuartos.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoVerificaQuartos.setPreferredSize(new Dimension(300, 30));
        botaoVerificaQuartos.addActionListener(a -> {
            acaoPanel.removeAll();
            try {
                VerificaDisponibilidade();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro!");
                EscolhaReserva();
            }
        });
        //adicinar botao
        acaoPanel.add(botaoVerificaQuartos, gbcEscolhaReserva);

        //Criar botão Fazer Reserva
        gbcEscolhaReserva.gridx = 0;
        gbcEscolhaReserva.gridy = 2;
        botaoFazerReserva = new JButton("Realizar Reserva");
        botaoFazerReserva.setBackground(new Color(183, 221, 120));
        botaoFazerReserva.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoFazerReserva.setPreferredSize(new Dimension(300, 30));
        botaoFazerReserva.addActionListener(b -> {
            acaoPanel.removeAll();
            FazerReserva();
        });
        //adicinar botao
        acaoPanel.add(botaoFazerReserva, gbcEscolhaReserva);

        //Criar botão Listar Reservas
        gbcEscolhaReserva.gridx = 0;
        gbcEscolhaReserva.gridy = 3;
        botaoListarReservas = new JButton("Listar Reservas");
        botaoListarReservas.setBackground(new Color(183, 221, 120));
        botaoListarReservas.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoListarReservas.setPreferredSize(new Dimension(300, 30));
        botaoListarReservas.addActionListener(b -> {
            acaoPanel.removeAll();
            try {
                ListarReservas();
                EscolhaReserva();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro!");
                EscolhaReserva();
            }
        });
        //adicinar botao
        acaoPanel.add(botaoListarReservas, gbcEscolhaReserva);

        //Criar botão Listar Reserva
        gbcEscolhaReserva.gridx = 0;
        gbcEscolhaReserva.gridy = 4;
        botaoListarReserva = new JButton("Consultar Reserva");
        botaoListarReserva.setBackground(new Color(183, 221, 120));
        botaoListarReserva.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoListarReserva.setPreferredSize(new Dimension(300, 30));
        botaoListarReserva.addActionListener(b -> {
            acaoPanel.removeAll();
            ConsultarReserva();
        });
        //adicinar botao
        acaoPanel.add(botaoListarReserva, gbcEscolhaReserva);

        //Clean
        acaoPanel.validate();
        acaoPanel.repaint();
        framePrincipal.validate();
        framePrincipal.setTitle("Reserva");
    }

    private void VerificaDisponibilidade() {
        //limpar frame
        acaoPanel.removeAll();

        //ajustando  GridBag
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.insets = new Insets(5, 5, 5, 5);

        //criando labelDataEntrada e adicionando para o panel
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        labelDataEntrada = new JLabel("Data de Entrada: ");
        labelDataEntrada.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelDataEntrada, gbc2);

        //criando TextDataEntrada,posicionamento e adicionado ao panel
        textDataEntrada = new JTextField(20);
        textDataEntrada.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textDataEntrada.setHorizontalAlignment(textDataEntrada.CENTER);
        gbc2.gridy = 0;
        gbc2.gridx = 1;
        acaoPanel.add(textDataEntrada, gbc2);

        //criando labelDataSaida adicionando para o panel
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        labelDataSaida = new JLabel("Data de Saída: ");
        labelDataSaida.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelDataSaida, gbc2);

        //criando  textDataSaida,posicionamento e adicionado ao panel
        textDataSaida = new JTextField(20);
        textDataSaida.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textDataSaida.setHorizontalAlignment(textDataSaida.CENTER);
        gbc2.gridy = 1;
        gbc2.gridx = 1;
        acaoPanel.add(textDataSaida, gbc2);

        //Botão Verificar Disponibilidade Quartos
        b2 = new JButton("Verificar Disponibilidade Quartos");
        b2.setBackground(new Color(183, 221, 120));
        b2.setFont(new Font("SansSerif", Font.BOLD, 14));
        gbc2.gridx = 1;
        gbc2.gridy = 3;
        acaoPanel.add(b2, gbc2);
        b2.addActionListener(b -> {
            //Ação
            boolean retorno;
            try {
                retorno = ctrPousada.verificaQuartos(textDataEntrada.getText(), textDataSaida.getText());
                if (retorno == true) {
                    JOptionPane.showMessageDialog(null,
                            "Existem quartos disponíveis no período: "
                            + textDataEntrada.getText() + " - "
                            + textDataSaida.getText() + "\n");

                    ConsultarCPF();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Não existem quartos disponíveis no período: "
                            + textDataEntrada.getText() + " - "
                            + textDataSaida.getText() + "\n");
                    EscolhaReserva();
                }
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro!");
            }

        });

        //update
        acaoPanel.validate();
        acaoPanel.repaint();
        framePrincipal.validate();
        framePrincipal.setTitle("Verificar Disponibilidade Quartos");
    }

    private void FazerReserva() {
        //limpar frame
        acaoPanel.removeAll();

        //ajustando  GridBag
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.insets = new Insets(5, 5, 5, 5);

        //criando labelDataEntrada e adicionando para o panel
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        labelDataEntrada = new JLabel("Data de Entrada: ");
        labelDataEntrada.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelDataEntrada, gbc2);

        //criando textDataEntrada, posicionamento e adicionado ao panel
        textDataEntrada = new JTextField(20);
        textDataEntrada.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textDataEntrada.setHorizontalAlignment(textDataEntrada.CENTER);
        gbc2.gridy = 0;
        gbc2.gridx = 1;
        acaoPanel.add(textDataEntrada, gbc2);

        //criando labelDataSaida e adicionando para o panel
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        labelDataSaida = new JLabel("Data de Saída: ");
        labelDataSaida.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelDataSaida, gbc2);

        //criando  textDataSaida, posicionamento e adicionado ao panel
        textDataSaida = new JTextField(20);
        textDataSaida.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textDataSaida.setHorizontalAlignment(textDataSaida.CENTER);
        gbc2.gridy = 1;
        gbc2.gridx = 1;
        acaoPanel.add(textDataSaida, gbc2);

        //criando labelDesconto e adicionando para o panel
        gbc2.gridx = 0;
        gbc2.gridy = 2;
        labelDesconto = new JLabel("Valor do Desconto (%): ");
        labelDesconto.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelDesconto, gbc2);

        //criando textDesconto, posicionamento e adicionado ao panel
        textDesconto = new JTextField(20);
        textDesconto.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textDesconto.setHorizontalAlignment(textDesconto.CENTER);
        gbc2.gridy = 2;
        gbc2.gridx = 1;
        acaoPanel.add(textDesconto, gbc2);

        //criando labelNumeroQuarto adicionando para o panel
        gbc2.gridx = 0;
        gbc2.gridy = 3;
        labelNumeroQuarto = new JLabel("Código da reserva: ");
        labelNumeroQuarto.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelNumeroQuarto, gbc2);

        //criando textCodigoReserva, posicionamento e adicionado ao panel
        textCodigoReserva = new JTextField(20);
        textCodigoReserva.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textCodigoReserva.setHorizontalAlignment(textCodigoReserva.CENTER);
        gbc2.gridy = 3;
        gbc2.gridx = 1;
        acaoPanel.add(textCodigoReserva, gbc2);

        //Botão Verificar Codigo Reserva
        botaoVerificarCodigoReserva = new JButton("Verificar Código");
        botaoVerificarCodigoReserva.setBackground(new Color(183, 221, 120));
        botaoVerificarCodigoReserva.setFont(new Font("SansSerif", Font.BOLD, 15));
        gbc2.gridx = 3;
        gbc2.gridy = 3;
        acaoPanel.add(botaoVerificarCodigoReserva, gbc2);

        botaoVerificarCodigoReserva.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (ctrPousada.verificaCodigo(Integer.parseInt(textCodigoReserva.getText())) == false) {
                        JOptionPane.showMessageDialog(null,
                                "Já existe reserva de código " + textCodigoReserva.getText() + "!",
                                "Código da Reserva",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Código " + textCodigoReserva.getText() + " disponível!",
                                "Código da Reserva",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro!");
                }
            }
        });

        //criando labelCliente adicionando para o panel
        gbc2.gridx = 0;
        gbc2.gridy = 6;
        labelCliente = new JLabel("Cliente");
        labelCliente.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelCliente, gbc2);

        //criando labelCliente adicionando para o panel
        gbc2.gridx = 0;
        gbc2.gridy = 7;
        labelCPF = new JLabel("CPF: ");
        labelCPF.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelCPF, gbc2);

        //criando textCPF, posicionamento e adicionado ao panel
        textCPF = new JTextField(20);
        textCPF.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textCPF.setEditable(false);
        textCPF.setHorizontalAlignment(textCPF.CENTER);
        gbc2.gridy = 7;
        gbc2.gridx = 1;
        acaoPanel.add(textCPF, gbc2);

        //criando labelCliente adicionando para o panel
        gbc2.gridx = 0;
        gbc2.gridy = 8;
        labelClienteReserva = new JLabel("Nome do Cliente: ");
        labelClienteReserva.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelClienteReserva, gbc2);

        //criando textNomeClienteReserva, posicionamento e adicionado ao panel
        textNomeClienteReserva = new JTextField(20);
        textNomeClienteReserva.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textNomeClienteReserva.setEditable(false);
        textNomeClienteReserva.setHorizontalAlignment(textNomeClienteReserva.CENTER);
        gbc2.gridy = 8;
        gbc2.gridx = 1;
        acaoPanel.add(textNomeClienteReserva, gbc2);

        //Botão Cliente
        bCliente = new JButton("Adicionar Cliente");
        bCliente.setBackground(new Color(183, 221, 120));
        bCliente.setFont(new Font("SansSerif", Font.BOLD, 15));
        gbc2.gridx = 1;
        gbc2.gridy = 6;
        acaoPanel.add(bCliente, gbc2);
        bCliente.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    boolean retorno = ctrPousada.verificaQuartos(
                            textDataEntrada.getText(),
                            textDataSaida.getText());
                    if (retorno == true) {
                        ListarCPFs();
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Cliente com CPF " + textCPF.getText()
                                + " não foi cadastrado na Reserva " + textNumQuarto.getText()
                                + "\nNão existem quartos disponíveis no período!");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro!");
                }
            }
        });

        //criando labelQuarto adicionando para o panel
        gbc2.gridx = 0;
        gbc2.gridy = 9;
        labelQuarto = new JLabel("Quarto");
        labelQuarto.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelQuarto, gbc2);

        //criando labelNum adicionando para o panel
        gbc2.gridx = 0;
        gbc2.gridy = 10;
        labelNum = new JLabel("Número do quarto: ");
        labelNum.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelNum, gbc2);

        //criando textNum, posicionamento e adicionado ao panel
        textNum = new JTextField(20);
        textNum.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textNum.setEditable(false);
        textNum.setHorizontalAlignment(textNum.CENTER);
        gbc2.gridy = 10;
        gbc2.gridx = 1;
        acaoPanel.add(textNum, gbc2);

        //criando labelQPreco adicionando para o panel
        gbc2.gridx = 0;
        gbc2.gridy = 11;
        labelQPreco = new JLabel("Preço do quarto: ");
        labelQPreco.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelQPreco, gbc2);

        //criando textNum2, posicionamento e adicionado ao panel
        textNum2 = new JTextField(20);
        textNum2.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textNum2.setEditable(false);
        textNum2.setHorizontalAlignment(textNum2.CENTER);
        gbc2.gridy = 11;
        gbc2.gridx = 1;
        acaoPanel.add(textNum2, gbc2);

        //criando labelDescricaoQuarto adicionando para o panel
        gbc2.gridx = 0;
        gbc2.gridy = 12;
        labelDescricaoQuarto = new JLabel("Descrição do quarto: ");
        labelDescricaoQuarto.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelDescricaoQuarto, gbc2);

        //criando textNum2, posicionamento e adicionado ao panel
        textDescricaoQuarto = new JTextField(20);
        textDescricaoQuarto.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textDescricaoQuarto.setEditable(false);
        textDescricaoQuarto.setHorizontalAlignment(textDescricaoQuarto.CENTER);
        gbc2.gridy = 12;
        gbc2.gridx = 1;
        acaoPanel.add(textDescricaoQuarto, gbc2);

        //Botão Quarto
        bQuarto = new JButton("Adicionar Quarto");
        bQuarto.setBackground(new Color(183, 221, 120));
        bQuarto.setFont(new Font("SansSerif", Font.BOLD, 15));
        gbc2.gridx = 1;
        gbc2.gridy = 9;
        acaoPanel.add(bQuarto, gbc2);
        bQuarto.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    boolean retorno = ctrPousada.verificaQuartos(
                            textDataEntrada.getText(),
                            textDataSaida.getText());

                    if (retorno == true) {
                        ListarQuartosNumero();
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Quarto " + textNum.getText()
                                + " não foi cadastrado na Reserva " + textNumQuarto.getText()
                                + "\nNão existem quartos disponíveis no período!");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro!");
                }
            }
        });

        //Botão Realizar Reserva
        b2 = new JButton("Realizar Reserva");
        b2.setBackground(new Color(183, 221, 120));
        b2.setFont(new Font("SansSerif", Font.BOLD, 15));
        gbc2.gridx = 1;
        gbc2.gridy = 14;
        acaoPanel.add(b2, gbc2);
        b2.addActionListener(a -> {
            try {
                boolean retorno = ctrPousada.verificaQuartos(
                        textDataEntrada.getText(),
                        textDataSaida.getText());
                if (retorno == true) {
                    if (ctrPousada.realizarReserva(textDataEntrada.getText(),
                            textDataSaida.getText(),
                            Double.parseDouble(textDesconto.getText()),
                            Integer.parseInt(textCodigoReserva.getText()),
                            quarto, cliente) == true) {
                        JOptionPane.showMessageDialog(null, "Reserva realizada com sucesso!");
                        // volta para a tela EscolhaReserva
                        EscolhaReserva();
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Já existe reserva de código " + textCodigoReserva.getText() + "!",
                                "Código da Reserva",
                                JOptionPane.ERROR_MESSAGE);
                        EscolhaReserva();
                    }

                } else {
                    JOptionPane.showMessageDialog(null,
                            "Não existem quartos disponíveis no período: "
                            + textDataEntrada.getText() + " - "
                            + textDataSaida.getText() + "\n", "Quartos", JOptionPane.ERROR_MESSAGE);
                    EscolhaReserva();
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro!");
                // volta para a tela EscolhaReserva
                EscolhaReserva();
            }
        });

        //update
        acaoPanel.validate();
        acaoPanel.repaint();
        framePrincipal.validate();
        framePrincipal.setTitle("Realizar Reserva");
    }

    private void ListarReservas() throws Exception {
        String[] reservas = ctrPousada.listaReservas();

        lstReserva = new JList(reservas);

        lstReserva.addListSelectionListener((ListSelectionEvent e) -> {
            int index = lstReserva.getSelectedIndex();
            try {
                JOptionPane.showMessageDialog(null,
                        ctrPousada.dadoReservas(index),
                        "Dados da Reserva",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {

            }
        });

        JScrollPane scroll1 = new JScrollPane(lstReserva, // componente
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, // scroll vertical
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // scrollhorizontal
        scroll1.setPreferredSize(new Dimension(320, 120));

        JOptionPane.showMessageDialog(null, scroll1);
    }

    private void ConsultarReserva() {
        //limpar frame
        acaoPanel.removeAll();

        //ajustando  GridBag
        GridBagConstraints gbcClienteConsultar = new GridBagConstraints();
        gbcClienteConsultar.insets = new Insets(5, 5, 5, 5);

        //criando labelCPFConsulta
        gbcClienteConsultar.gridx = 0;
        gbcClienteConsultar.gridy = 0;
        labelNumReserva = new JLabel("Numero da reserva: ");
        labelNumReserva.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelNumReserva, gbcClienteConsultar);

        //criando textfield para digitar o CPF
        textNumReserva = new JTextField(20);
        textNumReserva.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textNumReserva.setHorizontalAlignment(textNumReserva.CENTER);
        gbcClienteConsultar.gridy = 0;
        gbcClienteConsultar.gridx = 1;
        acaoPanel.add(textNumReserva, gbcClienteConsultar);

        //Criar botaoConsultarCliente
        gbcClienteConsultar.gridx = 1;
        gbcClienteConsultar.gridy = 2;
        botaoConsultReserva = new JButton("Consultar Reserva");
        botaoConsultReserva.setBackground(new Color(183, 221, 120));
        botaoConsultReserva.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoConsultReserva.addActionListener(b -> {
            //Ação
            try {
                String reserva = ctrPousada.consultarReserva(Integer.parseInt(textNumReserva.getText()));
                if (reserva == "") {
                    JOptionPane.showMessageDialog(null, "Não existe reserva cadastrada!");
                } else {
                    JOptionPane.showMessageDialog(null, reserva);
                }

                // volta para a tela EscolhaReserva
                EscolhaReserva();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro!");
                // volta para a tela EscolhaReserva
                EscolhaReserva();
            }
        });
        acaoPanel.add(botaoConsultReserva, gbcClienteConsultar);

        //update
        acaoPanel.validate();
        acaoPanel.repaint();
        framePrincipal.validate();
        framePrincipal.setTitle("Consultar Reserva");
    }

    /*     RELATORIO     */
    private void EscolhaRelatorio() {
        //limpar frame
        acaoPanel.removeAll();
        acaoPanel.setBackground(new Color(238, 238, 238));

        //Panel -> escolha
        //ajustando  GridBag
        GridBagConstraints gbcEscolhaRelatorio = new GridBagConstraints();
        gbcEscolhaRelatorio.insets = new Insets(5, 5, 5, 5);

        //criando labelEscolha
        gbcEscolhaRelatorio.gridx = 0;
        gbcEscolhaRelatorio.gridy = 0;
        EscolhaRelatorio = new JLabel("Escolha a opção desejada: ");
        EscolhaRelatorio.setFont(new Font("Calibri", Font.PLAIN, 40));
        //adicionar o label no panel
        acaoPanel.add(EscolhaRelatorio, gbcEscolhaRelatorio);

        //Criar botão Fazer Reserva
        gbcEscolhaRelatorio.gridx = 0;
        gbcEscolhaRelatorio.gridy = 1;
        botaoRelatorioReservasCanceladas = new JButton("Relatório de reservas canceladas");
        botaoRelatorioReservasCanceladas.setBackground(new Color(183, 221, 120));
        botaoRelatorioReservasCanceladas.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoRelatorioReservasCanceladas.setPreferredSize(new Dimension(400, 30));
        botaoRelatorioReservasCanceladas.addActionListener(b -> {
            acaoPanel.removeAll();
            try {
                String str = ctrPousada.relatorioCanceladas();
                JOptionPane.showMessageDialog(null, str);
                EscolhaRelatorio();
            } catch (Exception ex) {

            }
        });
        //adicinar botao
        acaoPanel.add(botaoRelatorioReservasCanceladas, gbcEscolhaRelatorio);

        //Criar botaoRelatoioReservasNaoPagas
        gbcEscolhaRelatorio.gridx = 0;
        gbcEscolhaRelatorio.gridy = 2;
        botaoRelatoioReservasNaoPagas = new JButton("Relatório de reservas não pagas");
        botaoRelatoioReservasNaoPagas.setBackground(new Color(183, 221, 120));
        botaoRelatoioReservasNaoPagas.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoRelatoioReservasNaoPagas.setPreferredSize(new Dimension(400, 30));
        botaoRelatoioReservasNaoPagas.addActionListener(a -> {
            acaoPanel.removeAll();
            try {
                String str = ctrPousada.relatorioNaoPagas();
                JOptionPane.showMessageDialog(null, str);
                EscolhaRelatorio();
            } catch (Exception ex) {

            }
        });
        //adicinar botao
        acaoPanel.add(botaoRelatoioReservasNaoPagas, gbcEscolhaRelatorio);

        //Criar botão Listar Reservas
        gbcEscolhaRelatorio.gridx = 0;
        gbcEscolhaRelatorio.gridy = 3;
        botaoRelatorioReservasdia = new JButton("Relatório de reservas a serem efetivadas no dia");
        botaoRelatorioReservasdia.setBackground(new Color(183, 221, 120));
        botaoRelatorioReservasdia.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoRelatorioReservasdia.setPreferredSize(new Dimension(400, 30));
        botaoRelatorioReservasdia.addActionListener(b -> {
            acaoPanel.removeAll();
            try {
                String str = ctrPousada.relatorioReservasDias();
                JOptionPane.showMessageDialog(null, str);
                EscolhaRelatorio();
            } catch (Exception ex) {

            }

        });
        //adicinar botao
        acaoPanel.add(botaoRelatorioReservasdia, gbcEscolhaRelatorio);

        //Criar botão Listar Reservas
        gbcEscolhaRelatorio.gridx = 0;
        gbcEscolhaRelatorio.gridy = 4;
        botaoRelatorioReservaPeriodo = new JButton("Relatório de reservas período");
        botaoRelatorioReservaPeriodo.setBackground(new Color(183, 221, 120));
        botaoRelatorioReservaPeriodo.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoRelatorioReservaPeriodo.setPreferredSize(new Dimension(400, 30));
        botaoRelatorioReservaPeriodo.addActionListener(b -> {
            acaoPanel.removeAll();
            try {
                /*String str = ctrPousada.relatorioReservasDias();
                 JOptionPane.showMessageDialog(null, str); */
                periodoReserva();
                //EscolhaRelatorio();
            } catch (Exception ex) {

            }

        });
        //adicinar botao
        acaoPanel.add(botaoRelatorioReservaPeriodo, gbcEscolhaRelatorio);

        //Clean
        acaoPanel.validate();
        acaoPanel.repaint();
        framePrincipal.validate();
        framePrincipal.setTitle("Relatorio");
    }

    public void periodoReserva() {
        //limpar frame
        acaoPanel.removeAll();

        //ajustando  GridBag
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.insets = new Insets(5, 5, 5, 5);

        //criando labelDataEntrada e adicionando para o panel
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        labelDataEntrada = new JLabel("Data de Entrada: ");
        labelDataEntrada.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelDataEntrada, gbc2);

        //criando textDataEntrada, posicionamento e adicionado ao panel
        textDataEntrada = new JTextField(20);
        textDataEntrada.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textDataEntrada.setHorizontalAlignment(textDataEntrada.CENTER);
        gbc2.gridy = 0;
        gbc2.gridx = 1;
        acaoPanel.add(textDataEntrada, gbc2);

        //criando labelDataSaida e adicionando para o panel
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        labelDataSaida = new JLabel("Data de Saída: ");
        labelDataSaida.setFont(new Font("SansSerif", Font.BOLD, 15));
        acaoPanel.add(labelDataSaida, gbc2);

        //criando  textDataSaida, posicionamento e adicionado ao panel
        textDataSaida = new JTextField(20);
        textDataSaida.setFont(new Font("SansSerif", Font.TYPE1_FONT, 15));
        textDataSaida.setHorizontalAlignment(textDataSaida.CENTER);
        gbc2.gridy = 1;
        gbc2.gridx = 1;
        acaoPanel.add(textDataSaida, gbc2);

        //Criar botão Listar Reservas
        gbc2.gridx = 1;
        gbc2.gridy = 2;
        botaoRelatorioPeriodo = new JButton("Gerar Relatório");
        botaoRelatorioPeriodo.setBackground(new Color(183, 221, 120));
        botaoRelatorioPeriodo.setFont(new Font("SansSerif", Font.BOLD, 15));
        botaoRelatorioPeriodo.setPreferredSize(new Dimension(200, 30));
        botaoRelatorioPeriodo.addActionListener(b -> {
            acaoPanel.removeAll();
            try {
                String str = ctrPousada.relatorioReservasPeriodo(textDataEntrada.getText(), textDataSaida.getText());
                JOptionPane.showMessageDialog(null, str);
                EscolhaRelatorio();
                //EscolhaRelatorio();
            } catch (Exception ex) {

            }

        });
        //adicinar botao
        acaoPanel.add(botaoRelatorioPeriodo, gbc2);

        //Clean
        acaoPanel.validate();
        acaoPanel.repaint();
        framePrincipal.validate();
        framePrincipal.setTitle("Relatorio Reservas Periodo");
    }

}
