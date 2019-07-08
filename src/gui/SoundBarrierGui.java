/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import data.Components;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_INT_ARGB;
import java.awt.image.RescaleOp;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.LinkedList;
import parts.Selektor;

/**
 *
 * @author User
 */
public class SoundBarrierGui extends javax.swing.JFrame
{
    private BufferedImage tempImage;
    private Graphics g;
    
    public SoundBarrierGui()
    {
        initComponents();
        this.setLocationRelativeTo(null);
        plDisplay.setBackground(Color.white);
        changeBgModes();
        tempImage = new BufferedImage(plDisplay.getWidth(), plDisplay.getHeight(), TYPE_INT_ARGB);
        g = tempImage.createGraphics();
        
    }
    
    private int mode = 0;
    private int multiplicator = 20;
    private int border = 5;
    private ArrayList<parts.WallComponent> data = new ArrayList();
    
    private ArrayList<parts.WallComponent> selectedObjects = new ArrayList();
 
    
    //vars for dragging
    private boolean dragAble = false;
    private parts.Selektor selektor;
    private parts.Selektor defectText;
    private LinkedList<Double> oldX = new LinkedList();
    private LinkedList<Double> oldY = new LinkedList();
    private double oldXMouse;
    private double oldYMouse;
    
    private int sector = -1;
    
    private boolean changes = false;

    @Override
    public void paint(Graphics g)
    {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pmModify = new javax.swing.JPopupMenu();
        miDup = new javax.swing.JMenuItem();
        plTools = new javax.swing.JPanel();
        lbNeu = new javax.swing.JLabel();
        lbSelect = new javax.swing.JLabel();
        lbModify = new javax.swing.JLabel();
        lbMove = new javax.swing.JLabel();
        lbDup = new javax.swing.JLabel();
        lbDefect = new javax.swing.JLabel();
        lbLöschen = new javax.swing.JLabel();
        lbSave = new javax.swing.JLabel();
        lbLoad = new javax.swing.JLabel();
        plDisplay = new javax.swing.JPanel();

        miDup.setText("Duplizieren");
        miDup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onActionMiDup(evt);
            }
        });
        pmModify.add(miDup);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 800));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                onFrameMoved(evt);
            }
            public void componentResized(java.awt.event.ComponentEvent evt) {
                onFrameResized(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                onClosingFrame(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                onGuiOpened(evt);
            }
        });

        plTools.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        plTools.setMinimumSize(new java.awt.Dimension(100, 84));
        plTools.setPreferredSize(new java.awt.Dimension(100, 122));
        plTools.setLayout(new java.awt.GridLayout(9, 1));

        lbNeu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNeu.setText("Neu");
        lbNeu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbNeu.setOpaque(true);
        lbNeu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onClickedNew(evt);
            }
        });
        plTools.add(lbNeu);

        lbSelect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSelect.setText("Select");
        lbSelect.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbSelect.setOpaque(true);
        lbSelect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onClickSelect(evt);
            }
        });
        plTools.add(lbSelect);

        lbModify.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbModify.setText("Bearbeiten");
        lbModify.setToolTipText("");
        lbModify.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbModify.setOpaque(true);
        lbModify.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onClickModify(evt);
            }
        });
        plTools.add(lbModify);

        lbMove.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMove.setText("Bewegen");
        lbMove.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbMove.setOpaque(true);
        lbMove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onClickMove(evt);
            }
        });
        plTools.add(lbMove);

        lbDup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDup.setText("Duplizieren");
        lbDup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbDup.setOpaque(true);
        lbDup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onClickDup(evt);
            }
        });
        plTools.add(lbDup);

        lbDefect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDefect.setText("<html><body>Beschädigung<br>vermerken</body></html>");
        lbDefect.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbDefect.setOpaque(true);
        lbDefect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onClickDefect(evt);
            }
        });
        plTools.add(lbDefect);

        lbLöschen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLöschen.setText("Löschen");
        lbLöschen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbLöschen.setOpaque(true);
        lbLöschen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onClickDelete(evt);
            }
        });
        plTools.add(lbLöschen);

        lbSave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSave.setText("Speichern");
        lbSave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbSave.setOpaque(true);
        lbSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onClickSave(evt);
            }
        });
        plTools.add(lbSave);

        lbLoad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLoad.setText("Laden");
        lbLoad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbLoad.setOpaque(true);
        lbLoad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onClickLoad(evt);
            }
        });
        plTools.add(lbLoad);

        getContentPane().add(plTools, java.awt.BorderLayout.LINE_END);

        plDisplay.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                onDraggedDisplay(evt);
            }
        });
        plDisplay.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                onMouseWheelDisplay(evt);
            }
        });
        plDisplay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onClickDisplay(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                onPressedDisplay(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                onReleasedDisplay(evt);
            }
        });
        plDisplay.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                onResized(evt);
            }
        });

        javax.swing.GroupLayout plDisplayLayout = new javax.swing.GroupLayout(plDisplay);
        plDisplay.setLayout(plDisplayLayout);
        plDisplayLayout.setHorizontalGroup(
            plDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        plDisplayLayout.setVerticalGroup(
            plDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        getContentPane().add(plDisplay, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public double calcPxToCords(int x)
    {
        return 1.0*x/multiplicator;
    }
    
    /**
     * Klickevenr dür das "Neu"  Label
     * Setzt den Modus bei Klick  auf 3
     * @param evt 
     */
    private void onClickedNew(java.awt.event.MouseEvent evt)//GEN-FIRST:event_onClickedNew
    {//GEN-HEADEREND:event_onClickedNew
        mode = 1;
        changeBgModes();
        lbNeu.setBackground(Color.gray);
    }//GEN-LAST:event_onClickedNew

    /**
     * Klickevent für das "Löschen" Label
     * Setzt den Modus bei Klick auf 2
     * @param evt 
     */
    private void onClickDelete(java.awt.event.MouseEvent evt)//GEN-FIRST:event_onClickDelete
    {//GEN-HEADEREND:event_onClickDelete
        mode = 2;
        changeBgModes();
        
        lbLöschen.setBackground(Color.gray);
    }//GEN-LAST:event_onClickDelete

    /**
     * Klickevent für das "Beschädung" Label"
     * Setzt den Modus bei Klick auf 3
     * @param evt 
     */
    private void onClickDefect(java.awt.event.MouseEvent evt)//GEN-FIRST:event_onClickDefect
    {//GEN-HEADEREND:event_onClickDefect
        mode = 3;
        changeBgModes();
        lbDefect.setBackground(Color.gray);
    }//GEN-LAST:event_onClickDefect

    /**
     * Klickevent für die Zeicheneeben, hier werden die meisten operationen laut des modes getrennt
     * @param evt 
     */
    private void onClickDisplay(java.awt.event.MouseEvent evt)//GEN-FIRST:event_onClickDisplay
    {//GEN-HEADEREND:event_onClickDisplay

        /**
         * 1 Neue Barriere erstellen
         * 2 Komponente löschen
         * 3 Beschädigugn erstellen
         * 4 Drag and Drop
         * 5 Modify
         * 6 Auswählen/Selektieren
         * 7 Duplizieren
         */
        System.out.println(1.0 * evt.getX() / multiplicator + " - " + (1.0 * plDisplay.getHeight() / multiplicator - 1.0 * evt.getY() / multiplicator));

        System.out.println("XR: " + evt.getX());

        if (mode == 1) {
            guiNew.CreateComponent dlg = new guiNew.CreateComponent(this, true,1.0 * evt.getX() / multiplicator, 1.0 * plDisplay.getHeight() / multiplicator - 1.0 * evt.getY() / multiplicator);
            dlg.setVisible(true);

            if (dlg.isOkay()) {
                for(parts.WallComponent comp : dlg.getCreatedComponents())
                {
                    data.add(comp);
                    changes = true;
                }
                
            }
        } else if (mode == 2) {

            parts.Selektor sel = new Selektor(1.0 * evt.getX() / multiplicator, 1.0 * plDisplay.getHeight() / multiplicator - 1.0 * evt.getY() / multiplicator, 1, 1);
            if (getCollisions(sel).length > 0) {
                
                
                parts.WallComponent collision = getCollisions(sel)[getCollisions(sel).length - 1];
                if(selectedObjects.contains(collision))
                {
                    for(parts.WallComponent comp: selectedObjects)
                        data.remove(comp);
                    selectedObjects.clear();
                }
                else
                    data.remove(collision);

                changes = true;
                redrawAll();
            }
        } else if (mode == 3) {
            parts.Defect def = new parts.Defect(calcPxToCords(evt.getX() - 15), 1.0 * plDisplay.getHeight() / multiplicator - calcPxToCords(evt.getY() - 15), 30);
            ModifyDefectDialog dlg = new ModifyDefectDialog(this, true, def);
            dlg.setVisible(true);

            if (dlg.isOkay()) {
                
                data.add(def);
                def.setComment(dlg.getComment());
                changes = true;
                redrawAll();
            }
        }
        else if(mode == 5)
        {
            Components changeMode = null;
            if(selectedObjects.size() > 0)
            {
                boolean barrier = false;
                boolean foundation = false;
                boolean door = false;
                
                LinkedList<parts.WallComponent> def = new LinkedList<>();
                
                for(parts.WallComponent comp: selectedObjects)
                {
                    if(comp instanceof parts.Barrier)
                        barrier = true;
                    else if(comp instanceof parts.Foundation)
                        foundation = true;
                    else if(comp instanceof parts.Door)
                        door = true;
                    else if(comp instanceof parts.Defect)
                        def.add(comp);   
                }
                
                for(parts.WallComponent comp: def)
                    selectedObjects.remove(comp);
                
                if(barrier && foundation && door)
                    changeMode = Components.BARRIER_AND_FOUNDATION_AND_DOOR;
                else if(barrier && foundation)
                    changeMode = Components.BARRIER_AND_FOUNDATION;
                else if(barrier && door)
                    changeMode = Components.BARRIER_AND_DOOR;
                else if(foundation && door)
                    changeMode = Components.FOUNDATION_AND_DOOR;
                else if(foundation)
                    changeMode = Components.FOUNDATION;
                else if(barrier)
                    changeMode = Components.BARRIER;
                else if(door)
                    changeMode = Components.DOOR;
                
                guiNew.CreateComponent dlg;
                if(selectedObjects.size() == 1)
                    dlg = new guiNew.CreateComponent(this, true, changeMode, selectedObjects.get(0));
                else
                    dlg = new guiNew.CreateComponent(this, true, changeMode, null);
                
                dlg.setVisible(true);
                
                if(dlg.isOkay())
                {
                    if(selectedObjects.size() == 1)
                    {
                        data.remove(selectedObjects.get(0));
                        selectedObjects.clear();
                        
                        data.add(dlg.getCreatedComponents().get(0));
                        selectedObjects.add(dlg.getCreatedComponents().get(0));
                    }
                    else
                    {
                        for(parts.WallComponent comp: selectedObjects)
                        {
                            data.remove(comp);
                        }
                        
                        for(parts.WallComponent change: dlg.getCreatedComponents())
                        {
                            if(change instanceof parts.Barrier)
                            {
                                for(parts.WallComponent comp: selectedObjects)
                                {
                                    if(comp instanceof parts.Barrier)
                                    {
                                        ((parts.Barrier)comp).setHoeheL((((parts.Barrier)((parts.WallComponent)change)).getHoeheL()));
                                        ((parts.Barrier)comp).setHoeheR((((parts.Barrier)((parts.WallComponent)change)).getHoeheR()));
                                        ((parts.Barrier)comp).setBreite((((parts.Barrier)((parts.WallComponent)change)).getBreite()));
                                        ((parts.Barrier)comp).setMat((((parts.Barrier)((parts.WallComponent)change)).getMat()));
                                    }
                                }
                            }
                            else if(change instanceof parts.Foundation)
                            {
                                for(parts.WallComponent comp: selectedObjects)
                                {
                                    if(comp instanceof parts.Foundation)
                                    {
                                        ((parts.Foundation) comp).setHoehe((((parts.Foundation)change)).getHoehe());
                                        ((parts.Foundation) comp).setBreite((((parts.Foundation)change)).getBreite());
                                    }
                                }
                            }
                            else if(change instanceof parts.Door)
                            {
                                for(parts.WallComponent comp: selectedObjects)
                                {
                                    if(comp instanceof parts.Door)
                                    {
                                        ((parts.Door) comp).setHoehe((((parts.Door)change)).getHoehe());
                                        ((parts.Door) comp).setBreite((((parts.Door)change)).getBreite());
                                    }
                                }
                            }
                        }
                        
                        for(parts.WallComponent comp: selectedObjects)
                        {
                            data.add(comp);
                        }
                    }
                    redrawAll();
                }
            }
            else
            {
                if(getCollisions(new Selektor(1.0 * evt.getX() / multiplicator, 1.0 * plDisplay.getHeight() / multiplicator - 1.0 * evt.getY() / multiplicator, 1, 1)).length > 0)
                {
                    parts.WallComponent comp = getCollisions(new Selektor(1.0 * evt.getX() / multiplicator, 1.0 * plDisplay.getHeight() / multiplicator - 1.0 * evt.getY() / multiplicator, 1, 1))[getCollisions(new Selektor(1.0 * evt.getX() / multiplicator, 1.0 * plDisplay.getHeight() / multiplicator - 1.0 * evt.getY() / multiplicator, 1, 1)).length-1];
                    
                    guiNew.CreateComponent dlg = null;
                    if(comp instanceof parts.Barrier)
                        dlg = new guiNew.CreateComponent(this, true, Components.BARRIER, comp);
                    else if(comp instanceof parts.Foundation)
                        dlg = new guiNew.CreateComponent(this, true, Components.FOUNDATION, comp);
                    else if(comp instanceof parts.Door)
                        dlg = new guiNew.CreateComponent(this, true, Components.DOOR, comp);
                    
                    if(comp instanceof parts.Defect)
                    {
                        gui.ModifyDefectDialog ddlg = new gui.ModifyDefectDialog(this, true, ((parts.Defect)comp));
                        ddlg.setVisible(true);
                        
                        if(ddlg.isOkay())
                        {
                            selectedObjects.remove(comp);
                            data.remove(comp);
                            ((parts.Defect) comp).setComment(ddlg.getComment());
                            selectedObjects.add(comp);
                            data.add(comp);   
                            changes = true;
                        } 
                    }
                    else
                        {
                            dlg.setVisible(true);
                            
                            if(dlg.isOkay())
                            {
                                selectedObjects.remove(comp);
                                data.remove(comp);
                                if(comp instanceof parts.Barrier)
                                {
                                    ((parts.Barrier)comp).setHoeheL(((parts.Barrier)dlg.getCreatedComponents().get(0)).getHoeheL());
                                    ((parts.Barrier)comp).setHoeheR(((parts.Barrier)dlg.getCreatedComponents().get(0)).getHoeheR());
                                    ((parts.Barrier)comp).setBreite(((parts.Barrier)dlg.getCreatedComponents().get(0)).getBreite());
                                    ((parts.Barrier)comp).setMat(((parts.Barrier)dlg.getCreatedComponents().get(0)).getMat());
                                }
                                else if(comp instanceof parts.Foundation)
                                {
                                    ((parts.Foundation)comp).setHoehe(((parts.Foundation)dlg.getCreatedComponents().get(0)).getHoehe());
                                    ((parts.Foundation)comp).setBreite(((parts.Foundation)dlg.getCreatedComponents().get(0)).getBreite());
                                }
                                else if(comp instanceof parts.Door)
                                {
                                    ((parts.Door)comp).setHoehe(((parts.Door)dlg.getCreatedComponents().get(0)).getHoehe());
                                    ((parts.Door)comp).setBreite(((parts.Door)dlg.getCreatedComponents().get(0)).getBreite());
                                }
                                
                                selectedObjects.add(comp);
                                data.add(comp);
                                changes = true;
                            }
                        }
                        
                }
            }
            
            
        }
        
        redrawAll();
        
        if(mode < 2 || mode > 5)
        {
            if(getCollisions(new Selektor(1.0 * evt.getX() / multiplicator, 1.0 * plDisplay.getHeight() / multiplicator - 1.0 * evt.getY() / multiplicator, 1, 1)).length > 0)
            {
                if(getCollisions(new Selektor(1.0 * evt.getX() / multiplicator, 1.0 * plDisplay.getHeight() / multiplicator - 1.0 * evt.getY() / multiplicator, 1, 1))[getCollisions(new Selektor(1.0 * evt.getX() / multiplicator, 1.0 * plDisplay.getHeight() / multiplicator - 1.0 * evt.getY() / multiplicator, 1, 1)).length-1] instanceof parts.Defect)
                {
                    String text = ((parts.Defect)getCollisions(new Selektor(1.0 * evt.getX() / multiplicator, 1.0 * plDisplay.getHeight() / multiplicator - 1.0 * evt.getY() / multiplicator, 1, 1))[getCollisions(new Selektor(1.0 * evt.getX() / multiplicator, 1.0 * plDisplay.getHeight() / multiplicator - 1.0 * evt.getY() / multiplicator, 1, 1)).length-1]).getComment();
                    String nText = "";
                    boolean umbruch = false;
                    
                    for(int i = 0, c = 0; i < text.length(); i++)
                    {
                        nText += text.charAt(i);
                        if(text.charAt(i) == ' ' && umbruch)
                        {
                            umbruch = false;
                            nText +="\n";
                            c = 0;
                        }
                        
                        c++;
                        
                        if(c == 50)
                            umbruch = true;
                    }
                    JOptionPane.showMessageDialog(this,nText,"Kommentar",1);
                }
            }
        }
        

    }//GEN-LAST:event_onClickDisplay

    /**
     * Klickevent für das "Speichern" Label
     * Versucht die Daten von data in die Datanbank zu speichern
     * @param evt 
     */
    private void onClickSave(java.awt.event.MouseEvent evt)//GEN-FIRST:event_onClickSave
    {//GEN-HEADEREND:event_onClickSave
        changeBgModes();
        db.Database database = db.Database.getInstance();
        try {
            database.save(sector, data);
            
            mode = 0;
            JOptionPane.showMessageDialog(this, "Speichern erfolgreich");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_onClickSave

    /**
     * Event für das verändern der Größte der GUI
     * repainted die Zeichenfläche
     * @param evt 
     */
    private void onResized(java.awt.event.ComponentEvent evt)//GEN-FIRST:event_onResized
    {//GEN-HEADEREND:event_onResized
        redrawAll();
    }//GEN-LAST:event_onResized

    /**
     * Clickevent für das "Bewegen" Label
     * Setzt den Modus auf 4
     * @param evt 
     */
    private void onClickMove(java.awt.event.MouseEvent evt)//GEN-FIRST:event_onClickMove
    {//GEN-HEADEREND:event_onClickMove
        mode = 4;
        changeBgModes();
        lbMove.setBackground(Color.gray);
    }//GEN-LAST:event_onClickMove

    /**
     * Dragevent für die Zeichenfläche
     * @param evt 
     */
    private void onDraggedDisplay(java.awt.event.MouseEvent evt)//GEN-FIRST:event_onDraggedDisplay
    {//GEN-HEADEREND:event_onDraggedDisplay
        if(mode == 4)
        {
            if(dragAble)
            {
                
                //
                System.out.println("OX: "+oldX+" - OXM "+oldXMouse+" = ");
                
                
                int i = 0;
                for(parts.WallComponent comp: selectedObjects)
                {
                    data.remove(comp);
                    comp.setPosX(oldX.get(i)+(calcPxToCords(evt.getX())-oldXMouse));
                    comp.setPosY(oldY.get(i)+(1.0*plDisplay.getHeight()/multiplicator - 1.0*evt.getY()/multiplicator-oldYMouse));
                    i++;
                    
                    data.add(comp);
      
                }
                
                changes = true;
                redrawAll();
            }
        }
        else if(mode == 6)
        {
            if(calcPxToCords(evt.getX())-oldXMouse > 0)
                selektor.setBreite(calcPxToCords(evt.getX())-oldXMouse);
            else
            {
                selektor.setPosX(oldXMouse+calcPxToCords(evt.getX())-oldXMouse);
                selektor.setBreite((calcPxToCords(evt.getX())-oldXMouse)*-1);
            }
            if(-1*(1.0*plDisplay.getHeight()/multiplicator - 1.0*evt.getY()/multiplicator-oldYMouse) > 0)
                selektor.setHoehe(-1*(1.0*plDisplay.getHeight()/multiplicator - 1.0*evt.getY()/multiplicator-oldYMouse));
            else
            {
                selektor.setPosY(oldYMouse+(oldYMouse-(1.0*plDisplay.getHeight()/multiplicator - 1.0*evt.getY()/multiplicator))*-1);
                selektor.setHoehe((oldYMouse-(1.0*plDisplay.getHeight()/multiplicator - 1.0*evt.getY()/multiplicator))*-1);
            }
            
            //y nach oben oldYMouse-(1.0*plDisplay.getHeight()/multiplicator - 1.0*evt.getY()/multiplicator)*-1
            System.out.println((oldYMouse-(1.0*plDisplay.getHeight()/multiplicator - 1.0*evt.getY()/multiplicator))*-1);
            redrawAll();
        }
    }//GEN-LAST:event_onDraggedDisplay

    /**
     * Mouse Releaseevent für die Zeichenfläche
     * Setzt dragable auf false
     * @param evt 
     */
    private void onReleasedDisplay(java.awt.event.MouseEvent evt)//GEN-FIRST:event_onReleasedDisplay
    {//GEN-HEADEREND:event_onReleasedDisplay
        
        if(mode == 4)
        {
            dragAble = false;
            selectedObjects.clear();
        }
        if(mode == 6)
        {
            
            selectedObjects.clear();
            
            for(parts.WallComponent comp: getCollisions(selektor))
            {
                selectedObjects.add(comp);
                data.remove(comp);
                data.add(comp);
            }
            
            selektor = null;
            redrawAll();
        }
    }//GEN-LAST:event_onReleasedDisplay

    /**
     * Mouse Pressedevent für die Zeichenfläche
     * Setzt unter der erfüllung von Vorrausetzung dragable auf true
     * @param evt 
     */
    private void onPressedDisplay(java.awt.event.MouseEvent evt)//GEN-FIRST:event_onPressedDisplay
    {//GEN-HEADEREND:event_onPressedDisplay
        if(mode == 4)
        {

            parts.Selektor sel = new Selektor(1.0 * evt.getX() / multiplicator, 1.0 * plDisplay.getHeight() / multiplicator - 1.0 * evt.getY() / multiplicator, 1, 1);

            if(getCollisions(sel).length == 0)
                selectedObjects.clear();
            if(getCollisions(sel).length > 0 || selectedObjects.size() > 0)
            {
                if(selectedObjects.size() == 0)
                    selectClicked(1.0*evt.getX()/multiplicator, 1.0*plDisplay.getHeight()/multiplicator-calcPxToCords(evt.getY()));
                if (selectedObjects.size() > 0)
                {
                    //parts.Barrier bar = new Barrier(, 1.0*plDisplay.getHeight()/multiplicator - 1.0*evt.getY()/multiplicator, 1, 1, Material.HOLZ);

                    dragAble = true;
                    oldXMouse = 1.0*evt.getX()/multiplicator;
                    oldYMouse = 1.0*plDisplay.getHeight()/multiplicator - 1.0*evt.getY()/multiplicator;
                    oldX.clear();
                    oldY.clear();
                    
                    int i = 0;
                    for(parts.WallComponent comp: selectedObjects)
                    {
                        oldX.add(i, comp.getPosX());
                        oldY.add(i,comp.getPosY());
                        i++;
                    }
                }
            }
        }
        else if(mode == 6)
        {
            selectedObjects.clear();
            redrawAll();
            oldXMouse = 1.0*evt.getX()/multiplicator;
            oldYMouse = 1.0*plDisplay.getHeight()/multiplicator - 1.0*evt.getY()/multiplicator;
            selektor = new Selektor(oldXMouse, oldYMouse, 0, 0);
        }
    }//GEN-LAST:event_onPressedDisplay

    /**
     * Klickevent für das "Bearbeiten" Label
     * Setzt den Modus bei Klick auf 5
     * @param evt 
     */
    private void onClickModify(java.awt.event.MouseEvent evt)//GEN-FIRST:event_onClickModify
    {//GEN-HEADEREND:event_onClickModify
        mode = 5;
        changeBgModes();
        lbModify.setBackground(Color.gray);
    }//GEN-LAST:event_onClickModify

    /**
     * Klickevent für das "Auswählen" Label
     * Setzt den Modus bei KLick auf 6
     * @param evt 
     */
    private void onClickSelect(java.awt.event.MouseEvent evt)//GEN-FIRST:event_onClickSelect
    {//GEN-HEADEREND:event_onClickSelect
        mode = 6;
        changeBgModes();
        lbSelect.setBackground(Color.gray);
    }//GEN-LAST:event_onClickSelect

    private void onActionMiDup(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onActionMiDup
    {//GEN-HEADEREND:event_onActionMiDup

    }//GEN-LAST:event_onActionMiDup

    /**
     * Klickevent für das "Duplizieren" Label
     * Setzt den Modus auf 7 und dubliziert das ausgewählte Objekt
     * @param evt 
     */
    private void onClickDup(java.awt.event.MouseEvent evt)//GEN-FIRST:event_onClickDup
    {//GEN-HEADEREND:event_onClickDup
        mode = 7;
        changeBgModes();
        lbDup.setBackground(Color.gray);
        
        double xMin = Double.MAX_VALUE;
        double xMax = 0;
        int idxMin = 0;
        int idxMax = 0;
        int c = 0;
        for(parts.WallComponent comp: selectedObjects)
        {   
            if(comp.getPosX() < xMin && !(comp instanceof parts.Defect))
            {
                idxMax = c;
                xMin = comp.getPosX();
            }
            
            if(comp instanceof parts.Rect)
            {
                if(((parts.Rect)comp).getBreite()+comp.getPosX() > xMax)
                {
                    idxMax = c;
                    xMax = comp.getPosX()+((parts.Rect)comp).getBreite();
                }
            }
            
            c++;
        }
        
        
        LinkedList<parts.WallComponent> duplicated = new LinkedList();
        
        
        for(parts.WallComponent comp: selectedObjects)
        {
            if(comp instanceof parts.Barrier)
            {
                
                parts.Barrier bar = new parts.Barrier(comp.getPosX()+(xMax-xMin), comp.getPosY(), ((parts.Barrier)comp).getBreite(), ((parts.Barrier)comp).getHoeheL(), ((parts.Barrier)comp).getHoeheR(), ((parts.Barrier)comp).getMat());
                bar.setMat(((parts.Barrier)comp).getMat());
                duplicated.add(bar);

            }
            else if(comp instanceof parts.Foundation)
            {
                
                parts.Foundation fd = new parts.Foundation(comp.getPosX()+xMax-xMin, comp.getPosY(), ((parts.Foundation)comp).getBreite(), ((parts.Foundation)comp).getHoehe());
                duplicated.add(fd);
            }
            else if(comp instanceof parts.Door)
            {
                
                parts.Door dr = new parts.Door(comp.getPosX()+xMax-xMin, comp.getPosY(), ((parts.Door)comp).getBreite(), ((parts.Door)comp).getHoehe());
                duplicated.add(dr);
            }
            else if(comp instanceof parts.Defect)
            {
                
                parts.Defect def = new parts.Defect(comp.getPosX()+xMax-xMin+((parts.Defect)comp).getRadius(), comp.getPosY(), (int)((parts.Defect)comp).getRadius());
                duplicated.add(def);
            }
        }
        
        if(duplicated.size() > 0)
        {
            redrawAll();
            changes = true;
        }
        
        selectedObjects.clear();
        for(parts.WallComponent comp: duplicated)
        {
            data.add(comp);
            selectedObjects.add(comp);
        }
    }//GEN-LAST:event_onClickDup

    /**
     * Component Resizedevent, falls der GUI Frame die Größe ändert wird die Zeichenfläche angepasst.
     * @param evt 
     */
    private void onFrameResized(java.awt.event.ComponentEvent evt)//GEN-FIRST:event_onFrameResized
    {//GEN-HEADEREND:event_onFrameResized
        tempImage = new BufferedImage(plDisplay.getWidth(), plDisplay.getHeight(), TYPE_INT_ARGB);
        g = tempImage.createGraphics();
    }//GEN-LAST:event_onFrameResized

    /**
     * Component Movedevent für den Frame, falls sich dieser bewegt wird dieser geupdatet
     * @param evt 
     */
    private void onFrameMoved(java.awt.event.ComponentEvent evt)//GEN-FIRST:event_onFrameMoved
    {//GEN-HEADEREND:event_onFrameMoved
        redrawAll();
    }//GEN-LAST:event_onFrameMoved

    
    /**
     * Window Openedevent, sobald der Frame geöffnet wird, wird ein eingabe Dialog
     * für den Sektor geöfnet. Erfolgt eine Eingabe wird versucht, die dazugehörigen Daten
     * aus der Datenbank zu laden.
     * @param evt 
     */
    private void onGuiOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_onGuiOpened
        gui.EditSectorDialog dlg = new gui.EditSectorDialog(this, true);
        dlg.setVisible(true);
        
        if(dlg.isOkay())
        {
            sector = dlg.getSector();
            load(dlg.getSector());
        }
        else
            this.setTitle("Unbekannter Sektor");
    }//GEN-LAST:event_onGuiOpened

    /**
     * Klickevent für das Label "Load"
     * @param evt 
     */
    private void onClickLoad(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onClickLoad
        changeBgModes();
        gui.EditSectorDialog dlg = new gui.EditSectorDialog(this, true);
        dlg.setVisible(true);
        
        if(dlg.isOkay())
        {
            
            load(dlg.getSector());
            sector = dlg.getSector();
            mode = 0;
        }
    }//GEN-LAST:event_onClickLoad

    private void onClosingFrame(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_onClosingFrame
        
        if(changes)
        {
            String options[] = {"Ja","Nein"};
            int opt = JOptionPane.showOptionDialog(this, "Sollen die Änderungen gespeichert werden?", "Speichern", 1, 1, null, options, NORMAL);

            if(opt == 0)
            {
                save();
            }
        }
    }//GEN-LAST:event_onClosingFrame

    private void onMouseWheelDisplay(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_onMouseWheelDisplay
        if(multiplicator+(evt.getUnitsToScroll())*-1 > 0)
            multiplicator+=evt.getUnitsToScroll()*-1;
        
        redrawAll();
    }//GEN-LAST:event_onMouseWheelDisplay

    /**
     * Ladet daten des angeben sektors aus der Datanbank
     * @param sector Sektor von welchem die Daten geladen werden sollen.
     */
    public void load(int sector)
    {
        this.setTitle("Sektor: "+sector);
        this.sector = sector;

            
            db.Database database = db.Database.getInstance();
          try {
            
            data.clear();
            for (parts.WallComponent com : database.load(sector)) {
                data.add(com);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            
            redrawAll();
    }
    
    public void save()
    {
        db.Database database = db.Database.getInstance();
        try {
            if(sector < 0)
            {
                gui.EditSectorDialog dlg = new gui.EditSectorDialog(this, true);
                
                if(dlg.isOkay())
                    sector = dlg.getSector();
            }
                database.save(sector, data);
                changes = false;
                
            
        } catch (SQLException ex) {
            Logger.getLogger(SoundBarrierGui.class.getName()).log(Level.SEVERE, null, ex);
        }
            JOptionPane.showMessageDialog(this, "Speichern erfolgreich");
    }
    /**
     * Berechnet die Kollision eines gegeben objektes mit anderen Objekten
     * @param collObj Objekt bei welchem überprüft werden soll ob es mit einem anderen kollidiert.
     * @return Alle objekte welche mit dem gegeben objekt kollidieren.
     */
    public parts.WallComponent[] getCollisions(parts.Selektor collObj)
    {
        int count = 0;
        System.out.println("Click: "+collObj.getPosX()+" --- "+collObj.getPosY());
        for (parts.WallComponent com : data)
        {

            if(com instanceof parts.Barrier)
            {
                System.out.println("1. "+((com.getPosX() < (collObj.getPosX() + collObj.getBreite()))? "T" : "F"));
                System.out.println("2. "+((collObj.getPosX() < (com.getPosX() + ((parts.Barrier)com).getBreite()))? "T" : "F"));
                System.out.println("3. "+((com.getPosY() > (collObj.getPosY() + collObj.getHoehe()))? "T" : "F"));
                System.out.println(""+com.getPosY()+" < "+(collObj.getPosY() - collObj.getHoehe()));
                System.out.println("4. "+(((collObj.getPosY() > (com.getPosY() - ((parts.Barrier)com).getHoehe())))? "T" : "F"));
                
                if (((com.getPosX() < (collObj.getPosX() + collObj.getBreite()))
                        && (collObj.getPosX() < (com.getPosX() + ((parts.Barrier)com).getBreite())))
                        && (com.getPosY() > (collObj.getPosY() - collObj.getHoehe()))
                        && (collObj.getPosY() > (com.getPosY() - ((parts.Barrier)com).getHoehe())))
                {
                    count++;
                }
            }
            else if(com instanceof parts.Foundation)
            {
                if (((com.getPosX() < (collObj.getPosX() + collObj.getBreite()))
                        && (collObj.getPosX() < (com.getPosX() + ((parts.Foundation)com).getBreite())))
                        && (com.getPosY() > (collObj.getPosY() - collObj.getHoehe()))
                        && (collObj.getPosY() > (com.getPosY() - ((parts.Foundation)com).getHoehe())))
                {
                    count++;
                }
            }
            else if(com instanceof parts.Door)
            {
                if (((com.getPosX() < (collObj.getPosX() + collObj.getBreite()))
                        && (collObj.getPosX() < (com.getPosX() + ((parts.Door)com).getBreite())))
                        && (com.getPosY() > (collObj.getPosY() - collObj.getHoehe()))
                        && (collObj.getPosY() > (com.getPosY() - ((parts.Door)com).getHoehe())))
                {
                    count++;
                }
            }
            else if(com instanceof parts.Defect)
            {
                if (((com.getPosX() < (collObj.getPosX() + collObj.getBreite()))
                        && (collObj.getPosX() < (com.getPosX() + ((parts.Defect)com).getRadius())))
                        && (com.getPosY() > (collObj.getPosY() - collObj.getHoehe()))
                        && (collObj.getPosY() > (com.getPosY() - ((parts.Defect)com).getRadius()*2)))
                {
                    count++;
                }
            }
        }
        
        parts.WallComponent collisions[] = new parts.WallComponent[count];
        System.out.println("Colls: "+count);
        
        int i = 0;
        for (parts.WallComponent com : data)
        {

            if(com instanceof parts.Barrier)
            {

                if (((com.getPosX() < (collObj.getPosX() + collObj.getBreite()))
                        && (collObj.getPosX() < (com.getPosX() + ((parts.Barrier)com).getBreite())))
                        && (((parts.Barrier)com).getPosY() > (collObj.getPosY() - collObj.getHoehe()))
                        && (collObj.getPosY() > (com.getPosY() - ((parts.Barrier)com).getHoehe())))
                {

                    collisions[i] = com;
                    i++;
                }
            }
            else if(com instanceof parts.Foundation)
            {
                if (((com.getPosX() < (collObj.getPosX() + collObj.getBreite()))
                        && (collObj.getPosX() < (com.getPosX() + ((parts.Foundation)com).getBreite())))
                        && (com.getPosY() > (collObj.getPosY() - collObj.getHoehe()))
                        && (collObj.getPosY() > (com.getPosY() - ((parts.Foundation)com).getHoehe())))
                {
                    collisions[i] = com;
                    i++;
                }
            }
            else if(com instanceof parts.Door)
            {
                if (((com.getPosX() < (collObj.getPosX() + collObj.getBreite()))
                        && (collObj.getPosX() < (com.getPosX() + ((parts.Door)com).getBreite())))
                        && (com.getPosY() > (collObj.getPosY() - collObj.getHoehe()))
                        && (collObj.getPosY() > (com.getPosY() - ((parts.Door)com).getHoehe())))
                {
                    collisions[i] = com;
                    i++;
                }
            }
            else if(com instanceof parts.Defect)
            {
                if (((com.getPosX() < (collObj.getPosX() + collObj.getBreite()))
                        && (collObj.getPosX() < (com.getPosX() + ((parts.Defect)com).getRadius())))
                        && (com.getPosY() > (collObj.getPosY() - collObj.getHoehe()))
                        && (collObj.getPosY() > (com.getPosY() - ((parts.Defect)com).getRadius()*2)))
                {
                    collisions[i] = com;
                    i++;
                }
            }
            
        }
        
        return collisions;
    }
   
     
     public void drawComponent(parts.WallComponent comp)
     {
        
         if (comp instanceof parts.Barrier) {
             switch (((parts.Barrier) comp).getMat()) {
                 case HOLZ:
                     g.setColor(new Color(139, 69, 19));
                     break;
                 case METALL:
                     g.setColor(new Color(227, 227, 227));
                     break;
                 case KUNSTSTOFF:
                     g.setColor(new Color(0, 153, 255));
                     break;
                 case STEIN:
                     g.setColor(new Color(156, 156, 156));
                     break;
             }

             if (((parts.Barrier) comp).getHoehe() == ((parts.Barrier) comp).getHoeheR()) 
             {
                 System.out.println("Barrier: x: " + comp.getPosX() + " y: " + comp.getPosY() + " b: " + ((parts.Barrier) comp).getBreite() + " h: " + ((parts.Barrier) comp).getBreite());
                 g.fillRect((int) (comp.getPosX() * multiplicator), (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator), (int) (((parts.Barrier) comp).getBreite() * multiplicator), (int) (((parts.Barrier) comp).getHoehe() * multiplicator));
                 g.setColor(Color.black);
                 g.drawRect((int) (comp.getPosX() * multiplicator), (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator), (int) (((parts.Barrier) comp).getBreite() * multiplicator), (int) (((parts.Barrier) comp).getHoehe() * multiplicator));
                
         
                 g.setColor(Color.black);
                 g.drawString("b: " + ((parts.Barrier) comp).getBreite() + "m", (int) (comp.getPosX() * multiplicator) + 10, (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator) + 17);
                 g.drawString("h: " + ((parts.Barrier) comp).getHoehe() + "m", (int) (comp.getPosX() * multiplicator) + 10, (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator) + 32);
                 

             } 
             else 
             {
                 int[] pointsX = new int[3];
                 int[] pointsY = new int[3];
                 if (((parts.Barrier) comp).getHoehe() > ((parts.Barrier) comp).getHoeheR()) 
                 {
                     System.out.println(comp.getPosY()-((parts.Barrier)comp).getHoeheL()+((parts.Barrier)comp).getHoeheR());
                     pointsX[0] = (int) (comp.getPosX() * multiplicator);
                     pointsY[0] = (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator) + (int) (((parts.Barrier) comp).getHoehe() * multiplicator) - (int) (((parts.Barrier) comp).getHoeheR() * multiplicator);
                     pointsX[1] = (int) (comp.getPosX() * multiplicator) + (int) (((parts.Barrier) comp).getBreite() * multiplicator);
                     pointsY[1] = (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator) + (int) (((parts.Barrier) comp).getHoehe() * multiplicator) - (int) (((parts.Barrier) comp).getHoeheR() * multiplicator);
                     pointsX[2] = (int) (comp.getPosX() * multiplicator);
                     pointsY[2] = (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator);

                     g.fillRect((int) (comp.getPosX() * multiplicator), (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator) + (int) (((parts.Barrier) comp).getHoehe() * multiplicator) - (int) (((parts.Barrier) comp).getHoeheR() * multiplicator), (int) (((parts.Barrier) comp).getBreite() * multiplicator), (int) (((parts.Barrier) comp).getHoeheR() * multiplicator));
                     g.fillPolygon(pointsX, pointsY, 3);

                     g.setColor(Color.black);
                     g.drawRect((int) (comp.getPosX() * multiplicator), (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator) + (int) (((parts.Barrier) comp).getHoehe() * multiplicator) - (int) (((parts.Barrier) comp).getHoeheR() * multiplicator), (int) (((parts.Barrier) comp).getBreite() * multiplicator), (int) (((parts.Barrier) comp).getHoeheR() * multiplicator));
                     g.drawPolygon(pointsX, pointsY, 3);

                     switch (((parts.Barrier) comp).getMat()) {
                         case HOLZ:
                             g.setColor(new Color(139, 69, 19));
                             break;
                         case METALL:
                             g.setColor(new Color(227, 227, 227));
                             break;
                         case KUNSTSTOFF:
                             g.setColor(new Color(0, 153, 255));
                             break;
                         case STEIN:
                             g.setColor(new Color(156, 156, 156));
                             break;
                     }

                     g.drawLine((int) (comp.getPosX() * multiplicator) + 1, (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator) + (int) (((parts.Barrier) comp).getHoehe() * multiplicator) - (int) (((parts.Barrier) comp).getHoeheR() * multiplicator), (int) (comp.getPosX() * multiplicator) + (int) (((parts.Barrier) comp).getBreite() * multiplicator) - 1, (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator) + (int) (((parts.Barrier) comp).getHoehe() * multiplicator) - (int) (((parts.Barrier) comp).getHoeheR() * multiplicator));

                     
                    
                     g.setColor(Color.black);
                     g.drawString("b: " + ((parts.Barrier) comp).getBreite() + "m", (int) (comp.getPosX() * multiplicator) + 10, (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator) + (int) (((parts.Barrier) comp).getHoehe() * multiplicator) - (int) (((parts.Barrier) comp).getHoeheR() * multiplicator) + 17);
                     g.drawString("h: " + ((parts.Barrier) comp).getHoehe() + "m", (int) (comp.getPosX() * multiplicator)+10, (int)(plDisplay.getHeight()-comp.getPosY()*multiplicator)+(int)(((parts.Barrier)comp).getHoehe()*multiplicator)-(int)(((parts.Barrier)comp).getHoeheR()*multiplicator)+32);

                    }
                    else
                    {
                        pointsX[0] = (int) (comp.getPosX() * multiplicator);
                        pointsY[0] = (int) (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator) + (int) (((parts.Barrier) comp).getHoeheR() * multiplicator) - (int) (((parts.Barrier) comp).getHoeheL() * multiplicator);
                        pointsX[1] = (int) (comp.getPosX() * multiplicator) + (int) (((parts.Barrier) comp).getBreite() * multiplicator);
                        pointsY[1] = (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator) + (int) (((parts.Barrier) comp).getHoeheR() * multiplicator) - (int) (((parts.Barrier) comp).getHoeheL() * multiplicator);
                        pointsX[2] = (int) (comp.getPosX() * multiplicator) + (int) (((parts.Barrier) comp).getBreite() * multiplicator);
                        pointsY[2] = (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator);

                        g.fillRect((int) (comp.getPosX() * multiplicator), (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator) + (int) (((parts.Barrier) comp).getHoeheR() * multiplicator) - (int) (((parts.Barrier) comp).getHoeheL() * multiplicator), (int) (((parts.Barrier) comp).getBreite() * multiplicator), (int) (((parts.Barrier) comp).getHoeheL() * multiplicator));
                        g.fillPolygon(pointsX, pointsY, 3);

                        g.setColor(Color.black);
                        g.drawRect((int) (comp.getPosX() * multiplicator), (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator) + (int) (((parts.Barrier) comp).getHoeheR() * multiplicator) - (int) (((parts.Barrier) comp).getHoeheL() * multiplicator), (int) (((parts.Barrier) comp).getBreite() * multiplicator), (int) (((parts.Barrier) comp).getHoeheL() * multiplicator));
                        g.drawPolygon(pointsX, pointsY, 3);

                        switch (((parts.Barrier) comp).getMat()) {
                            case HOLZ:
                                g.setColor(new Color(139, 69, 19));
                                break;
                            case METALL:
                                g.setColor(new Color(227, 227, 227));
                                break;
                            case KUNSTSTOFF:
                                g.setColor(new Color(0, 153, 255));
                                break;
                            case STEIN:
                                g.setColor(new Color(156, 156, 156));
                                break;
                        }

                        g.drawLine((int) (comp.getPosX() * multiplicator) + 1, (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator) + (int) (((parts.Barrier) comp).getHoeheR() * multiplicator) - (int) (((parts.Barrier) comp).getHoeheL() * multiplicator), (int) (comp.getPosX() * multiplicator) + (int) (((parts.Barrier) comp).getBreite() * multiplicator) - 1, (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator) + (int) (((parts.Barrier) comp).getHoeheR() * multiplicator) - (int) (((parts.Barrier) comp).getHoeheL() * multiplicator));

                        g.setColor(Color.black);
                        g.drawString("b: " + ((parts.Barrier) comp).getBreite() + "m", (int) (comp.getPosX() * multiplicator) + 10, (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator) + (int) (((parts.Barrier) comp).getHoeheR() * multiplicator) - (int) (((parts.Barrier) comp).getHoeheL() * multiplicator) + 17);
                        g.drawString("h: " + ((parts.Barrier) comp).getHoeheR() + "m", (int) (comp.getPosX() * multiplicator)+10, (int)(plDisplay.getHeight()-comp.getPosY()*multiplicator)+(int)(((parts.Barrier)comp).getHoeheR()*multiplicator)-(int)(((parts.Barrier)comp).getHoeheL()*multiplicator)+32);

                    }

             }
             
             
             System.out.println("OB: "+(int)(((parts.Barrier)comp).getBreite()*multiplicator));
         }
         else if(comp instanceof parts.Foundation)
         {
             System.out.println("Foundation: x: "+comp.getPosX()+" y: "+comp.getPosY()+" b: "+((parts.Foundation)comp).getBreite()+" h: "+((parts.Foundation)comp).getBreite());
             g.setColor(new Color(184, 176, 155));
             g.fillRect((int)(comp.getPosX()*multiplicator), (int)(plDisplay.getHeight()-comp.getPosY()*multiplicator), (int)(((parts.Foundation)comp).getBreite()*multiplicator), (int)(((parts.Foundation)comp).getHoehe()*multiplicator));
             g.setColor(Color.black);
             g.drawRect((int)(comp.getPosX()*multiplicator), (int)(plDisplay.getHeight()-comp.getPosY()*multiplicator), (int)(((parts.Foundation)comp).getBreite()*multiplicator), (int)(((parts.Foundation)comp).getHoehe()*multiplicator));
             g.drawString("b: "+((parts.Foundation)comp).getBreite()+"m", (int)(comp.getPosX()*multiplicator)+10, (int)(plDisplay.getHeight()-comp.getPosY()*multiplicator)+17);
             g.drawString("h: "+((parts.Foundation)comp).getHoehe()+"m", (int)(comp.getPosX()*multiplicator)+10, (int)(plDisplay.getHeight()-comp.getPosY()*multiplicator)+32);
         }
         else if(comp instanceof parts.Door)
         {
            System.out.println("Door: x: "+comp.getPosX()+" y: "+comp.getPosY()+" b: "+((parts.Door)comp).getBreite()+" h: "+((parts.Door)comp).getBreite());
             g.setColor(new Color(255, 255, 102));
             g.fillRect((int)(comp.getPosX()*multiplicator), (int)(plDisplay.getHeight()-comp.getPosY()*multiplicator), (int)(((parts.Door)comp).getBreite()*multiplicator), (int)(((parts.Door)comp).getHoehe()*multiplicator));
             g.setColor(Color.black);
             g.drawRect((int)(comp.getPosX()*multiplicator), (int)(plDisplay.getHeight()-comp.getPosY()*multiplicator), (int)(((parts.Door)comp).getBreite()*multiplicator), (int)(((parts.Door)comp).getHoehe()*multiplicator));
             g.drawString("b: "+((parts.Door)comp).getBreite()+"m", (int)(comp.getPosX()*multiplicator)+10, (int)(plDisplay.getHeight()-comp.getPosY()*multiplicator)+17);
             g.drawString("h: "+((parts.Door)comp).getHoehe()+"m", (int)(comp.getPosX()*multiplicator)+10, (int)(plDisplay.getHeight()-comp.getPosY()*multiplicator)+32); 
         }
         else if(comp instanceof parts.Defect)
         {
             g.setColor(Color.red);
            g.drawOval((int)(comp.getPosX()*multiplicator), (int)(plDisplay.getHeight()-comp.getPosY()*multiplicator), ((parts.Defect)comp).getRadius(), ((parts.Defect)comp).getRadius());
         }
         else if(comp instanceof parts.Selektor)
         {
             System.out.println("Selekted: "+comp.getPosX()+" --- "+comp.getPosY());
             g.setColor(new Color(0, 255, 255, 50));
             g.fillRect((int)(comp.getPosX()*multiplicator), (int)(plDisplay.getHeight()-comp.getPosY()*multiplicator), (int)(((parts.Selektor)comp).getBreite()*multiplicator), (int)(((parts.Selektor)comp).getHoehe()*multiplicator));
             g.setColor(new Color(0,0,255,50));
             g.drawRect((int)(comp.getPosX()*multiplicator), (int)(plDisplay.getHeight()-comp.getPosY()*multiplicator), (int)(((parts.Selektor)comp).getBreite()*multiplicator), (int)(((parts.Selektor)comp).getHoehe()*multiplicator));
         }
             
     }
     
     /**
      * Updatet die Zeichenfläche, und zeichnet jedes in data gespeicherte Objekt.
      */
    public void redrawAll()
    {
        g.setColor(Color.white);
        g.fillRect(0, 0, plDisplay.getWidth(), plDisplay.getWidth());
        
        plTools.repaint();
        
        for(parts.WallComponent com: data)
        {
            drawComponent(com); 
        }
        
        redrawSelected();
        
        if(selektor != null)
            drawComponent(selektor);
        
          updateDisplay();
    }
    
    /**
     * Das selektiere Objekt (selectedObject) wird gezeichnet.
     */
    public void redrawSelected()
    {   
        g.setColor(Color.GREEN);
        int a = 0;
        for(parts.WallComponent comp: selectedObjects)
        {
            
             if (comp instanceof parts.Barrier) 
             {

                if (((parts.Barrier) comp).getHoehe() == ((parts.Barrier) comp).getHoeheR()) 
                {
                    for(int i = 0; i < border; i++)
                        g.drawRect((int) (comp.getPosX() * multiplicator)+i, (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator)+i, (int) (((parts.Barrier) comp).getBreite() * multiplicator)-i*2, (int) (((parts.Barrier) comp).getHoehe() * multiplicator)-i*2);
                } 
                else 
                {
                    int[] pointsX = new int[3];
                    int[] pointsY = new int[3];
                    if (((parts.Barrier) comp).getHoehe() > ((parts.Barrier) comp).getHoeheR()) 
                    {
                        System.out.println(comp.getPosY()-((parts.Barrier)comp).getHoeheL()+((parts.Barrier)comp).getHoeheR());
                        pointsX[0] = (int) (comp.getPosX() * multiplicator);
                        pointsY[0] = (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator) + (int) (((parts.Barrier) comp).getHoehe() * multiplicator) - (int) (((parts.Barrier) comp).getHoeheR() * multiplicator);
                        pointsX[1] = (int) (comp.getPosX() * multiplicator) + (int) (((parts.Barrier) comp).getBreite() * multiplicator);
                        pointsY[1] = (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator) + (int) (((parts.Barrier) comp).getHoehe() * multiplicator) - (int) (((parts.Barrier) comp).getHoeheR() * multiplicator);
                        pointsX[2] = (int) (comp.getPosX() * multiplicator);
                        pointsY[2] = (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator);

                        for(int i = 0; i < border; i++)
                        {
                            g.drawRect((int) (comp.getPosX() * multiplicator)+i, (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator) + (int) (((parts.Barrier) comp).getHoehe() * multiplicator) - (int) (((parts.Barrier) comp).getHoeheR() * multiplicator)+i, (int) (((parts.Barrier) comp).getBreite() * multiplicator)-i*2, (int) (((parts.Barrier) comp).getHoeheR() * multiplicator)-i*2);
                            
                            g.drawLine(pointsX[0]+i, pointsY[0], pointsX[2]+i, pointsY[2]+i);
                            g.drawLine(pointsX[1]-i, pointsY[1], pointsX[2], pointsY[2]+i);
                        }

                        switch (((parts.Barrier) comp).getMat()) {
                            case HOLZ:
                                g.setColor(new Color(139, 69, 19));
                                break;
                            case METALL:
                                g.setColor(new Color(227, 227, 227));
                                break;
                            case KUNSTSTOFF:
                                g.setColor(new Color(0, 153, 255));
                                break;
                            case STEIN:
                                g.setColor(new Color(156, 156, 156));
                                break;
                        }

                        for(int i = 0; i < border; i++)
                            g.drawLine(pointsX[0]+border, pointsY[0]+i, pointsX[1]-border, pointsY[1]+i);
                        
                        g.setColor(Color.GREEN);
                       }
                       else
                       {
                           pointsX[0] = (int) (comp.getPosX() * multiplicator);
                           pointsY[0] = (int) (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator) + (int) (((parts.Barrier) comp).getHoeheR() * multiplicator) - (int) (((parts.Barrier) comp).getHoeheL() * multiplicator);
                           pointsX[1] = (int) (comp.getPosX() * multiplicator) + (int) (((parts.Barrier) comp).getBreite() * multiplicator);
                           pointsY[1] = (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator) + (int) (((parts.Barrier) comp).getHoeheR() * multiplicator) - (int) (((parts.Barrier) comp).getHoeheL() * multiplicator);
                           pointsX[2] = (int) (comp.getPosX() * multiplicator) + (int) (((parts.Barrier) comp).getBreite() * multiplicator);
                           pointsY[2] = (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator);

                           for(int i = 0; i < border; i++)
                           {
                            g.drawRect((int) (comp.getPosX() * multiplicator)+i, (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator) + (int) (((parts.Barrier) comp).getHoeheR() * multiplicator) - (int) (((parts.Barrier) comp).getHoeheL() * multiplicator)+i, (int) (((parts.Barrier) comp).getBreite() * multiplicator)-2*i, (int) (((parts.Barrier) comp).getHoeheL() * multiplicator)-2*i);
                            
                            g.drawLine(pointsX[0]+i, pointsY[0], pointsX[2], pointsY[2]+i);
                            g.drawLine(pointsX[1]-i, pointsY[1], pointsX[2]-i, pointsY[2]+i);
                           }

                           switch (((parts.Barrier) comp).getMat()) {
                               case HOLZ:
                                   g.setColor(new Color(139, 69, 19));
                                   break;
                               case METALL:
                                   g.setColor(new Color(227, 227, 227));
                                   break;
                               case KUNSTSTOFF:
                                   g.setColor(new Color(0, 153, 255));
                                   break;
                               case STEIN:
                                   g.setColor(new Color(156, 156, 156));
                                   break;
                           }
                           
                           for(int i = 0; i < border; i++)
                                g.drawLine(pointsX[0]+border, pointsY[0]+i, pointsX[1]-border, pointsY[1]+i);
                           
                           g.setColor(Color.GREEN);

                       }

                }
            }
            else if(comp instanceof parts.Foundation)
                for(int i = 0; i < 5; i++)
                    g.drawRect((int)(comp.getPosX()*multiplicator)+i, (int)(plDisplay.getHeight()-comp.getPosY()*multiplicator)+i, (int)(((parts.Foundation)comp).getBreite()*multiplicator-2*i), (int)(((parts.Foundation)comp).getHoehe()*multiplicator-2*i));
            else if(comp instanceof parts.Door)
                for(int i = 0; i < 5; i++)
                    g.drawRect((int)(comp.getPosX()*multiplicator)+i, (int)(plDisplay.getHeight()-comp.getPosY()*multiplicator)+i, (int)(((parts.Door)comp).getBreite()*multiplicator-2*i), (int)(((parts.Door)comp).getHoehe()*multiplicator-2*i));
            else if(comp instanceof parts.Defect)
            {
                g.setColor(Color.red);
                for(int i = 0; i < 3; i++)
                    g.drawOval((int)(comp.getPosX()*multiplicator)+i, (int)(plDisplay.getHeight()-comp.getPosY()*multiplicator)+i, ((parts.Defect)comp).getRadius()-i*2, ((parts.Defect)comp).getRadius()-i*2);
            }
        }
        
        System.out.println("Repainted "+selectedObjects.size()+" things "+a);
      
    }
    
    /**
     * Die zeichenfläche wird geupdatet.
     */
    public void updateDisplay()
    {
        drawMargin();
        
        Graphics2D g2 = (Graphics2D)plDisplay.getGraphics();
        float[] scales = { 1f, 1f, 1f, 0.5f };
        float[] offsets = new float[4];
        RescaleOp rop = new RescaleOp(scales, offsets, null);
        g2.drawImage(tempImage, 0, 0, plDisplay.getWidth(), plDisplay.getHeight(), null);
       
    }
    
    
    /**
     * Die Seitliche beschrieftung wird gezeichnet.
     */
    public void drawMargin()
    {
        g.setColor(Color.black);

        
        for(int i = plDisplay.getHeight(), c = 0; i > 0; i-=5*multiplicator, c+=5)
        {
            g.drawLine(0, i, 20, i);
            g.drawString(""+c+"m", 6, i-5);
        }
        
        for(int i = 0, c = 0; i < plDisplay.getWidth(); i+=5*multiplicator, c+=5)
        {
            g.drawLine(i, plDisplay.getHeight(), i, plDisplay.getHeight()-20);
            g.drawString(""+c+"m", i+6, plDisplay.getHeight()-5);
        }
        
    }
    
   

    /**
     * Die Hintergrundfarbe der Labels wird zurückgesetzt
     */
    public void changeBgModes()
    {
        lbNeu.setBackground(Color.lightGray);
        lbLöschen.setBackground(Color.lightGray);
        lbDefect.setBackground(Color.lightGray);
        lbSave.setBackground(Color.lightGray);
        lbMove.setBackground(Color.lightGray);
        lbModify.setBackground(Color.lightGray);
        lbSelect.setBackground(Color.lightGray);
        lbDup.setBackground(Color.lightGray);
        lbLoad.setBackground(Color.lightGray);
    }
    
    /**
     * Selektiert das ausgewählte objekt
     * @param x X-Koordinate des Klicks
     * @param y Y-Koordinate des Klicks
     */
    public void selectClicked(double x, double y)
    {
        selectedObjects.clear();
        parts.Selektor sel = new Selektor(x, y, 1, 1);
        if(getCollisions(sel).length > 0)
        {   
            selectedObjects.add(getCollisions(new Selektor(x, y, 1, 1))[getCollisions(new Selektor(x, y, 1, 1)).length-1]);
        }
    }      
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[])
//    {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try
//        {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
//            {
//                if ("Nimbus".equals(info.getName()))
//                {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex)
//        {
//            java.util.logging.Logger.getLogger(SoundBarrierGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex)
//        {
//            java.util.logging.Logger.getLogger(SoundBarrierGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex)
//        {
//            java.util.logging.Logger.getLogger(SoundBarrierGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex)
//        {
//            java.util.logging.Logger.getLogger(SoundBarrierGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable()
//        {
//            public void run()
//            {
//                new SoundBarrierGui().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbDefect;
    private javax.swing.JLabel lbDup;
    private javax.swing.JLabel lbLoad;
    private javax.swing.JLabel lbLöschen;
    private javax.swing.JLabel lbModify;
    private javax.swing.JLabel lbMove;
    private javax.swing.JLabel lbNeu;
    private javax.swing.JLabel lbSave;
    private javax.swing.JLabel lbSelect;
    private javax.swing.JMenuItem miDup;
    private javax.swing.JPanel plDisplay;
    private javax.swing.JPanel plTools;
    private javax.swing.JPopupMenu pmModify;
    // End of variables declaration//GEN-END:variables
}
