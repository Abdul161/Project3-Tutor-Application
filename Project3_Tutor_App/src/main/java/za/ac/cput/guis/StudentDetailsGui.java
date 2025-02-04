package za.ac.cput.guis;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.DriverManager;

/**
 *Chante Lewis
 *StudentDetailsGui.java
 *Due Date: 22 October 2022
 *Subject: Project3
 */
public class StudentDetailsGui extends javax.swing.JFrame {


    /**
     * Creates new form
     * StudentDetailsGui
     */
    public StudentDetailsGui() {
        initComponents();
        Connect();
        Student_Load();

    }
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    //Connect to database
    public void Connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/projectapp", "root","");
            System.out.println("Database Connection Success");
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }


    //Retrieve data from database and load onto table
    public void Student_Load(){

        try {
            String query = "SELECT * FROM Student_credential";

            Statement pst = con.createStatement();
            ResultSet rs = pst.executeQuery(query);

            String columns[] = { "Id", "First_Name", "Surname", "Email_Address", "Course_Enrolled_In"};
            String data[][] = new String[5][5];

            int i = 0;
            while (rs.next()) {
                String id = rs.getString("Id");
                String name = rs.getString("First_Name");
                String sname = rs.getString("Surname");
                String email = rs.getString("Email_Address");
                String course = rs.getString("Course_Enrolled_In");
                data[i][0] = id + "";
                data[i][1] = name;
                data[i][2] = sname;
                data[i][3] = email;
                data[i][4] = course;
                i++;
            }
            DefaultTableModel model = new DefaultTableModel(data, columns);
            jTableData.setModel(model);
        } catch(SQLException e) {JOptionPane.showMessageDialog(null, "Error displaying data!");}

    }
    /**
     * This method is called from within
     * the constructor to initialize the
     * form. WARNING: Do NOT modify this
     * code. The content of this method
     * is always regenerated by the Form
     * Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableData = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblStuDetails = new javax.swing.JLabel();
        lblStudentID = new javax.swing.JLabel();
        txtStudentID = new javax.swing.JTextField();
        lblDetailsView = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtStuDisplay = new javax.swing.JTextPane();
        lblStuDetailsDatabse = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(23, 37, 42));

        jPanel2.setBackground(new java.awt.Color(23, 37, 42));

        jTableData.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTableData.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String [] {
                        "Id", "First_Name", "Surname", "Email_Address", "Course_Enrolled_In"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableData);

        jPanel1.setBackground(new java.awt.Color(43, 122, 120));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblStuDetails.setFont(new java.awt.Font("Verdana", 1, 30)); // NOI18N
        lblStuDetails.setForeground(new java.awt.Color(255, 255, 255));
        lblStuDetails.setText("Student Details");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(227, 227, 227)
                                .addComponent(lblStuDetails)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(29, Short.MAX_VALUE)
                                .addComponent(lblStuDetails)
                                .addGap(16, 16, 16))
        );

        lblStudentID.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblStudentID.setForeground(new java.awt.Color(255, 255, 255));
        lblStudentID.setText("Student ID:");

        txtStudentID.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtStudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentIDActionPerformed(evt);
            }
        });
        txtStudentID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtStudentIDKeyPressed(evt);
            }
        });

        lblDetailsView.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblDetailsView.setForeground(new java.awt.Color(255, 255, 255));
        lblDetailsView.setText("Student Details Displayed:");

        txtStuDisplay.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(txtStuDisplay);

        lblStuDetailsDatabse.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblStuDetailsDatabse.setForeground(new java.awt.Color(255, 255, 255));
        lblStuDetailsDatabse.setText("Student Details in database:");

        btnSearch.setBackground(new java.awt.Color(58, 175, 169));
        btnSearch.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(58, 175, 169));
        btnBack.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(58, 175, 169));
        btnClear.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(58, 175, 169));
        btnExit.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lblStudentID)
                                                                        .addComponent(lblStuDetailsDatabse))
                                                                .addGap(346, 346, 346))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                                .addComponent(txtStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(72, 72, 72)))
                                                .addGap(102, 102, 102))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)
                                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)))
                                .addComponent(btnExit)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(20, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblDetailsView)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblDetailsView, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(lblStudentID)
                                                .addGap(26, 26, 26)
                                                .addComponent(lblStuDetailsDatabse)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnSearch)
                                        .addComponent(btnBack)
                                        .addComponent(btnClear)
                                        .addComponent(btnExit))
                                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {
        // Code for searching using StudentID
        try {
            String str = txtStudentID.getText();
            PreparedStatement st = con.prepareStatement("select * from Student_credential where Id=?");
            st.setString(1, str);
            //Executing Query
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String s = rs.getString("Id");
                String s1 = rs.getString("First_Name");
                String s2 = rs.getString("Surname");
                String s3 = rs.getString("Email_Address");
                String s4 = rs.getString("Course_Enrolled_In");
                //Sets Records in TextFields.
                txtStuDisplay.setText("Student number: " + s + "\nStudent name: " + s1 + "\nStudent surname: " +s2+ "\nEmail Address: " +s3+ "\nCourse: " +s4);
            } else {
                JOptionPane.showMessageDialog(null, "StudentID not found");
            }
            //Create Exception Handler
        } catch (HeadlessException | SQLException ex) {
            System.out.println(ex);
        }

    }

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
        // Back button (full action to be implemented when application is integrated)
        dispose();
        new za.ac.cput.guis.HomepageStudent().setGUI();
    }

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {
        //Code to clear/cancel form
        txtStudentID.setText("");
        txtStuDisplay.setText("");
    }

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {
        // Code to exit system

        int response = JOptionPane.showConfirmDialog(rootPane, "Would you like to exit?");

        if(response == JOptionPane.YES_OPTION){
            System.exit(0);
        }

    }

    private void jTableDataMouseClicked(java.awt.event.MouseEvent evt) {
        //Code to select/click data in table and display in textfield
        int row = jTableData.getSelectedRow();
        String tc = jTableData.getModel().getValueAt(row, 0).toString();
        try {
            PreparedStatement st = con.prepareStatement("select * from Student_credential where Id="+tc+"");
            //Excuting Query
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String s = rs.getString("Id");
                String s1 = rs.getString("First_Name");
                String s2 = rs.getString("Surname");
                String s3 = rs.getString("Email_Address");
                String s4 = rs.getString("Course_Enrolled_In");

                //Sets Records in TextFields.
                txtStuDisplay.setText("Student number: " + s + "\nStudent name: " + s1 + "\nStudent surname: " +s2+ "\nEmail Address: " +s3+ "\nCourse: " +s4);
            } else {
                JOptionPane.showMessageDialog(null,"Student does not exist!");
            }
            //Create Exception Handler
        } catch (HeadlessException | SQLException ex) {
            System.out.println(ex);
        }
    }

    private void txtStudentIDKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:

       if (evt.getKeyCode()== KeyEvent.VK_ENTER){
            try {
                String str = txtStudentID.getText();
                PreparedStatement st = con.prepareStatement("select * from Student_credential where Id=?");
                st.setString(1, str);
                //Excuting Query
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    String s = rs.getString("Id");
                    String s1 = rs.getString("First_Name");
                    String s2 = rs.getString("Surname");
                    String s3 = rs.getString("Email_Address");
                    String s4 = rs.getString("Course_Enrolled_In");
                    //Sets Records in TextFields.
                    txtStuDisplay.setText("StudentID: " + s + "\nStudent name: " + s1 + "\nStudent surname: " +s2+ "\nEmail Address: " +s3+ "\nCourse: " +s4);
                } else {
                    JOptionPane.showMessageDialog(null, "Student Id not found!"); }
                //Create Exception Handler
            } catch (HeadlessException | SQLException ex) {
                System.out.println(ex);
            }
        }
    }

    private void txtStudentIDActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * @param args the command line
     * arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(StudentDetailsGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(StudentDetailsGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(StudentDetailsGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(StudentDetailsGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new StudentDetailsGui().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableData;
    private javax.swing.JLabel lblDetailsView;
    private javax.swing.JLabel lblStuDetails;
    private javax.swing.JLabel lblStuDetailsDatabse;
    private javax.swing.JLabel lblStudentID;
    private javax.swing.JTextPane txtStuDisplay;
    private javax.swing.JTextField txtStudentID;
    // End of variables declaration
}
