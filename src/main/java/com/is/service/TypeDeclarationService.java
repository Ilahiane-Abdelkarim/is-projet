
/*
ILAHIANE ABDELKARIM   : SQ1 : 2,  SQ2 : 2,   SQ3 : 0
*/
package com.is.service;

import com.is.bean.TypeDeclaration;
import com.is.bean.TypeSociete;
import com.is.dao.TypeDeclarationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeDeclarationService {


    public TypeDeclaration findByCode(String code) {
        return typeDeclarationDao.findByCode(code);
    }
    @Transactional
    public int deleteByCode(String code) {
        return typeDeclarationDao.deleteByCode(code);
    }

    public List<TypeDeclaration> findAll() {
        return typeDeclarationDao.findAll();
    }

    public int save(TypeDeclaration typeDeclaration){
        if(findByCode(typeDeclaration.getCode())!=null){
            return -1;
        }else{
            typeDeclarationDao.save(typeDeclaration);
            return 1;
        }
    }

    public int updateByCode(String code,String libelle) {
        TypeDeclaration typeDeclaration = findByCode(code);
        if(typeDeclaration==null){
            return -1;
        }else{
            typeDeclaration.setLibelle(libelle);
            typeDeclarationDao.save(typeDeclaration);
            return 1;
        }
    }

    @Autowired
    private TypeDeclarationDao typeDeclarationDao;
}
