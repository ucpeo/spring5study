import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import com.ucpeo.config.Config;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {Config.class})
public class MyTest {
    // 按名称注入
    @Autowired
    @Qualifier("hello")
    String hello;

    @Autowired  //按类型注入
    List list;

    @Test
    public void Test() {
        System.out.println(hello);
        list.forEach(System.out::println);
    }

}
