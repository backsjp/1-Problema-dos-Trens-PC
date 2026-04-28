/******************************************************************************************************
* Autor: João Pedro Serra de Souza
* Matricula: 202510603
* Inicio: 22/03/2026
* Ultima alteracao: 29/03/2026
* Nome: Principal
* Descricao: Este projeto eh uma implementacao de uma simulacao de trens(ou avioes de papeis)
* utilizando recursos de uma GUI. A classe Principal eh a responsavel por iniciar a aplicacao javaFX
* e lancar o programa
******************************************************************************************************/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import controller.telaCorridaController;
import controller.telaInicioController;
import controller.telaCorridaController;
import model.Carro;

public class Principal extends Application{

  private Class<?>[] forcarCompilacao = {
    telaInicioController.class,
    telaCorridaController.class,
    Carro.class
  };

  @Override
  public void start(Stage janela) throws Exception{

    try{
      Parent root = FXMLLoader.load(getClass().getResource("view/telaInicio.fxml"));

      Scene cena = new Scene(root);
      janela.setTitle("F1 Circuit Simulator");
      janela.getIcons().add(new Image("/img/f1logo.png"));
      janela.setScene(cena);
      janela.show();
      janela.setOnCloseRequest(e -> {
        System.exit(0);
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args){
    launch(args);
  }
}
