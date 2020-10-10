package com.examplo.wsdlservidor.repositories;

import com.examplo.wsdlservidor.assets.Pais;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class PaisRepository {

    private static final Map<String, Pais> paises = new HashMap<>();

    @PostConstruct
    public void initData() {
        Pais brasil = new Pais();
    }

}
