package nguyen.thi.thien.core.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "roles",
            cascade = CascadeType.ALL)
    private List<Users> users;
}
