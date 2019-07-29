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
public class Defect extends WallComponent
{ 
    private String comment;
    private int radius;
    
    /**
     * Konstruktor der Klasse Defect
     * @param posX X-Koordinate der Beschädigung
     * @param posY Y-Koordinate der Beschädigung
     * @param r Radius des Kreises
     */
    public Defect(double posX, double posY, int r)
    {
        super(posX, posY);
        this.radius = r;
    }

    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public int getRadius()
    {
        return radius;
    }

    public void setRadius(int radius)
    {
        this.radius = radius;
    }
    
    
    
}
