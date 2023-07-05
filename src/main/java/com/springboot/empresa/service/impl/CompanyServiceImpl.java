package com.springboot.empresa.service.impl;

import com.springboot.empresa.domain.model.v1.CompanyModel;
import com.springboot.empresa.domain.repository.v1.CompanyRepository;
import com.springboot.empresa.service.CompanyService;
import jakarta.transaction.Transactional;
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
}

