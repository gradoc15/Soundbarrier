/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import data.Material;

/**
 *
 * @author User
 */
public class Database {
    private static Database instance; 
    private Connection con;
    
    /**
     * Kunstruktor der Database klasse
     */
    private Database()
    {
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost/soundbarrier", "postgres", "postgres");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Methode zum Speichern von Daten
     * @param sector gibt den Sektor an, zu welchem die Daten gehören
     * @param data sind die zuspeichernden Daten
     * @throws SQLException 
     */ 
    public void save(int sector, LinkedList<parts.WallComponent> data) throws SQLException
    {
        Statement st = con.createStatement();
        PreparedStatement actorInsertStmt;
        String actionInsert;
        actionInsert = "SELECT COUNT(sectorid) FROM sector WHERE SectorID="+sector+";";
        actorInsertStmt = con.prepareStatement(actionInsert);
        ResultSet rs = actorInsertStmt.executeQuery();
        rs.next();
        
        if(rs.getInt("count") == 0)
            st.executeUpdate("INSERT INTO sector VALUES("+sector+");");
        
        //Beginn save Methods of all objects
        saveBarriers(sector, data);
        saveFoundations(sector, data);
        saveDoors(sector, data);
        saveDefects(sector, data);
    }
    
    private void saveBarriers(int sector, LinkedList<parts.WallComponent> data) throws SQLException
    {
        Statement st = con.createStatement();
        PreparedStatement actorInsertStmt;
        String actionInsert;
        
        int nextID = 0;
        
        //Remove old data
        st.executeUpdate("DELETE FROM barrier WHERE SectorID="+sector+";");
        
        //Searching next index
        actionInsert = "SELECT MAX(BarrierID) FROM barrier;";
        actorInsertStmt = con.prepareStatement(actionInsert);
        ResultSet rs = actorInsertStmt.executeQuery();
        rs.next();
        nextID = rs.getInt("max")+1;
        
        //saving to db
        for(parts.WallComponent comp: data)
        {
            if(comp instanceof parts.Barrier)
            {
                st.executeUpdate("INSERT INTO barrier VALUES("+nextID+", "+sector+", "+comp.getPosX()+", "+comp.getPosY()+", "+((parts.Barrier)comp).getHoeheL()+", "+((parts.Barrier)comp).getHoeheR()+", "+((parts.Barrier)comp).getBreite()+", '"+((parts.Barrier)comp).getMat()+"');");
                nextID++;
            }
        }
    }
    
    private void saveFoundations(int sector, LinkedList<parts.WallComponent> data) throws SQLException
    {
        Statement st = con.createStatement();
        PreparedStatement actorInsertStmt;
        String actionInsert;
        
        int nextID = 0;
        
        //Remove old data
        st.executeUpdate("DELETE FROM foundation WHERE SectorID="+sector+";");
        
        //Searching next index
        actionInsert = "SELECT MAX(FoundationID) FROM foundation;";
        actorInsertStmt = con.prepareStatement(actionInsert);
        ResultSet rs = actorInsertStmt.executeQuery();
        rs.next();
        nextID = rs.getInt("max")+1;
        
        //saving to db
        for(parts.WallComponent comp: data)
        {
            if(comp instanceof parts.Foundation)
            {
                st.executeUpdate("INSERT INTO foundation VALUES("+nextID+", "+sector+", "+comp.getPosX()+", "+comp.getPosY()+", "+((parts.Foundation)comp).getHoehe()+", "+((parts.Foundation)comp).getBreite()+");");
                nextID++;
            }
        }
    }
    
    private void saveDoors(int sector, LinkedList<parts.WallComponent> data) throws SQLException
    {
        Statement st = con.createStatement();
        PreparedStatement actorInsertStmt;
        String actionInsert;
        
        int nextID = 0;
        
        //Remove old data
        st.executeUpdate("DELETE FROM door WHERE SectorID="+sector+";");
        
        //Searching next index
        actionInsert = "SELECT MAX(DoorID) FROM door;";
        actorInsertStmt = con.prepareStatement(actionInsert);
        ResultSet rs = actorInsertStmt.executeQuery();
        rs.next();
        nextID = rs.getInt("max")+1;
        
        //saving to db
        for(parts.WallComponent comp: data)
        {
            if(comp instanceof parts.Door)
            {
                st.executeUpdate("INSERT INTO door VALUES("+nextID+", "+sector+", "+comp.getPosX()+", "+comp.getPosY()+", "+((parts.Door)comp).getHoehe()+", "+((parts.Door)comp).getBreite()+");");
                nextID++;
            }
        }
    }
    
    private void saveDefects(int sector, LinkedList<parts.WallComponent> data) throws SQLException
    {
        Statement st = con.createStatement();
        PreparedStatement actorInsertStmt;
        String actionInsert;
        
        int nextID = 0;
        
        //Remove old data
        st.executeUpdate("DELETE FROM defect WHERE SectorID="+sector+";");
        
        //Searching next index
        actionInsert = "SELECT MAX(DefectID) FROM defect;";
        actorInsertStmt = con.prepareStatement(actionInsert);
        ResultSet rs = actorInsertStmt.executeQuery();
        rs.next();
        nextID = rs.getInt("max")+1;
        
        //saving to db
        for(parts.WallComponent comp: data)
        {
            if(comp instanceof parts.Defect)
            {
                st.executeUpdate("INSERT INTO defect VALUES("+nextID+", "+sector+", "+comp.getPosX()+", "+comp.getPosY()+", "+((parts.Defect)comp).getRadius()+");");
                nextID++;
            }
        }
    }
    
    /**
     * Ladet die Daten des angeben Sektors und gibt diese zurück
     * @param sector der Sektor von welchem die Daten geladen werden sollen
     * @return die aus dem Sektor geladenen Daten
     * @throws SQLException 
     */
    public LinkedList<parts.WallComponent> load(int sector) throws SQLException
    { 
        LinkedList<parts.WallComponent> data = new LinkedList<>();
        
        loadBarriers(sector, data);
        loadFoundations(sector, data);
        loadDoors(sector, data);
        loadDefects(sector, data);
         
        return data;
    }
    
    private void loadBarriers(int sector, LinkedList data) throws SQLException
    {
        PreparedStatement actorInsertStmt;
        String actionInsert;
        actionInsert = "SELECT * FROM barrier WHERE SectorID="+sector+";";
        actorInsertStmt = con.prepareStatement(actionInsert);
        ResultSet rs = actorInsertStmt.executeQuery();
        
        parts.Barrier bar;
        while(rs.next())
        {
            data.Material mat = null;
            
            switch(rs.getString("material"))
            {
                case "HOLZ": mat = Material.HOLZ; break;
                case "METALL": mat = Material.METALL; break;
                case "STEIN": mat = Material.KUNSTSTOFF; break;
                case "KUNSTSTOFF": mat = Material.KUNSTSTOFF; break;
            }
            bar = new parts.Barrier(rs.getDouble("PosX"), rs.getDouble("PosY"), rs.getDouble("breite"), rs.getDouble("hoehel"), rs.getDouble("hoeher"),mat);
            data.add(bar);
        }
        
    }
    
    private void loadFoundations(int sector, LinkedList data) throws SQLException
    {
        PreparedStatement actorInsertStmt;
        String actionInsert;
        actionInsert = "SELECT * FROM foundation WHERE SectorID="+sector+";";
        actorInsertStmt = con.prepareStatement(actionInsert);
        ResultSet rs = actorInsertStmt.executeQuery();
        
        while(rs.next())
            data.add(new parts.Foundation(rs.getDouble("PosX"), rs.getDouble("PosY"), rs.getDouble("breite"), rs.getDouble("hoehe")));
        
    }
    
    private void loadDoors(int sector, LinkedList data) throws SQLException
    {
        PreparedStatement actorInsertStmt;
        String actionInsert;
        actionInsert = "SELECT * FROM door WHERE SectorID="+sector+";";
        actorInsertStmt = con.prepareStatement(actionInsert);
        ResultSet rs = actorInsertStmt.executeQuery();
        
        while(rs.next())
            data.add(new parts.Door(rs.getDouble("PosX"), rs.getDouble("PosY"), rs.getDouble("breite"), rs.getDouble("hoehe")));
    }
    
    private void loadDefects(int sector, LinkedList data) throws SQLException
    {
        PreparedStatement actorInsertStmt;
        String actionInsert;
        actionInsert = "SELECT * FROM defect WHERE SectorID="+sector+";";
        actorInsertStmt = con.prepareStatement(actionInsert);
        ResultSet rs = actorInsertStmt.executeQuery();

        parts.Defect def;
        while(rs.next())
        {
            def = new parts.Defect(rs.getInt("PosX"), rs.getInt("PosY"), rs.getInt("radius"));
            def.setComment(rs.getString("com"));
            data.add(def);
        }
    }
    
    /**
     * Getter für die Instanz dieser Klasse
     * @return Instanz dieser Klasse
     */
    public static Database getInstance()
    {
        if(Database.instance == null)
            Database.instance = new Database();
        
        return instance;
    }
}
