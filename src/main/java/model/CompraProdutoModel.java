package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "COMPRA_PRODUTO")
public class CompraProdutoModel implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CPP_codigo", nullable = false, precision = 10, scale = 0)
    private int CPP_codigo;

    @ManyToOne
    @JoinColumn(name = "CPR_codigo", nullable = false)
    private CompraModel CPR_codigo;

    @ManyToOne
    @JoinColumn(name = "PRO_codigo", nullable = false)
    private ProdutoModel PRO_codigo;

    @Column(name = "CPP_qtde", nullable = false, precision = 14, scale = 4)
    private BigDecimal CPP_qtde;

    @Column(name = "CPP_preco", nullable = false, precision = 18, scale = 2)
    private BigDecimal CPP_preco;

    @Column(name = "CPP_desconto", precision = 18, scale = 2)
    private BigDecimal CPP_desconto;

    @Column(name = "CPP_total", precision = 18, scale = 2)
    private BigDecimal CPP_total;

    public CompraProdutoModel() {
    }

    public CompraProdutoModel(int CPP_codigo, CompraModel CPR_codigo, ProdutoModel PRO_codigo, BigDecimal CPP_qtde, BigDecimal CPP_preco, BigDecimal CPP_desconto, BigDecimal CPP_total) {
        this.CPP_codigo = CPP_codigo;
        this.CPR_codigo = CPR_codigo;
        this.PRO_codigo = PRO_codigo;
        this.CPP_qtde = CPP_qtde;
        this.CPP_preco = CPP_preco;
        this.CPP_desconto = CPP_desconto;
        this.CPP_total = CPP_total;
    }

    public int getCPP_codigo() {
        return CPP_codigo;
    }

    public void setCPP_codigo(int CPP_codigo) {
        this.CPP_codigo = CPP_codigo;
    }

    public CompraModel getCPR_codigo() {
        return CPR_codigo;
    }

    public void setCPR_codigo(CompraModel CPR_codigo) {
        this.CPR_codigo = CPR_codigo;
    }

    public ProdutoModel getPRO_codigo() {
        return PRO_codigo;
    }

    public void setPRO_codigo(ProdutoModel PRO_codigo) {
        this.PRO_codigo = PRO_codigo;
    }

    public BigDecimal getCPP_qtde() {
        return CPP_qtde;
    }

    public void setCPP_qtde(BigDecimal CPP_qtde) {
        this.CPP_qtde = CPP_qtde;
    }

    public BigDecimal getCPP_preco() {
        return CPP_preco;
    }

    public void setCPP_preco(BigDecimal CPP_preco) {
        this.CPP_preco = CPP_preco;
    }

    public BigDecimal getCPP_desconto() {
        return CPP_desconto;
    }

    public void setCPP_desconto(BigDecimal CPP_desconto) {
        this.CPP_desconto = CPP_desconto;
    }

    public BigDecimal getCPP_total() {
        return CPP_total;
    }

    public void setCPP_total(BigDecimal CPP_total) {
        this.CPP_total = CPP_total;
    }

}
