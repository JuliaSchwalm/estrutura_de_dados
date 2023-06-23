package listacircular;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        listas elementos = new listas();
        Scanner ler = new Scanner(System.in);
        int opt = 0;
        String nome = " ", novoNome = " ";

        do {
            System.out.println("\nDigite o numero desejado\n");
            System.out.println("1: adicionar um item no inicio da lista;\n"
                    + "2: adicionar item ao meio da lista;\n"
                    + "3: adicionar item ao fim da lista;\n"
                    + "4: imprimir o total de elementos da lista;\n"
                    + "5: imprimir a lista completa;\n"
                    + "6: localizar item na lista;\n"
                    + "7: remover item do inicio da lista;\n"
                    + "8: remover item do meio da lista;\n"
                    + "9: remover item do fim da lista;\n"
                    + "10: para sair.\n");
            opt = ler.nextInt();

            switch (opt) {
                case 1:
                    System.out.println("Digite o nome que você deseja inserir no inicio:\n");
                    nome = ler.next();
                    elementos.inserirInicio(nome);
                    break;
                case 2:
                    if (elementos.listaVazia()) {
                        System.out.println("Lista esta vazia! Para inserir elementos escolha a opção 1.");
                    } else {
                        System.out.println("Após quem deseja inserir o novo nome?\n");
                        nome = ler.next();
                        System.out.println("Digite o nome que deseja inserir:\n");
                        novoNome = ler.next();
                        elementos.inserirMeio(nome, novoNome);
                    }
                    break;
                case 3:
                    System.out.println("Digite o nome que você deseja inserir no fim:");
                    nome = ler.next();
                    elementos.inserirFim(nome);
                    break;
                case 4:
                    if (elementos.listaVazia()) {
                        System.out.println("Lista está vazia!");
                    } else {
                        System.out.println("O total de elementos da lista é: " + elementos.elementosLista());
                    }
                    break;
                case 5:
                    if (elementos.listaVazia()) {
                        System.out.println("Lista está vazia!");
                    } else {
                        System.out.println("Lista completa: \n");
                        elementos.imprimirLista();
                    }
                    break;
                case 6:
                    if (elementos.listaVazia()) {
                        System.out.println("Lista esta vazia! Adicione um nome para saber se ele está na lista.");
                    } else {
                        System.out.println("Qual o nome que deseja saber se está na lista?\n");
                        nome = ler.next();

                        if (elementos.contem(nome) != null) {
                            System.out.println("O nome " + nome + " contem na lista!\n");
                        } else {
                            System.out.println("O nome " + nome + " não contem na lista!\n");
                        }
                    }
                    break;
                case 7:

                    System.out.println("Nome do inicio da lista foi removido!\n");
                    elementos.removeInicio();
                    break;
                case 8:
                    System.out.println("Digite o nome de quem você quer remover seu nome seguinte:\n");
                    nome = ler.next();
                    elementos.removerMeio(nome);
                    break;
                case 9:
                    System.out.println("Nome do final da lista removido!\n");
                    elementos.removeFim();
                    break;
                case 10:
                    System.out.println("Lista encerrada!");
                    break;

                default:
                    System.out.println("Número não identificado.");
            }

        } while (opt != 10);
    }
}
