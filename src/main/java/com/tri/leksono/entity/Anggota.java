/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tri.leksono.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author tri
 */
@Entity                             //Anotasi menandakan kelas ini entity
@Table(name = "tbl_anggota")        //Nama table yg akan digenerate
public class Anggota implements Serializable {

    private static final Logger LOG = Logger.getLogger(Anggota.class.getName());
    
    @Id                             //Id table
    @GeneratedValue(generator = "uuid") //Di generate uniqe dengan uuid
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    @Column(name = "id_anggota")
    private String idAnggota;
    
    @Column(nullable = false,name = "nama_anggota") 
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String namaAnggota;
    
    @Column(nullable = false,length = 200, name = "alamat_anggota")
    private String alamatAnggota;
    
    @Column(name = "tgl_lahir", nullable = false)
    @Temporal(TemporalType.DATE)
    @Past                           // Validasi yg menandakan tanggal harus PAST( Lampau )
    @NotNull                        // Validasi using jsr 303
    private Date tglLahir;
    
    @Column(nullable = false, length = 10, name = "jenis_kelamin")
    private String jenisKelamin;

    @OneToMany(mappedBy = "anggota", cascade = CascadeType.ALL)  // Kasih tau peminjaman, entity di mapped oleh anggota
    @JsonIgnore
    private List<Peminjaman> listPeminjaman = new ArrayList<>();
    
    public String getIdAnggota() {
        return idAnggota;
    }

    public List<Peminjaman> getListPeminjaman() {
        return listPeminjaman;
    }

    public void setListPeminjaman(List<Peminjaman> listPeminjaman) {
        this.listPeminjaman = listPeminjaman;
    }

    public void setIdAnggota(String idAnggota) {
        this.idAnggota = idAnggota;
    }

    public String getNamaAnggota() {
        return namaAnggota;
    }

    public void setNamaAnggota(String namaAnggota) {
        this.namaAnggota = namaAnggota;
    }

    public String getAlamatAnggota() {
        return alamatAnggota;
    }

    public void setAlamatAnggota(String alamatAnggota) {
        this.alamatAnggota = alamatAnggota;
    }

    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
}
