package com.example.torresmora_t1_backend.controller;

import com.example.torresmora_t1_backend.dto.BusquedaRequest;
import com.example.torresmora_t1_backend.dto.BusquedaResponse;
import com.example.torresmora_t1_backend.services.BusquedaService;
import com.example.torresmora_t1_backend.services.imp.BusquedaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/t1")
public class BusquedaController {

  @Autowired
  BusquedaService service;

  @PostMapping("/busqueda")
  public BusquedaResponse busqueda(@RequestBody BusquedaRequest request) {

    try {

      String[] vehiculo = service.buscarPlaca(request);

      if(vehiculo == null) {
        return new BusquedaResponse("01","Placa no encontrada",
          "","","","","");
      }
      //System.out.println("Respuesta:"+ Arrays.toString(vehiculo));

      return new BusquedaResponse("00","",
        vehiculo[2],vehiculo[3],vehiculo[4],vehiculo[5],vehiculo[6]);


    }catch (Exception e) {
      return new BusquedaResponse("01","Error de servicio",
        "","","","","");
    }


  }

}
