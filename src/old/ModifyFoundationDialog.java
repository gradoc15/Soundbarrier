/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old;

import javax.swing.JOptionPane;

public class ModifyFoundationDialog extends javax.swing.JDialog
{

    /**
     * Konstruktur für den ModifyFoundation Dialog
     * @param parent
     * @param modal
     * @param fd Foundation Objekt, von welchem die Daten in die GUI eingetragen werden.
     */
    public ModifyFoundationDialog(java.awt.Frame parent, boolean modal, parts.Foundation fd) throws Exception
    {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        
        tfBreite.setText(""+fd.getBreite());
        tfHohe.setText(""+fd.getHoehe());
        
        throw new Exception("Outdated");
    }

    private boolean okay;
    private double hoehe;
    private double breite;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfBreite = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfHohe = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(3, 2));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Breite: ");
        getContentPane().add(jLabel1);
        getContentPane().add(tfBreite);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Höhe: ");
        getContentPane().add(jLabel2);
        getContentPane().add(tfHohe);

        jButton1.setText("Bestätigen");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onOkay(evt);
            }
        });
        getContentPane().add(jButton1);

        jButton2.setText("Abbrechen");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onCancle(evt);
            }
        });
        getContentPane().add(jButton2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Actionevent für den Button "Okay", überprüft die Eingegebenen Daten
     * auf Datentyps Fehler, falls alle korrekt sind wird okay auf true gesetzt
     * und der Dialog geschlossen.
     * @param evt 
     */
    private void onOkay(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onOkay
    {//GEN-HEADEREND:event_onOkay
        try
        {
            hoehe = Double.parseDouble(tfHohe.getText());
            breite = Double.parseDouble(tfBreite.getText());
            
            okay = true;
            this.dispose();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_onOkay

    /**
     * Actionevent für den Button "Cancle". Der Dialog wird beendet
     * @param evt 
     */
    private void onCancle(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onCancle
    {//GEN-HEADEREND:event_onCancle
        this.dispose();
    }//GEN-LAST:event_onCancle

    /**
     * Getter für okay
     * @return die Variable Okay wird zurückgegeben
     */
    public boolean isOkay()
    {
        return okay;
    }

    /**
     * Getter für hoehe
     * @return der Wert der Variable hoehe wird zurückgegeben
     */
    public double getHoehe()
    {
        return hoehe;
    }
   
    /**
     * Getter für Breite 
     * @return der Wert der Variable Breite wird zurückgegeben
     */
    public double getBreite()
    {
        return breite;
    }


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField tfBreite;
    private javax.swing.JTextField tfHohe;
    // End of variables declaration//GEN-END:variables
}
