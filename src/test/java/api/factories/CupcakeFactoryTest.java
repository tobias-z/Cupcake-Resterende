package api.factories;

import exeptions.ValidationError;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CupcakeFactoryTest {

    CupcakeFactory cupcakeFactory;

    @BeforeEach
    void setupFactory() {
        cupcakeFactory = new CupcakeFactory();
    }


    @Test
    void isValid_shouldReturnTrue() {
        try {
            cupcakeFactory.setCupcakeBottomId("102");
            cupcakeFactory.setCupcakeTopId("102");
            cupcakeFactory.setPris("102.0");
            cupcakeFactory.setPris(30,30, "3");
            cupcakeFactory.setAntal("4");
            cupcakeFactory.setCupcakeBottomType("Choco");
            cupcakeFactory.setCupcakeTopType("Choco");
        } catch (ValidationError validationError) {
            validationError.printStackTrace();
        }

        boolean isValid = cupcakeFactory.isValid();
        assertTrue(isValid);
    }

    @Test
    void validationError_shouldThrowExceptionOnBadInput() {
        assertThrows(ValidationError.class, () -> {
            cupcakeFactory.setCupcakeTopId("");
        });

        assertThrows(ValidationError.class, () -> {
            cupcakeFactory.setCupcakeTopId("not_a_number");
        });

        assertThrows(ValidationError.class, () -> {
            cupcakeFactory.setCupcakeBottomId("");
        });

        assertThrows(ValidationError.class, () -> {
            cupcakeFactory.setCupcakeBottomId("not_a_number");
        });

        assertThrows(ValidationError.class, () -> {
            cupcakeFactory.setPris("");
        });

        assertThrows(ValidationError.class, () -> {
            cupcakeFactory.setPris("not_a_number");
        });

        assertThrows(ValidationError.class, () -> {
            cupcakeFactory.setAntal("");
        });

        assertThrows(ValidationError.class, () -> {
            cupcakeFactory.setAntal("not_a_number");
        });
    }
}