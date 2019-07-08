/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old;

import parts.Barrier;
import data.Material;
import javax.swing.JOptionPane;

public class CreateDialog extends javax.swing.JDialog
{

    /**
     * Creates new form CreateDialog
     */
    public CreateDialog(java.awt.Frame parent, boolean modal) throws Exception
    {
        super(parent, modal);
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        for(data.Material m: data.Material.values())
        {
            cbMaterial.addItem(m);
        }
        
        throw new Exception("Outdated");
    }
    
    private boolean okay;
    private double hoehe;
    private double breite;
    private double hoeheFundament;
    private data.Material mat;
    private boolean withFoundation;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbBreite = new javax.swing.JLabel();
        tfBreite = new javax.swing.JTextField();
        lbHoehe = new javax.swing.JLabel();
        tfHoehe = new javax.swing.JTextField();
        lbMaterial = new javax.swing.JLabel();
        cbMaterial = new javax.swing.JComboBox<>();
        lbFundamentErstellen = new javax.swing.JLabel();
        cbFundament = new javax.swing.JCheckBox();
        lbHoheFundament = new javax.swing.JLabel();
        tfFundementHohe = new javax.swing.JTextField();
        btOkay = new javax.swing.JButton();
        btCancle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(6, 2));

        lbBreite.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBreite.setText("Breite: ");
        getContentPane().add(lbBreite);

        tfBreite.setText("10");
        getContentPane().add(tfBreite);

        lbHoehe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHoehe.setText("Höhe: ");
        getContentPane().add(lbHoehe);

        tfHoehe.setText("7");
        tfHoehe.setToolTipText("");
        getContentPane().add(tfHoehe);

        lbMaterial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMaterial.setText("Material:");
        getContentPane().add(lbMaterial);

        getContentPane().add(cbMaterial);

        lbFundamentErstellen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFundamentErstellen.setText("Fundament erstellen: ");
        getContentPane().add(lbFundamentErstellen);

        cbFundament.setSelected(true);
        cbFundament.setText("ja");
        cbFundament.setToolTipText("");
        cbFundament.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                onCbFundamentErstellenChanged(evt);
            }
        });
        getContentPane().add(cbFundament);

        lbHoheFundament.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHoheFundament.setText("Höhe des Fundaments: ");
        lbHoheFundament.setToolTipText("");
        getContentPane().add(lbHoheFundament);

        tfFundementHohe.setText("2");
        getContentPane().add(tfFundementHohe);

        btOkay.setText("Bestätigen");
        btOkay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onOkay(evt);
            }
        });
        getContentPane().add(btOkay);

        btCancle.setText("Abbrechen");
        btCancle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onCancle(evt);
            }
        });
        getContentPane().add(btCancle);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Actionevent für den Butten "Okay"
     * Die Eingabe wird auf Datentypen fehler überprüft, falls alles
     * korrekt ist wird okay auf true gesetzt und der Dialog geschlossen.
     * @param evt 
     */
    private void onOkay(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onOkay
    {//GEN-HEADEREND:event_onOkay
        try
        {
            hoehe = Double.parseDouble(tfHoehe.getText());
            breite = Double.parseDouble(tfBreite.getText());
            hoeheFundament = Double.parseDouble(tfFundementHohe.getText());
            mat = (data.Material)cbMaterial.getSelectedItem();
            okay = true;
            this.dispose();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_onOkay

    /**
     * Actionevent für den Button "Cancle"
     * Der Dialog wird gegschlossen.
     * @param evt 
     */
    private void onCancle(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onCancle
    {//GEN-HEADEREND:event_onCancle
        this.dispose();
    }//GEN-LAST:event_onCancle

    
    /**
     * ChangeEvent für die Checkbox zum Fundermenterstellen
     * Falls die Checkbox selektiert ist wird die bearbeitung der höhe aktiviert,
     * anderen falls wird die bearbeitung der höhe auf  gesetzt und deaktiviert
     * @param evt 
     */
    private void onCbFundamentErstellenChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_onCbFundamentErstellenChanged
    {//GEN-HEADEREND:event_onCbFundamentErstellenChanged
        if(cbFundament.isSelected())
            tfFundementHohe.setEditable(true);
        else
        {
            tfFundementHohe.setEditable(false);
        }
    }//GEN-LAST:event_onCbFundamentErstellenChanged

    /**
     * Getter für okay
     * @return gibt den Wert der Varible okay zurück
     */
    public boolean isOkay()
    {
        return okay;
    }

    /**
     * Getter für hoehe
     * @return Gibt den Wert der Varible hoehe zurück
     */
    public double getHoehe()
    {
        return hoehe;
    }

    /**
     * Getter für breite
     * @return gibt den Wert der Varible für breite zurück
     */
    public double getBreite()
    {
        return breite;
    }
    
    /**
     * Getter für die Checkbox für die Auwahl des Fundaments
     * @return Falls die Checkbox selektierit ist wird ein true zurückgeben, falls
     * nicht wird false zurückgegeben
     */
    public boolean withFoundation()
    {
        return cbFundament.isSelected();
    }

    /**
     * Getter für mat
     * @return gibt den Wert der Variable mat zurück
     */
    public Material getMat()
    {
        return mat;
    }

    /**
     * Getter für hoeheFundament
     * @return gibt den Wert der varible hoeheFundament zurück
     */
    public double getHoeheFundament()
    {
        return hoeheFundament;
    }
    
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancle;
    private javax.swing.JButton btOkay;
    private javax.swing.JCheckBox cbFundament;
    private javax.swing.JComboBox<data.Material> cbMaterial;
    private javax.swing.JLabel lbBreite;
    private javax.swing.JLabel lbFundamentErstellen;
    private javax.swing.JLabel lbHoehe;
    private javax.swing.JLabel lbHoheFundament;
    private javax.swing.JLabel lbMaterial;
    private javax.swing.JTextField tfBreite;
    private javax.swing.JTextField tfFundementHohe;
    private javax.swing.JTextField tfHoehe;
    // End of variables declaration//GEN-END:variables
}
