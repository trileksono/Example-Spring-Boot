/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tri.leksono.dao;

import com.tri.leksono.entity.Anggota;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author tri
 */
public interface AnggotaDAO extends PagingAndSortingRepository<Anggota, String> {
    public List<Anggota> findByidAnggota(String id);
    
    @Query("select b from Anggota b where b.namaAnggota like %:nama%")
    public List<Anggota> findByNama(@Param("nama") String nama);
}
