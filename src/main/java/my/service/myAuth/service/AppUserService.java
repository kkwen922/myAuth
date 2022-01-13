package my.service.myAuth.service;

import my.service.myAuth.domain.AppOrg;
import my.service.myAuth.domain.AppRole;
import my.service.myAuth.domain.AppUser;

import java.util.List;

/**
 * @author: kevin Chang
 * @since : 2022/1/11
 */
public interface AppUserService {

    AppUser saveUser(AppUser user);
    AppRole saveRole(AppRole role);
    AppOrg saveOrg(AppOrg org);

    void addRoleToUser(String username,String roleName);
    void addOrgToUser(String username,String organization);

    AppUser getUser(String username);
    AppUser findUserById(Long id);
    List<AppUser> getUsers();
}
