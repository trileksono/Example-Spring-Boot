package com.tri.leksono.pojo;

import java.io.Serializable;

/**
 * Created by tri on 5/14/16.
 */
public class AksesAkunId implements Serializable {
    String akun;
    Long hakAkses;

    public String getAkun() {
        return akun;
    }

    public void setAkun(String akun) {
        this.akun = akun;
    }

    public Long getHakAkses() {
        return hakAkses;
    }

    public void setHakAkses(Long hakAkses) {
        this.hakAkses = hakAkses;
    }
}
