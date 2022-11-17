package com.nimitz.repositories;

import org.springframework.stereotype.Repository;
import java.util.List;
import com.nimitz.models.StatusServicoModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StatusServicoRepository extends JpaRepository<StatusServicoModel, UUID>{

    List<StatusServicoModel> findByNomeEstado(String nomeEstado);
}