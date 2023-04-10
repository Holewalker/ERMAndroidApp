package com.svalero.ermandroidapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Report {

    private long id;

    private Intervention interventionReport;

    private LocalDate endDate;

    private String title;

    private String text;

    private String reporterComment;


}
