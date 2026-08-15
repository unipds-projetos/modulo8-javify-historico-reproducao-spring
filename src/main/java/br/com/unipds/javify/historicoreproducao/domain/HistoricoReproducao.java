package br.com.unipds.javify.historicoreproducao.domain;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("historico_reproducao")
public record HistoricoReproducao (
         @PrimaryKey HistoricoReproducaoChave chave,
         @Column("faixa_id") String faixaId,
         @Column("nome_faixa") String nomeFaixa
) {  }
