/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import application.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import model.Aluno;

public class PrincipalController {

    @FXML
    private TableView<Aluno> tabela;

    @FXML
    private TableColumn<Aluno, String> colunaNome;

    @FXML
    private TableColumn<Aluno, String> colunaSobrenome;

    @FXML
    private Label labelNome;

    @FXML
    private Label labelSobrenome;

    @FXML
    private Label labelEmail;

    @FXML
    private Label labelCurso;

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnDeletar;

    private ObservableList<Aluno> alunos = FXCollections.observableArrayList();

    private Main main;

    @FXML
    private void initialize() {

        //		setando a lista alunos na tabela
        tabela.setItems(alunos);

        // Inicializa a tabela de pessoas com duas colunas.
        colunaNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
        colunaNome.setCellFactory(TextFieldTableCell.forTableColumn());

        colunaSobrenome.setCellValueFactory(cellData -> cellData.getValue().sobreNomeProperty());
        colunaSobrenome.setCellFactory(TextFieldTableCell.forTableColumn());

        // Detecta mudanÃ§as de seleÃ§Ã£o e mostra os detalhes da pessoa quando houver mudanÃ§a.
        tabela.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> mostraDetalhes(newValue));

    }

    private void mostraDetalhes(Aluno newValue) {

        labelNome.setText(newValue.getNome());
        //		labelNome.setTextFill(Color.RED);
        labelSobrenome.setText(newValue.getSobreNome());
        labelEmail.setText(newValue.getEmail());
        labelCurso.setText(newValue.getCurso());

    }

    @FXML
    void handleBtnAdicionar(ActionEvent event) {
        Aluno alunoTemp = new Aluno();
        main.mostraTelaAdicionarAluno(alunoTemp);
        tabela.getItems().add(alunoTemp);
    }

    @FXML
    void handleBtnEditarAluno(ActionEvent event) {
        Aluno alunoSelecionado = tabela.getSelectionModel().getSelectedItem();
        if (alunoSelecionado == null) {
            String titulo = "Sem SeleÃ§Ã£o";
            String cabecalho = "Nenhum aluno selecionado.";
            String mensagem = "Por favor, selecione um aluno";
            main.mostraAlert(AlertType.WARNING, titulo, cabecalho, mensagem);
        } else {
            main.mostraTelaEditarAluno(alunoSelecionado);
        }
    }

    @FXML
    void handleBtnExcluirAluno(ActionEvent event) {

        int item = tabela.getSelectionModel().getSelectedIndex();

        if (item >= 0) {
            tabela.getItems().remove(item);
        } else {
            String titulo = "Sem SeleÃ§Ã£o";
            String cabecalho = "Nenhum aluno selecionado.";
            String mensagem = "Por favor, selecione um aluno";

            main.mostraAlert(AlertType.WARNING, titulo, cabecalho, mensagem);
        }
    }

    // mÃ©todo que altera a cÃ©lula editÃ¡vel
    @FXML
    void handleCellNomeEditar(CellEditEvent<Aluno, String> t) {
        ((Aluno) t.getTableView().getItems().get(
                t.getTablePosition().getRow())).setNome(t.getNewValue());
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
