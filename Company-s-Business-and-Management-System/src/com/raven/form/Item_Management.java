package com.raven.form;

import Login.EventCallBack;
import Login.EventTextField;
import Model.Bonus;
import Model.Bonus_Modify;
import Model.Contract;
import Model.Contract_Modify;
import Model.Contracttype;
import Model.Contracttype_Modify;
import Model.Item;
import Model.ItemType;
import Model.ItemType_Modify;
import Model.Item_Modify;
import Model.Order;
import Model.Order_Modify;
import Model.Role;
import Model.RoleManagement;
import Model.RoleManagement_Modify;
import Model.Role_Modify;
import Model.Salary;
import Model.SalaryMa;
import Model.SalaryMa_Modify;
import Model.Salary_Modify;
import Model.Staff;
import Model.Staff_Modify;
import Model.Supplier;
import Model.Supplier_Modify;
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
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static oracle.jdbc.OracleTypes.NULL;


public class Item_Management extends javax.swing.JPanel {
DefaultTableModel tableModel;
Calendar cal=new GregorianCalendar();
static boolean checkExistItem=false;
static boolean checkExistEditItem=false;
static String PreItem="";
 static boolean insertbutton=false; 
 static boolean updatebutton=false; 

    
    public Item_Management() {
        initComponents();
        tableModel = (DefaultTableModel) table1.getModel();
        showItem();
        showSuppliercombobox();
        showItemtypecombobox();
       
        text_itemID.setEnabled(false);
        textitemName.setEnabled(false);
        text_itemDate.setEnabled(false);
        text_itemPrice.setEnabled(false);
        text_itemUnit.setEnabled(false);
        comboboxitemType.setEnabled(false);
        comboboxitemSupplier.setEnabled(false);
        comboboxitemType.setSelectedIndex(-1);
        comboboxitemSupplier.setSelectedIndex(-1);
        btnEdit.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnEsc.setEnabled(false);
        btnDelete.setEnabled(false);
    }
    
    private void showItem(){
        List<Item> itemList = Item_Modify.findAll();
        
        tableModel.setRowCount(0);
        
        itemList.forEach(item -> {
            tableModel.addRow(new Object[] {item.getItem_ID(),item.getItem_Name(),item.getItem_Unit(),item.getItem_Type(),item.getItem_Suplier(),item.getPrice(),item.getItem_Date()} );
        });
        
    }
    
    public void showSuppliercombobox(){
         List<Supplier> supplierList = Supplier_Modify.findAll();
         for(Supplier supp :supplierList){
             comboboxitemSupplier.addItem(supp.getSuppName());
         }
        
    }
    
    public void showItemtypecombobox(){
         List<ItemType> itemtypeList = ItemType_Modify.findAll();
         for(ItemType itemtype :itemtypeList){
             comboboxitemType.addItem(itemtype.getItemTypeName());
         }
        
    }
    
    public void getItemtypecombobox(String itemtypename){
          int count=0;
          List<ItemType> itemtypeList = ItemType_Modify.findAll();
            for(ItemType itemtype :itemtypeList){
             if(itemtype.getItemTypeName().equalsIgnoreCase(itemtypename)){
                  comboboxitemType.setSelectedIndex(count);
             } else{
                 count++;
             }
         }
        
    }
    
      public void getSuppliercombobox(String supplier){
         int count=0;
          List<Supplier> supplierList = Supplier_Modify.findAll();
            for(Supplier supplieritem : supplierList){
             if(supplieritem.getSuppName().equalsIgnoreCase(supplier)){
                  comboboxitemSupplier.setSelectedIndex(count);
             } else{
                 count++;
             }
         }
        
    }
    
     public void checkExistitem(String itemname){
         List<Item> itemList = Item_Modify.findAll();
        
        
        itemList.forEach(item -> {
             if(item.getItem_Name().equalsIgnoreCase(itemname)){
                checkExistItem= true;
             }
        });
       
    }
    
      public void checkExistEdititem(String itemname,String preitem){
         List<Item> itemList = Item_Modify.findAll();
        
        
        itemList.forEach(item -> {
             if(item.getItem_Name().equalsIgnoreCase(itemname) && !itemname.equalsIgnoreCase(preitem)){
                checkExistEditItem= true;
             }
        });
       
    }
     public boolean checkItemOrder(int itemid){
        List<Order> orderList = Order_Modify.findAll();
          for(Order order : orderList ){
               if(  itemid==order.getItem_ID()){
                   return true;
               }
        }
          return false;
    }
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateStart = new com.raven.datechooser.DateChooser();
        jLabel1 = new javax.swing.JLabel();
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
        SearchTextField = new Login.TextFieldAnimation();
        jToolBar2 = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnEsc = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        dateStart.setForeground(new java.awt.Color(0, 153, 247));
        dateStart.setDateFormat("yyyy-MMMM-dd");
        dateStart.setFocusCycleRoot(true);
        dateStart.setTextRefernce(text_itemDate);

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1726, 820));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("ITEM MANGEMENT");

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
        table1.getTableHeader().setReorderingAllowed(false);
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(0).setResizable(false);
            table1.getColumnModel().getColumn(1).setResizable(false);
            table1.getColumnModel().getColumn(4).setResizable(false);
            table1.getColumnModel().getColumn(5).setResizable(false);
        }

        text_itemID.setEditable(false);
        text_itemID.setBackground(new java.awt.Color(255, 255, 255));
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textitemName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_itemDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_itemID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_itemPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboboxitemType, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_itemUnit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboboxitemSupplier, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_itemID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_itemUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboboxitemType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textitemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_itemDate, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboboxitemSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(text_itemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE))
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
        btnAdd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAddKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnAddKeyReleased(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboboxitemTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxitemTypeActionPerformed
      
    }//GEN-LAST:event_comboboxitemTypeActionPerformed

    private void comboboxitemSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxitemSupplierActionPerformed
     
    }//GEN-LAST:event_comboboxitemSupplierActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        btnEdit.setEnabled(true);
        btnDelete.setEnabled(true);
        int row = table1.getSelectedRow();    
        int itemId = Integer.valueOf(String.valueOf(table1.getValueAt(row, 0)));
        Item item=Item_Modify.getItemId(itemId);
        text_itemID.setText(String.valueOf(item.getItem_ID()));
        textitemName.setText(item.getItem_Name());  
        text_itemUnit.setText(item.getItem_Unit());
        text_itemDate.setText(item.getItem_Date());
        text_itemPrice.setText(String.valueOf(item.getPrice()));
        getItemtypecombobox(item.getItem_Type());
        getSuppliercombobox(item.getItem_Suplier());
        PreItem=item.getItem_Name();

    }//GEN-LAST:event_table1MouseClicked

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
        insertbutton=true;
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
        updatebutton=true;
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if(insertbutton==true){
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
        showItem();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnEscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscActionPerformed
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
    }//GEN-LAST:event_btnEscActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        int row = table1.getSelectedRow();
        int itemid= Integer.valueOf(String.valueOf(table1.getValueAt(row, 0)));

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
    }//GEN-LAST:event_btnDeleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Login.TextFieldAnimation SearchTextField;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnEsc;
    private javax.swing.JButton btnUpdate;
    private com.raven.swing.Combobox<String> comboboxitemSupplier;
    private com.raven.swing.Combobox<String> comboboxitemType;
    private com.raven.datechooser.DateChooser dateStart;
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
