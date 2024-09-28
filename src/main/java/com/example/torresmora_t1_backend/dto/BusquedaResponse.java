package com.example.torresmora_t1_backend.dto;

public record BusquedaResponse(
  String codigo,
  String mensaje,
  String marca,
  String modelo,
  String asientos,
  String precio,
  String color
) {
}
