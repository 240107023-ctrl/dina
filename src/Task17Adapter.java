public class Task17Adapter implements ImageTransformer {
    private final LegacyImageProcessor legacyProcessor;

    public Task17Adapter(LegacyImageProcessor legacyProcessor) {
        this.legacyProcessor = legacyProcessor;
    }

    @Override
    public byte[] resize(byte[] imageBytes, int width, int height) {
        if (imageBytes == null || imageBytes.length == 0) return new byte[0];
        return legacyProcessor.scaleImage(imageBytes, width, height);
    }
}