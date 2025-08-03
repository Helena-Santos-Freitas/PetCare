package petshop.view.historico;

import petshop.model.HistoricoMedico;
import petshop.services.HistoricoService;

import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ListarHistorico extends JFrame {

    private JPanel contentPanel;
    private JScrollPane scrollPane;

    public ListarHistorico() {

        setTitle("Histórico Médico");
        setSize(800, 600);
        setLocationRelativeTo(null);


        contentPanel = new JPanel(new BorderLayout());


        loadHistoricos();


        add(contentPanel);
    }

    private void loadHistoricos() {

        List<HistoricoMedico> historicos = HistoricoService.INSTANCE.getHistoricos();


        if (scrollPane != null) {
            contentPanel.remove(scrollPane);
        }


        if (historicos == null || historicos.isEmpty()) {
            JLabel emptyLabel = new JLabel("Não há registros de histórico médico disponíveis.");
            emptyLabel.setHorizontalAlignment(JLabel.CENTER);
            emptyLabel.setFont(new Font("Arial", Font.BOLD, 16));
            contentPanel.add(emptyLabel, BorderLayout.CENTER);
        } else {

            JPanel listPanel = new JPanel();
            listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));


            listPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


            for (HistoricoMedico historico : historicos) {
                JPanel card = createHistoricoCard(historico);
                listPanel.add(card);
                listPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            }


            scrollPane = new JScrollPane(listPanel);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            contentPanel.add(scrollPane, BorderLayout.CENTER);
        }


        JButton refreshButton = new JButton("Atualizar");
        refreshButton.addActionListener(e -> loadHistoricos());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(refreshButton);
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);


        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private JPanel createHistoricoCard(HistoricoMedico historico) {

        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));


        String formattedDate = historico.getDataConsulta() != null ?
                historico.getDataConsulta().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) :
                "Data não disponível";


        JLabel dateLabel = new JLabel("Data da Consulta: " + formattedDate);
        dateLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(dateLabel);
        panel.add(new JLabel(""));


        addField(panel, "Motivo:", historico.getMotivo());
        addField(panel, "Diagnóstico:", historico.getDiagnostico());
        addField(panel, "Tratamentos:", historico.getTratamentos());
        addField(panel, "Vacinas:", historico.getVacinas());
        addField(panel, "Prescrições:", historico.getPrescricoes());
        addField(panel, "Observações:", historico.getObservacoes());

        return panel;
    }

    private void addField(JPanel panel, String label, String value) {
        JLabel labelComponent = new JLabel(label);
        labelComponent.setFont(new Font("Arial", Font.BOLD, 12));
        panel.add(labelComponent);

        JTextArea valueArea = new JTextArea(value != null ? value : "");
        valueArea.setEditable(false);
        valueArea.setLineWrap(true);
        valueArea.setWrapStyleWord(true);
        valueArea.setBackground(new Color(240, 240, 240));
        valueArea.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));


        JScrollPane scrollPane = new JScrollPane(valueArea);
        scrollPane.setPreferredSize(new Dimension(300, 60));
        panel.add(scrollPane);
    }

    public static void main(String[] args) {


        SwingUtilities.invokeLater(() -> {
            ListarHistorico ui = new ListarHistorico();
            ui.setVisible(true);
        });
    }
}