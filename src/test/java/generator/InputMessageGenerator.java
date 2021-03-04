package generator;

import entities.InputMessage;

import java.util.Map;

public class InputMessageGenerator {

    public static InputMessage generateMessage(Map<String, String> values) {
        return InputMessage.builder()
                .messageId(values.get("messageId").trim())
                .versionId(Integer.valueOf(values.get("versionId").trim()))
                .rate(Integer.valueOf(values.get("rate").trim()))
                .quantity(Integer.valueOf(values.get("quantity").trim()))
                .build();
    }
}
