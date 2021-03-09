package nguyen.thi.thien.core.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "solution")
@Data
public class Solution implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "solution_id")
    private int solutionId;

    @Column(name = "result")
    private String result;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private Users users;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    @Column(name = "attempt")
    private int attempt;

    @Column(name = "markResult")
    private int markResult;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    private Status status;
}
