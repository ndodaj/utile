package al.utile.utile;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/home") // not protected
    public String utileApp() {
        return "Utile app";
    }

    @GetMapping("/login") // not protected
    public String login() {
        return "login page";
    }

    @GetMapping("/secret") // protected
    public String secret() {
        return "secret page";
    }

}
