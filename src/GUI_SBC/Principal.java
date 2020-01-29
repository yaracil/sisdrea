/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_SBC;

import AdaptationModule.AdaptationByFuzzyLogic;
import AdaptationModule.AdaptationByReInstantiation;
import AdaptationModule.EvaluationResponseDescription;
import CaseBaseModel.REA;
import CaseBaseModel.REAs;
import ConectionInterface.RestConectionUser;
import RecoveryModule.SimilarItems;
import RecoveryModule.SimilarityDescription;
import RecoveryModule.SimilarityEngine;
import com.nilo.plaf.nimrod.NimRODLookAndFeel;
import com.nilo.plaf.nimrod.NimRODTheme;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import ConectionInterface.XmlLomReader;

/**
 *
 * @author yoe
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     *
     * @param recursos
     */
    public REAs recursos;
    public SimilarItems similares;

    public Principal() throws UnsupportedLookAndFeelException {
        initComponents();
        this.recursos = new REAs();
        similares = null;
        this.setLocation(50, 100);
//        this.jTextArea4.setBackground(Color.orange);
//        this.jTextArea5.setBackground(Color.orange);
        this.jTextArea4.setFont(new Font("txt", 1, 12));
        this.jTextArea5.setFont(new Font("txt", 1, 12));
        this.jMenuItem7.setEnabled(false);

        nimrod();
        setLocationRelativeTo(null);
    }

    public void nimrod() throws UnsupportedLookAndFeelException {
        try {
            UIManager.setLookAndFeel("com.nilo.plaf.nimrod.NimRODLookAndFeel");

            SwingUtilities.updateComponentTreeUI(Principal.this);

            NimRODTheme nt = new NimRODTheme();
            nt.setPrimary1(new Color(80, 80, 80));
            nt.setPrimary2(new Color(90, 90, 90));
            nt.setPrimary3(new Color(80, 80, 80));
//nt.setSecondary1( new Color(110,110,110));
//nt.setSecondary2( new Color(50,50,50));
//nt.setSecondary3( new Color(80,80,80));
            nt.setMenuOpacity(0);
            nt.setOpacity(0);
            nt.setFrameOpacity(0);

//nt.setPrimary3( new Color(255,255,255));
            NimRODLookAndFeel NimRODLF = new NimRODLookAndFeel();
            NimRODLF.setCurrentTheme(nt);
            UIManager.setLookAndFeel(NimRODLF);

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void fillData() {
        String resp = "";
        int cant = 1;

        Iterator ite = recursos.getIterator();
        while (ite.hasNext()) {
            REA rea = (REA) ite.next();
            resp += "\n" + "\n" + "RECURSO: " + cant++ + "\n";
            resp += rea.toStringWithEvaluation();
//            Iterator it = rea.getIterator();
//            while (it.hasNext()) {
//                LomStandar_Rasgo rasgo = (LomStandar_Rasgo) it.next();
//                resp += "\n" + rasgo.toString();
//            }

        }
        jTextArea4.setText(resp);
        this.jMenuItem7.setEnabled(true);

    }

    public void fillSimilar(REA target, SimilarItems simi) {
        String resp = "***CASO BASE***" + "\n" + target.toString() + "\n";
        resp += "\n" + "***CASOS SIMILARES***";

        Iterator similares = simi.iterator();

        while (similares.hasNext()) {
            SimilarityDescription rasgo = (SimilarityDescription) similares.next();
            resp += "\n" + rasgo.toString();
        }
        jTextArea5.setText(resp);
    }

    public void limpiar() {
        jTextArea4.setText("");
        jTextArea5.setText("");
        this.recursos = new REAs();
        this.similares = new SimilarItems();
        this.jMenuItem7.setEnabled(false);
    }

    public void doInferencia(REA target) {
        SimilarityEngine sbc = new SimilarityEngine();
        try {
            SimilarItems similares = sbc.computeSimilarity(recursos, target);
            this.similares = similares;
            fillSimilar(target, similares);
        } catch (Exception ex) {
            Logger.getLogger(setREA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public REAs getRecursos() {
        return recursos;
    }

    public void setRecursos(REAs recursos) {
        this.recursos = recursos;
    }

    public void addRecurso(REA rea) {
        try {
            this.recursos.addREA(rea);
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
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

        jMenu3 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("BASE DE CASOS"));

        jTextArea4.setEditable(false);
        jTextArea4.setBackground(new java.awt.Color(255, 204, 0));
        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane6.setViewportView(jTextArea4);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1025, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("CASOS SEMEJANTES"));
        jPanel3.setFocusable(false);

        jTextArea5.setEditable(false);
        jTextArea5.setBackground(new java.awt.Color(255, 204, 0));
        jTextArea5.setColumns(20);
        jTextArea5.setRows(5);
        jScrollPane7.setViewportView(jTextArea5);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane7)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
        );

        jMenu5.setText("BASE DE CASOS");

        jMenuItem7.setText("REINICIAR BASE DE CASOS");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem7);

        jMenuItem1.setText("CARGAR CASO");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        jMenuItem6.setText("OBTENER RECURSOS DE RHODA");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem6);

        jMenuBar2.add(jMenu5);

        jMenu7.setText("BUSQUEDA BASADA EN CASOS");

        jMenuItem3.setText("ENTRAR CASO BASE");
        jMenuItem3.setToolTipText("");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem3);

        jMenuItem4.setText("CARGAR CASO BASE");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem4);

        jMenuItem5.setText("INFERIR PROBLEMAS X REINSTANCIACION");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem5);

        jMenuItem2.setText("INFERIR PROBLEMAS X LOGICA FUZZY");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem2);

        jMenuBar2.add(jMenu7);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File("C:\\Users\\Yoe\\Documents\\!!TESIS\\Base de Casos"));
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

            XmlLomReader xml = null;
            try {
                xml = new XmlLomReader(fc.getSelectedFile());
            } catch (Exception ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            REA rea = xml.toREA();
            if (rea.getId().isEmpty()) {
                Evaluar evaluation = new Evaluar(this, rootPaneCheckingEnabled, rea);
                evaluation.setLocationRelativeTo(this);
                evaluation.setVisible(rootPaneCheckingEnabled);
            }
        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        setREA newREA = new setREA(this, 2);
        newREA.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:

        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File("C:\\Users\\Yoe\\Documents\\!!TESIS\\Base de Casos"));
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            XmlLomReader xml = null;
            try {
                xml = new XmlLomReader(fc.getSelectedFile());
            } catch (Exception ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            doInferencia(xml.toREA());
        }

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        if (similares == null) {
            JOptionPane.showMessageDialog(rootPane, "Cargar Caso Base");

        } else {
            AdaptationByReInstantiation adaptacion = new AdaptationByReInstantiation();
            EvaluationResponseDescription resp = adaptacion.AdaptationByReinstantiation(similares);
            String adap = adaptacion.getProblemsResponse(resp);
            jTextArea5.setText(jTextArea5.getText() + "\n" + "***********************" + "\n" + adap);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        int opcion = JOptionPane.showConfirmDialog(rootPane, "CONECTAR CON REPOSITORIO RHODA");
        if (opcion == 0) {
            RestConectionUser coneccion = new RestConectionUser();
            try {
                REAs toAdd = coneccion.getReas();
                this.recursos.addReas(toAdd);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error de conexión", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            fillData();

        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        limpiar();

    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        if (similares == null) {
            JOptionPane.showMessageDialog(rootPane, "Cargar Caso Base");

        } else {
            AdaptationByFuzzyLogic adaptacion = new AdaptationByFuzzyLogic();
            EvaluationResponseDescription resp = adaptacion.AdaptationByFuzzyLogic(similares);
            String adap = adaptacion.getProblemsResponse(resp);
            jTextArea5.setText(jTextArea5.getText() + "\n" + "**************************************************" + "\n" + adap);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Principal().setVisible(true);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    // End of variables declaration//GEN-END:variables
}
