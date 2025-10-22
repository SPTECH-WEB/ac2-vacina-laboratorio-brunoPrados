package sptech.school;

import school.sptech.exception.ArgumentoInvalidoException;

import java.time.LocalDate;

public class Vacina {

    private String codigo, nome, tipo;
    private Double preco, eficacia;
    private LocalDate dataLancamento;

    public Vacina(String codigo, String nome, String tipo, Double preco, Double eficacia, LocalDate dataLancamento) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        this.eficacia = eficacia;
        if(this.eficacia < 0 || this.eficacia > 100) {
            throw new ArgumentoInvalidoException("ERRO!");
        }
        this.dataLancamento = dataLancamento;
    }

    public String getEficaciaDescricao(){
        String mensagem;
        if(this.eficacia >= 90.5) mensagem = "EXCELENTE";
        else if (this.eficacia >= 75.5)mensagem = "BOM";
        else if (this.eficacia >= 50.5)mensagem = "REGULAR";
        else mensagem = "RUIM";
        return mensagem;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getEficacia() {
        return eficacia;
    }

    public void setEficacia(Double eficacia) {
        this.eficacia = eficacia;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
}
