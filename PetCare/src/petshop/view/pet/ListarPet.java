package petshop.view.pet;

import petshop.model.Pet;
import petshop.services.PetService;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.List;

public class ListarPet extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ListarPet frame = new ListarPet();
            frame.setVisible(true);
        });
    }

    public ListarPet() {
        setTitle("Listar pets");
        setLayout(new BorderLayout());

        List<Pet> pets = PetService.INSTANCE.getPets();

        if (pets.isEmpty()) {
            JLabel noPetsLabel = new JLabel("Nenhum pet encontrado.");
            noPetsLabel.setHorizontalAlignment(SwingConstants.CENTER);
            noPetsLabel.setFont(new Font("Arial", Font.BOLD, 16));
            add(noPetsLabel, BorderLayout.CENTER);
        } else {
            JPanel gridPanel = new JPanel();
            gridPanel.setLayout(new GridLayout(0, 2, 10, 5));

            ImageIcon genericPetIcon = new ImageIcon(System.getProperty("user.dir") + "\\src\\Icon e Imagens\\cachorro.png");
            Image circularPetImage = createCircularImage(genericPetIcon.getImage(), 80);
            ImageIcon circularPetIcon = new ImageIcon(circularPetImage);


            for (Pet pet : pets) {
                JPanel petPanel = new JPanel();
                petPanel.setLayout(new BoxLayout(petPanel, BoxLayout.Y_AXIS));
                petPanel.setOpaque(false);
                petPanel.setBorder(BorderFactory.createEmptyBorder(2, 10, 2, 10));


                JLabel imageLabel = new JLabel(circularPetIcon);
                imageLabel.setAlignmentX(CENTER_ALIGNMENT);

                imageLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                petPanel.add(imageLabel);


                JLabel nameLabel = new JLabel(pet.getNome());
                nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
                nameLabel.setAlignmentX(CENTER_ALIGNMENT);

                nameLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                petPanel.add(nameLabel);

                gridPanel.add(petPanel);
            }


            JScrollPane scrollPane = new JScrollPane(gridPanel);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

            add(scrollPane, BorderLayout.CENTER);
        }

        setSize(400, 300);
        setLocationRelativeTo(null);
    }

    private Image createCircularImage(Image image, int diameter) {
        BufferedImage bi = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bi.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, diameter, diameter);
        g2d.setClip(circle);


        g2d.drawImage(image, 0, 0, diameter, diameter, null);
        g2d.dispose();

        return bi;
    }
}
