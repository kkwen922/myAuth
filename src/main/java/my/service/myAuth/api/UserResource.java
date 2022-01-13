package my.service.myAuth.api;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.service.myAuth.domain.AppRole;
import my.service.myAuth.domain.AppUser;
import my.service.myAuth.service.AppUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.List;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

/**
 * @author: kevin Chang
 * @since : 2022/1/11
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class UserResource {

    private final AppUserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<AppUser> findUser(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.findUserById(id));
    }

    @PostMapping("/user/save")
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<AppRole> saveRole(@RequestBody AppRole role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> AddroleToUser(@RequestBody RoleToUserForm form) {
        userService.addRoleToUser(form.getRoleName(), form.getUsername());
        return ResponseEntity.ok().build();
    }



}

@Data
class RoleToUserForm {
    private String username;
    private String roleName;
}
