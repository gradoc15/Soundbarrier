/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.LinkedList;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import parts.WallComponent;

/**
 *
 * @author User
 */
public class CreateComponent extends javax.swing.JDialog {

    private double x, y;
    private boolean changeMode  = false;
    
    private JPanel panel;
    private int rows = 2;
    private int cols = 2;
    
    private boolean okay;
    private LinkedList<parts.WallComponent> createdComponents = new LinkedList();
    
    private LinkedList<JComponent> actLoadedPrimary = new LinkedList();
    
    private data.Components selectedPrimaryComp = null;
    
    
    public CreateComponent(java.awt.Frame parent, boolean modal, double x, double y) {
        super(parent, modal);
        initComponents();
        
        this.x = x;
        this.y = y;
        
        selectedPrimaryComp = data.Components.BARRIER;
        loadBarrierInput();
        rows += actLoadedPrimary.size()/2;
        
        rebuildFrame();
        
    }
    
    public CreateComponent(java.awt.Frame parent, boolean modal, data.Components changeMode, parts.WallComponent comp) {
        super(parent, modal);
        initComponents();
        
        this.changeMode = true;
        
        
        
        selectedPrimaryComp = changeMode;
        
        unloadPrimaryComponent();
        loadModules();
        
        if(comp != null)
        {
            fillModule(comp);
            this.x = comp.getPosX();
            this.y = comp.getPosY();
        }
        else
        {
            this.x = 0;
            this.y = 0;
        }
        
        rebuildFrame();
        
    }
    
    public void rebuildFrame()
    {
        JComboBox<data.Components> cbPrimaryComp = new JComboBox<>();
        for(data.Components c: data.Components.values())
            cbPrimaryComp.addItem(c);
        
        if(changeMode)
            cbPrimaryComp.setEditable(okay);
        
        if(panel != null)
        {
            this.remove(panel);
            cbPrimaryComp.setSelectedItem(selectedPrimaryComp);
        }
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(rows, cols));
        
        JLabel lbPrimaryComp = new JLabel("Hauptkompnente");
        lbPrimaryComp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panel.add(lbPrimaryComp);
        
        
        cbPrimaryComp.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                onItemChangedCbPrimaryComp(cbPrimaryComp);
            }
        });
        
        panel.add(cbPrimaryComp);
        
        //Loading Comps
        loadPrimaryComponent();
        //End Loading Comps
        
        JButton btOkay = new JButton("Bestätigen");
        btOkay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onActionOkay();
            }
        });
        panel.add(btOkay);
        
        JButton btCancle = new JButton("Abbrechen");
        btCancle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onActionCancle();
            }
        });
        panel.add(btCancle);
        
        panel.updateUI();
        
        this.add(panel, BorderLayout.CENTER);
        this.setSize(550, rows*75);
        
    }
    
    public void onActionOkay()
    {
        try
        {
            createComponents();
            okay = true;
            this.dispose();
        }
        catch(NumberFormatException nfe)
        {
            JOptionPane.showMessageDialog(this, "Bitte fülle alle notwendigen Fehlder mit Werten aus");
        }
        
    }
    
    public void onActionCancle()
    {
        this.dispose();
    }
    
    private void createComponents()
    {
       
        if (selectedPrimaryComp.equals(data.Components.BARRIER)) {
            createdComponents.add(createBarrier());
        } else if (selectedPrimaryComp.equals(data.Components.FOUNDATION)) {
            createdComponents.add(createFoundation());
        } else if (selectedPrimaryComp.equals(data.Components.DOOR)) {
            createdComponents.add(createDoor());
        } else if (selectedPrimaryComp.equals(data.Components.BARRIER_AND_DOOR)) 
        {
            createdComponents.add(createBarrier());
            createdComponents.add(createDoor());
            
            //Türe ausrichten via Barriere
            createdComponents.getLast().setPosY(createdComponents.getFirst().getPosY()-(((parts.Barrier)createdComponents.getFirst()).getHoehe())+(((parts.Door)createdComponents.getLast()).getHoehe()));
            createdComponents.getLast().setPosX(createdComponents.getFirst().getPosX()+(((parts.Barrier)createdComponents.getFirst()).getBreite()/2)-(((parts.Door)createdComponents.getLast()).getBreite()/2));
        } else if (selectedPrimaryComp.equals(data.Components.BARRIER_AND_FOUNDATION)) {
            createdComponents.add(createBarrier());
            createdComponents.add(createFoundation());
            
            //Fundament ausrichten via Barriere
            createdComponents.getLast().setPosY(createdComponents.getFirst().getPosY()-(((parts.Barrier)createdComponents.getFirst()).getHoehe()));

        } else if (selectedPrimaryComp.equals(data.Components.FOUNDATION_AND_DOOR)) {
            createdComponents.add(createFoundation());         
            createdComponents.add(createDoor());
            
            //Türe ausrichten via Fundament
            createdComponents.getLast().setPosY(createdComponents.getFirst().getPosY()+(((parts.Door)createdComponents.getLast()).getHoehe()));
            createdComponents.getLast().setPosX(createdComponents.getFirst().getPosX()+(((parts.Foundation)createdComponents.getFirst()).getBreite()/2)-(((parts.Door)createdComponents.getLast()).getBreite()/2));


        } else if (selectedPrimaryComp.equals(data.Components.BARRIER_AND_FOUNDATION_AND_DOOR)) {
            createdComponents.add(createBarrier());
            createdComponents.add(createFoundation());
            
            //Fundament ausrichten via Barriere
            createdComponents.getLast().setPosY(createdComponents.getFirst().getPosY()-(((parts.Barrier)createdComponents.getFirst()).getHoehe()));
            
            createdComponents.add(createDoor());
            
            //Türe ausrichten via Barriere
            createdComponents.getLast().setPosY(createdComponents.getFirst().getPosY()-(((parts.Barrier)createdComponents.getFirst()).getHoehe())+(((parts.Door)createdComponents.getLast()).getHoehe()));
            createdComponents.getLast().setPosX(createdComponents.getFirst().getPosX()+(((parts.Barrier)createdComponents.getFirst()).getBreite()/2)-(((parts.Door)createdComponents.getLast()).getBreite()/2));
        }
        
    }
    
    private parts.Barrier createBarrier()
    {
        double breite = -1;
        double hoeheL = -1;
        double hoeheR = -1;
        data.Material mat = null;
        
        for(JComponent comp: actLoadedPrimary)
        {
            if(comp.getName() != null)
            {
                if(comp instanceof JTextField)
                {
                    if(comp.getName().equals("tfBarrierHoeheL"))
                        if(((JTextField) comp).getText().isEmpty())
                            hoeheL = -1;
                        else
                            hoeheL = Double.parseDouble(((JTextField) comp).getText().replace(',', '.'));
                    else if(comp.getName().equals("tfBarrierHoeheR"))
                    {
                        if(((JTextField) comp).getText().isEmpty())
                            hoeheR = -1;
                        else
                            hoeheR = Double.parseDouble(((JTextField) comp).getText().replace(',', '.'));
                    }
                    else if(comp.getName().equals("tfBarrierBreite"))
                            breite = Double.parseDouble(((JTextField) comp).getText().replace(',', '.'));
                }
                else if(comp instanceof JComboBox && comp.getName().equals("cbBarrierMaterial"))
                        mat = (data.Material)((JComboBox)comp).getSelectedItem();
                    
            }
        }
        
        System.out.println(mat);
        if(breite == -1 || (hoeheL == -1 && hoeheR == -1))
            throw new NumberFormatException();
        
        return new parts.Barrier(x, y, breite, (hoeheL != -1 ? hoeheL : hoeheR), (hoeheR != -1 ? hoeheR : hoeheL), mat);
    }
    
    private parts.Foundation createFoundation()
    {
        double breite = -1;
        double hoehe = -1;
        
        for(JComponent comp: actLoadedPrimary)
        {
            if(comp.getName() != null)
            {
                if(comp instanceof JTextField)
                {
                    if(comp.getName().equals("tfFoundationHoehe"))
                        hoehe = Double.parseDouble(((JTextField) comp).getText().replace(',', '.'));
                    else if(comp.getName().equals("tfFoundationBreite"))
                        breite = Double.parseDouble(((JTextField) comp).getText().replace(',', '.'));
                }
            }
        }
        
        if(breite == -1 || hoehe == -1)
            throw new NumberFormatException();
        
        return new parts.Foundation(x, y, breite, hoehe);
    }
    
    private parts.Door createDoor()
    {
        double breite = -1;
        double hoehe = -1;
        
        for(JComponent comp: actLoadedPrimary)
        {
            if(comp.getName() != null)
            {
                if(comp instanceof JTextField)
                {
                    if(comp.getName().equals("tfDoorHoehe"))
                        hoehe = Double.parseDouble(((JTextField) comp).getText().replace(',', '.'));
                    else if(comp.getName().equals("tfDoorBreite"))
                        breite = Double.parseDouble(((JTextField) comp).getText().replace(',', '.'));
                }
            }
        }
        
        if(breite == -1 || hoehe == -1)
            throw new NumberFormatException();
        
        return new parts.Door(x, y, breite, hoehe);
    }
    
    public void onItemChangedCbPrimaryComp(JComboBox<data.Components> cbPrimaryComb)
    {
        selectedPrimaryComp = (data.Components)cbPrimaryComb.getSelectedItem();
        
        unloadPrimaryComponent();
        
        loadModules();
    }
    
    private void loadModules()
    {
        if(selectedPrimaryComp.equals(data.Components.BARRIER))
            loadBarrierInput(); 
        else if(selectedPrimaryComp.equals(data.Components.FOUNDATION))
            loadFoundationInput();
        else if(selectedPrimaryComp.equals(data.Components.DOOR))
            loadDoorInput();
        else if(selectedPrimaryComp.equals(data.Components.BARRIER_AND_DOOR))
        {
            loadBarrierInput();
            loadDoorInput();
        }
        else if(selectedPrimaryComp.equals(data.Components.BARRIER_AND_FOUNDATION))
        {
            loadBarrierInput();
            loadFoundationInput();
        }
        else if(selectedPrimaryComp.equals(data.Components.FOUNDATION_AND_DOOR))
        {
            loadFoundationInput();
            loadDoorInput();
        }
        else if(selectedPrimaryComp.equals(data.Components.BARRIER_AND_FOUNDATION_AND_DOOR))
        {
            loadBarrierInput();
            loadFoundationInput();
            loadDoorInput();
        }
        rows += actLoadedPrimary.size()/2;
        rebuildFrame();
    }
    
    
    
    //Beginn LoadMethods
    private void loadBarrierInput()
    {   
        JLabel lbHeadline1 = new JLabel(data.Components.BARRIER.toString().substring(0, data.Components.BARRIER.toString().length()/2));
        lbHeadline1.setFont(new Font("Dialog", 1, 18));
        actLoadedPrimary.add(lbHeadline1);
        JLabel lbHeadline2 = new JLabel(data.Components.BARRIER.toString().substring(data.Components.BARRIER.toString().length()/2));
        lbHeadline2.setFont(new Font("Dialog", 1, 18));
        actLoadedPrimary.add(lbHeadline2);
        
        lbHeadline1.setName("lbHeadline1");
        lbHeadline2.setName("lbHeadline2");
        
        JLabel lbHoeheL = new JLabel("Höhe Links: ");
        JLabel lbHoeheR = new JLabel("Höhe Rechts: ");
        JLabel lbBreite = new JLabel("Breite: ");
        JLabel lbMaterial = new JLabel("Material: ");
        
        JTextField tfHoeheL = new JTextField();
        tfHoeheL.setName("tfBarrierHoeheL");
        JTextField tfHoeheR = new JTextField();
        tfHoeheR.setName("tfBarrierHoeheR");
        JTextField tfBreite = new JTextField();
        tfBreite.setName("tfBarrierBreite");
        JComboBox<data.Material> cbMaterial = new JComboBox();
        cbMaterial.setName("cbBarrierMaterial");
        for(data.Material mat : data.Material.values())
            cbMaterial.addItem(mat);
        
        
        actLoadedPrimary.add(lbHoeheL);
        actLoadedPrimary.add(tfHoeheL);
        actLoadedPrimary.add(lbHoeheR);
        actLoadedPrimary.add(tfHoeheR);
        actLoadedPrimary.add(lbBreite);
        actLoadedPrimary.add(tfBreite);
        actLoadedPrimary.add(lbMaterial);
        actLoadedPrimary.add(cbMaterial);
    }
    
    private void loadFoundationInput()
    {
        JLabel lbHeadline1 = new JLabel(data.Components.FOUNDATION.toString().substring(0, data.Components.FOUNDATION.toString().length()/2));
        lbHeadline1.setFont(new Font("Dialog", 1, 18));
        actLoadedPrimary.add(lbHeadline1);
        JLabel lbHeadline2 = new JLabel(data.Components.FOUNDATION.toString().substring(data.Components.FOUNDATION.toString().length()/2));
        lbHeadline2.setFont(new Font("Dialog", 1, 18));
        actLoadedPrimary.add(lbHeadline2);
        
        lbHeadline1.setName("lbHeadline1");
        lbHeadline2.setName("lbHeadline2");
        
        JLabel lbHoehe = new JLabel("Höhe: ");
        JLabel lbBreite = new JLabel("Breite: ");
        
        JTextField tfHoehe = new JTextField();
        tfHoehe.setName("tfFoundationHoehe");
        JTextField tfBreite = new JTextField(); 
        tfBreite.setName("tfFoundationBreite");
        actLoadedPrimary.add(lbHoehe);
        actLoadedPrimary.add(tfHoehe);
        actLoadedPrimary.add(lbBreite);
        actLoadedPrimary.add(tfBreite);
    }
    
    private void loadDoorInput()
    {
        JLabel lbHeadline1 = new JLabel(data.Components.DOOR.toString().substring(0, data.Components.DOOR.toString().length()/2));
        lbHeadline1.setFont(new Font("Dialog", 1, 18));
        actLoadedPrimary.add(lbHeadline1);
        JLabel lbHeadline2 = new JLabel(data.Components.DOOR.toString().substring(data.Components.DOOR.toString().length()/2));
        lbHeadline2.setFont(new Font("Dialog", 1, 18));
        actLoadedPrimary.add(lbHeadline2);
        
        lbHeadline1.setName("lbHeadline1");
        lbHeadline2.setName("lbHeadline2");
        
        actLoadedPrimary.add(new JLabel("Höhe: "));
        JTextField tfHoehe = new JTextField();
        tfHoehe.setName("tfDoorHoehe");
        actLoadedPrimary.add(tfHoehe);
        actLoadedPrimary.add(new JLabel("Breite: "));
        JTextField tfBreite = new JTextField();
        tfBreite.setName("tfDoorBreite");
        actLoadedPrimary.add(tfBreite);
    }
    
    private void loadPrimaryComponent()
    {
        for(JComponent comp: actLoadedPrimary)
        {
            if(comp instanceof JLabel)
            {
                if(comp.getName() != null)
                {
                    if(comp.getName().equals("lbHeadline1"))
                        ((JLabel)comp).setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                    else if(comp.getName().equals("lbHeadline2"))
                        ((JLabel)comp).setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                    else
                        ((JLabel)comp).setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                }
                else
                    ((JLabel)comp).setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            }
            panel.add(comp);
        }

    }
    
    private void unloadPrimaryComponent()
    {
        rows -= actLoadedPrimary.size()/2;
        for(JComponent comp: actLoadedPrimary)
        {
            panel.remove(comp);
        }
        actLoadedPrimary.clear();
    }
    
    private void fillModule(parts.WallComponent givenComp)
    {
        if(givenComp != null)
        {
            if(givenComp instanceof parts.Barrier)
            {
                for(JComponent comp: actLoadedPrimary)
                {
                    if(comp.getName() != null)
                    {
                        if(comp instanceof JTextField)
                        {
                            if(comp.getName().equals("tfBarrierHoeheL"))
                                ((JTextField) comp).setText(""+((parts.Barrier)givenComp).getHoeheL());
                            else if(comp.getName().equals("tfBarrierHoeheR"))
                                ((JTextField) comp).setText(""+((parts.Barrier)givenComp).getHoeheR());
                            else if(comp.getName().equals("tfBarrierBreite"))
                                ((JTextField) comp).setText(""+((parts.Barrier)givenComp).getBreite());
                        }
                        else if(comp instanceof JComboBox && comp.getName().equals("cbBarrierMaterial"))
                                ((JComboBox)comp).setSelectedItem(((parts.Barrier)givenComp).getMat());

                    }
                }
            }
            else if(givenComp instanceof parts.Barrier)
            {
                for(JComponent comp: actLoadedPrimary)
                {
                    if(comp.getName() != null)
                    {
                        if(comp instanceof JTextField)
                        {
                            if(comp.getName().equals("tfFoundationHoehe"))
                                ((JTextField) comp).setText(""+((parts.Foundation)givenComp).getHoehe());
                            else if(comp.getName().equals("tfFoundationBreite"))
                                ((JTextField) comp).setText(""+((parts.Foundation)givenComp).getBreite());
                        }
                    }
                }
            }
            else if(givenComp instanceof parts.Door)
            {
                 for(JComponent comp: actLoadedPrimary)
                {
                    if(comp.getName() != null)
                    {
                        if(comp instanceof JTextField)
                        {
                            if(comp.getName().equals("tfDoorHoehe"))
                                ((JTextField) comp).setText(""+((parts.Door)givenComp).getHoehe());
                            else if(comp.getName().equals("tfDoorBreite"))
                                ((JTextField) comp).setText(""+((parts.Door)givenComp).getBreite());
                        }
                    }
                }
            }
        }
    }

    public boolean isOkay() {
        return okay;
    }

    public LinkedList<WallComponent> getCreatedComponents() {
        return createdComponents;
    }
    
    
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
