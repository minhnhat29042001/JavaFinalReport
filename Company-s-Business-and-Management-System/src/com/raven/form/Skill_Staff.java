package com.raven.form;

import Login.EventCallBack;
import Login.EventTextField;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Skill_Staff extends javax.swing.JPanel {
DefaultTableModel tableModel;
List<SkillManagement> skillList = new ArrayList<>();
 Calendar cal=new GregorianCalendar();
  static String PreSkill;
    public Skill_Staff() {
        initComponents();
        tableModel = (DefaultTableModel) table1.getModel();
        setOpaque(false);
        showSkill();
        showSkillComboBox();
        Search();
        Text_LastDateComment.setEnabled(false);
        Text_Name.setEnabled(false);
        Text_Comment.setEnabled(false);
        combobox_Skill.setEnabled(false);
        combobox_Skill.setSelectedIndex(-1);
        btnSave.setEnabled(false);
        btnEsc.setEnabled(false);
        btnupdate.setEnabled(false);
        btnDelete.setEnabled(false);
       
    }

   

    public void showSkill(){
        List<SkillManagement> skillManagementList = SkillManagement_Modify.findAll();
        tableModel.setRowCount(0);
        skillManagementList.forEach((skill) -> {
            tableModel.addRow(new Object[] {skill.getID(), skill.getStaffName(),skill.getStaffSkill(), skill.getComment(),skill.getLastDateComment() } );
        });
    }


      private void Search(){
        SearchTextField.addEvent(new EventTextField() {
            @Override
            public void onPressed(EventCallBack call) {
               String input = SearchTextField.getText();
        if (input != null && input.length() > 0){
            skillList = SkillManagement_Modify.findByName(input);
            tableModel.setRowCount(0);
        
        skillList.forEach((skill) -> {
            tableModel.addRow(new Object[] {skill.getID(), skill.getStaffName(), skill.getStaffSkill(), skill.getComment(), skill.getLastDateComment() } );
        });
        }  
        else showSkill();
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
                showSkill();
            }
        });
    }

    
     public void SkillIndex(SkillManagement skm){
              
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
       
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from skill ";
            int SkillId=0 ;
            String SkillNameStaff =skm.getStaffSkill();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
          
            while (resultSet.next()) {
                 if(resultSet.getString("SkillName").equalsIgnoreCase(SkillNameStaff)){
                      combobox_Skill.setSelectedIndex(SkillId);
                      break;
                } else{
                    SkillId++;
                }
                
             
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(Skill_Staff.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
     
     public void showSkillComboBox(){
         List<Skill> skillList = Skill_Modify.findAll();
         for(Skill skill :skillList){
             combobox_Skill.addItem(skill);
         }
    }
    
    public boolean CheckExistSkill(int IDStaff, String SkillStaff){
        List<SkillManagement> skillmanagementList = SkillManagement_Modify.findAll();
        
      for(SkillManagement skillmang :skillmanagementList){
           if(skillmang.getID()==IDStaff && skillmang.getStaffSkill().equalsIgnoreCase(SkillStaff)){
              return true;
            }
      }
           
             
       
        return false;
           
     
     }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Text_ID = new com.raven.swing.TextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.raven.swing.table.Table();
        Text_ID1 = new com.raven.swing.TextField();
        Text_Comment = new com.raven.swing.TextField();
        Text_LastDateComment = new com.raven.swing.TextField();
        combobox_Skill = new com.raven.swing.Combobox<>();
        Text_Name = new com.raven.swing.TextField();
        SearchTextField = new Login.TextFieldAnimation();
        jToolBar2 = new javax.swing.JToolBar();
        btnupdate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnEsc = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        Text_ID.setEditable(false);
        Text_ID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Text_ID.setLabelText("ID");
        Text_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_IDActionPerformed(evt);
            }
        });

        setPreferredSize(new java.awt.Dimension(1726, 820));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("STAFF SKILL MANGEMENT");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(76, 76, 76));
        jLabel5.setText("Data Staff");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jScrollPane1.setBorder(null);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "NAME", "SKILL", "COMMENT", "DATE"
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
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        Text_ID1.setEditable(false);
        Text_ID1.setBackground(new java.awt.Color(255, 255, 255));
        Text_ID1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_ID1.setLabelText("ID");
        Text_ID1.setLineColor(new java.awt.Color(0, 0, 0));

        Text_Comment.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_Comment.setLabelText("COMMENT");
        Text_Comment.setLineColor(new java.awt.Color(0, 0, 0));

        Text_LastDateComment.setEditable(false);
        Text_LastDateComment.setBackground(new java.awt.Color(255, 255, 255));
        Text_LastDateComment.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_LastDateComment.setLabelText("LAST DATE COMMENT");

        combobox_Skill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        combobox_Skill.setLabeText("SKILL");

        Text_Name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_Name.setLabelText("NAME");

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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Text_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Text_ID1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combobox_Skill, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Text_Comment, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Text_LastDateComment, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                            .addComponent(Text_ID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Text_LastDateComment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Text_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Text_Comment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addComponent(combobox_Skill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)))
        );

        jToolBar2.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar2.setForeground(new java.awt.Color(255, 255, 255));
        jToolBar2.setRollover(true);

        btnupdate.setBackground(new java.awt.Color(255, 255, 255));
        btnupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/Edit.png"))); // NOI18N
        btnupdate.setText("UPDATE");
        btnupdate.setIconTextGap(15);
        btnupdate.setMargin(new java.awt.Insets(2, 16, 2, 16));
        btnupdate.setMaximumSize(new java.awt.Dimension(129, 33));
        btnupdate.setMinimumSize(new java.awt.Dimension(119, 33));
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        jToolBar2.add(btnupdate);

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
                .addContainerGap(352, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Text_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_IDActionPerformed
      
    }//GEN-LAST:event_Text_IDActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        Text_LastDateComment.setEnabled(true);
        Text_Name.setEnabled(true);
        Text_Comment.setEnabled(true);
        combobox_Skill.setEnabled(true);    
        btnSave.setEnabled(true);    
        btnEsc.setEnabled(true);
        btnupdate.setEnabled(false);
        DateTimeFormatter dft= DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now=LocalDateTime.now();
        String nowdate=dft.format(now);
        Text_LastDateComment.setText(nowdate);
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        int id=Integer.valueOf(Text_ID1.getText());
        String comment = Text_Comment.getText();
        String lastdate=Text_LastDateComment.getText();
        String skill=String.valueOf(combobox_Skill.getSelectedItem());
        String staffname=Text_Name.getText();
       
        
        if(!skill.equalsIgnoreCase(PreSkill)){
          if( CheckExistSkill(id,skill)){
              JOptionPane.showMessageDialog(null,"SKILL ALREADY EXIST","",2);// role trùng
          } else{
               SkillManagement_Modify.update(id, staffname, skill,PreSkill, comment, lastdate);
               Text_ID1.setText("");
               Text_Comment.setText("");
               Text_LastDateComment.setText("");
               Text_Name.setText("");
               btnSave.setEnabled(false);    
               btnEsc.setEnabled(true);
               btnupdate.setEnabled(false);
               btnDelete.setEnabled(false);
               combobox_Skill.setEnabled(false);
               combobox_Skill.setSelectedIndex(-1);
               table1.clearSelection();
               PreSkill="";
                      showSkill();  
          }
    } else if(skill.equalsIgnoreCase(PreSkill)){
              SkillManagement_Modify.update(id, staffname, skill,PreSkill, comment, lastdate);
               Text_ID1.setText("");
               Text_Comment.setText("");
               Text_LastDateComment.setText("");
               Text_Name.setText("");
               btnSave.setEnabled(false);    
               btnEsc.setEnabled(true);
               btnupdate.setEnabled(false);
               btnDelete.setEnabled(false);
               combobox_Skill.setEnabled(false);
               combobox_Skill.setSelectedIndex(-1);
               table1.clearSelection();
               PreSkill="";
                      showSkill();  
        }
        
        
        
        
        
        
      
        showSkill();     
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscActionPerformed
        Text_LastDateComment.setEnabled(false);
        Text_Name.setEnabled(false);
        Text_Comment.setEnabled(false);
        combobox_Skill.setEnabled(false);    
        btnSave.setEnabled(false);    
        btnEsc.setEnabled(false);
        btnupdate.setEnabled(false);
        btnDelete.setEnabled(false);
        combobox_Skill.setSelectedIndex(-1);
        Text_ID1.setText("");
        Text_Comment.setText("");
        Text_LastDateComment.setText("");
        Text_Name.setText("");
        table1.clearSelection();
    }//GEN-LAST:event_btnEscActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int response=JOptionPane.showConfirmDialog(this,"DO YOU WANT TO CONTINUE DELETE ACTION","CONFIRM", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(response == JOptionPane.YES_OPTION){
        int row = table1.getSelectedRow();
        int stfId = Integer.valueOf(String.valueOf(table1.getValueAt(row, 0))); // lấy đc id
        String skill=String.valueOf(table1.getValueAt(row, 2));// lấy đc skill trùng với id
        SkillManagement_Modify.delete(stfId, skill);
      
         } else if(response == JOptionPane.NO_OPTION){
             
         }
        Text_LastDateComment.setEnabled(false);
        Text_Name.setEnabled(false);
        Text_Comment.setEnabled(false);
        combobox_Skill.setEnabled(false);    
        btnSave.setEnabled(false);    
        btnEsc.setEnabled(false);
        btnupdate.setEnabled(false);
        btnDelete.setEnabled(false);
        combobox_Skill.setSelectedIndex(-1);
        Text_ID1.setText("");
        Text_Comment.setText("");
        Text_LastDateComment.setText("");
        Text_Name.setText("");
        table1.clearSelection();
          showSkill();     
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        btnupdate.setEnabled(true);
        btnDelete.setEnabled(true);
        int row = table1.getSelectedRow();
        int stfId = Integer.valueOf(String.valueOf(table1.getValueAt(row, 0))); // lấy đc id
        String skill=String.valueOf(table1.getValueAt(row, 2));// lấy đc skill trùng với id
        SkillManagement skillmanagement = SkillManagement_Modify.getSkillManagementId(stfId,skill);
        Text_ID1.setText(String.valueOf(skillmanagement.getID()));
        Text_Comment.setText(skillmanagement.getComment());
       
        Text_LastDateComment.setText(skillmanagement.getLastDateComment());
        Text_Name.setText(skillmanagement.getStaffName());
        SkillIndex(skillmanagement);
        PreSkill=combobox_Skill.getSelectedItem().toString();
    }//GEN-LAST:event_table1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Login.TextFieldAnimation SearchTextField;
    private com.raven.swing.TextField Text_Comment;
    private com.raven.swing.TextField Text_ID;
    private com.raven.swing.TextField Text_ID1;
    private com.raven.swing.TextField Text_LastDateComment;
    private com.raven.swing.TextField Text_Name;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEsc;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnupdate;
    private com.raven.swing.Combobox<Skill> combobox_Skill;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar2;
    private com.raven.swing.table.Table table1;
    // End of variables declaration//GEN-END:variables
}
