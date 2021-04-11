package com.is.dao;

import com.is.bean.DeclarationIs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DeclarationIsDao extends JpaRepository<DeclarationIs,Long> {
    DeclarationIs findByCode(String code);
    int deleteByCode(String code);
    List<DeclarationIs> findBySocieteIce(String ice);
    List<DeclarationIs> findByAnnee(Date annee);
    List<DeclarationIs> findByAnneeBetween(Date startDate, Date endDate);
    List<DeclarationIs> findByTotalChargeBetween(double startCharge, double endCharge);
    List<DeclarationIs> findByTotalGainBetween(double startGain, double endGain);
    List<DeclarationIs> findByBeneficeBetween(double startBenefice, double endBenefice);
    List<DeclarationIs> findByMtBaseBetween(double startMtBase, double endMtBase);

}
