package Functionallities;

import DAO.Library_DAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class account extends JFrame {
    private JPanel mainPanel;
    private JTextField UsernameTextField;
    private JPasswordField PasswordTextField;
    private JLabel UsernameLabel;
    private JLabel PasswordLabel;
    private JCheckBox checkboxLibrarian;
    private JButton LoginButton;
    private JButton SignUpButton;

    public account() {
        setContentPane(mainPanel);
        setTitle("Library Management System");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        PasswordTextField.setEchoChar('*');
        PasswordTextField.setColumns(10);

        SignUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String password = String.copyValueOf(PasswordTextField.getPassword());
                    String username = UsernameLabel.getText();
                    int x = DAO.Library_DAO.account(username, password);

                    if (x > 0 && checkboxLibrarian.isSelected()) {
                        JOptionPane.showMessageDialog(null, "hello librarian you have now created a brand new account for yourself");
                        librarian_view LibraryV = new librarian_view();
                        setVisible(false);
                        //LibraryV.setVisible(true);
                    } else if (x > 0 && !checkboxLibrarian.isSelected()) {
                        JOptionPane.showMessageDialog(null, "welcome new user you have now created a brand new account for yourself to use");
                        User_view UserV = new User_view();
                        setVisible(false);
                        //UserV.setVisible(true);
                    } else if (password.equals("")) {
                        JOptionPane.showMessageDialog(null, "enter your password");
                    } else if (username.equals("")) {
                        JOptionPane.showMessageDialog(null, "enter your username");
                    } else if (Library_DAO.checkusername(username)) {
                        JOptionPane.showMessageDialog(null, "This username already exists");
                    }

                } catch (Exception x) {
                    System.out.println(x);
                }
            }
        });
    }

    public static void main(String[] args) {

        account myFrame = new account();
    }

}
