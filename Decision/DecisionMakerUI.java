import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class DecisionMakerUI extends JFrame {
    private JLabel choicesLabel;
    private JTextField choicesField;
    private JButton submitButton;
    private HashMap<Integer, String> choicesMap;
   
    public DecisionMakerUI() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("DECISION MAKER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        choicesLabel = new JLabel("Enter the number of choices:");
        choicesLabel.setHorizontalAlignment(JLabel.CENTER);
        choicesLabel.setVerticalAlignment(JLabel.CENTER);
        add(choicesLabel);

        choicesField = new JTextField();
        choicesField.setHorizontalAlignment(JTextField.CENTER);
        add(choicesField);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSubmission();
            }
        });
        add(submitButton);

        pack();
        setLocationRelativeTo(null);
    }

    private void handleSubmission() {
        String choicesInput = choicesField.getText().trim();
        int numChoices = Integer.parseInt(choicesInput);

        choicesMap = new HashMap<>();

        for (int i = 1; i <= numChoices; i++) {
            String choice = JOptionPane.showInputDialog("Enter choice " + i+":");
            choicesMap.put(i, choice);
        }

        String outputInput = JOptionPane.showInputDialog("Enter the number of choices to output:");

        int numOutput = Integer.parseInt(outputInput);

        StringBuilder outputBuilder = new StringBuilder("Output:\n");

        for (int i = 1; i <= numOutput; i++) {
            int randomChoice = ThreadLocalRandom.current().nextInt(1, numChoices + 1);
            String choice = choicesMap.get(randomChoice);
            outputBuilder.append(i).append(": ").append(choice).append("\n");
        }

        JOptionPane.showMessageDialog(this, outputBuilder.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DecisionMakerUI ui = new DecisionMakerUI();
                ui.setSize(300, 200);
                ui.setVisible(true);
            }
        });
    }
}

