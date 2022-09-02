package Practice02.Ex02;

public class Main {
    public static void main(String[] args) {
        ListaLigada listaNoiva = new ListaLigada();
        ListaLigada listaNoivo = new ListaLigada();
        ListaLigada listaJoin = new ListaLigada();
        RandomName name = new RandomName();

        // Noiva
        for(int i = 0; i < 60; i++) {
            listaNoiva.adicionar(name.randomIdentifier());
        }

        // Noivo
        for(int i = 0; i < 55; i++) {
            listaNoivo.adicionar(name.randomIdentifier());
        }

        // União
        for(int i = 0; i < listaNoiva.getTamanho(); i++) {
            listaJoin.adicionar(listaNoiva.get(i).getValor());
        }

        for(int i = 0; i < listaNoivo.getTamanho(); i++) {
            listaJoin.adicionar(listaNoivo.get(i).getValor());
        }

        // Mostrar
        for(int i = 0; i < listaJoin.getTamanho(); i++) {
            System.out.println(listaJoin.get(i).getValor());
        }
    }
}