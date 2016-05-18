package com.tri.leksono.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by tri on 5/14/16.
 */
@Entity
public class Akun {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_akun")
    String idAkun;

    @NotNull
    private String namaAkun;

    @NotNull
    private String password;

    @NotNull
    private boolean aktif = true;

    @NotNull
    private boolean kadaluarsa = false;

    @NotNull
    private boolean terkunci = false;

    @NotNull
    private boolean hakAksesKadaluarsa = false;

    /*@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "AkunAkses",
            joinColumns = @JoinColumn(name = "id_akun", referencedColumnName = "idAkun"),
            inverseJoinColumns = @JoinColumn(name = "id_akses", referencedColumnName = "id"))
    private Set<HakAkses> hakAksesSet;*/

    @OneToMany(mappedBy = "akun", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<AksesAkun> listAksesAkun = new ArrayList<>();

    public List<AksesAkun> getListAksesAkun() {
        return listAksesAkun;
    }

    public void setListAksesAkun(List<AksesAkun> listAksesAkun) {
        this.listAksesAkun = listAksesAkun;
    }


    public String getIdAkun() {
        return idAkun;
    }

    public void setIdAkun(String idAkun) {
        this.idAkun = idAkun;
    }

    public String getNamaAkun() {
        return namaAkun;
    }

    public void setNamaAkun(String namaAkun) {
        this.namaAkun = namaAkun;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAktif() {
        return aktif;
    }

    public void setAktif(boolean aktif) {
        this.aktif = aktif;
    }

    public boolean isKadaluarsa() {
        return kadaluarsa;
    }

    public void setKadaluarsa(boolean kadaluarsa) {
        this.kadaluarsa = kadaluarsa;
    }

    public boolean isTerkunci() {
        return terkunci;
    }

    public void setTerkunci(boolean terkunci) {
        this.terkunci = terkunci;
    }

    public boolean isHakAksesKadaluarsa() {
        return hakAksesKadaluarsa;
    }

    public void setHakAksesKadaluarsa(boolean hakAksesKadaluarsa) {
        this.hakAksesKadaluarsa = hakAksesKadaluarsa;
    }
}
