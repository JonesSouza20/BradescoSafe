package br.com.a3bradesco.projeto.telas;

import br.com.a3bradesco.projeto.ConexaoDataBase;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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
        lblNascimento = new JLabel();
        lblEndereco = new JLabel();
        txtNome = new JTextField();
        txtRg = new JTextField();
        txtCpf = new JTextField();
        spnlEndereco = new JScrollPane();
        txaEndereco = new JTextArea();
        fmtNascimento = new JFormattedTextField();
        btnCriar = new JButton();
        btnCancelar = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        lblCriar.setFont(new Font("Segoe UI", 0, 24));
        lblCriar.setHorizontalAlignment(SwingConstants.CENTER);
        lblCriar.setText("Criar Conta");

        lblNome.setText("Nome completo:");
        lblRg.setText("RG:");
        lblCpf.setText("CPF:");
        lblNascimento.setText("Data de nascimento (dd/MM/yyyy):");
        lblEndereco.setText("Endereço:");

        txaEndereco.setColumns(20);
        txaEndereco.setRows(5);
        spnlEndereco.setViewportView(txaEndereco);

        btnCriar.setText("Criar");
        btnCriar.addActionListener(e -> criarConta());  // Aqui o listener está certo

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(e -> System.exit(0));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblNome)
                                        .addComponent(lblRg)
                                        .addComponent(lblCpf)
                                        .addComponent(lblNascimento)
                                        .addComponent(lblEndereco)
                                        .addComponent(txtNome)
                                        .addComponent(txtRg)
                                        .addComponent(txtCpf)
                                        .addComponent(spnlEndereco, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                                        .addComponent(fmtNascimento))
                                .addContainerGap(55, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblCriar, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnCriar)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnCancelar)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(lblCriar)
                                .addGap(20, 20, 20)
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
                                .addComponent(lblNascimento)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fmtNascimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblEndereco)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnlEndereco, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCriar)
                                        .addComponent(btnCancelar))
                                .addContainerGap(40, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        pack();
        setLocationRelativeTo(null);
    }

    private void criarConta() {
        String nome = txtNome.getText().trim();
        String rg = txtRg.getText().trim();
        String cpf = txtCpf.getText().trim();
        String dataNascimentoTexto = fmtNascimento.getText().trim();
        String endereco = txaEndereco.getText().trim();

        // Verifica se algum campo está vazio
        if (nome.isEmpty() || rg.isEmpty() || cpf.isEmpty() || dataNascimentoTexto.isEmpty() || endereco.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.");
            return;
        }

        // Valida formato da data
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate nascimento;
        try {
            nascimento = LocalDate.parse(dataNascimentoTexto, formatter);
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "Formato de data inválido. Use dd/MM/yyyy.");
            return;
        }

        Date dataSql = Date.valueOf(nascimento); // yyyy-MM-dd

        try {
            Connection conn = ConexaoDataBase.conectar();
            String sql = "INSERT INTO usuarios (nome, rg, cpf, nascimento, endereco, email) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, rg);
            stmt.setString(3, cpf);
            stmt.setDate(4, dataSql);
            stmt.setString(5, endereco);
            String email = "";
            stmt.setString(6, email);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Conta criada com sucesso!");
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao criar conta: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new TelaCriarConta().setVisible(true));
    }

    // Declaração dos componentes
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
    private JScrollPane spnlEndereco;
    private JTextArea txaEndereco;
    private JTextField txtCpf;
    private JTextField txtNome;
    private JTextField txtRg;
}
