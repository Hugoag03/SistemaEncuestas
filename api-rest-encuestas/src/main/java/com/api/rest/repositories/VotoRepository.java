package com.api.rest.repositories;

import com.api.rest.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VotoRepository extends JpaRepository<Voto, Long> {

    @Query(value = "select v.* from Opcion o, Voto v where o.ENCUESTA_ID=?1 and v.OPCION_ID=o.OPCION_ID", nativeQuery = true)
    public Iterable<Voto> findByEncuesta(Long encuestaId);
}
