package tumnus.landpage.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tumnus.landpage.domain.entity.User;
import tumnus.landpage.domain.integration.request.UserRequest;
import tumnus.landpage.domain.integration.response.UserResponse;
import tumnus.landpage.domain.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public ResponseEntity<UserResponse> salvarUsuario (UserRequest userRequest) {
        User userDefault = User.builder()
                .cpf(userRequest.getCpf())
                .email(userRequest.getEmail())
                .name(userRequest.getName())
                .build();

        User userSaved = userRepository.save(userDefault);

        UserResponse userResponse = UserResponse.builder()
                .id(userSaved.getId())
                .cpf(userSaved.getCpf())
                .email(userSaved.getEmail())
                .name(userSaved.getName())
                .build();

        return ResponseEntity.ok(userResponse);
    }

    public List<User> listarTodos () {
        return userRepository.findAll();
    }

    public Optional<User> buscarPorId (Long id) {
        return userRepository.findById(id);
    }

    public void deletar (Long id) {
        userRepository.deleteById(id);
    }

}
