package petshop.view.historico;

import petshop.services.HistoricoService;

import javax.swing.*;
import java.awt.*;

public class CadastrarHistoricoForm extends JFrame {
    private JTextField motivoField;
    private JTextField diagnosticoField;
    private JTextField tratamentosField;
    private JTextField vacinasField;
    private JTextField prescricoesField;
    private JTextField observacoesField;
    private JButton cadastrarButton;
    private JLabel statusLabel;

    public CadastrarHistoricoForm() {


        setTitle("Cadastro de Histórico Médico");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);


        setLayout(new BorderLayout());


        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(6, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        formPanel.add(new JLabel("Motivo:"));
        motivoField = new JTextField();
        formPanel.add(motivoField);

        formPanel.add(new JLabel("Diagnóstico:"));
        diagnosticoField = new JTextField();
        formPanel.add(diagnosticoField);

        formPanel.add(new JLabel("Tratamento:"));
        tratamentosField = new JTextField();
        formPanel.add(tratamentosField);

        formPanel.add(new JLabel("Vacinas:"));
        vacinasField = new JTextField();
        formPanel.add(vacinasField);

        formPanel.add(new JLabel("Prescrições:"));
        prescricoesField = new JTextField();
        formPanel.add(prescricoesField);

        formPanel.add(new JLabel("Observações:"));
        observacoesField = new JTextField();
        formPanel.add(observacoesField);


        statusLabel = new JLabel(" ");
        statusLabel.setHorizontalAlignment(JLabel.CENTER);


        JPanel buttonPanel = new JPanel();
        cadastrarButton = new JButton("Cadastrar histórico");
        buttonPanel.add(cadastrarButton);


        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(statusLabel, BorderLayout.NORTH);


        cadastrarButton.addActionListener(e -> cadastrarHistorico());
    }

    private void cadastrarHistorico() {
        try {

            String motivo = motivoField.getText().trim();
            if (motivo.isEmpty()) {
                throw new IllegalArgumentException("Motivo é obrigatório");
            }

            String diagnostico = motivoField.getText().trim();
            if (diagnostico.isEmpty()) {
                throw new IllegalArgumentException("Diagnóstico é obrigatório");
            }

            String tratamentos = motivoField.getText().trim();
            if (tratamentos.isEmpty()) {
                throw new IllegalArgumentException("Tratamentos é obrigatório");
            }

            String vacinas = motivoField.getText().trim();
            if (vacinas.isEmpty()) {
                throw new IllegalArgumentException("Vacinas é obrigatório");
            }

            String prescricoes = motivoField.getText().trim();
            if (prescricoes.isEmpty()) {
                throw new IllegalArgumentException("Prescrições é obrigatório");
            }

            String observacoes = motivoField.getText().trim();
            if (observacoes.isEmpty()) {
                throw new IllegalArgumentException("Observações é obrigatório");
            }


            HistoricoService.INSTANCE.cadastrarHistorico(motivo, diagnostico, tratamentos, vacinas, prescricoes, observacoes);


            statusLabel.setText("Histórico cadastrado com sucesso!");
            statusLabel.setForeground(new Color(0, 128, 0));


            clearFields();

        } catch (Exception ex) {

            statusLabel.setText("Erro: " + ex.getMessage());
            statusLabel.setForeground(Color.RED);
        }
    }

    private void clearFields() {
        motivoField.setText("");
        diagnosticoField.setText("");
        tratamentosField.setText("");
        vacinasField.setText("");
        prescricoesField.setText("");
        observacoesField.setText("");
    }

    public static void main(String[] args) {


        SwingUtilities.invokeLater(() -> new CadastrarHistoricoForm().setVisible(true));
    }
}