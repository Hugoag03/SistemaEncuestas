package com.api.rest.controller.v1;

import com.api.rest.exception.ResourceNotFoundException;
import com.api.rest.model.Encuesta;
import com.api.rest.model.Opcion;
import com.api.rest.repositories.EncuestaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController("EncuestaControllerV1")
@RequestMapping("/v1")
public class EncuestaController {

    @Autowired
    private EncuestaRepository encuestaRepository;

    @GetMapping("/encuestas")
    public ResponseEntity<Iterable<Encuesta>> listarTodasLasEncuestas(){
        return new ResponseEntity<>(encuestaRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/encuestas")
    public ResponseEntity<?> crearEncuesta(@Valid @RequestBody Encuesta encuesta){
        encuesta = encuestaRepository.save(encuesta);

        HttpHeaders httpHeaders = new HttpHeaders();
        URI newEncuestaUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(encuesta.getId()).toUri();
        httpHeaders.setLocation(newEncuestaUri);

        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }

    @GetMapping("/encuestas/{id}")
    public ResponseEntity<?> obtenerEncuesta(@PathVariable Long id) {
        verifyEncuesta(id);
        Optional<Encuesta> encuesta = encuestaRepository.findById(id);

        return new ResponseEntity<>(encuestaRepository.findById(id).get(), HttpStatus.OK);

    }

    @PutMapping("/encuestas/{id}")
    public ResponseEntity<?> actualizarEncuesta(@Valid @RequestBody Encuesta encuesta, @PathVariable Long id){
        verifyEncuesta(id);
        encuesta.setId(id);
        encuestaRepository.save(encuesta);

        return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("/encuestas/{id}")
    public ResponseEntity<?> eliminarEncuesta(@PathVariable Long id){
        verifyEncuesta(id);
        encuestaRepository.deleteById(id);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    protected void verifyEncuesta(Long encuestaId){
        Optional<Encuesta> encuesta = encuestaRepository.findById(encuestaId);
        if(!encuesta.isPresent()){
            throw new ResourceNotFoundException("Encuesta con el ID: " + encuestaId + " no encontrada");
        }
    }
}
