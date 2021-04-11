package com.is.ws;

import com.is.bean.DeclarationIs;
import com.is.service.DeclarationIsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("gestion-is/declarationis")
public class declarationIsProvided {
    @GetMapping("/code/{code}")
    public DeclarationIs findByCode(@PathVariable String code) {
        return declarationIsService.findByCode(code);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(String code) {
        return declarationIsService.deleteByCode(code);
    }

    @GetMapping("/ice/{ice}")
    public List<DeclarationIs> findBySocieteIce(@PathVariable String ice) {
        return declarationIsService.findBySocieteIce(ice);
    }

    /*@GetMapping("/annee/{annee}")
    public List<DeclarationIs> findByAnnee(@PathVariable @DateTimeFormat( pattern = "yyyy") Date annee) {
        return declarationIsService.findByAnnee(annee);
    }*/

    @GetMapping("/startDate/{startDate}/endDate/{endDate}")
    public List<DeclarationIs> findByAnneeBetween(@PathVariable @DateTimeFormat( pattern = "MM-dd-yyyy") Date startDate, @PathVariable @DateTimeFormat( pattern = "MM-dd-yyyy")  Date endDate) {
        return declarationIsService.findByAnneeBetween(startDate, endDate);
    }

    @GetMapping("/startCharge/{startCharge}/endCharge/{endCharge}")
    public List<DeclarationIs> findByTotalChargeBetween(@PathVariable double startCharge, @PathVariable double endCharge) {
        return declarationIsService.findByTotalChargeBetween(startCharge, endCharge);
    }

    @GetMapping("/startGain/{startGain}/endGain/{endGain}")
    public List<DeclarationIs> findByTotalGainBetween(@PathVariable double startGain, @PathVariable double endGain) {
        return declarationIsService.findByTotalGainBetween(startGain, endGain);
    }

    @GetMapping("/startBenefice/{startBenefice}/endBenefice/{endBenefice}")
    public List<DeclarationIs> findByBeneficeBetween(@PathVariable double startBenefice, @PathVariable double endBenefice) {
        return declarationIsService.findByBeneficeBetween(startBenefice, endBenefice);
    }

    @GetMapping("/startMtBase/{startMtBase}/endMtBase/{endMtBase}")
    public List<DeclarationIs> findByMtBaseBetween(@PathVariable double startMtBase, @PathVariable double endMtBase) {
        return declarationIsService.findByMtBaseBetween(startMtBase, endMtBase);
    }

    @GetMapping("/")
    public List<DeclarationIs> findAll() {
        return declarationIsService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody DeclarationIs declarationIs) {
        return declarationIsService.save(declarationIs);
    }

    @PutMapping("/code/{code}/ice/{ice}/annee/{annee}/dateDeclaration/{dateDeclaration}/totalCharge/{totalCharge}/totalGain/{totalGain}/benefice/{benefice}/mtBase/{mtBase}")
    public int updateByCode(@PathVariable String code, @PathVariable String ice, @PathVariable @DateTimeFormat( pattern = "MM-dd-yyyy") Date annee, @PathVariable @DateTimeFormat( pattern = "MM-dd-yyyy") Date dateDeclaration, @PathVariable double totalCharge, @PathVariable double totalGain, @PathVariable double benefice, @PathVariable double mtBase) {
        return declarationIsService.updateByCode(code, ice, annee, dateDeclaration, totalCharge, totalGain, benefice, mtBase);
    }

    @Autowired
    private DeclarationIsService declarationIsService;
}
