import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
class MainTest {

    @Test
    @Timeout(value = 22)
    void main() {
        try {
            Main.main(new String[]{""});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}