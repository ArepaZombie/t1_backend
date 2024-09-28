package com.example.torresmora_t1_backend.services;

import com.example.torresmora_t1_backend.dto.BusquedaRequest;

public interface BusquedaService {
  String[] buscarPlaca(BusquedaRequest request) throws Exception;
}
