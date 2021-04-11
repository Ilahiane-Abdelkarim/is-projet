/*
ILAHIANE ABDELKARIM   : SQ1 : 9,  SQ2 : 0,   SQ3 : 2
*/

package com.is.service;

import com.is.bean.DeclarationIs;
import com.is.bean.Societe;
import com.is.bean.TypeSociete;
import com.is.dao.DeclarationIsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class DeclarationIsService {


    public DeclarationIs findByCode(String code) {
        return declarationIsDao.findByCode(code);
    }

    @Transactional
    public int deleteByCode(String code) {
        return declarationIsDao.deleteByCode(code);
    }

    public List<DeclarationIs> findBySocieteIce(String ice) {
        return declarationIsDao.findBySocieteIce(ice);
    }

    public List<DeclarationIs> findByAnnee(Date annee) {
        return declarationIsDao.findByAnnee(annee);
    }

    public List<DeclarationIs> findByAnneeBetween(Date startDate, Date endDate) {
        return declarationIsDao.findByAnneeBetween(startDate, endDate);
    }

    public List<DeclarationIs> findByTotalChargeBetween(double startCharge, double endCharge) {
        return declarationIsDao.findByTotalChargeBetween(startCharge, endCharge);
    }

    public List<DeclarationIs> findByTotalGainBetween(double startGain, double endGain) {
        return declarationIsDao.findByTotalGainBetween(startGain, endGain);
    }

    public List<DeclarationIs> findByBeneficeBetween(double startBenefice, double endBenefice) {
        return declarationIsDao.findByBeneficeBetween(startBenefice, endBenefice);
    }

    public List<DeclarationIs> findByMtBaseBetween(double startMtBase, double endMtBase) {
        return declarationIsDao.findByMtBaseBetween(startMtBase, endMtBase);
    }

    public List<DeclarationIs> findAll() {
        return declarationIsDao.findAll();
    }

    public int save(DeclarationIs declarationIs){
        DeclarationIs foundedDeclarationIs = findByCode(declarationIs.getCode());
        Societe societe = societeService.findByIce(declarationIs.getSociete().getIce());
        if(foundedDeclarationIs != null){
            return -1;
        }else if(societe == null){
            return -2;
        }else{
            declarationIs.setSociete(societe);
            declarationIsDao.save(declarationIs);
            return 1;
        }
    }
    public int updateByCode(String code,String ice,Date annee,Date dateDeclaration,double totalCharge,double totalGain,double benefice,double mtBase) {
        DeclarationIs foundedDeclarationIs = findByCode(code);
        Societe societe = societeService.findByIce(ice);
        if(foundedDeclarationIs==null){
            return -1;
        }else if(societe==null){
            return -2;
        }else{
            foundedDeclarationIs.setCode(code);
            foundedDeclarationIs.setSociete(societe);
            foundedDeclarationIs.setAnnee(annee);
            foundedDeclarationIs.setDateDeclaration(dateDeclaration);
            foundedDeclarationIs.setBenefice(benefice);
            foundedDeclarationIs.setMtBase(mtBase);
            foundedDeclarationIs.setTotalCharge(totalCharge);
            foundedDeclarationIs.setTotalGain(totalGain);
            declarationIsDao.save(foundedDeclarationIs);
            return 1;
        }
    }



    @Autowired
    private DeclarationIsDao declarationIsDao;
    @Autowired
    private  SocieteService societeService;
}
