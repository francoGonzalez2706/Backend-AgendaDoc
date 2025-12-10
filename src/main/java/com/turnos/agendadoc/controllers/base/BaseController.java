package com.turnos.agendadoc.controllers.base;

import com.turnos.agendadoc.services.base.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class BaseController <D,DC,DE,ID>{

    protected final BaseService<D,DC,DE,ID> baseService;

    public BaseController(BaseService<D,DC,DE,ID> baseService) {
        this.baseService = baseService;
    }

    @PostMapping
    public ResponseEntity<?> save (@RequestBody DC dc){
        try{
            return ResponseEntity.ok(baseService.save(dc));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Ocurrio un error del tipo " + e.getClass() + " \nMensaje: " + e.getMessage());
        }
    }
    @PutMapping("{id}")
    public ResponseEntity<?> edit (@PathVariable ID id, @RequestBody DE de){
        try{
            return ResponseEntity.ok(baseService.update(id, de));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Ocurrio un error del tipo " + e.getClass() + " \nMensaje: " + e.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity<?> findAll (){
        try{
            return ResponseEntity.ok(baseService.findAll());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Ocurrio un error del tipo " + e.getClass() + " \nMensaje: " + e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById (@PathVariable ID id){
        try{
            return ResponseEntity.ok(baseService.findById(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Ocurrio un error del tipo " + e.getClass() + " \nMensaje: " + e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete (@PathVariable ID id){
        try{
            baseService.deleteById(id);
            return ResponseEntity.ok("Entidad con id " + id + " eliminada con exito");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Ocurrio un error del tipo " + e.getClass() + " \nMensaje: " + e.getMessage());
        }
    }
}