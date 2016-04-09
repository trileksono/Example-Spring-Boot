/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tri.leksono.dao;

import com.tri.leksono.entity.Peminjaman;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author tri
 */
public interface PeminjamanDao extends JpaRepository<Peminjaman, String>{
    
    @Query("select p from Peminjaman p where p.tglPinjam between :tglPinjam and :tglKembali")
    public List<Peminjaman> findTglPinjam(@Param("tglPinjam") Date tglPinjam, 
            @Param("tglKembali") Date tglKembali);
}
