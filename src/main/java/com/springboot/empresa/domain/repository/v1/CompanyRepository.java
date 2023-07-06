package com.springboot.empresa.domain.repository.v1;

import com.springboot.empresa.domain.model.v1.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyModel, UUID> {


    boolean existsByCnpj(String cnpj);

    @Query(value="SELECT * FROM tb_empresa WHERE nome_empresa = ?1", nativeQuery = true)
    Optional<CompanyModel> findByName(String nome_empresa);


    @Query(value = "SELECT * FROM tb_empresa WHERE cnpj = ?1",nativeQuery = true)
    Optional<CompanyModel> findByCnpj(String cnpj);

    @Modifying
    @Query(value = "UPDATE tb_empresa SET cnpj = ?1, cep= ?2,nome_empresa = ?3 WHERE cnpj = ?1",nativeQuery = true )
    void updateByCnpj(String cnpj, String cep, String nomeEmpresa);

    @Modifying
    @Query(value = "UPDATE tb_empresa SET nome_empresa = ?1, cnpj= ?2,cep = ?3 WHERE nome_empresa = ?1",nativeQuery = true)
    void updateByName(String nome_empresa, String cnpj, String cep);
}
