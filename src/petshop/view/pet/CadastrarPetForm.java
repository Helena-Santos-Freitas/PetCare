package petshop.view.pet;

import petshop.model.Cliente;
import petshop.services.PetService;
import petshop.services.UsuarioService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarPetForm extends JFrame {
    private JTextField nomeField;
    private JTextField idadeField;
    private JComboBox<String> sexoComboBox;
    private JTextField pesoField;
    private JButton cadastrarButton;
    private JLabel statusLabel;

    public CadastrarPetForm() {


        setTitle("Cadastro de Pet");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);


        setLayout(new BorderLayout());


        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        formPanel.add(new JLabel("Nome do Animal:"));
        nomeField = new JTextField();
        formPanel.add(nomeField);

        formPanel.add(new JLabel("Idade do Animal:"));
        idadeField = new JTextField();
        formPanel.add(idadeField);

        formPanel.add(new JLabel("Sexo do Animal (M/F):"));
        String[] options = {"M", "F"};
        sexoComboBox = new JComboBox<>(options);
        formPanel.add(sexoComboBox);

        formPanel.add(new JLabel("Peso do Animal (kg):"));
        pesoField = new JTextField();
        formPanel.add(pesoField);


        statusLabel = new JLabel(" ");
        statusLabel.setHorizontalAlignment(JLabel.CENTER);


        JPanel buttonPanel = new JPanel();
        cadastrarButton = new JButton("Cadastrar Pet");
        buttonPanel.add(cadastrarButton);


        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(statusLabel, BorderLayout.NORTH);


        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarPet();
            }
        });
    }

    private void cadastrarPet() {
        try {
            Cliente clienteLogado = UsuarioService.INSTANCE.getClienteLogado();


            String nomeAnimal = nomeField.getText().trim();
            if (nomeAnimal.isEmpty()) {
                throw new IllegalArgumentException("Nome do animal é obrigatório");
            }


            int idadeAnimal;
            try {
                idadeAnimal = Integer.parseInt(idadeField.getText().trim());
                if (idadeAnimal < 0) {
                    throw new IllegalArgumentException("Idade deve ser maior ou igual a 0");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Idade deve ser um número inteiro");
            }


            char sexoAnimal = sexoComboBox.getSelectedItem().toString().charAt(0);


            double pesoAnimal;
            try {
                pesoAnimal = Double.parseDouble(pesoField.getText().trim().replace(",", "."));
                if (pesoAnimal <= 0) {
                    throw new IllegalArgumentException("Peso deve ser maior que 0");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Peso deve ser um número válido");
            }


            PetService.INSTANCE.cadastrarPet(nomeAnimal, idadeAnimal, sexoAnimal, pesoAnimal, clienteLogado);


            statusLabel.setText("Pet cadastrado com sucesso!");
            statusLabel.setForeground(new Color(0, 128, 0));


            clearFields();

        } catch (Exception ex) {

            statusLabel.setText("Erro: " + ex.getMessage());
            statusLabel.setForeground(Color.RED);
        }
    }

    private void clearFields() {
        nomeField.setText("");
        idadeField.setText("");
        sexoComboBox.setSelectedIndex(0);
        pesoField.setText("");
    }

    public static void main(String[] args) {


        SwingUtilities.invokeLater(() -> new CadastrarPetForm().setVisible(true));
    }
}