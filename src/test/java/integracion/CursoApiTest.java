package integracion;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CursoApiTest {

    private static final String ALUMNO = "Josue Arizapana";
    private static final String CODIGO = "I202505315";

    @BeforeAll
    static void configurar() {
        System.out.println("Alumno: " + ALUMNO + " Código: " + CODIGO);
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    // Escenario 1: consultar todos los cursos
    @Test
    void consultarTodosLosCursos() {
        given()
                .when()
                .get("/api/cursos")
                .then()
                .statusCode(200)
                .body("size()", greaterThanOrEqualTo(3));
    }

    // Escenario 2: consultar el curso con id 1
    @Test
    void consultarCursoConId1() {
        given()
                .pathParam("id", 1)
                .when()
                .get("/api/cursos/{id}")
                .then()
                .statusCode(200)
                .body("nombre", equalTo("Seguridad de Aplicaciones"))
                .body("vacantes", greaterThan(0));
    }

    // Consulta adicional: curso con id 2
    @Test
    void consultarCursoConId2() {
        given()
                .pathParam("id", 2)
                .when()
                .get("/api/cursos/{id}")
                .then()
                .statusCode(200)
                .body("nombre", equalTo("Pruebas de Software"))
                .body("vacantes", greaterThan(0));
    }
}
