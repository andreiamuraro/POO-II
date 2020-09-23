/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exe1;

/**
 *
 * @author andreia
 */
public class Livraria {

    private final String nome;
    private final Livro livro[];
    private int numLivro;

    public Livraria(String nome) {
        this.nome = nome;
        this.livro = new Livro[10];
        this.numLivro = 0;
    }

    public void setNumLivro(int numLivro) {
        this.numLivro = numLivro;
    }

    public String getNome() {
        return nome;
    }

    public Livro[] getLivro() {
        return livro;
    }

    public void adicaoLivro(Livro livro) {
        this.livro[this.numLivro] = livro;
        this.numLivro++;
    }

    public int getNumLivro() {
        return this.numLivro;
    }

    public void inf_Livro() {
        System.out.println("LIVRARIA: " + this.nome);
        System.out.println("LIVRO ");
        for (int i = 0; i < this.numLivro; i++) {
            System.out.println("LIVRO: " +i+ "\n" + "TÍTULO: " + this.livro[i].getISBN());
        }
    }

}
