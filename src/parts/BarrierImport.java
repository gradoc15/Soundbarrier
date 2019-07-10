/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parts;

import java.time.LocalDate;

public class BarrierImport
{
    private String objid, klasse, konstruktion, objName, status, mandant;
    private String verwalter, baulicheErhaltung, betrieblicheErhaltung, prüfverpflichtung, kontrollverpflichtung, sondernutzung;
    private String laufendeÜberwachung, standortA, standortB, prefix, üs, hauptverkehrslinieNR;
    private String hauptverkehrslinieNA, funktion, position, fahrbahnanlage, anmerkung, weitereVerkehrslinien;
    private String koordinatenMeridian, einbauten, system, norm, systemAnmerkung, unterbauGründung;
    private String unterbauAnmerkung, unterbauDammabmessungen, KonstruktionWirkungsweise, KonstruktionBefestigung;
    private String konstruktionAnmerkung, konstruktionMaterial, konstruktionAbmessung, konstruktionAbmessungLängensumme, ausruestungAnmerkung, lastEditUser;
    private String pnote, pname, pnext, pErgänzendeUntersuchung, knote, kname;
    private String knext, kErgänzendeUntersuchung, LastEditTimeStamp, pdatum, kdatum;
    private String kmVonBei, kmBis, seitlicherAbstand, anfangRechtswert, anfangNordwert, anfangHöhe;
    private String kreuzungspunktRechtswert, kreuzungspunktNordwert, kreuzungspunktHöhe, endpunktRechtswert, endpunktNordwert, endpunktHöhe;
    private String lh, ffBreite, konstruktionGesamtlaengeAuskragung, konstruktionMaximaleAuskragung, konstruktionAnsichtsflaeche;
    private String objNummer, bj, giswert, dtv, dtlv, dlr;
    private String dl,AusruestungAnzahlTüren, ppid, kpid;
    private boolean laufendeÜberwachungAngehakt, ortsgebiet, konstruktionAuskragung, ausruestungZugbänder, untb;
    private boolean kos, ausr, konstruktionNachträglicheErhöhung, konstruktionHMAX;
    //private LocalDate LastEditTimeStamp, pdatum, kdatum;

    public String getObjid()
    {
        return objid;
    }

    public void setObjid(String objid)
    {
        this.objid = objid;
    }

    public String getKlasse()
    {
        return klasse;
    }

    public void setKlasse(String klasse)
    {
        this.klasse = klasse;
    }

    public String getKonstruktion()
    {
        return konstruktion;
    }

    public void setKonstruktion(String konstruktion)
    {
        this.konstruktion = konstruktion;
    }

    public String getObjName()
    {
        return objName;
    }

    public void setObjName(String objName)
    {
        this.objName = objName;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getMandant()
    {
        return mandant;
    }

    public void setMandant(String mandant)
    {
        this.mandant = mandant;
    }

    public String getVerwalter()
    {
        return verwalter;
    }

    public void setVerwalter(String verwalter)
    {
        this.verwalter = verwalter;
    }

    public String getBaulicheErhaltung()
    {
        return baulicheErhaltung;
    }

    public void setBaulicheErhaltung(String baulicheErhaltung)
    {
        this.baulicheErhaltung = baulicheErhaltung;
    }

    public String getBetrieblicheErhaltung()
    {
        return betrieblicheErhaltung;
    }

    public void setBetrieblicheErhaltung(String betrieblicheErhaltung)
    {
        this.betrieblicheErhaltung = betrieblicheErhaltung;
    }

    public String getPrüfverpflichtung()
    {
        return prüfverpflichtung;
    }

    public void setPrüfverpflichtung(String prüfverpflichtung)
    {
        this.prüfverpflichtung = prüfverpflichtung;
    }

    public String getKontrollverpflichtung()
    {
        return kontrollverpflichtung;
    }

    public void setKontrollverpflichtung(String kontrollverpflichtung)
    {
        this.kontrollverpflichtung = kontrollverpflichtung;
    }

    public String getSondernutzung()
    {
        return sondernutzung;
    }

    public void setSondernutzung(String sondernutzung)
    {
        this.sondernutzung = sondernutzung;
    }

    public String getLaufendeÜberwachung()
    {
        return laufendeÜberwachung;
    }

    public void setLaufendeÜberwachung(String laufendeÜberwachung)
    {
        this.laufendeÜberwachung = laufendeÜberwachung;
    }

    public String getStandortA()
    {
        return standortA;
    }

    public void setStandortA(String standortA)
    {
        this.standortA = standortA;
    }

    public String getStandortB()
    {
        return standortB;
    }

    public void setStandortB(String standortB)
    {
        this.standortB = standortB;
    }

    public String getPrefix()
    {
        return prefix;
    }

    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
    }

    public String getÜs()
    {
        return üs;
    }

    public void setÜs(String üs)
    {
        this.üs = üs;
    }

    public String getHauptverkehrslinieNR()
    {
        return hauptverkehrslinieNR;
    }

    public void setHauptverkehrslinieNR(String hauptverkehrslinieNR)
    {
        this.hauptverkehrslinieNR = hauptverkehrslinieNR;
    }

    public String getHauptverkehrslinieNA()
    {
        return hauptverkehrslinieNA;
    }

    public void setHauptverkehrslinieNA(String hauptverkehrslinieNA)
    {
        this.hauptverkehrslinieNA = hauptverkehrslinieNA;
    }

    public String getFunktion()
    {
        return funktion;
    }

    public void setFunktion(String funktion)
    {
        this.funktion = funktion;
    }

    public String getPosition()
    {
        return position;
    }

    public void setPosition(String position)
    {
        this.position = position;
    }

    public String getFahrbahnanlage()
    {
        return fahrbahnanlage;
    }

    public void setFahrbahnanlage(String fahrbahnanlage)
    {
        this.fahrbahnanlage = fahrbahnanlage;
    }

    public String getAnmerkung()
    {
        return anmerkung;
    }

    public void setAnmerkung(String anmerkung)
    {
        this.anmerkung = anmerkung;
    }

    public String getWeitereVerkehrslinien()
    {
        return weitereVerkehrslinien;
    }

    public void setWeitereVerkehrslinien(String weitereVerkehrslinien)
    {
        this.weitereVerkehrslinien = weitereVerkehrslinien;
    }

    public String getKoordinatenMeridian()
    {
        return koordinatenMeridian;
    }

    public void setKoordinatenMeridian(String koordinatenMeridian)
    {
        this.koordinatenMeridian = koordinatenMeridian;
    }

    public String getEinbauten()
    {
        return einbauten;
    }

    public void setEinbauten(String einbauten)
    {
        this.einbauten = einbauten;
    }

    public String getSystem()
    {
        return system;
    }

    public void setSystem(String system)
    {
        this.system = system;
    }

    public String getNorm()
    {
        return norm;
    }

    public void setNorm(String norm)
    {
        this.norm = norm;
    }

    public String getSystemAnmerkung()
    {
        return systemAnmerkung;
    }

    public void setSystemAnmerkung(String systemAnmerkung)
    {
        this.systemAnmerkung = systemAnmerkung;
    }

    public String getUnterbauGründung()
    {
        return unterbauGründung;
    }

    public void setUnterbauGründung(String unterbauGründung)
    {
        this.unterbauGründung = unterbauGründung;
    }

    public String getUnterbauAnmerkung()
    {
        return unterbauAnmerkung;
    }

    public void setUnterbauAnmerkung(String unterbauAnmerkung)
    {
        this.unterbauAnmerkung = unterbauAnmerkung;
    }

    public String getUnterbauDammabmessungen()
    {
        return unterbauDammabmessungen;
    }

    public void setUnterbauDammabmessungen(String unterbauDammabmessungen)
    {
        this.unterbauDammabmessungen = unterbauDammabmessungen;
    }

    public String getKonstruktionWirkungsweise()
    {
        return KonstruktionWirkungsweise;
    }

    public void setKonstruktionWirkungsweise(String KonstruktionWirkungsweise)
    {
        this.KonstruktionWirkungsweise = KonstruktionWirkungsweise;
    }

    public String getKonstruktionBefestigung()
    {
        return KonstruktionBefestigung;
    }

    public void setKonstruktionBefestigung(String KonstruktionBefestigung)
    {
        this.KonstruktionBefestigung = KonstruktionBefestigung;
    }

    public String getKonstruktionAnmerkung()
    {
        return konstruktionAnmerkung;
    }

    public void setKonstruktionAnmerkung(String konstruktionAnmerkung)
    {
        this.konstruktionAnmerkung = konstruktionAnmerkung;
    }

    public String getKonstruktionMaterial()
    {
        return konstruktionMaterial;
    }

    public void setKonstruktionMaterial(String konstruktionMaterial)
    {
        this.konstruktionMaterial = konstruktionMaterial;
    }

    public String getKonstruktionAbmessung()
    {
        return konstruktionAbmessung;
    }

    public void setKonstruktionAbmessung(String konstruktionAbmessung)
    {
        this.konstruktionAbmessung = konstruktionAbmessung;
    }

    public String getKonstruktionAbmessungLängensumme()
    {
        return konstruktionAbmessungLängensumme;
    }

    public void setKonstruktionAbmessungLängensumme(String konstruktionAbmessungLängensumme)
    {
        this.konstruktionAbmessungLängensumme = konstruktionAbmessungLängensumme;
    }

    public String getAusruestungAnmerkung()
    {
        return ausruestungAnmerkung;
    }

    public void setAusruestungAnmerkung(String ausruestungAnmerkung)
    {
        this.ausruestungAnmerkung = ausruestungAnmerkung;
    }

    public String getLastEditUser()
    {
        return lastEditUser;
    }

    public void setLastEditUser(String lastEditUser)
    {
        this.lastEditUser = lastEditUser;
    }

    public String getPnote()
    {
        return pnote;
    }

    public void setPnote(String pnote)
    {
        this.pnote = pnote;
    }

    public String getPname()
    {
        return pname;
    }

    public void setPname(String pname)
    {
        this.pname = pname;
    }

    public String getPnext()
    {
        return pnext;
    }

    public void setPnext(String pnext)
    {
        this.pnext = pnext;
    }

    public String getpErgänzendeUntersuchung()
    {
        return pErgänzendeUntersuchung;
    }

    public void setpErgänzendeUntersuchung(String pErgänzendeUntersuchung)
    {
        this.pErgänzendeUntersuchung = pErgänzendeUntersuchung;
    }

    public String getKnote()
    {
        return knote;
    }

    public void setKnote(String knote)
    {
        this.knote = knote;
    }

    public String getKname()
    {
        return kname;
    }

    public void setKname(String kname)
    {
        this.kname = kname;
    }

    public String getKnext()
    {
        return knext;
    }

    public void setKnext(String knext)
    {
        this.knext = knext;
    }

    public String getkErgänzendeUntersuchung()
    {
        return kErgänzendeUntersuchung;
    }

    public void setkErgänzendeUntersuchung(String kErgänzendeUntersuchung)
    {
        this.kErgänzendeUntersuchung = kErgänzendeUntersuchung;
    }

    public String getLastEditTimeStamp()
    {
        return LastEditTimeStamp;
    }

    public void setLastEditTimeStamp(String LastEditTimeStamp)
    {
        this.LastEditTimeStamp = LastEditTimeStamp;
    }

    public String getPdatum()
    {
        return pdatum;
    }

    public void setPdatum(String pdatum)
    {
        this.pdatum = pdatum;
    }

    public String getKdatum()
    {
        return kdatum;
    }

    public void setKdatum(String kdatum)
    {
        this.kdatum = kdatum;
    }

    public String getKmVonBei()
    {
        return kmVonBei;
    }

    public void setKmVonBei(String kmVonBei)
    {
        this.kmVonBei = kmVonBei;
    }

    public String getKmBis()
    {
        return kmBis;
    }

    public void setKmBis(String kmBis)
    {
        this.kmBis = kmBis;
    }

    public String getSeitlicherAbstand()
    {
        return seitlicherAbstand;
    }

    public void setSeitlicherAbstand(String seitlicherAbstand)
    {
        this.seitlicherAbstand = seitlicherAbstand;
    }

    public String getAnfangRechtswert()
    {
        return anfangRechtswert;
    }

    public void setAnfangRechtswert(String anfangRechtswert)
    {
        this.anfangRechtswert = anfangRechtswert;
    }

    public String getAnfangNordwert()
    {
        return anfangNordwert;
    }

    public void setAnfangNordwert(String anfangNordwert)
    {
        this.anfangNordwert = anfangNordwert;
    }

    public String getAnfangHöhe()
    {
        return anfangHöhe;
    }

    public void setAnfangHöhe(String anfangHöhe)
    {
        this.anfangHöhe = anfangHöhe;
    }

    public String getKreuzungspunktRechtswert()
    {
        return kreuzungspunktRechtswert;
    }

    public void setKreuzungspunktRechtswert(String kreuzungspunktRechtswert)
    {
        this.kreuzungspunktRechtswert = kreuzungspunktRechtswert;
    }

    public String getKreuzungspunktNordwert()
    {
        return kreuzungspunktNordwert;
    }

    public void setKreuzungspunktNordwert(String kreuzungspunktNordwert)
    {
        this.kreuzungspunktNordwert = kreuzungspunktNordwert;
    }

    public String getKreuzungspunktHöhe()
    {
        return kreuzungspunktHöhe;
    }

    public void setKreuzungspunktHöhe(String kreuzungspunktHöhe)
    {
        this.kreuzungspunktHöhe = kreuzungspunktHöhe;
    }

    public String getEndpunktRechtswert()
    {
        return endpunktRechtswert;
    }

    public void setEndpunktRechtswert(String endpunktRechtswert)
    {
        this.endpunktRechtswert = endpunktRechtswert;
    }

    public String getEndpunktNordwert()
    {
        return endpunktNordwert;
    }

    public void setEndpunktNordwert(String endpunktNordwert)
    {
        this.endpunktNordwert = endpunktNordwert;
    }

    public String getEndpunktHöhe()
    {
        return endpunktHöhe;
    }

    public void setEndpunktHöhe(String endpunktHöhe)
    {
        this.endpunktHöhe = endpunktHöhe;
    }

    public String getLh()
    {
        return lh;
    }

    public void setLh(String lh)
    {
        this.lh = lh;
    }

    public String getFfBreite()
    {
        return ffBreite;
    }

    public void setFfBreite(String ffBreite)
    {
        this.ffBreite = ffBreite;
    }

    public String getKonstruktionGesamtlaengeAuskragung()
    {
        return konstruktionGesamtlaengeAuskragung;
    }

    public void setKonstruktionGesamtlaengeAuskragung(String konstruktionGesamtlaengeAuskragung)
    {
        this.konstruktionGesamtlaengeAuskragung = konstruktionGesamtlaengeAuskragung;
    }

    public String getKonstruktionMaximaleAuskragung()
    {
        return konstruktionMaximaleAuskragung;
    }

    public void setKonstruktionMaximaleAuskragung(String konstruktionMaximaleAuskragung)
    {
        this.konstruktionMaximaleAuskragung = konstruktionMaximaleAuskragung;
    }

    public String getKonstruktionAnsichtsflaeche()
    {
        return konstruktionAnsichtsflaeche;
    }

    public void setKonstruktionAnsichtsflaeche(String konstruktionAnsichtsflaeche)
    {
        this.konstruktionAnsichtsflaeche = konstruktionAnsichtsflaeche;
    }

    public String getObjNummer()
    {
        return objNummer;
    }

    public void setObjNummer(String objNummer)
    {
        this.objNummer = objNummer;
    }

    public String getBj()
    {
        return bj;
    }

    public void setBj(String bj)
    {
        this.bj = bj;
    }

    public String getGiswert()
    {
        return giswert;
    }

    public void setGiswert(String giswert)
    {
        this.giswert = giswert;
    }

    public String getDtv()
    {
        return dtv;
    }

    public void setDtv(String dtv)
    {
        this.dtv = dtv;
    }

    public String getDtlv()
    {
        return dtlv;
    }

    public void setDtlv(String dtlv)
    {
        this.dtlv = dtlv;
    }

    public String getDlr()
    {
        return dlr;
    }

    public void setDlr(String dlr)
    {
        this.dlr = dlr;
    }

    public String getDl()
    {
        return dl;
    }

    public void setDl(String dl)
    {
        this.dl = dl;
    }

    public String getAusruestungAnzahlTüren()
    {
        return AusruestungAnzahlTüren;
    }

    public void setAusruestungAnzahlTüren(String AusruestungAnzahlTüren)
    {
        this.AusruestungAnzahlTüren = AusruestungAnzahlTüren;
    }

    public String getPpid()
    {
        return ppid;
    }

    public void setPpid(String ppid)
    {
        this.ppid = ppid;
    }

    public String getKpid()
    {
        return kpid;
    }

    public void setKpid(String kpid)
    {
        this.kpid = kpid;
    }

    public boolean isLaufendeÜberwachungAngehakt()
    {
        return laufendeÜberwachungAngehakt;
    }

    public void setLaufendeÜberwachungAngehakt(boolean laufendeÜberwachungAngehakt)
    {
        this.laufendeÜberwachungAngehakt = laufendeÜberwachungAngehakt;
    }

    public boolean isOrtsgebiet()
    {
        return ortsgebiet;
    }

    public void setOrtsgebiet(boolean ortsgebiet)
    {
        this.ortsgebiet = ortsgebiet;
    }

    public boolean isKonstruktionAuskragung()
    {
        return konstruktionAuskragung;
    }

    public void setKonstruktionAuskragung(boolean konstruktionAuskragung)
    {
        this.konstruktionAuskragung = konstruktionAuskragung;
    }

    public boolean isAusruestungZugbänder()
    {
        return ausruestungZugbänder;
    }

    public void setAusruestungZugbänder(boolean ausruestungZugbänder)
    {
        this.ausruestungZugbänder = ausruestungZugbänder;
    }

    public boolean isUntb()
    {
        return untb;
    }

    public void setUntb(boolean untb)
    {
        this.untb = untb;
    }

    public boolean isKos()
    {
        return kos;
    }

    public void setKos(boolean kos)
    {
        this.kos = kos;
    }

    public boolean isAusr()
    {
        return ausr;
    }

    public void setAusr(boolean ausr)
    {
        this.ausr = ausr;
    }

    public boolean isKonstruktionNachträglicheErhöhung()
    {
        return konstruktionNachträglicheErhöhung;
    }

    public void setKonstruktionNachträglicheErhöhung(boolean konstruktionNachträglicheErhöhung)
    {
        this.konstruktionNachträglicheErhöhung = konstruktionNachträglicheErhöhung;
    }

    public boolean isKonstruktionHMAX()
    {
        return konstruktionHMAX;
    }

    public void setKonstruktionHMAX(boolean konstruktionHMAX)
    {
        this.konstruktionHMAX = konstruktionHMAX;
    }
    
    
    
    
}
