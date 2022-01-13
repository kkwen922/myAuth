package my.service.myAuth.repo;

import my.service.myAuth.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: kevin Chang
 * @since : 2022/1/11
 */
public interface AppUserRepo extends JpaRepository<AppUser,Long> {

    AppUser findByUsername(String username);

    AppUser findByName(String name);

}
