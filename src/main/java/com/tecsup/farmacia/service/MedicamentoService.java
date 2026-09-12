package com.tecsup.farmacia.service;

import com.tecsup.farmacia.repository.MedicamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;

    public MedicamentoService(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    public boolean codigoExiste(String codigo) {
        return medicamentoRepository.existsByCodigo(codigo);
    }
}