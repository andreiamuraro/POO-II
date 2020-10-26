package exe2;
/**
 *
 * @author andreia
 */
public final class Cartas {
    public static final int AS = 1;
    public static final int VALETE = 11;
    public static final int DAMA = 12;
    public static final int REI = 13;
    public static final int PAUS = 0;
    public static final int OUROS = 1;
    public static final int COPAS = 2;
    public static final int ESPADAS = 3;

    private String carta;
    private String naipe; 

    public Cartas(String carta, String naipe) {
        this.setCarta(carta);
        this.setNaipe(naipe);
    }
    
    public String getCarta() {
        return carta;
    }

    public void setCarta(String carta) {
         if(carta.equalsIgnoreCase("AS") || carta.equalsIgnoreCase("VALETE") 
                || carta.equalsIgnoreCase("DAMA") || carta.equalsIgnoreCase("REI")
                || carta.equals("DOIS") || carta.equals("TRES") || carta.equals("QUATRO") 
                || carta.equals("CINCO") || carta.equals("SEIS") || carta.equals("SETE")
                || carta.equals("OITO") || carta.equals("NOVE") || carta.equals("DEZ")){
        this.carta = carta;
        }else
            throw new RuntimeException ("CARTA ERRADA");
    }

    public String getNaipe() {
        return naipe;
    }

    public void setNaipe(String naipe) {
         if(!naipe.equalsIgnoreCase("PAUS") && !naipe.equalsIgnoreCase("COPAS") && !naipe.equalsIgnoreCase("OUROS") 
                 && !naipe.equalsIgnoreCase("ESPADAS")){
             throw new RuntimeException ("NAIPE ERRADO");
         }else{
             this.naipe = naipe;
         }
    }

    public String imprime() {
        return "\n" + carta + " DE "+ naipe + "\n" ;
    }
}

    