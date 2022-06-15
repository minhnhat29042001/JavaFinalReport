package com.raven.swing.table;

import com.raven.swing.scrollbar.ScrollBarCustom;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

public class Table extends JTable {

    public Table() {
      
        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(true); // ko cho chỉnh kéo thả các cột
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader header = new TableHeader(o + "");
                // chỉnh header vô giữa 
                for (int j=0; j<8; j++) {
                    if(i1==j){
                    header.setHorizontalAlignment(JLabel.CENTER);
                }
                }
                return header;
            }
        });
       
        
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean focus, int i, int i1) {
                    
                    Component com = super.getTableCellRendererComponent(jtable, o, selected, focus, i, i1);
                    setBorder(noFocusBorder);
                    setHorizontalAlignment(JLabel.CENTER);
                  
                    com.setForeground(new Color(102, 102, 102));
                    if (selected) {
                        com.setBackground(new Color(239, 244, 255));
                    } else {
                        com.setBackground(Color.WHITE);
                    }
                    return com;
                
            }
        });
        
        
    }
     @Override
    public TableCellEditor getCellEditor(int row, int col) {
        if (col == 4) {
            return new TableCellAction();
        } else {
            return super.getCellEditor(row, col);
        }
    }
    
    public void addRow(Object[] row) {
        DefaultTableModel mod = (DefaultTableModel) getModel();
        mod.addRow(row);
     }

    public void fixTable(JScrollPane scroll) {
        scroll.getViewport().setBackground(Color.WHITE);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        scroll.setBorder(new EmptyBorder(5, 10, 5, 10));
    }
}

