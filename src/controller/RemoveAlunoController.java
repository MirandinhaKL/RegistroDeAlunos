package controller;

import application.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Aluno;
import model.DAO.AlunoDAO;

public class RemoveAlunoController implements Initializable {

    @FXML
    private TextField textFieldNome;
    @FXML
    private TextField textFieldSobrenome;

    private Main main;
    private Stage stage;
    private Aluno alunoAremover;

    @FXML
    void handleButtonRemover(ActionEvent event) {
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.removeAluno(alunoAremover);
        main.mostraTelaPrincipal();
    }

    @FXML
    void handleButtonVoltar(ActionEvent event) {
        main.mostraTelaPrincipal();;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void setAluno (Aluno alunoTelaPrincipal){
        alunoAremover = alunoTelaPrincipal;
        textFieldNome.setText(alunoAremover.getNome());
        textFieldSobrenome.setText(alunoAremover.getSobreNome());
    }
    
    public void setStage(Stage stageDialogo) {
        this.stage = stageDialogo;
    }

    public void setMain(Main main) {
        this.main = main;
    }

}
