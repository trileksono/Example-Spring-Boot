package com.tri.leksono.controller;

import com.tri.leksono.dao.AnggotaDAO;
import com.tri.leksono.dao.BukuDAO;
import com.tri.leksono.dao.PeminjamanDao;
import com.tri.leksono.entity.Anggota;
import com.tri.leksono.entity.Buku;
import com.tri.leksono.entity.Peminjaman;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tri
 */
@RestController
@RequestMapping("/api")
public class RPeminjamanController {
    
    @Autowired
    PeminjamanDao dao;
    
    @Autowired
    BukuDAO bukuDao;
    
    @Autowired
    AnggotaDAO anggotaDao;
    
    @RequestMapping(value = "/pinjam", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    private @ResponseBody
    ResponseEntity simpanPinjam(@RequestBody Peminjaman peminjaman) throws ParseException{

        Anggota ag = anggotaDao.findOne(peminjaman.getAnggota().getIdAnggota());
        Buku buku = bukuDao.findOne(peminjaman.getBuku().getIdBuku());
        if(ag == null || buku == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        Peminjaman pm = new Peminjaman();
        pm.setAnggota(ag);
        pm.setBuku(buku);
        pm.setTglKembali(peminjaman.getTglKembali());
        pm.setTglPinjam(peminjaman.getTglPinjam());
        
        dao.save(pm);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    
    @RequestMapping(value ="/pinjam/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    private @ResponseBody ResponseEntity cariPinjamBuku(){
        List<Peminjaman> p = dao.findAll();
        if(p.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/pinjam/{tglPinjam}&{tglKembali}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    private @ResponseBody ResponseEntity cariPinjam(
            @PathVariable ("tglPinjam") String tglPinjam,
            @PathVariable ("tglKembali") String tglKembali){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            List<Peminjaman> p = dao.findTglPinjam(sdf.parse(tglPinjam),sdf.parse(tglKembali));
            if(p.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(p,HttpStatus.OK);
        } catch (ParseException ex) {
            return new ResponseEntity<>("Date formate exception (yyyy-MM-dd)",HttpStatus.BAD_REQUEST);
        }
    }
}
