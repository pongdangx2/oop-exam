package org.eternity.exam.service;

import org.eternity.exam.domain.Lecture;
import org.eternity.exam.domain.LectureReportFormatPolicy;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LectureReportService {
    public enum StorageType { DATABASE, FILE }
    private final Map<String, LectureReportRepository> repositoryMap;

    public LectureReportService(Map<String, LectureReportRepository> repositoryMap) {
        this.repositoryMap = repositoryMap;
    }

    public void report(Lecture lecture, LectureReportFormatPolicy lectureReportFormatPolicy, StorageType storageType) throws Exception {
        String reportContent = lecture.getReportContent(lectureReportFormatPolicy);
        repositoryMap.get(storageType.name()).persist(reportContent);
    }
}
