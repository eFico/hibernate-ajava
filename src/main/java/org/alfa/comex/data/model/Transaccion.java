package org.alfa.comex.data.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transaccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTransaccion;
	
	//id empresaOneToOne 
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Empresa empresa;//FK
  
    private String nombreDocumento;
    private LocalDateTime fechaRegistro;
    private Integer estado;

   
}
