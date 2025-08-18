package com.mecanica.feicina.domain.model;


import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import java.time.LocalDateTime;
import java.util.UUID;


@Table("diagnostic_logs")
public class DiagnosticLog {

    @PrimaryKey
    private UUID id;

    @Column("vehicleid")
    private UUID vehicleId;

    @Column("logtimestamp")
    private LocalDateTime logTimestamp;

    @Column("errorcode")
    private String errorCode;

    @Column("mechanicnotes")
    private String mechanicNotes;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(UUID vehicleId) {
        this.vehicleId = vehicleId;
    }

    public LocalDateTime getLogTimestamp() {
        return logTimestamp;
    }

    public void setLogTimestamp(LocalDateTime logTimestamp) {
        this.logTimestamp = logTimestamp;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }


    public String getMechanicNotes() {
        return mechanicNotes;
    }

    public void setMechanicNotes(String mechanicNotes) {
        this.mechanicNotes = mechanicNotes;
    }
}
