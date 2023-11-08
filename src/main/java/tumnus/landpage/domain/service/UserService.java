package tumnus.landpage.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tumnus.landpage.domain.entity.User;
import tumnus.landpage.domain.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User salvar (User user) {
        return repository.save(user);
    }

    public List<User> listarTodos () {
        return repository.findAll();
    }

    public Optional<User> buscarPorId (Long id) {
        return repository.findById(id);
    }

    public void deletar (Long id) {
        repository.deleteById(id);
    }

}
