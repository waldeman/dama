package org.example.dama.tabuleiro;

public class Peca {
    private String corDaPeca;
    private boolean dama;

    public Peca(String corDaPeca){
        setCorDaPeca(corDaPeca);
        this.dama = false;

    }
    public void transformarDama(){
        this.dama = true;
    }
    public String getCorDaPeca() {
        return this.corDaPeca;
    }
    public void setCorDaPeca(String corDaPeca) {
        if (corDaPeca != null && !corDaPeca.isBlank()){
            this.corDaPeca = corDaPeca;
        }
    }
    public boolean isDama() {
        return this.dama;
    }


}
