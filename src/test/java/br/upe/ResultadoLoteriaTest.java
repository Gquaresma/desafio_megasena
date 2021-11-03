package br.upe;
import java.util.ArrayList;

import org.junit.Test;
import junit.framework.TestCase;

public class ResultadoLoteriaTest extends TestCase {
/** Número  resultado da mega-sena. */
    private final static String numeroSorteados = "020923354358";
    /**
    * Teste do método pairsNumberso()
    */
    @Test
    public void testpairsNumbers() {
        final ArrayList<String> ultimoResultado = ResultadoLoteria.pairsNumbers(numeroSorteados, "megasena");

        assertNotNull(ultimoResultado);
        assertTrue( ultimoResultado.size() == (numeroSorteados.length()) / 2 );
    }
}