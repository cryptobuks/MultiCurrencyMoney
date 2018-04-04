class Money implements Expression {
    protected int amount; // protected so the subclass can still see it

    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    public boolean equals(Object object) {
        Money money = (Money) object;
        return this.amount == money.amount && this.currency().equals(money.currency());
    }

    public String currency() {
        return currency;
    }

    Money plus(Money addend) {
        return new Money(amount + addend.amount, currency);
    }

    public String toString() {
        return amount + "" + currency;
    }
}
