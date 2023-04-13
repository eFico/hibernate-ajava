package org.alfa.comex.domain.services;

import java.util.stream.Stream;

import org.alfa.comex.data.daos.TransaccionDaoImpl;
import org.alfa.comex.data.daos.TransaccionRepository;
import org.alfa.comex.data.model.Transaccion;
import org.alfa.comex.domain.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransaccionService {

	@Autowired
	private TransaccionRepository transaccionRepository;

	@Autowired
	TransaccionDaoImpl transaccionDaoImpl;

	public Stream<Transaccion> readAll() {
		return this.transaccionDaoImpl.listaTransaccion();
	}

	public Transaccion read(Long id) {

		Transaccion response = this.transaccionRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("The id don't exist: " + id));

		return response;
	}

	public Transaccion create(Transaccion newRegistry) {
		//TODO
		this.transaccionDaoImpl.registrarTransaccion(newRegistry);

		return Transaccion.builder().estado(1).build();

	}

	public Transaccion update(Long id, Transaccion newRegistry) {

		//TODO
		return this.transaccionRepository.save(newRegistry);
	}

}
