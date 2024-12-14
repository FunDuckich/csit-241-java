package org.knit.lab10;

public class Pair<F, S> {
    private F firstValue;
    private S secondValue;

    public Pair(F firstValue, S secondValue) {
        setFirst(firstValue);
        setSecond(secondValue);
    }

    public Pair(Pair<F, S> other) {
        setFirst(other.getFirst());
        setSecond(other.getSecond());
    }

    public F getFirst() {
        return firstValue;
    }

    public void setFirst(F newFirstValue) {
        firstValue = newFirstValue;
    }

    public S getSecond() {
        return secondValue;
    }

    // Метод для установки второго значения
    public void setSecond(S newSecondValue) {
        secondValue = newSecondValue;
    }

    @Override
    public String toString() {
        return "Pair {\n" +
                getFirst().getClass().getSimpleName() + " first = " + firstValue +
                ",\n" + getSecond().getClass().getSimpleName() + " second = " + secondValue +
                "\n}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (o instanceof Pair) {
            Pair<?, ?> other = (Pair<?, ?>) o;
            return firstValue.equals(other.firstValue) && secondValue.equals(other.secondValue);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return firstValue.hashCode() + secondValue.hashCode();
    }
}
