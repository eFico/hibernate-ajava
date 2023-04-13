package org.alfa.comex.api.resources;

import java.util.stream.Stream;

import org.alfa.comex.data.model.Transaccion;
import org.alfa.comex.domain.services.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1" +TransaccionResource.TRANSACCION)
public class TransaccionResource {
	
    public static final String TRANSACCION = "/transaccion";
    public static final String ID = "/{id}";

    @Autowired
    private TransaccionService transaccionService;
    
    @GetMapping
    public Stream<Transaccion> readAll() {
        return this.transaccionService.readAll();
    }
    @GetMapping(value = ID)
    public Transaccion read(@PathVariable Long id){
        return  this.transaccionService.read(id);
    }

    @PostMapping
    public void create(@RequestBody Transaccion newRegistry) {
        this.transaccionService.create(newRegistry);
    }

    @PutMapping(value = ID)
    public Transaccion update(@PathVariable Long id, @RequestBody Transaccion newRegistry){
        return this.transaccionService.update(id,newRegistry);
    }

}
