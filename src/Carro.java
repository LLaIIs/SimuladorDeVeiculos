import java.util.ArrayList;
import java.util.List;

public class Carro extends  VeiculoMotorizado implements Ipva{
    private int espacoAntes;

    public Carro(){
        setQuantRodas(4);
        List<Roda> rodas = new ArrayList<>();

        for (int i = 0; i < getQuantRodas(); i++) {
            rodas.add(new Roda());
        }

        setRodas(rodas);
        espacoAntes=0;
    }


    @Override
    public void mover() {
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
                espacoAntes++; // incrementa
                setCombustivel(getCombustivel() - totalVal);
            } else {
                System.out.println("Não é possível mover, combustível insuficiente");
            }
        }
    }

    @Override
    public String desenhar() {
        setQuantBloco(5);
        String espacos =" ".repeat(espacoAntes*getQuantBloco());//5 em 5 blocos
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
        return  valBase*valCarro;
    }
}
