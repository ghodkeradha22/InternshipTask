package InternshipTask6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoApp extends JFrame {
    private DefaultListModel<String> taskModel; 
    private JList<String> taskList;             
    private JTextField taskInput;              
    private JButton addButton, deleteButton;   

    public ToDoApp() {
        setTitle("To-Do List");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  
        
        taskModel = new DefaultListModel<>();
        taskList = new JList<>(taskModel);
        taskInput = new JTextField(20);
        addButton = new JButton("Add Task");
        deleteButton = new JButton("Delete Task");

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.add(taskInput);
        inputPanel.add(addButton);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(deleteButton);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);

        addButton.addActionListener(e -> addTask());
        deleteButton.addActionListener(e -> deleteTask());

        setVisible(true);
    }

    private void addTask() {
        String task = taskInput.getText().trim();
        if (!task.isEmpty()) {
            taskModel.addElement(task);
            taskInput.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a task", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void deleteTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            taskModel.remove(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a task to delete", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoApp::new);
    }
}
