package com.biprom.amcal.amcalpompen.Entities;

import org.springframework.data.annotation.Id;

import java.time.LocalTime;
import java.util.Date;

public class WerkUren {

    @Id
    private String Id;

    private Date datum;
    private LocalTime startTijd;
    private LocalTime eindTijd;
    private LocalTime pauze;

}
