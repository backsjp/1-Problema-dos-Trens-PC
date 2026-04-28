/*******************************************************************************************************
* Autor: João Pedro Serra de Souza
* Matricula: 202510603
* Inicio: 22/03/2026
* Ultima alteracao: 29/03/2026
* Nome: Carro
* Descricao: Essa classe cria o objeto carro e seus metodos que sao usados na simulacao
******************************************************************************************************* */

package model;

import javafx.scene.image.ImageView;
import javafx.scene.control.Slider;
import javafx.application.Platform;
import javafx.animation.AnimationTimer;

public class Carro {

  private ImageView imagemCarro;
  private double velocidadeCar;
  private int posicaoCar;
  private Slider sliderCar;
  private AnimationTimer timer;

  public Carro(ImageView imagemCarro, Slider sliderCar, int posicaoCar){
    this.imagemCarro = imagemCarro;
    this.sliderCar = sliderCar;
    this.posicaoCar = posicaoCar;
  }

  public void iniciarCorrida() {
    this.pararCorrida();

    timer = new AnimationTimer() {
      @Override
      public void handle(long agora) {
        inicioCarro(posicaoCar);
      }
    };
    timer.start();
  }

  public void inicioCarro(int posicionarCarro){
    switch (posicionarCarro){

      case 1:
        moverCarro01();
        break;

      case 2:
        moverCarro02();
        break;

      case 3:
        moverCarro03();
        break;

      case 4:
        moverCarro04();
        break;
    }
  }

  private void moverCarro01(){

    ImageView carro = this.getImagemCarro();
    velocidadeCar = sliderCar.getValue();

    if (carro.getLayoutX() < 150) {
      carro.setRotate(0);
      carro.setLayoutX(carro.getLayoutX() + velocidadeCar);
      carro.setLayoutY(130);

    } else if (carro.getLayoutX() < 180) {
      carro.setRotate(45);
      carro.setLayoutX(carro.getLayoutX() + velocidadeCar);
      carro.setLayoutY(carro.getLayoutY() + velocidadeCar);

    } else if (carro.getLayoutX() < 325) {
      carro.setRotate(0);
      carro.setLayoutX(carro.getLayoutX() + velocidadeCar);
      carro.setLayoutY(175);

    } else if (carro.getLayoutX() < 380) {
      carro.setRotate(-45);
      carro.setLayoutX(carro.getLayoutX() + velocidadeCar);
      carro.setLayoutY(carro.getLayoutY() - velocidadeCar);

    } else if (carro.getLayoutX() < 560) {
      carro.setRotate(0);
      carro.setLayoutX(carro.getLayoutX() + velocidadeCar);
      carro.setLayoutY(130);

    } else if (carro.getLayoutX() < 590) {
      carro.setRotate(45);
      carro.setLayoutX(carro.getLayoutX() + velocidadeCar);
      carro.setLayoutY(carro.getLayoutY() + velocidadeCar);

    } else if (carro.getLayoutX() < 730) {
      carro.setRotate(0);
      carro.setLayoutX(carro.getLayoutX() + velocidadeCar);
      carro.setLayoutY(175);

    } else if (carro.getLayoutX() < 780) {
      carro.setRotate(-45);
      carro.setLayoutX(carro.getLayoutX() + velocidadeCar);
      carro.setLayoutY(carro.getLayoutY() - velocidadeCar);

    } else if (carro.getLayoutX() < 940) {
      carro.setRotate(0);
      carro.setLayoutX(carro.getLayoutX() + velocidadeCar);
      carro.setLayoutY(130);

    } else if (carro.getLayoutX() >= 940) {
      carro.setRotate(0);
      carro.setLayoutX(0);
      carro.setLayoutY(130);
    }
  }

  private void moverCarro02(){

    ImageView carro = this.getImagemCarro();
    velocidadeCar = sliderCar.getValue();

    if (carro.getLayoutX() < 150) {
      carro.setRotate(0);
      carro.setLayoutX(carro.getLayoutX() + velocidadeCar);
      carro.setLayoutY(230);

    } else if (carro.getLayoutX() < 180) {
      carro.setRotate(-45);
      carro.setLayoutX(carro.getLayoutX() + velocidadeCar);
      carro.setLayoutY(carro.getLayoutY() - velocidadeCar);

    } else if (carro.getLayoutX() < 325) {
      carro.setRotate(0);
      carro.setLayoutX(carro.getLayoutX() + velocidadeCar);
      carro.setLayoutY(180);

    } else if (carro.getLayoutX() < 380) {
      carro.setRotate(45);
      carro.setLayoutX(carro.getLayoutX() + velocidadeCar);
      carro.setLayoutY(carro.getLayoutY() + velocidadeCar);

    } else if (carro.getLayoutX() < 560) {
      carro.setRotate(0);
      carro.setLayoutX(carro.getLayoutX() + velocidadeCar);
      carro.setLayoutY(230);

    } else if (carro.getLayoutX() < 590) {
      carro.setRotate(-45);
      carro.setLayoutX(carro.getLayoutX() + velocidadeCar);
      carro.setLayoutY(carro.getLayoutY() - velocidadeCar);

    } else if (carro.getLayoutX() < 730) {
      carro.setRotate(0);
      carro.setLayoutX(carro.getLayoutX() + velocidadeCar);
      carro.setLayoutY(180);

    } else if (carro.getLayoutX() < 780) {
      carro.setRotate(45);
      carro.setLayoutX(carro.getLayoutX() + velocidadeCar);
      carro.setLayoutY(carro.getLayoutY() + velocidadeCar);

    } else if (carro.getLayoutX() < 940) {
      carro.setRotate(0);
      carro.setLayoutX(carro.getLayoutX() + velocidadeCar);
      carro.setLayoutY(230);

    } else if (carro.getLayoutX() >= 940) {
      carro.setRotate(0);
      carro.setLayoutX(0);
      carro.setLayoutY(230);
    }
  }

  private void moverCarro03(){

    ImageView carro = this.getImagemCarro();
    velocidadeCar = sliderCar.getValue();

    if (carro.getLayoutX() > 780) {
      carro.setRotate(0);
      carro.setLayoutX(carro.getLayoutX() - velocidadeCar);
      carro.setLayoutY(130);

    } else if (carro.getLayoutX() > 730) {
      carro.setRotate(-45);
      carro.setLayoutX(carro.getLayoutX() - velocidadeCar);
      carro.setLayoutY(carro.getLayoutY() + velocidadeCar);

    } else if (carro.getLayoutX() > 590) {
      carro.setRotate(0);
      carro.setLayoutX(carro.getLayoutX() - velocidadeCar);
      carro.setLayoutY(180);

    } else if (carro.getLayoutX() > 560) {
      carro.setRotate(45);
      carro.setLayoutX(carro.getLayoutX() - velocidadeCar);
      carro.setLayoutY(carro.getLayoutY() - velocidadeCar);

    } else if (carro.getLayoutX() > 380) {
      carro.setRotate(0);
      carro.setLayoutX(carro.getLayoutX() - velocidadeCar);
      carro.setLayoutY(130);

    } else if (carro.getLayoutX() > 325) {
      carro.setRotate(-45);
      carro.setLayoutX(carro.getLayoutX() - velocidadeCar);
      carro.setLayoutY(carro.getLayoutY() + velocidadeCar);

    } else if (carro.getLayoutX() > 180) {
      carro.setRotate(0);
      carro.setLayoutX(carro.getLayoutX() - velocidadeCar);
      carro.setLayoutY(180);

    } else if (carro.getLayoutX() > 150) {
      carro.setRotate(45);
      carro.setLayoutX(carro.getLayoutX() - velocidadeCar);
      carro.setLayoutY(carro.getLayoutY() - velocidadeCar);

    } else if (carro.getLayoutX() > 0) {
      carro.setRotate(0);
      carro.setLayoutX(carro.getLayoutX() - velocidadeCar);
      carro.setLayoutY(130);

    } else if (carro.getLayoutX() <= 0) {
      carro.setRotate(0);
      carro.setLayoutX(940);
      carro.setLayoutY(130);
    }
  }

  private void moverCarro04(){

    ImageView carro = this.getImagemCarro();
    velocidadeCar = sliderCar.getValue();

    if (carro.getLayoutX() > 780) {
      carro.setRotate(0);
      carro.setLayoutX(carro.getLayoutX() - velocidadeCar);
      carro.setLayoutY(230);

    } else if (carro.getLayoutX() > 730) {
      carro.setRotate(45);
      carro.setLayoutX(carro.getLayoutX() - velocidadeCar);
      carro.setLayoutY(carro.getLayoutY() - velocidadeCar);

    } else if (carro.getLayoutX() > 590) {
      carro.setRotate(0);
      carro.setLayoutX(carro.getLayoutX() - velocidadeCar);
      carro.setLayoutY(180);

    } else if (carro.getLayoutX() > 560) {
      carro.setRotate(-45);
      carro.setLayoutX(carro.getLayoutX() - velocidadeCar);
      carro.setLayoutY(carro.getLayoutY() + velocidadeCar);

    } else if (carro.getLayoutX() > 380) {
      carro.setRotate(0);
      carro.setLayoutX(carro.getLayoutX() - velocidadeCar);
      carro.setLayoutY(230);

    } else if (carro.getLayoutX() > 325) {
      carro.setRotate(45);
      carro.setLayoutX(carro.getLayoutX() - velocidadeCar);
      carro.setLayoutY(carro.getLayoutY() - velocidadeCar);

    } else if (carro.getLayoutX() > 180) {
      carro.setRotate(0);
      carro.setLayoutX(carro.getLayoutX() - velocidadeCar);
      carro.setLayoutY(180);

    } else if (carro.getLayoutX() > 150) {
      carro.setRotate(-45);
      carro.setLayoutX(carro.getLayoutX() - velocidadeCar);
      carro.setLayoutY(carro.getLayoutY() + velocidadeCar);

    } else if (carro.getLayoutX() > 0) {
      carro.setRotate(0);
      carro.setLayoutX(carro.getLayoutX() - velocidadeCar);
      carro.setLayoutY(230);

    } else if (carro.getLayoutX() <= 0) {
      carro.setRotate(0);
      carro.setLayoutX(940);
      carro.setLayoutY(230);
    }
  }

  public ImageView getImagemCarro(){
    return imagemCarro;
  }

  public void setPosicaoCar(int posicaoCar){
    this.posicaoCar = posicaoCar;
  }

  public void pararCorrida() {
    if (timer != null) {
      timer.stop();
    }
  }

}
