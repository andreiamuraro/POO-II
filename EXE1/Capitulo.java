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
public class Capitulo {

    private final int numero ;
    private final Livro livro ;
    private final String nome;

    public Capitulo ( int numero , Livro livro ,String nome) {  
        this.numero = numero;
        this.livro = livro;
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public Livro getLivro() {
        return livro;
    }

    public String getNome() {
        return nome;
    }
    }
    

