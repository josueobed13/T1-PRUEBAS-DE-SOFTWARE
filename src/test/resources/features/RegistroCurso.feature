Feature: Registro de cursos

  Scenario: Registro de curso válido
    Given un curso con nombre "Selenium Avanzado", precio 400.0 y 20 vacantes
    When registra el curso en el sistema
    Then el sistema responde con el código 200
    And la respuesta contiene el nombre "Selenium Avanzado"

  Scenario: Registro con precio inválido
    Given un curso con nombre "Curso Gratis", precio 0.0 y 20 vacantes
    When registra el curso en el sistema
    Then el sistema rechaza el registro
