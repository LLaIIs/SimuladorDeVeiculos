import java.util.Random;
import java.util.Scanner;
//VeiculoMotorizado é filho de Veiculo
public abstract class VeiculoMotorizado extends Veiculo {
    //Atributos nescessários
    private final float litToMorocicleta =0.25f;
    private final float litToCarro = 0.75f;
    private final float litToFerrari = 2.5f;
    private  static float combustivel;
    private boolean ipva;

    public VeiculoMotorizado(){
        //construtor inicializa com combustivel = 3.5
        Random random = new Random();
        combustivel=3.5f;
        int genIpva = random.nextInt(0,100);

        if(genIpva%2==0){
            //inicializa com Ipva pago se for par
            this.ipva = true;

        }else{
            //Ipva não pago
            this.ipva =false;
        }

    }
    //getters e setters
    public float getCombustivel() {

        return combustivel;
    }

    public void setCombustivel(float combustivel) {

        this.combustivel = combustivel;
    }
    public float getLitToCarro() {
        return litToCarro;
    }



    public float getLitToMorocicleta() {
        return litToMorocicleta;
    }



    public float getLitToFerrari() {
        return litToFerrari;
    }

    public boolean isIpva() {
        return ipva;
    }

    public void setIpva(boolean ipva) {
       this.ipva = ipva;
    }

    public static void  abastecer(){
         //abasatece o veiculo
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o Id do veículo:");
        int combusId =sc.nextInt();
        System.out.println("Digite a quantidade de combustível em Litros:");
        double combusQuant =sc.nextDouble();
        for (Veiculo veiculo: Simulador.veiculos) {
            if(veiculo.getId() == combusId){
                if(veiculo instanceof  Bike){
                    System.out.println("Não é possível abastecer veículo do tipo bicicleta!");
                }
               combustivel+=combusQuant;
            }
        }


    }
    public String toString(){
        return "Ipva pago?:"+ipva;

    }


}
