package app;

import entities.InputMessage;
import entities.OutputMessage;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Application {

    public List<InputMessage> inputCache;
    public List<OutputMessage> outputCache;

    private static Application instance;

    private Application() {
    }

    public static Application getInstance() {
        if (instance == null)
            instance = new Application();
        return instance;
    }

    public void processMessages() {
        outputCache = new ArrayList<>();
        OutputMessage outMsg;
        for (InputMessage inMsg : inputCache) {
            outMsg = new OutputMessage();
            outMsg.setMessageId(inMsg.getMessageId());
            outMsg.setVersionId(inMsg.getVersionId());
            outMsg.setStatus("UNPROCESSED");
            if (inMsg.getQuantity() != 0) {
                outMsg.setTotal(inMsg.getQuantity() * inMsg.getRate());
                outMsg.setStatus("PROCESSED");
            }
            outputCache.add(outMsg);
        }
    }
}
