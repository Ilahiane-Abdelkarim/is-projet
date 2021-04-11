/*
ILAHIANE ABDELKARIM   : SQ1 : 11,  SQ2 : 0,   SQ3 : 2
*/

package com.is.service;

import com.is.bean.DeclarationIs;
import com.is.bean.FactureSociete;
import com.is.bean.Societe;
import com.is.bean.TypeDeclaration;
import com.is.dao.FactureSocieteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class FactureSocieteService {
    @Autowired
    private FactureSocieteDao factureSocieteDao;
    @Autowired
    private  SocieteService societeService;
    @Autowired
    private  TypeDeclarationService typeDeclarationService;

    public FactureSociete findByLibelle(String libelle) {
        return factureSocieteDao.findByLibelle(libelle);
    }

    @Transactional
    public int deleteByLibelle(String libelle) {
        return factureSocieteDao.deleteByLibelle(libelle);
    }


    public List<FactureSociete> findByMthttBetween(double minMthtt, double maxMthtt) {
        return factureSocieteDao.findByMthttBetween(minMthtt, maxMthtt);
    }

    public List<FactureSociete> findByMtttcBetween(double minMtttc, double maxMtttc) {
        return factureSocieteDao.findByMtttcBetween(minMtttc, maxMtttc);
    }

    public List<FactureSociete> findByMttvaBetween(double minMttva, double maxMttva) {
        return factureSocieteDao.findByMttvaBetween(minMttva, maxMttva);
    }

    public List<FactureSociete> findByTvaBetween(double minTva, double maxTva) {
        return factureSocieteDao.findByTvaBetween(minTva, maxTva);
    }

    public List<FactureSociete> findAll() {
        return factureSocieteDao.findAll();
    }
    public int save(FactureSociete factureSociete){
        FactureSociete foundedFactureSociete = findByLibelle(factureSociete.getLibelle());
        Societe societe1 = societeService.findByIce(factureSociete.getSocieteSource().getIce());
        Societe societe2 = societeService.findByIce(factureSociete.getSocieteDestination().getIce());
        TypeDeclaration typeDeclaration1 = typeDeclarationService.findByCode(factureSociete.getTypedeclaration().getCode());
        if(foundedFactureSociete != null){
            return -1;
        }else if(societe1 == null){
            return -2;
        }else if(societe2 == null){
            return -3;
        }else if(typeDeclaration1 == null){
            return -4;
        }else{
            factureSociete.setSocieteSource(societe1);
            factureSociete.setSocieteDestination(societe2);
            factureSociete.setTypedeclaration(typeDeclaration1);
            factureSocieteDao.save(factureSociete);
            return 1;
        }
    }

    public int updateByLibelle(String libelle, String iceSocieteSource,String iceSocieteDestination,String description,double mthtt, double mtttc,double mttva,double tva,String code) {
        FactureSociete foundedFactureSociete = findByLibelle(libelle);
        Societe societe1 = societeService.findByIce(iceSocieteSource);
        Societe societe2 = societeService.findByIce(iceSocieteDestination);
        TypeDeclaration typeDeclaration = typeDeclarationService.findByCode(code);
        if(foundedFactureSociete==null){
            return -1;
        }else if(societe1==null){
            return -2;
        }else if(societe2==null){
            return -3;
        }else if(typeDeclaration==null){
            return -4;
        }else{
            foundedFactureSociete.setLibelle(libelle);
            foundedFactureSociete.setSocieteSource(societe1);
            foundedFactureSociete.setSocieteDestination(societe2);
            foundedFactureSociete.setDescription(description);
            foundedFactureSociete.setMthtt(mthtt);
            foundedFactureSociete.setMtttc(mtttc);
            foundedFactureSociete.setMttva(mttva);
            foundedFactureSociete.setTva(tva);
            factureSocieteDao.save(foundedFactureSociete);
            return 1;
        }
    }

    public List<FactureSociete> findBySocieteSourceIceAndSocieteDestinationIce(String societeSourceIce, String societeDestinationIce) {
        return factureSocieteDao.findBySocieteSourceIceAndSocieteDestinationIce(societeSourceIce, societeDestinationIce);
    }

    public List<FactureSociete> findBySocieteSourceIce(String societeSourceIce) {
        return factureSocieteDao.findBySocieteSourceIce(societeSourceIce);
    }

    public List<FactureSociete> findBySocieteDestinationIce(String societeDestinationIce) {
        return factureSocieteDao.findBySocieteDestinationIce(societeDestinationIce);
    }

    public List<FactureSociete> findByTypedeclarationCode(String code) {
        return factureSocieteDao.findByTypedeclarationCode(code);
    }


}
