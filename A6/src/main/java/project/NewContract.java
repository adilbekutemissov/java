/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import DBS.Farmaceut;
import static DBS.Farmaceut_.smlouvy;
import DBS.Smlouva;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Adilbek Utemissov
 */
public class NewContract extends javax.swing.JFrame {
    
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("Pharmacy");
       
    private Farmaceut cust;
    
    
    
    /**
     * Creates new form NewContract
     */
    public NewContract(Farmaceut cust) {
        this.cust = cust;

//        Smlouva nsmlouva = nsmlouva;
//        Farmaceut zamestnanecid = zamestnanecid;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jSlider1 = new javax.swing.JSlider();
        Nova = new javax.swing.JPanel();
        NSmlouvyTitle = new javax.swing.JLabel();
        IcoLekTitle = new javax.swing.JLabel();
        IcoSpolText = new javax.swing.JTextField();
        DodavatelTitle = new javax.swing.JLabel();
        KonceTitle = new javax.swing.JLabel();
        IcoSpolTitle = new javax.swing.JLabel();
        ZacatekTitle = new javax.swing.JLabel();
        IcoLekText = new javax.swing.JTextField();
        KonecText = new javax.swing.JTextField();
        DodavatelText = new javax.swing.JTextField();
        ZacatekText = new javax.swing.JTextField();
        NSmlouvyText = new javax.swing.JTextField();
        Zpet = new javax.swing.JButton();
        Title = new javax.swing.JLabel();
        PrijemceText = new javax.swing.JTextField();
        Pridat = new javax.swing.JButton();
        PrijemceTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Nova.setBackground(new java.awt.Color(44, 62, 80));

        NSmlouvyTitle.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        NSmlouvyTitle.setForeground(new java.awt.Color(255, 255, 255));
        NSmlouvyTitle.setText("Číslo smlouvy:");

        IcoLekTitle.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        IcoLekTitle.setForeground(new java.awt.Color(255, 255, 255));
        IcoLekTitle.setText("ICO lekárny:");

        IcoSpolText.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        DodavatelTitle.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        DodavatelTitle.setForeground(new java.awt.Color(255, 255, 255));
        DodavatelTitle.setText("Dodavatel:");

        KonceTitle.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        KonceTitle.setForeground(new java.awt.Color(255, 255, 255));
        KonceTitle.setText("Konec:");

        IcoSpolTitle.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        IcoSpolTitle.setForeground(new java.awt.Color(255, 255, 255));
        IcoSpolTitle.setText("ICO společnosti:");

        ZacatekTitle.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        ZacatekTitle.setForeground(new java.awt.Color(255, 255, 255));
        ZacatekTitle.setText("Začátek:");

        IcoLekText.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        KonecText.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        DodavatelText.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        ZacatekText.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ZacatekText.setToolTipText("");

        NSmlouvyText.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        Zpet.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        Zpet.setText("Zpět");
        Zpet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ZpetMouseClicked(evt);
            }
        });

        Title.setFont(new java.awt.Font("Arial", 1, 34)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 255, 255));
        Title.setText("Nová smlouva");

        PrijemceText.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        Pridat.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        Pridat.setText("Přidat");
        Pridat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PridatActionPerformed(evt);
            }
        });

        PrijemceTitle.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        PrijemceTitle.setForeground(new java.awt.Color(255, 255, 255));
        PrijemceTitle.setText("Příjemce:");

        javax.swing.GroupLayout NovaLayout = new javax.swing.GroupLayout(Nova);
        Nova.setLayout(NovaLayout);
        NovaLayout.setHorizontalGroup(
            NovaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NovaLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(NovaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NovaLayout.createSequentialGroup()
                        .addGroup(NovaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NSmlouvyTitle)
                            .addComponent(IcoSpolTitle)
                            .addComponent(IcoLekTitle)
                            .addComponent(DodavatelTitle)
                            .addComponent(PrijemceTitle)
                            .addComponent(ZacatekTitle)
                            .addComponent(KonceTitle))
                        .addGap(23, 23, 23)
                        .addGroup(NovaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(KonecText, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IcoLekText, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IcoSpolText, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NSmlouvyText, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DodavatelText, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ZacatekText, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PrijemceText, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(NovaLayout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(Title)))
                .addContainerGap(95, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NovaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Zpet, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Pridat, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        NovaLayout.setVerticalGroup(
            NovaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NovaLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(NovaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NSmlouvyTitle)
                    .addComponent(NSmlouvyText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(NovaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IcoSpolTitle)
                    .addComponent(IcoSpolText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(NovaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IcoLekTitle)
                    .addGroup(NovaLayout.createSequentialGroup()
                        .addComponent(IcoLekText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(NovaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DodavatelTitle)
                            .addComponent(DodavatelText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(NovaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PrijemceTitle)
                            .addComponent(PrijemceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(NovaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ZacatekTitle)
                            .addComponent(ZacatekText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(NovaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(KonceTitle)
                            .addComponent(KonecText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addGroup(NovaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Pridat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Zpet, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Nova, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Nova, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ZpetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ZpetMouseClicked
        this.cust = cust;
        HomePage hm = new HomePage(cust);
        hm.setVisible(true);
        hm.pack();
        hm.setLocationRelativeTo(null);
        hm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_ZpetMouseClicked

    private void PridatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PridatActionPerformed
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
       
        int nSmlouva = Integer.parseInt(NSmlouvyText.getText());
        int ico_lek = Integer.parseInt(IcoLekText.getText());
        int ico_spol = Integer.parseInt(IcoSpolText.getText());
        String prijemce = PrijemceText.getText();
        String dodavatel = DodavatelText.getText();
        String zacatek = ZacatekText.getText();
        String konec = KonecText.getText();

        try {            
            // Get transaction and start
            et = em.getTransaction();
            et.begin();
                        
            // Create and set values for new customer
            Smlouva cu = new Smlouva();
                        
            cu.setNsmlouva(nSmlouva);
            cu.setIcolekarna(ico_lek);
            cu.setIcofarmspol(ico_spol);
            cu.setPrijemce(prijemce);
            cu.setDodavatel(dodavatel);
            cu.setZacatek(zacatek);
            cu.setKonec(konec);
                        
            em.persist(cu);
            et.commit();
            add(cust.getZamestnanecid(),cu.getNsmlouva());
            JOptionPane.showMessageDialog(null, "Smlouva pridana uspesne");
            
            HomePage hm = new HomePage(cust);
            hm.setVisible(true);
            hm.pack();
            hm.setLocationRelativeTo(null);
            hm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
        } catch (Exception ex) {
            // If there is an exception rollback changes
            JOptionPane.showMessageDialog(null, "Smlouva je existuje");
        } finally {
            // Close EntityManager
            em.close();
        }
    }//GEN-LAST:event_PridatActionPerformed

    private void add(int zamestnanecid, int nSmlouva) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        Farmaceut farm = null;
        Smlouva sm = null;
       
        try {            
            // Get transaction and start
            et = em.getTransaction();
            et.begin();
                        
            farm = em.find(Farmaceut.class, zamestnanecid);
            
            sm = em.find(Smlouva.class, nSmlouva);
            
            List<Smlouva> smlouvy = new ArrayList<>();

            smlouvy = farm.getSmlouvy();
            
            smlouvy.add(sm);
            
            
            farm.setSmlouvy(smlouvy);
            //Save the customer object
            em.persist(farm);
            et.commit();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Smlouva je");
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DodavatelText;
    private javax.swing.JLabel DodavatelTitle;
    private javax.swing.JTextField IcoLekText;
    private javax.swing.JLabel IcoLekTitle;
    private javax.swing.JTextField IcoSpolText;
    private javax.swing.JLabel IcoSpolTitle;
    private javax.swing.JLabel KonceTitle;
    private javax.swing.JTextField KonecText;
    private javax.swing.JTextField NSmlouvyText;
    private javax.swing.JLabel NSmlouvyTitle;
    private javax.swing.JPanel Nova;
    private javax.swing.JButton Pridat;
    private javax.swing.JTextField PrijemceText;
    private javax.swing.JLabel PrijemceTitle;
    private javax.swing.JLabel Title;
    private javax.swing.JTextField ZacatekText;
    private javax.swing.JLabel ZacatekTitle;
    private javax.swing.JButton Zpet;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}