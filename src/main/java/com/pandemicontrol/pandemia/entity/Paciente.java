package com.pandemicontrol.pandemia.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "name_hash", nullable = false, unique = true)
    private String nameHash;

    @Column(nullable = false)
    private String sexo;

    @Column(name = "ano_nascimento", nullable = false)
    private Integer anoNascimento;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String uf;
    @Column(nullable = false)
    private String pais;
    //@Column(nullable = false)
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Exame> exames;


    public Paciente(){}

    public Paciente(String nameHash, String sexo, Integer anoNascimento, String cidade, String uf, String pais) {
        this.nameHash = nameHash;
        this.sexo = sexo;
        this.anoNascimento = anoNascimento;
        this.cidade = cidade;
        this.uf = uf;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameHash() {
        return nameHash;
    }

    public void setNameHash(String nameHash) {
        this.nameHash = nameHash;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Integer anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @JsonBackReference
    public List<Exame> getExames() {
        return exames;
    }

    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paciente)) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(getId(), paciente.getId()) && Objects.equals(getNameHash(), paciente.getNameHash()) && Objects.equals(getSexo(), paciente.getSexo()) && Objects.equals(getAnoNascimento(), paciente.getAnoNascimento()) && Objects.equals(getCidade(), paciente.getCidade()) && Objects.equals(getUf(), paciente.getUf()) && Objects.equals(getPais(), paciente.getPais()) && Objects.equals(getExames(), paciente.getExames());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNameHash(), getSexo(), getAnoNascimento(), getCidade(), getUf(), getPais(), getExames());
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nameHash='" + nameHash + '\'' +
                ", sexo='" + sexo + '\'' +
                ", anoNascimento=" + anoNascimento +
                ", cidade='" + cidade + '\'' +
                ", uf='" + uf + '\'' +
                ", pais='" + pais + '\'' +
                ", exames=" + exames +
                '}';
    }
}
