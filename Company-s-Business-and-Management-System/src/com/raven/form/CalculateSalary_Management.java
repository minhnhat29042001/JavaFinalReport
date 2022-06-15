package com.raven.form;

import Login.EventCallBack;
import Login.EventTextField;
import Model.Bonus;
import Model.Bonus_Modify;
import Model.Contract;
import Model.Contract_Modify;
import Model.Contracttype;
import Model.Contracttype_Modify;
import Model.OvertimePay;
import Model.OvertimePay_Modify;
import Model.Role;
import Model.RoleManagement;
import Model.RoleManagement_Modify;
import Model.Role_Modify;
import Model.Salary;
import Model.SalaryMa;
import Model.SalaryMa_Modify;
import Model.Salary_Modify;
import Model.Staff;
import Model.Staff_Modify;
import com.raven.component.Card_EditStaffInfo;
import com.raven.datechooser.SelectedDate;
import com.raven.dialog.Message;
import com.raven.main.Main;
import com.raven.model.ModelCard;
import com.raven.model.ModelStudent;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import com.raven.swing.noticeboard.ModelNoticeBoard;
import com.raven.swing.table.EventAction;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import static oracle.jdbc.OracleTypes.NULL;


public class CalculateSalary_Management extends javax.swing.JPanel {
DefaultTableModel tableModel;
Calendar cal=new GregorianCalendar();
List<Staff> staffList = new ArrayList<>();
    
    public CalculateSalary_Management() {
        initComponents();
        tableModel = (DefaultTableModel) table1.getModel();
        showStaff();
        showBonus();
        showOvertimePay();
        
        changeTime();
        changeOvertime();
        btnAdd.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnEsc.setEnabled(true);
        combobox_OTP.setSelectedIndex(-1);
        comboboxbonus.setSelectedIndex(-1);
        Search();
 
        
    }
    
    private void reset(){
        btnAdd.setEnabled(false);
        
        btnUpdate.setEnabled(false);
        btnEsc.setEnabled(true);
     
        text_ID.setText("");
        text_Name.setText("");
        text_role.setText("");
        textAllowance.setText("");
        text_contract.setText("");
        text_basicsalary.setText("");
        textTimeSalary.setText("");
        textdepartment.setText("");
        textBonus.setText("");
        textOVT.setText("");
        textOVTMoney.setText("");
        textTotalSalary.setText("");
        combobox_OTP.setSelectedIndex(-1);
        comboboxbonus.setSelectedIndex(-1);
    }
    
    private void showStaff(){
        List<Staff> staffList = Staff_Modify.findAll();
        
        tableModel.setRowCount(0);
        
        staffList.forEach(staff -> {
            tableModel.addRow(new Object[] {staff.getId(), staff.getHoten(), staff.getPhongban() } );
        });
        
    }
    
    private void changeTime(){
        textTimeSalary.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                change();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                change(); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                change(); //To change body of generated methods, choose Tools | Templates.
            }
            
            public void change(){
                int emid = Integer.valueOf(text_ID.getText());
        SelectedDate d = dateSalary.getSelectedDate();
        int month = d.getMonth();
        int year = d.getYear();
        SalaryMa salaryma = SalaryMa_Modify.getSalary(emid, month, year);
        if (salaryma.getBonusLevel() == null){
        
        textBonus.setText("");
            textOVT.setText("");
            textOVTMoney.setText("");
            textTotalSalary.setText("");
            
        btnUpdate.setEnabled(false);
         btnAdd.setEnabled(true);
            }
        else
        {
        textOVT.setText(salaryma.getOvertime()+"");
        comboboxbonus.setSelectedItem(salaryma.getBonusLevel());
        combobox_OTP.setSelectedItem(salaryma.getOvertimePay()+"");
        textOVTMoney.setText(salaryma.getTotalOVT()+"");
        textTotalSalary.setText(salaryma.getTotalSalary()+"");   
        
         btnUpdate.setEnabled(true);
         btnAdd.setEnabled(false);
        }
            }
        });
    }
    
    private void changeOvertime(){
        
        textOVT.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                change();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                delete();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                change(); //To change body of generated methods, choose Tools | Templates.
            }
            
            public void change(){
            int a = Integer.valueOf(textOVT.getText());
        int b = Integer.valueOf(combobox_OTP.getSelectedItem()+"");
        textOVTMoney.setText((a*b)+"");
        int totalsalary;
            int allowance1 = Integer.parseInt((String) textAllowance.getText());
            int basicsalary2 = Integer.parseInt((String) text_basicsalary.getText());
            int bonus3 = Integer.parseInt((String) textBonus.getText());
            int overtime4 = Integer.parseInt((String) textOVTMoney.getText());
            totalsalary = allowance1+basicsalary2+bonus3+overtime4;
        
            textTotalSalary.setText(String.valueOf(totalsalary));
            }
            
            public void delete(){
            
            textOVTMoney.setText("");
            }
        });
    }
    
    public void showOvertimePay(){
        
         List<OvertimePay> otpList = OvertimePay_Modify.findAll();
         for(OvertimePay bon :otpList){
             int ot = bon.getOvertimePay();
             String otp = ot+"";
             combobox_OTP.addItem(otp);
         }
        
    }
    
    public void showBonus(){
         List<Bonus> bonusList = Bonus_Modify.findAll();
         for(Bonus bon :bonusList){
             comboboxbonus.addItem(bon.getBonus_Level());
         }
        
    }
    
    
    private void Search(){
        SearchTextField.addEvent(new EventTextField() {
            @Override
            public void onPressed(EventCallBack call) {
               String input = SearchTextField.getText();
        if (input != null && input.length() > 0){
            staffList = Staff_Modify.findByName(input);
            tableModel.setRowCount(0);
        
        staffList.forEach((staff) -> {
            tableModel.addRow(new Object[] {staff.getId(), staff.getHoten(),
                staff.getPhongban() } );
        });
        }  
        else showStaff();
                try {
                    for (int i = 1; i <= 100; i++) {
                        //do action here
                        Thread.sleep(10000);
                    }
                    call.done();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }

            @Override
            public void onCancel() {
                showStaff();
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateSalary = new com.raven.datechooser.DateChooser();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        textOVT = new com.raven.swing.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.raven.swing.table.Table();
        text_contract = new com.raven.swing.TextField();
        text_basicsalary = new com.raven.swing.TextField();
        text_ID = new com.raven.swing.TextField();
        textdepartment = new com.raven.swing.TextField();
        textBonus = new com.raven.swing.TextField();
        textOVTMoney = new com.raven.swing.TextField();
        text_Name = new com.raven.swing.TextField();
        textTotalSalary = new com.raven.swing.TextField();
        textAllowance = new com.raven.swing.TextField();
        text_role = new com.raven.swing.TextField();
        combobox_OTP = new com.raven.swing.Combobox<>();
        comboboxbonus = new com.raven.swing.Combobox<>();
        textTimeSalary = new com.raven.swing.TextField();
        SearchTextField = new Login.TextFieldAnimation();
        jToolBar2 = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnEsc = new javax.swing.JButton();

        dateSalary.setForeground(new java.awt.Color(0, 153, 247));
        dateSalary.setDateFormat("dd-MMMM-yyyy");
        dateSalary.setTextRefernce(textTimeSalary);

        setPreferredSize(new java.awt.Dimension(1726, 820));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("STAFF SALARY MANGEMENT");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(76, 76, 76));
        jLabel5.setText("Data Staff");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        textOVT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textOVT.setLabelText("OVERTIME");
        textOVT.setLineColor(new java.awt.Color(0, 0, 0));

        jScrollPane1.setBorder(null);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "STAFF NAME", "DEPARTMENT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        table1.getTableHeader().setReorderingAllowed(false);
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        text_contract.setEditable(false);
        text_contract.setBackground(new java.awt.Color(255, 255, 255));
        text_contract.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_contract.setLabelText("CONTRACT TYPE");

        text_basicsalary.setEditable(false);
        text_basicsalary.setBackground(new java.awt.Color(255, 255, 255));
        text_basicsalary.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_basicsalary.setLabelText("BASIC SALARY");
        text_basicsalary.setLineColor(new java.awt.Color(0, 0, 0));

        text_ID.setEditable(false);
        text_ID.setBackground(new java.awt.Color(255, 255, 255));
        text_ID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_ID.setLabelText("EMPLOYEE ID");
        text_ID.setLineColor(new java.awt.Color(0, 0, 0));

        textdepartment.setEditable(false);
        textdepartment.setBackground(new java.awt.Color(255, 255, 255));
        textdepartment.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textdepartment.setLabelText("DEPARTMENT");
        textdepartment.setLineColor(new java.awt.Color(0, 0, 0));

        textBonus.setEditable(false);
        textBonus.setBackground(new java.awt.Color(255, 255, 255));
        textBonus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textBonus.setLabelText("BONUS MONEY");
        textBonus.setLineColor(new java.awt.Color(0, 0, 0));

        textOVTMoney.setEditable(false);
        textOVTMoney.setBackground(new java.awt.Color(255, 255, 255));
        textOVTMoney.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textOVTMoney.setLabelText("OVERTIME MONEY");
        textOVTMoney.setLineColor(new java.awt.Color(0, 0, 0));

        text_Name.setEditable(false);
        text_Name.setBackground(new java.awt.Color(255, 255, 255));
        text_Name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_Name.setLabelText("EMPLOYEE NAME");
        text_Name.setLineColor(new java.awt.Color(0, 0, 0));

        textTotalSalary.setEditable(false);
        textTotalSalary.setBackground(new java.awt.Color(255, 255, 255));
        textTotalSalary.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textTotalSalary.setLabelText("TOTAL SALARY");
        textTotalSalary.setLineColor(new java.awt.Color(0, 0, 0));

        textAllowance.setEditable(false);
        textAllowance.setBackground(new java.awt.Color(255, 255, 255));
        textAllowance.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textAllowance.setLabelText("ALLOWANCE");
        textAllowance.setLineColor(new java.awt.Color(0, 0, 0));

        text_role.setEditable(false);
        text_role.setBackground(new java.awt.Color(255, 255, 255));
        text_role.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_role.setLabelText("EMPLOYEE ROLE");
        text_role.setLineColor(new java.awt.Color(0, 0, 0));

        combobox_OTP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        combobox_OTP.setLabeText("OVERTIME PAY");
        combobox_OTP.setLineColor(new java.awt.Color(0, 0, 0));
        combobox_OTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_OTPActionPerformed(evt);
            }
        });

        comboboxbonus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        comboboxbonus.setLabeText("BONUS LEVEL");
        comboboxbonus.setLineColor(new java.awt.Color(0, 0, 0));
        comboboxbonus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxbonusActionPerformed(evt);
            }
        });

        textTimeSalary.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textTimeSalary.setLabelText("TIME SALARY");
        textTimeSalary.setLineColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(text_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 346, Short.MAX_VALUE)
                                .addComponent(textBonus, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(text_basicsalary, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textTimeSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(text_role, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textAllowance, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(text_contract, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(text_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textTotalSalary, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textOVT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(combobox_OTP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textOVTMoney, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboboxbonus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textdepartment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(349, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(text_ID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textdepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(text_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textBonus, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(text_role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textOVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textAllowance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(combobox_OTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(text_contract, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textOVTMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(comboboxbonus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(text_basicsalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textTotalSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(textTimeSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jToolBar2.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar2.setRollover(true);

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/Add.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setIconTextGap(15);
        btnAdd.setMargin(new java.awt.Insets(2, 16, 2, 16));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        btnAdd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAddKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnAddKeyReleased(evt);
            }
        });
        jToolBar2.add(btnAdd);

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/Tick.png"))); // NOI18N
        btnUpdate.setText("Save");
        btnUpdate.setIconTextGap(15);
        btnUpdate.setMaximumSize(new java.awt.Dimension(129, 33));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jToolBar2.add(btnUpdate);

        btnEsc.setBackground(new java.awt.Color(255, 255, 255));
        btnEsc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/Stop.png"))); // NOI18N
        btnEsc.setText("Exit");
        btnEsc.setFocusable(false);
        btnEsc.setHideActionText(true);
        btnEsc.setIconTextGap(15);
        btnEsc.setMargin(new java.awt.Insets(2, 16, 2, 16));
        btnEsc.setMaximumSize(new java.awt.Dimension(129, 33));
        btnEsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscActionPerformed(evt);
            }
        });
        jToolBar2.add(btnEsc);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addContainerGap(1077, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboboxbonusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxbonusActionPerformed
        if (textOVT.getText().isBlank()){
            String bonuslevel = comboboxbonus.getSelectedItem()+""; //get bonus level       
        Bonus bon1 = Bonus_Modify.getBonusName(bonuslevel); //get bonus
        textBonus.setText(String.valueOf(bon1.getBonus_Money()));
        }
        else
        {
            String bonuslevel = comboboxbonus.getSelectedItem()+""; //get bonus level       
        Bonus bon1 = Bonus_Modify.getBonusName(bonuslevel); //get bonus
        textBonus.setText(String.valueOf(bon1.getBonus_Money()));
            int totalsalary;
            int allowance1 = Integer.parseInt((String) textAllowance.getText());
            int basicsalary2 = Integer.parseInt((String) text_basicsalary.getText());
            int bonus3 = Integer.parseInt((String) textBonus.getText());
            int overtime4 = Integer.parseInt((String) textOVTMoney.getText());
            totalsalary = allowance1+basicsalary2+bonus3+overtime4;
        
            textTotalSalary.setText(String.valueOf(totalsalary));
        }
    }//GEN-LAST:event_comboboxbonusActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        // TODO add your handling code here:
       int row = table1.getSelectedRow();
        int stfId = Integer.valueOf(String.valueOf(table1.getValueAt(row, 0))); // lấy đc id
        Staff stf = Staff_Modify.getStaffId(stfId);
        text_ID.setText(String.valueOf(stf.getId()));
        text_Name.setText(String.valueOf(stf.getHoten()));
        
        text_role.setText(String.valueOf(stf.getChucvuhientai()));
        String role1 = stf.getChucvuhientai();
        
        Role rol = Role_Modify.getRolebyName(role1);
        textAllowance.setText(String.valueOf(rol.getAllowance()));      
        
        textdepartment.setText(String.valueOf(stf.getPhongban()));
        Contracttype ctt = Contracttype_Modify.getContracttypebyEmployee(stfId);
        String contname = ctt.getContracttypeName();
        Contract contra = Contract_Modify.getContractbyName(contname);
        
        text_contract.setText(String.valueOf(contra.getContractName()));
        text_basicsalary.setText(String.valueOf(contra.getBasicSalary()));
        
        
    }//GEN-LAST:event_table1MouseClicked

    private void combobox_OTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_OTPActionPerformed
          if (textOVT.getText().isBlank()){
            textOVTMoney.setText("");
        }
        else
        {
        int a = Integer.valueOf(textOVT.getText());
        int b = Integer.valueOf(combobox_OTP.getSelectedItem()+"");
        textOVTMoney.setText((a*b)+"");
        int totalsalary;
            int allowance1 = Integer.parseInt((String) textAllowance.getText());
            int basicsalary2 = Integer.parseInt((String) text_basicsalary.getText());
            int bonus3 = Integer.parseInt((String) textBonus.getText());
            int overtime4 = Integer.parseInt((String) textOVTMoney.getText());
            totalsalary = allowance1+basicsalary2+bonus3+overtime4;
        
            textTotalSalary.setText(String.valueOf(totalsalary));
        }
    }//GEN-LAST:event_combobox_OTPActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
          btnAdd.setEnabled(false);
        
        btnUpdate.setEnabled(true);
        btnEsc.setEnabled(true);
        
        int employee_id = Integer.parseInt((String)text_ID.getText());
        String bonle = comboboxbonus.getSelectedItem()+"";
        int ovt = Integer.valueOf(textOVT.getText());
        int ovtpay = Integer.valueOf(combobox_OTP.getSelectedItem()+"");
        int totalovt = Integer.valueOf(textOVTMoney.getText());
        int totalsalary = Integer.valueOf(textTotalSalary.getText());
        SelectedDate d = dateSalary.getSelectedDate();
        String date = d.getYear()+"-"+d.getMonth()+"-"+d.getDay();
        
        
        SalaryMa slr = new SalaryMa(employee_id, bonle, ovt, ovtpay,totalovt,totalsalary,date);
        SalaryMa_Modify.insert(slr); 
        
        reset();
       

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnAddKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAddKeyPressed

    }//GEN-LAST:event_btnAddKeyPressed

    private void btnAddKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAddKeyReleased

    }//GEN-LAST:event_btnAddKeyReleased

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
           int employee_id = Integer.parseInt((String)text_ID.getText());
        String bonle = comboboxbonus.getSelectedItem()+"";
        int ovt = Integer.valueOf(textOVT.getText());
        int ovtpay = Integer.valueOf(combobox_OTP.getSelectedItem()+"");
        int totalovt = Integer.valueOf(textOVTMoney.getText());
        int totalsalary = Integer.valueOf(textTotalSalary.getText());
        SelectedDate d = dateSalary.getSelectedDate();
        String date = d.getYear()+"-"+d.getMonth()+"-"+d.getDay();
        int month = d.getMonth();
        int year = d.getYear();
        
        SalaryMa slr = new SalaryMa(employee_id, bonle, ovt, ovtpay,totalovt,totalsalary,date);
        SalaryMa_Modify.update(slr,month,year);
        
        reset();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnEscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscActionPerformed
       btnAdd.setEnabled(false);
       
        btnUpdate.setEnabled(false);
        btnEsc.setEnabled(true);
     
        text_ID.setText("");
        text_Name.setText("");
        text_role.setText("");
        textAllowance.setText("");
        text_contract.setText("");
        text_basicsalary.setText("");
        
        textdepartment.setText("");
        textBonus.setText("");
        textOVT.setText("");
        textOVTMoney.setText("");
        textTotalSalary.setText("");
     
    }//GEN-LAST:event_btnEscActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Login.TextFieldAnimation SearchTextField;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEsc;
    private javax.swing.JButton btnUpdate;
    private com.raven.swing.Combobox<String> combobox_OTP;
    private com.raven.swing.Combobox<String> comboboxbonus;
    private com.raven.datechooser.DateChooser dateSalary;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar2;
    private com.raven.swing.table.Table table1;
    private com.raven.swing.TextField textAllowance;
    private com.raven.swing.TextField textBonus;
    private com.raven.swing.TextField textOVT;
    private com.raven.swing.TextField textOVTMoney;
    private com.raven.swing.TextField textTimeSalary;
    private com.raven.swing.TextField textTotalSalary;
    private com.raven.swing.TextField text_ID;
    private com.raven.swing.TextField text_Name;
    private com.raven.swing.TextField text_basicsalary;
    private com.raven.swing.TextField text_contract;
    private com.raven.swing.TextField text_role;
    private com.raven.swing.TextField textdepartment;
    // End of variables declaration//GEN-END:variables
}
