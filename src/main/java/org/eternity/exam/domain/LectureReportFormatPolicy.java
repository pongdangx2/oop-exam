package org.eternity.exam.domain;

abstract public class LectureReportFormatPolicy {
    abstract protected String getReportContent(Lecture lecture) throws Exception;
}
