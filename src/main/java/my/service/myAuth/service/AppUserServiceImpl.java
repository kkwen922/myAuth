package my.service.myAuth.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.service.myAuth.domain.AppOrg;
import my.service.myAuth.domain.AppRole;
import my.service.myAuth.domain.AppUser;
import my.service.myAuth.repo.AppOrgRepo;
import my.service.myAuth.repo.AppRoleRepo;
import my.service.myAuth.repo.AppUserRepo;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: kevin Chang
 * @since : 2022/1/11
 */
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepo userRepo;
    private final AppRoleRepo roleRepo;
    private final AppOrgRepo orgRepo;
//    private final PasswordEncoder passwordEncoder;

    @Override
    public AppUser saveUser(AppUser user) {
        log.info("Saving new user {} to the database",user.getUsername());
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public AppRole saveRole(AppRole role) {
        log.info("Saving new role {} to the database",role.getName());
        return roleRepo.save(role);
    }

    @Override
    public AppOrg saveOrg(AppOrg org) {
        log.info("Saving new organization {} to the database",org.getOrganization());
        return orgRepo.save(org);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName,username);
        AppUser user = userRepo.findByName(username);
        AppRole role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public void addOrgToUser(String username, String organization) {
        log.info("Adding organization {} to user {}", organization,username);
        AppUser user = userRepo.findByName(username);
        AppOrg org = orgRepo.findByOrganization(organization);
        user.getOrg().add(org);
    }

    @Override
    public AppUser getUser(String username) {
        log.info("Fetching user {}", username);
        return userRepo.findByUsername(username);
    }

    @Override
    public AppUser findUserById(Long id) {
        return userRepo.findById(id).orElse(new AppUser());
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        AppUser user = userRepo.findByUsername(username);
//        if(user == null){
//            log.error("User not found in the database");
//            throw new UsernameNotFoundException("User not found in the database");
//        }else{
//            log.info("User found in the database {}",username);
//        }
//
//        /*
//        GrantedAuthority接口
//        UserDeitails接口裡面有一個getAuthorities()方法。
//        這個方法將返回此用戶的所擁有的『權限』。這個集合將用於用戶的『訪問控制』，也就是Authorization。
//         */
//        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        user.getRoles().forEach(role -> {
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//        });
//        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
//    }
}
