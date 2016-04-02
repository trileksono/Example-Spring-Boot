/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tri.leksono.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author tri
 */
@Entity
@Table(name = "tbl_buku")
public class Buku implements Serializable {
    
    @Id                            
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    @Column(name = "id_buku")
    private String idBuku;
    
    @Column(nullable = false,name = "nama_buku") 
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 200)
    private String namaBuku;
    
    @Column(nullable = false,name = "pengarang") 
    @NotNull
    @NotEmpty
    private String pengarang;
    
    @Column(nullable = false,name = "tahun_terbit")
    @Size(min = 4, max = 4)
    private String tahunTerbit;
    
    @OneToMany(mappedBy = "buku")
    private List<Peminjaman> listPeminjaman = new ArrayList<>();
    
    public String getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(String idBuku) {
        this.idBuku = idBuku;
    }

    public String getNamaBuku() {
        return namaBuku;
    }

    public void setNamaBuku(String namaBuku) {
        this.namaBuku = namaBuku;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public String getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(String tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }
}
