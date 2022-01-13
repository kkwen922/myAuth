package my.service.myAuth.repo;

import my.service.myAuth.domain.AppOrg;
import my.service.myAuth.domain.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: kevin Chang
 * @since : 2022/1/13
 */
public interface AppOrgRepo extends JpaRepository<AppOrg,Long> {

    AppOrg findByOrganization(String organization);
}
