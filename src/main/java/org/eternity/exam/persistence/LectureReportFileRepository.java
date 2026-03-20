package org.eternity.exam.persistence;

import org.eternity.exam.service.LectureReportRepository;
import org.springframework.stereotype.Repository;

import java.io.FileWriter;
import java.io.IOException;

@Repository("FILE")
public class LectureReportFileRepository implements LectureReportRepository {
    @Override
    public void persist(String report) {
        try (FileWriter writer = new FileWriter("lecture_data.txt")) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
