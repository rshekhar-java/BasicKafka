package com.rs.basickafkaproducer.json;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.ser.std.*;

import java.io.*;
import java.time.*;
import java.time.format.*;

/**
 * created by rs 4/28/2022.
 */
public class CustomLocalDateSerializer extends StdSerializer<LocalDate> {
    private static final long serialVersionUID = 1L;
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");

    public CustomLocalDateSerializer() {
        this(null);
    }

    public CustomLocalDateSerializer(Class<LocalDate> t) {
        super(t);
    }

    @Override
    public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider arg2) throws IOException,JsonProcessingException {
            gen.writeString(formatter.format(value));
    }
}
