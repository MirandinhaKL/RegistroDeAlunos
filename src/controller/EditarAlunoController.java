package controller;

import application.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Aluno;

public class EditarAlunoController {

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
        this.stage.close();
    }

    @FXML
    void handleBtnOk(ActionEvent event) {
        aluno.setNome(campoTextoNome.getText());
        aluno.setSobreNome(campoTextoSobreNome.getText());
        stage.close();
    }

    public void setAluno(Aluno alunoSelecionado) {
        aluno = alunoSelecionado;
        campoTextoNome.setText(aluno.getNome());
        campoTextoSobreNome.setText(aluno.getSobreNome());
    }

    public void setStage(Stage stageDialogo) {
        this.stage = stageDialogo;
    }
    
     public void setMain(Main main) {
        this.main = main;
    }
}
