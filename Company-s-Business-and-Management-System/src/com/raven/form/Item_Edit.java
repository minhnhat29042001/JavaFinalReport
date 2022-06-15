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
import Model.Item;
import Model.ItemType;
import Model.ItemType_Modify;
import Model.Item_Modify;
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
import Model.Supplier;
import Model.Supplier_Modify;
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

public class Item_Edit extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    Calendar cal = new GregorianCalendar();
    static String PreItem="";

    static boolean checkItem=false; 
    static boolean checkItemInsert=false; 
    List<Item> itemList = new ArrayList<>();

    public Item_Edit() {
        initComponents();
        tableModel = (DefaultTableModel) table1.getModel();
        setOpaque(false);
    //    showItem();
   //     showItemTypeCombobox();
      //  showSupplierCombobox();
      //  Search();
    }
/*
    public void showItem() {
        List<Item> itemManagementList =Item_Modify.findAll();
        tableModel.setRowCount(0);
        itemManagementList.forEach((item) -> {
            tableModel.addRow(new Object[]{item.getItem_ID(),item.getItem_Name(),item.getItem_Unit(),item.getItem_Type(),item.getItem_Suplier(),item.getPrice(),item.getItem_Date()});
        });
    }

    public void showItemTypeCombobox(){
       List<ItemType> ItemTypeManagementList = ItemType_Modify.findAll();
      
       for(ItemType itemtype :ItemTypeManagementList){
           combobox_ItemType1.addItem(itemtype.getItemTypeName());
        }
    }
    
    private void Search(){
        SearchTextField.addEvent(new EventTextField() {
            @Override
            public void onPressed(EventCallBack call) {
               String input = SearchTextField.getText();
        if (input != null && input.length() > 0){
            itemList = Item_Modify.findByName(input);
            tableModel.setRowCount(0);
        
        itemList.forEach((dpm) -> {
            tableModel.addRow(new Object[] {dpm.getItem_ID(),dpm.getItem_Name(),dpm.getItem_Unit(),dpm.getItem_Type(),dpm.getItem_Suplier(),dpm.getPrice(),dpm.getItem_Date() } );
        });
        }  
        else showItem();

            }

            @Override
            public void onCancel() {
                showItem();
            }
        });
    }
    
      public void showSupplierCombobox(){
       List<Supplier> SupplierManagementList =Supplier_Modify.findAll();
      
       for(Supplier supplier :SupplierManagementList){
           combobox_Supplier.addItem(supplier.getSuppName());
        }
    }
    
    
    

    public void checkExistItem(String itemname) {
          List<Item> itemManagementList =Item_Modify.findAll();
          itemManagementList.forEach((item) -> {
             if(itemname.equalsIgnoreCase(item.getItem_Name()) && !itemname.equalsIgnoreCase(PreItem)){
                 checkItem=true;
             }
        });
    }

    public void checkExistItemInsert(String itemname) {
        List<Item> itemManagementList =Item_Modify.findAll();
          itemManagementList.forEach((item) -> {
             if(itemname.equalsIgnoreCase(item.getItem_Name()) ){
                 checkItemInsert=true;
             }
        });
    }
    
     public void getSupplierCombobox(String suppliername) {
        
          List<Supplier> supplierManagementList =Supplier_Modify.findAll();
           int count=0;
           for(Supplier supplier :supplierManagementList){
             if(suppliername.equalsIgnoreCase(supplier.getSuppName())){
                  combobox_Supplier.setSelectedIndex(count);
             } else{
                 count++;
             }
    }
     }
     
     
       public void getItemtypeCombobox(String itemtypename) {
        
          List<ItemType> itemtypeManagementList =ItemType_Modify.findAll();
           int count=0;
           for(ItemType itemtype : itemtypeManagementList){
             if(itemtypename.equalsIgnoreCase(itemtype.getItemTypeName())){
                  combobox_ItemType1.setSelectedIndex(count);
             } else{
                 count++;
             }
    }
     }
     
 */    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PRICEDATE = new com.raven.datechooser.DateChooser();
        jLabel1 = new javax.swing.JLabel();
        SearchTextField = new Login.TextFieldAnimation();
        jToolBar2 = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnEsc = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.raven.swing.table.Table();
        text_itemID = new com.raven.swing.TextField();
        textitemName = new com.raven.swing.TextField();
        text_itemDate = new com.raven.swing.TextField();
        text_itemUnit = new com.raven.swing.TextField();
        comboboxitemSupplier = new com.raven.swing.Combobox<>();
        comboboxitemType = new com.raven.swing.Combobox<>();
        text_itemPrice = new com.raven.swing.TextField();
        button_Fix = new com.raven.swing.ButtonGradient();
        button_Insert = new com.raven.swing.ButtonGradient();
        button_Submit = new com.raven.swing.ButtonGradient();

        PRICEDATE.setForeground(new java.awt.Color(0, 153, 247));
        PRICEDATE.setDateFormat("yyyy-MM-dd");

        setPreferredSize(new java.awt.Dimension(1726, 820));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("ITEM  MANGEMENT");

        jToolBar2.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar2.setRollover(true);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/Add.png"))); // NOI18N
        btnAdd.setText("Thêm mới");
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
        btnEdit.setText("Sửa");
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
        btnUpdate.setText("Cập nhật");
        btnUpdate.setIconTextGap(15);
        btnUpdate.setMaximumSize(new java.awt.Dimension(129, 33));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jToolBar2.add(btnUpdate);

        btnEsc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/Stop.png"))); // NOI18N
        btnEsc.setText("Hủy bỏ");
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
        btnDelete.setText("Xóa");
        btnDelete.setIconTextGap(15);
        btnDelete.setMargin(new java.awt.Insets(2, 16, 2, 16));
        btnDelete.setMaximumSize(new java.awt.Dimension(129, 33));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jToolBar2.add(btnDelete);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(76, 76, 76));
        jLabel5.setText("Data Item");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jScrollPane1.setBorder(null);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "ITEM NAME", "ITEM UNIT", "ITEM TYPE", "SUPPLIER", "ITEM PRICE", "ITEM DATE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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

        text_itemID.setEditable(false);
        text_itemID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_itemID.setLabelText("ITEM ID");
        text_itemID.setLineColor(new java.awt.Color(0, 0, 0));

        textitemName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textitemName.setLabelText("ITEM NAME");
        textitemName.setLineColor(new java.awt.Color(0, 0, 0));

        text_itemDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_itemDate.setLabelText("ITEM DATE");
        text_itemDate.setLineColor(new java.awt.Color(0, 0, 0));

        text_itemUnit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_itemUnit.setLabelText("ITEM UNIT");
        text_itemUnit.setLineColor(new java.awt.Color(0, 0, 0));

        comboboxitemSupplier.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        comboboxitemSupplier.setLabeText("ITEM SUPPLIER");
        comboboxitemSupplier.setLineColor(new java.awt.Color(0, 0, 0));
        comboboxitemSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxitemSupplierActionPerformed(evt);
            }
        });

        comboboxitemType.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        comboboxitemType.setLabeText("ITEM TYPE");
        comboboxitemType.setLineColor(new java.awt.Color(0, 0, 0));
        comboboxitemType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxitemTypeActionPerformed(evt);
            }
        });

        text_itemPrice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_itemPrice.setLabelText("ITEM PRICE");
        text_itemPrice.setLineColor(new java.awt.Color(0, 0, 0));

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

        button_Insert.setBackground(new java.awt.Color(255, 255, 255));
        button_Insert.setText("INSERT");
        button_Insert.setColor1(new java.awt.Color(194, 85, 1));
        button_Insert.setColor2(new java.awt.Color(255, 212, 99));
        button_Insert.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        button_Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_InsertActionPerformed(evt);
            }
        });

        button_Submit.setText("SUBMIT");
        button_Submit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        button_Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_SubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textitemName, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(text_itemID, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(text_itemDate, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(36, 36, 36)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(comboboxitemType, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(text_itemUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(comboboxitemSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(text_itemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(button_Fix, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(button_Submit, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 33, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_itemID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_itemUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textitemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboboxitemType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_itemDate, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboboxitemSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(text_itemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button_Fix, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_Submit, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 427, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(211, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button_InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_InsertActionPerformed
  /*      String itemname = Text_ItemName.getText();
        String itemunit=Text_ItemUnit.getText();
        int itemprice=Integer.valueOf(Text_ItemPrice.getText());
        String itemdate=Text_ItemDate.getText();
        String supplier = combobox_Supplier.getSelectedItem().toString();
        String itemtype = combobox_ItemType1.getSelectedItem().toString();
        
        Item item = new Item(Integer.valueOf(""), itemname,itemunit,itemtype,supplier,itemprice,itemdate);
        checkExistItemInsert(item.getItem_Name());
        if(checkItemInsert==true){
              JOptionPane.showMessageDialog(null,"ITEM LEVEL  ALREADY EXISTS"+":"+itemname,"",2);
        } else{
             Item_Modify.insert(item);
             showItem();
        }
       
        Text_ItemID.setText("");
        Text_ItemName.setText("");
        Text_ItemUnit.setText("");
        Text_ItemPrice.setText("");
        checkItemInsert=false;
        */
    }//GEN-LAST:event_button_InsertActionPerformed

    private void button_FixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_FixActionPerformed
     /*   int row = table1.getSelectedRow();
        button_Insert.setVisible(false);
        int itemId= Integer.valueOf(String.valueOf(table1.getValueAt(row, 0))); // lấy đc id
        Item item =Item_Modify.getItemId(itemId);

        Text_ItemID.setText(String.valueOf(item.getItem_ID()));
        Text_ItemName.setText(String.valueOf(item.getItem_Name()));
        Text_ItemUnit.setText(String.valueOf(item.getItem_Unit()));
        Text_ItemPrice.setText(String.valueOf(item.getPrice()));
        Text_ItemDate.setText(item.getItem_Date());
        getSupplierCombobox(item.getItem_Suplier());
        getItemtypeCombobox(item.getItem_Type());
        PreItem=item.getItem_Name();
*/
    }//GEN-LAST:event_button_FixActionPerformed

    private void button_SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_SubmitActionPerformed
     /*   int itemId = Integer.valueOf(Text_ItemID.getText());
        String itemname = Text_ItemName.getText();
        String itemunit=Text_ItemUnit.getText();
        int itemprice=Integer.valueOf(Text_ItemPrice.getText());
        String itemdate=Text_ItemDate.getText();
        String supplier = combobox_Supplier.getSelectedItem().toString();
        String itemtype = combobox_ItemType1.getSelectedItem().toString();
        
        Item item = new Item(itemId, itemname,itemunit,itemtype,supplier,itemprice,itemdate);

       
        checkExistItem(item.getItem_Name());
        if(checkItem=true){
              JOptionPane.showMessageDialog(null,"ITEM ALREADY EXISTS"+":"+itemname,"",2);
        } else{
             Item_Modify.update(item);
              showItem();
        }
       
        Text_ItemID.setText("");
        Text_ItemName.setText("");
        Text_ItemUnit.setText("");
        Text_ItemPrice.setText("");
        PreItem="";
        checkItem=false;
        */
    }//GEN-LAST:event_button_SubmitActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        btnAdd.setEnabled(false);
        btnEdit.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnEsc.setEnabled(true);
        btnDelete.setEnabled(false);
        text_itemID.setEnabled(true);
        textitemName.setEnabled(true);
        text_itemDate.setEnabled(true);
        text_itemPrice.setEnabled(true);
        text_itemUnit.setEnabled(true);
        comboboxitemType.setEnabled(true);
        comboboxitemSupplier.setEnabled(true);
        comboboxitemType.setSelectedIndex(-1);
        comboboxitemSupplier.setSelectedIndex(-1);
     //   insertbutton=true;
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
        text_itemID.setEnabled(true);
        textitemName.setEnabled(true);
        text_itemDate.setEnabled(true);
        text_itemPrice.setEnabled(true);
        text_itemUnit.setEnabled(true);
        comboboxitemType.setEnabled(true);
        comboboxitemSupplier.setEnabled(true);
       // updatebutton=true;
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
       /* if(insertbutton==true){
            String ItemName=textitemName.getText();
            String ItemUnit= text_itemUnit.getText();
            String ItemDate=text_itemDate.getText();
            int ItemPrice=Integer.valueOf(text_itemPrice.getText());
            String ItemType=comboboxitemType.getSelectedItem().toString();
            String ItemSupplier=comboboxitemSupplier.getSelectedItem().toString();
            Item insertitem=new Item(Integer.valueOf(""),ItemName,ItemUnit,ItemType,ItemSupplier,ItemPrice,ItemDate);
            checkExistitem(insertitem.getItem_Name());
            if(checkExistItem==true){
                JOptionPane.showMessageDialog(null,"ITEM ALREADY EXIST","",2);// role trùng
            }else{
                Item_Modify.insert(insertitem);
            }

            checkExistItem=false;
        } else if(updatebutton==true){
            String ItemName=textitemName.getText();
            String ItemUnit= text_itemUnit.getText();
            String ItemDate=text_itemDate.getText();
            String ItemType=comboboxitemType.getSelectedItem().toString();
            String ItemSupplier=comboboxitemSupplier.getSelectedItem().toString();
            int ItemPrice=Integer.valueOf(text_itemPrice.getText());
            Item updateitem=new Item(Integer.valueOf(text_itemID.getText()),ItemName,ItemUnit,ItemType,ItemSupplier,ItemPrice,ItemDate);
            checkExistEdititem(updateitem.getItem_Name(),PreItem);
            if(checkExistEditItem==true){
                JOptionPane.showMessageDialog(null,"ITEM ALREADY EXIST","",2);// role trùng
            }else{
                Item_Modify.update(updateitem);
            }

            checkExistEditItem=false;
            PreItem="";
        }
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnEsc.setEnabled(false);
        btnDelete.setEnabled(true);
        updatebutton=false;
        insertbutton=false;
        text_itemID.setEnabled(false);
        textitemName.setEnabled(false);
        text_itemDate.setEnabled(false);
        text_itemPrice.setEnabled(false);
        text_itemUnit.setEnabled(false);
        comboboxitemType.setEnabled(false);
        comboboxitemSupplier.setEnabled(false);
        comboboxitemType.setSelectedIndex(-1);
        comboboxitemSupplier.setSelectedIndex(-1);
        text_itemID.setText("");
        textitemName.setText("");
        text_itemDate.setText("");
        text_itemPrice.setText("");
        text_itemUnit.setText("");
*/
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnEscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscActionPerformed
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnEsc.setEnabled(false);
        btnDelete.setEnabled(true);
     //   updatebutton=false;
     //   insertbutton=false;
        text_itemID.setEnabled(false);
        textitemName.setEnabled(false);
        text_itemDate.setEnabled(false);
        text_itemPrice.setEnabled(false);
        text_itemUnit.setEnabled(false);
        comboboxitemType.setEnabled(false);
        comboboxitemSupplier.setEnabled(false);
        comboboxitemType.setSelectedIndex(-1);
        comboboxitemSupplier.setSelectedIndex(-1);
        text_itemID.setText("");
        textitemName.setText("");
        text_itemDate.setText("");
        text_itemPrice.setText("");
        text_itemUnit.setText("");
    }//GEN-LAST:event_btnEscActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
/*
        int row = table1.getSelectedRow();
        int itemid= Integer.valueOf(String.valueOf(table1.getValueAt(row, 1)));

        int respone=JOptionPane.showConfirmDialog(this,"Do you want to continue delete item ?", "CONFIRM",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(respone==JOptionPane.YES_OPTION){
          if(   checkItemOrder(itemid)){
                JOptionPane.showMessageDialog(null,"YOU MUST UPDATE CURRENT ORDER:","",2);
            } else{
                Item_Modify.delete(itemid);
            }
        } else if(respone==JOptionPane.NO_OPTION){

        }
        showItem();
*/
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        btnEdit.setEnabled(true);
        int row = table1.getSelectedRow();
        int itemId = Integer.valueOf(String.valueOf(table1.getValueAt(row, 0)));
        Item item=Item_Modify.getItemId(itemId);
        text_itemID.setText(String.valueOf(item.getItem_ID()));
        textitemName.setText(item.getItem_Name());
        text_itemUnit.setText(item.getItem_Unit());
        text_itemDate.setText(item.getItem_Date());
    //    getItemtypecombobox(item.getItem_Type());
    //    getSuppliercombobox(item.getItem_Suplier());
        PreItem=item.getItem_Name();
    }//GEN-LAST:event_table1MouseClicked

    private void comboboxitemSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxitemSupplierActionPerformed

    }//GEN-LAST:event_comboboxitemSupplierActionPerformed

    private void comboboxitemTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxitemTypeActionPerformed

    }//GEN-LAST:event_comboboxitemTypeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.datechooser.DateChooser PRICEDATE;
    private Login.TextFieldAnimation SearchTextField;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnEsc;
    private javax.swing.JButton btnUpdate;
    private com.raven.swing.ButtonGradient button_Fix;
    private com.raven.swing.ButtonGradient button_Insert;
    private com.raven.swing.ButtonGradient button_Submit;
    private com.raven.swing.Combobox<String> comboboxitemSupplier;
    private com.raven.swing.Combobox<String> comboboxitemType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar2;
    private com.raven.swing.table.Table table1;
    private com.raven.swing.TextField text_itemDate;
    private com.raven.swing.TextField text_itemID;
    private com.raven.swing.TextField text_itemPrice;
    private com.raven.swing.TextField text_itemUnit;
    private com.raven.swing.TextField textitemName;
    // End of variables declaration//GEN-END:variables
}
