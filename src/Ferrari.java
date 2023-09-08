import java.util.ArrayList;
import java.util.List;
//ferrari é filha do veiculoMotorizado e implementa ipva
public class Ferrari extends  VeiculoMotorizado implements Ipva{

    public Ferrari(int espacoAntes){
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
        float totalVal = getQuantBloco() * getLitToFerrari();
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
        setQuantBloco(10);
        String espacos = " ".repeat(getEspacoAntes()*getQuantBloco());//10 em 10 blocos
        String ferrari = "" +
                "\n"+espacos+"       __" +
                "\n "+espacos+"    ~( @\\ \\" +
                "\n"+espacos+" _____]  [_/_>___" +
                "\n"+espacos+"/  __ \\<>  |  __ \\" +
                "\n"+espacos+"\\_/__\\_\\___|_/__\\_D" +
                "\n"+espacos+"  (__)       (__)    " +
                "\n"+espacos+"'                    ";
        return ferrari;
    }
    @Override
    public String toString() {
        //print o as informações do veiculo
        StringBuilder sb = new StringBuilder();
        sb.append("Ferrari: ID:").append(getId()).append("\n");
        sb.append("Combustivel:").append(getCombustivel()).append("\n");
        for (Roda roda : getRodas()) {
            sb.append(roda.toString()).append("\n");
        }

        return sb.toString() ;
    }

    @Override
    public double calcularIpva() {
        //calcula o valor do ipva

        return valBase*valFerrari;
    }
}
