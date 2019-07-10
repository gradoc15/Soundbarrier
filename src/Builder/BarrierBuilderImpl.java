/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;

import java.time.LocalDate;
import parts.BarrierImport;


public class BarrierBuilderImpl implements BarrierBuilder
{

    private BarrierImport temp;
    
    public BarrierBuilderImpl()
    {
        temp = new BarrierImport();
    }
    
    @Override
    public BarrierImport build()
    {
        BarrierImport imported = new BarrierImport();
        imported.setAnfangHöhe(temp.getAnfangHöhe());
        imported.setAnfangNordwert(temp.getAnfangNordwert());
        imported.setAnfangRechtswert(temp.getAnfangRechtswert());
        imported.setAnmerkung(temp.getAnmerkung());
        imported.setAusr(temp.isAusr());
        imported.setAusruestungAnmerkung(temp.getAusruestungAnmerkung());
        imported.setAusruestungAnzahlTüren(temp.getAusruestungAnzahlTüren());
        imported.setAusruestungZugbänder(temp.isAusruestungZugbänder());
        imported.setBaulicheErhaltung(temp.getBaulicheErhaltung());
        imported.setBetrieblicheErhaltung(temp.getBetrieblicheErhaltung());
        imported.setBj(temp.getBj());
        imported.setDl(temp.getDl());
        imported.setDlr(temp.getDlr());
        imported.setDtlv(temp.getDtlv());
        imported.setDtv(temp.getDtv());
        imported.setEinbauten(temp.getEinbauten());
        imported.setEndpunktHöhe(temp.getEndpunktHöhe());
        imported.setEndpunktNordwert(temp.getEndpunktNordwert());
        imported.setEndpunktRechtswert(temp.getEndpunktRechtswert());
        imported.setFahrbahnanlage(temp.getFahrbahnanlage());
        imported.setFfBreite(temp.getFfBreite());
        imported.setFunktion(temp.getFunktion());
        imported.setGiswert(temp.getGiswert());
        imported.setHauptverkehrslinieNA(temp.getHauptverkehrslinieNA());
        imported.setHauptverkehrslinieNR(temp.getHauptverkehrslinieNR());
        imported.setKdatum(temp.getKdatum());
        imported.setKlasse(temp.getKlasse());
        imported.setKmBis(temp.getKmBis());
        imported.setKmVonBei(temp.getKmVonBei());
        imported.setKname(temp.getKname());
        imported.setKnext(temp.getKnext());
        imported.setKnote(temp.getKnote());
        imported.setKonstruktion(temp.getKonstruktion());
        imported.setKonstruktionAbmessung(temp.getKonstruktionAbmessung());
        imported.setKonstruktionAbmessungLängensumme(temp.getKonstruktionAbmessungLängensumme());
        imported.setKonstruktionAnmerkung(temp.getKonstruktionAnmerkung());
        imported.setKonstruktionAnsichtsflaeche(temp.getKonstruktionAnsichtsflaeche());
        imported.setKonstruktionAuskragung(temp.isKonstruktionAuskragung());
        imported.setKonstruktionBefestigung(temp.getKonstruktionBefestigung());
        imported.setKonstruktionGesamtlaengeAuskragung(temp.getKonstruktionGesamtlaengeAuskragung());
        imported.setKonstruktionHMAX(temp.isKonstruktionHMAX());
        imported.setKonstruktionMaterial(temp.getKonstruktionMaterial());
        imported.setKonstruktionMaximaleAuskragung(temp.getKonstruktionMaximaleAuskragung());
        imported.setKonstruktionNachträglicheErhöhung(temp.isKonstruktionNachträglicheErhöhung());
        imported.setKonstruktionWirkungsweise(temp.getKonstruktionWirkungsweise());
        imported.setKontrollverpflichtung(temp.getKontrollverpflichtung());
        imported.setKoordinatenMeridian(temp.getKoordinatenMeridian());
        imported.setKos(temp.isKos());
        imported.setKpid(temp.getKpid());
        imported.setKreuzungspunktHöhe(temp.getKreuzungspunktHöhe());
        imported.setKreuzungspunktNordwert(temp.getKreuzungspunktNordwert());
        imported.setKreuzungspunktRechtswert(temp.getKreuzungspunktRechtswert());
        imported.setLastEditTimeStamp(temp.getLastEditTimeStamp());
        imported.setLastEditUser(temp.getLastEditUser());
        imported.setLaufendeÜberwachung(temp.getLaufendeÜberwachung());
        imported.setLaufendeÜberwachungAngehakt(temp.isLaufendeÜberwachungAngehakt());
        imported.setLh(temp.getLh());
        imported.setMandant(temp.getMandant());
        imported.setNorm(temp.getNorm());
        imported.setObjName(temp.getObjName());
        imported.setObjNummer(temp.getObjNummer());
        imported.setObjid(temp.getObjid());
        imported.setOrtsgebiet(temp.isOrtsgebiet());
        imported.setPdatum(temp.getPdatum());
        imported.setPname(temp.getPname());
        imported.setPnext(temp.getPnext());
        imported.setPnote(temp.getPnote());
        imported.setPosition(temp.getPosition());
        imported.setPpid(temp.getPpid());
        imported.setPrefix(temp.getPrefix());
        imported.setPrüfverpflichtung(temp.getPrüfverpflichtung());
        imported.setpErgänzendeUntersuchung(temp.getpErgänzendeUntersuchung());
        imported.setSeitlicherAbstand(temp.getSeitlicherAbstand());
        imported.setSondernutzung(temp.getSondernutzung());
        imported.setStandortA(temp.getStandortA());
        imported.setStandortB(temp.getStandortB());
        imported.setStatus(temp.getStatus());
        imported.setSystem(temp.getSystem());
        imported.setSystemAnmerkung(temp.getSystemAnmerkung());
        imported.setUntb(temp.isUntb());
        imported.setUnterbauAnmerkung(temp.getUnterbauAnmerkung());
        imported.setUnterbauDammabmessungen(temp.getUnterbauDammabmessungen());
        imported.setUnterbauGründung(temp.getUnterbauGründung());
        imported.setVerwalter(temp.getVerwalter());
        imported.setWeitereVerkehrslinien(temp.getWeitereVerkehrslinien());
        imported.setkErgänzendeUntersuchung(temp.getkErgänzendeUntersuchung());
        imported.setÜs(temp.getÜs());
        return imported;
    }

    @Override
    public BarrierBuilder setObjid(String objid)
    {
        temp.setObjid(objid);
        return this;
    }

    @Override
    public BarrierBuilder setKlasse(String klasse)
    {
        temp.setKlasse(klasse);
        return this;
    }

    @Override
    public BarrierBuilder setKonstruktion(String konstruktion)
    {
        temp.setKonstruktion(konstruktion);
        return this;
    }

    @Override
    public BarrierBuilder setObjName(String objName)
    {
        temp.setObjName(objName);
        return this;
    }

    @Override
    public BarrierBuilder setStatus(String status)
    {
        temp.setStatus(status);
        return this;
    }

    @Override
    public BarrierBuilder setMandant(String mandant)
    {
        temp.setMandant(mandant);
        return this;
    }

    @Override
    public BarrierBuilder setVerwalter(String verwalter)
    {
        temp.setVerwalter(verwalter);
        return this;
    }

    @Override
    public BarrierBuilder setBaulicheErhaltung(String baulicheErhaltung)
    {
        temp.setBaulicheErhaltung(baulicheErhaltung);
        return this;
    }

    @Override
    public BarrierBuilder setBetrieblicheErhaltung(String betrieblicheErhaltung)
    {
        temp.setBetrieblicheErhaltung(betrieblicheErhaltung);
        return this;
    }

    @Override
    public BarrierBuilder setPrüfverpflichtung(String prüfverpflichtung)
    {
        temp.setPrüfverpflichtung(prüfverpflichtung);
        return this;
    }

    @Override
    public BarrierBuilder setKontrollverpflichtung(String kontrollverpflichtung)
    {
        temp.setKontrollverpflichtung(kontrollverpflichtung);
        return this;
    }

    @Override
    public BarrierBuilder setSondernutzung(String sondernutzung)
    {
        temp.setSondernutzung(sondernutzung);
        return this;
    }

    @Override
    public BarrierBuilder setLaufendeÜberwachung(String laufendeÜberwachung)
    {
        temp.setLaufendeÜberwachung(laufendeÜberwachung);
        return this;
    }

    @Override
    public BarrierBuilder setStandortA(String standortA)
    {
        temp.setStandortA(standortA);
        return this;
    }

    @Override
    public BarrierBuilder setStandortB(String standortB)
    {
        temp.setStandortB(standortB);
        return this;
    }

    @Override
    public BarrierBuilder setPrefix(String prefix)
    {
        temp.setPrefix(prefix);
        return this;
    }

    @Override
    public BarrierBuilder setÜS(String üs)
    {
        temp.setÜs(üs);
        return this;
    }

    @Override
    public BarrierBuilder setHauptverkehrslinienNR(String hauptverkehrslinienNR)
    {
        temp.setHauptverkehrslinieNR(hauptverkehrslinienNR);
        return this;
    }

    @Override
    public BarrierBuilder setHauptverkehrslinienNA(String hauptverkehrslinienNA)
    {
        temp.setHauptverkehrslinieNA(hauptverkehrslinienNA);
        return this;
    }

    @Override
    public BarrierBuilder setFunktion(String funktion)
    {
        temp.setFunktion(funktion);
        return this;
    }

    @Override
    public BarrierBuilder setPosition(String position)
    {
        temp.setPosition(position);
        return this;
    }

    @Override
    public BarrierBuilder setFahrbahnanlage(String fahrbahnanlage)
    {
        temp.setFahrbahnanlage(fahrbahnanlage);
        return this;
    }

    @Override
    public BarrierBuilder setAnmerkung(String anmerkung)
    {
        temp.setAnmerkung(anmerkung);
        return this;
    }

    @Override
    public BarrierBuilder setWeitereVerkehrslinien(String verkehrslinien)
    {
        temp.setWeitereVerkehrslinien(verkehrslinien);
        return this;
    }

    @Override
    public BarrierBuilder setKoordinatenMeridian(String meridian)
    {
        temp.setKoordinatenMeridian(meridian);
        return this;
    }

    @Override
    public BarrierBuilder setEinbauten(String einbauten)
    {
        temp.setEinbauten(einbauten);
        return this;
    }

    @Override
    public BarrierBuilder setSystem(String system)
    {
        temp.setSystem(system);
        return this;
    }

    @Override
    public BarrierBuilder setNorm(String norm)
    {
        temp.setNorm(norm);
        return this;
    }

    @Override
    public BarrierBuilder setSystemAnmerkungen(String systemAnmerkungen)
    {
        temp.setSystemAnmerkung(systemAnmerkungen);
        return this;
    }

    @Override
    public BarrierBuilder setUnterbauGründung(String unterbau)
    {
        temp.setUnterbauGründung(unterbau);
        return this;
    }

    @Override
    public BarrierBuilder setUnterbauAnmerkung(String unterbauAnmerkung)
    {
        temp.setUnterbauAnmerkung(unterbauAnmerkung);
        return this;
    }

    @Override
    public BarrierBuilder setUnterbauDammabmessungen(String unterbauAbmessungen)
    {
        temp.setUnterbauDammabmessungen(unterbauAbmessungen);
        return this;
    }

    @Override
    public BarrierBuilder setKonstruktionWirkungsweise(String konstruktionWirkungsweise)
    {
        temp.setKonstruktionWirkungsweise(konstruktionWirkungsweise);
        return this;
    }

    @Override
    public BarrierBuilder setKonstruktionBefestigung(String konstruktionBefestigung)
    {
        temp.setKonstruktionBefestigung(konstruktionBefestigung);
        return this;
    }

    @Override
    public BarrierBuilder setKonstruktionAnsichtsflaeche(String ansichtsFlaeche)
    {
        temp.setKonstruktionAnsichtsflaeche(ansichtsFlaeche);
        return this;
    }

    @Override
    public BarrierBuilder setKonstruktionAnmerkung(String anmerkung)
    {
        temp.setKonstruktionAnmerkung(anmerkung);
        return this;
    }

    @Override
    public BarrierBuilder setKonstruktionMaterial(String material)
    {
        temp.setKonstruktionMaterial(material);
        return this;
    }

    @Override
    public BarrierBuilder setKonstruktionAbmessung(String abmessung)
    {
        temp.setKonstruktionAbmessung(abmessung);
        return this;
    }

    @Override
    public BarrierBuilder setKonstruktionAbmessungLängenSumme(String summe)
    {
        temp.setKonstruktionAbmessungLängensumme(summe);
        return this;
    }

    @Override
    public BarrierBuilder setAusruestungAnmerkung(String anmerkung)
    {
        temp.setAusruestungAnmerkung(anmerkung);
        return this;
    }

    @Override
    public BarrierBuilder setLastEditUser(String user)
    {
        temp.setLastEditUser(user);
        return this;
    }

    @Override
    public BarrierBuilder setPNote(String pnote)
    {
        temp.setPnote(pnote);
        return this;
    }

    @Override
    public BarrierBuilder setPName(String pname)
    {
        temp.setPname(pname);
        return this;
    }

    @Override
    public BarrierBuilder setPNext(String pnext)
    {
        temp.setPnext(pnext);
        return this;
    }

    @Override
    public BarrierBuilder setPErgänzendeUntersuchung(String pErgänzendeUntersuchung)
    {
        temp.setpErgänzendeUntersuchung(pErgänzendeUntersuchung);
        return this;
    }

    @Override
    public BarrierBuilder setKNote(String knote)
    {
        temp.setKnote(knote);
        return this;
    }

    @Override
    public BarrierBuilder setKName(String kname)
    {
        temp.setKname(kname);
        return this;
    }

    @Override
    public BarrierBuilder setKNext(String knext)
    {
        temp.setKnext(knext);
        return this;
    }

    @Override
    public BarrierBuilder setKErgänzendeUntersuchung(String kErgänzendeUntersuchung)
    {
        temp.setkErgänzendeUntersuchung(kErgänzendeUntersuchung);
        return this;
    }

    @Override
    public BarrierBuilder setKmVonBei(String kmVonBei)
    {
        temp.setKmVonBei(kmVonBei);
        return this;
    }

    @Override
    public BarrierBuilder setKmBis(String kmBis)
    {
        temp.setKmBis(kmBis);
        return this;
    }

    @Override
    public BarrierBuilder setSeitlicherAbstand(String abstand)
    {
        temp.setSeitlicherAbstand(abstand);
        return this;
    }

    @Override
    public BarrierBuilder setAnfangRechtswert(String wert)
    {
        temp.setAnfangRechtswert(wert);
        return this;
    }

    @Override
    public BarrierBuilder setAnfangNordwert(String wert)
    {
        temp.setAnfangNordwert(wert);
        return this;
    }

    @Override
    public BarrierBuilder setAnfangHöhe(String höhe)
    {
        temp.setAnfangHöhe(höhe);
        return this;
    }

    @Override
    public BarrierBuilder setKreuzungspunktRechtswert(String wert)
    {
        temp.setKreuzungspunktRechtswert(wert);
        return this;
    }

    @Override
    public BarrierBuilder setKreuzungspunktNordwert(String wert)
    {
        temp.setKreuzungspunktNordwert(wert);
        return this;
    }

    @Override
    public BarrierBuilder setKreuzungspunktHöhe(String höhe)
    {
        temp.setKreuzungspunktHöhe(höhe);
        return this;
    }

    @Override
    public BarrierBuilder setEndpunktRechtswert(String wert)
    {
        temp.setEndpunktRechtswert(wert);
        return this;
    }

    @Override
    public BarrierBuilder setEndpunktNordwert(String wert)
    {
        temp.setEndpunktNordwert(wert);
        return this;
    }

    @Override
    public BarrierBuilder setEndpunktHöhe(String höhe)
    {
        temp.setEndpunktHöhe(höhe);
        return this;
    }

    @Override
    public BarrierBuilder setLH(String lh)
    {
        temp.setLh(lh);
        return this;
    }

    @Override
    public BarrierBuilder setFFBreite(String ffBreite)
    {
        temp.setFfBreite(ffBreite);
        return this;
    }

    @Override
    public BarrierBuilder setKonstruktionHMAX(boolean konstruktionHMax)
    {
        temp.setKonstruktionHMAX(konstruktionHMax);
        return this;
    }

    @Override
    public BarrierBuilder setKonstruktionGesamtLaengeAuskragung(String laenge)
    {
        temp.setKonstruktionGesamtlaengeAuskragung(laenge);
        return this;
    }

    @Override
    public BarrierBuilder setKonstruktionMaximaleAuskragung(String maxAuskragung)
    {
        temp.setKonstruktionMaximaleAuskragung(maxAuskragung);
        return this;
    }

    @Override
    public BarrierBuilder setObjNummer(String nummer)
    {
        temp.setObjNummer(nummer);
        return this;
    }

    @Override
    public BarrierBuilder setBJ(String bj)
    {
        temp.setBj(bj);
        return this;
    }

    @Override
    public BarrierBuilder setGISWert(String gis)
    {
        temp.setGiswert(gis);
        return this;
    }

    @Override
    public BarrierBuilder setDTV(String dtv)
    {
        temp.setDtv(dtv);
        return this;
    }

    @Override
    public BarrierBuilder setDTLV(String dtlv)
    {
        temp.setDtlv(dtlv);
        return this;
    }

    @Override
    public BarrierBuilder setDLR(String dlr)
    {
        temp.setDlr(dlr);
        return this;
    }

    @Override
    public BarrierBuilder setDL(String dl)
    {
        temp.setDl(dl);
        return this;
    }

    @Override
    public BarrierBuilder setAusruestungAnzahlTüren(String anzahl)
    {
        temp.setAusruestungAnzahlTüren(anzahl);
        return this;
    }

    @Override
    public BarrierBuilder setPPID(String ppid)
    {
        temp.setPpid(ppid);
        return this;
    }

    @Override
    public BarrierBuilder setKPID(String kpid)
    {
        temp.setKpid(kpid);
        return this;
    }

    @Override
    public BarrierBuilder setLaufendeÜberwachungAngehakt(boolean überwachung)
    {
        temp.setLaufendeÜberwachungAngehakt(überwachung);
        return this;
    }

    @Override
    public BarrierBuilder setOrtsgebiet(boolean ortsgebiet)
    {
        temp.setOrtsgebiet(ortsgebiet);
        return this;
    }

    @Override
    public BarrierBuilder setKonstruktionAuskragung(boolean auskragung)
    {
        temp.setKonstruktionAuskragung(auskragung);
        return this;
    }

    @Override
    public BarrierBuilder setAusruestungZugbänder(boolean bänder)
    {
        temp.setAusruestungZugbänder(bänder);
        return this;
    }

    @Override
    public BarrierBuilder setUNTB(boolean untb)
    {
        temp.setUntb(untb);
        return this;
    }

    @Override
    public BarrierBuilder setKOS(boolean kos)
    {
        temp.setKos(kos);
        return this;
    }

    @Override
    public BarrierBuilder setAUSR(boolean ausr)
    {
        temp.setAusr(ausr);
        return this;
    }

    @Override
    public BarrierBuilder setKonstruktionNachträglicheErhöhung(boolean erhöhung)
    {
        temp.setKonstruktionNachträglicheErhöhung(erhöhung);
        return this;
    }

    @Override
    public BarrierBuilder setDatum(String datum)
    {
        temp.setLastEditTimeStamp(datum);
        return this;
    }

    @Override
    public BarrierBuilder setPDatum(String pdatum)
    {
        temp.setPdatum(pdatum);
        return this;
    }

    @Override
    public BarrierBuilder setKDatum(String kdatum)
    {
        temp.setKdatum(kdatum);
        return this;
    }
    
}
