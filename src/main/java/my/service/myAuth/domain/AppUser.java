package my.service.myAuth.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author: kevin Chang
 * @since : 2022/1/11
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String username; // email
    private String password;

    @ManyToMany(fetch = FetchType.EAGER) //開始查詢時就會將AppRole中的物件立刻載入
    @Fetch(FetchMode.SUBSELECT)
    private Collection<AppRole> roles = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private Collection<AppOrg> org = new ArrayList<>(); ;

}
