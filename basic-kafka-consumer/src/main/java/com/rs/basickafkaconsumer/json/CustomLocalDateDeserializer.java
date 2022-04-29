package com.rs.basickafkaconsumer.json;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.std.*;

import java.io.*;
import java.time.LocalDate;
import java.time.format.*;

/**
 * created by rs 4/28/2022.
 */
public class CustomLocalDateDeserializer extends StdDeserializer<LocalDate> {
    private static final long serialVersionUID = 1L;
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");

    public CustomLocalDateDeserializer() {
        super(LocalDate.class);
    }

    @Override
    public LocalDate deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        return LocalDate.parse(parser.readValueAs(String.class), formatter);
    }
}
