package fixtures;

import app.Application;
import entities.InputMessage;
import entities.OutputMessage;
import generator.InputMessageGenerator;
import org.concordion.api.BeforeExample;
import org.concordion.api.FullOGNL;
import org.concordion.api.extension.Extensions;
import org.concordion.ext.timing.TimerExtension;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import streams.InputStream;
import streams.OutputStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@FullOGNL
@Extensions(value = TimerExtension.class)
@RunWith(ConcordionRunner.class)
public class FixtureBase {

    public List<InputMessage> inputMessagesList;

    @BeforeExample
    public void setup() {
        inputMessagesList = new ArrayList<>();
    }

    public InputMessage generateMessage(Map<String, String> values) {
        return InputMessageGenerator.generateMessage(values);
    }

    public String publishInputMessages(List<InputMessage> messages) {
        return InputStream.publishInputMessages(messages);
    }

    public void processMessages() {
        Application.getInstance().processMessages();
    }

    public Map<String, OutputMessage> consumeOutputMessages() {
        return OutputStream.consumeOutputMessages();
    }

    public OutputMessage getOutputMessage(Map<String, OutputMessage> messages, String messageId) {
        return messages.getOrDefault(messageId.trim(), new OutputMessage());
    }
}
