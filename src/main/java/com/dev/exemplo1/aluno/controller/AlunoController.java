package com.dev.exemplo1.aluno.controller;

import com.dev.exemplo1.aluno.entity.Aluno;
import com.dev.exemplo1.aluno.service.AlunoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {
    @Autowired
    AlunoServico alunoServico;

    @GetMapping
    public List<Aluno> obterTodos(){
        return alunoServico.obterTodos();
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<Aluno> obterAlunoPelaMatricula(@PathVariable int matricula){
        Aluno aluno = alunoServico.selecionarAlunoPelaMatricula(matricula);

        if (aluno == null){
           return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(aluno);

    }

    @PostMapping
    public ResponseEntity<Aluno> inserir(@RequestBody Aluno aluno){
        alunoServico.inserir(aluno);

        return  ResponseEntity.created(null).body(aluno);
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<Aluno> actualizar(@RequestBody Aluno novosDadosAluno, @PathVariable int matricula){
        Aluno aluno = alunoServico.selecionarAlunoPelaMatricula(matricula);


            if (aluno == null){
                return ResponseEntity.notFound().build();
            }

            alunoServico.atualizar(matricula, novosDadosAluno);
            return ResponseEntity.ok().body(aluno);
    }

    @PatchMapping("/{matricula}")
    public ResponseEntity<Aluno> actualizarUm(@RequestParam("bi") String bi , @PathVariable int matricula){
        Aluno aluno = alunoServico.selecionarAlunoPelaMatricula(matricula);

        if (aluno == null){
            return  ResponseEntity.notFound().build();
        }

        aluno.setBi(bi);

        alunoServico.atualizar(matricula, aluno);

        return ResponseEntity.ok().body(aluno);
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<Aluno> deletaAluno(@PathVariable int matricula){
        Aluno aluno = alunoServico.selecionarAlunoPelaMatricula(matricula);

        if (aluno == null){
            return  ResponseEntity.notFound().build();
        }

        alunoServico.remove(matricula);

        return ResponseEntity.ok().body(null);
    }

}
