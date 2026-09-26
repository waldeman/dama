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
    public void verificarDama(int linha, int coluna){
        if (this.jogadorAtual.getCorPecas().equals("Preto") && linha == 0){
            this.tabuleiro.getCasa(linha, coluna).getPeca().transformarDama();
        } else if (this.jogadorAtual.getCorPecas().equals("Branco") && linha == 7) {
            this.tabuleiro.getCasa(linha, coluna).getPeca().transformarDama();
        }
    }
    public void capturar(int linha, int coluna, int linhaDestino, int colunaDestino){
        if (podeCapturar(linha, coluna, linhaDestino, colunaDestino)){
            int linhaDiferenca = linha - linhaDestino;
            int colunaDiferenca = coluna - colunaDestino;
            int linhaMeio;
            int colunaMeio;
            if( linhaDiferenca < 0){
                linhaMeio = linha+1;
            }else{
                linhaMeio = linha-1;
            }
            if( colunaDiferenca >= 0){
                colunaMeio = coluna-1;
            }else{
                colunaMeio = coluna+1;
            }
            this.tabuleiro.getCasa(linhaMeio, colunaMeio).retirarPeca();
            this.tabuleiro.getCasa(linhaDestino, colunaDestino).botarPeca(this.tabuleiro.getCasa(linha,coluna).getPeca());
            this.verificarDama(linhaDestino, colunaDestino);
            this.tabuleiro.getCasa(linha, coluna).retirarPeca();
            this.trocarJogador();
            this.jogadorAtual.perderPeca();
        }
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
        if (!tabuleiro.getCasa(linha, coluna).isVazia()){
            if (!getJogadorAtual().getCorPecas().equals(tabuleiro.getCasa(linha,coluna).getPeca().getCorDaPeca())) {
                return false;
            }
            if (tabuleiro.getCasa(linhaDestino, colunaDestino).isVazia()){
                if(linha - 2 == linhaDestino && coluna + 2 == colunaDestino){
                    if(!tabuleiro.getCasa(linhaDestino+1, colunaDestino-1).isVazia() &&
                            !tabuleiro.getCasa(linhaDestino+1, colunaDestino-1).getPeca().getCorDaPeca().equals(jogadorAtual.getCorPecas())){
                        return true;
                    }
                }else if ((linha - 2 == linhaDestino && coluna - 2 == colunaDestino)){
                    if (!tabuleiro.getCasa(linhaDestino+1, colunaDestino+1).isVazia() &&
                            !tabuleiro.getCasa(linhaDestino+1, colunaDestino+1).getPeca().getCorDaPeca().equals(jogadorAtual.getCorPecas())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public void moverPeca(int linha, int coluna, int linhaDestino, int colunaDestino){
        if (podeMover(linha, coluna, linhaDestino, colunaDestino)){
            tabuleiro.getCasa(linhaDestino, colunaDestino).botarPeca(tabuleiro.getCasa(linha, coluna).getPeca());
            tabuleiro.getCasa(linha, coluna).retirarPeca();
            this.verificarDama(linhaDestino, colunaDestino);
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
        } else if (this.tabuleiro.getCasa(linha, coluna).getPeca().isDama()) {
            if(linha+1 == linhaDestino && coluna +1 == colunaDestino || linha+1 == linhaDestino && coluna-1 == colunaDestino || linha-1 == linhaDestino && coluna+1 == colunaDestino || linha-1 == linhaDestino && coluna-1 == colunaDestino){
                return true;
            }

        } else if (tabuleiro.getCasa(linha, coluna).getPeca().getCorDaPeca().equals("Branco")) {
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
