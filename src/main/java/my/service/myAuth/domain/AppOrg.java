package my.service.myAuth.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author: kevin Chang
 * @since : 2022/1/13
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppOrg {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String organizationId;
    private String organization;
}
