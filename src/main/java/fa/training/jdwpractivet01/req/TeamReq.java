package fa.training.jdwpractivet01.req;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamReq implements Serializable {

    private Long id;
    @NotEmpty(message = "Team name must not be empty.")
    private String teamName;
    private String coachName;
    private String nationalName;
}
