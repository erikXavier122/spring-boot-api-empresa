package com.springboot.empresa.service;

import com.springboot.empresa.domain.model.v1.CompanyModel;
import com.springboot.empresa.dto.v1.CompanyDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface CompanyService {


    Optional<CompanyModel> findById(UUID id);

    boolean existsByCnpj(String cnpj);

    Object save(CompanyModel companyModel);

    List<CompanyModel> findAll();

    Optional<CompanyModel> findByName(String nome_empresa);

    Optional<CompanyModel> findByCnpj(String cnpj);

    void delete(CompanyModel companyModel);

    Object updateById(UUID id, CompanyDto companyDto);

    Object deleteById(UUID id);

    Object deleteByNome_empresa(String nome_empresa);

    Object deleteByCnpj(String cnpj);

    Object updateByCnpj(String cnpj, CompanyDto companyDto);

    Object updateByName(String nomeEmpresa, CompanyDto companyDto);
}
