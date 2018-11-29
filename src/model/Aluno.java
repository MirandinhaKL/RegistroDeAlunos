package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Aluno {
    
    private int idAluno;
    private StringProperty nome;
    private StringProperty sobreNome;
    private StringProperty email;
    private StringProperty curso;

    public Aluno(String nome, String snome) {
        this.nome = new SimpleStringProperty(nome);
        this.sobreNome = new SimpleStringProperty(snome);
        this.email = new SimpleStringProperty("teste@teste.com");
        this.curso = new SimpleStringProperty("ADS");
    }

    public Aluno() {
        this(null, null);
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }
    
    

    public StringProperty nomeProperty() {
        return nome;
    }

    public String getNome() {
        return nome.get();
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public StringProperty sobreNomeProperty() {
        return sobreNome;
    }

    public String getSobreNome() {
        return sobreNome.get();
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome.set(sobreNome);
    }

    public String getEmail() {
        return email.get();
    }

    public String getCurso() {
        return curso.get();
    }
    
    public void exibeDadosDoAluno(){
        System.out.println("=========== Dados do Aluno: ===========");
        System.out.println("ID = " + getIdAluno());
        System.out.println("Nome = " + getNome());
        System.out.println("Sobrenome = " + getSobreNome());
    }
}
