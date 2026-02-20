package dat102.f05.stabel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParentesSjekkerTest {

    private final dat102.f05.stabel.ParentesSjekker sjekker = new dat102.f05.stabel.ParentesSjekker();

    @Test
    void korrektParenteser() {
        assertTrue(sjekker.sjekkParenteser("{[()]}"));
    }

    @Test
    void manglerSluttParentes() {
        assertFalse(sjekker.sjekkParenteser("{[()}"));
    }

    @Test
    void manglerStartParentes() {
        assertFalse(sjekker.sjekkParenteser("[()]}}"));
    }

    @Test
    void feilRekkefolge() {
        assertFalse(sjekker.sjekkParenteser("{[(])}"));
    }

    @Test
    void javaProgramEksempel() {

        String javaprogram = """
                class HelloWorld {
                    public static void main(String[] args) {
                        System.out.println("Hello World!");
                    }
                }
                """;

        assertTrue(sjekker.sjekkParenteser(javaprogram));
    }
}
