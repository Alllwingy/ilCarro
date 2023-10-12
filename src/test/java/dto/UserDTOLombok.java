package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter // Annotations that applies to whole Class
@Setter
@Builder
@ToString // With any possiable combinations

public class UserDTOLombok {

    String name;
    String lastName;
    String email;
    String password;
}
