package com.examplo.wsdlservidor.repositories;

import com.examplo.wsdlservidor.assets.Moeda;
import com.examplo.wsdlservidor.assets.Pais;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class PaisRepository {

    private static final Map<String, Pais> paises = new HashMap<>();

    @PostConstruct
    public void initData() {
        Pais brasil = new Pais();
        brasil.setNome("Brasil");
        brasil.setCapital("Brasilia");
        brasil.setMoeda(Moeda.BRL);
        brasil.setPopulacao(209300000);
        paises.put(brasil.getNome(), brasil);

        Pais uk = new Pais();
        uk.setNome("United Kingdom");
        uk.setCapital("London");
        uk.setMoeda(Moeda.GBP);
        uk.setPopulacao(63705000);
        paises.put(uk.getNome(), uk);
    }

    public Pais buscarPorPais(String nome) {
        Assert.notNull(nome, "O país não pode ser nulo.");
        return paises.get(nome);
    }

}
