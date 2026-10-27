package cl.duoc.esports.model;

public abstract class Jugador{
    protected String nickname;
    protected String videojuego;
    protected int nivel;
    protected int puntitos;

    public Jugador() {
    }

    public Jugador(String nickname, String videojuego, int nivel, int puntitos) {
        setNickname(nickname);
        setVideojuego(videojuego);
        setNivel(nivel);
        setPuntitos(puntitos);
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        if(nickname==null || nickname.isBlank()){
            throw new IllegalArgumentException("El nickname no puede estar vacio o en blanco.");
        }
        this.nickname = nickname;
    }

    public String getVideojuego() {
        return videojuego;
    }

    public void setVideojuego(String videojuego) {
        if(videojuego==null || videojuego.isBlank()){
            throw new IllegalArgumentException("El videojuego no puede estar vacio o en blanco.");
        }
        this.videojuego = videojuego;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        if(nivel<=0){
            throw new IllegalArgumentException("El nivel debe ser positivo.");
        }
        this.nivel = nivel;
    }

    public int getPuntitos() {
        return puntitos;
    }

    public void setPuntitos(int puntitos) {
        if(puntitos<0){
            throw new IllegalArgumentException("Puntos deben ser positivos.");
        }this.puntitos = puntitos;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nickname='" + nickname + '\'' +
                ", videojuego='" + videojuego +
                ", nivel=" + nivel +'\''+
                ",puntitos="+puntitos+
                '}';
    }

    public abstract int calcularPuntos();
}
