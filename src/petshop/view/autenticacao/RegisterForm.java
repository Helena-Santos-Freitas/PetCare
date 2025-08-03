package petshop.view.autenticacao;

import petshop.services.UsuarioService;

import javax.swing.*;
import java.awt.*;

public class RegisterForm extends JFrame {
    private MenuAutenticacao menuAutenticacao;

    private JTextField nomeField;
    private JTextField emailField;
    private JTextField cpfField;
    private JTextField senhaField;
    private JButton loginButton;
    private JLabel statusLabel;

    public RegisterForm(MenuAutenticacao menuAutenticacao) {
        this.menuAutenticacao = menuAutenticacao;


        setTitle("Cadastro");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);


        setLayout(new BorderLayout());


        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        formPanel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        formPanel.add(nomeField);

        formPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        formPanel.add(emailField);

        formPanel.add(new JLabel("CPF:"));
        cpfField = new JTextField();
        formPanel.add(cpfField);

        formPanel.add(new JLabel("Senha:"));
        senhaField = new JTextField();
        formPanel.add(senhaField);


        statusLabel = new JLabel(" ");
        statusLabel.setHorizontalAlignment(JLabel.CENTER);


        JPanel buttonPanel = new JPanel();
        loginButton = new JButton("Registrar");
        buttonPanel.add(loginButton);


        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(statusLabel, BorderLayout.NORTH);


        loginButton.addActionListener(e -> register());
    }

    private void register() {
        try {

            String nome = nomeField.getText().trim();
            if (nome.isEmpty()) {
                throw new IllegalArgumentException("Nome é obrigatório");
            }


            String email = emailField.getText().trim();
            if (email.isEmpty()) {
                throw new IllegalArgumentException("Email é obrigatório");
            }


            String cpf = cpfField.getText().trim();
            if (cpf.isEmpty()) {
                throw new IllegalArgumentException("CPF é obrigatório");
            }


            String senha = senhaField.getText().trim();
            if (senha.isEmpty()) {
                throw new IllegalArgumentException("Senha é obrigatória");
            }


            UsuarioService.INSTANCE.cadastrar(nome, email, cpf, senha);


            statusLabel.setText("Cadastro realizado com sucesso!");
            statusLabel.setForeground(new Color(0, 128, 0));


            clearFields();


        } catch (Exception ex) {

            statusLabel.setText("Erro: " + ex.getMessage());
            statusLabel.setForeground(Color.RED);
        }
    }

    private void clearFields() {
        nomeField.setText("");
        emailField.setText("");

        senhaField.setText("");
    }

    public static void main(String[] args) {


        SwingUtilities.invokeLater(() -> new RegisterForm(null).setVisible(true));
    }
}