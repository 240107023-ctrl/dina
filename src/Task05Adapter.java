public class Task05Adapter implements AdvancedPrinter {
    private final BasicPrinter basicPrinter;

    public Task05Adapter(BasicPrinter basicPrinter) {
        this.basicPrinter = basicPrinter;
    }

    @Override
    public void printDocument(PrintRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("PrintRequest cannot be null");
        }
        String textToPrint = request.getHeader() + "\n" + request.getBody() + "\n" + request.getFooter();
        basicPrinter.printRawText(textToPrint);
    }
}