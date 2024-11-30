package org.knit.lab9;

public enum Season {
    SUMMER("ужасно жарко", "Международный день друзей 9-ого июня"),
    AUTUMN("можно выгулить модный тренч", "Международный мужской день 19-ого ноября"),
    WINTER("ужасно холодно", "Новый год гыыы"),
    SPRING("кайф", "Всемирный день комплимента 1-ого марта");

    private final String temperature;
    private final String associatedHoliday;

    Season(String temperature, String associatedHoliday) {
        this.temperature = temperature;
        this.associatedHoliday = associatedHoliday;
    }

    public String getInfo() {
        return "обычно " + temperature + ", у меня ассоциируется с " + associatedHoliday;
    }
}
