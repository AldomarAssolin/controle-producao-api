package online.aldomar.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import online.aldomar.api.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}