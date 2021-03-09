package nguyen.thi.thien.core.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class Users implements Serializable {

    @Id
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles roles;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id")
    private UserDetail userDetail;

    @OneToMany(mappedBy = "users",
            cascade = CascadeType.ALL)
    private List<Exercise> exercises;

    @OneToMany(mappedBy = "users",
            cascade = CascadeType.ALL)
    private List<Solution> solutions;
}
