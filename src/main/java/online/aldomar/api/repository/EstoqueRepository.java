package online.aldomar.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import online.aldomar.api.model.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}

