package com.raven.form;

import Login.EventCallBack;
import Login.EventTextField;
import Model.Bonus;
import Model.Bonus_Modify;
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
import Model.SalaryMa;
import Model.SalaryMa_Modify;
import Model.Skill;
import Model.SkillManagement;
import Model.SkillManagement_Modify;
import Model.Skill_Modify;
import Model.Staff;
import Model.Staff_Modify;
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


public class Bonus_Edit extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    Calendar cal = new GregorianCalendar();
    static String PreBonuslevel="";
    List<Bonus> bonusList = new ArrayList<>();
 static boolean insertbutton=false; 
 static boolean updatebutton=false; 

static boolean checkBonuslevel=false; 
static boolean checkBonuslevelInsert=false; 

    public Bonus_Edit() {
        initComponents();
        tableModel = (DefaultTableModel) table1.getModel();
        setOpaque(false);
        showBonus();
        Search();
        Text_BonusID.setEnabled(false);
        Text_BonusLevel.setEnabled(false);
        Text_BonusMoney.setEnabled(false);
        Text_BonusDate.setEnabled(false);
        btnEdit.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnEsc.setEnabled(false);
        btnDelete.setEnabled(false);
    }

    public void showBonus() {
        List<Bonus> bonusManagementList = Bonus_Modify.findAll();
        tableModel.setRowCount(0);
        bonusManagementList.forEach((bonus) -> {
            tableModel.addRow(new Object[]{bonus.getBonus_ID(), bonus.getBonus_Level(), bonus.getBonus_Money(), bonus.getBonus_Date()});
        });

        Text_BonusDate.setText("");
    }


   private void Search(){
        SearchTextField.addEvent(new EventTextField() {
            @Override
            public void onPressed(EventCallBack call) {
               String input = SearchTextField.getText();
        if (input != null && input.length() > 0){
            bonusList = Bonus_Modify.findByName(input);
            tableModel.setRowCount(0);
        
        bonusList.forEach((bonus) -> {
            tableModel.addRow(new Object[] {bonus.getBonus_ID(), bonus.getBonus_Level(), bonus.getBonus_Money(), bonus.getBonus_Date()} );
        });
        }  
        else showBonus();

            }

            @Override
            public void onCancel() {
                showBonus();
            }
        });
    }


    public void checkExistBonus(String bonusname) {
         List<Bonus> bonusManagementList = Bonus_Modify.findAll(); 
          bonusManagementList.forEach((bonus) -> {
             if(bonusname.equalsIgnoreCase(bonus.getBonus_Level()) && !bonusname.equalsIgnoreCase(PreBonuslevel)){
                 checkBonuslevel=true;
             }
        });
    }

    public void checkExistBonusInsertContract(String bonusname) {
         List<Bonus> bonusManagementList = Bonus_Modify.findAll();
          bonusManagementList.forEach((bonus) -> {
             if(bonusname.equalsIgnoreCase(bonus.getBonus_Level())){
                 checkBonuslevelInsert=true;
             }
        });
    }
    
      public boolean checkBonusSalaryManagement(String bonusname){
        List<SalaryMa> salarymanageList = SalaryMa_Modify.findAll();
          for(SalaryMa salarymanage : salarymanageList ){
               if( salarymanage.getBonusLevel().equalsIgnoreCase(bonusname)){
                   return true;
               }
        }
          return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BONUSDATE = new com.raven.datechooser.DateChooser();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        Text_BonusDate = new com.raven.swing.TextField();
        Text_BonusMoney = new com.raven.swing.TextField();
        Text_BonusID = new com.raven.swing.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.raven.swing.table.Table();
        Text_BonusLevel = new com.raven.swing.TextField();
        SearchTextField = new Login.TextFieldAnimation();
        jToolBar2 = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnEsc = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        BONUSDATE.setForeground(new java.awt.Color(0, 153, 247));
        BONUSDATE.setDateFormat("yyyy-MM-dd");
        BONUSDATE.setTextRefernce(Text_BonusDate);

        setPreferredSize(new java.awt.Dimension(1726, 820));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("BONUS  MANGEMENT");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(76, 76, 76));
        jLabel5.setText("Data Bonus");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        Text_BonusDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_BonusDate.setLabelText("BONUS DATE");
        Text_BonusDate.setLineColor(new java.awt.Color(0, 0, 0));

        Text_BonusMoney.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_BonusMoney.setLabelText("BONUS MONEY");
        Text_BonusMoney.setLineColor(new java.awt.Color(0, 0, 0));

        Text_BonusID.setEditable(false);
        Text_BonusID.setBackground(new java.awt.Color(255, 255, 255));
        Text_BonusID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_BonusID.setLabelText("BONUS ID");
        Text_BonusID.setLineColor(new java.awt.Color(0, 0, 0));

        jScrollPane1.setBorder(null);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "BONUS ID", "BONUS NAME", "BONUS MONEY", "BONUS DATE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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

        Text_BonusLevel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Text_BonusLevel.setLabelText("BONUS LEVEL");
        Text_BonusLevel.setLineColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Text_BonusLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Text_BonusID, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Text_BonusMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Text_BonusDate, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Text_BonusID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Text_BonusLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Text_BonusMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Text_BonusDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        btnAdd.setEnabled(false);
        btnEdit.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnEsc.setEnabled(true);
        btnDelete.setEnabled(false);
        Text_BonusID.setEnabled(true);
        Text_BonusLevel.setEnabled(true);
        Text_BonusMoney.setEnabled(true);
        Text_BonusDate.setEnabled(true);
        insertbutton=true;
        Text_BonusID.setText("");
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
        Text_BonusID.setEnabled(true);
        Text_BonusLevel.setEnabled(true);
        Text_BonusMoney.setEnabled(true);
        Text_BonusDate.setEnabled(true);
        updatebutton=true;
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if(insertbutton==true){
             String bonuslevel = Text_BonusLevel.getText();
        int money = Integer.parseInt(Text_BonusMoney.getText());

        String day = Text_BonusDate.getText();

        Bonus bon = new Bonus(bonuslevel, money, day);
        checkExistBonusInsertContract(bonuslevel);
        if(checkBonuslevelInsert==true){
              JOptionPane.showMessageDialog(null,"BONUS LEVEL  ALREADY EXISTS"+":"+bonuslevel,"",2);
        } else{
             Bonus_Modify.insert(bon);
             showBonus();
        }
       
        Text_BonusID.setText("");
        Text_BonusLevel.setText("");
        Text_BonusMoney.setText("");
        Text_BonusDate.setText("");
        checkBonuslevelInsert=false;
        } else if(updatebutton==true){
            int id = Integer.valueOf(Text_BonusID.getText());
        String level = Text_BonusLevel.getText();
        int money = Integer.valueOf(Text_BonusMoney.getText());
        String dayy = Text_BonusDate.getText();

        Bonus bon = new Bonus(id, level, money, dayy);
        checkExistBonus(level);
        if(checkBonuslevel=true){
              JOptionPane.showMessageDialog(null,"BONUS LEVEL  ALREADY EXISTS"+":"+level,"",2);
        } else{
             Bonus_Modify.update(bon);
             showBonus();
        }
       
        Text_BonusID.setText("");
        Text_BonusLevel.setText("");
        Text_BonusMoney.setText("");
        Text_BonusDate.setText("");
        PreBonuslevel="";
        checkBonuslevel=false;
        }
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnEsc.setEnabled(false);
        btnDelete.setEnabled(false);
        updatebutton=false;
        insertbutton=false;
        Text_BonusID.setEnabled(false);
        Text_BonusLevel.setEnabled(false);
        Text_BonusMoney.setEnabled(false);
        Text_BonusDate.setEnabled(false);

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnEscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscActionPerformed
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnEsc.setEnabled(false);
        btnDelete.setEnabled(false);
        updatebutton=false;
        insertbutton=false;
        Text_BonusID.setEnabled(false);
        Text_BonusLevel.setEnabled(false);
        Text_BonusMoney.setEnabled(false);
        Text_BonusDate.setEnabled(false);   
        Text_BonusID.setText("");
        Text_BonusLevel.setText("");
        Text_BonusMoney.setText("");
        Text_BonusDate.setText("");
        table1.clearSelection();
    }//GEN-LAST:event_btnEscActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        int row = table1.getSelectedRow();
        String bonusname= String.valueOf(table1.getValueAt(row, 1));

        int respone=JOptionPane.showConfirmDialog(this,"Do you want to continue delete bonus ?", "CONFIRM",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(respone==JOptionPane.YES_OPTION){
            if(  checkBonusSalaryManagement(bonusname)){
                JOptionPane.showMessageDialog(null,"YOU MUST UPDATE CURRENT EMPLOYEE SALARY MANAGEMENT:"+""+bonusname,"",2);
            } else{
                Bonus_Modify.delete(bonusname);
            }
        } else if(respone==JOptionPane.NO_OPTION){

        }
         showBonus();
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnEsc.setEnabled(false);
        btnDelete.setEnabled(false);
        updatebutton=false;
        insertbutton=false;
        Text_BonusID.setEnabled(false);
        Text_BonusLevel.setEnabled(false);
        Text_BonusMoney.setEnabled(false);
        Text_BonusDate.setEnabled(false);   
        Text_BonusID.setText("");
        Text_BonusLevel.setText("");
        Text_BonusMoney.setText("");
        Text_BonusDate.setText("");
        table1.clearSelection();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        btnEdit.setEnabled(true);    
         btnDelete.setEnabled(true);
        int row = table1.getSelectedRow();
        
        int level = Integer.valueOf(String.valueOf(table1.getValueAt(row, 0))); // lấy đc id
        Bonus bonus = Bonus_Modify.getBonusId(level);

        Text_BonusID.setText(String.valueOf(bonus.getBonus_ID()));
        Text_BonusLevel.setText(String.valueOf(bonus.getBonus_Level()));
        Text_BonusMoney.setText(String.valueOf(bonus.getBonus_Money()));
        Text_BonusDate.setText(String.valueOf(bonus.getBonus_Date()));
        PreBonuslevel=bonus.getBonus_Level();
    }//GEN-LAST:event_table1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.datechooser.DateChooser BONUSDATE;
    private Login.TextFieldAnimation SearchTextField;
    private com.raven.swing.TextField Text_BonusDate;
    private com.raven.swing.TextField Text_BonusID;
    private com.raven.swing.TextField Text_BonusLevel;
    private com.raven.swing.TextField Text_BonusMoney;
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
