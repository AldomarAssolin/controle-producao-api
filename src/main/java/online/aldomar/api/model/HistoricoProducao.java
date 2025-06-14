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
@Table(name = "historico_producao")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoricoProducao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ordem_id", nullable = false)
    private OrdemProducao ordem;

    @Column(name = "status_anterior", nullable = false, length = 20)
    private String statusAnterior;

    @Column(name = "status_novo", nullable = false, length = 20)
    private String statusNovo;

    @Column(name = "data_alteracao", nullable = false)
    private LocalDateTime dataAlteracao = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "alterado_por")
    private Operador alteradoPor;
}
