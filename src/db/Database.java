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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import data.Material;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

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
            con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1/soundbarrier", "postgres", "postgres");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void importFile(File csvdat) throws FileNotFoundException, IOException, IllegalStateException, SQLException
    {
        try(BufferedReader br = new BufferedReader(new FileReader(csvdat)))
        {
            String line = br.readLine();
            while((line=br.readLine())!=null)
            {
                String[] parts = line.split("¥");
                if(rightCSV(parts))
                {
                    boolean überwachung = (parts[13].equalsIgnoreCase("Ja")) ;
                    boolean ortsgebiet = (parts[40].equalsIgnoreCase("Ja"));
                    boolean nachträglich = (parts[58].equalsIgnoreCase("Ja"));
                    boolean auskragung = (parts[60].equalsIgnoreCase("Ja"));
                    boolean bänder = (parts[68].equalsIgnoreCase("Ja"));
                    boolean untb = (parts[84].equalsIgnoreCase("Ja"));
                    boolean kons = (parts[85].equalsIgnoreCase("Ja"));
                    boolean ausr = (parts[86].equalsIgnoreCase("Ja"));
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
                    DateTimeFormatter datetimeformat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate datum = LocalDate.of(1, Month.JANUARY, 1);
                    LocalDate pdatum = LocalDate.of(1, Month.JANUARY, 1);
                    LocalDate kdatum = LocalDate.of(1, Month.JANUARY, 1);
                    
                    if(!parts[21].isEmpty()) 
                    {
                        parts[21]=parts[21].replace(".","");
                        parts[21]=parts[21].replace(",",".");
                    }
                    else parts[21] = "0.0";
                    if(!parts[22].isEmpty()) 
                    {
                        parts[22]=parts[22].replace(".","");
                        parts[22]=parts[22].replace(",",".");
                    }
                    else parts[22] = "0.0";
                    if(!parts[26].isEmpty()) 
                    {
                        parts[26]=parts[26].replace(".","");
                        parts[26]=parts[26].replace(",",".");
                    }
                    else parts[26] = "0.0";
                    if(!parts[31].isEmpty()) 
                    {
                        parts[31]=parts[31].replace(".","");
                        parts[31]=parts[31].replace(",",".");
                    }
                    else parts[31] = "0.0";
                    if(!parts[32].isEmpty()) 
                    {
                        parts[32]=parts[32].replace(".","");
                        parts[32]=parts[32].replace(",",".");
                    }
                    else parts[32] = "0.0";
                    if(!parts[33].isEmpty()) 
                    {
                        parts[33]=parts[33].replace(".","");
                        parts[33]=parts[33].replace(",",".");
                    }
                    else parts[33] = "0.0";
                    if(!parts[34].isEmpty()) 
                    {
                        parts[34]=parts[34].replace(".","");
                        parts[34]=parts[34].replace(",",".");
                    }
                    else parts[34] = "0.0";
                    if(!parts[35].isEmpty()) 
                    {
                        parts[35]=parts[35].replace(".","");
                        parts[35]=parts[35].replace(",",".");
                    }
                    else parts[35] = "0.0";
                    if(!parts[36].isEmpty()) 
                    {
                        parts[36]=parts[36].replace(".","");
                        parts[36]=parts[36].replace(",",".");
                    }
                    else parts[36] = "0.0";
                    if(!parts[37].isEmpty()) 
                    {
                        parts[37]=parts[37].replace(".","");
                        parts[37]=parts[37].replace(",",".");
                    }
                    else parts[37] = "0.0";
                    if(!parts[38].isEmpty()) 
                    {
                        parts[38]=parts[38].replace(".","");
                        parts[38]=parts[38].replace(",",".");
                    }
                    else parts[38] = "0.0";
                    if(!parts[39].isEmpty()) 
                    {
                        parts[39]=parts[39].replace(".","");
                        parts[39]=parts[39].replace(",",".");
                    }
                    else parts[39] = "0.0";
                    if(!parts[50].isEmpty()) 
                    {
                        parts[50]=parts[50].replace(".","");
                        parts[50]=parts[50].replace(",",".");
                    }
                    else parts[50] = "0.0";
                    if(!parts[51].isEmpty()) 
                    {
                        parts[51]=parts[51].replace(".","");
                        parts[51]=parts[51].replace(",",".");
                    }
                    else parts[51] = "0.0";
                    if(!parts[57].isEmpty()) 
                    {
                        parts[57]=parts[57].replace(".","");
                        parts[57]=parts[57].replace(",",".");
                    }
                    else parts[57] = "0.0";
                    if(!parts[59].isEmpty()) 
                    {
                        parts[59]=parts[59].replace(".","");
                        parts[59]=parts[59].replace(",",".");
                    }
                    else parts[59] = "0.0";
                    if(!parts[61].isEmpty()) 
                    {
                        parts[61]=parts[61].replace(".","");
                        parts[61]=parts[61].replace(",",".");
                    }
                    else parts[61] = "0.0";
                    if(!parts[62].isEmpty()) 
                    {
                        parts[62]=parts[62].replace(".","");
                        parts[62]=parts[62].replace(",",".");
                    }
                    else parts[62] = "0.0";
                    
                    if(parts[29].isEmpty())
                    {
                        parts[29]="0";
                    }
                    if(parts[41].isEmpty())
                    {
                        parts[41]="0";
                    }
                    if(parts[45].isEmpty())
                    {
                        parts[45]="0";
                    }
                    if(parts[46].isEmpty())
                    {
                        parts[46]="0";
                    }
                    if(parts[47].isEmpty())
                    {
                        parts[47]="0";
                    }
                    if(parts[48].isEmpty())
                    {
                        parts[48]="0";
                    }
                    if(parts[67].isEmpty())
                    {
                        parts[67]="0";
                    }
                    if(parts[72].isEmpty())
                    {
                        parts[72]="0";
                    }
                    if(parts[78].isEmpty())
                    {
                        parts[78]="0";
                    }
                    
                    Statement stat = con.createStatement();
                    String sql = "SELECT *"
                                +"FROM barrier_import "
                                +"WHERE objid='"+parts[0]+"';";
                    ResultSet rs = stat.executeQuery(sql);
                    if(rs.next())
                    {
                        System.out.println("Update");
                        
                        stat.executeUpdate("UPDATE barrier_import "
                                         + "SET Klasse='"+parts[1]+"',"
                                         + "    Konstruktion = '"+parts[2]+"',"
                                         + "    ObjNummer = '"+Integer.parseInt(parts[3])+"',"
                                         + "    ObjName = '"+parts[4]+"',"
                                         + "    Status = '"+parts[5]+"',"
                                         + "    Mandant = '"+parts[6]+"',"
                                         + "    Verwalter = '"+parts[7]+"',"
                                         + "    BaulicheErhaltung = '"+parts[8]+"',"
                                         + "    BetrieblicheErhaltung = '"+parts[9]+"',"
                                         + "    Prüfverpflichtung = '"+parts[10]+"',"
                                         + "    Kontrollverpflichtung = '"+parts[11]+"',"
                                         + "    Sondernutzung = '"+parts[12]+"',"
                                         + "    LaufendeÜberwachungAngehakt = '"+ überwachung+"',"
                                         + "    LaufendeÜberwachung = '"+parts[14]+"',"
                                         + "    StandortA = '"+parts[15]+"',"
                                         + "    StandortB = '"+parts[16]+"',"
                                         + "    Prefix = '"+parts[17]+"',"
                                         + "    ÜS = '"+parts[18]+"',"
                                         + "    HauptverkehrslinieNR = '"+parts[19]+"',"
                                         + "    HauptverkehrslinieNA = '"+parts[20]+"',"
                                         + "    KmVonBei = '"+Double.parseDouble(parts[21])+"',"
                                         + "    KmBis = '"+Double.parseDouble(parts[22])+"',"
                                         + "    Funktion = '"+parts[23]+"',"
                                         + "    Position = '"+parts[24]+"',"
                                         + "    Fahrbahnanlage = '"+parts[25]+"',"
                                         + "    SeitlicherAbstand = '"+Double.parseDouble(parts[26])+"',"
                                         + "    Anmerkung = '"+parts[27]+"',"
                                         + "    weitereVerkehrslinien = '"+parts[28]+"',"
                                         + "    BJ = '"+Integer.parseInt(parts[29])+"',"
                                         + "    KoordinatenMeridian = '"+parts[30]+"',"
                                         + "    AnfangRechtswert = '"+Double.parseDouble(parts[31])+"',"
                                         + "    AnfangNordwert = '"+Double.parseDouble(parts[32])+"',"
                                         + "    AnfangHöhe = '"+Double.parseDouble(parts[33])+"',"
                                         + "    KreuzungspunktRechtswert = '"+Double.parseDouble(parts[34])+"',"
                                         + "    KreuzungspunktNordwert = '"+Double.parseDouble(parts[35])+"',"
                                         + "    KreuzungspunktHöhe = '"+Double.parseDouble(parts[36])+"',"
                                         + "    EndpunktRechtswert = '"+Double.parseDouble(parts[37])+"',"
                                         + "    EndpunktNordwert = '"+Double.parseDouble(parts[38])+"',"
                                         + "    EndpunktHöhe = '"+Double.parseDouble(parts[39])+"',"
                                         + "    Ortsgebiet = '"+ortsgebiet+"',"
                                         + "    GISWert = '"+Integer.parseInt(parts[41])+"',"
                                         + "    Einbauten = '"+parts[42]+"',"
                                         + "    System = '"+parts[43]+"',"
                                         + "    Norm = '"+parts[44]+"',"
                                         + "    DTV = '"+Integer.parseInt(parts[45])+"',"
                                         + "    DTLV = '"+Integer.parseInt(parts[46])+"',"
                                         + "    DLR = '"+Integer.parseInt(parts[47])+"',"
                                         + "    DL = '"+Integer.parseInt(parts[48])+"',"
                                         + "    Systemanmerkung = '"+parts[49]+"',"
                                         + "    LH = '"+Double.parseDouble(parts[50])+"',"
                                         + "    FFBreite = '"+Double.parseDouble(parts[51])+"',"
                                         + "    UnterbauGründung = '"+parts[52]+"',"
                                         + "    UnterbauAnmerkung = '"+parts[53]+"',"
                                         + "    UnterbauDammAbmessungen = '"+parts[54]+"',"
                                         + "    KonstruktionWirkungsweise = '"+parts[55]+"',"
                                         + "    KonstruktionBefestigung = '"+parts[56]+"',"
                                         + "    KonstruktionAnsichtsflaeche = '"+parts[57]+"',"
                                         + "    KonstruktionNachträglicheErhöhung = '"+nachträglich+"',"
                                         + "    KonstruktionHMAX = '"+Double.parseDouble(parts[59])+"',"
                                         + "    KonstruktionAuskragung = '"+auskragung+"',"
                                         + "    KonstruktionGesamtlaengeAuskragung = '"+Double.parseDouble(parts[61])+"',"
                                         + "    KonstruktionMaximaleAuskragung = '"+Double.parseDouble(parts[62])+"',"
                                         + "    KonstruktionAnmerkung = '"+parts[63]+"',"
                                         + "    KonstruktionMaterial = '"+parts[64]+"',"
                                         + "    KonstruktionAbmessung = '"+parts[65]+"',"
                                         + "    KonstruktionAbmessungLängensumme = '"+parts[66]+"',"
                                         + "    AusruestungAnzahlTüren = '"+Integer.parseInt(parts[67])+"',"
                                         + "    AusruestungZugbänder = '"+bänder+"',"
                                         + "    AusruestungAnmerkung = '"+parts[69]+"',"
                                         + "    LastEditUser = '"+parts[70]+"',"
                                         + "    LastEditTimeStamp = '"+datum+"',"
                                         + "    PPID = '"+Integer.parseInt(parts[72])+"',"
                                         + "    PDatum = '"+pdatum+"',"
                                         + "    PNote = '"+parts[74]+"',"
                                         + "    PName = '"+parts[75]+"',"
                                         + "    PNext = '"+parts[76]+"',"
                                         + "    PErgänzendeUntersuchung = '"+parts[77]+"',"
                                         + "    KPID = '"+Integer.parseInt(parts[78])+"',"
                                         + "    KDatum = '"+kdatum+"',"
                                         + "    KNote = '"+parts[80]+"',"
                                         + "    KName = '"+parts[81]+"',"
                                         + "    KNext = '"+parts[82]+"',"
                                         + "    KErgänzendeUntersuchung = '"+parts[83]+"',"
                                         + "    UNTB = '"+untb+"',"
                                         + "    KONS = '"+kons+"',"
                                         + "    AUSR = '"+ausr+"';");
                    }
                    else
                    {
                        System.out.println("Insert");
                        if(!parts[71].isEmpty())
                        {
                            String[] help = parts[71].split(" ");
                            if(help.length>1)
                            {
                                String test = help[help.length-1];
                                test = test.replace(".", ",");
                                if(test.contains(","))
                                { 
                                    String[] help2 = test.split(",");
                                    if(help2.length>1)
                                    {
                                        String toparse = help[0]+" "+help2[0];
                                        datum = LocalDate.parse(toparse,dtf);
                                    }
                                }
                            }
                        }
                        if(!parts[73].isEmpty())
                        {
                            pdatum = LocalDate.parse(parts[73],datetimeformat);
                        }
                        if(!parts[79].isEmpty())
                        {
                            kdatum = LocalDate.parse(parts[79], datetimeformat);
                        }
                        
                        stat.executeUpdate("INSERT INTO barrier_import"
                                         + "(ObjID, Klasse, Konstruktion, ObjNummer, ObjName, "
                                         + "Status, Mandant, Verwalter, BaulicheErhaltung, BetrieblicheErhaltung, "
                                         + "Prüfverpflichtung, Kontrollverpflichtung, Sondernutzung, LaufendeÜberwachungAngehakt, LaufendeÜberwachung, "
                                         + "StandortA, StandortB, Prefix, ÜS, HauptverkehrslinieNR, "
                                         + "HauptverkehrslinieNA, KmVonBei, KmBis, Funktion, Position, "
                                         + "Fahrbahnanlage, SeitlicherAbstand, Anmerkung, weitereVerkehrslinien, BJ, "
                                         + "KoordinatenMeridian, AnfangRechtswert, AnfangNordwert, Anfanghöhe, KreuzungspunktRechtswert, "
                                         + "KreuzungspunktNordwert, KreuzungspunktHöhe, EndpunktRechtswert, EndpunktNordwert, Endpunkthöhe, "
                                         + "Ortsgebiet, GISWert, Einbauten, System, Norm, "
                                         + "DTV, DTLV, DLR, DL, SystemAnmerkung, "
                                         + "LH, FFBreite, Unterbaugründung, UnterbauAnmerkung, UnterbauDammabmessungen, "
                                         + "KonstruktionWirkungsweise, KonstruktionBefestigung, KonstruktionAnsichtsflaeche, KonstruktionNachträglicheErhöhung, KonstruktionHMax, "
                                         + "KonstruktionAuskragung, KonstruktionGesamtlaengeAuskragung, KonstruktionMaximaleAuskragung, KonstruktionAnmerkung, KonstruktionMaterial, "
                                         + "KonstruktionAbmessung, KonstruktionAbmessungLängensumme, AusruestungAnzahlTüren, AusruestungZugbänder, AusruestungAnmerkung, "
                                         + "LastEditUser, LastEditTimeStamp, PPID, PDatum, PNote, "
                                         + "PName, PNext, PErgänzendeUntersuchung, KPID, KDatum, "
                                         + "KNote, KName, KNext, KErgänzendeUntersuchung, UNTB, "
                                         + "KONS, AUSR)"
                                         + "VALUES"
                                         + "('"+parts[0]+"','"+parts[1]+"','"+parts[2]+"','"+Integer.parseInt(parts[3])+"','"+parts[4] 
                                         + "','"+parts[5]+"','"+parts[6]+"','"+parts[7]+"','"+parts[8]+"','"+parts[9]
                                         + "','"+parts[10]+"','"+parts[11]+"','"+parts[12]+"',"+überwachung+",'"+parts[14]
                                         + "','"+parts[15]+"','"+parts[16]+"','"+parts[17]+"','"+parts[18]+"','"+parts[19]
                                         + "','"+parts[20]+"','"+Double.parseDouble(parts[21])+"','"+Double.parseDouble(parts[22])+"','"+parts[23]+"','"+parts[24]
                                         + "','"+parts[25]+"','"+Double.parseDouble(parts[26])+"','"+parts[27]+"','"+parts[28]+"','"+Integer.parseInt(parts[29])
                                         + "','"+parts[30]+"','"+Double.parseDouble(parts[31])+"','"+Double.parseDouble(parts[32])+"','"+Double.parseDouble(parts[33])+"','"+Double.parseDouble(parts[34])
                                         + "','"+Double.parseDouble(parts[35])+"','"+Double.parseDouble(parts[36])+"','"+Double.parseDouble(parts[37])+"','"+Double.parseDouble(parts[38])+"','"+Double.parseDouble(parts[39])
                                         + "','"+ortsgebiet+"','"+Integer.parseInt(parts[41])+"','"+parts[42]+"','"+parts[43]+"','"+parts[44]
                                         + "','"+Integer.parseInt(parts[45])+"','"+Integer.parseInt(parts[46])+"','"+Integer.parseInt(parts[47])+"','"+Integer.parseInt(parts[48])+"','"+parts[49]
                                         + "','"+Double.parseDouble(parts[50])+"','"+Double.parseDouble(parts[51])+"','"+parts[52]+"','"+parts[53]+"','"+parts[54]
                                         + "','"+parts[55]+"','"+parts[56]+"','"+Double.parseDouble(parts[57])+"','"+nachträglich+"','"+Double.parseDouble(parts[59])
                                         + "','"+auskragung+"','"+Double.parseDouble(parts[61])+"','"+Double.parseDouble(parts[62])+"','"+parts[63]+"','"+parts[64]
                                         + "','"+parts[65]+"','"+parts[66]+"','"+Integer.parseInt(parts[67])+"','"+bänder+"','"+parts[69]
                                         + "','"+parts[70]+"','"+datum+"','"+Integer.parseInt(parts[72])+"','"+pdatum+"','"+parts[74]
                                         + "','"+parts[75]+"','"+parts[76]+"','"+parts[77]+"','"+Integer.parseInt(parts[78])+"','"+kdatum
                                         + "','"+parts[80]+"','"+parts[81]+"','"+parts[82]+"','"+parts[83]+"','"+untb
                                         + "','"+kons+"','"+ausr+"');");
                    }
                }
            }
        }catch(IllegalStateException istex){
            throw istex;
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    private boolean rightCSV(String[] parts)
    {
        boolean right = false;
        
        if(parts.length!=87)
        {
            throw new IllegalStateException("Ungültige CSV Datei ausgewählt.");
        }
        else
        {
            right=true;
        }
        
        return right;
    }
    
    /**
     * Methode zum Speichern von Daten
     * @param sector gibt den Sektor an, zu welchem die Daten gehören
     * @param data sind die zuspeichernden Daten
     * @throws SQLException 
     */ 
    public void save(int sector, ArrayList<parts.WallComponent> data) throws SQLException
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
    
    private void saveBarriers(int sector, ArrayList<parts.WallComponent> data) throws SQLException
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
    
    private void saveFoundations(int sector, ArrayList<parts.WallComponent> data) throws SQLException
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
    
    private void saveDoors(int sector, ArrayList<parts.WallComponent> data) throws SQLException
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
    
    private void saveDefects(int sector, ArrayList<parts.WallComponent> data) throws SQLException
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
