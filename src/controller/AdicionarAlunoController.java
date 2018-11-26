package controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Aluno;

public class AdicionarAlunoController {

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnOk;

    @FXML
    private TextField campoTextoNome;

    @FXML
    private TextField campoTextoSobreNome;

    private Aluno aluno;
    private Stage stage;
    private Main main;
    
    @FXML
    void handleBtnCancelar(ActionEvent event) {
      main.mostraTelaPrincipal();
    }

    @FXML
    void handleBtnOk(ActionEvent event) {
        aluno.setNome(campoTextoNome.getText());
        aluno.setSobreNome(campoTextoSobreNome.getText());
        main.mostraTelaPrincipal();
    }

    public void setAluno(Aluno alunoSelecionado) {
        aluno = alunoSelecionado;
    }

    public void setStage(Stage stageDialogo) {
        this.stage = stageDialogo;
    }
    
       public void setMain(Main main) {
        this.main = main;
    }
}
