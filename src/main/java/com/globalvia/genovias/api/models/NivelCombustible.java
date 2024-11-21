package com.globalvia.genovias.api.models;

public enum NivelCombustible {
  VEINTICINCO(25),
  CINCUENTA(50),
  SETENTA_Y_CINCO(75),
  CIEN(100);

  private final int porcentaje;

  NivelCombustible(int porcentaje) {
      this.porcentaje = porcentaje;
  }

  public int getPorcentaje() {
      return porcentaje;
  }

  public static NivelCombustible fromPorcentaje(int porcentaje) {
      for (NivelCombustible nivel : values()) {
          if (nivel.getPorcentaje() == porcentaje) {
              return nivel;
          }
      }
      throw new IllegalArgumentException("Nivel de combustible no válido");
  }
}

