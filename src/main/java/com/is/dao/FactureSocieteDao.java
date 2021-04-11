package com.is.dao;

import com.is.bean.DeclarationIs;
import com.is.bean.FactureSociete;
import com.is.bean.Societe;
import com.is.bean.TypeDeclaration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FactureSocieteDao extends JpaRepository<FactureSociete,Long> {

    FactureSociete findByLibelle(String libelle);
    int deleteByLibelle(String libelle);
    List<FactureSociete> findBySocieteSourceIceAndSocieteDestinationIce(String societeSourceIce ,String societeDestinationIce);
    List<FactureSociete> findBySocieteSourceIce(String societeSourceIce);
    List<FactureSociete> findBySocieteDestinationIce(String societeDestinationIce);
    List<FactureSociete> findByTypedeclarationCode(String code);
    List<FactureSociete> findByMthttBetween(double minMthtt, double maxMthtt);
    List<FactureSociete> findByMtttcBetween(double minMtttc, double maxMtttc);
    List<FactureSociete> findByMttvaBetween(double minMttva, double maxMttva);
    List<FactureSociete> findByTvaBetween(double minTva, double maxTva);
}
