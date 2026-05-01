Proposta de Projeto Final para o Curso CAIXA VERSO Java

Projeto Final — Urna Eletrônica
Objetivo
Criar uma aplicação Java via terminal que simule uma urna eletrônica com votação, confirmação e
apuração final.

Fluxo da Aplicação

Passo Descrição

1 Exibir menu

2 Escolher cargo

3 Digitar número

4 Confirmar voto

5 Registrar voto

6 Exibir apuração

Exemplo Completo de Lógica de Votação

Scanner scanner = new Scanner(System.in);

int opcao = -1;

while (opcao != 0) {

System.out.println("1 - Prefeito");

System.out.println("2 - Vereador");

System.out.println("0 - Encerrar");

opcao = scanner.nextInt();

switch (opcao) {

case 1:

votarPrefeito(scanner);

break;

case 2:

votarVereador(scanner);

break;

case 0:

System.out.println("Encerrando...");

break;

default:

System.out.println("Opção inválida");

}

}

Exemplo de Método de Votação

void votarPrefeito(Scanner scanner) {

System.out.println("Digite o número:");

int numero = scanner.nextInt();

System.out.println("Confirmar? (1-Sim / 2-Não)");

int confirmacao = scanner.nextInt();

if (confirmacao == 1) {

if (numero == 10) {

candidatoA.receberVoto();

} else if (numero == 20) {

candidatoB.receberVoto();

} else if (numero == 0) {

brancos++;

} else {

nulos++;

}

}

}

Estrutura do Projeto

enum Cargo { PREFEITO, VEREADOR }


abstract class Pessoa {
private String nome;
}
class Candidato extends Pessoa {
private int numero;
private int votos;
public void receberVoto() {
votos++;
}
}

Checklist de Entrega
* Menu funcionando
* Votação funcionando
* Confirmação de voto
* Contagem correta
* Uso de POO 
4 Confirmação de voto
4 Contagem correta
4 Uso de POO
