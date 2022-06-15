package com.raven.form;

import Login.EventCallBack;
import Login.EventTextField;
import Model.ItemType;
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
import com.raven.main.Main;
import com.raven.model.ModelCard;
import com.raven.model.ModelStudent;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import com.raven.swing.noticeboard.ModelNoticeBoard;
import com.raven.swing.table.EventAction;
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


public class Role_Edit extends javax.swing.JPanel {
DefaultTableModel tableModel;
 Calendar cal=new GregorianCalendar();
 static boolean checkRole=false; 
 static boolean checkRoleInsert=false; 
 static boolean insertbutton=false; 
 static boolean updatebutton=false; 
 //static boolean checkEditpress=false;
 //static boolean checkInsertpress=false;
 static String Prerole="";
 List<Role> roleList = new ArrayList<>();
         
    public Role_Edit() {
        initComponents();
        tableModel = (DefaultTableModel) table1.getModel();
        setOpaque(false);
        showRole();
        //showRoleComebobox();
        Search();
        Text_ROLENAME.setEnabled(false);
        Text_ALLOWANCE.setEnabled(false);
        Text_ALLOWANCETIME.setEnabled(false);
        btnEdit.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnEsc.setEnabled(false);
        btnDelete.setEnabled(false);

   
    }

   

    public void showRole(){
        List<Role> RoleList = Role_Modify.findAll();
        tableModel.setRowCount(0);
        RoleList.forEach((role) -> {
            tableModel.addRow(new Object[] {role.getRolename(),role.getAllowance(),role.getAllowanceTime() } );
        });
     
    }
 
      public void checkExistRole(String rolename){
          
        List<Role> RoleList = Role_Modify.findAll();
        RoleList.forEach((role) -> {
             if(rolename.equals(role.getRolename()) && !rolename.equals(Prerole)){
                 checkRole=true;
             }
        });
        
    }
      
       public void checkExistRoleInsert(String rolename){
          
        List<Role> RoleList = Role_Modify.findAll();
        RoleList.forEach((role) -> {
             if(rolename.equals(role.getRolename()) ){
                 checkRoleInsert=true;
             }
        });
        
    }

     private void Search(){
        SearchTextField.addEvent(new EventTextField() {
            @Override
            public void onPressed(EventCallBack call) {
               String input = SearchTextField.getText();
        if (input != null && input.length() > 0){
            roleList = Role_Modify.findByName(input);
            tableModel.setRowCount(0);
        
        roleList.forEach((role) -> {
            tableModel.addRow(new Object[] {role.getRolename(), role.getAllowance(), role.getAllowanceTime() } );
        });
        }  
        else showRole();

            }

            @Override
            public void onCancel() {
                showRole();
            }
        });
    }

    
     
     
     public boolean checkEmployeeRole(String rolename){
        List<Staff> staffList = Staff_Modify.findAll();
          for(Staff staff : staffList){
               if(staff.getChucvuhientai().equalsIgnoreCase(rolename)){
                   return true;
               }
        }
          return false;
    }
     
     public boolean checkRolemManagement(String rolename){
        List<RoleManagement> rolemanagementList = RoleManagement_Modify.findAll();
          for(RoleManagement rlm :  rolemanagementList){
               if(rlm.getRole().equalsIgnoreCase(rolename)){
                   return true;
               }
        }
          return false;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ALLOWANCETIME_PICKER = new com.raven.datechooser.DateChooser();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.raven.swing.table.Table();
        Text_ALLOWANCE = new com.raven.swing.TextField();
        Text_ALLOWANCETIME = new com.raven.swing.TextField();
        Text_ROLENAME = new com.raven.swing.TextField();
        SearchTextField = new Login.TextFieldAnimation();
        jToolBar2 = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnEsc = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        ALLOWANCETIME_PICKER.setForeground(new java.awt.Color(0, 153, 247));
        ALLOWANCETIME_PICKER.setDateFormat("yyyy-MM-dd");
        ALLOWANCETIME_PICKER.setTextRefernce(Text_ALLOWANCETIME);

        setPreferredSize(new java.awt.Dimension(1726, 820));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("ROLE MANGEMENT");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(76, 76, 76));
        jLabel5.setText("Data Role");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jScrollPane1.setBorder(null);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "ROLENAME", "ALLOWANCE", "ALLOWANCETIME"
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

        Text_ALLOWANCE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_ALLOWANCE.setLabelText("ALLOWANCE");
        Text_ALLOWANCE.setLineColor(new java.awt.Color(0, 0, 0));

        Text_ALLOWANCETIME.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_ALLOWANCETIME.setLabelText("ALLOWANCE TIME");
        Text_ALLOWANCETIME.setLineColor(new java.awt.Color(0, 0, 0));

        Text_ROLENAME.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_ROLENAME.setLabelText("ROLENAME ");
        Text_ROLENAME.setLineColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Text_ALLOWANCE, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Text_ALLOWANCETIME, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Text_ROLENAME, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Text_ROLENAME, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(Text_ALLOWANCE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(Text_ALLOWANCETIME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(863, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        btnAdd.setEnabled(false);
        btnEdit.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnEsc.setEnabled(true);
        btnDelete.setEnabled(false);
        Text_ROLENAME.setEnabled(true);
        Text_ALLOWANCE.setEnabled(true);
        Text_ALLOWANCETIME.setEnabled(true);
        insertbutton=true;
       

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        btnAdd.setEnabled(false);
        btnEdit.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnEsc.setEnabled(true);
        btnDelete.setEnabled(false);
        Text_ROLENAME.setEnabled(true);
        Text_ALLOWANCE.setEnabled(true);
        Text_ALLOWANCETIME.setEnabled(true);
        updatebutton=true;
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if(insertbutton==true){
             String nameinsert = Text_ROLENAME.getText();
        int allowance = Integer.parseInt(Text_ALLOWANCE.getText()); 
        String day = Text_ALLOWANCETIME.getText();
        Role rol = new Role(nameinsert, allowance, day);
        
         checkExistRoleInsert(nameinsert);
             if(checkRoleInsert==true){
                  JOptionPane.showMessageDialog(null,"ROLE ALREADY EXIST"+":"+nameinsert,"",2);
             } else{
                    Role_Modify.insert(nameinsert, allowance, day);     
                    showRole();
                  Text_ALLOWANCE.setText("");
                  Text_ALLOWANCETIME.setText("");
                  Text_ROLENAME.setText("");
             }
      
        checkRoleInsert=false;      
        } else if(updatebutton==true){
             String updaterole=Text_ROLENAME.getText();
        int allowance=Integer.valueOf(Text_ALLOWANCE.getText());
        String allowancetime= Text_ALLOWANCETIME.getText();
        Role role=new Role(updaterole,allowance,allowancetime);
             checkExistRole(role.getRolename());
        if(checkRole==true){
             JOptionPane.showMessageDialog(null,"ROLE ALREADY EXIST"+":"+role.getRolename(),"",2);
             checkRole=false;
        } else  {
              Role role1=new Role(updaterole,allowance,allowancetime);
              Role_Modify.update(role1,Prerole);
              showRole();
              checkRole=false;
             
        }
       
       
        
        Text_ROLENAME.setText("");
        Text_ALLOWANCE.setText("");
        Text_ALLOWANCETIME.setText("");
        checkRole=false;
        Prerole="";
        }
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnEsc.setEnabled(false);
        btnDelete.setEnabled(true);
        Text_ROLENAME.setText("");
        Text_ALLOWANCE.setText("");
        Text_ALLOWANCETIME.setText("");
        table1.clearSelection();
        updatebutton=false;
        insertbutton=false;
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnEscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscActionPerformed
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnEsc.setEnabled(false);
        btnDelete.setEnabled(true);
        Text_ROLENAME.setEnabled(false);
        Text_ALLOWANCE.setEnabled(false);
        Text_ALLOWANCETIME.setEnabled(false);
        Text_ROLENAME.setText("");
        Text_ALLOWANCE.setText("");
        Text_ALLOWANCETIME.setText("");
        table1.clearSelection();
        updatebutton=false;
        insertbutton=false;
    }//GEN-LAST:event_btnEscActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        
        int row = table1.getSelectedRow();
        String rolename= String.valueOf(table1.getValueAt(row, 0));

        int respone=JOptionPane.showConfirmDialog(this,"Do you want to continue delete role ?", "CONFIRM",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(respone==JOptionPane.YES_OPTION){
            if(checkEmployeeRole(rolename)){
                JOptionPane.showMessageDialog(null,"YOU MUST UPDATE CURRENT EMPLOYEE ROLE:"+""+rolename,"",2);
            } else if(checkRolemManagement(rolename)){
                JOptionPane.showMessageDialog(null,"YOU MUST DELETE EMPLOYEE ROLEMANGEMENT:"+":"+rolename,"",2);
            } else{
                Role_Modify.delete(rolename);
            }
        } else if(respone==JOptionPane.NO_OPTION){

        }
        showRole();
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnEsc.setEnabled(false);
        btnDelete.setEnabled(false);
        Text_ROLENAME.setEnabled(false);
        Text_ALLOWANCE.setEnabled(false);
        Text_ALLOWANCETIME.setEnabled(false);
        Text_ROLENAME.setText("");
        Text_ALLOWANCE.setText("");
        Text_ALLOWANCETIME.setText("");
        table1.clearSelection();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        btnEdit.setEnabled(true);
        btnDelete.setEnabled(true);
        int row = table1.getSelectedRow();
        String RoleName = (String.valueOf(table1.getValueAt(row, 0))); // lấy đc rolename
        Role role=Role_Modify.getRolebyName(RoleName);
        Text_ROLENAME.setText(role.getRolename());
        Text_ALLOWANCE.setText(String.valueOf(role.getAllowance()));
        Text_ALLOWANCETIME.setText(role.getAllowanceTime());
        Prerole=role.getRolename();
 
    }//GEN-LAST:event_table1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.datechooser.DateChooser ALLOWANCETIME_PICKER;
    private Login.TextFieldAnimation SearchTextField;
    private com.raven.swing.TextField Text_ALLOWANCE;
    private com.raven.swing.TextField Text_ALLOWANCETIME;
    private com.raven.swing.TextField Text_ROLENAME;
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
