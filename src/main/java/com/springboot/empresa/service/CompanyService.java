package com.springboot.empresa.service;

import com.springboot.empresa.domain.model.v1.CompanyModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface CompanyService {


    Optional<CompanyModel> findById(UUID id);

    boolean existsByCnpj(String cnpj);

    Object save(CompanyModel companyModel);

    List<CompanyModel> findAll();

    Optional<CompanyModel> findByName(String nome_empresa);

    void delete(CompanyModel companyModel);
}
