package entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OutputMessage {

    String messageId;
    int versionId;
    long total;
    String status;
}
