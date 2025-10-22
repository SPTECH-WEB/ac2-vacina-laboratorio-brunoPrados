package sptech.school;
import school.sptech.exception.ArgumentoInvalidoException;
import school.sptech.exception.VacinaInvalidaException;
import school.sptech.exception.VacinaNaoEncontradaException;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Laboratorio {

    private String nome;
    private List<Vacina> vacinas;

    public Laboratorio(String nome, List<Vacina> vacinas) {
        this.nome = nome;
        this.vacinas = new ArrayList<>();
    }

    public void adicionarVacina(Vacina vacina){
        if(getVacinas().isEmpty()){
            throw new VacinaInvalidaException("ERRO!");
        }
        if(vacina.getCodigo().isEmpty() || vacina.getCodigo().isBlank()){
            throw new VacinaInvalidaException("ERRO!");
        }
        if(vacina.getNome().isEmpty() || vacina.getNome().isBlank()){
            throw new VacinaInvalidaException("ERRO!");
        }
        if(vacina.getTipo().isEmpty() || vacina.getTipo().isBlank()){
            throw new VacinaInvalidaException("ERRO!");
        }
        if(vacina.getEficacia() == null || (vacina.getEficacia() > 5 || vacina.getEficacia() < 0)){
            throw new VacinaInvalidaException("ERRO!");
        }
        if(vacina.getDataLancamento() == null || vacina.getDataLancamento().isAfter(vacina.getDataLancamento())){
            throw new VacinaInvalidaException("ERRO!");
        }

        vacinas.add(vacina);

    }

    public Vacina buscarVacinaPorCodigo(String codigo){
        if(codigo == null || codigo.isBlank() || codigo.isEmpty()){
            throw new ArgumentoInvalidoException("ERRO!");
        }

        Vacina vacinacerta = null;
        for (Vacina v : vacinas) {
            if(v.getCodigo().equals(codigo)){
                vacinacerta = v;
            }
        }
        if(vacinacerta == null){
            throw new VacinaNaoEncontradaException("ERRO!");
        }
        return vacinacerta;
    }

    public void removerVacinaPorCodigo(String codigo){
        if(codigo == null || codigo.isBlank() || codigo.isEmpty()){
            throw new ArgumentoInvalidoException("ERRO!");
        }

        Vacina vacinaremover = null;
        for (Vacina v : vacinas) {
            if(v.getCodigo().equals(codigo)){
                vacinaremover = v;
                getVacinas().remove(vacinaremover);
            }
        }
        if(vacinaremover == null){
            throw new VacinaNaoEncontradaException("ERRO!");
        }

    }

    public Vacina buscarVacinaComMelhorEficacia(){
        if(getVacinas().isEmpty()){
            throw new VacinaNaoEncontradaException("ERRO!");
        }
        Vacina melhor = null;
        for (Vacina v : vacinas){
        melhor = vacinas.getFirst();
            if(v.getEficacia() > melhor.getEficacia()){
                melhor = v;
            }
            if(v.getEficacia().equals(melhor.getEficacia())){
                if(v.getDataLancamento().isBefore(melhor.getDataLancamento())){
                melhor = v;
                }
            }
        }
        if(melhor == null){
            throw new VacinaNaoEncontradaException("ERRO!");
        }
        return melhor;
    }

    public List<Vacina> buscarVacinaPorPeriodo(LocalDate dataInicio, LocalDate dataFim){
        if(dataInicio == null || dataFim == null || (dataFim.isBefore(dataInicio))){
            throw new ArgumentoInvalidoException("ERRO!");
        }

        List<Vacina> listaVacinas = null;
        for (Vacina v : vacinas){
            if((v.getDataLancamento().isBefore(dataFim) && v.getDataLancamento().isAfter(dataInicio))
            || (v.getDataLancamento().isEqual(dataFim) || v.getDataLancamento().isEqual(dataInicio))){
                listaVacinas.add(v);
            }
        }
        return listaVacinas;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Vacina> getVacinas() {
        return vacinas;
    }
}
