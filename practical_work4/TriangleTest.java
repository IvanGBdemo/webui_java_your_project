package practical_work4;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static practical_work4.CalculatingTheAreaOfAnIsoscelesTriangle.calculatingTheAreaOfAnIsoscelesTriangle;


public class TriangleTest {

    private static Logger logger = (Logger) LoggerFactory.getLogger(TriangleTest.class);

    @BeforeAll
    static void BeforeAll() {
        logger.error("error");
    }


    @Test
    @DisplayName("Проверка работы метода calculatingTheAreaOfAnIsoscelesTriangle на верность результата расчётов")
    void testCalculatingTheAreaOfAnIsoscelesTriangle() throws CalculatingTheAreaOfAnIsoscelesTriangleException {
        double result = calculatingTheAreaOfAnIsoscelesTriangle(5.1, 2.6, 3.5);
        Assertions.assertEquals(4.199999999999999, result);
    }

    @Test
    @DisplayName("Проверка работы метода calculatingTheAreaOfAnIsoscelesTriangle на выкидывание Exception")
    void сalculatingTheAreaOfAnIsoscelesTriangleExceptionTest() {
        assertThatExceptionOfType(CalculatingTheAreaOfAnIsoscelesTriangleException.class).isThrownBy(
                () -> calculatingTheAreaOfAnIsoscelesTriangle(-1.0, 1.0, 1.0));
    }
}