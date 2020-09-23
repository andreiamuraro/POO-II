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
public class Livro {

        private final String ISBN;
        private final int num_Capitulos;
        private final Autor autor;
        private final Capitulo capitulo[];

        public String getISBN() {
            return ISBN;
        }

    public int getNum_Capitulos() {
        return num_Capitulos;
    }

    public Autor getAutor() {
        return autor;
    }

    public Capitulo[] getCapitulo() {
        return capitulo;
    }
        public Livro ( String  ISBN , Autor  autor , int  num_Capitulos ) {
        this.ISBN = ISBN ;
        this.autor =autor;
        this.num_Capitulos = num_Capitulos;
        this.capitulo = new Capitulo [num_Capitulos];
    }
    public  void  setCapitulo ( int num , String  titulo ) {
        this.capitulo[num] = new Capitulo (num,this,titulo);
    }
    public  void  printLivro () {
        System.out.println( "LIVRO: " +  this. ISBN );
        System.out.println ( "AUTOR: "  +  this. autor . getName ());
        for ( int i =  0 ; i <  this . num_Capitulos; i ++ ) {
            System.out.println( "CAPÍTULO: "+i+ "\t" + this.capitulo [i].getNome());
        }
    }
}

