package com.dan.bancodigitaldescomplicado.web.apiControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dan.bancodigitaldescomplicado.model.dto.ErrorResponse;
import com.dan.bancodigitaldescomplicado.service.interfaces.UserService;
// import com.dan.bancodigitaldescomplicado.model.dto.LoginResponseDto;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.web.bind.annotation.PostMapping;
// import com.dan.bancodigitaldescomplicado.model.dto.LoginDto;
// import com.dan.bancodigitaldescomplicado.model.entity.Roles;
// import com.dan.bancodigitaldescomplicado.model.entity.User;
// import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    // @PostMapping("/register")
    // public ResponseEntity<?> save(@RequestBody LoginDto user) throws Exception {

    // String ecryptedPassword = new
    // BCryptPasswordEncoder().encode(user.password());

    // User nUser = new User(user.username(), ecryptedPassword, Roles.USER);

    // System.out.println(nUser.getUsername() + " " + nUser.getPassword());

    // var newUser = userService.save(nUser);

    // return ResponseEntity.ok().body(newUser);
    // }

    @GetMapping("/username-exists/{username}")
    public ResponseEntity<?> usernameExists(@PathVariable("username") String username) throws Exception {

        if (username == null)
            throw new RuntimeException("campo username não pode ser vazio");

        if (userService.usernameAlreadyExists(username))
            return ResponseEntity.badRequest().body(new ErrorResponse("400", "nome de usuário já em uso"));

        return ResponseEntity.ok().build();

    }

}
