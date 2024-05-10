package com.api.rest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "voto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VOTO_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "OPCION_ID")
    private Opcion opcion;
}
