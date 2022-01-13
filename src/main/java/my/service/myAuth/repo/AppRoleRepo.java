package my.service.myAuth.repo;

import my.service.myAuth.domain.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: kevin Chang
 * @since : 2022/1/11
 */
public interface AppRoleRepo extends JpaRepository<AppRole,Long> {

    AppRole findByName(String name);
}
