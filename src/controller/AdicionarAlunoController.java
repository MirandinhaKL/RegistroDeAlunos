package controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Aluno;
import model.DAO.AlunoDAO;

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
        AlunoDAO  alunoDao = new AlunoDAO();
        aluno.setNome(campoTextoNome.getText());
        aluno.setSobreNome(campoTextoSobreNome.getText());
        alunoDao.adicionaAluno(aluno);
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
