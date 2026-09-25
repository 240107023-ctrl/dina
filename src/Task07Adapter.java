public class Task07Adapter implements ModernDataProcessor {
    private final LegacyXmlParser xmlParser;

    public Task07Adapter(LegacyXmlParser xmlParser) {
        this.xmlParser = xmlParser;
    }

    @Override
    public JsonNode processData(String jsonPayload) {
        if (jsonPayload == null || jsonPayload.trim().isEmpty()) {
            throw new IllegalArgumentException("Payload cannot be empty");
        }
        String xmlPayload = JsonToXmlUtils.convertJsonToXml(jsonPayload);
        String xmlResult = xmlParser.executeXml(xmlPayload);
        return XmlToJsonUtils.convertXmlToJson(xmlResult);
    }
}