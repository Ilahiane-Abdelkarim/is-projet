package com.is.ws;

import com.is.bean.TypeDeclaration;
import com.is.service.TypeDeclarationService;
import com.is.service.TypeSocieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gestion-is/typedeclaration")
public class TypeDeclarationProvided {
    public TypeDeclaration findByCode(String code) {
        return typeDeclarationService.findByCode(code);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return typeDeclarationService.deleteByCode(code);
    }

    @GetMapping("/")
    public List<TypeDeclaration> findAll() {
        return typeDeclarationService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody TypeDeclaration typeDeclaration) {
        return typeDeclarationService.save(typeDeclaration);
    }

    @PutMapping("/code/{code}/libelle/{libelle}")
    public int updateByCode(@PathVariable String code, @PathVariable String libelle) {
        return typeDeclarationService.updateByCode(code, libelle);
    }

    @Autowired
    private TypeDeclarationService typeDeclarationService;
}
