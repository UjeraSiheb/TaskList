import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;

class AppFrame extends JFrame {
    private JLabel titleLabel;
    private JButton addButton, deleteButton;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;

    AppFrame() {
        Border emptyBorder = BorderFactory.createEmptyBorder();
        titleLabel = new JLabel("To-Do List App");
        addButton = new JButton("Add Task");
        deleteButton = new JButton("Delete Selected Tasks");
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        this.setSize(400, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(new Color(135, 206, 250)); 
        // Set background color to light blue

        titleLabel.setPreferredSize(new Dimension(400, 80));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(70, 130, 180)); 
        // Set background color to steel blue
        titleLabel.setForeground(Color.white);

        addButton.setBorder(emptyBorder);
        deleteButton.setBorder(emptyBorder);

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        buttonPanel.add(deleteButton);
        buttonPanel.setOpaque(false);
        this.add(buttonPanel, BorderLayout.CENTER);

        // Panel for task list
        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setOpaque(false);
        this.add(scrollPane, BorderLayout.SOUTH);

        this.add(titleLabel, BorderLayout.NORTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newTask = JOptionPane.showInputDialog("Enter a new task:");
                if (newTask != null && !newTask.isEmpty()) {
                    listModel.addElement(newTask);
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] selectedIndices = taskList.getSelectedIndices();
                for (int i = selectedIndices.length - 1; i >= 0; i--) {
                    listModel.removeElementAt(selectedIndices[i]);
                }
            }
        });

        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AppFrame();
        });
    }
}

public class ToDoList {
    public static void main(String[] args) {
        new AppFrame();
    }
}
