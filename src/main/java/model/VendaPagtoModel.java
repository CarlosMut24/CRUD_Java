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
@Table(name = "VENDA_PAGTO")
public class VendaPagtoModel implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VDP_codigo", nullable = false, precision = 10, scale = 0)
    private int VDP_codigo;

    @ManyToOne
    @JoinColumn(name = "VDA_codigo", nullable = false)
    private VendaModel VDA_codigo;

    @ManyToOne
    @JoinColumn(name = "FPG_codigo", nullable = false)
    private FormaPagtoModel FPG_codigo;

    @Column(name = "VDP_valor", nullable = false, precision = 18, scale = 2)
    private BigDecimal VDP_valor;

    public VendaPagtoModel() {
    }

    public VendaPagtoModel(int VDP_codigo, VendaModel VDA_codigo, FormaPagtoModel FPG_codigo, BigDecimal VDP_valor) {
        this.VDP_codigo = VDP_codigo;
        this.VDA_codigo = VDA_codigo;
        this.FPG_codigo = FPG_codigo;
        this.VDP_valor = VDP_valor;
    }

    public int getVDP_codigo() {
        return VDP_codigo;
    }

    public void setVDP_codigo(int VDP_codigo) {
        this.VDP_codigo = VDP_codigo;
    }

    public VendaModel getVDA_codigo() {
        return VDA_codigo;
    }

    public void setVDA_codigo(VendaModel VDA_codigo) {
        this.VDA_codigo = VDA_codigo;
    }

    public FormaPagtoModel getFPG_codigo() {
        return FPG_codigo;
    }

    public void setFPG_codigo(FormaPagtoModel FPG_codigo) {
        this.FPG_codigo = FPG_codigo;
    }

    public BigDecimal getVDP_valor() {
        return VDP_valor;
    }

    public void setVDP_valor(BigDecimal VDP_valor) {
        this.VDP_valor = VDP_valor;
    }

}
