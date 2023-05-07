package com.svalero.ermandroidapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmgService {


    private Long id;


    private String location;



    private String type;


    public EmgService(String location, String type) {
        this.location = location;
        this.type = type;
    }
}
