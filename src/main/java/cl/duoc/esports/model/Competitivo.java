package cl.duoc.esports.model;

public class Competitivo extends Jugador implements Clasificable{
    private int victorias;

    public Competitivo() {
    }

    public Competitivo(String nickname, String videojuego, int nivel,int puntitos, int victorias) {
        super(nickname, videojuego, nivel, puntitos);
        setVictorias(victorias);
    }

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        if(victorias<0){
            throw new IllegalArgumentException("La cantidad de victorias no puede ser negativa");
        }
        this.victorias = victorias;
    }

    @Override
    public String toString() {
        return super.toString() + "Competitivo{" +
                "victorias=" + victorias +
                '}';
    }

    @Override
    public int calcularPuntos() {
        puntitos=(super.nivel * 10) + (this.victorias * 50);
        return puntitos;
    }


    @Override
    public String obtenerRango() {
        int puntos = calcularPuntos();
        if(puntos<500){
            return "Bronce";
        }else if(puntos<=999){
            return "Plata";
        }else{
            return "Oro";
        }
    }
}
