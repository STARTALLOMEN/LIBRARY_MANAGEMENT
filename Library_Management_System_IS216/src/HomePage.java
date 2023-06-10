/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author trieu
 */
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    Color mouseEnterColor = new Color(0,0,0);
    Color mouseExitColor = new Color(51,51,51);
    DefaultTableModel model;
    public HomePage() {
        initComponents();
        showPieChart(); 
        setStudentDetailsToTable();
        setBookDetailsToTable();
        setDatatoCards();
    }

    public void showPieChart(){
        
        //create dataset
      DefaultPieDataset barDataset = new DefaultPieDataset( );
      
      try{

             Connection con = DBConnection.getConnection();
             String sql= "select book_name ,count(*) as issue_count from issue_book_details group by book_id";
             Statement st= con.createStatement();
             ResultSet rs =st.executeQuery(sql);
             
             while (rs.next()){
                 barDataset.setValue(rs.getString("book_name") , Double.valueOf(rs.getDouble("issue_count")));  

                 

             }
             
        }catch(Exception e){
            e.printStackTrace();
        }


      
      //create chart
       JFreeChart piechart = ChartFactory.createPieChart("Issue Book Details",barDataset, true,true,false);//explain
      
        PiePlot piePlot =(PiePlot) piechart.getPlot();
      
       //changing pie chart blocks colors
       piePlot.setSectionPaint("IPhone 5s", new Color(255,255,102));
        piePlot.setSectionPaint("SamSung Grand", new Color(102,255,102));
        piePlot.setSectionPaint("MotoG", new Color(255,102,153));
        piePlot.setSectionPaint("Nokia Lumia", new Color(0,204,204));
      
       
        piePlot.setBackgroundPaint(Color.white);
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panelPieChart.removeAll();
        panelPieChart.add(barChartPanel, BorderLayout.CENTER);
        panelPieChart.validate();
    }
    //to set the student details into the table
    
    public void setStudentDetailsToTable(){
        try{
             Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","TRIEUBUI003@");
             Statement st= con.createStatement();
             ResultSet rs =st.executeQuery("select * from student_details");
             
             while (rs.next()){
                 String StudentId =rs.getString("student_id");
                 String StudentName =rs.getString("student_name");
                 String course =rs.getString("course");
                 String branch =rs.getString("branch");
                 
                 Object[] obj ={StudentId,StudentName,course,branch};
                 model = (DefaultTableModel)tbl_studentDetails.getModel();
                 model.addRow(obj);
             }
             
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //to set the book details into the table
    public void setBookDetailsToTable(){
        try{
             Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","TRIEUBUI003@");
             Statement st= con.createStatement();
             ResultSet rs =st.executeQuery("select * from book_details");
             
             while (rs.next()){
                 String bookID =rs.getString("book_id");
                 String bookName =rs.getString("book_name");
                 String author =rs.getString("author");
                 int quantity =rs.getInt("quantity");
                 
                 Object[] obj ={bookID,bookName,author,quantity};
                 model = (DefaultTableModel)tbl_bookDetails.getModel();
                 model.addRow(obj);
             }
             
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void setDatatoCards(){
        Statement st = null;
        ResultSet rs =null;
        long l =System.currentTimeMillis();
        Date todaysDate= new Date(l);
        try{
             Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","TRIEUBUI003@");
             st= con.createStatement();
             rs =st.executeQuery("select * from book_details");
             rs.last();
             lbl_nofBook.setText(Integer.toString(rs.getRow()));
             
             rs =st.executeQuery("select * from student_details");
             rs.last();
             lbl_nofStudent.setText(Integer.toString(rs.getRow()));

             rs =st.executeQuery("select * from issue_book_details where status = '"+"pending"+"'");
             rs.last();
             lbl_issueBook.setText(Integer.toString(rs.getRow()));
             
             rs =st.executeQuery("select * from issue_book_details where due_date < '"+todaysDate+"'and status = '"+"pending"+"'");
             rs.last();
             lbl_defaulterList.setText(Integer.toString(rs.getRow()));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        lbl_nofBook = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        lbl_nofStudent = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();
        lbl_issueBook = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        lbl_defaulterList = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_studentDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel56 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bookDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel57 = new javax.swing.JLabel();
        panelPieChart = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_menu_48px_1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 45));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 5, 45));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 30)); // NOI18N
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 0, -1, 20));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Library IS216");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 100, 30));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/male_user_50px.png"))); // NOI18N
        jLabel4.setText("Welcome, Admin");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 10, 210, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 60));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/home_24px.png"))); // NOI18N
        jLabel7.setText("Home Page");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 110, 40));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 40));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Book_26px.png"))); // NOI18N
        jLabel6.setText("Manage Book");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 50));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 220, 50));

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Read_Online_26px.png"))); // NOI18N
        jLabel8.setText("Manage Students");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 160, 50));

        jPanel9.setBackground(new java.awt.Color(255, 51, 51));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel10.setText("LMS Dashboard");
        jPanel9.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 50));

        jPanel10.setBackground(new java.awt.Color(255, 51, 51));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel11.setText("LMS Dashboard");
        jPanel10.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 50));

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 240, 50));

        jPanel7.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 240, 50));

        jPanel11.setBackground(new java.awt.Color(255, 51, 51));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel12.setText("LMS Dashboard");
        jPanel11.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 50));

        jPanel12.setBackground(new java.awt.Color(255, 51, 51));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel13.setText("LMS Dashboard");
        jPanel12.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 50));

        jPanel11.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 240, 50));

        jPanel7.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 240, 50));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 220, 50));

        jPanel18.setBackground(new java.awt.Color(255, 51, 51));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel19.setText("LMS Dashboard");
        jPanel18.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 50));

        jPanel19.setBackground(new java.awt.Color(255, 51, 51));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel20.setText("LMS Dashboard");
        jPanel19.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 50));

        jPanel20.setBackground(new java.awt.Color(255, 51, 51));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel21.setText("LMS Dashboard");
        jPanel20.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 50));

        jPanel19.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 240, 50));

        jPanel18.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 240, 50));

        jPanel21.setBackground(new java.awt.Color(255, 51, 51));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel22.setText("LMS Dashboard");
        jPanel21.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 50));

        jPanel22.setBackground(new java.awt.Color(255, 51, 51));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel23.setText("LMS Dashboard");
        jPanel22.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 50));

        jPanel21.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 240, 50));

        jPanel18.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 240, 50));

        jPanel3.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 220, 50));

        jPanel23.setBackground(new java.awt.Color(51, 51, 51));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        jLabel24.setText("Issue Book");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel24MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel24MouseExited(evt);
            }
        });
        jPanel23.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 50));

        jPanel24.setBackground(new java.awt.Color(255, 51, 51));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel25.setText("LMS Dashboard");
        jPanel24.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 50));

        jPanel25.setBackground(new java.awt.Color(255, 51, 51));
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel26.setText("LMS Dashboard");
        jPanel25.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 50));

        jPanel24.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 240, 50));

        jPanel23.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 240, 50));

        jPanel26.setBackground(new java.awt.Color(255, 51, 51));
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel27.setText("LMS Dashboard");
        jPanel26.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 50));

        jPanel27.setBackground(new java.awt.Color(255, 51, 51));
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel28.setText("LMS Dashboard");
        jPanel27.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 50));

        jPanel26.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 240, 50));

        jPanel23.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 240, 50));

        jPanel3.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 220, 50));

        jPanel28.setBackground(new java.awt.Color(51, 51, 51));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Return_Purchase_26px.png"))); // NOI18N
        jLabel29.setText("Return Book");
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel29MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel29MouseExited(evt);
            }
        });
        jPanel28.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 50));

        jPanel29.setBackground(new java.awt.Color(255, 51, 51));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel30.setText("LMS Dashboard");
        jPanel29.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 50));

        jPanel30.setBackground(new java.awt.Color(255, 51, 51));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel31.setText("LMS Dashboard");
        jPanel30.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 50));

        jPanel29.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 240, 50));

        jPanel28.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 240, 50));

        jPanel31.setBackground(new java.awt.Color(255, 51, 51));
        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel32.setText("LMS Dashboard");
        jPanel31.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 50));

        jPanel32.setBackground(new java.awt.Color(255, 51, 51));
        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel33.setText("LMS Dashboard");
        jPanel32.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 50));

        jPanel31.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 240, 50));

        jPanel28.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 240, 50));

        jPanel3.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 220, 50));

        jPanel33.setBackground(new java.awt.Color(51, 51, 51));
        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_View_Details_26px.png"))); // NOI18N
        jLabel34.setText("View Record");
        jLabel34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel34MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel34MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel34MouseExited(evt);
            }
        });
        jPanel33.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 50));

        jPanel34.setBackground(new java.awt.Color(255, 51, 51));
        jPanel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel35.setText("LMS Dashboard");
        jPanel34.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 50));

        jPanel35.setBackground(new java.awt.Color(255, 51, 51));
        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel36.setText("LMS Dashboard");
        jPanel35.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 50));

        jPanel34.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 240, 50));

        jPanel33.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 240, 50));

        jPanel36.setBackground(new java.awt.Color(255, 51, 51));
        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel37.setText("LMS Dashboard");
        jPanel36.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 50));

        jPanel37.setBackground(new java.awt.Color(255, 51, 51));
        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel38.setText("LMS Dashboard");
        jPanel37.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 50));

        jPanel36.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 240, 50));

        jPanel33.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 240, 50));

        jPanel3.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 220, 50));

        jPanel38.setBackground(new java.awt.Color(51, 51, 51));
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Books_26px.png"))); // NOI18N
        jLabel39.setText("View Issue Books");
        jLabel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel39MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel39MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel39MouseExited(evt);
            }
        });
        jPanel38.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 160, 50));

        jPanel39.setBackground(new java.awt.Color(255, 51, 51));
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel40.setText("LMS Dashboard");
        jPanel39.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 50));

        jPanel40.setBackground(new java.awt.Color(255, 51, 51));
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel41.setText("LMS Dashboard");
        jPanel40.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 50));

        jPanel39.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 240, 50));

        jPanel38.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 240, 50));

        jPanel41.setBackground(new java.awt.Color(255, 51, 51));
        jPanel41.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel42.setText("LMS Dashboard");
        jPanel41.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 50));

        jPanel42.setBackground(new java.awt.Color(255, 51, 51));
        jPanel42.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel43.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel43.setText("LMS Dashboard");
        jPanel42.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 50));

        jPanel41.add(jPanel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 240, 50));

        jPanel38.add(jPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 240, 50));

        jPanel3.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 220, 50));

        jPanel43.setBackground(new java.awt.Color(51, 51, 51));
        jPanel43.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Conference_26px.png"))); // NOI18N
        jLabel44.setText("Defaulter list ");
        jLabel44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel44MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel44MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel44MouseExited(evt);
            }
        });
        jPanel43.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 50));

        jPanel44.setBackground(new java.awt.Color(255, 51, 51));
        jPanel44.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel45.setText("LMS Dashboard");
        jPanel44.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 50));

        jPanel45.setBackground(new java.awt.Color(255, 51, 51));
        jPanel45.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel46.setText("LMS Dashboard");
        jPanel45.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 50));

        jPanel44.add(jPanel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 240, 50));

        jPanel43.add(jPanel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 240, 50));

        jPanel46.setBackground(new java.awt.Color(255, 51, 51));
        jPanel46.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel47.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel47.setText("LMS Dashboard");
        jPanel46.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 50));

        jPanel47.setBackground(new java.awt.Color(255, 51, 51));
        jPanel47.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel48.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel48.setText("LMS Dashboard");
        jPanel47.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 50));

        jPanel46.add(jPanel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 240, 50));

        jPanel43.add(jPanel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 240, 50));

        jPanel3.add(jPanel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 220, 50));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Features");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 150, 50));

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Exit_26px_2.png"))); // NOI18N
        jLabel14.setText("Log out");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 150, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 220, 590));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));

        lbl_nofBook.setBackground(new java.awt.Color(102, 102, 102));
        lbl_nofBook.setFont(new java.awt.Font("Segoe UI Black", 1, 40)); // NOI18N
        lbl_nofBook.setForeground(new java.awt.Color(102, 102, 102));
        lbl_nofBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Book_Shelf_50px.png"))); // NOI18N
        lbl_nofBook.setText("10");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lbl_nofBook)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(lbl_nofBook)
                .addGap(16, 16, 16))
        );

        jPanel4.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 195, 105));

        jLabel49.setBackground(new java.awt.Color(102, 102, 102));
        jLabel49.setFont(new java.awt.Font("Segoe UI Black", 1, 15)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(102, 102, 102));
        jLabel49.setText("Student Details");
        jPanel4.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        jLabel50.setBackground(new java.awt.Color(102, 102, 102));
        jLabel50.setFont(new java.awt.Font("Segoe UI Black", 1, 15)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(102, 102, 102));
        jLabel50.setText("No of Students");
        jPanel4.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, -1, -1));

        jPanel48.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(102, 102, 255)));

        lbl_nofStudent.setBackground(new java.awt.Color(102, 102, 102));
        lbl_nofStudent.setFont(new java.awt.Font("Segoe UI Black", 1, 40)); // NOI18N
        lbl_nofStudent.setForeground(new java.awt.Color(102, 102, 102));
        lbl_nofStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_People_50px.png"))); // NOI18N
        lbl_nofStudent.setText("10");

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lbl_nofStudent)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel48Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(lbl_nofStudent)
                .addGap(16, 16, 16))
        );

        jPanel4.add(jPanel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 195, 105));

        jLabel52.setBackground(new java.awt.Color(102, 102, 102));
        jLabel52.setFont(new java.awt.Font("Segoe UI Black", 1, 15)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(102, 102, 102));
        jLabel52.setText("Issued Books");
        jPanel4.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, -1, -1));

        jPanel49.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));

        lbl_issueBook.setBackground(new java.awt.Color(102, 102, 102));
        lbl_issueBook.setFont(new java.awt.Font("Segoe UI Black", 1, 40)); // NOI18N
        lbl_issueBook.setForeground(new java.awt.Color(102, 102, 102));
        lbl_issueBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_Sell_50px.png"))); // NOI18N
        lbl_issueBook.setText("10");

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lbl_issueBook)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(lbl_issueBook)
                .addGap(16, 16, 16))
        );

        jPanel4.add(jPanel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 195, 105));

        jPanel50.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(102, 102, 255)));

        lbl_defaulterList.setBackground(new java.awt.Color(102, 102, 102));
        lbl_defaulterList.setFont(new java.awt.Font("Segoe UI Black", 1, 40)); // NOI18N
        lbl_defaulterList.setForeground(new java.awt.Color(102, 102, 102));
        lbl_defaulterList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/adminIcons/adminIcons/icons8_List_of_Thumbnails_50px.png"))); // NOI18N
        lbl_defaulterList.setText("10");

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lbl_defaulterList)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel50Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(lbl_defaulterList)
                .addGap(16, 16, 16))
        );

        jPanel4.add(jPanel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 80, 195, 105));

        jLabel55.setBackground(new java.awt.Color(102, 102, 102));
        jLabel55.setFont(new java.awt.Font("Segoe UI Black", 1, 15)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(102, 102, 102));
        jLabel55.setText("Defaulter List");
        jPanel4.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 40, -1, -1));

        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "Course", "Branch"
            }
        ));
        tbl_studentDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_studentDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_studentDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_studentDetails.setColorForegroundHead(new java.awt.Color(255, 51, 51));
        tbl_studentDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        tbl_studentDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jScrollPane1.setViewportView(tbl_studentDetails);
        if (tbl_studentDetails.getColumnModel().getColumnCount() > 0) {
            tbl_studentDetails.getColumnModel().getColumn(1).setResizable(false);
            tbl_studentDetails.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 530, 150));

        jLabel56.setBackground(new java.awt.Color(102, 102, 102));
        jLabel56.setFont(new java.awt.Font("Segoe UI Black", 1, 15)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(102, 102, 102));
        jLabel56.setText("No of Books");
        jPanel4.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        tbl_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Name", "Author", "Quantity"
            }
        ));
        tbl_bookDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_bookDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_bookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_bookDetails.setColorForegroundHead(new java.awt.Color(255, 51, 51));
        tbl_bookDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 15)); // NOI18N
        tbl_bookDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jScrollPane2.setViewportView(tbl_bookDetails);
        if (tbl_bookDetails.getColumnModel().getColumnCount() > 0) {
            tbl_bookDetails.getColumnModel().getColumn(1).setResizable(false);
            tbl_bookDetails.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 530, 150));

        jLabel57.setBackground(new java.awt.Color(102, 102, 102));
        jLabel57.setFont(new java.awt.Font("Segoe UI Black", 1, 15)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(102, 102, 102));
        jLabel57.setText("Book Details");
        jPanel4.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, -1, -1));

        panelPieChart.setLayout(new java.awt.BorderLayout());
        jPanel4.add(panelPieChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, 330, 290));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 1060, 590));

        setBounds(0, 0, 1282, 654);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        ManageBooks books =new ManageBooks();
        books.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        // TODO add your handling code here:
        jPanel6.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        // TODO add your handling code here:
        jPanel6.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        // TODO add your handling code here:
        jPanel7.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        // TODO add your handling code here:
        jPanel7.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        ManageStudents student =new ManageStudents();
        student.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        // TODO add your handling code here:
        IssueBook book = new IssueBook();
        book.setVisible(true);
        dispose( );
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseEntered
        // TODO add your handling code here:
        jPanel23.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel24MouseEntered

    private void jLabel24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseExited
        // TODO add your handling code here:
        jPanel23.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel24MouseExited

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        // TODO add your handling code here:
        ReturnBook returnbook = new ReturnBook();
        returnbook.setVisible(true);
        dispose( );
    }//GEN-LAST:event_jLabel29MouseClicked

    private void jLabel29MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseEntered
        // TODO add your handling code here:
        jPanel28.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel29MouseEntered

    private void jLabel29MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseExited
        // TODO add your handling code here:
        jPanel28.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel29MouseExited

    private void jLabel34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseClicked
        // TODO add your handling code here:
        ViewAllRecord viewbook = new ViewAllRecord();
        viewbook.setVisible(true);
        dispose( );
    }//GEN-LAST:event_jLabel34MouseClicked

    private void jLabel34MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseEntered
        // TODO add your handling code here:
        jPanel33.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel34MouseEntered

    private void jLabel34MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseExited
        // TODO add your handling code here:
        jPanel33.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel34MouseExited

    private void jLabel39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseClicked
        // TODO add your handling code here:
        IssuebookDetails ibdetails = new IssuebookDetails();
        ibdetails.setVisible(true);
        dispose( );
    }//GEN-LAST:event_jLabel39MouseClicked

    private void jLabel39MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseEntered
        // TODO add your handling code here:
        jPanel38.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel39MouseEntered

    private void jLabel39MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseExited
        // TODO add your handling code here:
        jPanel38.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel39MouseExited

    private void jLabel44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MouseClicked
        // TODO add your handling code here:
        DefaultList dlist = new DefaultList();
        dlist.setVisible(true);
        dispose( );
    }//GEN-LAST:event_jLabel44MouseClicked

    private void jLabel44MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MouseEntered
        // TODO add your handling code here:
        jPanel43.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel44MouseEntered

    private void jLabel44MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MouseExited
        // TODO add your handling code here:
        jPanel43.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel44MouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_defaulterList;
    private javax.swing.JLabel lbl_issueBook;
    private javax.swing.JLabel lbl_nofBook;
    private javax.swing.JLabel lbl_nofStudent;
    private javax.swing.JPanel panelPieChart;
    private rojeru_san.complementos.RSTableMetro tbl_bookDetails;
    private rojeru_san.complementos.RSTableMetro tbl_studentDetails;
    // End of variables declaration//GEN-END:variables
}
