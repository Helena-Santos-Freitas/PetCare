package petshop.view.compromisso;

import petshop.model.Compromisso;
import petshop.services.CompromissoService;

import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ListarCompromisso extends JFrame {

    private JPanel contentPanel;
    private JScrollPane scrollPane;

    public ListarCompromisso() {

        setTitle("Lista de Compromissos");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);


        contentPanel = new JPanel(new BorderLayout());


        loadCompromissos();


        add(contentPanel);
    }

    private void loadCompromissos() {

        List<Compromisso> compromissos = CompromissoService.INSTANCE.getCompromissos();


        if (scrollPane != null) {
            contentPanel.remove(scrollPane);
        }


        if (compromissos == null || compromissos.isEmpty()) {
            JLabel emptyLabel = new JLabel("Não há compromissos agendados.");
            emptyLabel.setHorizontalAlignment(JLabel.CENTER);
            emptyLabel.setFont(new Font("Arial", Font.BOLD, 16));
            contentPanel.add(emptyLabel, BorderLayout.CENTER);
        } else {

            JPanel listPanel = new JPanel();
            listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));


            listPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


            for (Compromisso compromisso : compromissos) {
                JPanel card = createCompromissoCard(compromisso);
                listPanel.add(card);
                listPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            }


            scrollPane = new JScrollPane(listPanel);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            contentPanel.add(scrollPane, BorderLayout.CENTER);
        }


        JButton refreshButton = new JButton("Atualizar");
        refreshButton.addActionListener(e -> loadCompromissos());

        JButton addButton = new JButton("Novo Compromisso");
        addButton.addActionListener(e -> {


            JOptionPane.showMessageDialog(this, "Abrir tela de cadastro de compromisso");
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        buttonPanel.add(refreshButton);
        buttonPanel.add(addButton);
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);


        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private JPanel createCompromissoCard(Compromisso compromisso) {

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 180)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        panel.setBackground(new Color(250, 250, 250));


        String formattedDate = compromisso.getDataHora() != null ?
                compromisso.getDataHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) :
                "Data não disponível";


        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(240, 240, 240));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JLabel dateLabel = new JLabel(formattedDate);
        dateLabel.setFont(new Font("Arial", Font.BOLD, 14));

        JLabel titleLabel = new JLabel(compromisso.getCompromisso());
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

        headerPanel.add(dateLabel, BorderLayout.WEST);
        headerPanel.add(titleLabel, BorderLayout.CENTER);


        panel.add(headerPanel, BorderLayout.NORTH);


        JPanel detailsPanel = new JPanel(new GridLayout(0, 1, 5, 5));
        detailsPanel.setBackground(new Color(250, 250, 250));


        JPanel localPanel = new JPanel(new BorderLayout());
        localPanel.setBackground(new Color(250, 250, 250));
        JLabel localLabel = new JLabel("Local: ");
        localLabel.setFont(new Font("Arial", Font.BOLD, 12));
        JLabel localValue = new JLabel(compromisso.getLocal());
        localPanel.add(localLabel, BorderLayout.WEST);
        localPanel.add(localValue, BorderLayout.CENTER);
        detailsPanel.add(localPanel);


        if (compromisso.getAfazeres() != null && !compromisso.getAfazeres().trim().isEmpty()) {
            JPanel afazeresPanel = new JPanel(new BorderLayout());
            afazeresPanel.setBackground(new Color(250, 250, 250));
            JLabel afazeresLabel = new JLabel("Afazeres: ");
            afazeresLabel.setFont(new Font("Arial", Font.BOLD, 12));

            JTextArea afazeresArea = new JTextArea(compromisso.getAfazeres());
            afazeresArea.setEditable(false);
            afazeresArea.setLineWrap(true);
            afazeresArea.setWrapStyleWord(true);
            afazeresArea.setBackground(new Color(250, 250, 250));
            afazeresArea.setBorder(null);

            afazeresPanel.add(afazeresLabel, BorderLayout.NORTH);
            afazeresPanel.add(afazeresArea, BorderLayout.CENTER);
            detailsPanel.add(afazeresPanel);
        }


        panel.add(detailsPanel, BorderLayout.CENTER);

        return panel;
    }

    public static void main(String[] args) {


        SwingUtilities.invokeLater(() -> {
            ListarCompromisso ui = new ListarCompromisso();
            ui.setVisible(true);
        });
    }
}