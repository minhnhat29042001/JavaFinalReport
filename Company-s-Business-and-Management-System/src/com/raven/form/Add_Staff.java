package com.raven.form;

import Model.Academiclevel;
import Model.Academiclevel_Modify;
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
import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.border.Border;
import scrollbar.ScrollBarCustom;

public class Add_Staff extends javax.swing.JPanel {
 static int ID_Generate1;
     Calendar cal=new GregorianCalendar();
    public Add_Staff() {
        initComponents();

        setOpaque(false);
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane1.setHorizontalScrollBar(null);
        showAcademiclevel();
        showDepartment();
        showRole();
        showID();
        showSKILL();
        btnEsc.setEnabled(false);
        btnSave.setEnabled(false);
        Text_Address.setEnabled(false);
        Text_BirthDate.setEnabled(false);
        Text_Birthplace.setEnabled(false);
        Text_Name.setEnabled(false);
        combobox_Academic.setEnabled(false);
        combobox_Department.setEnabled(false);
        combobox_ROLE.setEnabled(false);
        radioButtonCustom_MEN.setEnabled(false);
        radioButtonCustom_WOMEN.setEnabled(false);
        radioButtonCustom_MEN.setSelected(false);
        radioButtonCustom_WOMEN.setSelected(false);
        jListSkill.setEnabled(false);
        combobox_Academic.setSelectedIndex(-1);
        combobox_Department.setSelectedIndex(-1);
        combobox_ROLE.setSelectedIndex(-1);
   
       

 
        
        
    }
    
     
    public void showAcademiclevel(){
         List<Academiclevel> academicList = Academiclevel_Modify.findAll();
         for(Academiclevel acl :academicList ){
             combobox_Academic.addItem(acl);
         }
    }
    
     public void showDepartment(){
         List<Department> departmentList = Department_Modify.findAll();
         for(Department dpt :departmentList){
             combobox_Department.addItem(dpt);
         }
    }
     
      public void showRole(){
         List<Role> roleList = Role_Modify.findAll();
         for(Role rol :roleList){
             combobox_ROLE.addItem(rol);
         }
    }
      
      public void showID(){
        ID_Generate1 = IDGenerate_Modify.getID();
        Text_ID.setText(String.valueOf(ID_Generate1));
         
    }
      
        public void showSKILL(){
         DefaultListModel<Skill> listModel= new DefaultListModel();
     
         List<Skill> skillList = Skill_Modify.findAll();
         for(Skill skill :skillList ){
            listModel.addElement(new Skill(skill.getName()));
         }
         jListSkill.setModel(listModel);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        date = new com.raven.datechooser.DateChooser();
        buttonGroup1 = new javax.swing.ButtonGroup();
        combobox_Academic = new com.raven.swing.Combobox<>();
        Text_ID = new com.raven.swing.TextField();
        combobox_Department = new com.raven.swing.Combobox<>();
        Text_Name = new com.raven.swing.TextField();
        Text_Address = new com.raven.swing.TextField();
        Text_BirthDate = new com.raven.swing.TextField();
        combobox_ROLE = new com.raven.swing.Combobox<>();
        Text_Birthplace = new com.raven.swing.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListSkill = new javax.swing.JList<>();
        jToolBar2 = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnEsc = new javax.swing.JButton();
        jToolBarSex = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        radioButtonCustom_MEN = new com.raven.swing.RadioButtonCustom();
        radioButtonCustom_WOMEN = new com.raven.swing.RadioButtonCustom();

        date.setForeground(new java.awt.Color(0, 153, 247));
        date.setDateFormat("dd-MMMM-yyyy");
        date.setTextRefernce(Text_BirthDate);

        setOpaque(false);

        combobox_Academic.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        combobox_Academic.setLabeText("ACADEMIC BANCHELOR");
        combobox_Academic.setLineColor(new java.awt.Color(0, 0, 0));
        combobox_Academic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_AcademicActionPerformed(evt);
            }
        });

        Text_ID.setEditable(false);
        Text_ID.setBackground(new java.awt.Color(255, 255, 255));
        Text_ID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_ID.setLabelText("ID");
        Text_ID.setLineColor(new java.awt.Color(0, 0, 0));

        combobox_Department.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        combobox_Department.setLabeText("DEPARTMENT");
        combobox_Department.setLineColor(new java.awt.Color(0, 0, 0));

        Text_Name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_Name.setLabelText("NAME");
        Text_Name.setLineColor(new java.awt.Color(0, 0, 0));
        Text_Name.setSelectionColor(new java.awt.Color(0, 0, 0));

        Text_Address.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_Address.setLabelText("ADDRESS");
        Text_Address.setLineColor(new java.awt.Color(0, 0, 0));

        Text_BirthDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_BirthDate.setLabelText("DAY OF BIRTH");
        Text_BirthDate.setLineColor(new java.awt.Color(0, 0, 0));
        Text_BirthDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_BirthDateActionPerformed(evt);
            }
        });

        combobox_ROLE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        combobox_ROLE.setLabeText("ROLE");
        combobox_ROLE.setLineColor(new java.awt.Color(0, 0, 0));

        Text_Birthplace.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_Birthplace.setLabelText("BIRTH PLACE");
        Text_Birthplace.setLineColor(new java.awt.Color(0, 0, 0));

        jListSkill.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SKILL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(109, 109, 109))); // NOI18N
        jListSkill.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(jListSkill);
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());

        jToolBar2.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar2.setRollover(true);

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

        btnEsc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/Stop.png"))); // NOI18N
        btnEsc.setText("EXIT");
        btnEsc.setFocusable(false);
        btnEsc.setHideActionText(true);
        btnEsc.setIconTextGap(15);
        btnEsc.setMargin(new java.awt.Insets(2, 20, 2, 20));
        btnEsc.setMaximumSize(new java.awt.Dimension(129, 33));
        btnEsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscActionPerformed(evt);
            }
        });
        jToolBar2.add(btnEsc);

        jToolBarSex.setBackground(new java.awt.Color(255, 255, 255));
        jToolBarSex.setForeground(new java.awt.Color(255, 255, 255));
        jToolBarSex.setRollover(true);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(109, 109, 109));
        jLabel1.setText("GENDER");
        jToolBarSex.add(jLabel1);

        radioButtonCustom_MEN.setText("Men");
        radioButtonCustom_MEN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioButtonCustom_MEN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonCustom_MENActionPerformed(evt);
            }
        });
        jToolBarSex.add(radioButtonCustom_MEN);

        radioButtonCustom_WOMEN.setText("Women");
        radioButtonCustom_WOMEN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jToolBarSex.add(radioButtonCustom_WOMEN);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(combobox_Department, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combobox_Academic, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combobox_ROLE, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Text_Address, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBarSex, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Text_Birthplace, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Text_BirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Text_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Text_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(234, 234, 234))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(404, 404, 404))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Text_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combobox_Academic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combobox_Department, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Text_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combobox_ROLE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Text_BirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Text_Birthplace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Text_Address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBarSex, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void combobox_AcademicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_AcademicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combobox_AcademicActionPerformed

    private void Text_BirthDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_BirthDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_BirthDateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        btnAdd.setEnabled(false);
        btnSave.setEnabled(true);
        btnEsc.setEnabled(true);
        btnEsc.setEnabled(true);
        btnSave.setEnabled(true);
        Text_Address.setEnabled(true);
        Text_BirthDate.setEnabled(true);
        Text_Birthplace.setEnabled(true);
        Text_Name.setEnabled(true);
        combobox_Academic.setEnabled(true);
        combobox_Department.setEnabled(true);
        combobox_ROLE.setEnabled(true);
        radioButtonCustom_MEN.setEnabled(true);
        radioButtonCustom_WOMEN.setEnabled(true);
         jListSkill.setEnabled(true);


    }//GEN-LAST:event_btnAddActionPerformed

    private void btnAddKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAddKeyPressed

    }//GEN-LAST:event_btnAddKeyPressed

    private void btnAddKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAddKeyReleased

    }//GEN-LAST:event_btnAddKeyReleased

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
       int id = ID_Generate1;
        String name = Text_Name.getText();
        String gender = "";
        if (radioButtonCustom_MEN.isSelected()) {
            gender = "Men";
        }
        else if (radioButtonCustom_WOMEN.isSelected()){
            gender = "Women";
        }
        else {
            gender = "None";
        }
        String adr = Text_Address.getText();
        String bp = Text_Birthplace.getText();
        
        SelectedDate d = date.getSelectedDate();
        String bd = (d.getYear() + "-" + d.getMonth() + "-" + d.getDay());
        
        String ac = combobox_Academic.getSelectedItem().toString();
        String dp = combobox_Department.getSelectedItem().toString();
        String rl = combobox_ROLE.getSelectedItem().toString();
        
        DateTimeFormatter dft= DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now=LocalDateTime.now();
        String nowdate=dft.format(now);
        
        
        
        
        Staff stf = new Staff(id,name, gender, adr, bp, bd, ac, dp,rl);
        // thêm mới vào bảng employee
        Staff_Modify.insert(stf);
        // thêm vào quản lý role
        RoleManagement rlmn = new RoleManagement(stf.getId(),stf.getHoten(),rl,nowdate,nowdate);
        RoleManagement_Modify.insert(rlmn);
        
        List<Skill> skillList = jListSkill.getSelectedValuesList();
        for(Skill skill : skillList){

            SkillManagement skillmanagement = new SkillManagement(stf.getId(),stf.getHoten(),skill.getName(),"","");
            SkillManagement_Modify.insert(skillmanagement);
        }
        
        ID_Generate1++;
        Text_ID.setText(String.valueOf(ID_Generate1));
        IDGenerate_Modify.update(ID_Generate1);
        btnSave.setEnabled(false);
        btnEsc.setEnabled(false);
        btnAdd.setEnabled(true);
        Text_Address.setText("");
        Text_BirthDate.setText("");
        Text_Birthplace.setText("");
        Text_Name.setText("");
        jListSkill.clearSelection();
        radioButtonCustom_MEN.setSelected(false);
        radioButtonCustom_WOMEN.setSelected(false);
        radioButtonCustom_MEN.setEnabled(false);
        radioButtonCustom_WOMEN.setEnabled(false);
        Text_Address.setEnabled(false);
        Text_BirthDate.setEnabled(false);
        Text_Birthplace.setEnabled(false);
        Text_Name.setEnabled(false);
        combobox_Academic.setEnabled(false);
        combobox_Department.setEnabled(false);
        combobox_ROLE.setEnabled(false);
        radioButtonCustom_MEN.setEnabled(false);
        radioButtonCustom_WOMEN.setEnabled(false);
        jListSkill.setEnabled(false);
        combobox_Academic.setSelectedIndex(-1);
        combobox_Department.setSelectedIndex(-1);
        combobox_ROLE.setSelectedIndex(-1);
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscActionPerformed
        btnAdd.setEnabled(true);
        btnSave.setEnabled(false);
        Text_Address.setText("");
        Text_BirthDate.setText("");
        Text_Birthplace.setText("");
        Text_Name.setText("");
        radioButtonCustom_MEN.setSelected(false);
        radioButtonCustom_WOMEN.setSelected(false);
        radioButtonCustom_MEN.setEnabled(false);
        radioButtonCustom_WOMEN.setEnabled(false);
        btnEsc.setEnabled(false);
        btnSave.setEnabled(false);
        Text_Address.setEnabled(false);
        Text_BirthDate.setEnabled(false);
        Text_Birthplace.setEnabled(false);
        Text_Name.setEnabled(false);
        combobox_Academic.setEnabled(false);
        combobox_Department.setEnabled(false);
        combobox_ROLE.setEnabled(false);
        radioButtonCustom_MEN.setEnabled(false);
        radioButtonCustom_WOMEN.setEnabled(false);
        jListSkill.setEnabled(false);
        combobox_Academic.setSelectedIndex(-1);
        combobox_Department.setSelectedIndex(-1);
        combobox_ROLE.setSelectedIndex(-1);
        jListSkill.clearSelection();
        

    }//GEN-LAST:event_btnEscActionPerformed

    private void radioButtonCustom_MENActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonCustom_MENActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioButtonCustom_MENActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.TextField Text_Address;
    private com.raven.swing.TextField Text_BirthDate;
    private com.raven.swing.TextField Text_Birthplace;
    private com.raven.swing.TextField Text_ID;
    private com.raven.swing.TextField Text_Name;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEsc;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.raven.swing.Combobox<Academiclevel> combobox_Academic;
    private com.raven.swing.Combobox<Department> combobox_Department;
    private com.raven.swing.Combobox<Role> combobox_ROLE;
    private com.raven.datechooser.DateChooser date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<Skill> jListSkill;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBarSex;
    private com.raven.swing.RadioButtonCustom radioButtonCustom_MEN;
    private com.raven.swing.RadioButtonCustom radioButtonCustom_WOMEN;
    // End of variables declaration//GEN-END:variables
}
