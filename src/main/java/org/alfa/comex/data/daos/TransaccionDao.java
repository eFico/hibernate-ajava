package org.alfa.comex.data.daos;

import java.util.stream.Stream;

import org.alfa.comex.data.model.Transaccion;

public interface TransaccionDao {
	
	public void registrarTransaccion (Transaccion transaccion);
	public Boolean modificarTransaccion (Transaccion transaccion);
	
	public Stream<Transaccion> listaTransaccion();
	
}
