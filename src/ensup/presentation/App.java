package ensup.presentation;

import ensup.business.Role;
import ensup.dto.CourseDTO;
import ensup.dto.ManagerDTO;
import ensup.dto.PersonDTO;
import ensup.dto.StudentDTO;
import ensup.service.CourseService;
import ensup.service.ServiceConnection;
import ensup.service.ServicePerson;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    private JTextField textField16;
    private JPasswordField passwordField2;
    private JTable table1;


    public App() {
        //Vue connexion
        connexionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServiceConnection sc = new ServiceConnection();
                /*System.out.println(textField1.getText());
                System.out.println(passwordField1.getText());*/

                int item = sc.checkConnection(textField1.getText(), passwordField1.getText());
                ServicePerson ps = new ServicePerson();
                PersonDTO p = ps.get(item);
                if (p instanceof ManagerDTO) {
                    Role r = p.getRole();
                    if (r.getNum() == 1 || r.getNum() == 2) {
                        connexionPanel.setVisible(false);
                        menuPanel.setVisible(true);
                        if (r.getNum() == 1) {
                            studentListBtn.setVisible(true);
                        } else {
                            studentListBtn.setVisible(false);
                        }
                    }
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
                for(PersonDTO p : ps.getAll()){
                    if(p instanceof StudentDTO) {
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
                CourseService cs = new CourseService();
                comboBox3.removeAllItems();
                for(CourseDTO c : cs.getAll()){
                    System.out.println(c);
                    comboBox3.addItem(new Item(c.getId(), c.getCourseSubject()));
                }

                //Add item in combobox student
                ServicePerson ps = new ServicePerson();
                comboBox2.removeAllItems();
                for(PersonDTO p : ps.getAll()){
                    if(p instanceof StudentDTO) {
                        System.out.println(p);
                        comboBox2.addItem(new Item(p.getId(), p.getFirstname() + " " + p.getLastname()));
                    }
                }
            }
        });



        studentListBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuPanel.setVisible(false);
                studentListPanel.setVisible(true);
                // TableModel's column names
                String[] columnNames = {
                        "Nom", "Prénom", "Email", "Adresse", "Téléphone", "Date de naissance", "Action 1", "Action 2",
                };
                ServicePerson ps = new ServicePerson();
                int nbStudent = 0;
                for(PersonDTO p : ps.getAll()){
                    if(p instanceof StudentDTO) {
                        nbStudent++;
                    }
                }

                Object[][] data = new Object[nbStudent][8];
                int count = 0;
                for(PersonDTO p : ps.getAll()){
                    if(p instanceof StudentDTO) {
                        data[count][0] = p.getFirstname();
                        data[count][1] = p.getLastname();
                        data[count][2] = p.getMailAddress();
                        data[count][3] = p.getAddress();
                        data[count][4] = p.getPhoneNumber();
                        data[count][5] = ((StudentDTO) p).getDateOfBirth().toString();
                        JButton modStudentBtnFromList = new JButton("Modifier");
                        JButton delStudentBtnFromList = new JButton("Supprimer");
                        data[count][6] = modStudentBtnFromList;
                        data[count][7] = delStudentBtnFromList;
                        modStudentBtnFromList.setVisible(true);
                        delStudentBtnFromList.setVisible(true);
                        //TODO : Find a way to do this
                        modStudentBtnFromList.addActionListener(this.modifyStudentAction);
                        count++;
                    }
                }
                // TableModel's data
                /***Object[][] data = {
                 { "Liverpool", 3, 3, 0, 0, 7,  },
                 { "Tottenham", 3, 3, 0, 0, 8,  },
                 { "Chelsea", 3, 3, 0, 0, 8,  },
                 { "Watford", 3, 3, 0, 0, 7,  },
                 { "Manchester City", 3, 2, 1, 0, 9, }
                 };***/

                StudentTableModel modele =new StudentTableModel(data,columnNames);
                table1.setModel(modele);
                TableCellRenderer tableRenderer;
                tableRenderer = table1.getDefaultRenderer(JButton.class);
                table1.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));


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
                                CourseDTO c = new CourseDTO(textField8.getText(), f);
                                cs.create(c);
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
                PersonDTO p = ps.get(item.getId());
                if (p instanceof StudentDTO) {
                    System.out.println(p.toString());

                    String s = String.valueOf(p.getId());
                    hiddenTextField1.setText(s);
                    textField2.setText(p.getLastname());
                    textField3.setText(p.getFirstname());
                    textField4.setText(p.getMailAddress());
                    textField5.setText(p.getAddress());
                    textField6.setText(p.getPhoneNumber());
                    textField7.setText(((StudentDTO)p).getDateOfBirth().toString());
                    passwordField2.setText(p.getPassword());
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
        createStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TF10 à TF15
                if (textField10.getText() == "" || textField11.getText() == "" || textField12.getText() == "" || textField13.getText() == "" || textField14.getText() == "" || textField15.getText() == "" || textField16.getText() == "") {
                    JOptionPane.showMessageDialog(null, "Un des champs est vide");
                } else {
                    //If nb hours is not numeric return msgbox
                    try {
                        //Create course with parameters
                        ServicePerson sp = new ServicePerson();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        Date auj = sdf.parse(textField15.getText());
                        sp.create(textField11.getText(), textField12.getText(), textField13.getText(), textField14.getText(), textField10.getText(), textField16.getText(), 4, auj ,"");
                        textField10.setText("");
                        textField11.setText("");
                        textField12.setText("");
                        textField13.setText("");
                        textField14.setText("");
                        textField15.setText("");
                        textField16.setText("");
                    } catch (NumberFormatException | ParseException nfe) {
                        JOptionPane.showMessageDialog(null, "Un des paramètres à pas a été renseigné");
                    }
                }
            }
        });
        associerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Item item = (Item) comboBox3.getSelectedItem();
                int idCourse = item.getId();
                Item item2 = (Item) comboBox2.getSelectedItem();
                int idStudent = item2.getId();

                ServicePerson ps = new ServicePerson();
                ps.linkToCourse(idStudent, idCourse);
            }
        });


        ActionListener modifyStudentAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TF2 à TF7
                if (textField2.getText() == "" || textField3.getText() == "" || textField4.getText() == "" || textField5.getText() == "" || textField6.getText() == "" || textField7.getText() == "" || passwordField2.getText() == "") {
                    JOptionPane.showMessageDialog(null, "Un des champs est vide");
                } else {
                    //If nb hours is not numeric return msgbox
                    try {
                        //Create course with parameters
                        ServicePerson sp = new ServicePerson();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        Date auj = sdf.parse(textField7.getText());
                        sp.update(textField3.getText(), textField4.getText(), textField5.getText(), textField6.getText(), textField2.getText(), passwordField2.getText(), 4, auj ,"");
                        textField2.setText("");
                        textField3.setText("");
                        textField4.setText("");
                        textField5.setText("");
                        textField6.setText("");
                        textField7.setText("");
                        passwordField2.setText("");
                    } catch (NumberFormatException | ParseException nfe) {
                        JOptionPane.showMessageDialog(null, "Un des paramètres n'a pas été renseigné");
                    }
                }
            }
        };

        modifyStudent.addActionListener(modifyStudentAction);

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
        frame.setTitle("Gestion d'établissement");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.decode("#343a40"));
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

class StudentTableModel extends AbstractTableModel {
    private Object[][] data;
    private String[] columnNames;


    public StudentTableModel(Object[][] data, String[] columnNames) {
        this.data = data;
        this.columnNames = columnNames;
    }

    /**
     * Returns the number of rows in the table model.
     */
    public int getRowCount() {
        return data.length;
    }

    /**
     * Returns the number of columns in the table model.
     */
    public int getColumnCount() {
        return columnNames.length;
    }

    /**
     * Returns the column name for the column index.
     */
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    /**
     * Returns data type of the column specified by its index.
     */
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

    /**
     * Returns the value of a table model at the specified
     * row index and column index.
     */
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }
}

class JTableButtonRenderer implements TableCellRenderer {
    private TableCellRenderer defaultRenderer;
    public JTableButtonRenderer(TableCellRenderer renderer) {
        defaultRenderer = renderer;
    }
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if(value instanceof Component)
            return (Component)value;
        return defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
