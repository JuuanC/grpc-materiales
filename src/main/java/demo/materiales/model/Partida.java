package demo.materiales.model;

public class Partida {
    private int idPartida;
    private int clave;
    private String descripción;
    private String usuario;

    public Partida() {
    }

    public Partida(int idPartida, int clave, String descripción, String usuario) {
        this.idPartida = idPartida;
        this.clave = clave;
        this.descripción = descripción;
        this.usuario = usuario;
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
