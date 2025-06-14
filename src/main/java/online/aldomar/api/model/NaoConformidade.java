package online.aldomar.api.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "nao_conformidade")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NaoConformidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "etapa_id", nullable = false)
    private EtapaProducao etapa;

    @ManyToOne
    @JoinColumn(name = "operador_id", nullable = false)
    private Operador operador;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String descricao;

    @Column(name = "data_registro", nullable = false)
    private LocalDateTime dataRegistro = LocalDateTime.now();
}
