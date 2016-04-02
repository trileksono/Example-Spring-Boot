/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tri.leksono.controller;

import com.tri.leksono.dao.AnggotaDAO;
import com.tri.leksono.entity.Anggota;
import com.tri.leksono.util.ResponseUtil;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
    public Page<Anggota> cariBuku(Pageable page) {
        return dao.findAll(page);
    }

    @RequestMapping(value = "/anggota/nama/{nama}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity cariByName(@PathVariable("nama") String nama) {
        List lAnggota = dao.findByNama(nama);
        if (lAnggota == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(nama, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/anggota/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity findById(@PathVariable("id") String id) {
        List anggota = dao.findByidAnggota(id);
        if (anggota == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(anggota, HttpStatus.OK);
        }
    }

    //Custom response
    @RequestMapping(value = "/anggota/id/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody ResponseUtil findByIdCus(@PathVariable("id") String id) {
        ResponseUtil resp = new ResponseUtil();
        List anggota = dao.findByidAnggota(id);
        if (anggota == null) {
            resp.setErrorCode("10");
            resp.setErrorMessage("Data tidak ditemukan");
            return resp;
        } else {
            resp.setErrorCode("00");
            resp.setErrorMessage("success");
            resp.setObject(anggota);
            return resp;
        }
    }
    //
    
    @RequestMapping(value = "/anggota/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteBuku(@PathVariable("id") String id) {
        dao.delete(id);
    }
}
