package org.eternity.exam.persistence;

import org.eternity.exam.service.LectureReportRepository;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository("DATABASE")
public class LectureReportDbRepository implements LectureReportRepository {

    private final JdbcClient jdbcClient;
    public LectureReportDbRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }
    @Override
    public void persist(String report) {
        jdbcClient.sql("INSERT INTO LECTURE(SERIALIZED_DATA) VALUES(?)")
                .param(1, report)
                .update();
    }
}
