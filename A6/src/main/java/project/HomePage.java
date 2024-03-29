/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import DBS.Farmaceut;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;

/**
 *
 * @author Adilbek Utemissov
 */
public class HomePage extends javax.swing.JFrame {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("Pharmacy");
    private Farmaceut cust;
    /**
     * Creates new form HomePage
     */
    public HomePage(Farmaceut cust) {
        this.cust = cust;
        initComponents();
//        this.refresh();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hlavni = new javax.swing.JPanel();
        Logout = new javax.swing.JButton();
        NewContract = new javax.swing.JButton();
        ViewContacts = new javax.swing.JButton();
        ViewMySmlouvy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        hlavni.setBackground(new java.awt.Color(44, 62, 80));

        Logout.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        NewContract.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        NewContract.setText("New Contract");
        NewContract.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NewContractMouseClicked(evt);
            }
        });

        ViewContacts.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        ViewContacts.setText("View Contracts");
        ViewContacts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ViewContactsMouseClicked(evt);
            }
        });

        ViewMySmlouvy.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        ViewMySmlouvy.setText("View My Contracts");
        ViewMySmlouvy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ViewMySmlouvyMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout hlavniLayout = new javax.swing.GroupLayout(hlavni);
        hlavni.setLayout(hlavniLayout);
        hlavniLayout.setHorizontalGroup(
            hlavniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hlavniLayout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addGroup(hlavniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ViewMySmlouvy, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ViewContacts, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NewContract, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89))
        );
        hlavniLayout.setVerticalGroup(
            hlavniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hlavniLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(NewContract, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(ViewContacts, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(ViewMySmlouvy, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hlavni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hlavni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        em.close();
        LoginForm lgf = new LoginForm();
        lgf.setVisible(true);
        lgf.pack();
        lgf.setLocationRelativeTo(null);
        lgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_LogoutActionPerformed

    private void NewContractMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewContractMouseClicked
        NewContract nc = new NewContract(cust);
        System.out.println(cust);
        nc.setVisible(true);
        nc.pack();
        nc.setLocationRelativeTo(null);
        nc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_NewContractMouseClicked

    private void ViewContactsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewContactsMouseClicked
        ViewContracts vc = new ViewContracts(cust);
        vc.setVisible(true);
        vc.pack();
        vc.setLocationRelativeTo(null);
        vc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_ViewContactsMouseClicked

    private void ViewMySmlouvyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewMySmlouvyMouseClicked
        MySmlouvy ms = new MySmlouvy(cust);
        ms.setVisible(true);
        ms.pack();
        ms.setLocationRelativeTo(null);
        ms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
        
    }//GEN-LAST:event_ViewMySmlouvyMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Logout;
    private javax.swing.JButton NewContract;
    private javax.swing.JButton ViewContacts;
    private javax.swing.JButton ViewMySmlouvy;
    private javax.swing.JPanel hlavni;
    // End of variables declaration//GEN-END:variables
}
