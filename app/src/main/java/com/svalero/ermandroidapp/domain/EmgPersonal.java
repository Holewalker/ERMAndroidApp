package com.svalero.ermandroidapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmgPersonal {

    private long id;

    private EmgService emgServicePersonal;

    private String fullName;

    private String idNumber;

    private String type;

    private String title;

}
