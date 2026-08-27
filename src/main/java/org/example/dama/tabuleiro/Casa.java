package org.example.dama.tabuleiro;

public class Casa {
    private int linha;
    private int coluna;
    private Peca peca;

    public Casa(int linha, int coluna, Peca peca){
        this.linha = linha;
        this.coluna = coluna;
        this.peca = peca;
    }
    public void botarPeca(Peca peca){
        if (isVazia()){
            this.peca = peca;
        }
    }
    public void retirarPeca(){
        if (!isVazia()){
            this.peca = null;
        }
    }
    public boolean isVazia() {
        return peca == null;
    }

    public Peca getPeca() {
        return this.peca;
    }

    public int getColuna() {
        return this.coluna;
    }
    public int getLinha() {
        return this.linha;
    }
}
