package cn.me.edge;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.DigestUtils;

//@SpringBootTest
class SpringBootSecurityJwtApplicationTests {

    @Test
    void contextLoads() {
        String pass = "admin";
        String encodePass = DigestUtils.md5DigestAsHex(pass.getBytes());
        System.out.println(encodePass);
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        String hashPass = bcryptPasswordEncoder.encode(encodePass);
        System.out.println(hashPass);

        boolean flag = bcryptPasswordEncoder.matches(encodePass,"$2a$10$FNbue.DhHT5gjd5mhOTj4OP4MvB/p5qceaW9s5UeesJIrUE7NkYqO");
        System.out.println(flag);
    }

}
