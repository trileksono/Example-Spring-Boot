package com.tri.leksono.dao;

import com.tri.leksono.entity.Akun;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by tri on 5/14/16.
 */
public interface AkunDao extends JpaRepository<Akun,String> {

    Akun findByNamaAkun(String nama_akun);
}
