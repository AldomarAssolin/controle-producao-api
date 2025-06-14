package online.aldomar.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import online.aldomar.api.model.NaoConformidade;

public interface NaoConformidadeRepository extends JpaRepository<NaoConformidade, Long> {
}

