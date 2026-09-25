import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Task08Adapter implements StreamDataReader {
    private final LegacyByteStreamReader byteStreamReader;

    public Task08Adapter(LegacyByteStreamReader byteStreamReader) {
        this.byteStreamReader = byteStreamReader;
    }

    @Override
    public String readNextChunk(InputStream inputStream) {
        byte[] bytes = byteStreamReader.readBytes(inputStream, 1024);
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        return new String(bytes, StandardCharsets.UTF_8);
    }
}