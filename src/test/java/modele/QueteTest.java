package modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueteTest {

    Quete q1 = new Quete("1|(4, 3)|()|2|100|explorer pic de Bhanborim");
    Quete q2 = new Quete("0|(1,1)|((3,4),)|4|350|vaincre Araignée lunaire");
    @Test
    void testPrecon() {
        System.out.println("test preconditions");
        assertTrue(q1.testPrecon());
        assertFalse(q2.testPrecon());
    }
}