package com.dia.app_boot_secure.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class VehicleMouvement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name="vehicleid", insertable=false, updatable=false)
    private Vehicle vehicle;
    private int vehicleid;

    @ManyToOne
    @JoinColumn(name="locationid1", insertable=false, updatable=false)
    private Location location1;
    private int locationid1;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date1;

    @ManyToOne
    @JoinColumn(name="locationid2", insertable=false, updatable=false)
    private Location location2;
    private int locationid2;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date2;

    private String remarks;
}
