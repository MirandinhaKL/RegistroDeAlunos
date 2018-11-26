package application;

import controller.AdicionarAlunoController;
import controller.EditarAlunoController;
import controller.PrincipalController;
import controller.RootController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Aluno;

public class Main extends Application {

    private BorderPane root;
    private Stage primaryStage;
    private PrincipalController principalController;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Registro de Alunos");
        iniciaRootLayout();
        mostraTelaPrincipal();
    }

    public void iniciaRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/Root.fxml"));
            root = (BorderPane) loader.load();
            RootController controller = loader.getController();
            /*
            As duas linhas abaixo foram adicionadas para permitir que as telas
            abram no mesmo stage.
             */
            controller.setMain(this);
            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostraTelaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/Principal.fxml"));
            AnchorPane principal = (AnchorPane) loader.load();
            root.setCenter(principal);
            PrincipalController controller = loader.getController();
            controller.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Mostra tela editado - a cena abre no mesmo stage.
    public void mostraTelaEditarAluno(Aluno alunoSelecionado) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/EditarAluno.fxml"));
            GridPane tela = (GridPane) loader.load();
            root.setCenter(tela);

            /* As linhas comentadas abaixo, fazem com que não seja criado um 
            novo stage e nem uma nova cena. Isto porque, a tela editar aluno,
            agora será aberta diretamente na cena root.
             */
//            Stage stageDialogo = new Stage();
//            stageDialogo.setTitle("Editar Aluno");
//            stageDialogo.initModality(Modality.WINDOW_MODAL);
//            stageDialogo.initOwner(primaryStage);
//            Scene scene = new Scene(tela);
//            stageDialogo.setScene(scene);
            EditarAlunoController controller = loader.getController();
            controller.setMain(this);
            controller.setAluno(alunoSelecionado); // linha adicionada.

            /* As linhas comentadas abaixo, não são mais necessária. Isto porque,
            a tela editar aluno,agora será aberta diretamente na cena root.
             */
//            controller.setStage(stageDialogo);
//            stageDialogo.showAndWait();
        } catch (IOException e) {
            e.getMessage();
        }
    }

      // Mostra tela original - a cena abre em outro stage.
    
//    public void mostraTelaEditarAluno(Aluno alunoSelecionado) {
//        try {
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(Main.class.getResource("../view/EditarAluno.fxml"));
//            GridPane tela = (GridPane) loader.load();
//            Stage stageDialogo = new Stage();
//            stageDialogo.setTitle("Editar Aluno");
//            stageDialogo.initModality(Modality.WINDOW_MODAL);
//            stageDialogo.initOwner(primaryStage);
//            Scene scene = new Scene(tela);
//            stageDialogo.setScene(scene);
//            EditarAlunoController controller = loader.getController();
//            controller.setAluno(alunoSelecionado);
//            controller.setStage(stageDialogo);
//            stageDialogo.showAndWait();
//        } catch (IOException e) {
//            e.getMessage();
//        }
//    }

    public void mostraTelaAdicionarAluno(Aluno alunoTemporario) {
        try {
            /*
            As mesmas alterações feitas em editar aluno, foram feitas em adicio-
            nar aluno. O objetivo é que a tela abra no mesmo stage.
             */
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/AdicionarAluno.fxml"));
            GridPane tela = (GridPane) loader.load();
            root.setCenter(tela);
//            Stage stageDialogo = new Stage();
//            stageDialogo.setTitle("Adicionar Aluno");
//            stageDialogo.initModality(Modality.WINDOW_MODAL);
//            stageDialogo.initOwner(primaryStage);
//            Scene scene = new Scene(tela);
//            stageDialogo.setScene(scene);
            AdicionarAlunoController controller = loader.getController();
            controller.setMain(this);
            controller.setAluno(alunoTemporario);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void mostraAlert(AlertType tipoAlert, String titulo, String cabecalho, String mensagem) {
        Alert alert = new Alert(tipoAlert);
        alert.initOwner(this.getPrimaryStage());
        alert.setTitle(titulo);
        alert.setHeaderText(cabecalho);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public Stage getPrimaryStage() {
        return this.primaryStage;
    }
    
    public PrincipalController getPrincipalController(){
        return this.principalController;
    }
}
