package exe2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 *
 * @author andreia
 */
public class Baralho {
    private final ArrayList<Cartas> cartas;

    public Baralho() {
        cartas = new ArrayList<>();
        iniciarBaralho();
    }
   
    public Baralho(ArrayList<Cartas> cartas){
        this.cartas = cartas;
    }
    private void iniciarBaralho() {
        String carta[] = {"AS","DOIS","TRES","QUATRO","CINCO","SEIS","SETE",
            "OITO","NOVE","DEZ","VALETE","DAMA","REI"};
        String naipe[] = {"ESPADAS","COPAS","OUROS","PAUS"};
        try{
            for(int i = 0; i < 13; i++){
                for(int j = 0; j < 4; j++){
                    adicionaCarta(carta[i], naipe[j]);
                }
            }
        }catch(Exception e){
            System.out.println("ERRO:" + e);     
        }
    }

    public void adicionaCarta(String carta, String naipe) {
        Cartas novaCarta = new Cartas(carta, naipe);
        cartas.add(novaCarta);
    }
    
    public void embaralhar(){ 
         try{
            int quantidade = 52;
            List<Integer> baralhoAleatorio = new ArrayList<>();
            int sorteio;
            System.out.println("BARALHO ALETÓRIO");
            do {
                boolean adicionarLista = true;
                sorteio = (int) (Math.random() * 52); 
                for (int i : baralhoAleatorio){
                    if (i == sorteio) {
                        adicionarLista = false;
                        break;
                    }
                }
                if (adicionarLista) { baralhoAleatorio.add(sorteio); }
            }while (baralhoAleatorio.size() < quantidade);
            baralhoAleatorio.forEach((x) -> {
                System.out.println(cartas.get(x).imprime());
             });
            System.out.println("---------------------------------");
         }catch(Exception c){
             System.out.println("ERRO: " + c.getMessage());
         }
    }
    
    public void tirarCartas(int quantidadeCartas){
        try{
            Random gerador = new Random();
            System.out.println("CARTA RETIRADA" + cartas.get
        (gerador.nextInt(quantidadeCartas)).imprime() );
            System.out.println("----------------------------------------");
        }catch(Exception e){
            System.out.println("CARTA NÃO ENCONTRADA");
        }
    }
    
    public void impressao() {
        System.out.println("INICIO DO BARALHO");
         try{
            for(int i = 0; i<52;i++){
                System.out.println(cartas.get(i).imprime());
            }
         }catch(Exception e){
            System.out.println("QUANTIDADE INVALIDA DE CARTAS " );     
        }        
        System.out.println("FINAL DO BARALHO");
    }
}

