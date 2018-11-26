package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Aluno {

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
}
