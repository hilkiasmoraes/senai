package com.escola.senai.service;
import com.escola.senai.model.Aluno;

import com.escola.senai.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    //Metodo para cadastrar aluno
    public Aluno salvarAluno(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    //Metodo para buscar todos alunos
    public List<Aluno> buscarTodosAlunos(){
        return alunoRepository.findAll();
    }

    //Metodo para buscar alunos apenas pelo ID
    public Optional<Aluno> buscarAlunosPorId(Long id){
        return alunoRepository.findById(id);
    }

    // Atualizar um novo aluno
    public Aluno atualizarAluno(Long id , Aluno alunoAtualizado) {
        return alunoRepository.findById(id)
                .map(aluno -> {
                    aluno.setNomeAluno(alunoAtualizado.getNomeAluno());
                    aluno.setMatriculaAluno(alunoAtualizado.getMatriculaAluno());
                    aluno.setIdadeAluno(alunoAtualizado.getIdadeAluno());
                    return alunoRepository.save(aluno);
                })
        .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + id));
    }

    //Metodo para deletar um aluno
    public void deletarAluno(Long id){
        return alunoRepository.deleteById(id);
    }
}