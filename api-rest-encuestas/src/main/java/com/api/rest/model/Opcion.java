package com.api.rest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "opcion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Opcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OPCION_ID")
    private Long id;

    @Column(name = "valor")
    private String valor;


}
