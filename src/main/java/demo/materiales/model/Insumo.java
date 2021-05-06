package demo.materiales.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "insumo", schema = "catalogo")
public class Insumo {
    private Long idInsumo;
    private int clave;
    private String descripcion;
    private int idPartida;
    private String usuario;

    @Id
    @Column(name = "id_insumo")
    public Long getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(Long idInsumo) {
        this.idInsumo = idInsumo;
    }

    @Basic
    @Column(name = "clave")
    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    @Basic
    @Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "id_partida")
    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    @Basic
    @Column(name = "usuario")
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Insumo insumo = (Insumo) o;
        return idInsumo == insumo.idInsumo && clave == insumo.clave && idPartida == insumo.idPartida && Objects.equals(descripcion, insumo.descripcion) && Objects.equals(usuario, insumo.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idInsumo, clave, descripcion, idPartida, usuario);
    }
}
