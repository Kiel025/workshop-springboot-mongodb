package com.kiel.workshopmongo.resources.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class URL {

    public static String decodeParam(String text) {
        return URLDecoder.decode(text, StandardCharsets.UTF_8);
    }

    public static LocalDate convertDate(String textDate, LocalDate defaultDate) {
        try {
            return LocalDate.parse(textDate);
        } catch (DateTimeParseException e) {
            return defaultDate;
        }
    }

}
