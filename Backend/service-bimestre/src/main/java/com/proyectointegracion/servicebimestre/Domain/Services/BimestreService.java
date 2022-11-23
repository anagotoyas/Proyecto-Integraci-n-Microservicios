package com.proyectointegracion.servicebimestre.Domain.Services;

import com.proyectointegracion.servicebimestre.Domain.Entities.Bimestre;
import com.proyectointegracion.servicebimestre.Domain.Repositories.BimestreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BimestreService {

    private final BimestreRepository bimestreRepository;


    public BimestreService(BimestreRepository bimestreRepository) {
        this.bimestreRepository = bimestreRepository;
    }



    public Bimestre crearBimestre(Bimestre bimestre) {
        return bimestreRepository.save(bimestre);
    }

    public Bimestre modificarBimestre(Bimestre bimestre) {
        return bimestreRepository.save(bimestre);
    }

    public void eliminarBimestre(Integer idBimestre) {
        bimestreRepository.deleteById(idBimestre);
    }

    public List<Bimestre> listarBimestre() {
        return bimestreRepository.findAll();
    }

    public List<Bimestre> listarBimestrePorYear(Integer idYear) {
        return bimestreRepository.findAllByIdYear( idYear);
    }

    public Bimestre obtenerBimestrePorIdBimestre(Integer idBimestre) {
        return bimestreRepository.findById(idBimestre).orElse(new Bimestre());
    }
}
