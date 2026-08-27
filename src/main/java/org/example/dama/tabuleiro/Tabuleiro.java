package org.example.dama.tabuleiro;

public class Tabuleiro {
    private Casa[][] casas;

    public Tabuleiro(){
        casas = new Casa[8][8];
        for (int i = 0; i < casas.length; i++) {
            for (int j = 0; j < casas[i].length; j++) {
                casas[i][j] = new Casa(i,j,null);
            }
        }
    }
    public Casa getCasa(int linha, int coluna){
        return this.casas[linha][coluna];
    }
    public void limparTabuleiro(){
        for(int i = 0; i < casas.length; i++){
            for(int j = 0; j < casas[i].length; j++){
                casas[i][j].retirarPeca();
            }
        }
    }
        public void inicializar(){
            for (int i = 0; i < casas.length; i++){
                for (int j = 0; j < casas[i].length; j++){
                    if( (i + j) % 2 == 0){
                        if (i < 3){
                            Peca p1 = new Peca("Branco");
                            casas[i][j].botarPeca(p1);
                        }
                        if (i > 4){
                            Peca p2 = new Peca("Preto");
                            casas[i][j].botarPeca(p2);
                        }
                    }
                }
            }
        }
}
