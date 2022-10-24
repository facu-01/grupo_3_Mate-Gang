package com.example.capybara.controllers;

import com.example.capybara.entities.CarritoProductoDetalle;
import com.example.capybara.services.CarritoProductoDetalleServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/carritoproductodetalles")
public class CarritoProductoDetalleController extends BaseControllerImpl<CarritoProductoDetalle, CarritoProductoDetalleServiceImpl>{

    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam float filtro, Pageable pageable){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro, pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
