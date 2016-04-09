/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tri.leksono.entity;

import com.tri.leksono.pojo.PeminjamanId;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tri 
 */
@Entity
@Table(name = "tbl_peminjaman") 
@IdClass(PeminjamanId.class)  // Referensi class yg berisikan ID (PK) pada table ini
public class Peminjaman implements Serializable{
    
    @Id
    @ManyToOne
    @JoinColumn(name = "id_buku")
    private Buku buku;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "id_anggota")
    private Anggota anggota;
    
    @Column(name = "tgl_pinjam")
    @Temporal(TemporalType.DATE)
    private Date tglPinjam;
    
    @Column(name = "tgl_kembali")
    @Temporal(TemporalType.DATE)
    private Date tglKembali;

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public Anggota getAnggota() {
        return anggota;
    }

    public void setAnggota(Anggota anggota) {
        this.anggota = anggota;
    }

    public Date getTglPinjam() {
        return tglPinjam;
    }

    public void setTglPinjam(Date tglPinjam) {
        this.tglPinjam = tglPinjam;
    }

    public Date getTglKembali() {
        return tglKembali;
    }

    public void setTglKembali(Date tglKembali) {
        this.tglKembali = tglKembali;
    }
}
