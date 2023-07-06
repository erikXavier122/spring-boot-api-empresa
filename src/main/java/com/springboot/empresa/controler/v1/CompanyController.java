package com.springboot.empresa.controler.v1;


import com.springboot.empresa.domain.model.v1.CompanyModel;
import com.springboot.empresa.dto.v1.CompanyDto;
import com.springboot.empresa.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/company/v1")
@CrossOrigin(origins = "*",maxAge = 3600)
public class CompanyController {

    final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<CompanyModel>> getAllCompanyModel(){
        return ResponseEntity.status(HttpStatus.OK).body(companyService.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getOneCompany(@PathVariable(value = "id")UUID id){
        Optional<CompanyModel> companyModelOptional=companyService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(companyModelOptional.get());
    }

    @GetMapping("/getEmpresa/{nome_empresa}")
    public ResponseEntity<Object> getOneNameEmpresa(@PathVariable(value = "nome_empresa")String nome_empresa){
        return ResponseEntity.status(HttpStatus.OK).body(companyService.findByName(nome_empresa));
    }

    @GetMapping("/getCnpj/{cnpj}")
    public ResponseEntity<Object> getOneCnpj(@PathVariable(value="cnpj")String cnpj){
        return ResponseEntity.status(HttpStatus.OK).body(companyService.findByCnpj(cnpj));
    }

    @PostMapping("/save")
    public ResponseEntity<Object>saveRepository(@RequestBody @Valid CompanyDto companyDto){
        if (companyService.existsByCnpj(companyDto.getCnpj())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CONFLICT: Cnpj is already in use!");
        }
        var companyModel = new CompanyModel();
        BeanUtils.copyProperties(companyDto,companyModel);
        return ResponseEntity.status(HttpStatus.OK).body(companyService.save(companyModel));
    }

    @DeleteMapping("/deleteByEmpresa/{nome_empresa}")
    public ResponseEntity<Object> deleteByName(@PathVariable(value = "nome_empresa")String nome_empresa){
        return ResponseEntity.status(HttpStatus.OK).body(companyService.deleteByNome_empresa(nome_empresa));
    }
    @DeleteMapping("/deleteByCnpj/{cnpj}")
    public ResponseEntity<Object> deleteByCnpj(@PathVariable(value = "cnpj")String cnpj){
        return ResponseEntity.status(HttpStatus.OK).body(companyService.deleteByCnpj(cnpj));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Object>deleteRepository(@PathVariable(value = "id")UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(companyService.deleteById(id));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateRepository(@PathVariable(value = "id")UUID id, @RequestBody @Valid CompanyDto companyDto){
        return ResponseEntity.status(HttpStatus.OK).body(companyService.updateById(id,companyDto));
    }

    @PutMapping("/updateByname/{nome_empresa}")
    public ResponseEntity<Object> updateByName_empresa(@PathVariable(value = "nome_empresa")String nome_empresa,@RequestBody @Valid CompanyDto companyDto){
        return ResponseEntity.status(HttpStatus.OK).body(companyService.updateByName(nome_empresa,companyDto));
    }

    @PutMapping("/updateByCnpj/{cnpj}")
    public ResponseEntity<Object> updateByCnpj(@PathVariable(value = "cnpj")String cnpj,@RequestBody @Valid CompanyDto companyDto){
        return  ResponseEntity.status(HttpStatus.OK).body(companyService.updateByCnpj(cnpj,companyDto));
    }

}
