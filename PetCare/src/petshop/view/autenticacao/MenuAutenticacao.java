package petshop.view.autenticacao;

import petshop.view.MenuPrincipal;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuAutenticacao extends JFrame {
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MenuAutenticacao frame = new MenuAutenticacao();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MenuAutenticacao() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 425, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(10, 10));


        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.Y_AXIS));


        JPanel topRow = new JPanel(new GridLayout(1, 3, 10, 10));


        JPanel listPetPanel = createButtonPanel(
                "Login",
                "login.png",
                e -> new LoginForm(this).setVisible(true)
        );
        topRow.add(listPetPanel);


        JPanel schedulePanel = createButtonPanel(
                "Registrar",
                "register.png",
                e -> new RegisterForm(this).setVisible(true)
        );
        topRow.add(schedulePanel);

        backgroundPanel.add(Box.createVerticalGlue());
        backgroundPanel.add(topRow);
        backgroundPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        backgroundPanel.add(Box.createVerticalGlue());

        contentPane.add(backgroundPanel, BorderLayout.CENTER);
    }

    private JPanel createButtonPanel(String label, String iconPath, ActionListener listener) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton button = new JButton();
        try {
            button.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\icones-imagens\\icone\\" + iconPath));
        } catch (Exception e) {
            button.setText(label);
        }

        button.setPreferredSize(new Dimension(86, 80));
        button.setMaximumSize(new Dimension(86, 80));
        button.setAlignmentX(CENTER_ALIGNMENT);
        button.addActionListener(listener);

        JLabel buttonLabel = new JLabel(label);
        buttonLabel.setAlignmentX(CENTER_ALIGNMENT);

        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(buttonLabel);

        return panel;
    }

    public void onLoginSuccess() {
        setVisible(false);
        new MenuPrincipal().setVisible(true);
    }
}
