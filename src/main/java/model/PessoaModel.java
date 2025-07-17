package model;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PESSOA")
public class PessoaModel implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PES_codigo", nullable = false, precision = 10)
    private int PES_codigo;

    @Column(name = "PES_nome", nullable = false, length = 80)
    private String PES_nome;

    @Column(name = "PES_fantasia", length = 80)
    private String PES_fantasia;

    @Column(name = "PES_fisica", nullable = false, length = 1)
    private int PES_fisica;

    @Column(name = "PES_CpfCnpj", nullable = false, length = 20)
    private String PES_CpfCnpj;

    @Column(name = "PES_rgie", length = 20)
    private String PES_rgie;

    @Column(name = "PES_cadrastro")
    private Date PES_cadrastro;

    @Column(name = "PES_endereco", length = 120)
    private String PES_endereco;

    @Column(name = "PES_numero", length = 10)
    private String PES_numero;

    @Column(name = "PES_complemento", length = 30)
    private String PES_complemento;

    @Column(name = "PES_bairro", length = 50)
    private String PES_bairro;

    @Column(name = "PES_cidade", length = 80)
    private String PES_cidade;

    @Column(name = "PES_uf", length = 2)
    private String PES_uf;

    @Column(name = "PES_cep", length = 9)
    private String PES_cep;

    @Column(name = "PES_fone1", length = 16)
    private String PES_fone1;

    @Column(name = "PES_fone2", length = 16)
    private String PES_fone2;

    @Column(name = "PES_celular", length = 16)
    private String PES_celular;

    @Column(name = "PES_site", length = 200)
    private String PES_site;

    @Column(name = "PES_email", length = 200)
    private String PES_email;

    @Column(name = "PES_ativo", length = 1)
    private int PES_ativo;

    public PessoaModel() {
    }

    public PessoaModel(int PES_codigo, String PES_nome, String PES_fantasia, int PES_fisica, String PES_CpfCnpj, String PES_rgie, Date PES_cadrastro, String PES_endereco, String PES_numero, String PES_complemento, String PES_bairro, String PES_cidade, String PES_uf, String PES_cep, String PES_fone1, String PES_fone2, String PES_celular, String PES_site, String PES_email, int PES_ativo) {
        this.PES_codigo = PES_codigo;
        this.PES_nome = PES_nome;
        this.PES_fantasia = PES_fantasia;
        this.PES_fisica = PES_fisica;
        this.PES_CpfCnpj = PES_CpfCnpj;
        this.PES_rgie = PES_rgie;
        this.PES_cadrastro = PES_cadrastro;
        this.PES_endereco = PES_endereco;
        this.PES_numero = PES_numero;
        this.PES_complemento = PES_complemento;
        this.PES_bairro = PES_bairro;
        this.PES_cidade = PES_cidade;
        this.PES_uf = PES_uf;
        this.PES_cep = PES_cep;
        this.PES_fone1 = PES_fone1;
        this.PES_fone2 = PES_fone2;
        this.PES_celular = PES_celular;
        this.PES_site = PES_site;
        this.PES_email = PES_email;
        this.PES_ativo = PES_ativo;
    }

    public int getPES_codigo() {
        return PES_codigo;
    }

    public String getPES_nome() {
        return PES_nome;
    }

    public String getPES_fantasia() {
        return PES_fantasia;
    }

    public int getPES_fisica() {
        return PES_fisica;
    }

    public String getPES_CpfCnpj() {
        return PES_CpfCnpj;
    }

    public String getPES_rgie() {
        return PES_rgie;
    }

    public Date getPES_cadrastro() {
        return PES_cadrastro;
    }

    public String getPES_endereco() {
        return PES_endereco;
    }

    public String getPES_numero() {
        return PES_numero;
    }

    public String getPES_complemento() {
        return PES_complemento;
    }

    public String getPES_bairro() {
        return PES_bairro;
    }

    public String getPES_cidade() {
        return PES_cidade;
    }

    public String getPES_uf() {
        return PES_uf;
    }

    public String getPES_cep() {
        return PES_cep;
    }

    public String getPES_fone1() {
        return PES_fone1;
    }

    public String getPES_fone2() {
        return PES_fone2;
    }

    public String getPES_celular() {
        return PES_celular;
    }

    public String getPES_site() {
        return PES_site;
    }

    public String getPES_email() {
        return PES_email;
    }

    public int getPES_ativo() {
        return PES_ativo;
    }

    public void setPES_codigo(int PES_codigo) {
        this.PES_codigo = PES_codigo;
    }

    public void setPES_nome(String PES_nome) {
        this.PES_nome = PES_nome;
    }

    public void setPES_fantasia(String PES_fantasia) {
        this.PES_fantasia = PES_fantasia;
    }

    public void setPES_fisica(int PES_fisica) {
        this.PES_fisica = PES_fisica;
    }

    public void setPES_CpfCnpj(String PES_CpfCnpj) {
        this.PES_CpfCnpj = PES_CpfCnpj;
    }

    public void setPES_rgie(String PES_rgie) {
        this.PES_rgie = PES_rgie;
    }

    public void setPES_cadrastro(Date PES_cadrastro) {
        this.PES_cadrastro = PES_cadrastro;
    }

    public void setPES_endereco(String PES_endereco) {
        this.PES_endereco = PES_endereco;
    }

    public void setPES_numero(String PES_numero) {
        this.PES_numero = PES_numero;
    }

    public void setPES_complemento(String PES_complemento) {
        this.PES_complemento = PES_complemento;
    }

    public void setPES_bairro(String PES_bairro) {
        this.PES_bairro = PES_bairro;
    }

    public void setPES_cidade(String PES_cidade) {
        this.PES_cidade = PES_cidade;
    }

    public void setPES_uf(String PES_uf) {
        this.PES_uf = PES_uf;
    }

    public void setPES_cep(String PES_cep) {
        this.PES_cep = PES_cep;
    }

    public void setPES_fone1(String PES_fone1) {
        this.PES_fone1 = PES_fone1;
    }

    public void setPES_fone2(String PES_fone2) {
        this.PES_fone2 = PES_fone2;
    }

    public void setPES_celular(String PES_celular) {
        this.PES_celular = PES_celular;
    }

    public void setPES_site(String PES_site) {
        this.PES_site = PES_site;
    }

    public void setPES_email(String PES_email) {
        this.PES_email = PES_email;
    }

    public void setPES_ativo(int PES_ativo) {
        this.PES_ativo = PES_ativo;
    }

}
