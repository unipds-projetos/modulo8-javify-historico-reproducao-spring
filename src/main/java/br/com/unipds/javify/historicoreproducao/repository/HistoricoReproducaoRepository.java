package br.com.unipds.javify.historicoreproducao.repository;

import br.com.unipds.javify.historicoreproducao.domain.HistoricoReproducao;
import br.com.unipds.javify.historicoreproducao.domain.HistoricoReproducaoChave;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

public interface HistoricoReproducaoRepository extends CassandraRepository<HistoricoReproducao, HistoricoReproducaoChave> {

    List<HistoricoReproducao> findByChaveUsuarioId(Long usuarioId);
}
