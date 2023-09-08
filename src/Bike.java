import java.util.ArrayList;
import java.util.List;

//bike é filha de veiculo
public class Bike extends Veiculo {


    public Bike(int espacoAntes){
        //construtor inicializa com 2 rodas

        setQuantRodas(2);
        List<Roda> rodas = new ArrayList<>();

        for (int i = 0; i < getQuantRodas(); i++) {
            rodas.add(new Roda());
        }

        setRodas(rodas);
        setEspacoAntes(espacoAntes);

    }



    public void mover() {
        //metodo que move o veiculo
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
            int novoEspacoAntes = getEspacoAntes() + 1;
            setEspacoAntes(novoEspacoAntes); // incrementa
        }
    }
    public String desenhar(){
        //desenha o veiculo
        String espacos = "  ".repeat(getEspacoAntes());//2 em 2 blocos
        String bike = " "+
                 "\n "+espacos+"   __o" +
                    " \n"+espacos+" _¬\\ <,_" +
                " \n"+espacos+"(*)/  (*) " +
                "\n               ";

        return bike;
    }

    @Override
    public String toString() {
        //printa as informações do veiculo
        StringBuilder sb = new StringBuilder();
        sb.append("Bicicleta: ID:").append(getId()).append("\n");
        for (Roda roda : getRodas()) {
            sb.append(roda.toString()).append("\n");
        }

        return sb.toString() ;
    }
}
