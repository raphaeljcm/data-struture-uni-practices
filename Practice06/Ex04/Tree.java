package Practice06.Ex04;

public class Tree {
    private No root; // raiz

    public Tree() { root=null; } // inicializa arvore

    public void inserir(long v) {
        No novo = new No(); // cria um novo N�
        novo.item = v; // atribui o valor recebido ao item de dados do N�
        novo.dir = null;
        novo.esq = null;

        if (root == null) root = novo;
        else  { // se nao for a raiz
            No atual = root;
            No anterior;
            while(true) {
                anterior = atual;
                if (v <= atual.item) { // ir para esquerda
                    atual = atual.esq;
                    if (atual == null) {
                        anterior.esq = novo;
                        return;
                    }
                }  // fim da condi��o ir a esquerda
                else { // ir para direita
                    atual = atual.dir;
                    if (atual == null) {
                        anterior.dir = novo;
                        return;
                    }
                } // fim da condi��o ir a direita
            } // fim do la�o while
        } // fim do else n�o raiz

    }

    public No buscar(long chave) {
        if (root == null) return null; // se arvore vazia
        No atual = root;  // come�a a procurar desde raiz
        while (atual.item != chave) { // enquanto nao encontrou
            if(chave < atual.item ) atual = atual.esq; // caminha para esquerda
            else atual = atual.dir; // caminha para direita
            if (atual == null) return null; // encontrou uma folha -> sai
        } // fim la�o while
        return atual; // terminou o la�o while e chegou aqui � pq encontrou item
    }


    public boolean remover(long v) {
        if (root == null) return false; // se arvore vazia

        No atual = root;
        No pai = root;
        boolean filho_esq = true;

        // ****** Buscando o valor **********
        while (atual.item != v) { // enquanto nao encontrou
            pai = atual;
            if(v < atual.item ) { // caminha para esquerda
                atual = atual.esq;
                filho_esq = true; // � filho a esquerda? sim
            }
            else { // caminha para direita
                atual = atual.dir;
                filho_esq = false; // � filho a esquerda? NAO
            }
            if (atual == null) return false; // encontrou uma folha -> sai
        } // fim la�o while de busca do valor

        // **************************************************************
        // se chegou aqui quer dizer que encontrou o valor (v)
        // "atual": contem a referencia ao No a ser eliminado
        // "pai": contem a referencia para o pai do No a ser eliminado
        // "filho_esq": � verdadeiro se atual � filho a esquerda do pai
        // **************************************************************

        // Se nao possui nenhum filho (� uma folha), elimine-o
        if (atual.esq == null && atual.dir == null) {
            if (atual == root ) root = null; // se raiz
            else if (filho_esq) pai.esq = null; // se for filho a esquerda do pai
            else pai.dir = null; // se for filho a direita do pai
        }

        // Se � pai e nao possui um filho a direita, substitui pela subarvore a direita
        else if (atual.dir == null) {
            if (atual == root) root = atual.esq; // se raiz
            else if (filho_esq) pai.esq = atual.esq; // se for filho a esquerda do pai
            else pai.dir = atual.esq; // se for filho a direita do pai
        }

        // Se � pai e nao possui um filho a esquerda, substitui pela subarvore a esquerda
        else if (atual.esq == null) {
            if (atual == root) root = atual.dir; // se raiz
            else if (filho_esq) pai.esq = atual.dir; // se for filho a esquerda do pai
            else pai.dir = atual.dir; // se for  filho a direita do pai
        }

        // Se possui mais de um filho, se for um av� ou outro grau maior de parentesco
        else {
            No sucessor = no_sucessor(atual);
            // Usando sucessor que seria o N� mais a esquerda da subarvore a direita do No que deseja-se remover
            if (atual == root) root = sucessor; // se raiz
            else if(filho_esq) pai.esq = sucessor; // se for filho a esquerda do pai
            else pai.dir = sucessor; // se for filho a direita do pai
            sucessor.esq = atual.esq; // acertando o ponteiro a esquerda do sucessor agora que ele assumiu
            // a posi��o correta na arvore
        }

        return true;
    }

    // O sucessor � o N� mais a esquerda da subarvore a direita do No que foi passado como parametro do metodo
    public No no_sucessor(No apaga) { // O parametro � a referencia para o No que deseja-se apagar
        No paidosucessor = apaga;
        No sucessor = apaga;
        No atual = apaga.dir; // vai para a subarvore a direita

        while (atual != null) { // enquanto nao chegar no N� mais a esquerda
            paidosucessor = sucessor;
            sucessor = atual;
            atual = atual.esq; // caminha para a esquerda
        }
        // *********************************************************************************
        // quando sair do while "sucessor" ser� o N� mais a esquerda da subarvore a direita
        // "paidosucessor" ser� o o pai de sucessor e "apaga" o N� que dever� ser eliminado
        // *********************************************************************************
        if (sucessor != apaga.dir) { // se sucessor nao � o filho a direita do N� que dever� ser eliminado
            paidosucessor.esq = sucessor.dir; // pai herda os filhos do sucessor que sempre ser�o a direita
            // lembrando que o sucessor nunca poder� ter filhos a esquerda, pois, ele sempre ser� o
            // N� mais a esquerda da subarvore a direita do N� apaga.
            // lembrando tamb�m que sucessor sempre ser� o filho a esquerda do pai

            sucessor.dir = apaga.dir; // guardando a referencia a direita do sucessor para
            // quando ele assumir a posi��o correta na arvore
        }
        return sucessor;
    }

    public void caminhar() {
        System.out.print("\n Exibindo em ordem: ");
        inOrder(root);
        System.out.print("\n Exibindo em pos-ordem: ");
        posOrder(root);
        System.out.print("\n Exibindo em pre-ordem: ");
        preOrder(root);
        System.out.print("\n Altura da arvore: " + altura(root));
        System.out.print("\n Quantidade de folhas: " + folhas(root));
        System.out.print("\n Quantidade de N�s: " + contarNos(root));
        if (root != null ) {  // se arvore nao esta vazia
            System.out.print("\n Valor minimo: " + min().item);
            System.out.println("\n Valor maximo: " + max().item);
        }
    }

    public void inOrder(No atual) {
        if (atual != null) {
            inOrder(atual.esq);
            System.out.print(atual.item + " ");
            inOrder(atual.dir);
        }
    }

    public void preOrder(No atual) {
        if (atual != null) {
            System.out.print(atual.item + " ");
            preOrder(atual.esq);
            preOrder(atual.dir);
        }
    }

    public void posOrder(No atual) {
        if (atual != null) {
            posOrder(atual.esq);
            posOrder(atual.dir);
            System.out.print(atual.item + " ");
        }
    }

    public int altura(No atual) {
        if(atual == null || (atual.esq == null && atual.dir == null))
            return 0;
        else {
            if (altura(atual.esq) > altura(atual.dir))
                return ( 1 + altura(atual.esq) );
            else
                return ( 1 + altura(atual.dir) );
        }
    }

    public int folhas(No atual) {
        if(atual == null) return 0;
        if(atual.esq == null && atual.dir == null) return 1;
        return folhas(atual.esq) + folhas(atual.dir);
    }

    public int contarNos(No atual) {
        if(atual == null)  return 0;
        else return ( 1 + contarNos(atual.esq) + contarNos(atual.dir));
    }

    public No min() {
        No atual = root;
        No anterior = null;
        while (atual != null) {
            anterior = atual;
            atual = atual.esq;
        }
        return anterior;
    }

    public No max() {
        No atual = root;
        No anterior = null;
        while (atual != null) {
            anterior = atual;
            atual = atual.dir;
        }
        return anterior;
    }

}