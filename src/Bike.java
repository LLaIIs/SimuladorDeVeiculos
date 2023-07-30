import java.util.ArrayList;
import java.util.List;
public class Bike extends Veiculo {
    private int espacoAntes;


    public Bike(){
        setQuantRodas(2);
        List<Roda> rodas = new ArrayList<>();

        for (int i = 0; i < getQuantRodas(); i++) {
            rodas.add(new Roda());
        }

        setRodas(rodas);

    }



    public void mover() {
        boolean rodaDescalibrada = false;


            for (Roda roda : getRodas()) {
                if (!roda.isCalibragem()) {
                    rodaDescalibrada = true;
                    break;
                }

            }
        if (rodaDescalibrada) {
            System.out.println("Não é possível locomover pois a(s) roda(s) não está(ão) calibrada(s)!");
        } else {
            espacoAntes++; // incrementa
        }
    }
    public String desenhar(){
        String espacos = "  ".repeat(espacoAntes);//2 em 2 blocos
        String bike = " "+
                 "\n "+espacos+"   __o" +
                    " \n"+espacos+" _¬\\ <,_" +
                " \n"+espacos+"(*)/  (*) " +
                "\n               ";

        return bike;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bicicleta: ID:").append(getId()).append("\n");
        for (Roda roda : getRodas()) {
            sb.append(roda.toString()).append("\n");
        }

        return sb.toString() ;
    }
}
