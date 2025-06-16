package br.com.a3bradesco.projeto.view;

import br.com.a3bradesco.projeto.util.ConexaoDataBase;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.math.BigDecimal;
import java.sql.*;
import java.text.SimpleDateFormat;
import br.com.a3bradesco.projeto.util.BancoDeDadosSimples;


public class TelaCriarConta extends JFrame {

    public TelaCriarConta() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new JPanel();
        lblCriar = new JLabel();
        lblNome = new JLabel();
        lblRg = new JLabel();
        lblCpf = new JLabel();
        lblEmail = new JLabel();
        lblSenha = new JLabel();
        lblNascimento = new JLabel();
        lblEndereco = new JLabel();

        txtNome = new JTextField();
        txtRg = new JTextField();
        txtCpf = new JTextField();
        txtEmail = new JTextField();
        txtSenha = new JPasswordField();

        spnlEndereco = new JScrollPane();
        txaEndereco = new JTextArea();

        try {
            MaskFormatter maskNascimento = new MaskFormatter("##/##/####");
            maskNascimento.setPlaceholderCharacter('_');
            fmtNascimento = new JFormattedTextField(maskNascimento);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        btnCriar = new JButton();
        btnCancelar = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Criar Nova Conta");

        lblCriar.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblCriar.setHorizontalAlignment(SwingConstants.CENTER);
        lblCriar.setText("Criar Conta");

        lblNome.setText("Nome completo:");
        lblRg.setText("RG:");
        lblCpf.setText("CPF:");
        lblEmail.setText("E-mail:");
        lblSenha.setText("Senha:");
        lblNascimento.setText("Data de nascimento (dd/MM/yyyy):");
        lblEndereco.setText("Endereço:");

        txaEndereco.setColumns(20);
        txaEndereco.setRows(5);
        spnlEndereco.setViewportView(txaEndereco);

        btnCriar.setText("Criar");
        btnCriar.addActionListener(e -> criarConta());

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(e -> dispose());

        GroupLayout layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(48)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblNome)
                                        .addComponent(txtNome)
                                        .addComponent(lblRg)
                                        .addComponent(txtRg)
                                        .addComponent(lblCpf)
                                        .addComponent(txtCpf)
                                        .addComponent(lblEmail)
                                        .addComponent(txtEmail)
                                        .addComponent(lblSenha)
                                        .addComponent(txtSenha)
                                        .addComponent(lblNascimento)
                                        .addComponent(fmtNascimento)
                                        .addComponent(lblEndereco)
                                        .addComponent(spnlEndereco, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE))
                                .addContainerGap(55, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCriar)
                                .addGap(18)
                                .addComponent(btnCancelar)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblCriar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30)
                                .addComponent(lblCriar)
                                .addGap(20)
                                .addComponent(lblNome)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblRg)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblCpf)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblEmail)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblSenha)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNascimento)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fmtNascimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblEndereco)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnlEndereco, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addGap(25)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCriar)
                                        .addComponent(btnCancelar))
                                .addContainerGap(40, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        pack();
        setLocationRelativeTo(null);
    }

    private void criarConta() {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conexao = ConexaoDataBase.conectar();

            String nome = txtNome.getText();
            String rg = txtRg.getText();
            String cpf = txtCpf.getText();
            String email = txtEmail.getText();
            String senha = new String(txtSenha.getPassword());
            String nascimento = fmtNascimento.getText();
            String endereco = txaEndereco.getText();

            if (nome.isEmpty() || rg.isEmpty() || cpf.isEmpty() || email.isEmpty() || senha.isEmpty() || nascimento.contains("_") || endereco.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos corretamente.");
                return;
            }

            String sqlCheck = "SELECT COUNT(*) FROM usuarios WHERE cpf = ?";
            pst = conexao.prepareStatement(sqlCheck);
            pst.setString(1, cpf);
            rs = pst.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(null, "CPF já cadastrado.");
                return;
            }
            rs.close();
            pst.close();

            String sqlInsertUser = "INSERT INTO usuarios (nome, rg, cpf, email, nascimento, endereco, status_conta, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?) RETURNING usuario_id";

            pst = conexao.prepareStatement(sqlInsertUser);
            pst.setString(1, nome);
            pst.setString(2, rg);
            pst.setString(3, cpf);
            pst.setString(4, email);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date utilDate = sdf.parse(nascimento);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            pst.setDate(5, sqlDate);
            pst.setString(6, endereco);
            pst.setBoolean(7, true);
            pst.setString(8, senha);

            rs = pst.executeQuery();
            int usuarioId = 0;
            if (rs.next()) {
                usuarioId = rs.getInt("usuario_id");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao obter ID do usuário.");
                return;
            }
            rs.close();
            pst.close();

            String numeroConta = String.format("%06d", gerarNumeroConta());
            String agencia = "0001";
            String digitoVerificador = "0";
            String tipoConta = "Corrente";
            BigDecimal saldoInicial = BigDecimal.ZERO;
            java.sql.Date dataCriacao = new java.sql.Date(System.currentTimeMillis());
            String statusConta = "ativa";

            String sqlInsertConta = "INSERT INTO contas (numero_conta, agencia, digito_verificador, tipo_conta, saldo, data_criacao, status_conta, cliente_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pst = conexao.prepareStatement(sqlInsertConta);
            pst.setString(1, numeroConta);
            pst.setString(2, agencia);
            pst.setString(3, digitoVerificador);
            pst.setString(4, tipoConta);
            pst.setBigDecimal(5, saldoInicial);
            pst.setDate(6, dataCriacao);
            pst.setString(7, statusConta);
            pst.setInt(8, usuarioId);

            int contaInserida = pst.executeUpdate();
            if (contaInserida > 0) {
                BancoDeDadosSimples.contas.put(numeroConta, senha);
                JOptionPane.showMessageDialog(null, "Conta criada com sucesso!\nNúmero da conta: " + numeroConta);

                // Abre a TelaToken
                TelaToken telaToken = new TelaToken();
                telaToken.setVisible(true);
                this.dispose();
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar conta: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (conexao != null) conexao.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private int gerarNumeroConta() {
        return (int) (Math.random() * 900000) + 100000;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new TelaCriarConta().setVisible(true));
    }

    // Componentes
    private JButton btnCancelar;
    private JButton btnCriar;
    private JFormattedTextField fmtNascimento;
    private JPanel jPanel1;
    private JLabel lblCpf;
    private JLabel lblCriar;
    private JLabel lblEndereco;
    private JLabel lblNascimento;
    private JLabel lblNome;
    private JLabel lblRg;
    private JLabel lblEmail;
    private JLabel lblSenha;
    private JScrollPane spnlEndereco;
    private JTextArea txaEndereco;
    private JTextField txtCpf;
    private JTextField txtNome;
    private JTextField txtRg;
    private JTextField txtEmail;
    private JPasswordField txtSenha;
}
