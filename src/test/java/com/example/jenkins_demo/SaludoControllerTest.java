
package com.example.jenkins_demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SaludoControllerTest {

    @Test
    void debeDevolverSaludo() {
        // Arrange: preparar el objeto
        SaludoController controller = new SaludoController();

        // Act: ejecutar el método
        String resultado = controller.saludo().get("mensaje");

        // Assert: comprobar el resultado
        assertEquals("Hola desde Jenkins jeje", resultado);
    }
}
