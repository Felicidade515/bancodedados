package com.dev.exemplo1.escola.service;

import com.dev.exemplo1.escola.entity.Escola;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EscolaServico {

    private final List<Escola>  listaDeEscolas = new ArrayList<>();

    public List<Escola>  obterTodas(){return listaDeEscolas;}

    public Escola inserir(Escola escola){
        listaDeEscolas.add(escola);
        return escola;
    }

    public Escola atualizar(int id, Escola novosDadosEscola){
        Escola escola = selecionarEscolaPeloId(id);

        if(escola != null){
            BeanUtils.copyProperties(novosDadosEscola, escola);
        }
        return  escola;
    }

    public void remove(int id){
        Escola escola = selecionarEscolaPeloId(id);

        if (escola != null){
            listaDeEscolas.remove(escola);
        }
    }

    public Escola selecionarEscolaPeloId(int id){
        for (Escola escola : listaDeEscolas){
            if(escola.getId() == id){
                return escola;
            }
        }
        return null;
    }
}
