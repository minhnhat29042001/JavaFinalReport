package com.raven.form;

import Login.EventCallBack;
import Login.EventTextField;
import Model.Contract;
import Model.Contract_Modify;
import Model.Contracttype;
import Model.Contracttype_Modify;
import Model.Department;
import Model.Department_Modify;
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
import javax.swing.table.DefaultTableModel;


public class Contract_Edit extends javax.swing.JPanel {
DefaultTableModel tableModel;
 Calendar cal=new GregorianCalendar();
 static String PreContract="";
//static boolean checkEditpress=false;
//static boolean checkInsertpress=false;
static boolean checkContract=false; 
static boolean checkContractInsert=false;
 static boolean insertbutton=false; 
 static boolean updatebutton=false; 
List<Contract> contractList = new ArrayList<>();

    public Contract_Edit() {
        initComponents();
        tableModel = (DefaultTableModel) table1.getModel();
        setOpaque(false);
        showContract();
        Search();
        Text_ContractName.setEnabled(false);
        Text_ContractTime.setEnabled(false);
        Text_BasicSalary.setEnabled(false);
        btnEdit.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnEsc.setEnabled(false);
        btnDelete.setEnabled(false);
    }

   

    public void showContract(){
        List<Contract> contractManagementList = Contract_Modify.findAll();
        tableModel.setRowCount(0);
        contractManagementList.forEach((contract) -> {
            tableModel.addRow(new Object[] {contract.getContractName(),contract.getBasicSalary(),contract.getContractTime()} );
        });
   
    }


   private void Search(){
        SearchTextField.addEvent(new EventTextField() {
            @Override
            public void onPressed(EventCallBack call) {
               String input = SearchTextField.getText();
        if (input != null && input.length() > 0){
            contractList = Contract_Modify.findByName(input);
            tableModel.setRowCount(0);
        
        contractList.forEach((ctt) -> {
            tableModel.addRow(new Object[] {ctt.getContractName(), ctt.getBasicSalary(), ctt.getContractTime()} );
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

    
      public void checkExistContract(String contractname){
          
       List<Contract> contractManagementList = Contract_Modify.findAll();
        contractManagementList.forEach((contract) -> {
             if(contractname.equalsIgnoreCase(contract.getContractName()) && !contractname.equalsIgnoreCase(PreContract)){
                 checkContract=true;
             }
        });
        
    }
    
     public void checkExistInsertContract(String contractname){
          
       List<Contract> contractManagementList = Contract_Modify.findAll();
        contractManagementList.forEach((contract) -> {
             if(contractname.equalsIgnoreCase(contract.getContractName()) ){
                 checkContractInsert=true;
             }
        });
        
    }
     
     
         public boolean checkContracttype(String contractname){
        List<Contracttype> contracttypeList = Contracttype_Modify.findAll();
          for(Contracttype contracttype : contracttypeList ){
               if(contracttype.getContracttypeName().equalsIgnoreCase(contractname)){
                   return true;
               }
        }
          return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CONTRACTDATE = new com.raven.datechooser.DateChooser();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.raven.swing.table.Table();
        Text_BasicSalary = new com.raven.swing.TextField();
        Text_ContractName = new com.raven.swing.TextField();
        Text_ContractTime = new com.raven.swing.TextField();
        SearchTextField = new Login.TextFieldAnimation();
        jToolBar2 = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnEsc = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        CONTRACTDATE.setForeground(new java.awt.Color(0, 153, 247));
        CONTRACTDATE.setDateFormat("yyyy-MM-dd");
        CONTRACTDATE.setTextRefernce(Text_ContractTime);

        setPreferredSize(new java.awt.Dimension(1726, 820));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("CONTRACT MANGEMENT");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(76, 76, 76));
        jLabel5.setText("Data Contract");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jScrollPane1.setBorder(null);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "CONTRACT NAME", "BASIC SALARY", "CONTRACT TIME"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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

        Text_BasicSalary.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_BasicSalary.setLabelText("BASIC SALARY");
        Text_BasicSalary.setLineColor(new java.awt.Color(0, 0, 0));

        Text_ContractName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_ContractName.setLabelText("CONTRACT NAME");
        Text_ContractName.setLineColor(new java.awt.Color(0, 0, 0));

        Text_ContractTime.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_ContractTime.setLabelText("CONTRACT TIME");
        Text_ContractTime.setLineColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Text_ContractTime, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Text_ContractName, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Text_BasicSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Text_ContractName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(Text_ContractTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(Text_BasicSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jScrollPane1)))
        );

        jToolBar2.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar2.setRollover(true);

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

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/Edit.png"))); // NOI18N
        btnEdit.setText("Update");
        btnEdit.setIconTextGap(15);
        btnEdit.setMargin(new java.awt.Insets(2, 16, 2, 16));
        btnEdit.setMaximumSize(new java.awt.Dimension(129, 33));
        btnEdit.setMinimumSize(new java.awt.Dimension(119, 33));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jToolBar2.add(btnEdit);

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

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/Exit.png"))); // NOI18N
        btnDelete.setText("Delete");
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
                .addContainerGap(863, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(536, 580, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        btnEdit.setEnabled(true);
        btnDelete.setEnabled(true);
        int row = table1.getSelectedRow();
        String contractName = (String.valueOf(table1.getValueAt(row, 0))); // lấy đc id
        Contract contract=Contract_Modify.getContractbyName(contractName);
        Text_ContractName.setText(String.valueOf(contract.getContractName()));
        Text_BasicSalary.setText(String.valueOf(contract.getBasicSalary()));
        Text_ContractTime.setText(String.valueOf(contract.getContractTime()));
        PreContract = contract.getContractName();
    }//GEN-LAST:event_table1MouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        btnAdd.setEnabled(false);
        btnEdit.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnEsc.setEnabled(true);
        btnDelete.setEnabled(false);
        Text_ContractName.setEnabled(true);
        Text_ContractTime.setEnabled(true);
        Text_BasicSalary.setEnabled(true);
        insertbutton=true;
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnAddKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAddKeyPressed

    }//GEN-LAST:event_btnAddKeyPressed

    private void btnAddKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAddKeyReleased

    }//GEN-LAST:event_btnAddKeyReleased

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        btnAdd.setEnabled(false);
        btnEdit.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnEsc.setEnabled(true);
        btnDelete.setEnabled(false);
        Text_ContractName.setEnabled(true);
        Text_ContractTime.setEnabled(true);
        Text_BasicSalary.setEnabled(true);
        updatebutton=true;
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if(insertbutton==true){
           String contrname = Text_ContractName.getText();
        int basicsalary = Integer.parseInt(Text_BasicSalary.getText());
        String day = Text_ContractTime.getText();

        Contract contr = new Contract(contrname, basicsalary, day);
        checkExistInsertContract(contrname);
         if(checkContractInsert==true){
            JOptionPane.showMessageDialog(null,"CONTRACT NAME ALREADY EXISTS"+":"+contrname,"",2);
        }else{
            Contract_Modify.insert(contr);
            showContract();
        }

        showContract();
        Text_ContractName.setText("");
        Text_BasicSalary.setText("");
        Text_ContractTime.setText("");
        checkContractInsert=false;
        } else if(updatebutton==true){
          String contractname = Text_ContractName.getText();
        int basicmoney = Integer.valueOf(Text_BasicSalary.getText());
        String dayy = Text_ContractTime.getText();
        
        Contract contr = new Contract(contractname, basicmoney, dayy);
        checkExistContract( contractname);
        if(checkContract==true){
            JOptionPane.showMessageDialog(null,"CONTRACT NAME ALREADY EXISTS"+":"+contractname,"",2);
        }else{
            Contract_Modify.update(contr, PreContract);
            showContract();
        }
        
        
        
        Text_ContractName.setText("");
        Text_BasicSalary.setText("");
        Text_ContractTime.setText(""); 

        checkContract=false;
         PreContract ="";
        }
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnEsc.setEnabled(false);
        btnDelete.setEnabled(false);
        updatebutton=false;
        insertbutton=false;
        

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnEscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscActionPerformed
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnEsc.setEnabled(false);
        btnDelete.setEnabled(false);
        updatebutton=false;
        insertbutton=false;
        Text_ContractName.setEnabled(false);
        Text_ContractTime.setEnabled(false);
        Text_BasicSalary.setEnabled(false);
        Text_ContractName.setText("");
        Text_ContractTime.setText("");
        Text_BasicSalary.setText("");

    }//GEN-LAST:event_btnEscActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        int row = table1.getSelectedRow();
        String contractname= String.valueOf(table1.getValueAt(row, 0));
      
        int respone=JOptionPane.showConfirmDialog(this,"Do you want to continue delete item ?", "CONFIRM",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(respone==JOptionPane.YES_OPTION){
            if( checkContracttype(contractname)){
                JOptionPane.showMessageDialog(null,"YOU MUST UPDATE CURRENT EMPLOYEE CONTRACT TYPE:"+""+contractname,"",2);
            } else{
                Contract_Modify.delete(contractname);
            }
        } else if(respone==JOptionPane.NO_OPTION){

        }
        showContract();
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnEsc.setEnabled(false);
        btnDelete.setEnabled(false);
        Text_ContractName.setEnabled(false);
        Text_ContractTime.setEnabled(false);
        Text_BasicSalary.setEnabled(false);
        Text_ContractName.setText("");
        Text_ContractTime.setText("");
        Text_BasicSalary.setText("");
        table1.clearSelection();
    }//GEN-LAST:event_btnDeleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.datechooser.DateChooser CONTRACTDATE;
    private Login.TextFieldAnimation SearchTextField;
    private com.raven.swing.TextField Text_BasicSalary;
    private com.raven.swing.TextField Text_ContractName;
    private com.raven.swing.TextField Text_ContractTime;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnEsc;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar2;
    private com.raven.swing.table.Table table1;
    // End of variables declaration//GEN-END:variables
}
