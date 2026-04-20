import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class AplicatieCuBursaTest {

    AplicatieCuBursa app = new AplicatieCuBursa();

    @Test
    void sortTest1() {

        // arrange
        List<StudentBursier> lista = app.genereaza();

        // act
        List<StudentBursier> sortata = app.sorteaza(lista);

        // assert
        for (int i = 0; i < sortata.size() - 1; i++) {

            StudentBursier s1 = sortata.get(i);
            StudentBursier s2 = sortata.get(i + 1);

            int cmp = s1.getFormatieDeStudiu().compareTo(s2.getFormatieDeStudiu());
            if (cmp > 0) fail();

            if (cmp == 0) {
                cmp = s1.getNume().compareTo(s2.getNume());
                if (cmp > 0) fail();
            }
        }
    }
}