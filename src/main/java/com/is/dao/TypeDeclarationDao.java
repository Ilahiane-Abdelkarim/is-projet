package com.is.dao;

import com.is.bean.TypeDeclaration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeDeclarationDao extends JpaRepository<TypeDeclaration,Long> {
    TypeDeclaration findByCode(String code);
    int deleteByCode(String code);
}
