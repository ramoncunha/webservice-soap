package com.examplo.wsdlservidor.endpoints;

import com.examplo.wsdlservidor.assets.GetPaisRequest;
import com.examplo.wsdlservidor.assets.GetPaisResponse;
import com.examplo.wsdlservidor.repositories.PaisRepository;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PaisEndpoint {
    private static final String NAMESPACE_URI = "http://exemplo.com/wsdlservidor/assets";

    private final PaisRepository paisRepository;

    public PaisEndpoint(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPaisRequest")
    @ResponsePayload
    public GetPaisResponse getPais(@RequestPayload GetPaisRequest request) {
        GetPaisResponse response = new GetPaisResponse();
        response.setPais(this.paisRepository.buscarPorPais(request.getNome()));

        return response;
    }
}
