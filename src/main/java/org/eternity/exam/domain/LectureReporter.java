//package org.eternity.exam.domain;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.dataformat.csv.CsvMapper;
//import com.fasterxml.jackson.dataformat.csv.CsvSchema;
//import com.fasterxml.jackson.dataformat.xml.XmlMapper;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//import org.springframework.jdbc.core.simple.JdbcClient;
//
//import java.io.FileWriter;
//
//public class LectureReporter {
//    public enum FormatType { JSON, CSV, XML }
//    public enum StorageType { DATABASE, FILE }
//
//    private final JdbcClient jdbcClient;
//
//    public LectureReporter(JdbcClient jdbcClient) {
//        this.jdbcClient = jdbcClient;
//    }
//
//    public void report(FormatType formatType, StorageType storageType, Lecture lecture) throws Exception {
//        String serialized = null;
//
//        // 포맷 변환
//        switch (formatType) {
//            case JSON -> {
//                serialized = getJsonContent(lecture);
//            }
//            case CSV -> {
//                serialized = getCsvContent(lecture);
//            }
//            case XML -> {
//                serialized = getXmlContent(lecture);
//            }
//        }
//
//        //  저장
//        switch (storageType) {
//            case DATABASE -> {
//                jdbcClient.sql("INSERT INTO LECTURE(SERIALIZED_DATA) VALUES(?)")
//                        .param(1, serialized)
//                        .update();
//            }
//            case FILE -> {
//                try (FileWriter writer = new FileWriter("lecture_data.txt")) {
//                    writer.write(serialized);
//                }
//            }
//        }
//    }
//
//    private static String getXmlContent(Lecture lecture) throws JsonProcessingException {
//        String serialized;
//        XmlMapper mapper = new XmlMapper();
//        mapper.registerModule(new JavaTimeModule());
//        serialized = mapper.writeValueAsString(lecture);
//        return serialized;
//    }
//
//    private static String getCsvContent(Lecture lecture) throws JsonProcessingException {
//        String serialized;
//        CsvMapper mapper = new CsvMapper();
//        mapper.registerModule(new JavaTimeModule());
//        CsvSchema schema = mapper.schemaFor(Lecture.class).withHeader();
//        serialized = mapper.writer(schema).writeValueAsString(lecture);
//        return serialized;
//    }
//
//    private static String getJsonContent(Lecture lecture) throws JsonProcessingException {
//        String serialized;
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.registerModule(new JavaTimeModule());
//        serialized = mapper.writeValueAsString(lecture);
//        return serialized;
//    }
//}
