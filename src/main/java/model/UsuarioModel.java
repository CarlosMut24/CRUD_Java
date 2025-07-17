package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "USUARIO")
public class UsuarioModel implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USU_CODIGO", nullable = false, precision = 10, scale = 0)
    private int USU_CODIGO;

    @Column(name = "USU_NOME", nullable = false, length = 30)
    private String USU_NOME;

    @Column(name = "USU_LOGIN", nullable = false, length = 10)
    private String USU_LOGIN;

    @Column(name = "USU_SENHA", nullable = false, length = 10)
    private String USU_SENHA;

    @Column(name = "USU_cadrastro")
    private Date USU_cadrastro;

    @Column(name = "USU_ATIVO", precision = 1)
    private int USU_ATIVO;

    @Override
    public String toString() {
        return this.USU_NOME;
    }

    public UsuarioModel() {
    }

    public UsuarioModel(int USU_CODIGO, String USU_NOME, String USU_LOGIN, String USU_SENHA, Date USU_cadrastro, int USU_ATIVO) {
        this.USU_CODIGO = USU_CODIGO;
        this.USU_NOME = USU_NOME;
        this.USU_LOGIN = USU_LOGIN;
        this.USU_SENHA = USU_SENHA;
        this.USU_cadrastro = USU_cadrastro;
        this.USU_ATIVO = USU_ATIVO;
    }

    public int getUSU_CODIGO() {
        return this.USU_CODIGO;
    }

    public void setUSU_CODIGO(int USU_CODIGO) {
        this.USU_CODIGO = USU_CODIGO;
    }

    public String getUSU_NOME() {
        return this.USU_NOME;
    }

    public void setUSU_NOME(String USU_NOME) {
        this.USU_NOME = USU_NOME;
    }

    public String getUSU_LOGIN() {
        return this.USU_LOGIN;
    }

    public void setUSU_LOGIN(String USU_LOGIN) {
        this.USU_LOGIN = USU_LOGIN;
    }

    public String getUSU_SENHA() {
        return this.USU_SENHA;
    }

    public void setUSU_SENHA(String USU_SENHA) {
        this.USU_SENHA = USU_SENHA;
    }

    public int getUSU_ATIVO() {
        return this.USU_ATIVO;
    }

    public Date getUSU_cadrastro() {
        return USU_cadrastro;
    }

    public void setUSU_cadrastro(Date USU_cadrastro) {
        this.USU_cadrastro = USU_cadrastro;
    }

    public void setUSU_ATIVO(int USU_ATIVO) {
        this.USU_ATIVO = USU_ATIVO;
    }

}
