package org.eternity.exam.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class LectureReportFormatJsonPolicy extends LectureReportFormatPolicy {
    @Override
    protected String getReportContent(Lecture lecture) throws Exception {
        String serialized;
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        serialized = mapper.writeValueAsString(lecture);
        return serialized;
    }
}
