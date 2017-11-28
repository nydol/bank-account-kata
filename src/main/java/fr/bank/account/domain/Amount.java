package fr.bank.account.domain;

public class Amount {

    private final long value;

    private Amount(long value) {
        this.value = Math.abs(value);
    }

    static Amount valueOf(long value) {
        return new Amount(value);
    }

    Amount add(Amount other) {
        return valueOf(value + other.value);
    }

    Amount subtract(Amount other) {
        return valueOf(value - other.value);
    }

    long toLong() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
