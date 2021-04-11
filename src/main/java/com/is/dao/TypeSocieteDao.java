package com.is.dao;

import com.is.bean.TypeSociete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeSocieteDao extends JpaRepository<TypeSociete,Long> {
    TypeSociete findByCode(String code);
    int deleteByCode(String code);
}
