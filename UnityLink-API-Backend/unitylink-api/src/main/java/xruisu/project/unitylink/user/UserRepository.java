package xruisu.project.unitylink.user;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
	   Optional<User> findByEmail(String email);
	   //Optional<User> findByAllIds(String firstName, String lastName, String userId, String email);
}
