package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import util.Conexao;

public class AlunoRepository {
    public void adicionar(Aluno a){
        String sql = "insert into Aluno (matricula, nome, responsavel, contato, email) values (?, ?, ?, ?, ?)";
        try(Connection con = Conexao.getConexao()){
            
        }catch(SQLException e){
            System.out.println("Erro ao adicionar um Aluno");
            e.printStackTrace();
        } 
    }

    public void alterar(Aluno a){
        String sql = "update Aluno set matricula = ?, nome = ?, responsavel = ?, contato = ?, email = ? where id = ?";
        try(Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(sql)){    
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
        }catch(SQLException e){
            System.out.println("Erro ao alterar um Aluno");
            e.printStackTrace();
        }
    }

    public void excluir(int id){
        
    }

    public List<Aluno> listarTodos(){
        String sql = "select * from Aluno";
        List< Aluno> alunos = new ArrayList<>();
        
        return alunos;
    }

    public Aluno buscarPorId(int id) {
        Aluno a = new Aluno();
        String sql = "SELECT * FROM aluno where id = ?";

        try (Connection con = Conexao.getConexao()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a.setId(rs.getInt("id"));
                a.setMatricula(rs.getString("matricula"));
                a.setNome(rs.getString("nome"));
                a.setResponsavel(rs.getString("responsavel"));
                a.setContato(rs.getString("contato"));
                a.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }
}
