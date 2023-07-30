import java.util.Random;
public class Roda {
    private boolean calibragem;
    private int num;
    public Roda(){
    Random random = new Random();
    int number = random.nextInt(101);
    num =number;
    if (number % 2 ==0){
        this.calibragem = true;

    }else {
        this.calibragem = false;

    }

    }


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
      return "roda:"+num+" = "+this.calibragem;
    }

}
