import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomWordGenerator {

    public static void main(String[] args) {


        // Create the main window with a title, size, and close operation
        JFrame frame = new JFrame("Random Word Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create the main panel to hold all components
        JPanel panel = new JPanel();
        frame.add(panel);

        // Create the components for the GUI
        JLabel welcomeLabel = new JLabel("Welcome to the random word generator!");
        JButton generateButton = new JButton("Generate a random word");
        JButton addButton = new JButton("Add a new word");
        JButton removeButton = new JButton("Remove a word");
        JButton showAllButton = new JButton("Show all words");
        JButton clearOutputButton = new JButton("Clear Output");
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Add the components to the main panel
        panel.add(welcomeLabel);
        panel.add(generateButton);
        panel.add(addButton);
        panel.add(removeButton);
        panel.add(showAllButton);
        panel.add(clearOutputButton);
        panel.add(scrollPane);

        // Set the layout for the main panel using GroupLayout
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(welcomeLabel)
                        .addComponent(generateButton)
                        .addComponent(addButton)
                        .addComponent(removeButton)
                        .addComponent(showAllButton)
                        .addComponent(clearOutputButton)
                        .addComponent(scrollPane)
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(welcomeLabel)
                        .addComponent(generateButton)
                        .addComponent(addButton)
                        .addComponent(removeButton)
                        .addComponent(showAllButton)
                        .addComponent(clearOutputButton)
                        .addComponent(scrollPane)
        );

        // Initialize the list of words and the random word generator
        List<String> myList = new ArrayList<>();
        myList.add("avenue");
        myList.add("splurge");
        myList.add("stretch");
        myList.add("market");
        Random r = new Random();

        // Add action listeners for the buttons to handle user interactions
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Generate and display a random word
                int randomItem = r.nextInt(myList.size());
                String randomElement = myList.get(randomItem);
                outputArea.append("Random word: " + randomElement + "\n");
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Prompt the user for a new word and add it to the list
                String newWord = JOptionPane.showInputDialog("Enter the new word:");
                if (newWord != null && !newWord.trim().isEmpty()) {
                    myList.add(newWord);
                    outputArea.append("Word added: " + newWord + "\n");
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Prompt the user for a word to remove and remove it from the list
                String wordToRemove = JOptionPane.showInputDialog("Enter the word to remove:");
                if (wordToRemove != null) {
                    if (myList.remove(wordToRemove)) {
                        outputArea.append("Word removed: "  + wordToRemove + "\n");
                    } else {
                        outputArea.append("Word not found: " + wordToRemove + "\n");
                    }
                }
            }
        });

        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display all the words in the list
                outputArea.append("All words:\n");
                for (String word : myList) {
                    outputArea.append(word + "\n");
                }
            }
        });

        // Add action listener for the clear output button
        clearOutputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear the text in the output area
                outputArea.setText("");
            }
        });

        // Show the main window
        frame.setVisible(true);
    }

}