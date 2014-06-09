/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package etf.si.tim8.app.Hotel;
import javax.swing.JFrame;

import java.awt.SystemColor;
import java.awt.Color;

import javax.swing.UIManager;

import Klase.Zaposlenik;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author adnan
 */
public class HomePage extends javax.swing.JFrame {

	private Zaposlenik zaposlenik;
    /**
     * Creates new form HomePage
     */
    public HomePage() {
    	setResizable(false);
    	getContentPane().setBackground(Color.WHITE);
        initComponents();
        setTitle("Hotel Ksenon Plaza-Dobrodosli!");
    }
    
    public HomePage(Zaposlenik zaposlenik) {
    	this.zaposlenik = zaposlenik;
    	setResizable(false);
    	getContentPane().setBackground(Color.WHITE);
        initComponents();
        setTitle("Hotel Ksenon Plaza-Dobrodosli!");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton1.setBackground(UIManager.getColor("Button.background"));
        jButton2 = new javax.swing.JButton();
        jButton2.setBackground(UIManager.getColor("Button.background"));
        jButton3 = new javax.swing.JButton();
        jButton3.setBackground(UIManager.getColor("Button.background"));
        jButton4 = new javax.swing.JButton();
        jButton4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
        jButton4.setBackground(UIManager.getColor("Button.background"));

        jButton1.setText("Rezervacija");
        jButton1.setActionCommand(jButton1.getActionCommand());
        jButton1.setNextFocusableComponent(this);
        jButton1.setOpaque(true);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Pla\u0107anje");
        jButton2.setActionCommand(jButton2.getActionCommand());
        jButton2.setNextFocusableComponent(this);
        jButton2.setOpaque(true);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton3.setText("Evidencija gostiju");
        jButton3.setActionCommand(jButton3.getActionCommand());
        jButton3.setNextFocusableComponent(this);
        jButton3.setOpaque(true);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton4.setText("Sobe");
        jButton4.setActionCommand(jButton4.getActionCommand());
        jButton4.setNextFocusableComponent(this);
        jButton4.setOpaque(true);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addGap(112, 112, 112))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        pack();
    }// </editor-fold>                        

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {                                      
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	dispose();
                new Rezervacija(zaposlenik).setVisible(true);
            }
        }); 
    }   
    
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {                                      
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
        	dispose();
            new EkranZaPlacanje(zaposlenik).setVisible(true);
        }
    }); 
} 
    
    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {                                      
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
        	dispose();
            new EvidencijaGostiju(zaposlenik).setVisible(true);
        }
    }); 
} 
    
    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {                                      
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
        	dispose();
            new EkranZaPracenjeRaspolozivostiSoba(zaposlenik).setVisible(true);
        }
    }); 
} 

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    // End of variables declaration                   
}
