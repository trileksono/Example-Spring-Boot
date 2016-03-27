/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tri.leksono.dao;

import com.tri.leksono.entity.Anggota;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author tri
 */
public interface AnggotaDAO extends PagingAndSortingRepository<Anggota, String> {
    
}
