package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Aluno;
import model.conexao.ConexaoBancoDeDados;

/**
 * @author Mirandinha
 */
public class AlunoDAO {

    private static Connection conexao;

    /**
     * Construtor que cria a conexão com o banco de dados.
     */
    public AlunoDAO() {
        this.conexao = new ConexaoBancoDeDados().getConexao();
    }

    /**
     * Adiciona um novo aluno ao BD.
     *
     * @param novoAluno - Atributos nome e sobrenome configurados.
     * @return boolean - Verdadeiro se o aluno foi adicionada com sucesso.
     */
    public boolean adicionaAluno(Aluno novoAluno) {
        String sql = "INSERT INTO alunos (nome, sobrenome) VALUES (?,?);";
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            declaracao.setString(1, novoAluno.getNome());
            declaracao.setString(2, novoAluno.getSobreNome());
            declaracao.execute();
            declaracao.close();
            conexao.close();
            return true;
        } catch (SQLException excecao) {
            System.out.println(excecao.getMessage());
            excecao.getMessage();
            return false;
        }
    }

    /**
     * Atualiza um aluno existente no banco.
     *
     * @param alunoRetornado - Atributos nome e sobrenome atualizados.
     * @return boolean - Verdadeiro se o aluno foi atualizado com sucesso.
     */
    public boolean atualizaAlunos(Aluno alunoRetornado) {
        String sql = "UPDATE alunos SET nome = ?, sobrenome = ? WHERE id =?;";
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            declaracao.setString(1, alunoRetornado.getNome());
            declaracao.setString(2, alunoRetornado.getSobreNome());
            declaracao.setInt(3, alunoRetornado.getIdAluno());
            declaracao.execute();
            declaracao.close();
            conexao.close();
            return true;
        } catch (Exception excecao) {
            System.out.println(excecao.getMessage());
            return false;
        }
    }

    /**
     * Remove um aluno existente no banco.
     *
     * @param alunoAremover - Informar o id do aluno a ser removido.
     * @return boolean - Verdadeiro se o aluno foi removido com sucesso.
     */
    public boolean removeAluno(Aluno alunoAremover) {
        String sql = "DELETE FROM alunos WHERE id = ?;";
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            declaracao.setInt(1, alunoAremover.getIdAluno());
            declaracao.execute();
            declaracao.close();
            conexao.close();
            return true;
        } catch (Exception excecao) {
            System.out.println(excecao.getMessage());
            return false;
        }
    }

    /**
     * Remove todos os itens da tabela alunos.
     *
     * @return boolean - Verdadeiro se todos os dados da tabela aluno forem
     * apagados,
     */
    public boolean removeTodosOsAlunos() {
        String sql = "DELETE FROM alunos;";
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            declaracao.execute();
            declaracao.close();
            conexao.close();
            return true;
        } catch (SQLException excecao) {
            System.out.println(excecao.getMessage());
            return false;
        }
    }

    /**
     * Retorna todos os alunos cadastrados no BD alunos.
     *
     * @return List<Aluno> - Retorna uma lista contendo todos os alunos
     * cadastrado no BD.
     */
    public List<Aluno> retornaTodosOsAlunos() {
        List<Aluno> listaDeAlunos = new ArrayList<>();
        String sql = "SELECT * FROM alunos;";
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            ResultSet consultaBD = declaracao.executeQuery();
            while (consultaBD.next()) {
                Aluno alunoRetornado = new Aluno();
                alunoRetornado.setIdAluno(consultaBD.getInt("id"));
                alunoRetornado.setNome(consultaBD.getString("nome"));
                alunoRetornado.setSobreNome(consultaBD.getString("sobrenome"));
                listaDeAlunos.add(alunoRetornado);
            }
            declaracao.close();
            consultaBD.close();;
            conexao.close();
        } catch (SQLException excecao) {
            System.out.println(excecao.getMessage());
            System.out.println("Lista NÃO retornada");
            return null;
        }
        return listaDeAlunos;
    }

    public Aluno retornaUmAluno(Aluno aluno) {
        String sql = "SELECT * FROM alunos WHERE id = ?;";
        Aluno alunoAretornar = new Aluno();
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            declaracao.setInt(1, aluno.getIdAluno());
            ResultSet consultaBD = declaracao.executeQuery();
            if (consultaBD.next()) {
                alunoAretornar.setNome(consultaBD.getString("nome"));
                alunoAretornar.setSobreNome(consultaBD.getString("sobrenome"));
                alunoAretornar.setIdAluno(consultaBD.getInt("id"));
            }
        } catch (Exception excecao) {
            excecao.getMessage();
        }
        return alunoAretornar;
    }
}
