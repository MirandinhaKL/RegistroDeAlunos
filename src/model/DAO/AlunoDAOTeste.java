package model.DAO;

import model.Aluno;

/**
 * @author Mirandinha
 */
public class AlunoDAOTeste {

    public static void main(String[] args) {

//================ Validação do método adiciona aluno no BD. ================
//        AlunoDAO conexaoBDAluno = new AlunoDAO();
//        Aluno novoAluno = new Aluno();
//        novoAluno.setNome("Karine");
//        novoAluno.setSobreNome("Miranda");
//        novoAluno.setIdAluno(0);
//        if (conexaoBDAluno.adicionaAluno(novoAluno)) {
//            System.out.println("Aluno adicionado com sucesso.");
//        } else {
//            System.out.println("Aluno NÃO adicionado");
//        }
//================ Validação do método atualiza aluno no BD. ================

        AlunoDAO conexaoBDAluno = new AlunoDAO();
        Aluno alunoExistente = new Aluno();
        alunoExistente.setIdAluno(3);
        alunoExistente.setNome("Vania");
        alunoExistente.setSobreNome("Vieira");
        if (conexaoBDAluno.atualizaAlunos(alunoExistente)) {
             System.out.println("Aluno atualizado com sucesso.");
        } else {
            System.out.println("Aluno NÃO atualizado!");
        }
    }
}
