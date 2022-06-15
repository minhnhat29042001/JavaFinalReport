package com.raven.form;

import Login.EventCallBack;
import Login.EventTextField;
import Model.Contract;
import Model.Contract_Modify;
import Model.Contracttype;
import Model.Contracttype_Modify;
import Model.Department;
import Model.Department_Modify;
import Model.IDGenerate_Modify;
import Model.Role;
import Model.RoleManagement;
import Model.RoleManagement_Modify;
import Model.Role_Modify;
import Model.Skill;
import Model.SkillManagement;
import Model.SkillManagement_Modify;
import Model.Skill_Modify;
import Model.Staff;
import Model.Staff_Modify;
import com.raven.datechooser.SelectedDate;
import com.raven.dialog.Message;
import static com.raven.form.AcademicLevel_Edit.PreAcademiclevel;
import static com.raven.form.AcademicLevel_Edit.checkAcademiclevel;
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
import javax.swing.table.DefaultTableModel;


public class Contracttype_Edit extends javax.swing.JPanel {
DefaultTableModel tableModel;
static String PreContracttypelevel="";
static boolean checkContracttype=false;
static boolean checkContracttypeInsert=false;
static boolean insertbutton=false;
static boolean updatebutton=false;
List<Contracttype> contracttypeList = new ArrayList<>();

Calendar cal=new GregorianCalendar();


    public Contracttype_Edit() {
        initComponents();
        tableModel = (DefaultTableModel) table1.getModel();
        setOpaque(false);
        showContract();
        showContractCombobox();
        Search();
        Text_ContractTypeID.setEnabled(false);
        combobox_ContractName.setEnabled(false);
        Text_StartDate.setEnabled(false);
        Text_StaffId.setEnabled(false);
        Text_EndDate.setEnabled(false);
        Text_QUITJOB.setEnabled(false);
        combobox_ContractName.setSelectedIndex(-1);
        btnSave.setEnabled(false);
        btnEsc.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        Text_QUITJOB.setText("");
   
    }

   

    public void showContract(){
        List<Contracttype> contractManagementList = Contracttype_Modify.findAll();
        tableModel.setRowCount(0);
        contractManagementList.forEach((contract) -> {
            tableModel.addRow(new Object[] {contract.getContracttypeid(),contract.getContracttypeName(),contract.getContractStartDate(),contract.getContractEndDate(),contract.getStaffID(),contract.getQuitJobDate()} );
        });

    }
    
     public void showContractCombobox(){
        List<Contract> contractManagementList = Contract_Modify.findAll();
       
        for(Contract contract :contractManagementList){
            combobox_ContractName.addItem(contract);
         }
    }


   private void Search(){
        SearchTextField.addEvent(new EventTextField() {
            @Override
            public void onPressed(EventCallBack call) {
               String input = SearchTextField.getText();
        if (input != null && input.length() > 0){
            contracttypeList = Contracttype_Modify.findByName(input);
            tableModel.setRowCount(0);
        
        contracttypeList.forEach((contract) -> {
            int id = contract.getStaffID();
            List<Staff> staffList = Staff_Modify.findById(id);
            staffList.forEach((stf) -> {
            String name = stf.getHoten();
            tableModel.addRow(new Object[] {contract.getContracttypeid(),name,contract.getContracttypeName(),contract.getContractStartDate(),contract.getContractEndDate(),contract.getQuitJobDate()} );
        });
            
            
        });
        }  
        else showContract();
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
                showContract();
            }
        });
    }

    
      public boolean checkExistContractType(String contractname, int StaffId){
            List<Contracttype> contractManagementList = Contracttype_Modify.findAll();
       
       
       for(Contracttype contracttype:contractManagementList){
            if(contractname.equalsIgnoreCase( contracttype.getContracttypeName()) && StaffId== contracttype.getStaffID() ){
                 if(!contractname.equalsIgnoreCase(PreContracttypelevel)){
                     return true;
                 }
                 
             }
       }
        return false;
    }
    
     public boolean checkExistInsertContract(String contractname, int StaffId){
        List<Contracttype> contractManagementList = Contracttype_Modify.findAll();
        for(Contracttype contracttype:contractManagementList){
            if(contractname.equalsIgnoreCase(contracttype.getContracttypeName()) && StaffId==contracttype.getStaffID() ){
           
                     return true;
                 
                 
             }
       }
        return false;
    }
        
    

     public void ContracttypeIndex(Contracttype contr){
              
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
       
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from contract";
            int ContracttypeId=0 ;
            String Contract_NAME=contr.getContracttypeName();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
          
            while (resultSet.next()) {
                 if(resultSet.getString("ContractNAME").equalsIgnoreCase(Contract_NAME)){
                       combobox_ContractName.setSelectedIndex(ContracttypeId);
                      break;
                } else{
                    ContracttypeId++;
                }          
            }
        } catch (SQLException ex) {
            Logger.getLogger(Contracttype_Edit.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CONTRACTDATE = new com.raven.datechooser.DateChooser();
        CONTRACTDATE1 = new com.raven.datechooser.DateChooser();
        CONTRACTDATE2 = new com.raven.datechooser.DateChooser();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        Text_EndDate = new com.raven.swing.TextField();
        Text_StartDate = new com.raven.swing.TextField();
        Text_ContractTypeID = new com.raven.swing.TextField();
        Text_StaffId = new com.raven.swing.TextField();
        combobox_ContractName = new com.raven.swing.Combobox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.raven.swing.table.Table();
        Text_QUITJOB = new com.raven.swing.TextField();
        SearchTextField = new Login.TextFieldAnimation();
        jToolBar2 = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnEsc = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        CONTRACTDATE.setForeground(new java.awt.Color(0, 153, 247));
        CONTRACTDATE.setDateFormat("yyyy-MM-dd");
        CONTRACTDATE.setTextRefernce(Text_StartDate);

        CONTRACTDATE1.setForeground(new java.awt.Color(0, 153, 247));
        CONTRACTDATE1.setDateFormat("yyyy-MM-dd");
        CONTRACTDATE1.setTextRefernce(Text_EndDate);

        CONTRACTDATE2.setForeground(new java.awt.Color(0, 153, 247));
        CONTRACTDATE2.setDateFormat("yyyy-MM-dd");
        CONTRACTDATE2.setTextRefernce(Text_QUITJOB);

        setPreferredSize(new java.awt.Dimension(1726, 820));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("CONTRACT TYPE MANGEMENT");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(76, 76, 76));
        jLabel5.setText("Data Contract Type");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        Text_EndDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_EndDate.setLabelText("END DATE");
        Text_EndDate.setLineColor(new java.awt.Color(0, 0, 0));

        Text_StartDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_StartDate.setLabelText("START DATE");
        Text_StartDate.setLineColor(new java.awt.Color(0, 0, 0));

        Text_ContractTypeID.setEditable(false);
        Text_ContractTypeID.setBackground(new java.awt.Color(255, 255, 255));
        Text_ContractTypeID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_ContractTypeID.setLabelText("CONTRACT TYPE ID");
        Text_ContractTypeID.setLineColor(new java.awt.Color(0, 0, 0));

        Text_StaffId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_StaffId.setLabelText("STAFF ID");
        Text_StaffId.setLineColor(new java.awt.Color(0, 0, 0));

        combobox_ContractName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        combobox_ContractName.setLabeText("CONTRACT NAME");
        combobox_ContractName.setLineColor(new java.awt.Color(0, 0, 0));
        combobox_ContractName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_ContractNameActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(null);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                " ID", "CONTRACT ", "START DATE", "ENDDATE", "STAFFID", "QUIT JOB "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        table1.getTableHeader().setReorderingAllowed(false);
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(0).setResizable(false);
            table1.getColumnModel().getColumn(1).setResizable(false);
            table1.getColumnModel().getColumn(2).setResizable(false);
            table1.getColumnModel().getColumn(3).setResizable(false);
            table1.getColumnModel().getColumn(4).setResizable(false);
            table1.getColumnModel().getColumn(5).setResizable(false);
        }

        Text_QUITJOB.setText("");
        Text_QUITJOB.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_QUITJOB.setLabelText("QUIT JOB DATE");
        Text_QUITJOB.setLineColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Text_StartDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Text_EndDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Text_ContractTypeID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Text_StaffId, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combobox_ContractName, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Text_QUITJOB, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Text_ContractTypeID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combobox_ContractName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Text_StartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Text_StaffId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Text_EndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Text_QUITJOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE))
        );

        jToolBar2.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar2.setForeground(new java.awt.Color(255, 255, 255));
        jToolBar2.setRollover(true);

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/Add.png"))); // NOI18N
        btnAdd.setText("ADD");
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
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/Edit.png"))); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.setIconTextGap(15);
        btnUpdate.setMargin(new java.awt.Insets(2, 16, 2, 16));
        btnUpdate.setMaximumSize(new java.awt.Dimension(129, 33));
        btnUpdate.setMinimumSize(new java.awt.Dimension(119, 33));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jToolBar2.add(btnUpdate);

        btnSave.setBackground(new java.awt.Color(255, 255, 255));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/Tick.png"))); // NOI18N
        btnSave.setText("SAVE");
        btnSave.setIconTextGap(15);
        btnSave.setMaximumSize(new java.awt.Dimension(129, 33));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jToolBar2.add(btnSave);

        btnEsc.setBackground(new java.awt.Color(255, 255, 255));
        btnEsc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/Stop.png"))); // NOI18N
        btnEsc.setText("EXIT");
        btnEsc.setToolTipText("");
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

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/Exit.png"))); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.setIconTextGap(15);
        btnDelete.setMargin(new java.awt.Insets(2, 16, 2, 16));
        btnDelete.setMaximumSize(new java.awt.Dimension(129, 33));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jToolBar2.add(btnDelete);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(839, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void combobox_ContractNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_ContractNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combobox_ContractNameActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        btnAdd.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnSave.setEnabled(true);
        btnEsc.setEnabled(true);
        btnDelete.setEnabled(false);
        Text_ContractTypeID.setEnabled(true);
        combobox_ContractName.setEnabled(true);
        Text_StartDate.setEnabled(true);
        Text_StaffId.setEnabled(true);
        Text_EndDate.setEnabled(true);
        Text_QUITJOB.setEnabled(true);

        insertbutton=true;

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnAddKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAddKeyPressed

    }//GEN-LAST:event_btnAddKeyPressed

    private void btnAddKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAddKeyReleased

    }//GEN-LAST:event_btnAddKeyReleased

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        btnAdd.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnSave.setEnabled(true);
        btnEsc.setEnabled(true);
        btnDelete.setEnabled(false);
        Text_ContractTypeID.setEnabled(true);
        combobox_ContractName.setEnabled(true);
        Text_StartDate.setEnabled(true);
        Text_StaffId.setEnabled(true);
        Text_EndDate.setEnabled(true);
        Text_QUITJOB.setEnabled(true);
        updatebutton=true;
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if(updatebutton==true){
        int id = Integer.valueOf(Text_ContractTypeID.getText());
        String contrname = combobox_ContractName.getSelectedItem().toString();
        String startday = Text_StartDate.getText();
        String endday = Text_EndDate.getText();
        int staffid = Integer.valueOf(Text_StaffId.getText()); 
        String quit = Text_QUITJOB.getText();
        Contracttype contrt = new Contracttype(id, contrname, startday, endday, staffid, quit);
       
        if(checkExistContractType(contrname,staffid)){
               JOptionPane.showMessageDialog(null,"CONTRACT TYPE ALREADY EXISTS"+":"+ contrname,"",2);
        }else{
             Contracttype_Modify.update(contrt);
             showContract();
        }
        btnAdd.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnSave.setEnabled(false);
        btnEsc.setEnabled(false);
        btnDelete.setEnabled(false);
        Text_ContractTypeID.setEnabled(false);
        combobox_ContractName.setEnabled(false);
        Text_StartDate.setEnabled(false);
        Text_StaffId.setEnabled(false);
        Text_EndDate.setEnabled(false);
        Text_QUITJOB.setEnabled(false);
        combobox_ContractName.setSelectedIndex(-1);
        Text_ContractTypeID.setText("");
        Text_StartDate.setText("");
        Text_EndDate.setText("");
        Text_StaffId.setText("");
        Text_QUITJOB.setText(""); 
        table1.clearSelection();
        PreContracttypelevel="";
        
        } else if(insertbutton==true){
        String contrname = combobox_ContractName.getSelectedItem().toString();
        String startday = Text_StartDate.getText();
        String endday = Text_EndDate.getText();
        int staffid = Integer.parseInt(Text_StaffId.getText());
        String quit = Text_QUITJOB.getText();

        Contracttype contrt = new Contracttype(contrname, startday, endday, staffid, quit);
         if(checkExistInsertContract(contrname,staffid)){
               JOptionPane.showMessageDialog(null,"CONTRACT TYPE ALREADY EXISTS"+":"+ contrname,"",2);
        }else{
              Contracttype_Modify.insert(contrt);
              showContract();
        }
       
        
        btnAdd.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnSave.setEnabled(false);
        btnEsc.setEnabled(false);
        btnDelete.setEnabled(false);
        Text_ContractTypeID.setEnabled(false);
        combobox_ContractName.setEnabled(false);
        Text_StartDate.setEnabled(false);
        Text_StaffId.setEnabled(false);
        Text_EndDate.setEnabled(false);
        Text_QUITJOB.setEnabled(false);
        combobox_ContractName.setSelectedIndex(-1);
        Text_ContractTypeID.setText("");
        Text_StartDate.setText("");
        Text_EndDate.setText("");
        Text_StaffId.setText("");
        Text_QUITJOB.setText(""); 
        table1.clearSelection();
        }
        
        
        
       
        insertbutton=false;
        updatebutton=false;
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscActionPerformed
        btnAdd.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnSave.setEnabled(false);
        btnEsc.setEnabled(false);
        btnDelete.setEnabled(false);
        Text_ContractTypeID.setEnabled(false);
        combobox_ContractName.setEnabled(false);
        Text_StartDate.setEnabled(false);
        Text_StaffId.setEnabled(false);
        Text_EndDate.setEnabled(false);
        Text_QUITJOB.setEnabled(false);
        combobox_ContractName.setSelectedIndex(-1);
        Text_ContractTypeID.setText("");
        Text_StartDate.setText("");
        Text_EndDate.setText("");
        Text_StaffId.setText("");
        Text_QUITJOB.setText(""); 
        table1.clearSelection();
    
       
    }//GEN-LAST:event_btnEscActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       
        int respone=JOptionPane.showConfirmDialog(this,"Do you want to continue delete employee contracttype ?", "CONFIRM",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(respone==JOptionPane.YES_OPTION){
            
        int row = table1.getSelectedRow();
        int contrId = Integer.valueOf(Text_ContractTypeID.getText());
        Contracttype_Modify.delete(contrId);
           
        }
        
                                      
        btnAdd.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnSave.setEnabled(false);
        btnEsc.setEnabled(false);
        btnDelete.setEnabled(false);
        Text_ContractTypeID.setEnabled(false);
        combobox_ContractName.setEnabled(false);
        Text_StartDate.setEnabled(false);
        Text_StaffId.setEnabled(false);
        Text_EndDate.setEnabled(false);
        Text_QUITJOB.setEnabled(false);
        combobox_ContractName.setSelectedIndex(-1);
        Text_ContractTypeID.setText("");
        Text_StartDate.setText("");
        Text_EndDate.setText("");
        Text_StaffId.setText("");
        Text_QUITJOB.setText(""); 
        table1.clearSelection();
         showContract();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
        int row = table1.getSelectedRow();
        int contrId = Integer.valueOf(String.valueOf(table1.getValueAt(row, 0))); // lấy đc id
        Contracttype contr = Contracttype_Modify.getContracttypebyID(contrId);
        
        ContracttypeIndex(contr);
        
        Text_ContractTypeID.setText(String.valueOf(contr.getContracttypeid()));
        Text_QUITJOB.setText(contr.getQuitJobDate());
        Text_StartDate.setText(String.valueOf(contr.getContractStartDate()));
        Text_EndDate.setText(String.valueOf(contr.getContractEndDate()));
        Text_StaffId.setText(String.valueOf(contr.getStaffID()));
        PreContracttypelevel=String.valueOf(combobox_ContractName.getSelectedItem());
    }//GEN-LAST:event_table1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.datechooser.DateChooser CONTRACTDATE;
    private com.raven.datechooser.DateChooser CONTRACTDATE1;
    private com.raven.datechooser.DateChooser CONTRACTDATE2;
    private Login.TextFieldAnimation SearchTextField;
    private com.raven.swing.TextField Text_ContractTypeID;
    private com.raven.swing.TextField Text_EndDate;
    private com.raven.swing.TextField Text_QUITJOB;
    private com.raven.swing.TextField Text_StaffId;
    private com.raven.swing.TextField Text_StartDate;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEsc;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private com.raven.swing.Combobox<Contract> combobox_ContractName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar2;
    private com.raven.swing.table.Table table1;
    // End of variables declaration//GEN-END:variables
}
