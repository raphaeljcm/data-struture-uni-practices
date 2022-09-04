package Practice02.Ex02;

public class BubbleSort {

    public ListaLigada sortList(ListaLigada unorderedList) {
        String temp;

        for(int i = 0; i < unorderedList.getTamanho(); i++) {
            for(int j = i + 1; j < unorderedList.getTamanho(); j++) {
                // comparar string
                if(unorderedList.get(i).getValor().compareTo(unorderedList.get(j).getValor()) > 0) {
                    temp = unorderedList.get(j).getValor();
                    unorderedList.get(j).setValor(unorderedList.get(i).getValor());
                    unorderedList.get(i).setValor(temp);
                }
            }
        }

        return unorderedList;
    }
}
