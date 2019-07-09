/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import data.Components;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_INT_ARGB;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import parts.Selektor;

/**
 *
 * @author User
 */
public class Soundbarrier extends javax.swing.JFrame {

    private BufferedImage tempImage;
    private Graphics g;
    
    //Design Vars
    private int multiplicator = 20;
    private final int border = 5;
    private final int defRad = 30;
    
    //Data vars
    private int mode = 0;
    private int currentSector = -1;
    private final LinkedList<parts.WallComponent> data = new LinkedList();
    private final LinkedList<parts.WallComponent> selectedObjects = new LinkedList();
    private boolean changes = false;
    
    //Vars for draggign
    private boolean dragAble = false;
    private parts.Selektor selektor;
    private final LinkedList<Double> oldX = new LinkedList();
    private final LinkedList<Double> oldY = new LinkedList();
    private double oldXMouse;
    private double oldYMouse;
    private double minX, minY;
    private double maxX, maxY;
    
    public Soundbarrier() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        plDisplay.setBackground(Color.white);
        resetLabelBackground();
        
        plDisplay.setSize(103*multiplicator, 51*multiplicator);
        plDisplay.setPreferredSize(new Dimension(103*multiplicator, 51*multiplicator));
        tempImage = new BufferedImage(plDisplay.getWidth(), plDisplay.getHeight(), TYPE_INT_ARGB);
        g = tempImage.createGraphics();
        g.setFont(new Font("Monospaced", g.getFont().getStyle(), g.getFont().getSize()));
       
        spScrollPane.getVerticalScrollBar().setMinimum(2283);
        spScrollPane.getHorizontalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) 
            {
                redrawAll();
            }
        });
       
       spScrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) 
            {
                redrawAll();
            }
        });
        
       
 
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        
        redrawAll();
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        plMenuebar = new javax.swing.JPanel();
        plToolbox = new javax.swing.JPanel();
        lbCreate = new javax.swing.JLabel();
        lbDefect = new javax.swing.JLabel();
        lbModify = new javax.swing.JLabel();
        lbSelect = new javax.swing.JLabel();
        lbMove = new javax.swing.JLabel();
        lbDuplicate = new javax.swing.JLabel();
        lbDelete = new javax.swing.JLabel();
        plDisplayPane = new javax.swing.JPanel();
        plSouth = new javax.swing.JPanel();
        plNorth = new javax.swing.JPanel();
        plCenter = new javax.swing.JPanel();
        spScrollPane = new javax.swing.JScrollPane();
        plDisplay = new javax.swing.JPanel();
        mbMenue = new javax.swing.JMenuBar();
        muData = new javax.swing.JMenu();
        miNew = new javax.swing.JMenuItem();
        miSave = new javax.swing.JMenuItem();
        miLoad = new javax.swing.JMenuItem();
        miClose = new javax.swing.JMenuItem();
        muView = new javax.swing.JMenu();
        miHideTools = new javax.swing.JMenuItem();
        miShowTools = new javax.swing.JMenuItem();
        muEdit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                onMovedFrame(evt);
            }
            public void componentResized(java.awt.event.ComponentEvent evt) {
                onResizedFrame(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                onClosingFrame(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                onOpenedFrame(evt);
            }
        });

        plMenuebar.setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(plMenuebar, java.awt.BorderLayout.PAGE_START);

        plToolbox.setMinimumSize(new java.awt.Dimension(130, 105));
        plToolbox.setPreferredSize(new java.awt.Dimension(105, 105));
        plToolbox.setLayout(new java.awt.GridLayout(7, 0));

        lbCreate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconAdd.png"))); // NOI18N
        lbCreate.setToolTipText("");
        lbCreate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbCreate.setOpaque(true);
        lbCreate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onClickNew(evt);
            }
        });
        plToolbox.add(lbCreate);

        lbDefect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDefect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconDefect.png"))); // NOI18N
        lbDefect.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbDefect.setOpaque(true);
        lbDefect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onClickDefect(evt);
            }
        });
        plToolbox.add(lbDefect);

        lbModify.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbModify.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconModify.png"))); // NOI18N
        lbModify.setToolTipText("");
        lbModify.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbModify.setOpaque(true);
        lbModify.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onClickModify(evt);
            }
        });
        plToolbox.add(lbModify);

        lbSelect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSelect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconSelect.png"))); // NOI18N
        lbSelect.setToolTipText("");
        lbSelect.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbSelect.setOpaque(true);
        lbSelect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onClickSelect(evt);
            }
        });
        plToolbox.add(lbSelect);

        lbMove.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconMove.png"))); // NOI18N
        lbMove.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbMove.setOpaque(true);
        lbMove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onClickMove(evt);
            }
        });
        plToolbox.add(lbMove);

        lbDuplicate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDuplicate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconDuplicate.png"))); // NOI18N
        lbDuplicate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbDuplicate.setOpaque(true);
        lbDuplicate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onClickDuplicate(evt);
            }
        });
        plToolbox.add(lbDuplicate);

        lbDelete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconDelete.png"))); // NOI18N
        lbDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbDelete.setOpaque(true);
        lbDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onClickDelete(evt);
            }
        });
        plToolbox.add(lbDelete);

        getContentPane().add(plToolbox, java.awt.BorderLayout.LINE_END);

        plDisplayPane.setLayout(new java.awt.BorderLayout());

        plSouth.setLayout(new java.awt.GridLayout(1, 1));
        plDisplayPane.add(plSouth, java.awt.BorderLayout.PAGE_END);

        plNorth.setLayout(new java.awt.BorderLayout());
        plDisplayPane.add(plNorth, java.awt.BorderLayout.LINE_END);

        plCenter.setLayout(new java.awt.GridLayout(1, 1));

        spScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        spScrollPane.setToolTipText("");
        spScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        spScrollPane.setAutoscrolls(true);
        spScrollPane.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                onResizedScrollPane(evt);
            }
        });

        plDisplay.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                onEnteredDisplay(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                onPressedDisplay(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                onReleasedDisplay(evt);
            }
        });
        plDisplay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                onKeyPressedDisplay(evt);
            }
        });

        javax.swing.GroupLayout plDisplayLayout = new javax.swing.GroupLayout(plDisplay);
        plDisplay.setLayout(plDisplayLayout);
        plDisplayLayout.setHorizontalGroup(
            plDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 282, Short.MAX_VALUE)
        );
        plDisplayLayout.setVerticalGroup(
            plDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        spScrollPane.setViewportView(plDisplay);

        plCenter.add(spScrollPane);

        plDisplayPane.add(plCenter, java.awt.BorderLayout.CENTER);

        getContentPane().add(plDisplayPane, java.awt.BorderLayout.CENTER);

        muData.setText("Datei");

        miNew.setText("Neu");
        miNew.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        miNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onMiNew(evt);
            }
        });
        muData.add(miNew);

        miSave.setText("Speichern");
        miSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onMiSave(evt);
            }
        });
        muData.add(miSave);

        miLoad.setText("Laden");
        miLoad.setToolTipText("");
        miLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onMiLoad(evt);
            }
        });
        muData.add(miLoad);

        miClose.setText("Beenden");
        miClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onMiClose(evt);
            }
        });
        muData.add(miClose);

        mbMenue.add(muData);

        muView.setText("Ansicht");
        muView.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
                onMuViewDeselected(evt);
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
            }
        });

        miHideTools.setText("Werzeuge verstecken");
        miHideTools.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onHideTools(evt);
            }
        });
        muView.add(miHideTools);

        miShowTools.setText("Werzeuge anzeigen");
        miShowTools.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onShowTools(evt);
            }
        });
        muView.add(miShowTools);

        mbMenue.add(muView);

        muEdit.setText("Edit");
        muEdit.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
                onMuEditDeselected(evt);
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
            }
        });
        mbMenue.add(muEdit);

        setJMenuBar(mbMenue);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resetLabelBackground()
    {
        lbCreate.setBackground(Color.white);
        lbDefect.setBackground(Color.white);
        lbDelete.setBackground(Color.white);
        lbDuplicate.setBackground(Color.white);
        lbModify.setBackground(Color.white);
        lbMove.setBackground(Color.white);
        lbSelect.setBackground(Color.white);
    }
    
    private void onClickNew(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onClickNew
        resetLabelBackground();
        lbCreate.setBackground(Color.lightGray);
        
        mode = 1;
    }//GEN-LAST:event_onClickNew

    private void onClickSelect(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onClickSelect
        resetLabelBackground();
        lbSelect.setBackground(Color.lightGray);
        
        mode = 6;
    }//GEN-LAST:event_onClickSelect

    private void onClickModify(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onClickModify
        resetLabelBackground();
        lbModify.setBackground(Color.lightGray);
        
        mode = 5;
        
        if(selectedObjects.size() > 0)
        {
            modifyComponents((int)(selectedObjects.get(0).getPosX()*multiplicator), plDisplay.getHeight() - (int)(selectedObjects.get(0).getPosY()*multiplicator));
            redrawAll();
        }
    }//GEN-LAST:event_onClickModify

    private void onClickDuplicate(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onClickDuplicate
        resetLabelBackground();
        lbDuplicate.setBackground(Color.lightGray);
        
        int anz = 0;
        try
        {
            anz = Integer.parseInt(JOptionPane.showInputDialog(this, "Wie oft soll die Auswahl dupliziert werden?", "Eingabe", 1));
            
            for(int i = 0; i < anz; i++)
                duplicateSelected();
            redrawAll();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
    }//GEN-LAST:event_onClickDuplicate

    private void onClickDefect(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onClickDefect
        resetLabelBackground();
        lbDefect.setBackground(Color.lightGray);
        
        mode = 3;
    }//GEN-LAST:event_onClickDefect

    private void onClickDelete(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onClickDelete
        resetLabelBackground();
        lbDelete.setBackground(Color.lightGray);
        
        mode = 2;
        System.out.println("S "+selectedObjects.size());
        if(selectedObjects.size() > 0)
        {
            removeComponent((int)(selectedObjects.get(0).getPosX()*multiplicator), plDisplay.getHeight() - (int)(selectedObjects.get(0).getPosY()*multiplicator));
            redrawAll();
        }
        
    }//GEN-LAST:event_onClickDelete

    private void onClickMove(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onClickMove
        resetLabelBackground();
        lbMove.setBackground(Color.lightGray);
        
        mode = 4;
    }//GEN-LAST:event_onClickMove

    private void onClickDisplay(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onClickDisplay
        System.out.println("ClickedDisplay");
        
        if(mode == 1)
            createNewComponent(evt.getX(), evt.getY());
        else if(mode == 2)
            removeComponent(evt.getX(), evt.getY());
        else if(mode == 3)
            createDefect(evt.getX(), evt.getY());
        else if(mode == 5)
            modifyComponents(evt.getX(), evt.getY());
        
        if(mode < 2 || mode > 5)
            showDefectComment(evt.getX(), evt.getY());
        
        redrawAll();
        
    }//GEN-LAST:event_onClickDisplay

    private void onDraggedDisplay(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onDraggedDisplay
        if(mode == 4)
        {
            if(dragAble)
            {
                int i = 0;

                System.out.println("MinX "+minX);
                System.out.println("MinY "+minY);
                System.out.println("MaxX "+maxX);
                System.out.println("MaxY "+maxY);
                System.out.println("ChangeX: "+(calcPxToCoordsX(evt.getX())));
                System.out.println("ChangeY: "+(calcPxToCoordsY(evt.getY())));
                
                
                //Überprüft, ob ein Objekt durch die Bewegung, das Panel verlassen würde
                i = 0;
                if(minX+(calcPxToCoordsX(evt.getX()) - oldXMouse) >= 0 && maxX+(calcPxToCoordsX(evt.getX()) - oldXMouse) <= plDisplay.getWidth()*1.0/multiplicator )
                {
                    System.out.println("X: okay");
                    for(parts.WallComponent comp: selectedObjects)
                    {
                        data.remove(comp);

                        comp.setPosX(oldX.get(i) + (calcPxToCoordsX(evt.getX()) - oldXMouse));
                        //comp.setPosY(oldY.get(i) + (calcPxToCoordsY(evt.getY()) - oldYMouse));
                        i++;

                        data.add(comp);
                    }
                }
                else if(maxX+(calcPxToCoordsX(evt.getX()) - oldXMouse) <= plDisplay.getWidth()*1.0/multiplicator)
                {
                    for(parts.WallComponent comp: selectedObjects)
                    {
                        data.remove(comp);

                        comp.setPosX(oldX.get(i) - minX);
                        //comp.setPosY(oldY.get(i) + (calcPxToCoordsY(evt.getY()) - oldYMouse));
                        i++;

                        data.add(comp);
                    }
                }
                else if(minX+(calcPxToCoordsX(evt.getX()) - oldXMouse) >= 0)
                {
                    for(parts.WallComponent comp: selectedObjects)
                    {
                        data.remove(comp);

                        comp.setPosX(oldX.get(i) + plDisplay.getWidth()*1.0/multiplicator - maxX);
                        i++;

                        data.add(comp);
                    }
                    
                }
                
                i = 0;
                if(minY+(calcPxToCoordsY(evt.getY()) - oldYMouse) >= 0 && maxY+(calcPxToCoordsY(evt.getY()) - oldYMouse) <= plDisplay.getHeight()*1.0/multiplicator)
                {
                    System.out.println("Y: okay");
                    for(parts.WallComponent comp: selectedObjects)
                    {
                        data.remove(comp);

                        //comp.setPosX(oldX.get(i) + (calcPxToCoordsX(evt.getX()) - oldXMouse));
                        comp.setPosY(oldY.get(i) + (calcPxToCoordsY(evt.getY()) - oldYMouse));
                        i++;

                        data.add(comp);
                    }
                }
                else if(maxY+(calcPxToCoordsY(evt.getY()) - oldYMouse) <= plDisplay.getHeight()*1.0/multiplicator)
                {
                    for(parts.WallComponent comp: selectedObjects)
                    {
                        data.remove(comp);

                        comp.setPosY(oldY.get(i) - minY);
                        //comp.setPosY(oldY.get(i) + (calcPxToCoordsY(evt.getY()) - oldYMouse));
                        i++;

                        data.add(comp);
                    }
                }
                else if(minY+(calcPxToCoordsY(evt.getY()) - oldYMouse) >= 0)
                {
                    for(parts.WallComponent comp: selectedObjects)
                    {
                        data.remove(comp);

                        comp.setPosY(oldY.get(i) + plDisplay.getHeight()*1.0/multiplicator - maxY);
                        i++;

                        data.add(comp);
                    }
                }
                
                changes = true;
                redrawAll();
            }
        }
        else if(mode == 6)
        {
           if(calcPxToCoordsX(evt.getX())-oldXMouse > 0)
                selektor.setBreite(calcPxToCoordsX(evt.getX())-oldXMouse);
            else
            {
                selektor.setPosX(oldXMouse+calcPxToCoordsX(evt.getX())-oldXMouse);
                selektor.setBreite((calcPxToCoordsX(evt.getX())-oldXMouse)*-1);
            }
            if(-1*(calcPxToCoordsY(evt.getY())-oldYMouse) > 0)
                selektor.setHoehe(-1*(calcPxToCoordsY(evt.getY())-oldYMouse));
            else
            {
                selektor.setPosY(oldYMouse+(oldYMouse-calcPxToCoordsY(evt.getY()))*-1);
                selektor.setHoehe((oldYMouse-calcPxToCoordsY(evt.getY()))*-1);
            }
            redrawAll(); 
        }
    }//GEN-LAST:event_onDraggedDisplay

    private void onPressedDisplay(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onPressedDisplay
        if(mode == 4)
        {
             parts.Selektor sel = new Selektor(calcPxToCoordsX(evt.getX()), calcPxToCoordsY(evt.getY()), 1, 1);

            if(calcCollisions(sel).length == 0)
                selectedObjects.clear();
            if(calcCollisions(sel).length > 0 || selectedObjects.size() > 0)
            {
                if(selectedObjects.size() == 0)
                    selectClicked(calcPxToCoordsX(evt.getX()), calcPxToCoordsY(evt.getY()));
                if (selectedObjects.size() > 0)
                {
                    //parts.Barrier bar = new Barrier(, 1.0*plDisplay.getHeight()/multiplicator - 1.0*evt.getY()/multiplicator, 1, 1, Material.HOLZ);

                    dragAble = true;
                    oldXMouse = calcPxToCoordsX(evt.getX());
                    oldYMouse = calcPxToCoordsY(evt.getY());
                    oldX.clear();
                    oldY.clear();
                    
                    int i = 0;
                    for(parts.WallComponent comp: selectedObjects)
                    {
                        oldX.add(i, comp.getPosX());
                        oldY.add(i,comp.getPosY());
                        i++;
                    }
                    
                    //**************************************************
                    minX = Double.MAX_VALUE;
                    minY = Double.MAX_VALUE;
                    maxX = Double.MIN_VALUE;
                    maxY = Double.MIN_VALUE;
                          
                //searching min and max
                for (parts.WallComponent comp : selectedObjects) 
                {
                    if(comp.getPosX() < minX)
                        minX = comp.getPosX();
                    if(comp.getPosY()-(comp instanceof parts.Barrier ? ((parts.Barrier)comp).getHoeheL() > ((parts.Barrier)comp).getHoeheR() ? ((parts.Barrier)comp).getHoeheL() : ((parts.Barrier)comp).getHoeheR() :comp instanceof parts.Rect ? ((parts.Rect)comp).getHoehe(): (((parts.Defect)comp).getRadius()*1.0/multiplicator)) < minY)
                        minY = comp.getPosY()-(comp instanceof parts.Barrier ? ((parts.Barrier)comp).getHoeheL() > ((parts.Barrier)comp).getHoeheR() ? ((parts.Barrier)comp).getHoeheL() : ((parts.Barrier)comp).getHoeheR() :comp instanceof parts.Rect ? ((parts.Rect)comp).getHoehe(): ((parts.Defect)comp).getRadius()*1.0/multiplicator);
                    if(comp.getPosX()+(comp instanceof parts.Rect ? ((parts.Rect)comp).getBreite() : (((parts.Defect)comp).getRadius()*1.0/multiplicator)) > maxX)
                        maxX = comp.getPosX()+(comp instanceof parts.Rect ? ((parts.Rect)comp).getBreite() : (((parts.Defect)comp).getRadius()*1.0/multiplicator));
                    if(comp.getPosY() > maxY)
                        maxY = comp.getPosY();
                }
                }
            }
        }
        else if(mode == 6)
        {
            selectedObjects.clear();
            redrawAll();
            oldXMouse = calcPxToCoordsX(evt.getX());
            oldYMouse = calcPxToCoordsY(evt.getY());
            selektor = new Selektor(oldXMouse, oldYMouse, 0, 0);
        }
            
    }//GEN-LAST:event_onPressedDisplay

    private void onReleasedDisplay(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onReleasedDisplay
        if(mode == 4)
        {
            dragAble = false;
            selectedObjects.clear();
            
            redrawAll();
        }
        else if(mode == 6)
        {
            selectedObjects.clear();
            
            for(parts.WallComponent comp: calcCollisions(selektor))
            {
                selectedObjects.add(comp);
                data.remove(comp);
                data.add(comp);
            }
            
            selektor = null;
            redrawAll();
        }
    }//GEN-LAST:event_onReleasedDisplay

    private void onMouseWheelDisplay(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_onMouseWheelDisplay
        if(multiplicator+(evt.getUnitsToScroll())*-1 > 12 && multiplicator+evt.getUnitsToScroll()*-1 < 45)
        {
            multiplicator+=evt.getUnitsToScroll()*-1;
            redrawAll();
        }
        
        
    }//GEN-LAST:event_onMouseWheelDisplay

    private void onResizedFrame(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_onResizedFrame
        repaint();
        tempImage = new BufferedImage(plDisplay.getWidth(), plDisplay.getHeight(), TYPE_INT_ARGB);
        g = tempImage.createGraphics();
        redrawAll();
        
    }//GEN-LAST:event_onResizedFrame

    private void onMovedFrame(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_onMovedFrame
        redrawAll();
    }//GEN-LAST:event_onMovedFrame

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

    private void onOpenedFrame(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_onOpenedFrame
        
        /*gui.EditSectorDialog dlg = new gui.EditSectorDialog(this, true);
        dlg.setVisible(true);
        
        if(dlg.isOkay())
        {
            currentSector = dlg.getSector();
            load(dlg.getSector());
        }
        */
    }//GEN-LAST:event_onOpenedFrame

    private void onMiSave(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onMiSave
        save();
    }//GEN-LAST:event_onMiSave

    private void onMiLoad(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onMiLoad
        gui.EditSectorDialog dlg = new gui.EditSectorDialog(this, true);
        dlg.setVisible(true);
        
        if(dlg.isOkay())
        {
            currentSector = dlg.getSector();
            load(dlg.getSector());
            mode = 0;
        }
    }//GEN-LAST:event_onMiLoad

    private void onMiNew(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onMiNew
        selectedObjects.clear();
        data.clear();
        oldX.clear();
        oldY.clear();
        tempImage = new BufferedImage(plDisplay.getWidth(), plDisplay.getHeight(), TYPE_INT_ARGB);
        g = tempImage.createGraphics();
        g.setFont(new Font("Monospaced", g.getFont().getStyle(), g.getFont().getSize()));
        
        System.gc();
        
        redrawAll();
        drawMargin();
    }//GEN-LAST:event_onMiNew

    private void onMuViewDeselected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_onMuViewDeselected
 
    }//GEN-LAST:event_onMuViewDeselected

    private void onMuEditDeselected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_onMuEditDeselected

    }//GEN-LAST:event_onMuEditDeselected

    private void onEnteredDisplay(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onEnteredDisplay

    }//GEN-LAST:event_onEnteredDisplay

    private void onHideTools(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onHideTools

        plToolbox.setVisible(false);
        
        tempImage = new BufferedImage(plDisplay.getWidth()+plToolbox.getWidth(), plDisplay.getHeight(), TYPE_INT_ARGB);
        g = tempImage.createGraphics();
        
        redrawAll();
    }//GEN-LAST:event_onHideTools

    private void onMiClose(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onMiClose
        //save();
        this.dispose();
    }//GEN-LAST:event_onMiClose

    private void onKeyPressedDisplay(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_onKeyPressedDisplay
        System.out.println(evt.getKeyChar());
    }//GEN-LAST:event_onKeyPressedDisplay

    private void onShowTools(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onShowTools
        plToolbox.setVisible(true);

        tempImage = new BufferedImage(plDisplay.getWidth()-plToolbox.getWidth(), plDisplay.getHeight(), TYPE_INT_ARGB);
        g = tempImage.createGraphics();

        redrawAll();
    }//GEN-LAST:event_onShowTools

    private void onResizedScrollPane(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_onResizedScrollPane
        redrawAll();
    }//GEN-LAST:event_onResizedScrollPane

    private double calcPxToCoordsX(int xCoord)
    {
        return 1.0 * xCoord / multiplicator;
    }
    
    private double calcPxToCoordsY(int yCoord)
    {
        return 1.0 * plDisplay.getHeight() / multiplicator - 1.0 * yCoord / multiplicator;
    }
    
    private void createNewComponent(int evtX, int evtY)
    {
        gui.CreateComponent dlg = new gui.CreateComponent(this, true, calcPxToCoordsX(evtX), calcPxToCoordsY(evtY));
        dlg.setVisible(true);

        if (dlg.isOkay()) 
        {
            for (parts.WallComponent comp : dlg.getCreatedComponents()) 
            {
                data.add(comp);
                changes = true;
            }

        }
    }
    
    private void removeComponent(int evtX, int evtY)
    {
        parts.Selektor sel = new Selektor(calcPxToCoordsX(evtX), calcPxToCoordsY(evtY), 1, 1);
        if(calcCollisions(sel).length > 0)
        {
            parts.WallComponent collision = calcCollisions(sel)[calcCollisions(sel).length-1];
            if(selectedObjects.contains(collision))
            {
                for(parts.WallComponent comp: selectedObjects)
                    data.remove(comp);
                selectedObjects.clear();
            }
            else
                data.remove(collision);
            
            changes = true;
        }
        
    }
    
    private void createDefect(int evtX, int evtY)
    {
        parts.Defect def = new parts.Defect(calcPxToCoordsX(evtX - defRad/2), calcPxToCoordsY(evtY - defRad/2), defRad);
        gui.ModifyDefectDialog dlg = new gui.ModifyDefectDialog(this, true, def);
        dlg.setVisible(true);
        
        if(dlg.isOkay())
        {
            def.setComment(dlg.getComment());
            data.add(def);
            changes = true;
        }
    }
    
    private void modifyComponents(int evtX, int evtY)
    {
        Components changeMode = null;
        if (selectedObjects.size() > 0) 
        {
            boolean barrier = false;
            boolean foundation = false;
            boolean door = false;

            LinkedList<parts.WallComponent> def = new LinkedList<>();

            for (parts.WallComponent comp : selectedObjects) {
                if (comp instanceof parts.Barrier) {
                    barrier = true;
                } else if (comp instanceof parts.Foundation) {
                    foundation = true;
                } else if (comp instanceof parts.Door) {
                    door = true;
                } else if (comp instanceof parts.Defect) {
                    def.add(comp);
                }
            }

            for (parts.WallComponent comp : def) {
                selectedObjects.remove(comp);
            }

            if (barrier && foundation && door) {
                changeMode = Components.BARRIER_AND_FOUNDATION_AND_DOOR;
            } else if (barrier && foundation) {
                changeMode = Components.BARRIER_AND_FOUNDATION;
            } else if (barrier && door) {
                changeMode = Components.BARRIER_AND_DOOR;
            } else if (foundation && door) {
                changeMode = Components.FOUNDATION_AND_DOOR;
            } else if (foundation) {
                changeMode = Components.FOUNDATION;
            } else if (barrier) {
                changeMode = Components.BARRIER;
            } else if (door) {
                changeMode = Components.DOOR;
            }

            gui.CreateComponent dlg;
            if (selectedObjects.size() == 1) {
                dlg = new gui.CreateComponent(this, true, changeMode, selectedObjects.get(0));
            } else {
                dlg = new gui.CreateComponent(this, true, changeMode, null);
            }

            dlg.setVisible(true);

            if (dlg.isOkay()) {
                if (selectedObjects.size() == 1) {
                    data.remove(selectedObjects.get(0));
                    selectedObjects.clear();

                    data.add(dlg.getCreatedComponents().get(0));
                    selectedObjects.add(dlg.getCreatedComponents().get(0));
                } else {
                    for (parts.WallComponent comp : selectedObjects) {
                        data.remove(comp);
                    }
                    
                    for (parts.WallComponent change : dlg.getCreatedComponents()) {
                        if (change instanceof parts.Barrier) {
                            for (parts.WallComponent comp : selectedObjects) {
                                if (comp instanceof parts.Barrier) {
                                    ((parts.Barrier) comp).setHoeheL((((parts.Barrier) ((parts.WallComponent) change)).getHoeheL()));
                                    ((parts.Barrier) comp).setHoeheR((((parts.Barrier) ((parts.WallComponent) change)).getHoeheR()));
                                    ((parts.Barrier) comp).setBreite((((parts.Barrier) ((parts.WallComponent) change)).getBreite()));
                                    ((parts.Barrier) comp).setMat((((parts.Barrier) ((parts.WallComponent) change)).getMat()));
                                }
                            }
                        } else if (change instanceof parts.Foundation) {
                            for (parts.WallComponent comp : selectedObjects) {
                                if (comp instanceof parts.Foundation) {
                                    ((parts.Foundation) comp).setHoehe((((parts.Foundation) change)).getHoehe());
                                    ((parts.Foundation) comp).setBreite((((parts.Foundation) change)).getBreite());
                                }
                            }
                        } else if (change instanceof parts.Door) {
                            for (parts.WallComponent comp : selectedObjects) {
                                if (comp instanceof parts.Door) {
                                    ((parts.Door) comp).setHoehe((((parts.Door) change)).getHoehe());
                                    ((parts.Door) comp).setBreite((((parts.Door) change)).getBreite());
                                }
                            }
                        }
                    }

                    for (parts.WallComponent comp : selectedObjects) {
                        data.add(comp);
                    }
                }
            }
        } else {
            parts.Selektor sel = new Selektor(calcPxToCoordsX(evtX), calcPxToCoordsY(evtY), 1, 1);
            if (calcCollisions(sel).length > 0) {
                parts.WallComponent comp = calcCollisions(sel)[calcCollisions(sel).length-1];

                gui.CreateComponent dlg = null;
                if (comp instanceof parts.Barrier) {
                    dlg = new gui.CreateComponent(this, true, Components.BARRIER, comp);
                } else if (comp instanceof parts.Foundation) {
                    dlg = new gui.CreateComponent(this, true, Components.FOUNDATION, comp);
                } else if (comp instanceof parts.Door) {
                    dlg = new gui.CreateComponent(this, true, Components.DOOR, comp);
                }

                if (comp instanceof parts.Defect) {
                    gui.ModifyDefectDialog ddlg = new gui.ModifyDefectDialog(this, true, ((parts.Defect) comp));
                    ddlg.setVisible(true);

                    if (ddlg.isOkay()) {
                        selectedObjects.remove(comp);
                        data.remove(comp);
                        ((parts.Defect) comp).setComment(ddlg.getComment());
                        selectedObjects.add(comp);
                        data.add(comp);
                        changes = true;
                    }
                } else {
                    dlg.setVisible(true);

                    if (dlg.isOkay()) {
                        selectedObjects.remove(comp);
                        data.remove(comp);
                        if (comp instanceof parts.Barrier) {
                            ((parts.Barrier) comp).setHoeheL(((parts.Barrier) dlg.getCreatedComponents().get(0)).getHoeheL());
                            ((parts.Barrier) comp).setHoeheR(((parts.Barrier) dlg.getCreatedComponents().get(0)).getHoeheR());
                            ((parts.Barrier) comp).setBreite(((parts.Barrier) dlg.getCreatedComponents().get(0)).getBreite());
                            ((parts.Barrier) comp).setMat(((parts.Barrier) dlg.getCreatedComponents().get(0)).getMat());
                        } else if (comp instanceof parts.Foundation) {
                            ((parts.Foundation) comp).setHoehe(((parts.Foundation) dlg.getCreatedComponents().get(0)).getHoehe());
                            ((parts.Foundation) comp).setBreite(((parts.Foundation) dlg.getCreatedComponents().get(0)).getBreite());
                        } else if (comp instanceof parts.Door) {
                            ((parts.Door) comp).setHoehe(((parts.Door) dlg.getCreatedComponents().get(0)).getHoehe());
                            ((parts.Door) comp).setBreite(((parts.Door) dlg.getCreatedComponents().get(0)).getBreite());
                        }

                        selectedObjects.add(comp);
                        data.add(comp);
                        changes = true;
                    }
                }
            }
        }
    }
    
    private parts.WallComponent[] calcCollisions(parts.Selektor collObj)
    {
        int count = 0;
        System.out.println("Click: "+collObj.getPosX()+" --- "+collObj.getPosY());
        for (parts.WallComponent com : data)
        {

            if(com instanceof parts.Barrier)
            {
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
    
    
    private void showDefectComment(int evtX, int evtY)
    {
        parts.Selektor sel = new Selektor(calcPxToCoordsX(evtX), calcPxToCoordsY(evtY), 1, 1);
        if (calcCollisions(sel).length > 0) {
            if (calcCollisions(sel)[calcCollisions(sel).length - 1] instanceof parts.Defect) {
                String text = ((parts.Defect) calcCollisions(sel)[calcCollisions(sel).length-1]).getComment();
                String nText = "";
                boolean umbruch = false;

                for (int i = 0, c = 0; i < text.length(); i++) {
                    nText += text.charAt(i);
                    if (text.charAt(i) == ' ' && umbruch) {
                        umbruch = false;
                        nText += "\n";
                        c = 0;
                    }

                    c++;

                    if (c == 50) {
                        umbruch = true;
                    }
                }
                JOptionPane.showMessageDialog(this, nText, "Kommentar", 1);
            }
        }
    }
    
    private void duplicateSelected()
    {
        double xMin = Double.MAX_VALUE;
        double xMax = 0;
        int idxMin = 0;
        int idxMax = 0;
        int c = 0;
        for (parts.WallComponent comp : selectedObjects) {
            if (comp.getPosX() < xMin && !(comp instanceof parts.Defect)) {
                idxMax = c;
                xMin = comp.getPosX();
            }

            if (comp instanceof parts.Rect) {
                if (((parts.Rect) comp).getBreite() + comp.getPosX() > xMax) {
                    idxMax = c;
                    xMax = comp.getPosX() + ((parts.Rect) comp).getBreite();
                }
            }

            c++;
        }

        LinkedList<parts.WallComponent> duplicated = new LinkedList();

        for (parts.WallComponent comp : selectedObjects) {
            if (comp instanceof parts.Barrier) {

                parts.Barrier bar = new parts.Barrier(comp.getPosX() + (xMax - xMin), comp.getPosY(), ((parts.Barrier) comp).getBreite(), ((parts.Barrier) comp).getHoeheL(), ((parts.Barrier) comp).getHoeheR(), ((parts.Barrier) comp).getMat());
                bar.setMat(((parts.Barrier) comp).getMat());
                duplicated.add(bar);

            } else if (comp instanceof parts.Foundation) {

                parts.Foundation fd = new parts.Foundation(comp.getPosX() + xMax - xMin, comp.getPosY(), ((parts.Foundation) comp).getBreite(), ((parts.Foundation) comp).getHoehe());
                duplicated.add(fd);
            } else if (comp instanceof parts.Door) {

                parts.Door dr = new parts.Door(comp.getPosX() + xMax - xMin, comp.getPosY(), ((parts.Door) comp).getBreite(), ((parts.Door) comp).getHoehe());
                duplicated.add(dr);
            } else if (comp instanceof parts.Defect) {

                parts.Defect def = new parts.Defect(comp.getPosX() + xMax - xMin + ((parts.Defect) comp).getRadius(), comp.getPosY(), (int) ((parts.Defect) comp).getRadius());
                duplicated.add(def);
            }
        }

        if (duplicated.size() > 0) {
            redrawAll();
            changes = true;
        }

        selectedObjects.clear();
        for (parts.WallComponent comp : duplicated) {
            data.add(comp);
            selectedObjects.add(comp);
        }
    }
    
    private void selectClicked(double x, double y)
    {
        selectedObjects.clear();
        parts.Selektor sel = new Selektor(x, y, 1, 1);
        if(calcCollisions(sel).length > 0)
        {   
            selectedObjects.add(calcCollisions(new Selektor(x, y, 1, 1))[calcCollisions(new Selektor(x, y, 1, 1)).length-1]);
        }
    }
    
    private void redrawAll()
    {
       
        
        g.setColor(Color.white);
        g.fillRect(0, 0, plDisplay.getWidth(), plDisplay.getWidth());
        
        drawMargin();
        plToolbox.repaint();
        
        for(parts.WallComponent com: data)
        {
            drawComponent(com); 
        }
        
        redrawSelected();
        
        if(selektor != null)
            drawComponent(selektor);
        
          updateDisplay();
    }
    
    private void drawComponent(parts.WallComponent comp)
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
                     g.setColor(new Color(139,141,122));
                     break;
             }

             if (((parts.Barrier) comp).getHoehe() == ((parts.Barrier) comp).getHoeheR()) 
             {
                 g.fillRect((int) (comp.getPosX() * multiplicator), (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator), (int) (((parts.Barrier) comp).getBreite() * multiplicator), (int) (((parts.Barrier) comp).getHoehe() * multiplicator));
                 g.setColor(Color.black);
                 g.drawRect((int) (comp.getPosX() * multiplicator), (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator), (int) (((parts.Barrier) comp).getBreite() * multiplicator), (int) (((parts.Barrier) comp).getHoehe() * multiplicator));
                
         
                 g.setColor(Color.black);
                 g.drawString("b: " + ((parts.Barrier) comp).getBreite() + "m", (int) (comp.getPosX() * multiplicator) + 5, (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator + ((parts.Barrier)comp).getHoehe()*multiplicator)- 6);
                 g.drawString("h: " + ((parts.Barrier) comp).getHoehe() + "m", (int) (comp.getPosX() * multiplicator) + 5, (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator + ((parts.Barrier)comp).getHoehe()*multiplicator)- 20 );
                 

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
                             g.setColor(new Color(139,141,122));
                             break;
                     }

                     g.drawLine((int) (comp.getPosX() * multiplicator) + 1, (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator) + (int) (((parts.Barrier) comp).getHoehe() * multiplicator) - (int) (((parts.Barrier) comp).getHoeheR() * multiplicator), (int) (comp.getPosX() * multiplicator) + (int) (((parts.Barrier) comp).getBreite() * multiplicator) - 1, (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator) + (int) (((parts.Barrier) comp).getHoehe() * multiplicator) - (int) (((parts.Barrier) comp).getHoeheR() * multiplicator));

                     
                    
                     g.setColor(Color.black);
                     g.drawString("b:  " + ((parts.Barrier) comp).getBreite() + "m", (int) (comp.getPosX() * multiplicator) + 5, (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator + ((parts.Barrier)comp).getHoehe()*multiplicator)- 6);
                     g.drawString("hR: " + ((parts.Barrier) comp).getHoeheR() + "m", (int) (comp.getPosX() * multiplicator) + 5, (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator + ((parts.Barrier)comp).getHoehe()*multiplicator)- 20 );
                     g.drawString("hL: " + ((parts.Barrier) comp).getHoehe() + "m", (int) (comp.getPosX() * multiplicator) + 5, (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator + ((parts.Barrier)comp).getHoehe()*multiplicator)- 34 );

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
                                g.setColor(new Color(139,141,122));
                                break;
                        }

                        g.drawLine((int) (comp.getPosX() * multiplicator) + 1, (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator) + (int) (((parts.Barrier) comp).getHoeheR() * multiplicator) - (int) (((parts.Barrier) comp).getHoeheL() * multiplicator), (int) (comp.getPosX() * multiplicator) + (int) (((parts.Barrier) comp).getBreite() * multiplicator) - 1, (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator) + (int) (((parts.Barrier) comp).getHoeheR() * multiplicator) - (int) (((parts.Barrier) comp).getHoeheL() * multiplicator));

                        g.setColor(Color.black);
                        g.drawString("b:  " + ((parts.Barrier) comp).getBreite() + "m", (int) (comp.getPosX() * multiplicator) + 5, (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator + ((parts.Barrier)comp).getHoeheR()*multiplicator)- 6);
                        g.drawString("hR: " + ((parts.Barrier) comp).getHoeheR() + "m", (int) (comp.getPosX() * multiplicator) + 5, (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator + ((parts.Barrier)comp).getHoeheR()*multiplicator)- 20 );
                        g.drawString("hL: " + ((parts.Barrier) comp).getHoehe() + "m", (int) (comp.getPosX() * multiplicator) + 5, (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator + ((parts.Barrier)comp).getHoeheR()*multiplicator)- 34 );

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
             g.drawString("b: " + ((parts.Foundation) comp).getBreite() + "m", (int) (comp.getPosX() * multiplicator) + 5, (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator + ((parts.Foundation)comp).getHoehe()*multiplicator)- 6);
             g.drawString("h: " + ((parts.Foundation) comp).getHoehe() + "m", (int) (comp.getPosX() * multiplicator) + 5, (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator + ((parts.Foundation)comp).getHoehe()*multiplicator)- 20 );
         }
         else if(comp instanceof parts.Door)
         {
            System.out.println("Door: x: "+comp.getPosX()+" y: "+comp.getPosY()+" b: "+((parts.Door)comp).getBreite()+" h: "+((parts.Door)comp).getBreite());
             g.setColor(new Color(255, 255, 102));
             g.fillRect((int)(comp.getPosX()*multiplicator), (int)(plDisplay.getHeight()-comp.getPosY()*multiplicator), (int)(((parts.Door)comp).getBreite()*multiplicator), (int)(((parts.Door)comp).getHoehe()*multiplicator));
             g.setColor(Color.black);
             g.drawRect((int)(comp.getPosX()*multiplicator), (int)(plDisplay.getHeight()-comp.getPosY()*multiplicator), (int)(((parts.Door)comp).getBreite()*multiplicator), (int)(((parts.Door)comp).getHoehe()*multiplicator));
             g.drawString("b: " + ((parts.Door) comp).getBreite() + "m", (int) (comp.getPosX() * multiplicator) + 5, (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator + ((parts.Door)comp).getHoehe()*multiplicator)- 6);
             g.drawString("h: " + ((parts.Door) comp).getHoehe() + "m", (int) (comp.getPosX() * multiplicator) + 5, (int) (plDisplay.getHeight() - comp.getPosY() * multiplicator + ((parts.Door)comp).getHoehe()*multiplicator)- 20 );
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
    
    private void redrawSelected()
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
                                g.setColor(new Color(139,141,122));
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
                                   g.setColor(new Color(139,141,122));
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
                g.setColor(Color.GREEN);
            }
        }
    }
    
    private void drawMargin()
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
    
    private void updateDisplay()
    {
        Graphics2D g2 = (Graphics2D)plDisplay.getGraphics();
        g2.drawImage(tempImage, 0, 0, plDisplay.getWidth(), plDisplay.getHeight(), null);
    }
    
    private void save()
    {
      
        db.Database database = db.Database.getInstance();
        try
        {
            database.save(currentSector, data);
            
            mode = 0;
            changes = false;
            JOptionPane.showMessageDialog(this, "Speichern erfolgreich");
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
    }
    
    private void load(int sector)
    {
        
        this.setTitle("Sektor: " + sector);
        currentSector = sector;

        db.Database database = db.Database.getInstance();
        try {

            data.clear();
            for (parts.WallComponent com : database.load(sector)) {
                data.add(com);
            }
            
            changes = false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

        redrawAll();
        
    }
    
    
    @Override
    public void repaint()
    {
        System.out.println("asd");
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
//        <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
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
            java.util.logging.Logger.getLogger(Soundbarrier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Soundbarrier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Soundbarrier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Soundbarrier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
//        </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Soundbarrier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbCreate;
    private javax.swing.JLabel lbDefect;
    private javax.swing.JLabel lbDelete;
    private javax.swing.JLabel lbDuplicate;
    private javax.swing.JLabel lbModify;
    private javax.swing.JLabel lbMove;
    private javax.swing.JLabel lbSelect;
    private javax.swing.JMenuBar mbMenue;
    private javax.swing.JMenuItem miClose;
    private javax.swing.JMenuItem miHideTools;
    private javax.swing.JMenuItem miLoad;
    private javax.swing.JMenuItem miNew;
    private javax.swing.JMenuItem miSave;
    private javax.swing.JMenuItem miShowTools;
    private javax.swing.JMenu muData;
    private javax.swing.JMenu muEdit;
    private javax.swing.JMenu muView;
    private javax.swing.JPanel plCenter;
    private javax.swing.JPanel plDisplay;
    private javax.swing.JPanel plDisplayPane;
    private javax.swing.JPanel plMenuebar;
    private javax.swing.JPanel plNorth;
    private javax.swing.JPanel plSouth;
    private javax.swing.JPanel plToolbox;
    private javax.swing.JScrollPane spScrollPane;
    // End of variables declaration//GEN-END:variables
}
