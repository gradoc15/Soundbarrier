/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parts;

/**
 *
 * @author User
 */
public abstract class WallComponent
{
    protected double posX;
    protected double posY;

    /**
     * Konstruktur der abstrakten klasse WallComponent
     * @param posX X-Koordinate der Komponente
     * @param posY Y-Koordinate der Komponente
     */
    public WallComponent(double posX, double posY)
    {
        this.posX = posX;
        this.posY = posY;
    }

    public double getPosX()
    {
        return posX;
    }

    public void setPosX(double posX)
    {
        this.posX = posX;
    }

    public double getPosY()
    {
        return posY;
    }

    public void setPosY(double posY)
    {
        this.posY = posY;
    }
    
    
    
 
}
