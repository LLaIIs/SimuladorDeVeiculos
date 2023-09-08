import java.util.ArrayList;
import java.util.List;
//carro é filho do veiculoMotorizado e implementa a interface Ipva
public class Carro extends  VeiculoMotorizado implements Ipva{


    public Carro(int espacoAntes){
        //inicializa com 4 rodas
        setQuantRodas(4);
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
        if (!isIpva()) {
            System.out.println("Não é possível locomover, IPVA não foi pago!");
            return;
        }
        float totalVal = getQuantBloco() * getLitToCarro();
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
        setQuantBloco(5);
        String espacos =" ".repeat(getEspacoAntes()*getQuantBloco());//5 em 5 blocos
        String carro = "     " +
                "\n"+espacos+"    ____" +
                " \n"+espacos+" __/  |_\\_" +
                " \n"+espacos+"|  _      _''-." +
                " \n"+espacos+",-(_)----(_)--'" +
                "\n                 " ;
        return carro;
    }
    @Override
    public String toString() {
        //printa as informações do veiculo
        StringBuilder sb = new StringBuilder();
        sb.append("Carro: ID:").append(getId()).append("\n");
        sb.append("Combustivel:").append(getCombustivel()).append("\n");
        for (Roda roda : getRodas()) {
            sb.append(roda.toString()).append("\n");
        }

        return sb.toString();
    }

    @Override
    public double calcularIpva() {
        //calcula o valor do ipva
        return  valBase*valCarro;
    }
}
