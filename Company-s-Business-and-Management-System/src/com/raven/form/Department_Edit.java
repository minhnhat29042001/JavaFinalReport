package com.raven.form;

import Login.EventCallBack;
import Login.EventTextField;
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
import static com.raven.form.Skill_Edit.PreSkill;
import static com.raven.form.Skill_Edit.checkSkill;
import static com.raven.form.Skill_Edit.checkSkillInsert;
import static com.raven.form.Skill_Edit.insertbutton;
import static com.raven.form.Skill_Edit.updatebutton;
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


public class Department_Edit extends javax.swing.JPanel {
DefaultTableModel tableModel;
static String PreDepartment="";
//static boolean checkEditpress=false;
//static boolean checkInsertpress=false;
static boolean checkDepartment=false; 
static boolean checkDepartmentInsert=false; 
 static boolean insertbutton=false; 
 static boolean updatebutton=false; 
List<Department> departmentList = new ArrayList<>();
    public Department_Edit() {
        initComponents();
        tableModel = (DefaultTableModel) table1.getModel();
        setOpaque(false);
        showDepartment();
        Search();
        Text_DepartmentName.setEnabled(false);
        Text_PhoneNumber.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnEsc.setEnabled(false);
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
    }

   

    public void showDepartment(){
        List<Department> departmentManagementList = Department_Modify.findAll();
        tableModel.setRowCount(0);
        departmentManagementList.forEach((department) -> {
            tableModel.addRow(new Object[] {department.getName(),department.getTelephone()} );
        });
 
    }


  private void Search(){
        SearchTextField.addEvent(new EventTextField() {
            @Override
            public void onPressed(EventCallBack call) {
               String input = SearchTextField.getText();
        if (input != null && input.length() > 0){
            departmentList = Department_Modify.findByName(input);
            tableModel.setRowCount(0);
        
        departmentList.forEach((dpm) -> {
            tableModel.addRow(new Object[] {dpm.getName(), dpm.getTelephone() } );
        });
        }  
        else showDepartment();

            }

            @Override
            public void onCancel() {
                showDepartment();
            }
        });
    }

    
     public void checkExistDepartment(String departmentname){
          
        List<Department> departmentManagementList = Department_Modify.findAll();
        departmentManagementList.forEach((department) -> {
             if(departmentname.equalsIgnoreCase(department.getName()) && !departmentname.equalsIgnoreCase(PreDepartment)){
                 checkDepartment=true;
             }
        });
        
    }
     
       public void checkExistDepartmentInsert(String departmentname){
          
        List<Department> departmentManagementList = Department_Modify.findAll();
        departmentManagementList.forEach((department) -> {
             if(departmentname.equalsIgnoreCase(department.getName()) ){
                 checkDepartmentInsert=true;
             }
        });
        
    }
    
    public boolean checkEmployeeDepartment(String departmentname){
        List<Staff> staffList = Staff_Modify.findAll();
          for(Staff staff : staffList){
               if(staff.getPhongban().equalsIgnoreCase(departmentname)){
                   return true;
               }
        }
          return false;
    }
     
   


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.raven.swing.table.Table();
        Text_PhoneNumber = new com.raven.swing.TextField();
        Text_DepartmentName = new com.raven.swing.TextField();
        SearchTextField = new Login.TextFieldAnimation();
        jToolBar2 = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnEsc = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1726, 820));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("DEPARTMENT MANGEMENT");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(76, 76, 76));
        jLabel5.setText("Data Department");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jScrollPane1.setBorder(null);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "DEPARTMENT NAME", "PHONE NUMBER"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
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

        Text_PhoneNumber.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_PhoneNumber.setLabelText("PHONE NUMBER");
        Text_PhoneNumber.setLineColor(new java.awt.Color(0, 0, 0));

        Text_DepartmentName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_DepartmentName.setLabelText("DEPARTMENT NAME");
        Text_DepartmentName.setLineColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Text_DepartmentName, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Text_PhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(99, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Text_DepartmentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(Text_PhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)))
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
        jToolBar2.add(btnAdd);

        btnEdit.setBackground(new java.awt.Color(255, 255, 255));
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

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        btnAdd.setEnabled(false);
        btnEdit.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnEsc.setEnabled(true);
        btnDelete.setEnabled(false);
        Text_DepartmentName.setEnabled(true);
        Text_PhoneNumber.setEnabled(true);
        insertbutton=true;
    }//GEN-LAST:event_btnAddActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
         btnEdit.setEnabled(true);  
         btnDelete.setEnabled(true);  
        int row = table1.getSelectedRow();
        String depart = (String.valueOf(table1.getValueAt(row, 0))); // lấy đc id
        Department dap = Department_Modify.getDepartmentbyName(depart);
        Text_DepartmentName.setText(String.valueOf(dap.getName()));
        Text_PhoneNumber.setText(String.valueOf(dap.getTelephone()));
        PreDepartment = dap.getName();
    }//GEN-LAST:event_table1MouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        btnAdd.setEnabled(false);
        btnEdit.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnEsc.setEnabled(true);
        btnDelete.setEnabled(false);
        Text_DepartmentName.setEnabled(true);
        Text_PhoneNumber.setEnabled(true);
        updatebutton=true;
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
          int row = table1.getSelectedRow();
        String departmentname= String.valueOf(table1.getValueAt(row, 0));

        int respone=JOptionPane.showConfirmDialog(this,"Do you want to continue delete department ?", "CONFIRM",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(respone==JOptionPane.YES_OPTION){
            if(checkEmployeeDepartment(departmentname)){
                JOptionPane.showMessageDialog(null,"YOU MUST DELETE CURRENT EMPLOYEE DEPARTMENT:"+""+departmentname,"",2);
            }else{
               Department_Modify.delete(departmentname);
            }
        } 
       showDepartment();
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnEsc.setEnabled(false);
        btnDelete.setEnabled(false);
        Text_DepartmentName.setText("");
        Text_PhoneNumber.setText(""); 
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
          if(insertbutton==true){
           String insertdepartment=Text_DepartmentName.getText();
              String insertphonenumber=Text_PhoneNumber.getText();
              Department department=new Department(insertdepartment,insertphonenumber);
              checkExistDepartmentInsert(insertdepartment);
              if(checkDepartmentInsert==true){
                  JOptionPane.showMessageDialog(null,"DEPARTMENT ALREADY EXIST"+":"+insertdepartment,"",2);
              } else{
                  Department_Modify.insert(department);
                 
                  showDepartment();
                 
     
              }
              
              checkDepartmentInsert=false;
        } else if(updatebutton==true){
             String depart = Text_DepartmentName.getText();
        String phone = Text_PhoneNumber.getText();
        checkExistDepartment(depart);
        if(checkDepartment==true){
           JOptionPane.showMessageDialog(null,"DEPARTMENT ALREADY EXIST"+":"+depart,"",2);
        }else{
              Department dep = new Department(depart, phone);
              Department_Modify.update(dep, PreDepartment);
              showDepartment();
        }
      
        checkDepartment=false;
        Text_DepartmentName.setText("");
        Text_PhoneNumber.setText("");     
        PreDepartment ="";
        }
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnEsc.setEnabled(false);
        btnDelete.setEnabled(false);
        table1.clearSelection();
        updatebutton=false;
        insertbutton=false;
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnEscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscActionPerformed
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnEsc.setEnabled(false);
        btnDelete.setEnabled(false);
        Text_DepartmentName.setText("");
        Text_PhoneNumber.setText(""); 
        table1.clearSelection();
        updatebutton=false;
        insertbutton=false;
    }//GEN-LAST:event_btnEscActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Login.TextFieldAnimation SearchTextField;
    private com.raven.swing.TextField Text_DepartmentName;
    private com.raven.swing.TextField Text_PhoneNumber;
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
