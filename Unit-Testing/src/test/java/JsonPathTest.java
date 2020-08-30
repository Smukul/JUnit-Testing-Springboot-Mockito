import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class JsonPathTest {
    @Test
    public void learning() throws IOException {
        DocumentContext context = JsonPath.parse(new File("D:\\GIT\\JUnit-Testing-Springboot-Mockito\\Unit-Testing\\src\\test\\resources\\json.json"));
        int length = context.read("$.length()");
        //System.out.println(length);
        assertThat(length).isEqualTo(4);

        List<Integer> ids = context.read("$..id");
        assertThat(ids).contains(1002);

        System.out.println(context.read("$.[0:1]").toString());
    }
}
