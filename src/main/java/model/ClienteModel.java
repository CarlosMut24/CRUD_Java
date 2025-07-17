package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "CLIENTE")
public class ClienteModel implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLI_codigo", nullable = false, precision = 10)
    private int CLI_codigo;
    
    @OneToOne
    @JoinColumn(name = "PES_codigo", nullable = false, unique = true)
    private PessoaModel PES_codigo;

    @Column(name = "CLI_LimiteCred", precision = 18, scale = 2)
    private BigDecimal CLI_LimiteCred;

    public ClienteModel() {
    }

    public ClienteModel(int CLI_codigo, PessoaModel PES_codigo, BigDecimal CLI_LimiteCred) {
        this.CLI_codigo = CLI_codigo;
        this.PES_codigo = PES_codigo;
        this.CLI_LimiteCred = CLI_LimiteCred;
    }

    public int getCLI_codigo() {
        return CLI_codigo;
    }

    public void setCLI_codigo(int CLI_codigo) {
        this.CLI_codigo = CLI_codigo;
    }

    public PessoaModel getPES_codigo() {
        return PES_codigo;
    }

    public void setPES_codigo(PessoaModel PES_codigo) {
        this.PES_codigo = PES_codigo;
    }
    
    public BigDecimal getCLI_LimiteCred() {
        return CLI_LimiteCred;
    }

    public void setCLI_LimiteCred(BigDecimal CLI_LimiteCred) {
        this.CLI_LimiteCred = CLI_LimiteCred;
    }
    
    
}
