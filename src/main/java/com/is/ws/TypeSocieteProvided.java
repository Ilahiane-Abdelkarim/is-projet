package com.is.ws;

import com.is.bean.TypeSociete;
import com.is.service.TypeSocieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gestion-is/typesociete")
public class TypeSocieteProvided {

    @DeleteMapping("/code/{code}")
    public int deleteByCode(String code) {
        return typeSocieteService.deleteByCode(code);
    }


    @GetMapping("/code/{code}")
    public TypeSociete findByCode(@PathVariable String code) {
        return typeSocieteService.findByCode(code);
    }

    @GetMapping("/")
    public List<TypeSociete> findAll() {
        return typeSocieteService.findAll();
    }

//    @GetMapping("/id/{id}")
//    public TypeSociete getOne(@PathVariable Long id) {
//        return typeSocieteService.getOne(id);
//    }

    @PostMapping("/")
    public int save(@RequestBody TypeSociete typeSociete) {
        return typeSocieteService.save(typeSociete);
    }

    @PutMapping("/code/{code}/libelle/{libelle}")
    public int updateByCode(@PathVariable String code, @PathVariable String libelle) {
        return typeSocieteService.updateByCode(code, libelle);
    }




    @Autowired
    private TypeSocieteService typeSocieteService;
}
