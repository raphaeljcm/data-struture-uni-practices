package Practice02.Ex01;

import java.io.IOException;

public class ListaLigada {
    private No primeiro, ultimo;

    public ListaLigada() {
        primeiro = null;
        ultimo = null;
    }

    public boolean listaVazia() {
        if(primeiro == null) {
            return true;
        }

        return false;
    }

    public void inserirInicio(Object element) {
        No novoNo = new No(element);

        if(listaVazia()) {
            ultimo = novoNo;
        } else {
            novoNo.prox = primeiro;
        }

        primeiro = novoNo;
    }

    public void inserirFinal(Object element) {
        No novoNo = new No(element);

        if(listaVazia()) {
            primeiro = novoNo;
        } else {
            ultimo.prox = novoNo;
        }

        ultimo = novoNo;
    }

    public int contarNos() {
        int tamanho = 0;
        No noTemp = primeiro;

        while(noTemp != null) {
            tamanho = tamanho + 1;
            noTemp = noTemp.prox;
        }

        return tamanho;
    }

    public void inserirMeio(Object element, int posicao) {
        No novoNo = new No(element);
        No noTemp = primeiro;
        int nroNos, posAux = 1;

        nroNos = contarNos();

        if(posicao <= 1) {
            inserirInicio(novoNo);
        } else if(posicao > nroNos) {
            inserirFinal(novoNo);
        } else {
            while(posAux < (posicao - 1)) {
                noTemp = noTemp.prox;
                posAux = posAux + 1;
            }

            novoNo.prox = noTemp.prox;
            noTemp.prox = novoNo;
        }
    }

    public void remover(Object element) {
        No noTemp = primeiro;
        No noAnt = null;

        if(primeiro.elemento.equals(element)) {
            primeiro = primeiro.prox;
        } else {
            while((noTemp != null) && (!noTemp.elemento.equals(element))) {
                noAnt = noTemp;
                noTemp = noTemp.prox;
            }

            if(noTemp != null) {
                noAnt.prox = noTemp.prox;
            }

            if(noTemp == ultimo) {
                ultimo = noAnt;
            }
        }
    }

    public Object elementoInicio() throws IOException {
        if(!listaVazia()) {
            return primeiro.elemento;
        }

        throw new IOException();
    }

    public Object elementoFinal() throws IOException {
        if(!listaVazia()) {
            return ultimo.elemento;
        }

        throw new IOException();
    }

    public String buscarNo(Object element) {
        No noTemp = primeiro;
        boolean found = false;

        while((noTemp != null) && (!found)) {
            if(noTemp.elemento.equals(element)) {
                found = true;
            } else {
                noTemp = noTemp.prox;
            }
        }

        return found ? "Sim" : "Não";
    }

    public void mostrarLista() {
        int i = 1;
        No noTemp = primeiro;

        while(noTemp != null) {
            System.out.println("Elemento: " + noTemp.elemento + " posição: " + i);
            noTemp = noTemp.prox;
            i++;
        }
    }
}

