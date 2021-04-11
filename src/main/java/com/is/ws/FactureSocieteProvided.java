package com.is.ws;


import com.is.bean.FactureSociete;
import com.is.service.FactureSocieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gestion-is/facturesocieteprovided")
public class FactureSocieteProvided {
    @GetMapping("/libelle/{libelle}")
    public FactureSociete findByLibelle(@PathVariable String libelle) {
        return factureSocieteService.findByLibelle(libelle);
    }

    @DeleteMapping("/libelle/{libelle}")
    public int deleteByLibelle(String libelle) {
        return factureSocieteService.deleteByLibelle(libelle);
    }

    @GetMapping("/minMthtt/{minMthtt}/maxMthtt/{maxMthtt}")
    public List<FactureSociete> findByMthttBetween(@PathVariable double minMthtt, @PathVariable double maxMthtt) {
        return factureSocieteService.findByMthttBetween(minMthtt, maxMthtt);
    }
    @GetMapping("/minMtttc/{minMtttc}/maxMtttc/{maxMtttc}")
    public List<FactureSociete> findByMtttcBetween(@PathVariable double minMtttc, @PathVariable double maxMtttc) {
        return factureSocieteService.findByMtttcBetween(minMtttc, maxMtttc);
    }
    @GetMapping("/minMttva/{minMttva}/maxMttva/{maxMttva}")
    public List<FactureSociete> findByMttvaBetween(@PathVariable double minMttva, @PathVariable double maxMttva) {
        return factureSocieteService.findByMttvaBetween(minMttva, maxMttva);
    }
    @GetMapping("/minTva/{minTva}/maxTva/{maxTva}")
    public List<FactureSociete> findByTvaBetween(@PathVariable double minTva, @PathVariable double maxTva) {
        return factureSocieteService.findByTvaBetween(minTva, maxTva);
    }

    @GetMapping("/")
    public List<FactureSociete> findAll() {
        return factureSocieteService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody FactureSociete factureSociete) {
        return factureSocieteService.save(factureSociete);
    }

    @PutMapping("/libelle/{libelle}/iceSocieteSource/{iceSocieteSource}/iceSocieteDestination/{iceSocieteDestination}/description/{description}/mthtt/{mthtt}/mtttc/{mtttc}/mttva/{mttva}/tva/{tva}/code/{code}")
    public int updateByLibelle(@PathVariable String libelle, @PathVariable String iceSocieteSource, @PathVariable String iceSocieteDestination, @PathVariable String description, @PathVariable double mthtt, @PathVariable double mtttc, @PathVariable double mttva, @PathVariable double tva, @PathVariable String code) {
        return factureSocieteService.updateByLibelle(libelle, iceSocieteSource, iceSocieteDestination, description, mthtt, mtttc, mttva, tva, code);
    }

    @GetMapping("/societeSourceIce/{societeSourceIce}/societeDestinationIce/{societeDestinationIce}")
    public List<FactureSociete> findBySocieteSourceIceAndSocieteDestinationIce(@PathVariable String societeSourceIce, @PathVariable String societeDestinationIce) {
        return factureSocieteService.findBySocieteSourceIceAndSocieteDestinationIce(societeSourceIce, societeDestinationIce);
    }

    @GetMapping("/societeSourceIce/{societeSourceIce}")
    public List<FactureSociete> findBySocieteSourceIce(@PathVariable String societeSourceIce) {
        return factureSocieteService.findBySocieteSourceIce(societeSourceIce);
    }

    @GetMapping("/societeDestinationIce/{societeDestinationIce}")
    public List<FactureSociete> findBySocieteDestinationIce(@PathVariable String societeDestinationIce) {
        return factureSocieteService.findBySocieteDestinationIce(societeDestinationIce);
    }
    @GetMapping("/code/{code}")
    public List<FactureSociete> findByTypedeclarationCode(@PathVariable String code) {
        return factureSocieteService.findByTypedeclarationCode(code);
    }

    @Autowired
    private FactureSocieteService factureSocieteService;
}
