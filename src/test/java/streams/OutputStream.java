package streams;

import app.Application;
import entities.OutputMessage;

import java.util.HashMap;
import java.util.Map;

public class OutputStream {

    public static Map<String, OutputMessage> consumeOutputMessages() {
        Map<String, OutputMessage> map = new HashMap<>();
        for (OutputMessage outMsg : Application.getInstance().outputCache) {
            map.put(outMsg.getMessageId(), outMsg);
        }
        return map;
    }
}
