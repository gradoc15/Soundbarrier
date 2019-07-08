/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

public class ModifyDefectDialog extends javax.swing.JDialog
{

    /**
     * Creates new form ModifyDefectDialog
     * @param parent
     */
    public ModifyDefectDialog(java.awt.Frame parent, boolean modal, parts.Defect def)
    {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        tfComment.setText(def.getComment());
    }

    
    private boolean okay = false;
    String comment = "";
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfComment = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btOkay = new javax.swing.JButton();
        btCancle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 200));
        getContentPane().setLayout(new java.awt.GridLayout(2, 1));
        getContentPane().add(tfComment);

        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        btOkay.setText("Bestätigen");
        btOkay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onOkay(evt);
            }
        });
        jPanel1.add(btOkay);

        btCancle.setText("Abbrechen");
        btCancle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onCancle(evt);
            }
        });
        jPanel1.add(btCancle);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Actionevent für den Button "Okay", dass eingetragene Kommentar wird gespeichert,
     * okay auf true gesetzt und der Dialog geschlossen
     * @param evt 
     */
    private void onOkay(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onOkay
    {//GEN-HEADEREND:event_onOkay
       comment = tfComment.getText();
       okay = true;
       this.dispose();
    }//GEN-LAST:event_onOkay

    /**
     * Actionevent für den Button "Cancle", der Dialog wird geschlossen
     * @param evt 
     */
    private void onCancle(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onCancle
    {//GEN-HEADEREND:event_onCancle
        this.dispose();
    }//GEN-LAST:event_onCancle

    /**
     * Getter für okay
     * @return der Wert der variable okay wird zurückgeben
     */
    public boolean isOkay()
    {
        return okay;
    }

    /**
     * Getter für comment
     * @return der Wert der Variable comment wird zurückgeben
     */
    public String getComment()
    {
        return comment;
    }

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancle;
    private javax.swing.JButton btOkay;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfComment;
    // End of variables declaration//GEN-END:variables
}
