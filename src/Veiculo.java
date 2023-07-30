import java.util.List;
import java.util.Random;

public abstract class  Veiculo {
    private int id;
    private int quantBloco;
    private  List<Roda> rodas;
    private int quantRodas;
    public Veiculo(){
        Random random = new Random();
        id = random.nextInt(200,900);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantBloco() {
        return quantBloco;
    }

    public void setQuantBloco(int quantBloco) {
        this.quantBloco = quantBloco;
    }

    public int getQuantRodas() {
        return quantRodas;
    }

    public void setQuantRodas(int quantRodas) {
        this.quantRodas = quantRodas;
    }


   public List<Roda> getRodas() {
        return rodas;
    }

    public void setRodas(List<Roda> rodas) {
        this.rodas = rodas;
    }

    public abstract void mover();
    public abstract String desenhar();
    public void calibraPneu() {
        for (Roda pneu : rodas) {
            if (!pneu.isCalibragem()) {
                System.out.println("Calibrando pneu " + pneu.getNum() + "...");
                pneu.setCalibragem(true);
                System.out.println("Pneu " + pneu.getNum() + " calibrado");
            } else {
                System.out.println("Pneu " + pneu.getNum() + " já está calibrado");
            }
        }
    }
    public void  calibraPneu(int numPneu) {
        for (Roda pneu : rodas) {
            if(pneu.getNum() == numPneu) {
                if (!pneu.isCalibragem()) {
                    System.out.println("Calibrando pneu "+pneu.getNum()+"...");
                    pneu.setCalibragem(true);
                    System.out.println("Pneu "+pneu.getNum()+" calibrado");
                }else{
                    System.out.println("Pneu "+pneu.getNum()+" ja está calibrado");

                }     return;
            }
        }
        System.out.println("Pneu "+numPneu +" inválido!");
    }

    /*public String toString(){


    }*/

}
