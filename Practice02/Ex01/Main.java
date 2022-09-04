package Practice02.Ex01;

/*
    Questão 01:
    Uma agência bancária necessita organizar a fila para atendimento do
    Auxílio Brasil. Cada usuário receberá uma senha numérica, serão
    atendidas 200 pessoas por dia.
    Percebeu-se que as pessoas que possuem senha impar até o número
    100 são consideradas prioridade, por isso, devem ficar em outra fila
    separada.

    Fazer um programa usando lista que gere a entrada de dados de 200
    pessoas, separe as pessoas com a senha impar até o número 100,
    criando a lista de prioridades. Ao final deverão ser impressos a lista de
    prioridade e a lista ordenada das pessoas que estão na fila comum.
*/

public class Main {
    public static void main(String[] args) {
        ListaLigada filaPrioridade = new ListaLigada();
        ListaLigada filaComum = new ListaLigada();

        for(int i = 1; i <= 200; i++) {
            if ((1 % 2 != 0) && (i <= 100)) {
                filaPrioridade.inserirFinal(i);
            } else {
                filaComum.inserirFinal(i);
            }
        }

        System.out.println("----------------- Fila Prioridade ---------------- \n");
        filaPrioridade.mostrarLista();

        System.out.println("\n----------------- Fila Comum ---------------- \n");
        filaComum.mostrarLista();
    }
}