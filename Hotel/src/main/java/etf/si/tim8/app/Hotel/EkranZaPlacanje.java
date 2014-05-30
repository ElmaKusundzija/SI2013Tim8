/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package etf.si.tim8.app.Hotel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JFrame;

import java.awt.SystemColor;

import javax.swing.SwingConstants;

import java.awt.Component;

import javax.swing.JPanel;

import Hibernate.DBManager;
import Hibernate.HibernateUtil;
import Klase.*;

import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.Dimension;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JTextField;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author adnan
 */
public class EkranZaPlacanje extends javax.swing.JFrame {

    /**
     * Creates new form EkranZaPlacanje
     */
	private List<Boravak> boravci; // Lista gostiju, za sad se koristi za popunjavanje jList1
	private Boravak oznaceniBoravak;
	private Predracun predracun;
	private Racun racun;
	
	private void kreirajPredracun() throws Exception {
		
		boolean kreiraj = false;
		if(oznaceniBoravak !=null && Double.parseDouble(tf_ukupno.getText()) >= 0 ){
			if(predracun==null){
				kreiraj = true;
				predracun = new Predracun();
			}
			if(Double.parseDouble(tf_popust.getText()) >=0 &&  Double.parseDouble(tf_popust.getText()) <=100) {
				predracun.setPopust(Double.parseDouble(tf_popust.getText()));
				predracun.setRezervacija(oznaceniBoravak.getRezervacija());
				predracun.setUkupnaCijena(Double.parseDouble(tf_ukupno.getText()));
				if(kreiraj)
				DBManager.unesiPredracun(predracun);
				else
				DBManager.updatePredracun(predracun);	
			}
			else 
				JOptionPane.showMessageDialog(null, "Popust mora biti broj izmedju 0 i 100!", "Greska", JOptionPane.ERROR_MESSAGE);
			
		}
		
		
	}
	
    public EkranZaPlacanje() {
    	setResizable(false);
    	setPreferredSize(new Dimension(850, 570));
    	setSize(1000,1000);
    	getContentPane().setBackground(Color.WHITE);
    	setAutoRequestFocus(false);
    	setTitle("Ekran za Placanje");
        initComponents();
        //dodavanje rezervacija u listu
        boravci = DBManager.dajBoravke2();
        
        if(boravci !=null && boravci.size() > 0 ){
	        DefaultListModel model = new DefaultListModel();
	        jList1.setModel(model);
	        
	        for(Boravak boravak : boravci){
	        	model.addElement(boravak.getGost());
	        }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	setTitle("Hotel Ksenon Plaza-Pla�anje");
        jPanel1 = new javax.swing.JPanel();
        jPanel1.setBackground(SystemColor.inactiveCaptionBorder);
        jPanel2 = new javax.swing.JPanel();
        jPanel2.setBackground(SystemColor.inactiveCaptionBorder);
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        final JLabel labelPlaceno = new JLabel(" ");
        
        jList1.addListSelectionListener(new ListSelectionListener() { // Listener za klik na jList1
        	public void valueChanged(ListSelectionEvent arg0) {
        		//for(Boravak boravak : boravci){
        			//if(boravak.getGost().getOsoba().getImePrezime() == jList1.getSelectedValue().toString() ){
        			if(jList1.getSelectedIndex()!=-1){
        				oznaceniBoravak = boravci.get(jList1.getSelectedIndex());
        				//unesemo podatke s rezervacije u polja
        				jTextField1.setText(oznaceniBoravak.getGost().getIme());
        				tf_ime.setText(oznaceniBoravak.getGost().getIme());
        				jTextField2.setText(oznaceniBoravak.getGost().getPrezime());
        				tf_prezime.setText(oznaceniBoravak.getGost().getPrezime());
        				jTextField3.setText(Integer.toString(oznaceniBoravak.getRezervacija().getSoba().getBrojSobe()));
        				tf_brojsobe.setText(Integer.toString(oznaceniBoravak.getRezervacija().getSoba().getBrojSobe()));
        				tf_cijena.setText(Double.toString(oznaceniBoravak.getRezervacija().getSoba().getCijena()));
        				
        				textField.setText( new SimpleDateFormat("dd.MM.yyyy").format(oznaceniBoravak.getRezervacija().getRezervisanoOd()) + " - " + new SimpleDateFormat("dd.MM.yyyy").format(oznaceniBoravak.getRezervacija().getRezervisanoDo()));
        				/*Integer.toString(oznaceniBoravak.getRezervacija().getRezervisanoOd().getDate()) + "." + Integer.toString(oznaceniBoravak.getRezervacija().getRezervisanoOd().getMonth()+1) + "."+Integer.toString(oznaceniBoravak.getRezervacija().getRezervisanoOd().getYear() +1900) + " - " + Integer.toString(oznaceniBoravak.getRezervacija().getRezervisanoDo().getDate()) + "." + Integer.toString(oznaceniBoravak.getRezervacija().getRezervisanoDo().getMonth()+1) + "."+Integer.toString(oznaceniBoravak.getRezervacija().getRezervisanoDo().getYear() +1900)*/ 
        				
        				long brojdana;
        				if(oznaceniBoravak.getVrijemeOdlaska() !=null) {
        					
        					brojdana = (oznaceniBoravak.getVrijemeOdlaska().getTime() - oznaceniBoravak.getVrijemeDolaska().getTime())/(1000 * 86400);
        				}
        				else brojdana = ((new Date().getTime()) - oznaceniBoravak.getVrijemeDolaska().getTime())/(1000 * 86400);
        				cb_brojdana.setSelectedItem(brojdana);
        				double cijenasoba = oznaceniBoravak.getRezervacija().getSoba().getCijena();
        				
        				Double polja7i9 =0.0;
        				try{
        					if(!tf_minibar.getText().equalsIgnoreCase("")) polja7i9 += Double.parseDouble(tf_minibar.getText());
        				}
        				catch(Exception e){
        					polja7i9=0.0;
        					//tf_telefon.setText("");
        					tf_minibar.setText("");
        					JOptionPane.showMessageDialog(null, "Pogresan unos cijene minibara", "Info", JOptionPane.ERROR_MESSAGE);
        				}
        				try{
        					if(!tf_telefon.getText().equalsIgnoreCase(""))polja7i9 += Double.parseDouble(tf_telefon.getText());
        				}
        				catch(Exception e){
        					polja7i9=0.0;
        					tf_telefon.setText("");
        					//tf_minibar.setText("");
        					JOptionPane.showMessageDialog(null, "Pogresan unos cijene telefona", "Info", JOptionPane.ERROR_MESSAGE);
        				}
        				
        				double popust = 0.0;
        				try{
        					if(!tf_popust.getText().equalsIgnoreCase("")) popust += Double.parseDouble(tf_popust.getText());
        				}
        				catch(Exception e){
        					polja7i9=0.0;
        					tf_popust.setText("");
        					JOptionPane.showMessageDialog(null, "Pogresan unos popusta", "Info", JOptionPane.ERROR_MESSAGE);
        				}
        				if(popust>=100 && popust<=0) popust =0.0;
        				
        				Double ukupno = (brojdana *  cijenasoba + polja7i9 - ((brojdana *  cijenasoba + polja7i9)*(popust/100)) );
        				String uk = ukupno.toString();
        				if(uk.length() > 7 ) uk = uk.substring(0, 7);
        				//jTextField11.setText(Double.toString( (brojdana *  cijenasoba + polja7i9 - (brojdana *  cijenasoba + polja7i9)*(popust/100) ) ));
        				tf_ukupno.setText(uk);
        				
        				//tf_popust.setText("");
        				
        				predracun = DBManager.dajPredracun(oznaceniBoravak.getRezervacija());
        				if(predracun!=null){
        				//	tf_popust.setText(Double.toString(predracun.getPopust()));
        					racun = DBManager.dajRacun(predracun);
        					if(racun!=null){
        						jButton1.setEnabled(false);
        						jButton2.setEnabled(false);
        						labelPlaceno.setText("DA");
        					}
        					else{ 
        						labelPlaceno.setText("NE");
        						jButton1.setEnabled(true);
        						jButton2.setEnabled(true);
        					}
        				}
        				else{ 
    						labelPlaceno.setText("NE");
    						jButton1.setEnabled(true);
    						jButton2.setEnabled(true);
    					}
        			}
        		//}
        	}
        });
        
        jPanel3 = new javax.swing.JPanel();
        jPanel3.setBackground(SystemColor.inactiveCaptionBorder);
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField1.setEnabled(false);
        jTextField2 = new javax.swing.JTextField();
        jTextField2.setEnabled(false);
        jTextField3 = new javax.swing.JTextField();
        jTextField3.setEnabled(false);
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel5.setBackground(SystemColor.inactiveCaptionBorder);
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel6.setBackground(SystemColor.inactiveCaptionBorder);
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tf_ime = new javax.swing.JTextField();
        tf_ime.setEnabled(false);
        tf_prezime = new javax.swing.JTextField();
        tf_prezime.setEnabled(false);
        tf_brojsobe = new javax.swing.JTextField();
        tf_brojsobe.setEnabled(false);
        tf_cijena = new javax.swing.JTextField();
        tf_cijena.setEnabled(false);
        cb_brojdana = new javax.swing.JComboBox();
        cb_brojdana.setEnabled(false);
        cb_brojdana.setEditable(true);
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel7.setBackground(SystemColor.inactiveCaptionBorder);
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tf_minibar = new javax.swing.JTextField();
        tf_telefon = new javax.swing.JTextField();
        tf_popust = new javax.swing.JTextField();
        tf_popust.setText(Integer.toString(0));
        jPanel8 = new javax.swing.JPanel();
        jPanel8.setBackground(SystemColor.inactiveCaptionBorder);
        jLabel16 = new javax.swing.JLabel();
        tf_ukupno = new javax.swing.JTextField();
        tf_ukupno.setEnabled(false);  /* read only texfield*/
        
        textField = new javax.swing.JTextField();
        textField.setEnabled(false);
        textField.setColumns(10);
        
        jButton1 = new javax.swing.JButton();
        jButton1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//JOptionPane.showMessageDialog(null, "Nije implementirano!", "Info", JOptionPane.INFORMATION_MESSAGE);
        		try{
        			kreirajPredracun();
        			JOptionPane.showMessageDialog(null, "Uspjesno ste evidentirali predracun!", "Evidencija predacuna", JOptionPane.INFORMATION_MESSAGE);
        		}
        		catch(Exception exception){
        			JOptionPane.showMessageDialog(null, exception.getMessage() , "Greska", JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });
        jButton2 = new javax.swing.JButton();
        jButton2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		//JOptionPane.showMessageDialog(null, "Nije implementirano", "Info", JOptionPane.INFORMATION_MESSAGE);
        		try{
        			kreirajPredracun();
        			racun = new Racun();
        			racun.setBrojRacuna(10);
        			racun.setPredracun(predracun);
        			racun.setVrijemeIzdavanja(new Date());
        			DBManager.unesiRacun(racun);
        			JOptionPane.showMessageDialog(null, "Uspjesno ste evidentirali racun!", "Evidencija racuna", JOptionPane.INFORMATION_MESSAGE);
        		}
        		catch(Exception exception){
        			JOptionPane.showMessageDialog(null, exception.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });
        jButton3 = new javax.swing.JButton();
        jButton3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new HomePage().setVisible(true);
        		EkranZaPlacanje.this.setVisible(false);
        	}
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Lista gostiju hotela:");

        jList1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Ime:");

        jLabel3.setText("Prezime:");

        jLabel4.setText("Soba:");

        jLabel5.setText("Placeno:");
        
        JLabel lblRezervacija = new JLabel("Rezervacija:");
        

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3Layout.setHorizontalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel3Layout.createSequentialGroup()
        			.addGap(10)
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jLabel4)
        				.addComponent(lblRezervacija)
        				.addComponent(jLabel3)
        				.addComponent(jLabel2))
        			.addGap(18)
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel3Layout.createSequentialGroup()
        					.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(jTextField2)
        						.addComponent(jTextField3)
        						.addComponent(jTextField1, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
        					.addGap(26)
        					.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel5)
        						.addGroup(jPanel3Layout.createSequentialGroup()
        							.addGap(10)
        							.addComponent(labelPlaceno))))
        				.addComponent(textField, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel3Layout.createSequentialGroup()
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel3Layout.createSequentialGroup()
        					.addGap(15)
        					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel2))
        					.addGap(6)
        					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel3))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel4)))
        				.addGroup(jPanel3Layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jLabel5)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(labelPlaceno)))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblRezervacija)
        				.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel3Layout.linkSize(SwingConstants.VERTICAL, new Component[] {jTextField1, jTextField2, jTextField3});
        jPanel3Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {jTextField1, jTextField2, jTextField3});
        jPanel3.setLayout(jPanel3Layout);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(17)
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(67)
        			.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(14)
        					.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(33)
        					.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setText("Predra\u010Dun");

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel7.setText("Ime:");

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel8.setText("Prezime:");

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel9.setText("Broj sobe:");

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel10.setText("Broj dana:");

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel11.setText("Cijena boravka po danu:");

        cb_brojdana.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cb_brojdana, javax.swing.GroupLayout.Alignment.LEADING, 0, 99, Short.MAX_VALUE)
                    .addComponent(tf_brojsobe, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_prezime, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_ime, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_cijena))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tf_ime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tf_prezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_brojsobe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cb_brojdana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_cijena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel12.setText("Ostali tro\u0161kovi:");

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel13.setText("Mini bar:");

        jLabel14.setText("Telefon:");

        jLabel15.setText("Popust:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_popust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_telefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(tf_minibar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tf_popust, tf_minibar, tf_telefon});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(tf_minibar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(tf_telefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(tf_popust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel16.setText("Ukupno za platiti:");

        tf_ukupno.setBackground(Color.WHITE);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8Layout.setHorizontalGroup(
        	jPanel8Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel8Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel16)
        			.addGap(24))
        		.addGroup(Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
        			.addComponent(tf_ukupno, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
        	jPanel8Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel8Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel16)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(tf_ukupno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8.setLayout(jPanel8Layout);

        jButton1.setText("Izrada predra\u010Duna");

        jButton2.setText("Izrada ra\u010Duna");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5Layout.setHorizontalGroup(
        	jPanel5Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel5Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel6)
        				.addGroup(jPanel5Layout.createSequentialGroup()
        					.addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(jPanel5Layout.createSequentialGroup()
        							.addGroup(jPanel5Layout.createParallelGroup(Alignment.TRAILING)
        								.addComponent(jButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addComponent(jPanel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(jButton2, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
        								.addComponent(jPanel8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        						.addComponent(jLabel12))))
        			.addGap(19))
        );
        jPanel5Layout.setVerticalGroup(
        	jPanel5Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel5Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel6)
        			.addGap(0)
        			.addGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addGroup(jPanel5Layout.createSequentialGroup()
        					.addComponent(jLabel12)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel5Layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(jPanel8, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jPanel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel5Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jButton2)
        						.addComponent(jButton1))))
        			.addContainerGap())
        );
        jPanel5.setLayout(jPanel5Layout);

        jButton3.setText("Po\u010Detna stranica");
        
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setSize(200,200);
        ImageIcon guy = new ImageIcon("hotel.png");
		JLabel pn = new JLabel(guy);
		panel.add(pn);
        FlowLayout fl_panel = (FlowLayout) panel.getLayout();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(19)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(jPanel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jButton3, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(20)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
        				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(EkranZaPlacanje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EkranZaPlacanje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EkranZaPlacanje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EkranZaPlacanje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EkranZaPlacanje().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox cb_brojdana;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField tf_popust;
    private javax.swing.JTextField tf_ukupno;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField tf_ime;
    private javax.swing.JTextField tf_prezime;
    private javax.swing.JTextField tf_brojsobe;
    private javax.swing.JTextField tf_minibar;
    private javax.swing.JTextField tf_cijena;
    private javax.swing.JTextField tf_telefon;
    private JPanel panel;
    private JTextField textField;
}
