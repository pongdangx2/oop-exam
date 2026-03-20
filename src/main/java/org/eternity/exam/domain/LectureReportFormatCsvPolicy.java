package org.eternity.exam.domain;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class LectureReportFormatCsvPolicy extends LectureReportFormatPolicy {
    @Override
    protected String getReportContent(Lecture lecture) throws Exception {
        String serialized;
        CsvMapper mapper = new CsvMapper();
        mapper.registerModule(new JavaTimeModule());
        CsvSchema schema = mapper.schemaFor(Lecture.class).withHeader();
        serialized = mapper.writer(schema).writeValueAsString(lecture);
        return serialized;
    }
}
