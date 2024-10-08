package com.example.repository;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.JdbcUtil;
import com.example.model.Aluno;

public class AlunosJDBC {

    public static void inserir(Aluno a) throws SQLException{
       
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

    public static List<Aluno> listarTodos() throws SQLException, Exception{
        String sql = "select * from Aluno";
        List< Aluno> alunos = new ArrayList<>();

        try(Connection con = JdbcUtil.getConexao()){
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Aluno a = new Aluno ();
                a.setId(rs.getInt("id"));
	    a.setMatricula(rs.getString(“matricula”));

        
}
