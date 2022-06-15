package com.raven.component;

import Login.EventCallBack;
import Login.EventTextField;
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
import com.raven.model.ModelCard;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.DecimalFormat;
import Model.Staff;
import Model.Staff_Modify;
import com.raven.datechooser.SelectedDate;
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
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Card_EditStaffInfo extends javax.swing.JPanel {
  
    List<Staff> staffList = new ArrayList<>();
    DefaultTableModel tableModel;
    static Boolean flag=false;
    static Boolean skillexistflag=false;
    static String PreRole;
    static String ExistSkill="";
     Calendar cal=new GregorianCalendar();
    
    public Color getColorGradient() {
        return colorGradient;
    }

    public void setColorGradient(Color colorGradient) {
        this.colorGradient = colorGradient;
    }

    private Color colorGradient;

    public Card_EditStaffInfo() {
        initComponents();
        setOpaque(false);

        colorGradient = new Color(255, 255, 255);
        tableModel = (DefaultTableModel) table1.getModel();
        Text_ID.setEnabled(false);
        Text_Name.setEnabled(false);
        Text_Address.setEnabled(false);
        Text_BirthDate.setEnabled(false);
        Text_Birthplace.setEnabled(false);       
        combobox_Academic.setEnabled(false);
        combobox_Department1.setEnabled(false);
        combobox_Role.setEnabled(false);
        btnUpdate.setEnabled(false);
        jToolBarsex.setEnabled(false);
        btnEsc.setEnabled(false);
        showStaff();
        showAcademiclevel();
        showDepartment();
        showRole();
        showSKILL();
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
             combobox_Academic.addItem(acl);
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
             combobox_Role.addItem(rol);
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
                      combobox_Academic.setSelectedIndex(AcademicId);
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
                      combobox_Role.setSelectedIndex(RoleId);
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

        date = new com.raven.datechooser.DateChooser();
        buttonGroup1 = new javax.swing.ButtonGroup();
        Text_ID = new com.raven.swing.TextField();
        Text_Address = new com.raven.swing.TextField();
        Text_BirthDate = new com.raven.swing.TextField();
        Text_Name = new com.raven.swing.TextField();
        Text_Birthplace = new com.raven.swing.TextField();
        combobox_Department1 = new com.raven.swing.Combobox<>();
        combobox_Academic = new com.raven.swing.Combobox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.raven.swing.table.Table();
        combobox_Role = new com.raven.swing.Combobox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListSkill = new javax.swing.JList<>();
        SearchTextField = new Login.TextFieldAnimation();
        jToolBar2 = new javax.swing.JToolBar();
        btnEdit = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnEsc = new javax.swing.JButton();
        jToolBarsex = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        radioButtonCustom_MEN = new com.raven.swing.RadioButtonCustom();
        radioButtonCustom_WOMEN = new com.raven.swing.RadioButtonCustom();

        date.setForeground(new java.awt.Color(0, 153, 247));
        date.setDateFormat("yyyy-MM-dd");
        date.setTextRefernce(Text_BirthDate);

        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        Text_ID.setEditable(false);
        Text_ID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_ID.setLabelText("ID");
        Text_ID.setLineColor(new java.awt.Color(0, 0, 0));

        Text_Address.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_Address.setLabelText("ADDRESS");
        Text_Address.setLineColor(new java.awt.Color(0, 0, 0));

        Text_BirthDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_BirthDate.setLabelText("DAY OF BIRTH");
        Text_BirthDate.setLineColor(new java.awt.Color(0, 0, 0));

        Text_Name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_Name.setLabelText("NAME");
        Text_Name.setLineColor(new java.awt.Color(0, 0, 0));

        Text_Birthplace.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_Birthplace.setLabelText("BIRTH PLACE");

        combobox_Department1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        combobox_Department1.setLabeText("DEPARTMENT");
        combobox_Department1.setLineColor(new java.awt.Color(0, 0, 0));

        combobox_Academic.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        combobox_Academic.setLabeText("ACADEMIC BANCHELOR");
        combobox_Academic.setLineColor(new java.awt.Color(0, 0, 0));

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
        table1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
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

        jListSkill.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SKILL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(109, 109, 109))); // NOI18N
        jListSkill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jScrollPane2.setViewportView(jListSkill);

        jToolBar2.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar2.setBorder(null);
        jToolBar2.setForeground(new java.awt.Color(255, 255, 255));
        jToolBar2.setRollover(true);
        jToolBar2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnEdit.setBackground(new java.awt.Color(255, 255, 255));
        btnEdit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/Edit.png"))); // NOI18N
        btnEdit.setText("UPDATE");
        btnEdit.setIconTextGap(15);
        btnEdit.setMargin(new java.awt.Insets(2, 16, 2, 16));
        btnEdit.setMaximumSize(new java.awt.Dimension(129, 33));
        btnEdit.setMinimumSize(new java.awt.Dimension(119, 33));
        btnEdit.setOpaque(false);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jToolBar2.add(btnEdit);

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/Tick.png"))); // NOI18N
        btnUpdate.setText("SAVE");
        btnUpdate.setIconTextGap(15);
        btnUpdate.setMaximumSize(new java.awt.Dimension(129, 33));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jToolBar2.add(btnUpdate);

        btnEsc.setBackground(new java.awt.Color(255, 255, 255));
        btnEsc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

        jToolBarsex.setBackground(new java.awt.Color(255, 255, 255));
        jToolBarsex.setBorder(null);
        jToolBarsex.setForeground(new java.awt.Color(255, 255, 255));
        jToolBarsex.setRollover(true);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(109, 109, 109));
        jLabel1.setText("GENDER");
        jToolBarsex.add(jLabel1);

        buttonGroup1.add(radioButtonCustom_MEN);
        radioButtonCustom_MEN.setText("MEN");
        radioButtonCustom_MEN.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jToolBarsex.add(radioButtonCustom_MEN);

        buttonGroup1.add(radioButtonCustom_WOMEN);
        radioButtonCustom_WOMEN.setText("WOMEN");
        radioButtonCustom_WOMEN.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jToolBarsex.add(radioButtonCustom_WOMEN);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Text_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(combobox_Role, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(combobox_Department1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(combobox_Academic, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jToolBarsex, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(83, 83, 83)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Text_Birthplace, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                                        .addComponent(Text_Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Text_BirthDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(Text_Address, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(228, 228, 228)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE))
                        .addContainerGap(144, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Text_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combobox_Role, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combobox_Academic, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        Text_ID.setEnabled(true);
        Text_Name.setEnabled(true);
        Text_Address.setEnabled(true);
        Text_BirthDate.setEnabled(true);
        Text_Birthplace.setEnabled(true);       
        combobox_Academic.setEnabled(true);
        combobox_Department1.setEnabled(true);
        combobox_Role.setEnabled(true);
        btnUpdate.setEnabled(true);
        jToolBarsex.setEnabled(true);
        btnEsc.setEnabled(true);

    }//GEN-LAST:event_btnEditActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int id = Integer.valueOf(Text_ID.getText());
        String name = Text_Name.getText();
        String gender = "";
        String ac = combobox_Academic.getSelectedItem().toString();
        String dp = combobox_Department1.getSelectedItem().toString();
        String rl = combobox_Role.getSelectedItem().toString();
        String adr = Text_Address.getText();
        String bp = Text_Birthplace.getText();
        String bd = Text_BirthDate.getText();
        
         if (radioButtonCustom_MEN.isSelected()) {
            gender = "Nam";
        }
        else if (radioButtonCustom_WOMEN.isSelected()){
            gender = "Nữ";
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
           
 
           DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy/MM/dd");
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
              
              
              
              
              
          }
          
         
          showStaff();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnEscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscActionPerformed
 
        btnEdit.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnEsc.setEnabled(false);

    }//GEN-LAST:event_btnEscActionPerformed

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
        if(gender.equalsIgnoreCase("nam")){
            radioButtonCustom_MEN.setSelected(true);
        } else{
            radioButtonCustom_WOMEN.setSelected(true);
        }
        PreRole = combobox_Role.getSelectedItem().toString();// lấy prerole
    }//GEN-LAST:event_table1MouseClicked

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gra = new GradientPaint(0, getHeight(), getBackground(), getWidth(), 0, colorGradient);
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Login.TextFieldAnimation SearchTextField;
    private com.raven.swing.TextField Text_Address;
    private com.raven.swing.TextField Text_BirthDate;
    private com.raven.swing.TextField Text_Birthplace;
    private com.raven.swing.TextField Text_ID;
    private com.raven.swing.TextField Text_Name;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnEsc;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.raven.swing.Combobox<Academiclevel> combobox_Academic;
    private com.raven.swing.Combobox<Department> combobox_Department1;
    private com.raven.swing.Combobox<Role> combobox_Role;
    private com.raven.datechooser.DateChooser date;
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
