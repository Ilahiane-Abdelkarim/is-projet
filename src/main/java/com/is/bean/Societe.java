package com.is.bean;

import javax.persistence.*;

@Entity
public class Societe {
    @Id @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    private String ice;
    private String siegeSociete;

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    private String libelle;
    @ManyToOne
    private TypeSociete typesociete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIce() {
        return ice;
    }

    public void setIce(String ice) {
        this.ice = ice;
    }

    public String getSiegeSociete() {
        return siegeSociete;
    }

    public void setSiegeSociete(String siegeSociete) {
        this.siegeSociete = siegeSociete;
    }

    public TypeSociete getTypesociete() {
        return typesociete;
    }

    public void setTypesociete(TypeSociete typesociete) {
        this.typesociete = typesociete;
    }
}
