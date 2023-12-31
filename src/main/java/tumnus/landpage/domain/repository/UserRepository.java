package tumnus.landpage.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tumnus.landpage.domain.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
