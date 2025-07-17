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
@Table(name = "VENDA")
public class VendaModel implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VDA_codigo", nullable = false, precision = 10, scale = 0)
    private int VDA_codigo;

    @ManyToOne
    @JoinColumn(name = "USU_codigo", nullable = false)
    private UsuarioModel USU_codigo;

    @ManyToOne
    @JoinColumn(name = "CLI_codigo", nullable = false)
    private ClienteModel CLI_codigo;

    @Column(name = "VDA_date")
    private Date VDA_date;

    @Column(name = "VDA_valor", precision = 18, scale = 2)
    private BigDecimal VDA_valor;

    @Column(name = "VDA_desconto", precision = 18, scale = 2)
    private BigDecimal VDA_desconto;

    @Column(name = "VDA_total", precision = 18, scale = 2)
    private BigDecimal VDA_total;

    @Column(name = "VDA_OBS", columnDefinition = "TEXT")
    private String VDA_OBS;

    public VendaModel() {
    }

    public VendaModel(int VDA_codigo, UsuarioModel USU_codigo, ClienteModel CLI_codigo, Date VDA_date, BigDecimal VDA_valor, BigDecimal VDA_desconto, BigDecimal VDA_total, String VEP_OBS) {
        this.VDA_codigo = VDA_codigo;
        this.USU_codigo = USU_codigo;
        this.CLI_codigo = CLI_codigo;
        this.VDA_date = VDA_date;
        this.VDA_valor = VDA_valor;
        this.VDA_desconto = VDA_desconto;
        this.VDA_total = VDA_total;
        this.VDA_OBS = VEP_OBS;
    }

    public int getVDA_codigo() {
        return VDA_codigo;
    }

    public void setVDA_codigo(int VDA_codigo) {
        this.VDA_codigo = VDA_codigo;
    }

    public UsuarioModel getUSU_codigo() {
        return USU_codigo;
    }

    public void setUSU_codigo(UsuarioModel USU_codigo) {
        this.USU_codigo = USU_codigo;
    }

    public ClienteModel getCLI_codigo() {
        return CLI_codigo;
    }

    public void setCLI_codigo(ClienteModel CLI_codigo) {
        this.CLI_codigo = CLI_codigo;
    }

    public Date getVDA_date() {
        return VDA_date;
    }

    public void setVDA_date(Date VDA_date) {
        this.VDA_date = VDA_date;
    }

    public BigDecimal getVDA_valor() {
        return VDA_valor;
    }

    public void setVDA_valor(BigDecimal VDA_valor) {
        this.VDA_valor = VDA_valor;
    }

    public BigDecimal getVDA_desconto() {
        return VDA_desconto;
    }

    public void setVDA_desconto(BigDecimal VDA_desconto) {
        this.VDA_desconto = VDA_desconto;
    }

    public BigDecimal getVDA_total() {
        return VDA_total;
    }

    public void setVDA_total(BigDecimal VDA_total) {
        this.VDA_total = VDA_total;
    }

    public String getVEP_OBS() {
        return VDA_OBS;
    }

    public void setVEP_OBS(String VEP_OBS) {
        this.VDA_OBS = VEP_OBS;
    }

}
