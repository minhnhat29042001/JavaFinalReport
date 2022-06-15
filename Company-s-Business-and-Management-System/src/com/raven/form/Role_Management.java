package com.raven.form;

import Login.EventCallBack;
import Login.EventTextField;
import Model.Role;
import Model.RoleManagement;
import Model.RoleManagement_Modify;
import Model.Role_Modify;
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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static oracle.jdbc.OracleTypes.NULL;

public class Role_Management extends javax.swing.JPanel {
DefaultTableModel tableModel;
 static String PreRole;
 static Boolean flag=false;
 List<RoleManagement> roleList = new ArrayList<>();
//static Boolean dateflag=false;
    public Role_Management() {
        initComponents();
        tableModel = (DefaultTableModel) table1.getModel();
        showRole();
        setOpaque(false);
        showRoleComboBox();
        Text_StartDate.setEnabled(false);
        Text_EndDate.setEnabled(false);
        combobox_Role.setSelectedIndex(-1);
        combobox_Role.setEnabled(false);
        btnSave.setEnabled(false);
        btnEsc.setEnabled(false);
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
        Search();
        
       
    }

    
     public void showRoleComboBox(){
         List<Role> roleList = Role_Modify.findAll();
         for(Role rol :roleList){
             combobox_Role.addItem(rol);
         }
    }
    
    
    public void showRole(){
        List<RoleManagement> rolemanagementList = RoleManagement_Modify.findAll();
        tableModel.setRowCount(0);
        rolemanagementList.forEach((role) -> {
            tableModel.addRow(new Object[] {role.getID(), role.getStaffName(),role.getRole(), role.getStartDate(),role.getEndDate() } );
        });
    }
    
   


  private void Search(){
        SearchTextField.addEvent(new EventTextField() {
            @Override
            public void onPressed(EventCallBack call) {
               String input = SearchTextField.getText();
        if (input != null && input.length() > 0){
            roleList = RoleManagement_Modify.findByName(input);
            tableModel.setRowCount(0);
        
        roleList.forEach((role) -> {
            tableModel.addRow(new Object[] {role.getID(), role.getStaffName(), role.getRole(), role.getStartDate(), role.getEndDate() } );
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



     public void RoleIndex(RoleManagement rlm){
              
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
       
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from role";
            int RoleId=0 ;
            String RoleName =rlm.getRole();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
          
            while (resultSet.next()) {
                if(resultSet.getString("RoleName").equalsIgnoreCase(RoleName)){
                      combobox_Role.setSelectedIndex(RoleId);
                      break;
                } else{
                    RoleId++;
                }
               
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(Role_Management.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
    
    
     public boolean CheckExistRole(int IDStaff, String RoleStaff){
        List<RoleManagement> rolemanagementList = RoleManagement_Modify.findAll();
        
      for(RoleManagement role :rolemanagementList){
           if(role.getID()==IDStaff && role.getRole().equalsIgnoreCase(RoleStaff)){
              return true;
            }
      }
           
             
       
        return false;
           
     
     }
    
    public boolean checkEmployeeRole(String rolename,int StaffId){
        List<Staff> staffList = Staff_Modify.findAll();
          for(Staff staff : staffList){
               if(staff.getChucvuhientai().equalsIgnoreCase(rolename)&& staff.getId()==StaffId){
                   return true;
               }
        }
          return false;
    }
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateStart = new com.raven.datechooser.DateChooser();
        dateEnd = new com.raven.datechooser.DateChooser();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        Text_ID = new com.raven.swing.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.raven.swing.table.Table();
        combobox_Role = new com.raven.swing.Combobox<>();
        Text_StartDate = new com.raven.swing.TextField();
        Text_EndDate = new com.raven.swing.TextField();
        SearchTextField = new Login.TextFieldAnimation();
        jToolBar1 = new javax.swing.JToolBar();
        btnUpdate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnEsc = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        dateStart.setForeground(new java.awt.Color(0, 153, 247));
        dateStart.setDateFormat("dd-MMMM-yyyy");
        dateStart.setTextRefernce(Text_StartDate);

        dateEnd.setForeground(new java.awt.Color(0, 153, 247));
        dateEnd.setDateFormat("dd-MMMM-yyyy");
        dateEnd.setTextRefernce(Text_EndDate);

        setPreferredSize(new java.awt.Dimension(1726, 820));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("STAFF ROLE MANGEMENT");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(76, 76, 76));
        jLabel5.setText("Data Staff");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        Text_ID.setEditable(false);
        Text_ID.setBackground(new java.awt.Color(255, 255, 255));
        Text_ID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_ID.setLabelText("ID");
        Text_ID.setLineColor(new java.awt.Color(0, 0, 0));

        jScrollPane1.setBorder(null);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "NAME", "ROLE", "START DATE", "END DATE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        combobox_Role.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        combobox_Role.setLabeText("ROLE");
        combobox_Role.setLineColor(new java.awt.Color(0, 0, 0));

        Text_StartDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_StartDate.setLabelText("START DATE");
        Text_StartDate.setLineColor(new java.awt.Color(0, 0, 0));

        Text_EndDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_EndDate.setLabelText("END DATE");
        Text_EndDate.setLineColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combobox_Role, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Text_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Text_StartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Text_EndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
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
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Text_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Text_StartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Text_EndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combobox_Role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)))
        );

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setForeground(new java.awt.Color(255, 255, 255));
        jToolBar1.setRollover(true);

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
        jToolBar1.add(btnUpdate);

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
        jToolBar1.add(btnSave);

        btnEsc.setBackground(new java.awt.Color(255, 255, 255));
        btnEsc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/Stop.png"))); // NOI18N
        btnEsc.setText("EXIT");
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
        jToolBar1.add(btnEsc);

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
        jToolBar1.add(btnDelete);

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
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(352, Short.MAX_VALUE))
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
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        Text_StartDate.setEnabled(true);
        Text_EndDate.setEnabled(true);
        combobox_Role.setEnabled(true);
        btnSave.setEnabled(true);
        btnEsc.setEnabled(true);     
        btnUpdate.setEnabled(false); 
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
         int idstaff=  Integer.valueOf(Text_ID.getText());
        SelectedDate dstart = dateStart.getSelectedDate();
        String ds = (dstart.getYear() + "-" + dstart.getMonth() + "-" + dstart.getDay());
        SelectedDate dend = dateEnd.getSelectedDate();
        String de = (dend.getYear() + "-" + dend.getMonth() + "-" + dend.getDay());
        int ID = Integer.valueOf(Text_ID.getText());
        String role = combobox_Role.getSelectedItem().toString();
        Staff staff=Staff_Modify.getStaffId(ID);
     
        if(!role.equalsIgnoreCase(PreRole) ) {
            if(CheckExistRole(idstaff,role)){
                JOptionPane.showMessageDialog(null,"ROLE ALREADY EXIST","",2);// role trùng
               
            } else {
                if(PreRole.equals(staff.getChucvuhientai())) {
                    Staff updateroletsaff = new Staff(ID,staff.getHoten(),staff.getGioitinh(),staff.getDiachithuongtru(),staff.getNoisinh(),staff.getNgaysinh(),staff.getTrinhdohocvan(),staff.getPhongban(),role);
                    Staff_Modify.update(updateroletsaff);
                    RoleManagement_Modify.update(ID, role, ds, de,PreRole);
                    PreRole="";
                    Text_StartDate.setText("");
                    Text_EndDate.setText("");
                    Text_ID.setText("");
                    btnEsc.setEnabled(false);
                    btnSave.setEnabled(false);
                    combobox_Role.setSelectedIndex(-1);
                    Text_StartDate.setEnabled(false);
                    Text_EndDate.setEnabled(false);
                    combobox_Role.setEnabled(false);
                    btnUpdate.setEnabled(false);
                    table1.clearSelection();
                    btnDelete.setEnabled(false);
                    showRole();
                } else if(!PreRole.equals(staff.getChucvuhientai())){

                    RoleManagement_Modify.update(ID, role, ds, de,PreRole);
                    PreRole="";
                    Text_StartDate.setText("");
                    Text_EndDate.setText("");
                    Text_ID.setText("");
                    btnEsc.setEnabled(false);
                    btnSave.setEnabled(false);
                    combobox_Role.setSelectedIndex(-1);
                    Text_StartDate.setEnabled(false);
                    Text_EndDate.setEnabled(false);
                    combobox_Role.setEnabled(false);
                    btnUpdate.setEnabled(false);
                    table1.clearSelection();
                    btnDelete.setEnabled(false);
                    showRole();

                }

            }

        } else if (role.equalsIgnoreCase(PreRole)){
            RoleManagement_Modify.update(ID, role, ds, de,PreRole);
            PreRole="";
            Text_StartDate.setText("");
            Text_EndDate.setText("");
            Text_ID.setText("");
            showRole();
            btnEsc.setEnabled(false);
            btnSave.setEnabled(false);
            combobox_Role.setSelectedIndex(-1);
            Text_StartDate.setEnabled(false);
            Text_EndDate.setEnabled(false);
            combobox_Role.setEnabled(false);
            table1.clearSelection();
            btnUpdate.setEnabled(false);
            btnDelete.setEnabled(false);
           
        }  
         
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscActionPerformed
        Text_StartDate.setEnabled(false);
        Text_EndDate.setEnabled(false);
        combobox_Role.setEnabled(false);
        combobox_Role.setSelectedIndex(-1);
        btnSave.setEnabled(false);
        btnEsc.setEnabled(true);     
        Text_StartDate.setText("");
        Text_EndDate.setText("");
        Text_ID.setText("");
        btnEsc.setEnabled(false);
        btnDelete.setEnabled(false);
        table1.clearSelection();
    }//GEN-LAST:event_btnEscActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int row = table1.getSelectedRow();
        int StaffId=Integer.valueOf(String.valueOf(table1.getValueAt(row, 0)));
        String rolename= String.valueOf(table1.getValueAt(row, 2));

        int respone=JOptionPane.showConfirmDialog(this,"Do you want to continue delete role ?", "CONFIRM",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(respone==JOptionPane.YES_OPTION){
            if(checkEmployeeRole(rolename,StaffId)){
                JOptionPane.showMessageDialog(null,"YOU MUST UPDATE CURRENT EMPLOYEE ROLE:"+""+rolename,"",2);
            } else{
                RoleManagement_Modify.delete(StaffId,rolename);
            }
        } else if(respone==JOptionPane.NO_OPTION){

        }
        Text_StartDate.setText("");
        Text_EndDate.setText("");
        Text_ID.setText("");
        btnDelete.setEnabled(false);
        Text_StartDate.setEnabled(false);
        Text_EndDate.setEnabled(false);
        combobox_Role.setEnabled(false);
        combobox_Role.setSelectedIndex(-1);
        btnUpdate.setEnabled(false); 
        table1.clearSelection();
        showRole();      
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
        int row = table1.getSelectedRow();
        int stfId = Integer.valueOf(String.valueOf(table1.getValueAt(row, 0))); // lấy đc id
        String role=String.valueOf(table1.getValueAt(row, 2));// lấy đc role trùng với id

        RoleManagement rolemanagement = RoleManagement_Modify.getRoleManagementId(stfId,role); // lấy tất cả thông tin qau role và id
        RoleIndex(rolemanagement);
        Text_ID.setText(String.valueOf(rolemanagement.getID()));

        Text_StartDate.setText(rolemanagement.getStartDate());
        Text_EndDate.setText(rolemanagement.getEndDate());
     
        PreRole = combobox_Role.getSelectedItem().toString();// lấy prerole

    }//GEN-LAST:event_table1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Login.TextFieldAnimation SearchTextField;
    private com.raven.swing.TextField Text_EndDate;
    private com.raven.swing.TextField Text_ID;
    private com.raven.swing.TextField Text_StartDate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEsc;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private com.raven.swing.Combobox<Role> combobox_Role;
    private com.raven.datechooser.DateChooser dateEnd;
    private com.raven.datechooser.DateChooser dateStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private com.raven.swing.table.Table table1;
    // End of variables declaration//GEN-END:variables
}
