package com.globalvia.genovias.api.models.base;

import java.time.LocalDate;
import java.time.LocalTime;

public interface Dateable {
  LocalDate getFecha();
  LocalTime getHora();
}
