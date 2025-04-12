package com.escola.senai.service;
import com.escola.senai.model.Professor;

import com.escola.senai.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    //Metodo para cadastrar professor
    public Professor salvarProfessor(Professor professor){
        return professorRepository.save(professor);
    }

    //Metodo para buscar todos professores
    public List<Professor> buscarTodosProfessores(){
        return professorRepository.findAll();
    }

    //Metodo para buscar professores apenas pelo ID
    public Optional<Professor> buscarProfessoresPorId(Long id){
        return professorRepository.findById(id);
    }

    // Atualizar professor
    public Professor atualizarProfessor(Long id , Professor professorAtualizado) {
        return professorRepository.findById(id)
                .map(professor -> {
                    professor.setNomeProfessor(professorAtualizado.getNomeProfessor());
                    professor.setDisciplinaProfessor(professorAtualizado.getDisciplinaProfessor());
                    return professorRepository.save(professor);
                })
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com o ID: " + id));
    }

    //Metodo para deletar um professor
    public void deletarProfessor(Long id){
        return professorRepository.deleteById(id);
    }
}