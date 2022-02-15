package template;

import org.junit.Ignore;
import org.junit.Test;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@Ignore
public class GeneratorStudyTest {

    @Test
    public void whenProduce() {
        GeneratorStudy generator = new GeneratorStudy();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = Map.of("name", "Olga", "subject", "you");
        String expected = "I am a Olga, Who are you?";
        assertThat(expected, is(generator.produce(template, args)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenTheKeysAreNotInTheMap() {
        GeneratorStudy generator = new GeneratorStudy();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = Map.of("name", "Olga");
        generator.produce(template, args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenExtraKeys() {
        GeneratorStudy generator = new GeneratorStudy();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = Map.of("name", "Olga", "subject", "you", "city", "Еkaterinburg");
        generator.produce(template, args);
    }
}
