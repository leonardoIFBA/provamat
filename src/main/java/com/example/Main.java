package com.example;

import java.sql.SQLException;

import com.example.model.Aluno;
import com.example.repository.AlunosJPA;

public class Main {
    public static void main(String[] args) throws SQLException {
        
        System.out.println("Prova da primeira Unidade!");
        
        Aluno a = new Aluno();
        a.setMatricula("2024001");
        a.setNome("João");
        a.setResponsavel("Pedro");
        a.setContato("77999310000");
        a.setEmail("joao@mail.com");

        //testando jpa
        AlunosJPA jpa = new AlunosJPA();
        jpa.adicionar(a);

        //testando jdbc
        

        //listando alunos
        System.out.println(jpa.listarTodos());
    }
}