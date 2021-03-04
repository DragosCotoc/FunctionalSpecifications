package streams;

import app.Application;
import entities.InputMessage;

import java.util.ArrayList;
import java.util.List;

public class InputStream {

    public static String publishInputMessages(List<InputMessage> messages) {
        Application.getInstance().inputCache = new ArrayList<>();
        List<String> failedMessages = new ArrayList<>();
        for (InputMessage message : messages) {
            Application.getInstance().inputCache.add(message);
        }
        return "successfully";
    }
}
