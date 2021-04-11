package com.is.ws;


import com.is.bean.Societe;
import com.is.service.SocieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gestion-is/societe")
public class SocieteProvided {

    @PostMapping("/")
    public int save(@RequestBody Societe societe) {
        return SocieteService.save(societe);
    }

    @GetMapping("/ice/{ice}")
    public Societe findByIce(@PathVariable String ice) {
        return SocieteService.findByIce(ice);
    }

    @GetMapping("/siegeSociete/{siegeSociete}")
    public List<Societe> findBySiegeSociete(@PathVariable String siegeSociete) {
        return SocieteService.findBySiegeSociete(siegeSociete);
    }

    @GetMapping("/code/{code}")
    public List<Societe> findByTypesocieteCode(@PathVariable String code) {
        return SocieteService.findByTypesocieteCode(code);
    }

    @DeleteMapping("/ice/{ice}")
    public int deleteByIce(String ice) {
        return SocieteService.deleteByIce(ice);
    }

    @GetMapping("/siegeSociete/{siegeSociete}/code/{code}")
    public List<Societe> findBySiegeSocieteAndTypesociete(@PathVariable String siegeSociete, @PathVariable String code) {
        return SocieteService.findBySiegeSocieteAndTypesocieteCode(siegeSociete, code);
    }

    @PutMapping("/ice/{ice}/siegeSociete/{siegeSociete}/libelle/{libelle}/code/{code}")
    public int updateByIce(@PathVariable String ice, @PathVariable String siegeSociete, @PathVariable String libelle, @PathVariable String code) {
        return SocieteService.updateByIce(ice, siegeSociete, libelle, code);
    }

    @GetMapping("/")
    public List<Societe> findAll() {
        return SocieteService.findAll();
    }

    @Autowired
    private SocieteService SocieteService;
}
