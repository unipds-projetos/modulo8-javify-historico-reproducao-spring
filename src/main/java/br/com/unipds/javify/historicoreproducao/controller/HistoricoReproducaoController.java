package br.com.unipds.javify.historicoreproducao.controller;

import br.com.unipds.javify.historicoreproducao.domain.HistoricoReproducao;
import br.com.unipds.javify.historicoreproducao.domain.HistoricoReproducaoChave;
import br.com.unipds.javify.historicoreproducao.repository.HistoricoReproducaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/analytics/historico")
public class HistoricoReproducaoController {

    private final HistoricoReproducaoRepository repository;

    public HistoricoReproducaoController(HistoricoReproducaoRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/{usuarioId}/tocar/{faixaId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void registrarPlay(
            @PathVariable Long usuarioId,
            @PathVariable String faixaId,
            @RequestParam String nomeFaixa) {

        var chave = new HistoricoReproducaoChave(usuarioId, LocalDateTime.now());
        var registro = new HistoricoReproducao(chave, faixaId, nomeFaixa);
        repository.save(registro);

    }

    @GetMapping("/{usuarioId}")
    public List<HistoricoReproducao> obterHistoricoUsuario(@PathVariable Long usuarioId) {

        return repository.findByChaveUsuarioId(usuarioId);

    }

}