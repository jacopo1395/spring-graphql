package org.jacopocarlini.micrographql.config;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Component
public class DateScalar extends GraphQLScalarType {
    public DateScalar() {
        super("Date", "Java 11 LocalDate as scalar.", new Coercing<LocalDate, String>() {
            @Override
            public String serialize(Object dataFetcherResult) throws CoercingSerializeException {
                if (dataFetcherResult instanceof LocalDate) {
                    return dataFetcherResult.toString();
                } else {
                    throw new CoercingSerializeException("Expected a LocalDate object.");
                }
            }

            @Override
            public LocalDate parseValue(Object input) throws CoercingParseValueException {
                try {
                    if (input instanceof String) {
                        return LocalDate.parse((String) input);
                    } else {
                        throw new CoercingParseValueException("Expected a String");
                    }
                } catch (DateTimeParseException e) {
                    throw new CoercingParseValueException(String.format("Not a valid date: '%s'.", input), e
                    );
                }
            }

            @Override
            public LocalDate parseLiteral(Object input) throws CoercingParseLiteralException {
                if (input instanceof StringValue) {
                    try {
                        return LocalDate.parse(((StringValue) input).getValue());
                    } catch (DateTimeParseException e) {
                        throw new CoercingParseLiteralException(e);
                    }
                } else {
                    throw new CoercingParseLiteralException("Expected a StringValue.");
                }
            }
        });
    }


}
