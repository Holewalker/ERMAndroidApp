package com.svalero.ermandroidapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Incident {

    private long id;

    private String location;

    private double lat;

    private double lon;

    private int status;

    private String description;

    private LocalDate startTime;
}
