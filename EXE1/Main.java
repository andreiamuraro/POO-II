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
public class Main {
    public  static  void  main ( String [] args ) {
        Livraria Livraria1 = new Livraria( " SELVA LITERÁRIA " );
        Autor autor1 = new Autor ("Sofia Silva " );
        Livro livro1 =  new Livro ("Sorrisos Quebrados",autor1,2 );
        livro1.setCapitulo (0,"Dolorosamente Colorida");
        livro1.setCapitulo (1,"Surpreendentemente Brilhante");
        livro1.printLivro ();
        System.out.println();
        Autor autor2 = new Autor ("R.J.Palacio " );
        Livro livro2 =  new Livro ("Extraordinário",autor2,2 );
        livro2.setCapitulo (0,"August " );
        livro2.setCapitulo (1,"Via" );
        livro2.printLivro ();
        Livraria1.adicaoLivro(livro2);
        System.out.println();
        Autor autor3 = new  Autor (" Leandro Moreira " );
        Livro livro3 =  new Livro (" Seja um Líder de Heróis " ,autor3,3 );
        livro3.setCapitulo (0,"Herói Daros, O Professor" );
        livro3.setCapitulo (1,"Herói U3D, O Apaixonado" );
        livro3.setCapitulo (2,"Herói Adler, O Experiente" );
        livro3.printLivro ();
        System.out.println();
        Livraria1.adicaoLivro (livro3);
        System.out.println();
    }
    
}
