package com.dev.exemplo1.aluno.service;

import com.dev.exemplo1.aluno.entity.Aluno;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlunoServico {

    private final List<Aluno> listaDeAlunos = new ArrayList<>();

    public List<Aluno> obterTodos(){
        return listaDeAlunos;
    }

    public Aluno inserir(Aluno aluno){
        listaDeAlunos.add(aluno);
        return aluno;
    }

    public Aluno atualizar(int matricula, Aluno novosDadosAluno){
        Aluno aluno = selecionarAlunoPelaMatricula(matricula);

        if (aluno != null){
            BeanUtils.copyProperties(novosDadosAluno, aluno);
        }
        return aluno;
    }

    public void remove(int matricula){
        Aluno aluno = selecionarAlunoPelaMatricula(matricula);

        if (aluno != null){
            listaDeAlunos.remove(aluno);
        }
    }

    public Aluno selecionarAlunoPelaMatricula(int matricula){
        for(Aluno aluno : listaDeAlunos){
            if(aluno.getMatricula() == matricula){
                return aluno;
            }
        }
        return null;
    }
}
