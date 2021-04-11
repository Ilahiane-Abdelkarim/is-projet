package com.is.bean;

import javax.persistence.*;

@Entity
public class FactureSociete {
    @Id @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    private String libelle;
    @ManyToOne
    private Societe societeSource;
    @ManyToOne
    private Societe societeDestination;
    private String description;
    private double mthtt;
    private double mtttc;
    private double mttva;
    private double tva;
    @ManyToOne
    private TypeDeclaration typedeclaration;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Societe getSocieteSource() {
        return societeSource;
    }

    public void setSocieteSource(Societe societeSource) {
        this.societeSource = societeSource;
    }

    public Societe getSocieteDestination() {
        return societeDestination;
    }

    public void setSocieteDestination(Societe societeDestination) {
        this.societeDestination = societeDestination;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMthtt() {
        return mthtt;
    }

    public void setMthtt(double mthtt) {
        this.mthtt = mthtt;
    }

    public double getMtttc() {
        return mtttc;
    }

    public void setMtttc(double mtttc) {
        this.mtttc = mtttc;
    }

    public double getMttva() {
        return mttva;
    }

    public void setMttva(double mttva) {
        this.mttva = mttva;
    }

    public double getTva() {
        return tva;
    }

    public void setTva(double tva) {
        this.tva = tva;
    }

    public TypeDeclaration getTypedeclaration() {
        return typedeclaration;
    }

    public void setTypedeclaration(TypeDeclaration typedeclaration) {
        this.typedeclaration = typedeclaration;
    }
}
