package Practice02.Ex02;

public class Elemento {
    private String valor;
    private Elemento proximo;

    public Elemento(String novoValor) {
        valor = novoValor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Elemento getProximo() {
        return proximo;
    }

    public void setProximo(Elemento proximo) {
        this.proximo = proximo;
    }
}
