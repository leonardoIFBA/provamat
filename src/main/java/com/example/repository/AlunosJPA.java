package com.example.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.example.JpaUtil;
import com.example.model.Aluno;

public class AlunosJPA {
    private EntityManager manager;

    public AlunosJPA() {
        this.manager = JpaUtil.getEntityManager(); 
    }

    public void adicionar(Aluno a){
        EntityTransaction et = manager.getTransaction();
        et.begin();
        manager.persist(a);
        et.commit();
    }
    
    public void atualizar(Aluno a){
        EntityTransaction et = manager.getTransaction();
        et.begin();
        manager.merge(a);
        et.commit();
    }

    public void remover(Aluno a){
        EntityTransaction et = manager.getTransaction();
        et.begin();
        manager.remove(a);
        et.commit();
    }

    public List<Aluno> listarTodos(){
        TypedQuery<Aluno> query = manager.createQuery("from Aluno", Aluno.class);
        return query.getResultList();
    }
    
    public Aluno porId(Long id){
        return manager.find(Aluno.class, id);
    }
}
