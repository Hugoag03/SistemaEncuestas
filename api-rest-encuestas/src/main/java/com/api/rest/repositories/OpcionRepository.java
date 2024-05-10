package com.api.rest.repositories;

import com.api.rest.model.Opcion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpcionRepository  extends JpaRepository<Opcion, Long> {
}
