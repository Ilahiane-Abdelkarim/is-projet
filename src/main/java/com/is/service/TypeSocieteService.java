/*
ILAHIANE ABDELKARIM   : SQ1 : 3,  SQ2 : 2,   SQ3 : 0
*/

package com.is.service;

import com.is.bean.TypeSociete;
import com.is.dao.TypeSocieteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TypeSocieteService {

    @Transactional
    public int deleteByCode(String code) {
        return typeSocieteDao.deleteByCode(code);
    }

    public TypeSociete findByCode(String code) {
        return typeSocieteDao.findByCode(code);
    }

    public List<TypeSociete> findAll() {
        return typeSocieteDao.findAll();
    }



    public int save(TypeSociete typeSociete){
        if(findByCode(typeSociete.getCode())!=null){
            return -1;
        }else{
            typeSocieteDao.save(typeSociete);
            return 1;
        }
    }

    public int updateByCode(String code,String libelle) {
        TypeSociete typeSociete = findByCode(code);
        if(typeSociete==null){
            return -1;
        }else{
            typeSociete.setLibelle(libelle);
            typeSocieteDao.save(typeSociete);
            return 1;
        }
    }

    @Autowired
    private TypeSocieteDao typeSocieteDao;
}
