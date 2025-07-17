package model;

import java.util.Date;
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
@Table(name = "COMPRA")
public class CompraModel implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CPR_codigo", nullable = false, precision = 10, scale = 0)
    private int CPR_codigo;

    @ManyToOne
    @JoinColumn(name = "USU_codigo", nullable = false)
    private UsuarioModel USU_codigo;

    @ManyToOne
    @JoinColumn(name = "FOR_codigo", nullable = false)
    private FornecedorModel FOR_codigo;

    @Column(name = "CPR_emissao")
    private Date CPR_emissao;

    @Column(name = "CPR_valor", precision = 18, scale = 4)
    private BigDecimal CPR_valor;

    @Column(name = "CPR_desconto", precision = 18, scale = 4)
    private BigDecimal CPR_desconto;

    @Column(name = "CPR_total", precision = 18, scale = 4)
    private BigDecimal CPR_total;

    @Column(name = "CPR_dtentrada")
    private Date CPR_dtentrada;

    @Column(name = "CPR_OBS", columnDefinition = "TEXT")
    private String CPR_OBS;

    public CompraModel() {
    }

    public CompraModel(int CPR_codigo, UsuarioModel USU_codigo, FornecedorModel FOR_codigo, Date CPR_emissao, BigDecimal CPR_valor, BigDecimal CPR_desconto, BigDecimal CPR_total, Date CPR_dtentrada, String CPR_OBS) {
        this.CPR_codigo = CPR_codigo;
        this.USU_codigo = USU_codigo;
        this.FOR_codigo = FOR_codigo;
        this.CPR_emissao = CPR_emissao;
        this.CPR_valor = CPR_valor;
        this.CPR_desconto = CPR_desconto;
        this.CPR_total = CPR_total;
        this.CPR_dtentrada = CPR_dtentrada;
        this.CPR_OBS = CPR_OBS;
    }

    public int getCPR_codigo() {
        return CPR_codigo;
    }

    public void setCPR_codigo(int CPR_codigo) {
        this.CPR_codigo = CPR_codigo;
    }

    public UsuarioModel getUSU_codigo() {
        return USU_codigo;
    }

    public void setUSU_codigo(UsuarioModel USU_codigo) {
        this.USU_codigo = USU_codigo;
    }

    public FornecedorModel getFOR_codigo() {
        return FOR_codigo;
    }

    public void setFOR_codigo(FornecedorModel FOR_codigo) {
        this.FOR_codigo = FOR_codigo;
    }

    public void setCPR_valor(BigDecimal CPR_valor) {
        this.CPR_valor = CPR_valor;
    }

    public BigDecimal getCPR_desconto() {
        return CPR_desconto;
    }

    public void setCPR_desconto(BigDecimal CPR_desconto) {
        this.CPR_desconto = CPR_desconto;
    }

    public BigDecimal getCPR_total() {
        return CPR_total;
    }

    public void setCPR_total(BigDecimal CPR_total) {
        this.CPR_total = CPR_total;
    }

    public String getCPR_OBS() {
        return CPR_OBS;
    }

    public void setCPR_OBS(String CPR_OBS) {
        this.CPR_OBS = CPR_OBS;
    }

    public Date getCPR_emissao() {
        return CPR_emissao;
    }

    public void setCPR_emissao(Date CPR_emissao) {
        this.CPR_emissao = CPR_emissao;
    }

    public Date getCPR_dtentrada() {
        return CPR_dtentrada;
    }

    public void setCPR_dtentrada(Date CPR_dtentrada) {
        this.CPR_dtentrada = CPR_dtentrada;
    }

    public BigDecimal getCPR_valor() {
        return CPR_valor;
    }

}
