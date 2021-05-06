package demo.materiales.dto;

public class InsumoDTO {
    private String insumo;
    private int clave;
    private String partida;
    private String usuario;

    public InsumoDTO() {
    }

    public InsumoDTO(String insumo, int clave, String partida, String usuario) {
        this.insumo = insumo;
        this.clave = clave;
        this.partida = partida;
        this.usuario = usuario;
    }

    public String getInsumo() {
        return insumo;
    }

    public void setInsumo(String insumo) {
        this.insumo = insumo;
    }

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
