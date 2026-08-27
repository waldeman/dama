package org.example.dama.tabuleiro;

public class Jogador {
    private String nome;
    private String corPecas;
    private int qtdPecas;
    public  Jogador(String nome, String corPecas) {
        this.nome = nome;
        this.corPecas = corPecas;
        this.qtdPecas = 12;
    }
    public String getNome() {
        return this.nome;
    }
    public String getCorPecas() {
        return this.corPecas;
    }
    public int getQtdPecas() {
        return this.qtdPecas;
    }
    public void perderPeca(){
        if (this.qtdPecas > 0){
            this.qtdPecas--;
        }

    }

}
