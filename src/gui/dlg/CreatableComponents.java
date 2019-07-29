/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author User
 */
public enum Components 
{
    BARRIER("Lärmschutzwand"),
    FOUNDATION("Fundament"),
    DOOR("Tür"),
    BARRIER_AND_FOUNDATION("Lärmschutzwand + Fundament"),
    BARRIER_AND_DOOR("Lärmschutzwand + Tür"),
    FOUNDATION_AND_DOOR("Fundament + Tür"),
    BARRIER_AND_FOUNDATION_AND_DOOR("Lärmschutzwand + Fundament + Tür");
    
    private String description;
    private Components(String description)
    {
        this.description = description;
    }
    
    public String toString()
    {
        return description;
    }
}
