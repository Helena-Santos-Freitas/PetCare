package petshop.view;

import petshop.view.compromisso.CadastrarCompromissoForm;
import petshop.view.compromisso.ListarCompromisso;
import petshop.view.historico.CadastrarHistoricoForm;
import petshop.view.historico.ListarHistorico;
import petshop.view.pet.CadastrarPetForm;
import petshop.view.pet.ListarPet;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MenuPrincipal frame = new MenuPrincipal();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MenuPrincipal() {
        setTitle("Menu principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 425, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(10, 10));


        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.Y_AXIS));


        JPanel topRow = new JPanel(new GridLayout(1, 3, 10, 10));


        JPanel registerPetPanel = createButtonPanel(
                "Cadastrar Pet",
                "seguro-animal-de-estimacao.png",
                e -> new CadastrarPetForm().setVisible(true)
        );
        topRow.add(registerPetPanel);


        JPanel listPetPanel = createButtonPanel(
                "Listar pets",
                "list-pets.png",
                e -> new ListarPet().setVisible(true)
        );
        topRow.add(listPetPanel);


        JPanel schedulePanel = createButtonPanel(
                "Agendar compromisso",
                "agendar.png",
                e -> new CadastrarCompromissoForm().setVisible(true)
        );
        topRow.add(schedulePanel);


        JPanel bottomRow = new JPanel(new GridLayout(1, 3, 10, 10));


        JPanel historyPanel = createButtonPanel(
                "Add ao Histórico",
                "add-historico-medico.png",
                e -> new CadastrarHistoricoForm().setVisible(true)
        );
        bottomRow.add(historyPanel);


        JPanel listHistoryPanel = createButtonPanel(
                "Listar Histórico",
                "historico-medico.png",
                e -> new ListarHistorico().setVisible(true)
        );
        bottomRow.add(listHistoryPanel);


        JPanel listAppointmentPanel = createButtonPanel(
                "Listar Compromisso",
                "list-compromissos.png",
                e -> new ListarCompromisso().setVisible(true)
        );
        bottomRow.add(listAppointmentPanel);

        backgroundPanel.add(Box.createVerticalGlue());
        backgroundPanel.add(topRow);
        backgroundPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        backgroundPanel.add(bottomRow);
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
}
