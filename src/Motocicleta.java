import java.util.ArrayList;
import java.util.List;
//motocicleta é filha de veiculoMotorizado e implementa a interface Ipva
public class Motocicleta extends VeiculoMotorizado implements Ipva{



    public Motocicleta(int espacoAntes){
        //inicializa com 2 rodas
        setQuantRodas(2);
        List<Roda> rodas = new ArrayList<>();

        for (int i = 0; i < getQuantRodas(); i++) {
            rodas.add(new Roda());
        }

        setRodas(rodas);
       setEspacoAntes(espacoAntes);
    }
    @Override
    public void mover() {
        //move o veiculo
        float totalVal = getQuantBloco() * getLitToMorocicleta();
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
            if (getCombustivel() >= totalVal) {
                int novoEspacoAntes = getEspacoAntes() + 1;
                setEspacoAntes(novoEspacoAntes); // incrementa
                setCombustivel(getCombustivel() - totalVal);
            } else {
                System.out.println("Não é possível mover, combustível insuficiente");
            }
        }
    }

    @Override
    public String desenhar() {
        //desenha o veiculo
       setQuantBloco(3);
        String espacos = " ".repeat(getEspacoAntes()*getQuantBloco());//3 em 3 blocos
        String motocicleta = "" +
                "         \n "+espacos+"  ,_oo" +
                "         \n"+espacos+".-/c-//::" +
                "          \n"+espacos+"(_),==(_)" +
                "  \n                       ";
        return motocicleta;
    }

    @Override
    public String toString() {
        //print as informações do veiculo
        StringBuilder sb = new StringBuilder();
        sb.append("Motocicleta: ID:").append(getId()).append("\n");
        sb.append("Combustivel:").append(getCombustivel()).append("\n");
        for (Roda roda : getRodas()) {
            sb.append(roda.toString()).append("\n");
        }

        return sb.toString();
    }

    @Override
    public double calcularIpva() {
        //calcula o valor do ipva do veiculo

        return valBase*valMotocicleta;
    }

}
