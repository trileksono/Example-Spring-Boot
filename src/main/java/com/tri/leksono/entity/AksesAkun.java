package com.tri.leksono.entity;

import com.tri.leksono.pojo.AksesAkunId;

import javax.persistence.*;

/**
 * Created by tri on 5/14/16.
 */
@Entity
@Table(name = "tbl_akses_akun")
@IdClass(AksesAkunId.class)
public class AksesAkun {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_akun")
    private Akun akun;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_akses")
    private HakAkses hakAkses;

    public Akun getAkun() {
        return akun;
    }

    public void setAkun(Akun akun) {
        this.akun = akun;
    }

    public HakAkses getHakAkses() {
        return hakAkses;
    }

    public void setHakAkses(HakAkses hakAkses) {
        this.hakAkses = hakAkses;
    }
}
