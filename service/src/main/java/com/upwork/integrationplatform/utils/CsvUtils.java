package com.upwork.integrationplatform.utils;

import static java.time.temporal.ChronoField.DAY_OF_MONTH;
import static java.time.temporal.ChronoField.HOUR_OF_DAY;
import static java.time.temporal.ChronoField.MINUTE_OF_HOUR;
import static java.time.temporal.ChronoField.MONTH_OF_YEAR;
import static java.time.temporal.ChronoField.SECOND_OF_MINUTE;
import static java.time.temporal.ChronoField.YEAR;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvParser.Feature;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.upwork.integrationplatform.model.VGTimeEntry;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.SignStyle;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;

public final class CsvUtils {

    private static final String CSV_FILENAME_SUFFIX = ".csv";
    private static final DateTimeFormatter CSV_FILENAME_DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendValue(YEAR, 4, 10, SignStyle.EXCEEDS_PAD)
            .appendLiteral('-')
            .appendValue(MONTH_OF_YEAR, 2)
            .appendLiteral('-')
            .appendValue(DAY_OF_MONTH, 2)
            .appendLiteral('-')
            .appendValue(HOUR_OF_DAY, 2)
            .appendLiteral('-')
            .appendValue(MINUTE_OF_HOUR, 2)
            .appendLiteral('-')
            .appendValue(SECOND_OF_MINUTE, 2)
            .toFormatter();

    public String getFileName(String prefix) {
        return prefix
                + LocalDateTime.now().format(CSV_FILENAME_DATE_TIME_FORMATTER)
                + CSV_FILENAME_SUFFIX;
    }


    public static <T> List<T> readAllRecords(Path filePath, Class<T> clazz) throws IOException {
        return readAllRecords(Files.readString(filePath), clazz);
    }

    public static <T> List<T> readAllRecords(String csv, Class<T> clazz) throws IOException {
        CsvMapper csvMapper = new CsvMapper();
        csvMapper.configure(Feature.FAIL_ON_MISSING_COLUMNS, false);
        csvMapper.configure(Feature.INSERT_NULLS_FOR_MISSING_COLUMNS, true);
        CsvSchema bootstrapSchema = csvMapper
                .schemaFor(clazz)
                .withColumnSeparator(',')
                .withHeader();
//        CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();

        MappingIterator<T> mappingIterator = csvMapper
                .readerFor(clazz)
                .with(bootstrapSchema)
                .readValues(csv);

        return mappingIterator.readAll();
    }

    public static <T> String toCsvText(List<T> details, Class<T> clazz) throws IOException {
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema csvSchema = csvMapper
                .schemaFor(clazz)
                .withHeader()
                .withColumnSeparator(',')
                .withLineSeparator("\n")
                .withQuoteChar('"');
        ObjectWriter csvWriter = csvMapper.writer(csvSchema);

        StringWriter stringWriter = new StringWriter();
        csvWriter.writeValues(stringWriter).writeAll(details);
        stringWriter.flush();

        return stringWriter.toString();
    }

    public static <T> File writeToCsvFile(List<T> elementsToWrite, Class<T> clazz, String fileName) throws IOException {
        String viewsAsCsvText = toCsvText(elementsToWrite, clazz);
        File file = File.createTempFile(fileName, "");
        try (FileWriter fw = new FileWriter(file)) {
            IOUtils.write(viewsAsCsvText.getBytes(), fw);
        }
        return file;
    }

}
