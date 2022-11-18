package com.nimitz.repositories;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.nimitz.dtos.StatusServicoDto;
import com.nimitz.models.StatusServicoModel;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface StatusServicoRepository extends JpaRepository<StatusServicoModel, UUID> {  

  List<Optional<StatusServicoModel>> findByNomeEstado(String nomeEstado);

  List<Optional<StatusServicoModel>> findByAutorizacao(String autorizacao);

  @Query("select s from StatusServicoModel s where s.dataVerificacao like %:dataVerificacao%")
  List<Optional<StatusServicoModel>> findByDataVerificacao(@Param("dataVerificacao") String dataVerificacao);
}