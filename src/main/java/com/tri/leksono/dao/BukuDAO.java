/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tri.leksono.dao;

import com.tri.leksono.entity.Buku;
import java.awt.print.Book;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author tri
 */
public interface BukuDAO extends PagingAndSortingRepository<Buku, String> {
    List<Book> findByNamaBuku(String namaBuku);
    List<Book> findByPengarang(String pengarang);
}
