package petshop.view.autenticacao;

import petshop.services.UsuarioService;

import javax.swing.*;
import java.awt.*;

public class LoginForm extends JFrame {
    private MenuAutenticacao menuAutenticacao;

    private JTextField emailField;
    private JTextField senhaField;
    private JButton loginButton;
    private JLabel statusLabel;

    public LoginForm(MenuAutenticacao menuAutenticacao) {
        this.menuAutenticacao = menuAutenticacao;


        setTitle("Login");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);


        setLayout(new BorderLayout());


        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        formPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        formPanel.add(emailField);

        formPanel.add(new JLabel("Senha:"));
        senhaField = new JTextField();
        formPanel.add(senhaField);


        statusLabel = new JLabel(" ");
        statusLabel.setHorizontalAlignment(JLabel.CENTER);


        JPanel buttonPanel = new JPanel();
        loginButton = new JButton("Login");
        buttonPanel.add(loginButton);


        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(statusLabel, BorderLayout.NORTH);


        loginButton.addActionListener(e -> login());
    }

    private void login() {
        try {


            String email = emailField.getText().trim();
            if (email.isEmpty()) {
                throw new IllegalArgumentException("Email é obrigatório");
            }


            String senha = senhaField.getText().trim();
            if (senha.isEmpty()) {
                throw new IllegalArgumentException("Senha é obrigatória");
            }


            UsuarioService.INSTANCE.login(email, senha);


            statusLabel.setText("Login realizado com succeso!");
            statusLabel.setForeground(new Color(0, 128, 0));


            clearFields();

            setVisible(false);
            menuAutenticacao.onLoginSuccess();


        } catch (Exception ex) {

            statusLabel.setText("Erro: " + ex.getMessage());
            statusLabel.setForeground(Color.RED);
        }
    }

    private void clearFields() {
        emailField.setText("");
        senhaField.setText("");
    }

    public static void main(String[] args) {


        SwingUtilities.invokeLater(() -> new LoginForm(null).setVisible(true));
    }
}