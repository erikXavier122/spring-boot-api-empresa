package com.springboot.empresa.service.impl;

import com.springboot.empresa.domain.model.v1.CompanyModel;
import com.springboot.empresa.domain.repository.v1.CompanyRepository;
import com.springboot.empresa.dto.v1.CompanyDto;
import com.springboot.empresa.service.CompanyService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CompanyServiceImpl  implements CompanyService {

    final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    @Override
    public Optional<CompanyModel> findById(UUID id) {
        return companyRepository.findById(id);
    }

    @Override
    public boolean existsByCnpj(String cnpj) {
        return companyRepository.existsByCnpj(cnpj);
    }

    @Transactional
    @Override
    public Object save(CompanyModel companyModel) {
        return companyRepository.save(companyModel);
    }

    @Override
    public List<CompanyModel> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<CompanyModel> findByName(String nome_empresa) {
        return companyRepository.findByName(nome_empresa);
    }

    @Override
    public void delete(CompanyModel companyModel) {

    }

    @Override
    public Object updateById(UUID id, CompanyDto companyDto) {
        Optional<CompanyModel> companyModelOptional = findById(id);
        if (companyModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nao temos cadastro dessa empresa para atualizar.");
        }
        var companyModel = companyModelOptional.get();
        companyModel.setNome_empresa(companyDto.getNome_empresa());
        companyModel.setCnpj(companyDto.getCnpj());
        companyModel.setCep(companyDto.getCep());
        return "Cadastro da empresa atualizado";
    }

    @Override
    public Object deleteById(UUID id) {
        Optional<CompanyModel> companyModelOptional = findById(id);
        if (!companyModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cadastro dessa empresa nao existe!");
        }
        delete(companyModelOptional.get());
        return "Cadastro da empresa apagado com sucesso.";
    }
}

