import com.ucpeo.tx.Config;
import com.ucpeo.tx.UserTx;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Config.class)
public class MyTest {
    @Autowired
    UserTx userTx;

    @Test
    public void success() {
        System.out.println(userTx.getClass());
        userTx.pass();
    }

    @Test
    public void fail() {
        try {
            userTx.fail();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
