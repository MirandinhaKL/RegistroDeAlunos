package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
     * @param alunoRetornado - Atributos nome e sobrenome atualizados.
     * @return boolean - Verdadeiro se o aluno foi atualizado com sucesso.
     */
    public boolean atualizaAlunos(Aluno alunoRetornado) {
        String sql = "UPDATE alunos SET nome = ?, sobrenome = ? WHERE id =?;";
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            declaracao.setString(1, alunoRetornado.getNome());
            declaracao.setString(2, alunoRetornado.getSobreNome());
            declaracao.execute();
            declaracao.close();
            conexao.close();
            return true;
        } catch (Exception excecao) {
            excecao.getMessage();
            return false;
        }
    }
}
