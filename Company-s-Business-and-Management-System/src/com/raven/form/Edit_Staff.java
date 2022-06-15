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
import com.raven.component.Card_EditStaffInfo;
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
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import scrollbar.ScrollBarCustom;


public class Edit_Staff extends javax.swing.JPanel {
List<Staff> staffList = new ArrayList<>();
    DefaultTableModel tableModel;
    static Boolean flag=false;
    static Boolean skillexistflag=false;
    static String PreRole;
    static String ExistSkill="";
     Calendar cal=new GregorianCalendar();
    public Edit_Staff() {

  
        initComponents();
        setOpaque(false);

        
        showAcademiclevel();
        showDepartment();
        showRole();
        showSKILL();
    
        tableModel = (DefaultTableModel) table1.getModel();
         jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        combobox_Academic1.setSelectedIndex(-1);
        combobox_Department1.setSelectedIndex(-1);
        combobox_Role1.setSelectedIndex(-1);
        Text_ID.setEnabled(false);
        Text_Name.setEnabled(false);
        Text_Address.setEnabled(false);
        Text_BirthDate.setEnabled(false);
        Text_Birthplace.setEnabled(false);       
        combobox_Academic1.setEnabled(false);
        combobox_Department1.setEnabled(false);
        combobox_Role1.setEnabled(false);
        btnSave.setEnabled(false);
 
        btnEsc.setEnabled(false);
        jListSkill.setEnabled(false);
        radioButtonCustom_MEN.setEnabled(false);
        radioButtonCustom_WOMEN.setEnabled(false);
        radioButtonCustom_MEN.setSelected(false);
        radioButtonCustom_WOMEN.setSelected(false);
        showStaff();
        Search();
        Text_BirthDate.setText("");
            

    }

   private void showStaff(){
        List<Staff> staffList = Staff_Modify.findAll();
        
        tableModel.setRowCount(0);
        
        staffList.forEach(staff -> {
            tableModel.addRow(new Object[] {staff.getId(), staff.getHoten(),
                staff.getGioitinh(), staff.getDiachithuongtru(),staff.getNoisinh(), staff.getTrinhdohocvan(),
                staff.getPhongban() } );
        });
    }
    
    public void setData(ModelCard data) {
        DecimalFormat df = new DecimalFormat("#,##0.##");
     
       
     
        
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
                staff.getGioitinh(), staff.getDiachithuongtru(),staff.getNoisinh(), staff.getTrinhdohocvan(),
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
    
    
    
    
    
    
    
    
    
       public void showAcademiclevel(){
         List<Academiclevel> academicList = Academiclevel_Modify.findAll();
         for(Academiclevel acl :academicList ){
             combobox_Academic1.addItem(acl);
         }
    }
    
     public void showDepartment(){
         List<Department> departmentList = Department_Modify.findAll();
         for(Department dpt :departmentList){
             combobox_Department1.addItem(dpt);
         }
    }
     
      public void showRole(){
         List<Role> roleList = Role_Modify.findAll();
         for(Role rol :roleList){
             combobox_Role1.addItem(rol);
         }
    }
      
       public void showSKILL(){
         DefaultListModel<Skill> listModel= new DefaultListModel();
     
         List<Skill> skillList = Skill_Modify.findAll();
         for(Skill skill :skillList ){
            listModel.addElement(new Skill(skill.getName()));
         }
         jListSkill.setModel(listModel);
    }
      
      public void AcademicIndex(Staff stf){
              
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
       
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from academic_level";
            int AcademicId=0 ;
            String AcademicName=stf.getTrinhdohocvan();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                 if(resultSet.getString("Academic_Name").equalsIgnoreCase(AcademicName)){
                      combobox_Academic1.setSelectedIndex(AcademicId);
                      break;
                } else{
                    AcademicId++;
                }
                
             
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(Card_EditStaffInfo.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
      
       public void DepartmentIndex(Staff stf){
              
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
       
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from department ";
            int DepartmentId=0 ;
            String DepartmentName=stf.getPhongban();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
          
            while (resultSet.next()) {
                 if(resultSet.getString("DepartmentName").equalsIgnoreCase(DepartmentName)){
                       combobox_Department1.setSelectedIndex(DepartmentId);
                      break;
                } else{
                    DepartmentId++;
                }
                
               
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(Card_EditStaffInfo.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
       
        public void RoleIndex(Staff stf){
              
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
       
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
            String sql = "select * from role ";
            int RoleId=0 ;
            String RoleName=stf.getChucvuhientai();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
          
            while (resultSet.next()) {
                 if(resultSet.getString("RoleName").equalsIgnoreCase(RoleName)){
                      combobox_Role1.setSelectedIndex(RoleId);
                      break;
                } else{
                    RoleId++;
                }
           
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(Card_EditStaffInfo.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
    
        
         public boolean CheckExistRole(int IDStaff, String RoleStaff){
        List<RoleManagement> rolemanagementList = RoleManagement_Modify.findAll();
        
        rolemanagementList.forEach((role) -> {
            if(role.getID()==IDStaff && role.getRole().equalsIgnoreCase(RoleStaff)){
              flag=true;
            }
             
        });
         
           return flag;
     
     }
         
         public boolean CheckExistSkillwithID(int id, ArrayList<String> skillname){
               List<SkillManagement> skillmanagementList = SkillManagement_Modify.findAll();
              
       skillmanagementList.forEach((skill) -> {
                skillname.forEach((choosenskill)->{
                    if(skill.getID()==id && skill.getStaffSkill().equalsIgnoreCase(choosenskill)){
                    ExistSkill+=choosenskill+",";
            }
                });
             
        });
       
          if(ExistSkill!=""){
              return true;
           }
        
            return false;
         }
         
         public boolean CheckExistSkill(int id){
            List<Skill> skillList = jListSkill.getSelectedValuesList();
            ArrayList<String> skillname = new ArrayList<String>();
        for(Skill skill : skillList){
            skillname.add(skill.getName());
            
        }
        if(CheckExistSkillwithID(id,skillname)){ 
           
            return true;
        } 
          return false;
         }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupsex = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.raven.swing.table.Table();
        SearchTextField = new Login.TextFieldAnimation();
        jToolBar2 = new javax.swing.JToolBar();
        btnUpdate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnEsc = new javax.swing.JButton();
        combobox_Role1 = new com.raven.swing.Combobox<>();
        Text_Name = new com.raven.swing.TextField();
        Text_BirthDate = new com.raven.swing.TextField();
        Text_Birthplace = new com.raven.swing.TextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListSkill = new javax.swing.JList<>();
        Text_ID = new com.raven.swing.TextField();
        combobox_Academic1 = new com.raven.swing.Combobox<>();
        combobox_Department1 = new com.raven.swing.Combobox<>();
        Text_Address = new com.raven.swing.TextField();
        jToolBarsex = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        radioButtonCustom_MEN = new com.raven.swing.RadioButtonCustom();
        radioButtonCustom_WOMEN = new com.raven.swing.RadioButtonCustom();

        setPreferredSize(new java.awt.Dimension(1726, 820));

        jScrollPane1.setBorder(null);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "HỌ TÊN"
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

        jToolBar2.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar2.setBorder(null);
        jToolBar2.setForeground(new java.awt.Color(255, 255, 255));
        jToolBar2.setRollover(true);
        jToolBar2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/Edit.png"))); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.setIconTextGap(15);
        btnUpdate.setMargin(new java.awt.Insets(2, 16, 2, 16));
        btnUpdate.setMaximumSize(new java.awt.Dimension(129, 33));
        btnUpdate.setMinimumSize(new java.awt.Dimension(119, 33));
        btnUpdate.setOpaque(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jToolBar2.add(btnUpdate);

        btnSave.setBackground(new java.awt.Color(255, 255, 255));
        btnSave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/Tick.png"))); // NOI18N
        btnSave.setText("SAVE");
        btnSave.setIconTextGap(15);
        btnSave.setMargin(new java.awt.Insets(2, 16, 2, 16));
        btnSave.setMaximumSize(new java.awt.Dimension(129, 33));
        btnSave.setMinimumSize(new java.awt.Dimension(119, 33));
        btnSave.setPreferredSize(new java.awt.Dimension(127, 33));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jToolBar2.add(btnSave);

        btnEsc.setBackground(new java.awt.Color(255, 255, 255));
        btnEsc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEsc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/Stop.png"))); // NOI18N
        btnEsc.setText("EXIT");
        btnEsc.setFocusable(false);
        btnEsc.setHideActionText(true);
        btnEsc.setIconTextGap(15);
        btnEsc.setMargin(new java.awt.Insets(2, 16, 2, 16));
        btnEsc.setMaximumSize(new java.awt.Dimension(129, 33));
        btnEsc.setMinimumSize(new java.awt.Dimension(119, 33));
        btnEsc.setPreferredSize(new java.awt.Dimension(127, 33));
        btnEsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscActionPerformed(evt);
            }
        });
        jToolBar2.add(btnEsc);

        combobox_Role1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        combobox_Role1.setLabeText("ROLE");
        combobox_Role1.setLineColor(new java.awt.Color(0, 0, 0));

        Text_Name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_Name.setLabelText("NAME");
        Text_Name.setLineColor(new java.awt.Color(0, 0, 0));

        Text_BirthDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_BirthDate.setLabelText("DAY OF BIRTH");
        Text_BirthDate.setLineColor(new java.awt.Color(0, 0, 0));

        Text_Birthplace.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_Birthplace.setLabelText("BIRTH PLACE");

        jListSkill.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SKILL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(109, 109, 109))); // NOI18N
        jListSkill.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(jListSkill);

        Text_ID.setEditable(false);
        Text_ID.setBackground(new java.awt.Color(255, 255, 255));
        Text_ID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_ID.setLabelText("ID");
        Text_ID.setLineColor(new java.awt.Color(0, 0, 0));

        combobox_Academic1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        combobox_Academic1.setLabeText("ACADEMIC BANCHELOR");
        combobox_Academic1.setLineColor(new java.awt.Color(0, 0, 0));

        combobox_Department1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        combobox_Department1.setLabeText("DEPARTMENT");
        combobox_Department1.setLineColor(new java.awt.Color(0, 0, 0));

        Text_Address.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_Address.setLabelText("ADDRESS");
        Text_Address.setLineColor(new java.awt.Color(0, 0, 0));

        jToolBarsex.setBackground(new java.awt.Color(255, 255, 255));
        jToolBarsex.setBorder(null);
        jToolBarsex.setForeground(new java.awt.Color(255, 255, 255));
        jToolBarsex.setRollover(true);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(109, 109, 109));
        jLabel1.setText("GENDER");
        jToolBarsex.add(jLabel1);

        buttonGroupsex.add(radioButtonCustom_MEN);
        radioButtonCustom_MEN.setText("MEN");
        radioButtonCustom_MEN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jToolBarsex.add(radioButtonCustom_MEN);

        buttonGroupsex.add(radioButtonCustom_WOMEN);
        radioButtonCustom_WOMEN.setText("WOMEN");
        radioButtonCustom_WOMEN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jToolBarsex.add(radioButtonCustom_WOMEN);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Text_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94)
                                .addComponent(combobox_Role1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Text_Address, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jToolBarsex, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(combobox_Department1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(combobox_Academic1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(94, 94, 94)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Text_BirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Text_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Text_Birthplace, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                            .addComponent(SearchTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Text_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combobox_Role1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combobox_Academic1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Text_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combobox_Department1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Text_BirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Text_Address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Text_Birthplace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToolBarsex, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        int row = table1.getSelectedRow();
        int stfId = Integer.valueOf(String.valueOf(table1.getValueAt(row, 0))); // lấy đc id
        Staff stf = Staff_Modify.getStaffId(stfId);
        Text_ID.setText(String.valueOf(stf.getId()));
        Text_Name.setText(String.valueOf(stf.getHoten()));
        Text_Address.setText(String.valueOf(stf.getDiachithuongtru()));
        Text_BirthDate.setText(String.valueOf(stf.getNgaysinh()));
        Text_Birthplace.setText(String.valueOf(stf.getNoisinh()));
        AcademicIndex(stf);
        DepartmentIndex(stf);
        RoleIndex(stf);
        String gender=stf.getGioitinh();
        if(gender.equalsIgnoreCase("Men")){
            radioButtonCustom_MEN.setSelected(true);
        } else{
            radioButtonCustom_WOMEN.setSelected(true);
        }
        PreRole = combobox_Role1.getSelectedItem().toString();// lấy prerole
    }//GEN-LAST:event_table1MouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        btnUpdate.setEnabled(false);
        Text_ID.setEnabled(true);
        Text_Name.setEnabled(true);
        Text_Address.setEnabled(true);
        Text_BirthDate.setEnabled(true);
        Text_Birthplace.setEnabled(true);
        combobox_Academic1.setEnabled(true);
        combobox_Department1.setEnabled(true);
        combobox_Role1.setEnabled(true);
        btnSave.setEnabled(true);
        jToolBarsex.setEnabled(true);
        btnEsc.setEnabled(true);
        radioButtonCustom_MEN.setEnabled(true);
        radioButtonCustom_WOMEN.setEnabled(true);
        jListSkill.setEnabled(true);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        int id = Integer.valueOf(Text_ID.getText());
        String name = Text_Name.getText();
        String gender = "";
        String ac = combobox_Academic1.getSelectedItem().toString();
        String dp = combobox_Department1.getSelectedItem().toString();
        String rl = combobox_Role1.getSelectedItem().toString();
        String adr = Text_Address.getText();
        String bp = Text_Birthplace.getText();
        String bd = Text_BirthDate.getText();

        if (radioButtonCustom_MEN.isSelected()) {
            gender = "Men";
        }
        else if (radioButtonCustom_WOMEN.isSelected()){
            gender = "Women";
        }
        else {
            gender = "None";
        }
        //checkskill
        if(CheckExistSkill(id)){
            JOptionPane.showMessageDialog(null,"SKILL ALREADY EXIST"+":"+ExistSkill,"",2);// skill trùng
            ExistSkill="";
         
            
        }else if(rl!=PreRole){
            if(CheckExistRole(id,rl)){
                Staff stf = new Staff(id,name, gender, adr, bp, bd, ac, dp,rl);
                Staff_Modify.update(stf);
                List<Skill> skillList = jListSkill.getSelectedValuesList();
                for(Skill skill : skillList){
                    SkillManagement skillmanagement = new SkillManagement(stf.getId(),stf.getHoten(),skill.getName(),"","");
                    SkillManagement_Modify.insert(skillmanagement);
                }

            } else{

                Staff stf = new Staff(id,name, gender, adr, bp, bd, ac, dp,rl);
                Staff_Modify.update(stf);

                DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDateTime now=LocalDateTime.now();
                String nowdate=(dtf.format(now));
                RoleManagement rlmn = new RoleManagement(stf.getId(),stf.getHoten(),rl,nowdate,nowdate);
                RoleManagement_Modify.insert(rlmn);

                List<Skill> skillList = jListSkill.getSelectedValuesList();
                for(Skill skill : skillList){

                    SkillManagement skillmanagement = new SkillManagement(stf.getId(),stf.getHoten(),skill.getName(),"","");
                    SkillManagement_Modify.insert(skillmanagement);
                }

                Connection connection = null;
                PreparedStatement statement,statement2,statement3 = null;
                try {
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
                    String sql = "update staffrolemanagement set STAFFNAME=? where ID = ?";
                    String sql2 = "update levelofskill set StaffName=? where StaffID = ?";
                    String sql3 = "update employee set Role=? where Employee_ID  = ?";
                    statement = connection.prepareCall(sql);
                    statement.setString(1, stf.getHoten());
                    statement.setString(2, String.valueOf(stf.getId()));

                    statement2 = connection.prepareCall(sql2);
                    statement2.setString(1, stf.getHoten());
                    statement2.setString(2, String.valueOf(stf.getId()));

                    statement3 = connection.prepareCall(sql3);
                    statement3.setString(1, stf.getChucvuhientai());
                    statement3.setString(2, String.valueOf(stf.getId()));

                    statement.execute();
                    statement2.execute();
                    statement3.execute();
                } catch (SQLException ex) {
                    Logger.getLogger(Staff_Modify.class.getName()).log(Level.SEVERE, null, ex);
                }
                
        Text_ID.setEnabled(false);
        Text_Name.setEnabled(false);
        Text_Address.setEnabled(false);
        Text_BirthDate.setEnabled(false);
        Text_Birthplace.setEnabled(false); 
        Text_ID.setText("");
        Text_Name.setText("");
        Text_Address.setText("");
        Text_BirthDate.setText("");
        Text_Birthplace.setText("");
        combobox_Academic1.setEnabled(false);
        combobox_Department1.setEnabled(false);
        combobox_Role1.setEnabled(false);
        combobox_Academic1.setSelectedIndex(-1);
        combobox_Department1.setSelectedIndex(-1);
        combobox_Role1.setSelectedIndex(-1);
        buttonGroupsex.clearSelection();
        radioButtonCustom_MEN.setEnabled(false);
        radioButtonCustom_WOMEN.setEnabled(false);
        jListSkill.clearSelection();
        btnSave.setEnabled(false);
        btnEsc.setEnabled(false);
        jListSkill.setEnabled(false);
        btnUpdate.setEnabled(true);

            }

        } else if(rl.equalsIgnoreCase(PreRole)) {

            Staff stf = new Staff(id,name, gender, adr, bp, bd, ac, dp,rl);
            Staff_Modify.update(stf);
            List<Skill> skillList = jListSkill.getSelectedValuesList();
            for(Skill skill : skillList){
                SkillManagement skillmanagement = new SkillManagement(stf.getId(),stf.getHoten(),skill.getName(),"","");
                SkillManagement_Modify.insert(skillmanagement);
            }

            Connection connection = null;
            PreparedStatement statement,statement2,statement3 = null;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginuser", "root", "");
                String sql = "update staffrolemanagement set STAFFNAME=? where ID = ?";
                String sql2 = "update levelofskill set StaffName=? where StaffID = ?";
                String sql3 = "update employee set Role=? where Employee_ID  = ?";
                statement = connection.prepareCall(sql);
                statement.setString(1, stf.getHoten());
                statement.setString(2, String.valueOf(stf.getId()));

                statement2 = connection.prepareCall(sql2);
                statement2.setString(1, stf.getHoten());
                statement2.setString(2, String.valueOf(stf.getId()));

                statement3 = connection.prepareCall(sql3);
                statement3.setString(1, stf.getChucvuhientai());
                statement3.setString(2, String.valueOf(stf.getId()));

                statement.execute();
                statement2.execute();
                statement3.execute();

            } catch (SQLException ex) {
                Logger.getLogger(Staff_Modify.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        Text_ID.setEnabled(false);
        Text_Name.setEnabled(false);
        Text_Address.setEnabled(false);
        Text_BirthDate.setEnabled(false);
        Text_Birthplace.setEnabled(false); 
        Text_ID.setText("");
        Text_Name.setText("");
        Text_Address.setText("");
        Text_BirthDate.setText("");
        Text_Birthplace.setText("");
        combobox_Academic1.setEnabled(false);
        combobox_Department1.setEnabled(false);
        combobox_Role1.setEnabled(false);
        combobox_Academic1.setSelectedIndex(-1);
        combobox_Department1.setSelectedIndex(-1);
        combobox_Role1.setSelectedIndex(-1);
        buttonGroupsex.clearSelection();
        radioButtonCustom_MEN.setEnabled(false);
        radioButtonCustom_WOMEN.setEnabled(false);
        jListSkill.clearSelection();
        btnSave.setEnabled(false);
        btnEsc.setEnabled(false);
        jListSkill.setEnabled(false);
        btnUpdate.setEnabled(true);
        }

        showStaff();
        table1.clearSelection();
       
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscActionPerformed
        buttonGroupsex.clearSelection();
        Text_ID.setEnabled(false);
        Text_Name.setEnabled(false);
        Text_Address.setEnabled(false);
        Text_BirthDate.setEnabled(false);
        Text_Birthplace.setEnabled(false); 
        Text_ID.setText("");
        Text_Name.setText("");
        Text_Address.setText("");
        Text_BirthDate.setText("");
        Text_Birthplace.setText("");
        combobox_Academic1.setEnabled(false);
        combobox_Department1.setEnabled(false);
        combobox_Role1.setEnabled(false);
        btnSave.setEnabled(false);
        btnEsc.setEnabled(false);
        combobox_Academic1.setSelectedIndex(-1);
        combobox_Department1.setSelectedIndex(-1);
        combobox_Role1.setSelectedIndex(-1);
        btnUpdate.setEnabled(true);
   
      //  radioButtonCustom_MEN.setEnabled(false);
        //radioButtonCustom_WOMEN.setEnabled(false);
        jListSkill.clearSelection();
        jListSkill.setEnabled(false);
         table1.clearSelection();
    }//GEN-LAST:event_btnEscActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Login.TextFieldAnimation SearchTextField;
    private com.raven.swing.TextField Text_Address;
    private com.raven.swing.TextField Text_BirthDate;
    private com.raven.swing.TextField Text_Birthplace;
    private com.raven.swing.TextField Text_ID;
    private com.raven.swing.TextField Text_Name;
    private javax.swing.JButton btnEsc;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroupsex;
    private com.raven.swing.Combobox<Academiclevel> combobox_Academic1;
    private com.raven.swing.Combobox<Department> combobox_Department1;
    private com.raven.swing.Combobox<Role> combobox_Role1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<Skill> jListSkill;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBarsex;
    private com.raven.swing.RadioButtonCustom radioButtonCustom_MEN;
    private com.raven.swing.RadioButtonCustom radioButtonCustom_WOMEN;
    private com.raven.swing.table.Table table1;
    // End of variables declaration//GEN-END:variables
}
