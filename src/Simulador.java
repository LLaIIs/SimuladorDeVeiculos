import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Simulador {
    static List<Veiculo> veiculos;
    private Veiculo veiculo;
   static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menu();

    }
    public static void menu() {
        char op;
        boolean veiculoIncluido = false;
        while (true){
            System.out.println("Que opção do menu:");
            System.out.println("[a] Incluir veículos");
            if (veiculoIncluido) {
                System.out.println("""
                [b] Remover veículos\s
                [c] Abastecer\s
                [d] Movimentar um veículo
                [e] Movimentar por tipo
                [f] Status de todos os veículos
                [g] Status por tipo
                [h] Esvaziar um pneu específico
                [i] Calibrar pneu específico
                [j] Calibrar todos os pneus por tipo
                [P] Pagar Ipva""");
            }
            System.out.println("[K] Sair da aplicação");
        op = sc.next().charAt(0);
        switch (op) {
            case 'a':
                incluirVeiculo();
                veiculoIncluido = true;
                printDesenhos(veiculos);
                break;
            case 'b':
                removerVeiculo();
                break;
            case 'c':
                VeiculoMotorizado.abastecer();
                break;
            case 'd':
                System.out.println("Digite o ID do veículo:");
                int idMove = sc.nextInt();
                for (Veiculo veiculo:veiculos) {
                    if(veiculo.getId() == idMove){
                        veiculo.mover();

                    }
                    printDesenhos(veiculos);
                }
                break;
            case 'e':
                boolean encontrado = false;
                System.out.println("Digite o tipo(B,M,C,F):");
                char tipo = sc.next().charAt(0);
                for (Veiculo veiculo : veiculos) {
                    if (tipo == 'B' || tipo == 'b') {
                        if (veiculo instanceof Bike) {
                            veiculo.mover();
                            encontrado = true;
                        }
                    } else if (tipo == 'M' || tipo == 'm') {
                        if (veiculo instanceof Motocicleta) {
                            veiculo.mover();
                            encontrado = true;
                        }
                    } else if (tipo == 'C' || tipo == 'c') {
                        if (veiculo instanceof Carro) {
                            veiculo.mover();
                            encontrado = true;
                        }
                    } else if (tipo == 'F' || tipo == 'f') {
                        if (veiculo instanceof Ferrari) {
                            veiculo.mover();
                            encontrado = true;
                        }
                    }
                }
                if(!encontrado){
                    System.out.println("Tipo não foi encontrado");
                }
                 printDesenhos(veiculos);
                break;
            case 'f':
                System.out.println("-------------------INFORMAÇÕES:---------------------");
                System.out.println(veiculos.toString());
                break;
            case 'g':
                System.out.println("Digite o tipo(B,M,C,F):");
                char statusTipo = sc.next().charAt(0);
               encontrado =false;
                for (Veiculo veiculo : veiculos) {
                    if (statusTipo == 'B' || statusTipo == 'b') {
                        if (veiculo instanceof Bike) {
                            System.out.println(veiculo);
                            encontrado = true;
                        }
                    } else if (statusTipo == 'M' || statusTipo == 'm') {
                        if (veiculo instanceof Motocicleta) {
                            System.out.println(veiculo);
                             encontrado = true;
                        }

                    } else if (statusTipo == 'C' || statusTipo == 'c') {
                        if (veiculo instanceof Carro) {
                            System.out.println(veiculo);
                            encontrado = true;
                        }

                    } else if(statusTipo == 'F' || statusTipo == 'f') {
                        if (veiculo instanceof Ferrari) {
                            System.out.println(veiculo);
                            encontrado = true;

                        }
                    }
                }
                if(!encontrado){
                    System.out.println("Tipo não foi encontrado");
                }

                break;
            case 'h':
                Veiculo veiculoEsvaziar = null;
                boolean idvalido =false;
                while(veiculoEsvaziar==null){
                System.out.println("Digite o ID do veículo:");
                int idVeiculoEsvaziar = sc.nextInt();



                for (Veiculo veiculo: veiculos) {
                    if(veiculo.getId() == idVeiculoEsvaziar){
                        veiculoEsvaziar = veiculo;
                        idvalido=true;
                        break;
                    }
                }
                if(!idvalido){
                    System.out.println("ID inválido. Digite novamente.");
                    }
                }

                if (veiculoEsvaziar != null) {
                    int numPneu;
                    boolean numPneuValido = false;

                    while (!numPneuValido) {
                        System.out.println("Digite o número do pneu (1 a " + veiculoEsvaziar.getQuantRodas() + "):");
                        numPneu = sc.nextInt();

                        if (numPneu >= 1 && numPneu <= veiculoEsvaziar.getQuantRodas()) {
                            if(!veiculoEsvaziar.getRodas().get(numPneu - 1).isCalibragem()){
                                System.out.println("Ja está esvaziado!");
                                break;
                            }else {
                                veiculoEsvaziar.getRodas().get(numPneu - 1).setCalibragem(false);
                                System.out.println("O " + numPneu + "° Pneu foi esvaziado!");
                                numPneuValido = true;
                            }
                        } else {
                            System.out.println("Número de pneu inválido. Digite novamente.");
                        }
                    }
                }
                break;

            case 'i':
                System.out.println("Digite o ID do veículo:");
                int idVeiculoPneu = sc.nextInt();
                Veiculo veiculoCalibrar = null;
                for (Veiculo veiculo : veiculos) {
                    if (veiculo.getId() == idVeiculoPneu) {
                        veiculoCalibrar = veiculo;
                        break;
                    }
                }
                if (veiculoCalibrar != null) {
                    System.out.println("Veículo encontrado!");
                    System.out.println("Digite o número do pneu:");
                    int numPneu = sc.nextInt();
                    veiculoCalibrar.calibraPneu(numPneu);

                } else {
                    System.out.println("ID inválido");
                }
                break;
            case 'j':
                System.out.println("Digite o tipo:");
                char tipoCalibrar = sc.next().charAt(0);
                encontrado =false;
                for (Veiculo veiculo : veiculos) {
                    if (tipoCalibrar == 'B' || tipoCalibrar == 'b') {
                        if (veiculo instanceof Bike) {
                          veiculo.calibraPneu();
                            encontrado = true;
                        }
                    } else if (tipoCalibrar == 'M' || tipoCalibrar == 'm') {
                        if (veiculo instanceof Motocicleta) {
                            veiculo.calibraPneu();
                            encontrado = true;
                        }

                    } else if (tipoCalibrar == 'C' || tipoCalibrar == 'c') {
                        if (veiculo instanceof Carro) {
                            veiculo.calibraPneu();
                            encontrado = true;
                        }

                    } else if (tipoCalibrar == 'F' || tipoCalibrar == 'f') {
                        if (veiculo instanceof Ferrari) {
                            veiculo.calibraPneu();
                            encontrado = true;

                        }
                    }

                }
                if(!encontrado){
                    System.out.println("Tipo não foi encontrado");
                }
                break;

            case 'p':
                System.out.println("Digite o ID do veículo:");
                int idIpva = sc.nextInt();
                VeiculoMotorizado veiculoIpva = null;


                for (Veiculo veiculo : veiculos) {
                    if (veiculo.getId() == idIpva) {
                        if(veiculo instanceof  Bike){
                            System.out.println("Veiculos do tipo bicicleta não pagam Ipva!");
                        }else{
                        veiculoIpva = (VeiculoMotorizado) veiculo;
                        break;}
                    }
                }
                if(veiculoIpva!=null){
                    if(!veiculoIpva.isIpva()){
                        if(veiculoIpva instanceof Carro){
                           double ipva = ((Carro) veiculoIpva).calcularIpva();
                            System.out.printf("\nValor do IPVA a pagar: R$ %.2f",ipva );
                            System.out.println("\nPagando...");
                            veiculoIpva.setIpva(true);
                            System.out.println("Pago");
                        }
                        else if(veiculoIpva instanceof Motocicleta){
                            double ipva = ((Motocicleta) veiculoIpva).calcularIpva();
                            System.out.printf("\nValor do IPVA a pagar: R$ %.2f",ipva );
                            System.out.println("\nPagando...");
                            veiculoIpva.setIpva(true);
                        }
                        else if(veiculoIpva instanceof Ferrari){
                            double ipva = ((Ferrari) veiculoIpva).calcularIpva();
                            System.out.printf("\nValor do IPVA a pagar: R$ %.2f",ipva );
                            System.out.println("\nPagando...");
                            veiculoIpva.setIpva(true);
                        }


                        }else{
                        System.out.println("O IPVA desse veículo já foi pago anteriormente.");
                    }
                }
                break;


            case 'k':
                System.out.println("Volte sempre!");

                 return;




            }
        }


    }

    public static void printDesenhos(List<Veiculo> veiculos) {
    //imprimi o desenho de todos os veículos
        for (Veiculo veiculo : veiculos) {
            System.out.println("ID:"+ veiculo.getId()+veiculo.desenhar());
        }
    }
    public static void incluirVeiculo(){


        Veiculo novoVeiculo;
        int quant;
        do {
            System.out.println("Quantos veículos[max:20]:");
            quant = sc.nextInt();
        }while(quant>20);
        for(int i=0; i<quant ;i++) {
            System.out.println("Incuir veículo o tipo(B,M,C,F):");
            char tipo = sc.next().charAt(0);
            if (tipo == 'B' || tipo == 'b') {
                novoVeiculo = new Bike();

            } else if (tipo == 'M' || tipo == 'm') {
                novoVeiculo = new Motocicleta();

            } else if (tipo == 'C' || tipo == 'c') {
                novoVeiculo = new Carro();

            } else if (tipo == 'F' || tipo == 'f') {
                novoVeiculo = new Ferrari();
            } else {
                System.out.println("Tipo de veículo Inválido");
                return;
            }
            if (veiculos == null) {
                veiculos = new ArrayList<>();
            }
            veiculos.add(novoVeiculo);
        }
    }
    public static void removerVeiculo(){
        int removeId;
        System.out.println("Digite o Id do veiculo:");
        removeId = sc.nextInt();
        Veiculo veiculoARemover = null;
        for (Veiculo veiculo :veiculos) {
            if(veiculo.getId() == removeId){
                veiculoARemover =veiculo;
                break;
            }
        }
        if(veiculoARemover !=null){
            veiculos.remove(veiculoARemover);
            System.out.println("O veiculo de id: "+removeId+" foi removido.");
        }else{
            System.out.println("ID inválido!");
        }
        }

}


