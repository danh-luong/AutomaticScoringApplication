package nguyen.thi.thien.core.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "status")
@Data
public class Status implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private int statusId;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "status",
            cascade = CascadeType.ALL)
    private List<Solution> solutionList;
}
