package org.alfa.comex.data.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data //@ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Respuesta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRespuesta;
	
	//id idTransaccion
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Transaccion transaccion;//FK
  
    private String codigoRespuesta;
    private String descripcionRespuesta;
    
    private LocalDateTime fechaRespuesta;
    private Integer estado;
}
