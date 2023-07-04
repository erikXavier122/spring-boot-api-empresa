package com.springboot.empresa.domain.repository.v1;

import com.springboot.empresa.domain.main.v1.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyModel, UUID> {


    boolean existsByCnpj(String cnpj);

    @Query(value="SELECT * FROM tb_empresa WHERE nome_empresa = ?1", nativeQuery = true)
    Optional<CompanyModel> findByName(String nome_empresa);
}
