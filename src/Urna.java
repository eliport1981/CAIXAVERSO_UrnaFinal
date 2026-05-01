import java.nio.channels.ScatteringByteChannel;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Urna {
    // simulador de urna eletrônica
    // autora: M. Elisiane S Portela

    // metodo cabeçalho eleicao
    public static void menuEleicao(){
        System.out.println("****************************************");
        System.out.println("******        Eleições 2026       ******");
        System.out.println("****************************************");
    }
    // metodo escolher cargo
    public static void menuCargo(){
        System.out.println("Escolha o cargo do candidato para votar:");
        System.out.println("1 - Prefeito");
        System.out.println("2 - Vereador");
        System.out.println("0 - Encerrar");
        System.out.println("****************************************");
   }
    //método principal
    public static void main(String[] args) {

        //criação dos objetos candidatos da classe Candidato
        //candidatos ao cargo PREFEITO
        Candidato candidatoA = new Candidato("ALEMÃO SANTOS", 10, Cargo.PREFEITO);
        Candidato candidatoB = new Candidato("VITOR BRANDÃO", 20, Cargo.PREFEITO);
        Candidato nuloP = new Candidato("VOTO NULO",-1, Cargo.PREFEITO );
        Candidato brancoP = new Candidato("VOTO BRANCO",0, Cargo.PREFEITO );

        //candidatos ao cargo VEREADOR
        Candidato candidatoC = new Candidato(" MARIAZINHA DA FEIRA", 10111, Cargo.VEREADOR);
        Candidato candidatoD = new Candidato("JOÃOZINHO DA PAZ", 20111, Cargo.VEREADOR);
        Candidato nuloV = new Candidato("VOTO NULO",-1, Cargo.VEREADOR );
        Candidato brancoV = new Candidato("VOTO BRANCO",0, Cargo.VEREADOR );

        //exibição de menu da URNA
        menuEleicao();
        System.out.println("Digite seu nome:");
        Scanner entrada = new Scanner(System.in);
        String nomeleitor = entrada.nextLine();
        System.out.println("Digite sua idade:");
        int idadeleitor = entrada.nextInt();
        int opcao = -1;
        //tratamento de erros
        try {
            // testar se o eleitor pode votar
            if (idadeleitor < 16) {
                System.out.println(nomeleitor + ", infelizmente, você não pode votar, o programa será finalizado!");
            }
            else {
               menuEleicao();
               while (opcao != 0) {
                   menuCargo();
                   opcao = entrada.nextInt();
                    switch (opcao) {
                        case 1:
                            //caso a escolha seja PREFEITO
                            System.out.println("Digite o numero do candidato para PREFEITO:");
                            System.out.println(candidatoA.getNumero() + " - " + candidatoA.getNome());
                            System.out.println(candidatoB.getNumero() + " - " + candidatoB.getNome());
                            System.out.println(brancoP.getNumero() + " - " + brancoP.getNome());
                            System.out.println("OUTRO Nº - "+nuloP.getNome() );
                            votarPrefeito(entrada, candidatoA, candidatoB, brancoP, nuloP);
                            menuEleicao();
                            break;
                        case 2:
                            //caso a escolha seja VEREADOR
                            System.out.println("Digite o numero do candidato para VEREADOR:");
                            System.out.println(candidatoC.getNumero() + " - " + candidatoC.getNome());
                            System.out.println(candidatoD.getNumero() + " - " + candidatoD.getNome());
                            System.out.println(brancoV.getNumero() + " - " + brancoV.getNome());
                            System.out.println("OUTRO Nº - "+nuloV.getNome() );
                            votarVereador(entrada, candidatoC, candidatoD, brancoV, nuloV);
                            menuEleicao();
                            break;
                        case 0:
                            System.out.println(nomeleitor + " você digitou '0' para sair, a votação será encerrada!");
                            break;
                        default:
                            System.out.println("Opção inválida");
                            menuEleicao();
                            break;
                    }  // fim do switch

               } // fim do while

                //exibição do resultado da eleição:
                menuEleicao();
                System.out.println("Eleição encerrada, segue apuração de votos:");
                System.out.println("*******************************************");
                System.out.println("Eleição PREFEITO");
                System.out.println("Votos " + candidatoA.getNome() + " :" + candidatoA.getNumeroVotos() + " - " + candidatoA.getCargo());
                System.out.println("Votos " + candidatoB.getNome() + " : " + candidatoB.getNumeroVotos() + " - " + candidatoB.getCargo());
                System.out.println( nuloP.getNome()+ ": " + nuloP.getNumeroVotos());
                System.out.println( brancoP.getNome() +": " + brancoP.getNumeroVotos());

                int votoA = candidatoA.getNumeroVotos();
                int votoB = candidatoB.getNumeroVotos();
                // testar quem recebeu maior quantidade de votos
                System.out.print("PREFEITO ELEITO : ");
                if (votoA > votoB) {
                    System.out.println(candidatoA.getNome());
                } else if (votoA == votoB) {
                    System.out.println("Houve empate entre os candidatos");
                } else {
                    System.out.println(candidatoB.getNome());
                }
                System.out.println("*******************************************");
                System.out.println("Eleição VEREADOR");
                System.out.println("Votos " + candidatoC.getNome() + " : " + candidatoC.getNumeroVotos() + " - " + candidatoC.getCargo());
                System.out.println("Votos " + candidatoD.getNome() + " : " + candidatoD.getNumeroVotos() + " - " + candidatoD.getCargo());
                System.out.println( nuloV.getNome()+ ": " + nuloV.getNumeroVotos());
                System.out.println( brancoV.getNome() +": " + brancoV.getNumeroVotos());

                int votoC = candidatoC.getNumeroVotos();
                int votoD = candidatoD.getNumeroVotos();
                // testar quem recebeu maior quantidade de votos
                System.out.print("VEREADOR ELEITO : ");
                if (votoC > votoD) {
                    System.out.println(candidatoC.getNome());
                } else if (votoC == votoD) {
                    System.out.println("Houve empate entre os candidatos");
                } else {
                    System.out.println(candidatoD.getNome());
                }

            } // fim do else

        }
        catch(InputMismatchException e) {
            System.out.println("Entrada inválida!");
            System.out.println(nomeleitor + " o programa será encerrado ....");
             }

            entrada.close(); // fechar Scanner
        } // fim classe main


        // métodos de confirmação de votos
        static void votarPrefeito (Scanner entrada, Candidato candidatoA, Candidato candidatoB,
                Candidato brancoP, Candidato nuloP)
        {
            int numero = entrada.nextInt();
            System.out.println("Confirmar? (1-Sim / 2-Não)");
            int confirmacao = entrada.nextInt();
            //Confirmar o voto escolhido e dados do candidato
            if (confirmacao == 1) {
                if (numero == 10) {
                    System.out.println(" Candidato escolhido: " + candidatoA.getNome());
                    candidatoA.receberVoto();
                } else if (numero == 20) {
                    System.out.println(" Candidato escolhido: " + candidatoB.getNome());
                    candidatoB.receberVoto();
                } else if (numero == 0) {
                    System.out.println(" Voto em BRANCO.");
                    brancoP.receberVoto();
                } else {
                    System.out.println(" Voto NULO.");
                    nuloP.receberVoto();
                }

            } // fim do teste confirmação
        } // fim do método votarPrefeito

        // método votarVereador
        static void votarVereador (Scanner entrada, Candidato candidatoC, Candidato candidatoD,
                Candidato brancoV, Candidato nuloV )
        {
            int numero = entrada.nextInt();
            System.out.println("Confirmar? (1-Sim / 2-Não)");
            int confirmacao = entrada.nextInt();
            //Confirmar o voto escolhido e dados do candidato
            if (confirmacao == 1) {
                if (numero == 10111) {
                    System.out.println(" Candidato escolhido: " + candidatoC.getNome());
                    candidatoC.receberVoto();
                } else if (numero == 20111) {
                    System.out.println(" Candidato escolhido: " + candidatoD.getNome());
                    candidatoD.receberVoto();
                } else if (numero == 0) {
                    System.out.println(" Voto em BRANCO.");
                    brancoV.receberVoto();
                } else {
                    System.out.println(" Voto NULO.");
                    nuloV.receberVoto();
                }

            } // fim do teste confirmação

        } // fim do método votarVereador

} // fim do programa




