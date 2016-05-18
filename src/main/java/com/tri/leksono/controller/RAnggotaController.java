/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tri.leksono.controller;

import com.tri.leksono.dao.AnggotaDAO;
import com.tri.leksono.entity.Anggota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 *
 * @author tri
 */
@RestController
@RequestMapping("/api")
public class RAnggotaController {

    @Autowired
    AnggotaDAO dao;

    @RequestMapping(value = "/anggota", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void simpanBuku(@RequestBody @Valid Anggota anggota) {
        dao.save(anggota);
    }

    @RequestMapping(value = "/anggota", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Anggota> cariAnggota(Pageable page) {
        return dao.findAll(page);
    }

    @RequestMapping(value = "/anggota/nama/{nama}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Anggota>> cariByName(@PathVariable("nama") String nama) {
        List<Anggota> lAnggota = dao.findByNama(nama);
        if (lAnggota.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(lAnggota, HttpStatus.OK);
    }

    @RequestMapping(value = "/anggota/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity findById(@PathVariable("id") String id) {
        Anggota anggota = dao.findOne(id);
        if (anggota == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(anggota, HttpStatus.OK);
    }

    //Custom response
    @RequestMapping(value = "/anggota/id/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    ResponseEntity<Anggota> findByIdCus(@PathVariable("id") String id) {
        Anggota anggota = dao.findOne(id);
        if (anggota == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(anggota, HttpStatus.OK);
        }

    }
    //
    
    @RequestMapping(value = "/anggota/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteAnggota(@PathVariable("id") String id) {
        dao.delete(id);
    }
}
