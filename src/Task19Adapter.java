public class Task19Adapter implements ReportGenerator {
    private final LegacyPdfEngine pdfEngine;

    public Task19Adapter(LegacyPdfEngine pdfEngine) {
        this.pdfEngine = pdfEngine;
    }

    @Override
    public byte[] generatePdfReport(ReportData data) {
        String htmlContent = data != null ? data.toHtml() : "";
        return pdfEngine.renderFromHtml(htmlContent);
    }
}