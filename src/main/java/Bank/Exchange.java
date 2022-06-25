package Bank;

public class Exchange {

private static final double euroToPlnRate = 4.6;
private static final double dollarToPlnRate = 4.3;
private static final double dollarToEurRate = 4.3/4.6;
private static final double euroToDollarRate = 4.6/4.3;

    static double convertFromEurToPln(double moneyToConvert) {
    return euroToPlnRate*moneyToConvert;
    }

    static double convertFromPlnToEur(double moneyToConvert) {
        return moneyToConvert/euroToPlnRate;
    }

    static double convertFromDoltoPln(double moneyToConvert) {return dollarToPlnRate*moneyToConvert;}

    static double convertFromPlnToDol(double moneyToConvert) {
        return moneyToConvert/dollarToPlnRate;
    }

    static double convertFromEurToDol(double moneyToConvert) {
        return moneyToConvert*euroToDollarRate;
    }

    static double convertFromDolToEur(double moneyToConvert) {
        return moneyToConvert*dollarToEurRate;
    }

}
