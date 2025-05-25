package com.alexandre.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class URL {

    public static String decodeParam(String arg) {
        return URLDecoder.decode(arg, StandardCharsets.UTF_8);
    }
}
