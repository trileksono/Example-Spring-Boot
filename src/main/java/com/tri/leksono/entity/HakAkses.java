package com.tri.leksono.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tri on 5/14/16.
 */
@Entity
public class HakAkses {

    @Id
    private Long id;

    @NotNull
    private String kodeAkses;

    @NotNull
    private String namaAkses;

    @OneToMany(mappedBy = "hakAkses", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnore
    private List<AksesAkun> listAksesAkun = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public List<AksesAkun> getListAksesAkun() {
        return listAksesAkun;
    }

    public void setListAksesAkun(List<AksesAkun> listAksesAkun) {
        this.listAksesAkun = listAksesAkun;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKodeAkses() {
        return kodeAkses;
    }

    public void setKodeAkses(String kodeAkses) {
        this.kodeAkses = kodeAkses;
    }

    public String getNamaAkses() {
        return namaAkses;
    }

    public void setNamaAkses(String namaAkses) {
        this.namaAkses = namaAkses;
    }
}
