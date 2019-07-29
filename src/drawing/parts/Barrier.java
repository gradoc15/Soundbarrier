/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parts;

import data.Material;

/**
 *
 * @author User
 */
public class Barrier extends Rect
{
    private double hoeheR;
    
    private Material mat;

    public Barrier(double posX, double posY, double breite, double hoehe, Material mat) {
        super(posX, posY, breite, hoehe);
        this.hoeheR = hoeheR;
        this.mat = mat;
    }
    
    public Barrier(double posX, double posY, double breite, double hoehe, double hoeheR, Material mat) {
        super(posX, posY, breite, hoehe);
        this.mat = mat;
        this.hoeheR = hoeheR;
    }

    public double getHoeheR() {
        return hoeheR;
    }

    public void setHoeheR(double hoeheR) {
        this.hoeheR = hoeheR;
    }

    public Material getMat() {
        return mat;
    }

    public void setMat(Material mat) {
        this.mat = mat;
    }
    
    public double getHoeheL()
    {
        return super.getHoehe();
    }
    
    public void setHoeheL(double h)
    {
        super.setHoehe(h);
    }
    
    
    
    
    
    

    /**
     * Konstruktor der Klasse Barrier
     * @param posX die X-Koordinate der Barriere
     * @param posY die Y-Koordinate der Barriere
     * @param hoehe die hoehe der Barriere
     * @param breite  die breite der Barriere
     */

    
    
    
    
    
    
    
    
    
}
