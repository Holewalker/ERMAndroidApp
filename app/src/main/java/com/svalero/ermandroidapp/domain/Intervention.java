package com.svalero.ermandroidapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Intervention {

    private long id;

    private Incident incidentIntervention;

    private EmgService emgServiceIntervention;

    private int status;

    private LocalDate dispatchDate;

    private LocalDate endDate;


}
