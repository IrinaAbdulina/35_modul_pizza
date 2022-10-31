package ru.sf;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class WeekAnalyser {
    private static String today;

    @Contract(pure = true)
    public static @NotNull String isItFridayToday(@NotNull String today) {
        WeekAnalyser.today = today;
        if (today.equals("Friday")) {
            return "Yes";
        } else {
            return "Nope";
        }

    }
}
