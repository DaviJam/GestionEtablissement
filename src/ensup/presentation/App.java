package ensup.presentation;

import ensup.business.Course;
import ensup.business.Person;
import ensup.business.Student;
import ensup.service.ServiceConnection;
import ensup.service.ServiceCourse;
import ensup.service.ServicePerson;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private JPanel mainPanel;
    private JPanel connexionPanel;
    private JButton connexionBtn;
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
    private JPanel infoStudentPanel;
    private JTextField hiddenTextField1;

    String[] columnNames = {"First Name",
            "Last Name",
            "Sport",
            "# of Years",
            "Vegetarian"};


    public App() {
        //Vue connexion
        connexionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServiceConnection sc = new ServiceConnection();
                boolean isConnect = sc.getConnection(textField1.getText(), passwordField1.getText());
                if (isConnect) {
                    connexionPanel.setVisible(false);
                    menuPanel.setVisible(true);
                }

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

                //Add item in combobox student
                ServicePerson ps = new ServicePerson();
                comboBox1.removeAllItems();
                for(Person p : ps.getAll()){
                    if(p instanceof Student) {
                        System.out.println(p);
                        comboBox1.addItem(new Item(p.getId(), p.getFirstname() + " " + p.getLastname()));
                    }
                }
            }
        });
        CourseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuPanel.setVisible(false);
                coursePanel.setVisible(true);

                //Add item in combobox course
                ServiceCourse cs = new ServiceCourse();
                comboBox3.removeAllItems();
                for(Course c : cs.getAll()){
                    System.out.println(c);
                    comboBox3.addItem(c.getCourseSubject());
                }

                //Add item in combobox student
                ServicePerson ps = new ServicePerson();
                comboBox2.removeAllItems();
                for(Person p : ps.getAll()){
                    if(p instanceof Student) {
                        System.out.println(p);
                        comboBox2.addItem(p.getFirstname() + " " + p.getLastname());
                    }
                }
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
                        ServiceCourse cs = new ServiceCourse();
                        cs.create(textField8.getText(), f);
                        comboBox3.addItem(textField8.getText());
                        textField8.setText("");
                        textField9.setText("");
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null, "Le nombre d'heure n'est pas un nombre (ex: 1.5)");
                    }
                }
            }
        });

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox c = (JComboBox) e.getSource();
                Item item = (Item) c.getSelectedItem();
                System.out.println(item.getId() + " : " + item.getDescription());

                //On affiche les informations utilisateurs
                ServicePerson ps = new ServicePerson();
                Person p = ps.get(item.getId());
                if (p instanceof Student) {
                    System.out.println(((Student)p).toString());

                    String s = String.valueOf(((Student)p).getId());
                    hiddenTextField1.setText(s);
                    textField2.setText(((Student)p).getLastname());
                    textField3.setText(((Student)p).getFirstname());
                    textField4.setText(((Student)p).getMailAddress());
                    textField5.setText(((Student)p).getAddress());
                    textField6.setText(((Student)p).getPhoneNumber());
                    textField7.setText(((Student)p).getDateOfBirth().toString());
                }
            }
        });
        deleteStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServicePerson ps = new ServicePerson();
                ps.delete(Integer.parseInt(hiddenTextField1.getText()));

                hiddenTextField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
                textField6.setText("");
                textField7.setText("");
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
class ItemRenderer extends BasicComboBoxRenderer {
    @Override
    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected,
                cellHasFocus);
        if (value != null) {
            Item item = (Item) value;
            setText(item.getDescription().toUpperCase());
        }
        if (index == -1) {
            Item item = (Item) value;
            setText("" + item.getId());
        }
        return this;
    }
}
