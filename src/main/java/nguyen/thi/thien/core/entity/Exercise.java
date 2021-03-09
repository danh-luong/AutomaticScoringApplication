package nguyen.thi.thien.core.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "exercise")
@Data
public class Exercise implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private int exerciseId;

    @Column(name = "problem")
    private String problem;

    @Column(name = "solution")
    private String solution;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private Users users;
}
