package com.example.client;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizationService {
    public static ResourceBundle getResourceBundle(Locale locale) {
        return ResourceBundle.getBundle("messages", locale);
    }
}
