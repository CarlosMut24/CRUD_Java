package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "FORNECEDOR")
public class FornecedorModel implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FOR_codigo", nullable = false, precision = 10)
    private int FOR_codigo;

    @OneToOne
    @JoinColumn(name = "PES_codigo", nullable = false, unique = true)
    private PessoaModel PES_codigo;

    @Column(name = "FOR_contato", length = 80)
    private String FOR_contato;

    public FornecedorModel() {
    }

    public FornecedorModel(int FOR_codigo, PessoaModel PES_codigo, String FOR_contato) {
        this.FOR_codigo = FOR_codigo;
        this.PES_codigo = PES_codigo;
        this.FOR_contato = FOR_contato;
    }

    public int getFOR_codigo() {
        return FOR_codigo;
    }

    public void setFOR_codigo(int FOR_codigo) {
        this.FOR_codigo = FOR_codigo;
    }

    public PessoaModel getPES_codigo() {
        return PES_codigo;
    }

    public void setPES_codigo(PessoaModel PES_codigo) {
        this.PES_codigo = PES_codigo;
    }

    public String getFOR_contato() {
        return FOR_contato;
    }

    public void setFOR_contato(String FOR_contato) {
        this.FOR_contato = FOR_contato;
    }

}
