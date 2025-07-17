package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "PRODUTO")
public class ProdutoModel implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRO_codigo", nullable = false)
    private int PRO_codigo;

    @Column(name = "PRO_nome", nullable = false)
    private String PRO_nome;

    @Column(name = "PRO_estoque", precision = 18, scale = 2)
    private BigDecimal PRO_estoque;

    @Column(name = "PRO_unidade", length = 5)
    private String PRO_unidade;

    @Column(name = "PRO_preco", precision = 18, scale = 2)
    private BigDecimal PRO_preco;

    @Column(name = "PRO_custo", precision = 18, scale = 2)
    private BigDecimal PRO_custo;

    @Column(name = "PRO_atacado", precision = 18, scale = 2)
    private BigDecimal PRO_atacado;

    @Column(name = "PRO_min", precision = 14, scale = 4)
    private BigDecimal PRO_min;

    @Column(name = "PRO_max", precision = 14, scale = 4)
    private BigDecimal PRO_max;

    @Column(name = "PRO_embalagem", precision = 9, scale = 0)
    private BigDecimal PRO_embalagem;

    @Column(name = "PRO_peso", precision = 14, scale = 4)
    private BigDecimal PRO_peso;

    @Column(name = "PRO_cadastro")
    private Date PRO_cadastro;

    @Column(name = "PRO_OBS", columnDefinition = "TEXT")
    private String PRO_OBS;

    @Column(name = "PRO_ativo", nullable = false)
    private int PRO_ativo;

    public ProdutoModel() {
    }

    public ProdutoModel(int PRO_codigo, String PRO_nome, BigDecimal PRO_estoque, String PRO_unidade, BigDecimal PRO_preco, BigDecimal PRO_custo, BigDecimal PRO_atacado, BigDecimal PRO_min, BigDecimal PRO_max, BigDecimal PRO_embalagem, BigDecimal PRO_peso, Date PRO_cadastro, String PRO_OBS, int PRO_ativo) {
        this.PRO_codigo = PRO_codigo;
        this.PRO_nome = PRO_nome;
        this.PRO_estoque = PRO_estoque;
        this.PRO_unidade = PRO_unidade;
        this.PRO_preco = PRO_preco;
        this.PRO_custo = PRO_custo;
        this.PRO_atacado = PRO_atacado;
        this.PRO_min = PRO_min;
        this.PRO_max = PRO_max;
        this.PRO_embalagem = PRO_embalagem;
        this.PRO_peso = PRO_peso;
        this.PRO_cadastro = PRO_cadastro;
        this.PRO_OBS = PRO_OBS;
        this.PRO_ativo = PRO_ativo;
    }

    public int getPRO_codigo() {
        return PRO_codigo;
    }

    public void setPRO_codigo(int PRO_codigo) {
        this.PRO_codigo = PRO_codigo;
    }

    public String getPRO_nome() {
        return PRO_nome;
    }

    public void setPRO_nome(String PRO_nome) {
        this.PRO_nome = PRO_nome;
    }

    public BigDecimal getPRO_estoque() {
        return PRO_estoque;
    }

    public void setPRO_estoque(BigDecimal PRO_estoque) {
        this.PRO_estoque = PRO_estoque;
    }

    public String getPRO_unidade() {
        return PRO_unidade;
    }

    public void setPRO_unidade(String PRO_unidade) {
        this.PRO_unidade = PRO_unidade;
    }

    public BigDecimal getPRO_preco() {
        return PRO_preco;
    }

    public void setPRO_preco(BigDecimal PRO_preco) {
        this.PRO_preco = PRO_preco;
    }

    public BigDecimal getPRO_custo() {
        return PRO_custo;
    }

    public void setPRO_custo(BigDecimal PRO_custo) {
        this.PRO_custo = PRO_custo;
    }

    public BigDecimal getPRO_atacado() {
        return PRO_atacado;
    }

    public void setPRO_atacado(BigDecimal PRO_atacado) {
        this.PRO_atacado = PRO_atacado;
    }

    public BigDecimal getPRO_min() {
        return PRO_min;
    }

    public void setPRO_min(BigDecimal PRO_min) {
        this.PRO_min = PRO_min;
    }

    public BigDecimal getPRO_max() {
        return PRO_max;
    }

    public void setPRO_max(BigDecimal PRO_max) {
        this.PRO_max = PRO_max;
    }

    public BigDecimal getPRO_embalagem() {
        return PRO_embalagem;
    }

    public void setPRO_embalagem(BigDecimal PRO_embalagem) {
        this.PRO_embalagem = PRO_embalagem;
    }

    public BigDecimal getPRO_peso() {
        return PRO_peso;
    }

    public void setPRO_peso(BigDecimal PRO_peso) {
        this.PRO_peso = PRO_peso;
    }

    public Date getPRO_cadastro() {
        return PRO_cadastro;
    }

    public void setPRO_cadastro(Date PRO_cadastro) {
        this.PRO_cadastro = PRO_cadastro;
    }

    public String getPRO_OBS() {
        return PRO_OBS;
    }

    public void setPRO_OBS(String PRO_OBS) {
        this.PRO_OBS = PRO_OBS;
    }

    public int getPRO_ativo() {
        return PRO_ativo;
    }

    public void setPRO_ativo(int PRO_ativo) {
        this.PRO_ativo = PRO_ativo;
    }

}
