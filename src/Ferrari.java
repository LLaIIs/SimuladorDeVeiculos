import java.util.ArrayList;
import java.util.List;

public class Ferrari extends  VeiculoMotorizado implements Ipva{
    private int espacoAntes;
    public Ferrari(){
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
                espacoAntes++; // incrementa
                setCombustivel(getCombustivel() - totalVal);
            } else {
                System.out.println("Não é possível mover, combustível insuficiente");
            }
        }
    }


    @Override
    public String desenhar() {
        setQuantBloco(10);
        String espacos = " ".repeat(espacoAntes*getQuantBloco());//10 em 10 blocos
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

        return valBase*valFerrari;
    }
}
