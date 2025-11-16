package com.xlc.config;

public class UrlCleaner {


    private static final String URL_CLEAN_ECHO = ".*/echo/.*";

    public static String clean(String url) {
        if (url.matches(URL_CLEAN_ECHO)) {
            url = url.replaceAll("/echo/.*", "/echo/{str}");
        }
        return url;
    }

}