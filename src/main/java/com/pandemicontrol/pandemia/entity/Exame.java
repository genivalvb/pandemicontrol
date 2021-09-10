package com.pandemicontrol.pandemia.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "exame")
public class Exame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "paciente_hash", nullable = false)
    private String pacienteHash;
    
    @Column(name = "atendimento_hash", nullable = false)
    private String atendimentoHash;
    
    @Column(name = "dt_coleta", nullable = false)
    private String dtColeta;
    
    @Column(name = "de_origem", nullable = false)
    private String deOrigem;
    
    @Column(name = "de_exame", nullable = false)
    private String deExame;
    
    @Column(name = "de_analito", nullable = false)
    private String deAnalito;
    
    @Column(name = "de_resultado", nullable = false)
    private String deResultado;
    
    @Column(name = "cd_unidade", nullable = false)
    private String cdUnidade;
    
    @Column(name = "de_valor_referencia", nullable = false)
    private String deValorReferencia;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    //@JsonIgnoreProperties("exames")
    private Paciente paciente;

    public Exame(){}

    public Exame(String pacienteHash, String atendimentoHash, String dtColeta,
                 String deOrigem, String deExame, String deAnalito, String deResultado,
                 String cdUnidade, String deValorReferencia) {
        this.pacienteHash = pacienteHash;
        this.atendimentoHash = atendimentoHash;
        this.dtColeta = dtColeta;
        this.deOrigem = deOrigem;
        this.deExame = deExame;
        this.deAnalito = deAnalito;
        this.deResultado = deResultado;
        this.cdUnidade = cdUnidade;
        this.deValorReferencia = deValorReferencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPacienteHash() {
        return pacienteHash;
    }

    public void setPacienteHash(String pacienteHash) {
        this.pacienteHash = pacienteHash;
    }

    public String getAtendimentoHash() {
        return atendimentoHash;
    }

    public void setAtendimentoHash(String atendimentoHash) {
        this.atendimentoHash = atendimentoHash;
    }

    public String getDtColeta() {
        return dtColeta;
    }

    public void setDtColeta(String dtColeta) {
        this.dtColeta = dtColeta;
    }

    public String getDeOrigem() {
        return deOrigem;
    }

    public void setDeOrigem(String deOrigem) {
        this.deOrigem = deOrigem;
    }

    public String getDeExame() {
        return deExame;
    }

    public void setDeExame(String deExame) {
        this.deExame = deExame;
    }

    public String getDeAnalito() {
        return deAnalito;
    }

    public void setDeAnalito(String deAnalito) {
        this.deAnalito = deAnalito;
    }

    public String getDeResultado() {
        return deResultado;
    }

    public void setDeResultado(String deResultado) {
        this.deResultado = deResultado;
    }

    public String getCdUnidade() {
        return cdUnidade;
    }

    public void setCdUnidade(String cdUnidade) {
        this.cdUnidade = cdUnidade;
    }

    public String getDeValorReferencia() {
        return deValorReferencia;
    }

    public void setDeValorReferencia(String deValorReferencia) {
        this.deValorReferencia = deValorReferencia;
    }


    @JsonManagedReference
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exame)) return false;
        Exame exame = (Exame) o;
        return Objects.equals(getId(), exame.getId()) && Objects.equals(getPacienteHash(), exame.getPacienteHash()) && Objects.equals(getAtendimentoHash(), exame.getAtendimentoHash()) && Objects.equals(getDtColeta(), exame.getDtColeta()) && Objects.equals(getDeOrigem(), exame.getDeOrigem()) && Objects.equals(getDeExame(), exame.getDeExame()) && Objects.equals(getDeAnalito(), exame.getDeAnalito()) && Objects.equals(getDeResultado(), exame.getDeResultado()) && Objects.equals(getCdUnidade(), exame.getCdUnidade()) && Objects.equals(getDeValorReferencia(), exame.getDeValorReferencia()) && Objects.equals(getPaciente(), exame.getPaciente());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPacienteHash(), getAtendimentoHash(), getDtColeta(), getDeOrigem(), getDeExame(), getDeAnalito(), getDeResultado(), getCdUnidade(), getDeValorReferencia(), getPaciente());
    }

    @Override
    public String toString() {
        return "Exame{" +
                "id=" + id +
                ", pacienteHash='" + pacienteHash + '\'' +
                ", atendimentoHash='" + atendimentoHash + '\'' +
                ", dtColeta='" + dtColeta + '\'' +
                ", deOrigem='" + deOrigem + '\'' +
                ", deExame='" + deExame + '\'' +
                ", deAnalito='" + deAnalito + '\'' +
                ", deResultado='" + deResultado + '\'' +
                ", cdUnidade='" + cdUnidade + '\'' +
                ", deValorReferencia='" + deValorReferencia + '\'' +
                ", paciente=" + paciente +
                '}';
    }
}
