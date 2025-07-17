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
@Table(name = "VENDA_PRODUTO")
public class VendaProdutoModel implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VEP_codigo", nullable = false, precision = 10, scale = 0)
    private int VEP_codigo;

    @ManyToOne
    @JoinColumn(name = "VDA_codigo", nullable = false)
    private VendaModel VDA_codigo;

    @ManyToOne
    @JoinColumn(name = "PRO_codigo", nullable = false)
    private ProdutoModel PRO_codigo;

    @Column(name = "VEP_qtde", precision = 14, scale = 4)
    private BigDecimal VEP_qtde;

    @Column(name = "VEP_preco", precision = 18, scale = 2)
    private BigDecimal VEP_preco;

    @Column(name = "VEP_desconto",  precision = 18, scale = 2)
    private BigDecimal VEP_desconto;

    @Column(name = "VEP_total",  precision = 18, scale = 2)
    private BigDecimal VEP_total;

    public VendaProdutoModel() {
    }

    public VendaProdutoModel(int VEP_codigo, VendaModel VDA_codigo, ProdutoModel PRO_codigo, BigDecimal VEP_qtde, BigDecimal VEP_preco, BigDecimal VEP_desconto, BigDecimal VEP_total) {
        this.VEP_codigo = VEP_codigo;
        this.VDA_codigo = VDA_codigo;
        this.PRO_codigo = PRO_codigo;
        this.VEP_qtde = VEP_qtde;
        this.VEP_preco = VEP_preco;
        this.VEP_desconto = VEP_desconto;
        this.VEP_total = VEP_total;
    }

    public int getVEP_codigo() {
        return VEP_codigo;
    }

    public void setVEP_codigo(int VEP_codigo) {
        this.VEP_codigo = VEP_codigo;
    }

    public VendaModel getVDA_codigo() {
        return VDA_codigo;
    }

    public void setVDA_codigo(VendaModel VDA_codigo) {
        this.VDA_codigo = VDA_codigo;
    }

    public ProdutoModel getPRO_codigo() {
        return PRO_codigo;
    }

    public void setPRO_codigo(ProdutoModel PRO_codigo) {
        this.PRO_codigo = PRO_codigo;
    }

    public BigDecimal getVEP_qtde() {
        return VEP_qtde;
    }

    public void setVEP_qtde(BigDecimal VEP_qtde) {
        this.VEP_qtde = VEP_qtde;
    }

    public BigDecimal getVEP_preco() {
        return VEP_preco;
    }

    public void setVEP_preco(BigDecimal VEP_preco) {
        this.VEP_preco = VEP_preco;
    }

    public BigDecimal getVEP_desconto() {
        return VEP_desconto;
    }

    public void setVEP_desconto(BigDecimal VEP_desconto) {
        this.VEP_desconto = VEP_desconto;
    }

    public BigDecimal getVEP_total() {
        return VEP_total;
    }

    public void setVEP_total(BigDecimal VEP_total) {
        this.VEP_total = VEP_total;
    }

}
