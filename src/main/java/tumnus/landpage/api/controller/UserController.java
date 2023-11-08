package tumnus.landpage.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tumnus.landpage.domain.entity.User;
import tumnus.landpage.domain.service.UserService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<User> salvarUsuario(@RequestBody User user) {
        User usuarioSalvo = service.salvar(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
    }

    @GetMapping
    public ResponseEntity<List<User>> listarTodos() {
        List<User> usuarios = service.listarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(usuarios);
    }

}
