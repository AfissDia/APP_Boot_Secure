package com.dia.app_boot_secure.model;

import java.time.LocalTime;
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

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VehicleHire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name="vehicleid", insertable=false, updatable=false)
    private Vehicle vehicle;
    private Integer vehicleid;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOut;

    private String timeOut;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateIn;

    private String timeIn;

    @ManyToOne
    @JoinColumn(name="clientid", insertable=false, updatable=false)
    private Client client;
    private Integer clientid;

    @ManyToOne
    @JoinColumn(name="locationid", insertable=false, updatable=false)
    private Location location;
    private Integer locationid;

    private String price;

    private String remarks;
}
