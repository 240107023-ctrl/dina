import java.util.Currency;

public class Task10Adapter implements CurrencyConverter {
    private final OldFxRatesProvider fxRatesProvider;

    public Task10Adapter(OldFxRatesProvider fxRatesProvider) {
        this.fxRatesProvider = fxRatesProvider;
    }

    @Override
    public double getExchangeRate(Currency source, Currency target) {
        if (source == null || target == null) {
            throw new IllegalArgumentException("Currencies must not be null");
        }
        return fxRatesProvider.fetchRate(source.getCurrencyCode(), target.getCurrencyCode());
    }
}