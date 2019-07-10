/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import Builder.BarrierBuilderImpl;
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
import gui.BarrierTable;
import guiNew.Soundbarrier;
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
import parts.BarrierImport;

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
    
    /**
     * Methode zum importieren der Lärmschutzwände
     * @param csvdat CSV File aus der die Werte ausgelesen werden.
     * @throws FileNotFoundException
     * @throws IOException
     * @throws IllegalStateException wirt geworfen, sollte eine ungültige CSV Datein eingelesen worden sein
     * @throws SQLException 
     */
    
    public void importFile(File csvdat) throws FileNotFoundException, IOException, IllegalStateException, SQLException
    {
        BarrierTable table = BarrierTable.getInstance();
        BarrierImport imp = new BarrierImport();
        int anzElemUpdated = 0;
        int anzElemInserted= 0;
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
                    boolean konsthmax = (parts[58].equalsIgnoreCase("Ja"));
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
                    DateTimeFormatter datetimeformat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDateTime datum = null;//LocalDate.of(1, Month.JANUARY, 1);
                    LocalDate pdatum = null;//LocalDate.of(1, Month.JANUARY, 1);
                    LocalDate kdatum = null;//LocalDate.of(1, Month.JANUARY, 1);
                    String date="TO_DATE(NULL,'DD.MM.YYYY')";
                    String pdate="TO_DATE(NULL,'YYYY.MM.DD')";
                    String kdate="TO_DATE(NULL,'YYYY.MM.DD')";
                    
                    if(!parts[21].isEmpty()) 
                    {
                        parts[21]=parts[21].replace(".","");
                        parts[21]=parts[21].replace(",",".");
                    }
                    else parts[21] = "NULL";
                    if(!parts[22].isEmpty()) 
                    {
                        parts[22]=parts[22].replace(".","");
                        parts[22]=parts[22].replace(",",".");
                    }
                    else parts[22] = "NULL";
                    if(!parts[26].isEmpty()) 
                    {
                        parts[26]=parts[26].replace(".","");
                        parts[26]=parts[26].replace(",",".");
                    }
                    else parts[26] = "NULL";
                    if(!parts[31].isEmpty()) 
                    {
                        parts[31]=parts[31].replace(".","");
                        parts[31]=parts[31].replace(",",".");
                    }
                    else parts[31] = "NULL";
                    if(!parts[32].isEmpty()) 
                    {
                        parts[32]=parts[32].replace(".","");
                        parts[32]=parts[32].replace(",",".");
                    }
                    else parts[32] = "NULL";
                    if(!parts[33].isEmpty()) 
                    {
                        parts[33]=parts[33].replace(".","");
                        parts[33]=parts[33].replace(",",".");
                    }
                    else parts[33] = "NULL";
                    if(!parts[34].isEmpty()) 
                    {
                        parts[34]=parts[34].replace(".","");
                        parts[34]=parts[34].replace(",",".");
                    }
                    else parts[34] = "NULL";
                    if(!parts[35].isEmpty()) 
                    {
                        parts[35]=parts[35].replace(".","");
                        parts[35]=parts[35].replace(",",".");
                    }
                    else parts[35] = "NULL";
                    if(!parts[36].isEmpty()) 
                    {
                        parts[36]=parts[36].replace(".","");
                        parts[36]=parts[36].replace(",",".");
                    }
                    else parts[36] = "NULL";
                    if(!parts[37].isEmpty()) 
                    {
                        parts[37]=parts[37].replace(".","");
                        parts[37]=parts[37].replace(",",".");
                    }
                    else parts[37] = "NULL";
                    if(!parts[38].isEmpty()) 
                    {
                        parts[38]=parts[38].replace(".","");
                        parts[38]=parts[38].replace(",",".");
                    }
                    else parts[38] = "NULL";
                    if(!parts[39].isEmpty()) 
                    {
                        parts[39]=parts[39].replace(".","");
                        parts[39]=parts[39].replace(",",".");
                    }
                    else parts[39] = "NULL";
                    if(!parts[50].isEmpty()) 
                    {
                        parts[50]=parts[50].replace(".","");
                        parts[50]=parts[50].replace(",",".");
                    }
                    else parts[50] = "NULL";
                    if(!parts[51].isEmpty()) 
                    {
                        parts[51]=parts[51].replace(".","");
                        parts[51]=parts[51].replace(",",".");
                    }
                    else parts[51] = "NULL";
                    if(!parts[57].isEmpty()) 
                    {
                        parts[57]=parts[57].replace(".","");
                        parts[57]=parts[57].replace(",",".");
                    }
                    else parts[57] = "NULL";
                    if(!parts[59].isEmpty()) 
                    {
                        parts[59]=parts[59].replace(".","");
                        parts[59]=parts[59].replace(",",".");
                    }
                    else parts[59] = "NULL";
                    if(!parts[61].isEmpty()) 
                    {
                        parts[61]=parts[61].replace(".","");
                        parts[61]=parts[61].replace(",",".");
                    }
                    else parts[61] = "NULL";
                    if(!parts[62].isEmpty()) 
                    {
                        parts[62]=parts[62].replace(".","");
                        parts[62]=parts[62].replace(",",".");
                    }
                    else parts[62] = "NULL";
                    
                    if(parts[29].isEmpty())
                    {
                        parts[29]="NULL";
                    }
                    if(parts[41].isEmpty())
                    {
                        parts[41]="NULL";
                    }
                    if(parts[45].isEmpty())
                    {
                        parts[45]="NULL";
                    }
                    if(parts[46].isEmpty())
                    {
                        parts[46]="NULL";
                    }
                    if(parts[47].isEmpty())
                    {
                        parts[47]="NULL";
                    }
                    if(parts[48].isEmpty())
                    {
                        parts[48]="NULL";
                    }
                    if(parts[67].isEmpty())
                    {
                        parts[67]="NULL";
                    }
                    if(parts[72].isEmpty())
                    {
                        parts[72]="NULL";
                    }
                    if(parts[78].isEmpty())
                    {
                        parts[78]="NULL";
                    }
                    
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
                                    datum = LocalDateTime.parse(toparse,dtf);
                                    date = "to_TIMESTAMP('";
                                    if(datum.getDayOfMonth()<10)
                                    {
                                        date+="0";
                                    }
                                    date+=datum.getDayOfMonth()+".";
                                    if(datum.getMonthValue()<10)
                                    {
                                        date+="0";
                                    }
                                    date+=datum.getMonthValue()+"."+datum.getYear()+" ";
                                    
                                    if(datum.getHour()<10)
                                    {
                                        date+="0";
                                    }
                                    date+=datum.getHour()+":";
                                    if(datum.getMinute()<10)
                                    {
                                        date+="0";
                                    }
                                    date+=datum.getMinute()+":";
                                    if(datum.getSecond()<10)
                                    {
                                        date+="0";
                                    }
                                    date+=datum.getSecond()+"'"+",'DD.MM.YYYY HH24:MI:SS')";
                                    
                                    //String s = "to_Date("+datum.getDayOfMonth()+"."+datum.getMonthValue()+"."+datum.getYear()+" "+datum.getHour()+":"+datum.getMinute()+":"+datum.getSecond()+")";
                                }
                            }
                        }
                    }
                    if(!parts[73].isEmpty())
                    {
                        pdatum = LocalDate.parse(parts[73],datetimeformat);
                        pdate = "to_Date('";
                        if(pdatum.getDayOfMonth()<10)
                        {
                            pdate+="0";
                        }
                        pdate+=pdatum.getDayOfMonth()+".";
                        if(pdatum.getMonthValue()<10)
                        {
                            pdate+="0";
                        }
                        pdate+=pdatum.getMonthValue()+".";
                        if(pdatum.getYear()<10)
                        {
                            pdate+="0";
                        }
                        else if(pdatum.getYear()<100)
                        {
                            pdate+="00";
                        }
                        else if(pdatum.getYear()<1000)
                        {
                            pdate+="000";
                        }
                        pdate+=pdatum.getYear()+"','DD.MM.YYYY')";
                    }
                    if(!parts[79].isEmpty())
                    {
                        kdatum = LocalDate.parse(parts[79], datetimeformat);
                        kdate = "to_Date('";
                        if(kdatum.getDayOfMonth()<10)
                        {
                            kdate+="0";
                        }
                        kdate+=kdatum.getDayOfMonth()+".";
                        if(kdatum.getMonthValue()<10)
                        {
                            kdate+="0";
                        }
                        kdate+=kdatum.getMonthValue()+"."+kdatum.getYear()+"','DD.MM.YYYY')";
                    }
                    
                    Statement stat = con.createStatement();
                    String sql = "SELECT *"
                                +"FROM barrier_import "
                                +"WHERE objid='"+parts[0]+"';";
                    ResultSet rs = stat.executeQuery(sql);
                    
                    if(rs.next())
                    {
                        System.out.println("Update");
                        
                        int ret=stat.executeUpdate("UPDATE barrier_import "
                                         + "SET Klasse='"+parts[1]+"',"
                                         + "    Konstruktion = '"+parts[2]+"',"
                                         + "    ObjNummer = CAST("+parts[3]+" AS INTEGER),"
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
                                         + "    KmVonBei = CAST("+parts[21]+" AS NUMERIC),"
                                         + "    KmBis = CAST("+parts[22]+" AS NUMERIC),"
                                         + "    Funktion = '"+parts[23]+"',"
                                         + "    Position = '"+parts[24]+"',"
                                         + "    Fahrbahnanlage = '"+parts[25]+"',"
                                         + "    SeitlicherAbstand = CAST("+parts[26]+" AS NUMERIC),"
                                         + "    Anmerkung = '"+parts[27]+"',"
                                         + "    weitereVerkehrslinien = '"+parts[28]+"',"
                                         + "    BJ = CAST("+parts[29]+" AS INTEGER),"
                                         + "    KoordinatenMeridian = '"+parts[30]+"',"
                                         + "    AnfangRechtswert = CAST("+parts[31]+" AS NUMERIC),"
                                         + "    AnfangNordwert = CAST("+parts[32]+" AS NUMERIC),"
                                         + "    AnfangHöhe = CAST("+parts[33]+" AS NUMERIC),"
                                         + "    KreuzungspunktRechtswert = CAST("+parts[34]+" AS NUMERIC),"
                                         + "    KreuzungspunktNordwert = CAST("+parts[35]+" AS NUMERIC),"
                                         + "    KreuzungspunktHöhe = CAST("+parts[36]+" AS NUMERIC),"
                                         + "    EndpunktRechtswert = CAST("+parts[37]+" AS NUMERIC),"
                                         + "    EndpunktNordwert = CAST("+parts[38]+" AS NUMERIC),"
                                         + "    EndpunktHöhe = CAST("+parts[39]+" AS NUMERIC),"
                                         + "    Ortsgebiet = '"+ortsgebiet+"',"
                                         + "    GISWert = CAST("+parts[41]+" AS INTEGER),"
                                         + "    Einbauten = '"+parts[42]+"',"
                                         + "    System = '"+parts[43]+"',"
                                         + "    Norm = '"+parts[44]+"',"
                                         + "    DTV = CAST("+parts[45]+" AS INTEGER),"
                                         + "    DTLV = CAST("+parts[46]+" AS INTEGER),"
                                         + "    DLR = CAST("+parts[47]+" AS INTEGER),"
                                         + "    DL = CAST("+parts[48]+" AS INTEGER),"
                                         + "    Systemanmerkung = '"+parts[49]+"',"
                                         + "    LH = CAST("+parts[50]+" AS NUMERIC),"
                                         + "    FFBreite = CAST("+parts[51]+" AS NUMERIC),"
                                         + "    UnterbauGründung = '"+parts[52]+"',"
                                         + "    UnterbauAnmerkung = '"+parts[53]+"',"
                                         + "    UnterbauDammAbmessungen = '"+parts[54]+"',"
                                         + "    KonstruktionWirkungsweise = '"+parts[55]+"',"
                                         + "    KonstruktionBefestigung = '"+parts[56]+"',"
                                         + "    KonstruktionAnsichtsflaeche = '"+parts[57]+"',"
                                         + "    KonstruktionNachträglicheErhöhung = '"+nachträglich+"',"
                                         + "    KonstruktionHMAX = '"+konsthmax+"',"
                                         + "    KonstruktionAuskragung = '"+auskragung+"',"
                                         + "    KonstruktionGesamtlaengeAuskragung = CAST("+parts[61]+" AS NUMERIC),"
                                         + "    KonstruktionMaximaleAuskragung = CAST("+parts[62]+" AS NUMERIC),"
                                         + "    KonstruktionAnmerkung = '"+parts[63]+"',"
                                         + "    KonstruktionMaterial = '"+parts[64]+"',"
                                         + "    KonstruktionAbmessung = '"+parts[65]+"',"
                                         + "    KonstruktionAbmessungLängensumme = '"+parts[66]+"',"
                                         + "    AusruestungAnzahlTüren = CAST("+parts[67]+" AS INTEGER),"
                                         + "    AusruestungZugbänder = '"+bänder+"',"
                                         + "    AusruestungAnmerkung = '"+parts[69]+"',"
                                         + "    LastEditUser = '"+parts[70]+"',"
                                         + "    LastEditTimeStamp = "+date+","
                                         + "    PPID = CAST("+parts[72]+" AS INTEGER),"
                                         + "    PDatum = "+pdate+","
                                         + "    PNote = '"+parts[74]+"',"
                                         + "    PName = '"+parts[75]+"',"
                                         + "    PNext = '"+parts[76]+"',"
                                         + "    PErgänzendeUntersuchung = '"+parts[77]+"',"
                                         + "    KPID = CAST("+parts[78]+" AS INTEGER),"
                                         + "    KDatum = "+kdate+","
                                         + "    KNote = '"+parts[80]+"',"
                                         + "    KName = '"+parts[81]+"',"
                                         + "    KNext = '"+parts[82]+"',"
                                         + "    KErgänzendeUntersuchung = '"+parts[83]+"',"
                                         + "    UNTB = '"+untb+"',"
                                         + "    KONS = '"+kons+"',"
                                         + "    AUSR = '"+ausr+"' "
                                         + "WHERE objid='"+parts[0]+"';");
                        anzElemUpdated+=ret;
                    }
                    else
                    {
                        System.out.println("Insert");
                        //TO_NUMBER('"+parts[3]+"','99999')
                        /*
                        stat.executeUpdate("INSERT INTO barrier_import "
                                         + "(objid,KmVonBei,KmBis)"
                                         + "VALUES"
                                         + "('"+parts[0]+"',CAST("+parts[21]+" AS NUMERIC),CAST("+parts[22]+" AS NUMERIC));");
                        /*
                        stat.executeUpdate("INSERT INTO barrier_import "
                                         + "(objid,objnummer,BJ)"
                                         + "VALUES"
                                         + "('"+parts[0]+"',CAST("+parts[3]+" AS INTEGER),CAST("+parts[29]+" AS INTEGER));");
                        /*stat.executeUpdate("INSERT INTO barrier_import "
                                         + "(objid,LastEditTimeStamp,PDatum,KDatum)"
                                         + "VALUES"
                                         + "('"+parts[0]+"',"+date+","+pdate+","+kdate+");");
                        */
                        int ret=stat.executeUpdate("INSERT INTO barrier_import"
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
                                         + "('"+parts[0]+"','"+parts[1]+"','"+parts[2]+"',CAST("+parts[3]+" AS INTEGER),'"+parts[4] 
                                         + "','"+parts[5]+"','"+parts[6]+"','"+parts[7]+"','"+parts[8]+"','"+parts[9]
                                         + "','"+parts[10]+"','"+parts[11]+"','"+parts[12]+"',"+überwachung+",'"+parts[14]
                                         + "','"+parts[15]+"','"+parts[16]+"','"+parts[17]+"','"+parts[18]+"','"+parts[19]
                                         + "','"+parts[20]+"',CAST("+parts[21]+" AS NUMERIC),CAST("+parts[22]+" AS NUMERIC),'"+parts[23]+"','"+parts[24]
                                         + "','"+parts[25]+"',CAST("+parts[26]+" AS NUMERIC),'"+parts[27]+"','"+parts[28]+"',CAST("+parts[29]+" AS INTEGER)"
                                         + ",'"+parts[30]+"',CAST("+parts[31]+" AS NUMERIC),CAST("+parts[32]+" AS NUMERIC),CAST("+parts[33]+" AS NUMERIC),CAST("+parts[34]+" AS NUMERIC)"
                                         + ",CAST("+parts[35]+" AS NUMERIC),CAST("+parts[36]+" AS NUMERIC),CAST("+parts[37]+" AS NUMERIC),CAST("+parts[38]+" AS NUMERIC),CAST("+parts[39]+" AS NUMERIC)"
                                         + ",'"+ortsgebiet+"',CAST("+parts[41]+" AS INTEGER),'"+parts[42]+"','"+parts[43]+"','"+parts[44]
                                         + "',CAST("+parts[45]+" AS INTEGER),CAST("+parts[46]+" AS INTEGER),CAST("+parts[47]+" AS INTEGER),CAST("+parts[48]+" AS INTEGER),'"+parts[49]
                                         + "',CAST("+parts[50]+" AS NUMERIC),CAST("+parts[51]+" AS NUMERIC),'"+parts[52]+"','"+parts[53]+"','"+parts[54]
                                         + "','"+parts[55]+"','"+parts[56]+"',CAST("+parts[57]+" AS NUMERIC),'"+nachträglich+"','"+konsthmax
                                         + "','"+auskragung+"',CAST("+parts[61]+" AS NUMERIC),CAST("+parts[62]+" AS NUMERIC),'"+parts[63]+"','"+parts[64]
                                         + "','"+parts[65]+"','"+parts[66]+"',CAST("+parts[67]+" AS INTEGER),'"+bänder+"','"+parts[69]
                                         + "','"+parts[70]+"',"+date+",CAST("+parts[72]+" AS INTEGER),"+pdate+",'"+parts[74]
                                         + "','"+parts[75]+"','"+parts[76]+"','"+parts[77]+"',CAST("+parts[78]+" AS INTEGER),"+kdate
                                         + ",'"+parts[80]+"','"+parts[81]+"','"+parts[82]+"','"+parts[83]+"','"+untb
                                         + "','"+kons+"','"+ausr+"');");
                        anzElemInserted+=ret;
                    }
                    
                    imp = new BarrierBuilderImpl().setObjid(parts[0])
                                                                .setKlasse(parts[1])
                                                                .setKonstruktion(parts[2])
                                                                .setObjNummer(parts[3])
                                                                .setObjName(parts[4])
                                                                .setStatus(parts[5])
                                                                .setMandant(parts[6])
                                                                .setVerwalter(parts[7])
                                                                .setBaulicheErhaltung(parts[8])
                                                                .setBetrieblicheErhaltung(parts[9])
                                                                .setPrüfverpflichtung(parts[10])
                                                                .setKontrollverpflichtung(parts[11])
                                                                .setSondernutzung(parts[12])
                                                                .setLaufendeÜberwachungAngehakt(überwachung)
                                                                .setLaufendeÜberwachung(parts[14])
                                                                .setStandortA(parts[15])
                                                                .setStandortB(parts[16])
                                                                .setPrefix(parts[17])
                                                                .setÜS(parts[18])
                                                                .setHauptverkehrslinienNR(parts[19])
                                                                .setHauptverkehrslinienNA(parts[20])
                                                                .setKmVonBei(parts[21])
                                                                .setKmBis(parts[22])
                                                                .setFunktion(parts[23])
                                                                .setPosition(parts[24])
                                                                .setFahrbahnanlage(parts[25])
                                                                .setSeitlicherAbstand(parts[26])
                                                                .setAnmerkung(parts[27])
                                                                .setWeitereVerkehrslinien(parts[28])
                                                                .setBJ(parts[29])
                                                                .setKoordinatenMeridian(parts[30])
                                                                .setAnfangRechtswert(parts[31])
                                                                .setAnfangNordwert(parts[32])
                                                                .setAnfangHöhe(parts[33])
                                                                .setKreuzungspunktRechtswert(parts[34])
                                                                .setKreuzungspunktNordwert(parts[35])
                                                                .setKreuzungspunktHöhe(parts[36])
                                                                .setEndpunktRechtswert(parts[37])
                                                                .setEndpunktNordwert(parts[38])
                                                                .setEndpunktHöhe(parts[39])
                                                                .setOrtsgebiet(ortsgebiet)
                                                                .setGISWert(parts[41])
                                                                .setEinbauten(parts[42])
                                                                .setSystem(parts[43])
                                                                .setNorm(parts[44])
                                                                .setDTV(parts[45])
                                                                .setDTLV(parts[46])
                                                                .setDLR(parts[47])
                                                                .setDL(parts[48])
                                                                .setSystemAnmerkungen(parts[49])
                                                                .setLH(parts[50])
                                                                .setFFBreite(parts[51])
                                                                .setUnterbauGründung(parts[52])
                                                                .setUnterbauAnmerkung(parts[53])
                                                                .setUnterbauDammabmessungen(parts[54])
                                                                .setKonstruktionWirkungsweise(parts[55])
                                                                .setKonstruktionBefestigung(parts[56])
                                                                .setKonstruktionAnsichtsflaeche(parts[57])
                                                                .setKonstruktionNachträglicheErhöhung(nachträglich)
                                                                .setKonstruktionHMAX(konsthmax)
                                                                .setKonstruktionAuskragung(auskragung)
                                                                .setKonstruktionGesamtLaengeAuskragung(parts[61])
                                                                .setKonstruktionMaximaleAuskragung(parts[62])
                                                                .setKonstruktionAnmerkung(parts[63])
                                                                .setKonstruktionMaterial(parts[64])
                                                                .setKonstruktionAbmessung(parts[65])
                                                                .setKonstruktionAbmessungLängenSumme(parts[66])
                                                                .setAusruestungAnzahlTüren(parts[67])
                                                                .setAusruestungZugbänder(bänder)
                                                                .setAusruestungAnmerkung(parts[69])
                                                                .setLastEditUser(parts[70])
                                                                .setDatum(date)
                                                                .setPPID(parts[72])
                                                                .setPDatum(pdate)
                                                                .setPNote(parts[74])
                                                                .setPName(parts[75])
                                                                .setPNext(parts[76])
                                                                .setPErgänzendeUntersuchung(parts[77])
                                                                .setKPID(parts[78])
                                                                .setKDatum(kdate)
                                                                .setKNote(parts[80])
                                                                .setKName(parts[81])
                                                                .setKNext(parts[82])
                                                                .setKErgänzendeUntersuchung(parts[83])
                                                                .setUNTB(untb)
                                                                .setKOS(kons)
                                                                .setAUSR(ausr)
                                                                .build();
                        table.getModel().add(imp);
                    
                }
            }
            Soundbarrier.showJOptionPaneMessageInformation("Es wurden: "+anzElemUpdated+" Element/e geupdated.");
            Soundbarrier.showJOptionPaneMessageInformation("Es wurden: "+anzElemInserted+" Element/e neu eingefügt.");
        }catch(IllegalStateException istex){
            throw istex;
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    /**
     * Methode zum überprüfen, ob eine gültige CSV Datei ausgewählt wurde.
     * @param parts String Arry aus einer Linie der CSV Datei
     * @return true wenn eine Zeile genau die richtige Menge an Daten hat.
     */
    
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
