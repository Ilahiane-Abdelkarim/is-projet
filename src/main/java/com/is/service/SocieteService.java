/*
ILAHIANE ABDELKARIM   : SQ1 : 6,  SQ2 : 0,   SQ3 : 2
*/

package com.is.service;

import com.is.bean.Societe;
import com.is.bean.TypeSociete;
import com.is.dao.SocieteDao;
import com.is.dao.TypeSocieteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SocieteService {
    @Autowired
    private SocieteDao societeDao;

    @Autowired
    private  TypeSocieteService typeSocieteService;
    public int save(Societe societe){
        Societe foundedSociete = findByIce(societe.getIce());
        TypeSociete typeSociete = typeSocieteService.findByCode(societe.getTypesociete().getCode());
        if(foundedSociete != null){
            return -1;
        }else if(typeSociete == null){
            return -2;
        }else{
            societe.setTypesociete(typeSociete);
            societeDao.save(societe);
            return 1;
        }
    }
    public int updateByIce(String ice,String siegeSociete,String libelle,String code) {
        Societe foundedSociete = findByIce(ice);
        TypeSociete typeSociete = typeSocieteService.findByCode(code);
        if(foundedSociete==null){
            return -1;
        }else if(typeSociete==null){
            TypeSociete typeSociete2 = new TypeSociete();
            typeSociete2.setCode(code);
            typeSociete2.setLibelle(code);
            typeSocieteService.save(typeSociete2);
            foundedSociete.setIce(ice);
            foundedSociete.setSiegeSociete(siegeSociete);
            foundedSociete.setLibelle(libelle);
            foundedSociete.setTypesociete(typeSociete2);
            societeDao.save(foundedSociete);
            return 1;
        }else{
            foundedSociete.setIce(ice);
            foundedSociete.setSiegeSociete(siegeSociete);
            foundedSociete.setLibelle(libelle);
            foundedSociete.setTypesociete(typeSociete);
            societeDao.save(foundedSociete);
            return 2;
        }
    }
    public Societe findByIce(String ice) {
        return societeDao.findByIce(ice);
    }

    public List<Societe> findBySiegeSociete(String siegeSociete) {
        return societeDao.findBySiegeSociete(siegeSociete);
    }

    public List<Societe> findByTypesocieteCode(String code) {
        return societeDao.findByTypesocieteCode(code);
    }
    @Transactional
    public int deleteByIce(String ice) {
        return societeDao.deleteByIce(ice);
    }

    public List<Societe> findBySiegeSocieteAndTypesocieteCode(String siegeSociete, String code) {
        return societeDao.findBySiegeSocieteAndTypesocieteCode(siegeSociete, code);
    }

    public List<Societe> findAll() {
        return societeDao.findAll();
    }
}
