package stack.Exemplos_Pilha_Fila.exemplo.listaduplamenteencadeada;

/*O <T> � usado quando se quer criar uma classe onde suas vari�veis s�o de um tipo que n�o � definido no momento em que ela � escrita,
 * mas sim no momento que ela � usada, deixando a crit�rio do usu�rio dessa classe qual ser� o tipo da vari�vel no lugar do T.
Al�m de T que � uma abrevia��o para o "tipo", existem outras siglas padronizadas por conven��o entre os desenvolvedores Java:
E - Elemento
K - Chave
N - N�mero
T - Tipo
V - Valor
*/

public class NoDuplo <T> {
	private T conteudo;
    private NoDuplo<T> noProximo;
    private NoDuplo<T> noPrevio;

    public NoDuplo(T conteudo) {
        this.conteudo = conteudo;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public NoDuplo<T> getNoProximo() {
        return noProximo;
    }

    public void setNoProximo(NoDuplo<T> noProximo) {
        this.noProximo = noProximo;
    }

    public NoDuplo<T> getNoPrevio() {
        return noPrevio;
    }

    public void setNoPrevio(NoDuplo<T> noPrevio) {
        this.noPrevio = noPrevio;
    }

    @Override
    public String toString() {
        return "NoDuplo{" +
                "conteudo=" + conteudo +
                '}';
    }
}

