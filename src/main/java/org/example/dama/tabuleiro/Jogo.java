package org.example.dama.tabuleiro;

public class Jogo {
    private Tabuleiro tabuleiro;
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorAtual;


    public Jogo(){
        tabuleiro = new Tabuleiro();
        tabuleiro.inicializar();
        jogador1 = new Jogador("Waldeman", "Branco");
        jogador2 = new Jogador("Hugo", "Preto");
        jogadorAtual = getJogadorBranco();

    }
    public boolean podeCapturar(int linha, int coluna, int linhaDestino, int colunaDestino){
        //Branco
        if (!tabuleiro.getCasa(linha, coluna).isVazia()){
            if (!getJogadorAtual().getCorPecas().equals(tabuleiro.getCasa(linha,coluna).getPeca().getCorDaPeca())) {
                return false;
            }
            if (tabuleiro.getCasa(linhaDestino, colunaDestino).isVazia()){
                if(linha + 2 == linhaDestino && coluna + 2 == colunaDestino){
                    if(!tabuleiro.getCasa(linhaDestino-1, colunaDestino-1).isVazia() &&
                    !tabuleiro.getCasa(linhaDestino-1, colunaDestino-1).getPeca().getCorDaPeca().equals(jogadorAtual.getCorPecas())){
                        return true;
                    }
                }else if ((linha + 2 == linhaDestino && coluna - 2 == colunaDestino)){
                    if (!tabuleiro.getCasa(linhaDestino-1, colunaDestino+1).isVazia() &&
                            !tabuleiro.getCasa(linhaDestino-1, colunaDestino+1).getPeca().getCorDaPeca().equals(jogadorAtual.getCorPecas())) {
                        return true;
                    }
            }
            }
        }
        //Preto
        
        return false;
    }
    public void moverPeca(int linha, int coluna, int linhaDestino, int colunaDestino){
        if (podeMover(linha, coluna, linhaDestino, colunaDestino)){
            tabuleiro.getCasa(linhaDestino, colunaDestino).botarPeca(tabuleiro.getCasa(linha, coluna).getPeca());
            tabuleiro.getCasa(linha, coluna).retirarPeca();
            trocarJogador();
        }
    }
    public boolean podeMover(int linha, int coluna, int linhaDestino, int colunaDestino){
        if (tabuleiro.getCasa(linha, coluna).isVazia()){
            return false;
        }else if (!getJogadorAtual().getCorPecas().equals(tabuleiro.getCasa(linha,coluna).getPeca().getCorDaPeca())) {
            return false;
        } else if (!tabuleiro.getCasa(linhaDestino, colunaDestino).isVazia()) {
            return false;
        }else if (tabuleiro.getCasa(linha, coluna).getPeca().getCorDaPeca().equals("Branco")) {
            if (linha + 1 == linhaDestino &&
                    (coluna + 1 == colunaDestino || coluna - 1 == colunaDestino)) {
                return true;
            }
        } else {
            if (linha - 1 == linhaDestino &&
                    (coluna + 1 == colunaDestino || coluna - 1 == colunaDestino)) {
                return true;
            }
        }
        return false;
    }
    public void trocarJogador(){
        if (this.jogadorAtual == jogador1){
            this.jogadorAtual = jogador2;
        }else{
            this.jogadorAtual = jogador1;
        }
    }
    public Tabuleiro getTabuleiro(){
        return this.tabuleiro;
    }

    public Jogador getJogadorBranco() {
        if(this.jogador1.getCorPecas().equals("Branco")){
            return this.jogador1;
        }else{
            return this.jogador2;
        }
    }
    public Jogador getJogadorPreto(){
        if(this.jogador1.getCorPecas().equals("Preto")){
            return this.jogador1;
        }else{
            return this.jogador2;
        }
    }
    public Jogador getJogadorAtual(){
        return this.jogadorAtual;
    }

}
