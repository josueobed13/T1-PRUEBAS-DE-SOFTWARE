# Evaluación T1 – Pruebas de Software

Proyecto de matrícula de cursos (Spring Boot 4.1.0, Java 17, Maven). Base de datos H2 en memoria.

## Requisitos
- JDK 17
- Maven 3.9.9 (Bundled Maven de IntelliJ IDEA)
- IntelliJ IDEA Community Edition 2025

## Ejecución
1. Abrir el proyecto en IntelliJ IDEA (Open → `pom.xml` → Open as Project) y esperar la descarga de dependencias.
2. Ejecutar `ModeloT1PswApplication` (la aplicación queda en http://localhost:8080). Los datos de prueba se cargan con `DataLoader`.
3. Con la aplicación encendida, ejecutar las pruebas de las preguntas 2 y 3. La pregunta 1 no requiere la aplicación encendida.

## Pruebas implementadas
| Pregunta | Tecnología | Archivo |
|---|---|---|
| 1 | JUnit 5 + Mockito | `src/test/java/com/pruebas/model/services/InscripcionServiceTest.java` |
| 2 | Rest Assured | `src/test/java/integracion/CursoApiTest.java` |
| 3 | Cucumber + Gherkin | `src/test/resources/features/RegistroCurso.feature`, `src/test/java/bdd/RegistroCursoStepDefinitions.java`, `src/test/java/bdd/RunCucumberTest.java` |

## Capturas
Las capturas de ejecución de cada pregunta se encuentran en la carpeta `capturas/`.
