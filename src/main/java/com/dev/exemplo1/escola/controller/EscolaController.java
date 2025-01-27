package com.dev.exemplo1.escola.controller;

import com.dev.exemplo1.escola.entity.Escola;
import com.dev.exemplo1.escola.service.EscolaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/escola")
public class EscolaController {

    @Autowired
    EscolaServico escolaServico;

    @GetMapping
    public List<Escola> obterTodas(){return escolaServico.obterTodas();}

    @GetMapping("/{id}")
    public ResponseEntity<Escola> obterEscolaPelId(@PathVariable int id){
        Escola escola = escolaServico.selecionarEscolaPeloId(id);

        if (escola == null){
            return ResponseEntity.notFound().build();
        }

        return  ResponseEntity.ok().body(escola);
    }

    @PostMapping
    public ResponseEntity<Escola> inserir(@RequestBody Escola escola){
        escolaServico.inserir(escola);

        return  ResponseEntity.created(null).body(escola);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Escola> atualizar (@RequestBody Escola novosDadosEscola, @PathVariable int id){
        Escola escola = escolaServico.selecionarEscolaPeloId(id);

        if (escola == null){
            return ResponseEntity.notFound().build();
        }
        escolaServico.atualizar(id, novosDadosEscola);
        return ResponseEntity.ok().body(escola);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Escola> atualizarUma(@RequestParam("idEscola") int idEscola, @PathVariable int id){
        Escola escola = escolaServico.selecionarEscolaPeloId(id);

        if (escola == null){
            return ResponseEntity.notFound().build();
        }

        escola.setIdEscola(idEscola);

        escolaServico.atualizar(id, escola);

        return ResponseEntity.ok().body(escola);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Escola> detetarEscola(@PathVariable int id){
        Escola escola = escolaServico.selecionarEscolaPeloId(id);

        if (escola == null){
            return ResponseEntity.notFound().build();
        }

        escolaServico.remove(id);

        return ResponseEntity.ok().body(null);
    }
}
