package service;

import java.util.List;

import model.Aluno;
import repository.AlunoRepository;

public class AlunoService {
    private AlunoRepository alunoRepository;

    public AlunoService() {
        this.alunoRepository = new AlunoRepository();
    }

    public void salvar(Aluno aluno) {
        alunoRepository.adicionar(aluno);
    }

    public void atualizar(Aluno aluno) {
        alunoRepository.alterar(aluno);
    }

    public void excluir(int id) {
        alunoRepository.excluir(id);
    }

    public Aluno buscarPorId(int id) {
        return alunoRepository.buscarPorId(id);
    }

    public List<Aluno> buscarTodos() {
        return alunoRepository.listarTodos();
    }
}
