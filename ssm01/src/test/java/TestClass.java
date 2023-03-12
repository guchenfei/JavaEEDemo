import com.example.pojo.User;
import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.UUID;

@SpringJUnitConfig(locations = "classpath:applicationContext.xml")
public class TestClass {
    @Autowired
    private UserService userService;

    @Test
    public void testFindUser(){
        User user = userService.findUser("张三", "123456");
        System.out.println(user);
    }

    @Test
    public void getUUID(){
        final String string = UUID.randomUUID().toString();
        System.out.println(string);
    }
}
