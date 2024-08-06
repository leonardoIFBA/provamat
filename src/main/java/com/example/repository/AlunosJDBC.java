package com.example.repository;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.JdbcUtil;
import com.example.model.Aluno;

public class AlunosJDBC {

    public static void inserir(Aluno a) throws SQLException{
        String sql = "insert into Aluno (matricula, nome, responsavel, contato, email)" + "values (?, ?, ?, ?, ?)";
        try(Connection con = JdbcUtil.getConexao()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,a.getMatricula());
            ps.setString(2,a.getNome());
            ps.setString(3,a.getResponsavel());
            ps.setString(4, a.getContato());
            ps.setString(5, a.getEmail());
            
            int resultado = ps.executeUpdate();
            if(resultado > 0){
                System.out.println("Aluno cadastrado com sucesso!!!");
            }
        }catch(Exception e){
            System.out.println("Erro ao inserir um Aluno");
            e.printStackTrace();
        }
    }

    public static void alterar(Aluno a) throws SQLException{
        String sql = "update Aluno set matricula = ?, nome = ?, responsavel = ?, contato = ?, email = ? where id = ?";
        try(Connection con = JdbcUtil.getConexao()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,a.getMatricula());
            ps.setString(2,a.getNome());
            ps.setString(3,a.getResponsavel());
            ps.setString(4, a.getContato());
            ps.setString(5, a.getEmail());
            ps.setLong(6, a.getId());
            
            int resultado = ps.executeUpdate();
            if(resultado > 0){
                System.out.println("Aluno alterado com sucesso!!!");
            }
        }catch(Exception e){
            System.out.println("Erro ao alterar um Aluno");
            e.printStackTrace();
        }
    }
    
    public static void excluir(Long id){
        String sql = "delete from Aluno where id = ?";
        try(Connection con = JdbcUtil.getConexao()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            
            int resultado = ps.executeUpdate();
            if(resultado > 0){
                System.out.println("Aluno excluido com sucesso!!!");
            }
        }catch(Exception e){
            System.out.println("Erro ao excluir um aluno");
            e.printStackTrace();
        }
    }

    public static List<Aluno> listarTodos() throws SQLException, Exception{
        String sql = "select * from Aluno";
        List<Aluno> alunos = new ArrayList<>();

        try(Connection con = JdbcUtil.getConexao()){
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Aluno a = new Aluno();
                a.setId(rs.getLong("Id"));
                a.setMatricula(rs.getString("matricula"));
                a.setNome(rs.getString("nome"));
                alunos.add(a);
            }
        }catch(SQLException e){
            System.out.println("Não foi possível listar os alunos");
            e.printStackTrace();
        }
        return alunos;
    }
}
