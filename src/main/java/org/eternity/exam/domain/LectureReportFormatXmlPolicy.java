package org.eternity.exam.domain;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class LectureReportFormatXmlPolicy extends LectureReportFormatPolicy {
    @Override
    protected String getReportContent(Lecture lecture) throws Exception {
        String serialized;
        XmlMapper mapper = new XmlMapper();
        mapper.registerModule(new JavaTimeModule());
        serialized = mapper.writeValueAsString(lecture);
        return serialized;
    }
}
