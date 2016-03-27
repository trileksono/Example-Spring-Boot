/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tri.leksono.pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author tri
 */
public class PeminjamanId implements Serializable{
    
    private String buku;
    private String anggota;

    public String getBuku() {
        return buku;
    }

    public void setBuku(String buku) {
        this.buku = buku;
    }

    public String getAnggota() {
        return anggota;
    }

    public void setAnggota(String anggota) {
        this.anggota = anggota;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.buku);
        hash = 61 * hash + Objects.hashCode(this.anggota);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PeminjamanId other = (PeminjamanId) obj;
        if (!Objects.equals(this.buku, other.buku)) {
            return false;
        }
        if (!Objects.equals(this.anggota, other.anggota)) {
            return false;
        }
        return true;
    }
    
}
