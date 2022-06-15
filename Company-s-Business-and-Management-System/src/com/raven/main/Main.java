package com.raven.main;

import Login.Login_Screen;
import static Login.Login_Screen.userlogin;
import Login.UserLogin;
import com.raven.component.Header;
import com.raven.component.Menu;
import com.raven.event.EventMenuSelected;
import com.raven.event.EventShowPopupMenu;
import com.raven.form.Add_Staff;
import com.raven.form.Bonus_Edit;
import com.raven.form.Contract_Edit;
import com.raven.form.Contracttype_Edit;
import com.raven.form.Department_Edit;
import com.raven.form.Edit_Staff;
import com.raven.form.Staff_information;
import com.raven.form.MainForm;
import com.raven.form.Role_Edit;
import com.raven.form.Role_Management;
import com.raven.form.CalculateSalary_Management;
import com.raven.form.Customer_Edit;
import com.raven.form.ItemType_Edit;
import com.raven.form.Item_Edit;
import com.raven.form.Item_Management;
import com.raven.form.Order_Edit;
import com.raven.form.Receipt_Edit;
import com.raven.form.Salary_Table;
import com.raven.form.Skill_Edit;
import com.raven.form.Skill_Staff;
import com.raven.form.Supplier_Edit;
import com.raven.swing.MenuItem;
import com.raven.swing.PopupMenu;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Main extends javax.swing.JFrame {

    private MigLayout layout;
    private Menu menu;
    private Header header;
    private MainForm main;
    private Animator animator;

    public Main() {
        initComponents();
        init();
    }

    private void init() {
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);
        menu = new Menu();
        header = new Header();
        main = new MainForm();
        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int menuIndex, int subMenuIndex) {
            //      System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
                if (menuIndex == 0) {
                    if (subMenuIndex == 0) {
                        main.showForm(new Staff_information());
                    } else if (subMenuIndex == 1) {
                        main.showForm(new Add_Staff());
                    }else if (subMenuIndex == 2) {
                        main.showForm(new Edit_Staff());
                    }else if (subMenuIndex == 3) {
                        main.showForm(new Role_Management());
                    }else if (subMenuIndex == 4) {
                        main.showForm(new Skill_Staff());
                    }else if (subMenuIndex == 5) {
                        main.showForm(new Contracttype_Edit());
                    }else if (subMenuIndex == 6) {
                        main.showForm(new CalculateSalary_Management());
                    }
                    else if (subMenuIndex == 7) {
                        main.showForm(new Salary_Table());
                    }
                    
                } else if(menuIndex == 1){
                    if (subMenuIndex == 0) {
                        main.showForm(new Role_Edit());
                    } else if (subMenuIndex == 1) {
                        main.showForm(new Skill_Edit());
                    }else if (subMenuIndex == 2) {
                        main.showForm(new Department_Edit());
                    }else if (subMenuIndex == 3) {
                        main.showForm(new Contract_Edit());
                    }else if (subMenuIndex == 4) {
                        main.showForm(new Bonus_Edit());
                    }else if (subMenuIndex == 5) {
                        main.showForm(new ItemType_Edit());
                    }else if (subMenuIndex == 6) {
                        main.showForm(new Item_Management());
                    }
                    else if (subMenuIndex == 7) {
                        main.showForm(new Order_Edit());
                    }
                    else if (subMenuIndex == 8) {
                        main.showForm(new Supplier_Edit());
                    }
                     else if (subMenuIndex == 9) {
                        main.showForm(new Customer_Edit());
                    }
                }else if(menuIndex == 2){
            
                Login_Screen login =new Login_Screen();
                login.setVisible(true);
                dispose();
                
                
                }
            }
        });
        menu.addEventShowPopup(new EventShowPopupMenu() {
            @Override
            public void showPopup(Component com) {
                MenuItem item = (MenuItem) com;
                PopupMenu popup = new PopupMenu(Main.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
                int x = Main.this.getX() + 52;
                int y = Main.this.getY() + com.getY() + 86;
                popup.setLocation(x, y);
                popup.setVisible(true);
            }
        });
        menu.initMenuItem();
        bg.add(menu, "w 230!, spany 2");    // Span Y 2cell
        bg.add(header, "h 50!, wrap");
        bg.add(main, "w 100%, h 100%");
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menu.isShowMenu()) {
                    width = 60 + (170 * (1f - fraction));
                } else {
                    width = 60 + (170 * fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany2");
                menu.revalidate();
            }

            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
                menu.setEnableMenu(true);
            }

        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        header.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
                menu.setEnableMenu(false);
                if (menu.isShowMenu()) {
                    menu.hideallMenu();
                }
            }
        });
        //  Init google icon font
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
        //  Start with this form
        main.showForm(new Staff_information());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(245, 245, 245));
        bg.setOpaque(true);
        bg.setPreferredSize(new java.awt.Dimension(1252, 807));

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1400, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 1400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
