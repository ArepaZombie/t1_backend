package com.example.torresmora_t1_backend.services.imp;

import com.example.torresmora_t1_backend.dto.BusquedaRequest;
import com.example.torresmora_t1_backend.services.BusquedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;

@Service
public class BusquedaServiceImp implements BusquedaService {

  @Autowired
  ResourceLoader resourceLoader;

  @Override
  public String[] buscarPlaca(BusquedaRequest request) throws Exception {

      String[] vehiculo = null;
      Resource resource = resourceLoader.getResource("classpath:vehiculos.txt");

      try(BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {
          String line;
          while ((line = br.readLine()) != null) {
            vehiculo = line.split(";");

            if (request.placa().equals(vehiculo[1])) {
              //acá se puede solo retornar dado que "vehiculo" ya tiene el array de strings que necesitamos
              return vehiculo;
            }

          }
      }catch (Exception e){
          vehiculo = null;
          throw new Exception(e);
      }

      return null;
  }
}
