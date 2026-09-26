package org.example.dama.tabuleiro;

public class Main {
    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        jogo.getTabuleiro().getCasa(3, 3).retirarPeca();
        jogo.getTabuleiro().getCasa(3, 5).retirarPeca();
        jogo.getTabuleiro().getCasa(5, 3).retirarPeca();
        jogo.getTabuleiro().getCasa(5, 5).retirarPeca();

        // Coloca uma dama em (4,4)
        Casa casa = jogo.getTabuleiro().getCasa(4, 4);
        casa.retirarPeca();

        Peca dama = new Peca("Branco");
        dama.transformarDama();
        casa.botarPeca(dama);

        System.out.println("↖ Dama (4,4) -> (3,3): "
                + jogo.podeMover(4, 4, 3, 3));

        System.out.println("↗ Dama (4,4) -> (3,5): "
                + jogo.podeMover(4, 4, 3, 5));

        System.out.println("↙ Dama (4,4) -> (5,3): "
                + jogo.podeMover(4, 4, 5, 3));

        System.out.println("↘ Dama (4,4) -> (5,5): "
                + jogo.podeMover(4, 4, 5, 5));

        System.out.println("→ Dama (4,4) -> (4,5): "
                + jogo.podeMover(4, 4, 4, 5));

        System.out.println("↓ Dama (4,4) -> (6,4): "
                + jogo.podeMover(4, 4, 6, 4));
    }
}
