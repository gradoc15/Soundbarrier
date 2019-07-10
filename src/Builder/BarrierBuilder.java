/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;

import parts.BarrierImport;
import java.time.LocalDate;


public interface BarrierBuilder
{
   BarrierImport build();
   BarrierBuilder setObjid(final String objid);
   BarrierBuilder setKlasse(final String klasse);
   BarrierBuilder setKonstruktion(final String konstruktion);
   BarrierBuilder setObjName(final String objName);
   BarrierBuilder setStatus(final String status);
   BarrierBuilder setMandant(final String mandant);
   BarrierBuilder setVerwalter(final String verwalter);
   BarrierBuilder setBaulicheErhaltung(final String baulicheErhaltung);
   BarrierBuilder setBetrieblicheErhaltung(final String betrieblicheErhaltung);
   BarrierBuilder setPrüfverpflichtung(final String prüfverpflichtung);
   BarrierBuilder setKontrollverpflichtung(final String kontrollverpflichtung);
   BarrierBuilder setSondernutzung(final String sondernutzung);
   BarrierBuilder setLaufendeÜberwachung(final String laufendeÜberwachung);
   BarrierBuilder setStandortA(final String standortA);
   BarrierBuilder setStandortB(final String standortB);
   BarrierBuilder setPrefix(final String prefix);
   BarrierBuilder setÜS(final String üs);
   BarrierBuilder setHauptverkehrslinienNR(final String hauptverkehrslinienNR);
   BarrierBuilder setHauptverkehrslinienNA(final String hauptverkehrslinienNA);
   BarrierBuilder setFunktion(final String funktion);
   BarrierBuilder setPosition(final String position);
   BarrierBuilder setFahrbahnanlage(final String fahrbahnanlage);
   BarrierBuilder setAnmerkung(final String anmerkung);
   BarrierBuilder setWeitereVerkehrslinien(final String verkehrslinien);
   BarrierBuilder setKoordinatenMeridian(final String meridian);
   BarrierBuilder setEinbauten(final String einbauten);
   BarrierBuilder setSystem(final String system);
   BarrierBuilder setNorm(final String norm);
   BarrierBuilder setSystemAnmerkungen(final String systemAnmerkungen);
   BarrierBuilder setUnterbauGründung(final String unterbau);
   BarrierBuilder setUnterbauAnmerkung(final String unterbauAnmerkung);
   BarrierBuilder setUnterbauDammabmessungen(final String unterbauAbmessungen);
   BarrierBuilder setKonstruktionWirkungsweise(final String konstruktionWirkungsweise);
   BarrierBuilder setKonstruktionBefestigung(final String konstruktionBefestigung);
   BarrierBuilder setKonstruktionAnsichtsflaeche(final String ansichtsFlaeche);
   BarrierBuilder setKonstruktionAnmerkung(final String anmerkung);
   BarrierBuilder setKonstruktionMaterial(final String material);
   BarrierBuilder setKonstruktionAbmessung(final String abmessung);
   BarrierBuilder setKonstruktionAbmessungLängenSumme(final String summe);
   BarrierBuilder setAusruestungAnmerkung(final String anmerkung);
   BarrierBuilder setLastEditUser(final String user);
   BarrierBuilder setPNote(final String pnote);
   BarrierBuilder setPName(final String pname);
   BarrierBuilder setPNext(final String pnext);
   BarrierBuilder setPErgänzendeUntersuchung(final String pErgänzendeUntersuchung);
   BarrierBuilder setKNote(final String knote);
   BarrierBuilder setKName(final String kname);
   BarrierBuilder setKNext(final String knext);
   BarrierBuilder setKErgänzendeUntersuchung(final String kErgänzendeUntersuchung);
   BarrierBuilder setKmVonBei(final String kmVonBei);
   BarrierBuilder setKmBis(final String kmBis);
   BarrierBuilder setSeitlicherAbstand(final String abstand);
   BarrierBuilder setAnfangRechtswert(final String wert);
   BarrierBuilder setAnfangNordwert(final String wert);
   BarrierBuilder setAnfangHöhe(final String höhe);
   BarrierBuilder setKreuzungspunktRechtswert(final String wert);
   BarrierBuilder setKreuzungspunktNordwert(final String wert);
   BarrierBuilder setKreuzungspunktHöhe(final String höhe);
   BarrierBuilder setEndpunktRechtswert(final String wert);
   BarrierBuilder setEndpunktNordwert(final String wert);
   BarrierBuilder setEndpunktHöhe(final String höhe);
   BarrierBuilder setLH(final String lh);
   BarrierBuilder setFFBreite(final String ffBreite);
   BarrierBuilder setKonstruktionHMAX(final boolean konstruktionHMax);
   BarrierBuilder setKonstruktionGesamtLaengeAuskragung(final String laenge);
   BarrierBuilder setKonstruktionMaximaleAuskragung(final String maxAuskragung);
   BarrierBuilder setObjNummer(final String nummer);
   BarrierBuilder setBJ(final String bj);
   BarrierBuilder setGISWert(final String gis);
   BarrierBuilder setDTV(final String dtv);
   BarrierBuilder setDTLV(final String dtlv);
   BarrierBuilder setDLR(final String dlr);
   BarrierBuilder setDL(final String dl);
   BarrierBuilder setAusruestungAnzahlTüren(final String anzahl);
   BarrierBuilder setPPID(final String ppid);
   BarrierBuilder setKPID(final String kpid);
   BarrierBuilder setLaufendeÜberwachungAngehakt(final boolean überwachung);
   BarrierBuilder setOrtsgebiet(final boolean ortsgebiet);
   BarrierBuilder setKonstruktionAuskragung(final boolean auskragung);
   BarrierBuilder setAusruestungZugbänder(final boolean bänder);
   BarrierBuilder setUNTB(final boolean untb);
   BarrierBuilder setKOS(final boolean kos);
   BarrierBuilder setAUSR(final boolean ausr);
   BarrierBuilder setKonstruktionNachträglicheErhöhung(final boolean erhöhung);
   BarrierBuilder setDatum(final String datum);
   BarrierBuilder setPDatum(final String pdatum);
   BarrierBuilder setKDatum(final String kdatum);
}
