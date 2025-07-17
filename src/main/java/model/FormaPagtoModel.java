package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "FORMAPAGTO")
public class FormaPagtoModel implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FPG_codigo", nullable = false, precision = 10, scale = 0)
    private int FPG_codigo;
    
    @Column(name = "FPG_nome", nullable = false, length = 80)
    private String FPG_nome;
    
    @Column(name = "FPG_ATIVO", precision = 1)
    private int FPG_ativo;

    public FormaPagtoModel() {
    }

    public FormaPagtoModel(int FPG_codigo, String FPG_nome, int FPG_ativo) {
        this.FPG_codigo = FPG_codigo;
        this.FPG_nome = FPG_nome;
        this.FPG_ativo = FPG_ativo;
    }

    public int getFPG_codigo() {
        return FPG_codigo;
    }

    public void setFPG_codigo(int FPG_codigo) {
        this.FPG_codigo = FPG_codigo;
    }

    public String getFPG_nome() {
        return FPG_nome;
    }

    public void setFPG_nome(String FPG_nome) {
        this.FPG_nome = FPG_nome;
    }

    public int getFPG_ativo() {
        return FPG_ativo;
    }

    public void setFPG_ativo(int FPG_ativo) {
        this.FPG_ativo = FPG_ativo;
    }
 
    
}
