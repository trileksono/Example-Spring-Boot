/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tri.leksono.controller;

import com.tri.leksono.dao.BukuDAO;
import com.tri.leksono.entity.Buku;
import org.springframework.data.domain.Pageable;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tri
 */
@RestController
@RequestMapping("/api")
public class RBukuController {
    
    @Autowired
    private BukuDAO dao;
    
    @RequestMapping(value = "/buku", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void simpanBuku(@RequestBody @Valid Buku buku){
        dao.save(buku);
    }
    
    @RequestMapping(value = "/buku", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Buku> cariBuku(Pageable page){
        return dao.findAll(page);
    }
    
    @RequestMapping(value = "/buku/author/{pengarang}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity cariByPengarang(@PathVariable("pengarang") String pengarang){
        List buku = dao.findByPengarang(pengarang);
        if(buku == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity(buku,HttpStatus.OK);
        }
    }
    
    @RequestMapping(value = "/buku/title/{judul}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity cariByJudul(@PathVariable("judul") String judul){
        List buku = dao.findByNamaBuku(judul);
        if(buku == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity(buku,HttpStatus.OK);
        }
    }
    
    @RequestMapping(value = "/buku/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteBuku(@PathVariable("id") String id){
        dao.delete(id);
    }
}
