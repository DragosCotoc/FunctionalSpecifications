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

    public static InputMessage generateMessage(String values) {
        String[] arrayValues = values.trim().replaceAll("[ ]+", " ").split(" ");
        return InputMessage.builder()
                .messageId(arrayValues[1])
                .versionId(Integer.valueOf(arrayValues[2]))
                .rate(Integer.valueOf(arrayValues[3]))
                .quantity(Integer.valueOf(arrayValues[4]))
                .build();
    }
}
