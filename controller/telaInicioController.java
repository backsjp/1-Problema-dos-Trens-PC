/*******************************************************************************************************
* Autor: João Pedro Serra de Souza
* Matricula: 202510603
* Inicio: 22/03/2026
* Ultima alteracao: 29/03/2026
* Nome: telaInicioController
* Descricao: Essa classe controla a tela inicial do projeto e eh responsavel pela posicao inicial dos
* carros e pela troca de telas
******************************************************************************************************* */

package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;

public class telaInicioController {

  @FXML
  private Button buttonStart;

  @FXML
  private ComboBox<String> boxSelect;

  @FXML
  private Button buttonSair01;

  @FXML
  public void initialize() {
    boxSelect.getItems().addAll("Superior Esquerdo / Inferior Esquerdo", "Superior Direito / Inferior Direito","Superior Esquerdo / Inferior Direito", "Superior Direito / Inferior Esquerdo");

    buttonStart.setOnAction(this::iniciarSimulacao);

    buttonSair01.setOnAction(this::fecharTela);
  }

  @FXML
  private void iniciarSimulacao (ActionEvent event) {

    try {
      String escolha = boxSelect.getValue();
      if (escolha == null){
        exibirAlerta("Escolha uma opcao", "Por favor, selecione uma opcao para poder continuar!");
        return;
      }

      FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/telaCorrida.fxml"));
      Parent root = loader.load();
      Stage stage = new Stage();
      stage.setScene(new Scene(root));
      stage.show();

      telaCorridaController corridaController = loader.getController();
      corridaController.receberPosicaoInicial(escolha);

      fecharTela(event);

    } catch (IOException e) {
      System.err.println("Erro ao carregar telaCorrida.fxml" + e.getMessage());
      e.printStackTrace();
    }
  }

  private void exibirAlerta(String titulo, String mensagem) {
    Alert alerta = new Alert(Alert.AlertType.WARNING);
    alerta.setTitle(titulo);
    alerta.setHeaderText(null);
    alerta.setContentText(mensagem);
    alerta.showAndWait();
  }

  private void fecharTela(ActionEvent event) {
    Stage stage = (Stage) buttonSair01.getScene().getWindow();
    stage.close();
  }

}
