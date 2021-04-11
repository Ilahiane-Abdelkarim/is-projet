package com.is.dao;

import com.is.bean.Societe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocieteDao extends JpaRepository<Societe,Long> {
    Societe findByIce(String ice);
    List<Societe> findBySiegeSocieteAndTypesocieteCode(String siegeSociete,String code);
    List<Societe> findBySiegeSociete(String siegeSociete);
    List<Societe> findByTypesocieteCode(String code);
    int deleteByIce(String ice);

}
