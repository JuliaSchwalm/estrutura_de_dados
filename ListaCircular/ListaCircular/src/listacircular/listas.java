package listacircular;

import java.util.Scanner;

public class listas {

    private No inicio;
    private int nElementos = 0;

    public void inserirInicio(String nome) {
        if (listaVazia()) {
            inicio = new No(nome);
            No aux = inicio;
            inicio.proximo = aux;
            inicio.anterior = aux;
            nElementos++;
        } else {
            if (nElementos == 1) {
                No aux = inicio;
                inicio = new No(nome);
                inicio.proximo = aux;
                aux.proximo = inicio;
                inicio.anterior = aux;
                aux.anterior = inicio;
                nElementos++;
            } else { // ju ro so 
                No aux = inicio;
                do {
                    aux = aux.proximo;
                } while (aux.proximo != inicio);

                No auxInicio = inicio;
                inicio = new No(nome);
                inicio.proximo = auxInicio;
                auxInicio.anterior = inicio;
                inicio.anterior = aux;
                aux.proximo = inicio;
                nElementos++;
            }

        }
    }

    public void inserirFim(String nome) {
        if (listaVazia()) {
            inicio = new No(nome);
            inicio.proximo = inicio;
            inicio.anterior = inicio;
            nElementos++;
        } else {
            if (nElementos == 1) {
                No aux = inicio;
                inicio.proximo = new No(nome);
                inicio.proximo.proximo = aux;
                inicio.proximo.anterior = aux;
                aux.anterior = inicio.proximo;
                nElementos++;
            } else {
                No aux = inicio;
                do {
                    aux = aux.proximo;
                } while (aux.proximo != inicio);

                aux.proximo = new No(nome);
                aux.proximo.proximo = inicio;
                inicio.anterior = aux.proximo;
                aux.proximo.anterior = aux;
                nElementos++;
            }
        }
    }

    public void inserirMeio(String nome, String novoNome) {
        if (listaVazia()) {
            System.out.println("Sem elementos na lista!");
        } else {
            No auxInicio = inicio;
            if (auxInicio.nome.equals(nome)) {
                No aux = inicio.proximo;
                inicio.proximo = new No(novoNome);
                inicio.proximo.anterior = auxInicio;
                inicio.proximo.proximo = aux;
                aux.anterior = inicio.proximo;
                nElementos++;
            } else if (contem(nome) != null) {
                No aux = contem(nome).proximo;
                contem(nome).proximo = new No(novoNome);
                contem(nome).proximo.anterior = contem(nome);
                contem(nome).proximo.proximo = aux;
                aux.anterior = contem(nome).proximo;
                nElementos++;

            } else {
                System.out.println("Este nome não contem na lista!");
            }
        }

    }

    public boolean listaVazia() {
        if (inicio == null) {
            return true;
        }
        return false;
    }

    public No contem(String nome) {
        if (listaVazia()) {
            return inicio;
        } else {
            No aux = inicio;
            do {
                if (aux.nome.equals(nome)) {
                    return aux;
                }
                aux = aux.proximo;
            } while (aux != inicio);
            return null;
        }
    }

    public void removeInicio() {
        if (listaVazia()) {
            System.out.println("Sem elementos na lista!");
        } else {
            if (nElementos == 1) {
                inicio = null;
                nElementos--;
            } else {
                if (nElementos == 2) {
                    inicio = inicio.proximo;
                    No aux = inicio;
                    aux.anterior = inicio;
                    aux.proximo = inicio;
                    nElementos--;
                } else {

                    No auxFim = inicio;
                    do {
                        auxFim = auxFim.proximo;
                    } while (auxFim.proximo != inicio);

                    inicio = inicio.proximo;
                    inicio.anterior = auxFim;
                    auxFim.proximo = inicio;
                    nElementos--;
                }
            }
        }
    }

    public void removeFim() {
        if (listaVazia()) {
            System.out.println("Sem elementos na lista!");
        } else {
            if (nElementos == 1) {
                inicio = null;
                nElementos--;
            } else if (nElementos == 2) {
                No aux = inicio;
                aux.anterior = inicio;
                aux.proximo = inicio;
                nElementos--;
            } else { 
                No aux = inicio;
                do {
                    aux = aux.proximo;
                } while (aux.proximo != inicio);
                No auxPenultimo = aux.anterior;
                auxPenultimo.proximo = inicio;
                inicio.anterior = auxPenultimo;
                nElementos--;
            }
        }
    }

    public void removerMeio(String nome) {
        if (listaVazia()) {
            System.out.println("Sem elementos na lista!");
        } else {
            No test = inicio;
            if (test.nome.equals(nome)) {
                inicio.proximo = inicio.proximo.proximo;
                inicio.proximo.anterior = test;
                nElementos--;

            } else if (contem(nome) != null) {
                contem(nome).proximo = contem(nome).proximo.proximo;
                contem(nome).proximo.anterior = contem(nome);
                nElementos--;

            } else {
                System.out.println("Este nome não contem na lista!");
            }
        }
    }

    public void imprimirLista() {
        No aux = inicio;
        do {
            System.out.println(aux.nome);
            aux = aux.proximo;
        } while (aux != inicio);

    }

    public int elementosLista() {
        return nElementos;
    }
}
