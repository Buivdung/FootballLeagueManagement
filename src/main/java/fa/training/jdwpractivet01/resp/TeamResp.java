package fa.training.jdwpractivet01.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamResp implements Serializable {

    private Long id;


    private String teamName;

    private String coachName;
    private String nationalName;
}
