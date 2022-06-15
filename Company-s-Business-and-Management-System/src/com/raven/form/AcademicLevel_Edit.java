package com.raven.form;

import Login.EventCallBack;
import Login.EventTextField;
import Model.Academiclevel;
import Model.Academiclevel_Modify;
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
import static com.raven.form.Department_Edit.PreDepartment;
import static com.raven.form.Department_Edit.checkDepartment;

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
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class AcademicLevel_Edit extends javax.swing.JPanel {
DefaultTableModel tableModel;
static String PreAcademiclevel="";
//static boolean checkEditpress=false;
//static boolean checkInsertpress=false;
static boolean checkAcademiclevel=false; 
static boolean checkAcademiclevelInsert=false; 
    public AcademicLevel_Edit() {
        initComponents();
        tableModel = (DefaultTableModel) table1.getModel();
        setOpaque(false);
        showAcademiclevel();
      
    }

   

    public void  showAcademiclevel(){
        List<Academiclevel>  academiclevelManagementList = Academiclevel_Modify.findAll();
        tableModel.setRowCount(0);
        academiclevelManagementList.forEach((academiclevel) -> {
            tableModel.addRow(new Object[] {academiclevel.getAcademic_name()} );
        });
    }


    private void Search(){
        SearchTextField.addEvent(new EventTextField() {
            @Override
            public void onPressed(EventCallBack call) {
                //  Test
                try {
                    for (int i = 1; i <= 100; i++) {
                        //do action here
                        Thread.sleep(10);
                    }
                    call.done();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }

            @Override
            public void onCancel() {

            }
        });
    }
    
     public void checkExistAcademiclevel(String academiclevelname){
          
        List<Academiclevel>  academiclevelManagementList = Academiclevel_Modify.findAll();
        academiclevelManagementList.forEach((academiclevel) -> {
             if(academiclevelname.equalsIgnoreCase(academiclevel.getAcademic_name()) && !academiclevelname.equalsIgnoreCase(PreAcademiclevel)){
                 checkAcademiclevel=true;
             }
        });
        
    }
     
      public void checkExistAcademiclevelInsert(String academiclevelname){
          
        List<Academiclevel>  academiclevelManagementList = Academiclevel_Modify.findAll();
        academiclevelManagementList.forEach((academiclevel) -> {
             if(academiclevelname.equalsIgnoreCase(academiclevel.getAcademic_name())){
                 checkAcademiclevelInsert=true;
             }
        });
        
    }
   
        public boolean checkEmployeeAcademic(String acdemicname){
        List<Staff> staffList = Staff_Modify.findAll();
          for(Staff staff : staffList){
               if(staff.getTrinhdohocvan().equalsIgnoreCase(acdemicname)){
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
        button_Fix = new com.raven.swing.ButtonGradient();
        button_Submit = new com.raven.swing.ButtonGradient();
        button_Insert = new com.raven.swing.ButtonGradient();
        Text_AcademicName = new com.raven.swing.TextField();
        button_Cancle = new com.raven.swing.ButtonGradient();
        button_Delete = new com.raven.swing.ButtonGradient();
        SearchTextField = new Login.TextFieldAnimation();

        setPreferredSize(new java.awt.Dimension(1726, 820));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("STAFF ACADEMIC LEVEL MANGEMENT");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(76, 76, 76));
        jLabel5.setText("Data Academic Level");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jScrollPane1.setBorder(null);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "ACADEMIC LEVEL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        table1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table1);

        button_Fix.setBackground(new java.awt.Color(255, 255, 255));
        button_Fix.setText("FIX");
        button_Fix.setColor1(new java.awt.Color(194, 85, 1));
        button_Fix.setColor2(new java.awt.Color(255, 212, 99));
        button_Fix.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        button_Fix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_FixActionPerformed(evt);
            }
        });

        button_Submit.setText("SUBMIT");
        button_Submit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        button_Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_SubmitActionPerformed(evt);
            }
        });

        button_Insert.setBackground(new java.awt.Color(255, 255, 255));
        button_Insert.setColor1(new java.awt.Color(194, 85, 1));
        button_Insert.setColor2(new java.awt.Color(255, 212, 99));
        button_Insert.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        button_Insert.setLabel("INSERT");
        button_Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_InsertActionPerformed(evt);
            }
        });

        Text_AcademicName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Text_AcademicName.setLabelText("ACADEMIC LEVEL");

        button_Cancle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        button_Cancle.setLabel("CANCLE");
        button_Cancle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_CancleActionPerformed(evt);
            }
        });

        button_Delete.setText("DELETE");
        button_Delete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        button_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_DeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(Text_AcademicName, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(button_Submit, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(button_Cancle, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_Fix, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(191, 191, 191))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Text_AcademicName, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(364, 364, 364)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button_Submit, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_Fix, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button_Cancle, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addComponent(button_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(1367, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button_FixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_FixActionPerformed
        int row = table1.getSelectedRow();
        String academiclevelName = String.valueOf(table1.getValueAt(row, 0)); // lấy đc id
        Academiclevel academiclevel = Academiclevel_Modify.getAcademiclevelbyName(academiclevelName);
        Text_AcademicName.setText(academiclevel.getAcademic_name());

        PreAcademiclevel=academiclevel.getAcademic_name();
        button_Insert.setVisible(false);
        
        
        
    }//GEN-LAST:event_button_FixActionPerformed

    private void button_SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_SubmitActionPerformed
         
  
            String academiclevelnameupdate=Text_AcademicName.getText();
            Academiclevel editacademiclevel= new Academiclevel(academiclevelnameupdate);
            checkExistAcademiclevel(editacademiclevel.getAcademic_name());
            if( checkAcademiclevel==true){
                  JOptionPane.showMessageDialog(null,"ACADEMIC LEVEL  ALREADY EXISTS"+":"+academiclevelnameupdate,"",2);
            } else{
                    Academiclevel_Modify.update(editacademiclevel,PreAcademiclevel);
                     showAcademiclevel();
            }
       
   
           

            
             
        

        checkAcademiclevel=false;
        PreAcademiclevel="";
        button_Insert.setVisible(true);
        
       
        
    }//GEN-LAST:event_button_SubmitActionPerformed

    private void button_InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_InsertActionPerformed
        String academiclevelinsert= Text_AcademicName.getText();
        Academiclevel insertacademiclevel =new Academiclevel(academiclevelinsert);
            checkExistAcademiclevelInsert(insertacademiclevel.getAcademic_name());
            if(checkAcademiclevelInsert==true){
                JOptionPane.showMessageDialog(null,"ACADEMIC LEVEL  ALREADY EXISTS"+":"+insertacademiclevel.getAcademic_name(),"",2);
            } else{
                 Academiclevel_Modify.insert(insertacademiclevel.getAcademic_name());
               showAcademiclevel();
            }
        checkAcademiclevelInsert=false;
    }//GEN-LAST:event_button_InsertActionPerformed

    private void button_CancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_CancleActionPerformed
    button_Insert.setVisible(true);
    button_Fix.setVisible(true);
    Text_AcademicName.setText("");
    PreAcademiclevel="";
    }//GEN-LAST:event_button_CancleActionPerformed

    private void button_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_DeleteActionPerformed
        int row = table1.getSelectedRow();
        String academicname= String.valueOf(table1.getValueAt(row, 0));

        int respone=JOptionPane.showConfirmDialog(this,"Do you want to continue delete role ?", "CONFIRM",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(respone==JOptionPane.YES_OPTION){
            if(checkEmployeeAcademic(academicname)){
                JOptionPane.showMessageDialog(null,"YOU MUST UPDATE CURRENT EMPLOYEE ACADEMIC LEVEL:"+""+academicname,"",2);
            }else{
                Academiclevel_Modify.delete(academicname);
            }
        } else if(respone==JOptionPane.NO_OPTION){

        }
       showAcademiclevel();
    }//GEN-LAST:event_button_DeleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Login.TextFieldAnimation SearchTextField;
    private com.raven.swing.TextField Text_AcademicName;
    private com.raven.swing.ButtonGradient button_Cancle;
    private com.raven.swing.ButtonGradient button_Delete;
    private com.raven.swing.ButtonGradient button_Fix;
    private com.raven.swing.ButtonGradient button_Insert;
    private com.raven.swing.ButtonGradient button_Submit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.table.Table table1;
    // End of variables declaration//GEN-END:variables
}
