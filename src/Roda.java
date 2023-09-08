import java.util.Random;
public class Roda {
    //Atributos nescessários
    private boolean calibragem;
    private int num;
    public Roda(){
        //construtor inicializa com um numero para cada roda
    Random random = new Random();
    int number = random.nextInt(101);
    num =number;
    if (number % 2 ==0){
        //se a roda for par então está calibrado
        this.calibragem = true;

    }else {
        this.calibragem = false;
        //se a roda for impar então não está calibrado

    }

    }

    //metodos getter e setters
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isCalibragem() {

        return calibragem;
    }

    public void setCalibragem(boolean calibragem) {
        this.calibragem = calibragem;

    }
    public String toString(){
        //mostra o "id" da roda e se está calibrada
      return "roda:"+num+" = "+this.calibragem;
    }

}
