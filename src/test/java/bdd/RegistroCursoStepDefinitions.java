package bdd;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class RegistroCursoStepDefinitions {

    private static final String ALUMNO = "Josue Arizapana";
    private static final String CODIGO = "I202505315";

    private static boolean alumnoMostrado = false;

    private String body;
    private Response respuesta;

    @Before
    public void prepararEscenario() {
        if (!alumnoMostrado) {
            System.out.println("Alumno: " + ALUMNO + " Código: " + CODIGO);
            alumnoMostrado = true;
        }
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Given("un curso con nombre {string}, precio {double} y {int} vacantes")
    public void unCursoConDatos(String nombre, double precio, int vacantes) {
        body = """
                {
                    "nombre": "%s",
                    "precio": %s,
                    "vacantes": %d
                }
                """.formatted(nombre, precio, vacantes);
    }

    @When("registra el curso en el sistema")
    public void registraElCurso() {
        respuesta = given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/api/cursos");
    }

    @Then("el sistema responde con el código {int}")
    public void elSistemaRespondeConElCodigo(int codigo) {
        respuesta.then().statusCode(codigo);
    }

    @And("la respuesta contiene el nombre {string}")
    public void laRespuestaContieneElNombre(String nombre) {
        respuesta.then().body("nombre", equalTo(nombre));
    }

    @Then("el sistema rechaza el registro")
    public void elSistemaRechazaElRegistro() {
        respuesta.then().statusCode(greaterThanOrEqualTo(400));
    }
}
