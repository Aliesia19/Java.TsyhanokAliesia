import org.example.FiniteStateMachine;
import org.example.State;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FiniteStateMachineTest {

    @ParameterizedTest
    @CsvSource({
            "abcTESTabc, F",      // Слово "TEST" присутнє, кінцевий стан F
            "abcTES, STATE_3",    // Рядок закінчується після "TES"
            "TEST, F",            // Рівно слово "TEST"
            "TES, STATE_3",       // Тільки частина "TES"
            "TTESTEST, F",        // "TEST" є у середині рядка
            "random, S",          // Слово "TEST" відсутнє
            "TE, STATE_2",        // Тільки "TE"
            "T, STATE_1",         // Тільки "T"
            "TTTEST, F",          // Багато "T", потім "TEST"
            "TESST, STATE_1"      // Переривання після "TES", повернення до "T"
    })
    void testFiniteStateMachine(String input, State expectedState) { // оголошення теста
        State actualState = FiniteStateMachine.processString(input);// обробка рядка
        assertEquals(expectedState, actualState, "Incorrect final state for input: " + input);// порівняння того що введено і те що має буть
    }
}
