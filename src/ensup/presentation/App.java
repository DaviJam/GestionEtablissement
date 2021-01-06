package ensup.presentation;

import ensup.business.Course;
import ensup.service.CourseService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private JPanel mainPanel;
    private JPanel connexionPanel;
    private JButton button1;
    private JPanel menuPanel;
    private JPanel studentPanel;
    private JPanel coursePanel;
    private JPanel studentListPanel;
    private JPanel addStudentPanel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton addStudentBtn;
    private JButton StudentBtn;
    private JButton CourseBtn;
    private JButton studentListBtn;
    private JButton returnBtn;
    private JComboBox comboBox1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JButton modifyStudent;
    private JButton deleteStudent;
    private JButton returnBtn1;
    private JTextField textField8;
    private JTextField textField9;
    private JButton addCourse;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JButton associerButton;
    private JButton returnBtn2;
    private JTable table1;
    private JButton returnBtn3;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;
    private JTextField textField13;
    private JTextField textField14;
    private JTextField textField15;
    private JButton createStudent;

    String[] columnNames = {"First Name",
            "Last Name",
            "Sport",
            "# of Years",
            "Vegetarian"};


    public App() {
        //Vue connexion
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connexionPanel.setVisible(false);
                menuPanel.setVisible(true);
                //JOptionPane.showMessageDialog(null, textField1.getText());
            }
        });

        //Vue menu
        addStudentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuPanel.setVisible(false);
                addStudentPanel.setVisible(true);
            }
        });
        StudentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuPanel.setVisible(false);
                studentPanel.setVisible(true);
            }
        });
        CourseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuPanel.setVisible(false);
                coursePanel.setVisible(true);
            }
        });
        studentListBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuPanel.setVisible(false);
                studentListPanel.setVisible(true);
            }
        });



        //User interactions
        addCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TF8 et TF9
                if (textField8.getText() == "" || textField9.getText() == "") {
                    JOptionPane.showMessageDialog(null, "Un des champs est vide");
                } else {
                    //If nb hours is not numeric return msgbox
                    try {
                        float f = Float.parseFloat(textField9.getText());

                        //Create course with parameters
                        CourseService cs = new CourseService();
                        Course c = new Course(textField8.getText(), f);
                        cs.createCourse(c);
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null, "Le nombre d'heure n'est pas un nombre (ex: 1.5)");
                    }
                }
            }
        });

            //Btn return
            returnBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    menuPanel.setVisible(true);
                    studentPanel.setVisible(false);
                }
            });
            returnBtn1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    menuPanel.setVisible(true);
                    coursePanel.setVisible(false);
                }
            });
            returnBtn2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    menuPanel.setVisible(true);
                    studentListPanel.setVisible(false);
                }
            });
            returnBtn3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    menuPanel.setVisible(true);
                    addStudentPanel.setVisible(false);
                }
            });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new App().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 720);
        frame.setVisible(true);

    }
}
