/*******************************************************************************************************
* Autor: João Pedro Serra de Souza
* Matricula: 202510603
* Inicio: 22/03/2026
* Ultima alteracao: 29/03/2026
* Nome: telaCorridaController
* Descricao: Essa classe controla a simulacao, controla a velocidade e instancia o objeto carro
******************************************************************************************************* */

package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.control.Slider;
import model.Carro;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class telaCorridaController {

  @FXML
  private ImageView imageCarro01;

  @FXML
  private ImageView imageCarro02;

  @FXML
  private Slider sliderVelocidade01;

  @FXML
  private Slider sliderVelocidade02;

  @FXML
  private Button buttonReset;

  @FXML
  private Button buttonVoltar;

  @FXML
  private ComboBox<String> boxSelect02;

  @FXML
  private Button buttonSair02;

  Carro carro01;
  Carro carro02;
  private String posicaoInicial;

  private Scene cena;
  private Stage janela;

  public void initialize() {

    boxSelect02.getItems().addAll("Superior Esquerdo / Inferior Esquerdo", "Superior Direito / Inferior Direito","Superior Esquerdo / Inferior Direito", "Superior Direito / Inferior Esquerdo");

    boxSelect02.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
      if (newValue != null) {

        configurarPosicaoCarro(newValue);

        carro01.iniciarCorrida();
        carro02.iniciarCorrida();
      }
    });

    buttonVoltar.setOnAction(this::voltarTela);

    buttonReset.setOnAction(this::resetarSimulacao);

    buttonSair02.setOnAction(this::fecharTela);

    sliderVelocidade01.setMin(0);
    sliderVelocidade01.setMax(5);
    sliderVelocidade01.setValue(1);
    sliderVelocidade01.valueProperty().addListener((obs, oldVal, newVal) -> {
    });

    sliderVelocidade02.setMin(0);
    sliderVelocidade02.setMax(5);
    sliderVelocidade02.setValue(1);
    sliderVelocidade02.valueProperty().addListener((obs, oldVal, newVal) -> {
    });

  }

  public void receberPosicaoInicial(String posicao) {
    this.posicaoInicial = posicao;
    configurarPosicaoCarro(posicao);

    carro01.iniciarCorrida();
    carro02.iniciarCorrida();
  }

  public void configurarPosicaoCarro(String posicaoAtual) {

    if (carro01 != null) carro01.pararCorrida();
    if (carro02 != null) carro02.pararCorrida();

    switch (posicaoAtual) {
      case "Superior Esquerdo / Inferior Esquerdo":
        imageCarro01.setLayoutX(0);
        imageCarro01.setLayoutY(130);
        imageCarro01.setRotate(0);
        imageCarro01.setScaleX(1);

        imageCarro02.setLayoutX(0);
        imageCarro02.setLayoutY(230);
        imageCarro02.setRotate(0);
        imageCarro02.setScaleX(1);

        carro01 = new Carro(imageCarro01, sliderVelocidade01, 1);
        carro02 = new Carro(imageCarro02, sliderVelocidade02, 2);
        break;

      case "Superior Direito / Inferior Direito":
        imageCarro01.setLayoutX(940);
        imageCarro01.setLayoutY(130);
        imageCarro01.setRotate(0);
        imageCarro01.setScaleX(-1);

        imageCarro02.setLayoutX(940);
        imageCarro02.setLayoutY(230);
        imageCarro02.setRotate(0);
        imageCarro02.setScaleX(-1);

        carro01 = new Carro(imageCarro01, sliderVelocidade01, 3);
        carro02 = new Carro(imageCarro02, sliderVelocidade02, 4);
        break;

      case "Superior Esquerdo / Inferior Direito":
        imageCarro01.setLayoutX(0);
        imageCarro01.setLayoutY(130);
        imageCarro01.setRotate(0);
        imageCarro01.setScaleX(1);

        imageCarro02.setLayoutX(940);
        imageCarro02.setLayoutY(230);
        imageCarro02.setRotate(0);
        imageCarro02.setScaleX(-1);

        carro01 = new Carro(imageCarro01, sliderVelocidade01, 1);
        carro02 = new Carro(imageCarro02, sliderVelocidade02, 4);
        break;

      case "Superior Direito / Inferior Esquerdo":
        imageCarro01.setLayoutX(940);
        imageCarro01.setLayoutY(130);
        imageCarro01.setRotate(0);
        imageCarro01.setScaleX(-1);

        imageCarro02.setLayoutX(940);
        imageCarro02.setLayoutY(230);
        imageCarro02.setRotate(0);
        imageCarro02.setScaleX(1);

        carro01 = new Carro(imageCarro01, sliderVelocidade01, 3);
        carro02 = new Carro(imageCarro02, sliderVelocidade02, 2);
        break;
    }
  }

   @FXML
  private void voltarTela(ActionEvent event) {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/telaInicio.fxml"));
      Parent root = loader.load();
      Stage stage = new Stage();
      stage.setScene(new Scene(root));
      stage.show();

      fecharTela(event);
    } catch (Exception e) {
      exibirAlerta("Erro", "Erro ao carregar Tela 1");
    }
  }

  private void resetarSimulacao(ActionEvent event) {
    sliderVelocidade01.setValue(1);
    sliderVelocidade02.setValue(1);

    if(boxSelect02.getValue() != null) {
      configurarPosicaoCarro(boxSelect02.getValue());
      carro01.iniciarCorrida();
      carro02.iniciarCorrida();
    }
  }

  private void fecharTela(ActionEvent event) {
    Stage stage = (Stage) buttonSair02.getScene().getWindow();
    stage.close();
  }

  private void exibirAlerta(String titulo, String mensagem) {
    Alert alerta = new Alert(Alert.AlertType.WARNING);
    alerta.setTitle(titulo);
    alerta.setHeaderText(null);
    alerta.setContentText(mensagem);
    alerta.showAndWait();
  }

}
