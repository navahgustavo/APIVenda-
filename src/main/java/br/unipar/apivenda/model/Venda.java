package br.unipar.apivenda.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column()
    private List<ItensVenda> listaItens;

    @Column(length = 30)
    private BigDecimal total;

    @Column(length = 200)
    private String observacoes;

    @Column(length = 10)
    private Integer idCliente;
}
