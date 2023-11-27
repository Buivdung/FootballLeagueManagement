package fa.training.jdwpractivet01.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collections;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Teams implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "team_name" ,unique = true)
    private String teamName;
    @Column(name = "coach_name")
    private String coachName;
    @Column(name = "national_name")
    private String nationalName;
}
