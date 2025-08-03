package petshop.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Telalogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPasswordField password_LOGIN;
    private JTextField textEMAIL;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Telalogin frame = new Telalogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public Telalogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 424, 942);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnEntrar.setBounds(119, 747, 164, 52);
        contentPane.add(btnEntrar);

        password_LOGIN = new JPasswordField();
        password_LOGIN.setBounds(56, 653, 304, 59);
        contentPane.add(password_LOGIN);

        textEMAIL = new JTextField();
        textEMAIL.setBounds(56, 539, 304, 59);
        contentPane.add(textEMAIL);
        textEMAIL.setColumns(10);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\aryan\\OneDrive\\Área de Trabalho\\Mnenos quebrado\\PetCare\\src\\Icon e Imagens\\TELA login.png"));
        lblNewLabel.setBounds(0, 0, 424, 896);
        contentPane.add(lblNewLabel);
    }
}
