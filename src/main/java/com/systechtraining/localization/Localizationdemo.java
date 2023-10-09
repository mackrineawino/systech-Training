package com.systechtraining.localization;
import java.util.Locale;

public class Localizationdemo {
    public static void main(String[] args) {
        Locale locale = Locale.getDefault();

       // Arrays.stream(Locale.getAvailableLocales()).forEach(System.out::println);

        System.out.println("locale = " + locale);
        locale = new Locale.Builder()
                .setLanguage("fr")
                .setRegion("FR")
                .build();
        System.out.println("locale = " + locale);

    }
}
