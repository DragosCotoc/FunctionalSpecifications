package entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class InputMessage {

    String messageId;
    int versionId;
    int rate;
    int quantity;

}
