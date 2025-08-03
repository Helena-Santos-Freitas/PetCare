package petshop.view.compromisso;

import petshop.services.CompromissoService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarCompromissoForm extends JFrame {
    private JTextField compromissoField;
    private JTextField dataHoraField;
    private JTextField localField;
    private JTextField afazeresField;
    private JButton cadastrarButton;
    private JLabel statusLabel;

    public CadastrarCompromissoForm() {

        setTitle("Cadastro de Compromisso");
        setSize(400, 300);
        setLocationRelativeTo(null);


        setLayout(new BorderLayout());


        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        formPanel.add(new JLabel("Compromisso:"));
        compromissoField = new JTextField();
        formPanel.add(compromissoField);

        formPanel.add(new JLabel("Data e Hora (dd-MM-yyyy HH:mm):"));
        dataHoraField = new JTextField();
        formPanel.add(dataHoraField);

        formPanel.add(new JLabel("Local:"));
        localField = new JTextField();
        formPanel.add(localField);

        formPanel.add(new JLabel("Afazeres:"));
        afazeresField = new JTextField();
        formPanel.add(afazeresField);


        JPanel buttonPanel = new JPanel();
        cadastrarButton = new JButton("Cadastrar");
        buttonPanel.add(cadastrarButton);


        statusLabel = new JLabel(" ");
        statusLabel.setHorizontalAlignment(JLabel.CENTER);


        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(statusLabel, BorderLayout.NORTH);


        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarCompromisso();
            }
        });
    }

    private void cadastrarCompromisso() {

        String compromisso = compromissoField.getText().trim();
        String dataHora = dataHoraField.getText().trim();
        String local = localField.getText().trim();
        String afazeres = afazeresField.getText().trim();


        if (compromisso.isEmpty() || dataHora.isEmpty() || local.isEmpty()) {
            statusLabel.setText("Erro: Preencha todos os campos obrigatórios!");
            statusLabel.setForeground(Color.RED);
            return;
        }

        try {

            CompromissoService.INSTANCE.cadastrarCompromisso(compromisso, dataHora, local, afazeres);


            statusLabel.setText("Compromisso cadastrado com sucesso!");
            statusLabel.setForeground(new Color(0, 128, 0));


            clearFields();

        } catch (Exception ex) {

            statusLabel.setText("Erro: " + ex.getMessage());
            statusLabel.setForeground(Color.RED);
        }
    }

    private void clearFields() {
        compromissoField.setText("");
        dataHoraField.setText("");
        localField.setText("");
        afazeresField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CadastrarCompromissoForm().setVisible(true));
    }
}