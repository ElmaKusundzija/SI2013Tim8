/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package etf.si.tim8.app.Hotel;
import etf.si.tim8.app.Hotel.org.eclipse.wb.swing.FocusTraversalOnArray;
import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.JList;
import javax.swing.JRadioButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.SystemColor;

/**
 *
 * @author adnan
 */
public class OsobljeN extends javax.swing.JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;

    /**
     * Creates new form HomePage
     */
    public OsobljeN() {
    	setTitle("Hotel Ksenon Plaza-Osoblje");
    	getContentPane().setBackground(Color.WHITE);
    	setResizable(false);
    	setSize(1124,598);
    	getContentPane().setBounds(0, 0, 917, 642);
    	
    	setAutoRequestFocus(false);
    	getContentPane().setSize(917, 642);
    	getContentPane().setLayout(null);
    	
    	JPanel panel = new JPanel();
    	panel.setBackground(SystemColor.inactiveCaptionBorder);
    	panel.setBounds(10, 11, 374, 538);
    	getContentPane().add(panel);
    	panel.setLayout(null);
    	
    	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    	tabbedPane.setBackground(SystemColor.inactiveCaptionBorder);
    	tabbedPane.setBounds(0, 0, 374, 538);
    	tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0)));
    	panel.add(tabbedPane);
    	
    	JPanel panel_2 = new JPanel();
    	panel_2.setBackground(SystemColor.inactiveCaptionBorder);
    	panel_2.setLayout(null);
    	tabbedPane.addTab("Pretraga osoblja", null, panel_2, null);
    	
    	textField = new JTextField();
    	textField.setColumns(10);
    	textField.setBounds(216, 10, 141, 37);
    	panel_2.add(textField);
    	
    	JLabel label = new JLabel("Unesite ime ili prezime \r\n\u010Dlana osoblja:");
    	label.setBounds(10, -4, 296, 64);
    	panel_2.add(label);
    	
    	JButton button = new JButton("Pretra\u017Ei");
    	button.setBounds(255, 56, 102, 28);
    	panel_2.add(button);
    	
    	JPanel panel_3 = new JPanel();
    	panel_3.setBackground(SystemColor.inactiveCaptionBorder);
    	panel_3.setLayout(null);
    	panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
    	panel_3.setBounds(10, 87, 347, 410);
    	panel_2.add(panel_3);
    	
    	JLabel label_1 = new JLabel("Rezultati pretrage:");
    	label_1.setBounds(128, 5, 91, 14);
    	panel_3.add(label_1);
    	
    	JList list = new JList();
    	list.setBounds(10, 32, 327, 367);
    	panel_3.add(list);
    	
    	JPanel panel_4 = new JPanel();
    	panel_4.setBackground(SystemColor.inactiveCaptionBorder);
    	panel_4.setLayout(null);
    	tabbedPane.addTab("Lista svih radnika", null, panel_4, null);
    	
    	JPanel panel_1 = new JPanel();
    	panel_1.setBackground(SystemColor.inactiveCaptionBorder);
    	panel_1.setBounds(402, 11, 497, 538);
    	getContentPane().add(panel_1);
    	panel_1.setLayout(null);
    	
    	JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
    	tabbedPane_1.setBackground(SystemColor.inactiveCaptionBorder);
    	tabbedPane_1.setBounds(0, 0, 497, 538);
    	tabbedPane_1.setBorder(new LineBorder(new Color(0, 0, 0)));
    	panel_1.add(tabbedPane_1);
    	
    	JPanel panel_5 = new JPanel();
    	panel_5.setBackground(SystemColor.inactiveCaptionBorder);
    	tabbedPane_1.addTab("Informacije:", null, panel_5, null);
    	panel_5.setLayout(null);
    	
    	textField_1 = new JTextField();
    	textField_1.setColumns(10);
    	textField_1.setBounds(107, 7, 123, 32);
    	panel_5.add(textField_1);
    	
    	textField_2 = new JTextField();
    	textField_2.setColumns(10);
    	textField_2.setBounds(107, 45, 123, 32);
    	panel_5.add(textField_2);
    	
    	textField_3 = new JTextField();
    	textField_3.setColumns(10);
    	textField_3.setBounds(107, 83, 123, 32);
    	panel_5.add(textField_3);
    	
    	textField_4 = new JTextField();
    	textField_4.setColumns(10);
    	textField_4.setBounds(107, 121, 123, 32);
    	panel_5.add(textField_4);
    	
    	textField_5 = new JTextField();
    	textField_5.setColumns(10);
    	textField_5.setBounds(107, 159, 123, 32);
    	panel_5.add(textField_5);
    	
    	textField_6 = new JTextField();
    	textField_6.setColumns(10);
    	textField_6.setBounds(107, 197, 123, 32);
    	panel_5.add(textField_6);
    	
    	textField_7 = new JTextField();
    	textField_7.setColumns(10);
    	textField_7.setBounds(107, 236, 123, 32);
    	panel_5.add(textField_7);
    	
    	textField_8 = new JTextField();
    	textField_8.setColumns(10);
    	textField_8.setBounds(107, 275, 123, 32);
    	panel_5.add(textField_8);
    	
    	textField_9 = new JTextField();
    	textField_9.setColumns(10);
    	textField_9.setBounds(107, 312, 123, 32);
    	panel_5.add(textField_9);
    	
    	textField_10 = new JTextField();
    	textField_10.setColumns(10);
    	textField_10.setBounds(359, 7, 123, 32);
    	panel_5.add(textField_10);
    	
    	textField_11 = new JTextField();
    	textField_11.setColumns(10);
    	textField_11.setBounds(359, 45, 123, 32);
    	panel_5.add(textField_11);
    	
    	textField_12 = new JTextField();
    	textField_12.setColumns(10);
    	textField_12.setBounds(359, 83, 123, 32);
    	panel_5.add(textField_12);
    	
    	textField_13 = new JTextField();
    	textField_13.setColumns(10);
    	textField_13.setBounds(359, 121, 123, 32);
    	panel_5.add(textField_13);
    	
    	JLabel label_2 = new JLabel("Ime:");
    	label_2.setBounds(10, -2, 210, 50);
    	panel_5.add(label_2);
    	
    	JLabel label_3 = new JLabel("Prezime:");
    	label_3.setBounds(10, 37, 210, 50);
    	panel_5.add(label_3);
    	
    	JLabel label_4 = new JLabel("JMBG:");
    	label_4.setBounds(10, 77, 200, 50);
    	panel_5.add(label_4);
    	
    	JLabel label_5 = new JLabel("Datum ro\u0111enja:");
    	label_5.setBounds(10, 115, 200, 50);
    	panel_5.add(label_5);
    	
    	JLabel label_6 = new JLabel("Adresa:");
    	label_6.setBounds(10, 150, 200, 50);
    	panel_5.add(label_6);
    	
    	JLabel label_7 = new JLabel("Dr\u017Eavljanstvo:");
    	label_7.setBounds(10, 188, 200, 50);
    	panel_5.add(label_7);
    	
    	JLabel label_8 = new JLabel("Titula:");
    	label_8.setBounds(10, 227, 200, 50);
    	panel_5.add(label_8);
    	
    	JLabel label_9 = new JLabel("Obrazovanje:");
    	label_9.setBounds(10, 266, 200, 50);
    	panel_5.add(label_9);
    	
    	JLabel label_10 = new JLabel("Email:");
    	label_10.setBounds(10, 305, 200, 50);
    	panel_5.add(label_10);
    	
    	JLabel label_11 = new JLabel("Telefon:");
    	label_11.setBounds(247, -2, 200, 50);
    	panel_5.add(label_11);
    	
    	JLabel label_12 = new JLabel("Mobitel:");
    	label_12.setBounds(247, 37, 200, 50);
    	panel_5.add(label_12);
    	
    	JLabel label_13 = new JLabel("Korisni\u010Dko ime:");
    	label_13.setBounds(247, 77, 200, 50);
    	panel_5.add(label_13);
    	
    	JLabel label_14 = new JLabel("Korisni\u010Dka lozinka:");
    	label_14.setBounds(247, 115, 200, 50);
    	panel_5.add(label_14);
    	
    	JPanel panel_6 = new JPanel();
    	panel_6.setBackground(SystemColor.inactiveCaptionBorder);
    	panel_6.setLayout(null);
    	panel_6.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
    	panel_6.setBounds(247, 184, 123, 160);
    	panel_5.add(panel_6);
    	
    	JRadioButton radioButton = new JRadioButton("Recepcioner");
    	radioButton.setBackground(SystemColor.inactiveCaptionBorder);
    	radioButton.setBounds(6, 7, 109, 23);
    	panel_6.add(radioButton);
    	
    	JRadioButton radioButton_1 = new JRadioButton("\u010Cista\u010Dica");
    	radioButton_1.setBackground(SystemColor.inactiveCaptionBorder);
    	radioButton_1.setBounds(6, 30, 109, 23);
    	panel_6.add(radioButton_1);
    	
    	JRadioButton radioButton_2 = new JRadioButton("Ekonomista");
    	radioButton_2.setBackground(SystemColor.inactiveCaptionBorder);
    	radioButton_2.setBounds(6, 82, 109, 23);
    	panel_6.add(radioButton_2);
    	
    	JRadioButton radioButton_3 = new JRadioButton("Kuhar");
    	radioButton_3.setBackground(SystemColor.inactiveCaptionBorder);
    	radioButton_3.setBounds(6, 56, 109, 23);
    	panel_6.add(radioButton_3);
    	
    	JRadioButton radioButton_4 = new JRadioButton("Manager");
    	radioButton_4.setBackground(SystemColor.inactiveCaptionBorder);
    	radioButton_4.setBounds(6, 108, 109, 23);
    	panel_6.add(radioButton_4);
    	
    	JRadioButton radioButton_5 = new JRadioButton("Administrator");
    	radioButton_5.setBackground(SystemColor.inactiveCaptionBorder);
    	radioButton_5.setBounds(6, 130, 109, 23);
    	panel_6.add(radioButton_5);
    	
    	JLabel label_15 = new JLabel("Uloge:");
    	label_15.setBounds(247, 150, 200, 50);
    	panel_5.add(label_15);
    	
    	JPanel panel_7 = new JPanel();
    	panel_7.setBackground(SystemColor.inactiveCaptionBorder);
    	panel_7.setLayout(null);
    	panel_7.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
    	panel_7.setBounds(10, 366, 220, 131);
    	panel_5.add(panel_7);
    	
    	JButton button_1 = new JButton("Uredi osobu");
    	button_1.setBounds(10, 10, 200, 33);
    	panel_7.add(button_1);
    	
    	JButton button_2 = new JButton("Izbri\u0161i osobu");
    	button_2.setBounds(10, 49, 200, 33);
    	panel_7.add(button_2);
    	
    	JButton button_3 = new JButton("Dodaj novu osobu");
    	button_3.setBounds(10, 88, 200, 33);
    	panel_7.add(button_3);
    	
    	JButton btnNewButton = new JButton("Po\u010Detna stranica");
    	btnNewButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
    			new HomePage().setVisible(true);
    		}
    	});
    	btnNewButton.setBounds(909, 499, 200, 50);
    	getContentPane().add(btnNewButton);
    	
    	JPanel panel_8 = new JPanel();
    	panel_8.setBackground(Color.WHITE);
    	panel_8.setBounds(909, 280, 200, 201);
    	getContentPane().add(panel_8);
    	ImageIcon guy = new ImageIcon("C:\\Users\\X\\Desktop\\hotel.png");
 		JLabel pn = new JLabel(guy);
 		panel_8.add(pn);
    	getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{tabbedPane, panel_2, panel, textField, label, button, panel_3, label_1, list, panel_4, panel_1, tabbedPane_1, panel_5, textField_1, textField_2, textField_3, textField_4, textField_5, textField_6, textField_7, textField_8, textField_9, textField_10, textField_11, textField_12, textField_13, label_2, label_3, label_4, label_5, label_6, label_7, label_8, label_9, label_10, label_11, label_12, label_13, label_14, panel_6, radioButton, radioButton_1, radioButton_2, radioButton_3, radioButton_4, radioButton_5, label_15, panel_7, button_1, button_2, button_3}));
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
    }// </editor-fold>                        

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
            java.util.logging.Logger.getLogger(OsobljeN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OsobljeN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OsobljeN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OsobljeN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OsobljeN().setVisible(true);
            }
        });
    }
    // End of variables declaration                   
}