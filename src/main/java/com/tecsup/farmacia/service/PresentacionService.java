package com.tecsup.farmacia.service;

import com.tecsup.farmacia.entity.Presentacion;
import com.tecsup.farmacia.repository.PresentacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PresentacionService {

    private final PresentacionRepository presentacionRepository;

    public PresentacionService(PresentacionRepository presentacionRepository) {
        this.presentacionRepository = presentacionRepository;
    }

    public List<Presentacion> listar() {
        return presentacionRepository.findAll();
    }

    public Optional<Presentacion> buscarPorId(Long id) {
        return presentacionRepository.findById(id);
    }

    public Presentacion guardar(Presentacion presentacion) {
        return presentacionRepository.save(presentacion);
    }

    public Presentacion actualizar(Long id, Presentacion presentacionActualizada) {
        Optional<Presentacion> presentacionExistente = presentacionRepository.findById(id);

        if (presentacionExistente.isPresent()) {
            Presentacion presentacion = presentacionExistente.get();

            presentacion.setNombre(presentacionActualizada.getNombre());
            presentacion.setDescripcion(presentacionActualizada.getDescripcion());
            presentacion.setEstado(presentacionActualizada.isEstado());
            presentacion.setMedicamento(presentacionActualizada.getMedicamento());

            return presentacionRepository.save(presentacion);
        }

        return null;
    }

    public boolean eliminar(Long id) {
        if (presentacionRepository.existsById(id)) {
            presentacionRepository.deleteById(id);
            return true;
        }

        return false;
    }
}