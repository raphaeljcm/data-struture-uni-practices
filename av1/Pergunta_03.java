package av1;

import java.util.*;

public class Pergunta_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String option = "";
        Deque<PostRedeSocial> deque = new ArrayDeque<>();

        while(!option.equals("3")) {
            System.out.println("Digite 1, 2 ou 3");
            option = scan.nextLine();

            switch (option) {
                case "1":
                    System.out.println("Insira a mensagem do post");
                    var mensagem = scan.nextLine();

                    System.out.println("Insira a relevância do post");
                    var relevancia = scan.nextByte();
                    scan.nextLine();

                    var post = new PostRedeSocial(mensagem, relevancia);

                    if(post.getRelevancia() == 1) {
                        deque.addFirst(post);
                    } else {
                        deque.addLast(post);
                    }
                    break;
                case "2":
                    if(!deque.isEmpty()) {
                        System.out.println("----- POSTS ------ ");

                        for(Iterator itr = deque.descendingIterator(); itr.hasNext();) {
                            var atual = (PostRedeSocial)itr.next();

                            if(atual.getRelevancia() == 1) {
                                System.out.println(atual.getMsg());
                            }
                        }
                    } else {
                        System.out.println("Deque vazio!");
                    }
                    break;
                case "3":
                    System.out.println("Tchau!");
                    break;
                default:
                    System.out.println("Erro, tente novamente!");
                    break;
            }
        }

        scan.close();
    }
}
