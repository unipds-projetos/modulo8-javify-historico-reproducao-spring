package br.com.unipds.javify.historicoreproducao.domain;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;
import java.time.LocalDateTime;

@PrimaryKeyClass
public record HistoricoReproducaoChave(

        @PrimaryKeyColumn(name = "usuario_id", type = PrimaryKeyType.PARTITIONED)
        Long usuarioId,

        @PrimaryKeyColumn(name = "data_reproducao", type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
        LocalDateTime dataReproducao

) implements Serializable { }
