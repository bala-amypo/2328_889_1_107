package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Evidence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;
    private String fileType;
    private byte[] data;

    @ManyToOne
    @JoinColumn(name = "damage_claim_id")
    private DamageClaim damageClaim;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    public String getFileType() { return fileType; }
    public void setFileType(String fileType) { this.fileType = fileType; }

    public byte[] getData() { return data; }
    public void setData(byte[] data) { this.data = data; }

    public DamageClaim getDamageClaim() { return damageClaim; }
    public void setDamageClaim(DamageClaim damageClaim) { this.damageClaim = damageClaim; }
}
