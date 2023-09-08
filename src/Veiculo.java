import java.util.List;
import java.util.Random;

public abstract class  Veiculo {
    //Atributos nescessários
    private int id;
    private int quantBloco;
    private  List<Roda> rodas;
    private int quantRodas;
    private int espacoAntes;
    public Veiculo(){
        //Construtor de veículos inicializa com id

        Random random = new Random();
        id = random.nextInt(200,900);
    }

    // geters e setters dos atributos
    public int getEspacoAntes() {
        return espacoAntes;
    }

    public void setEspacoAntes(int espacoAntes) {
        this.espacoAntes = espacoAntes;
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

    public abstract void mover();//metodo abstrato mover
    public abstract String desenhar();//metodo abstrato desenhar
    public void calibraPneu() {
        //metodo calibra pneu por  tipo
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
        //calibra pneu por id
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

    public abstract String toString();//metodo abstrato toString

}
