import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadioButtonDemo extends JFrame {

    private JRadioButton bird, cat, dog, rabbit, pig;
    private JLabel animalImage;
    private ButtonGroup group;

    public RadioButtonDemo() {

        setTitle("RadioButtonDemo");
        setSize(550, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Create the five radio buttons
        bird = new JRadioButton("Bird");
        cat = new JRadioButton("Cat");
        dog = new JRadioButton("Dog");
        rabbit = new JRadioButton("Rabbit");
        pig = new JRadioButton("Pig");

        // Allow only one animal to be selected
        group = new ButtonGroup();
        group.add(bird);
        group.add(cat);
        group.add(dog);
        group.add(rabbit);
        group.add(pig);

        // Arrange radio buttons vertically
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(5, 1, 5, 5));
        radioPanel.add(bird);
        radioPanel.add(cat);
        radioPanel.add(dog);
        radioPanel.add(rabbit);
        radioPanel.add(pig);

        radioPanel.setBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 10)
        );

        add(radioPanel, BorderLayout.WEST);

        // Area for displaying the selected animal
        animalImage = new JLabel(
            "Choose an animal",
            SwingConstants.CENTER
        );

        animalImage.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 90));
        add(animalImage, BorderLayout.CENTER);

        // Button to show the selection
        JButton showButton = new JButton("Show Selection");
        add(showButton, BorderLayout.SOUTH);

        // Display the selected animal
        showButton.addActionListener(e -> showAnimal());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void showAnimal() {

        String selectedPet = "";
        String animalIcon = "";

        if (bird.isSelected()) {
            selectedPet = "Bird";
            animalIcon = "\uD83D\uDC26";
        } else if (cat.isSelected()) {
            selectedPet = "Cat";
            animalIcon = "\uD83D\uDC31";
        } else if (dog.isSelected()) {
            selectedPet = "Dog";
            animalIcon = "\uD83D\uDC36";
        } else if (rabbit.isSelected()) {
            selectedPet = "Rabbit";
            animalIcon = "\uD83D\uDC30";
        } else if (pig.isSelected()) {
            selectedPet = "Pig";
            animalIcon = "\uD83D\uDC37";
        } else {
            JOptionPane.showMessageDialog(
                this,
                "Please select an animal first!"
            );
            return;
        }

        // Display the animal icon and its name
        animalImage.setText(
            "<html><div style='text-align:center;'>"
            + animalIcon + "<br>"
            + selectedPet
            + "</div></html>"
        );

        JOptionPane.showMessageDialog(
            this,
            "You selected: " + selectedPet,
            "Animal Selection",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RadioButtonDemo());
    }
}