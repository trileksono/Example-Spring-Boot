package com.tri.leksono.controller;

import com.tri.leksono.dao.AnggotaDAO;
import com.tri.leksono.dao.BukuDAO;
import com.tri.leksono.dao.PeminjamanDao;
import com.tri.leksono.entity.Anggota;
import com.tri.leksono.entity.Buku;
import com.tri.leksono.entity.Peminjaman;
import com.tri.leksono.util.ResponseUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private @ResponseBody ResponseUtil simpanPinjam(@RequestBody Peminjaman peminjaman) throws ParseException{
        ResponseUtil res = new ResponseUtil();
        
        Anggota ag = anggotaDao.findOne(peminjaman.getAnggota().getIdAnggota());
        Buku buku = bukuDao.findOne(peminjaman.getBuku().getIdBuku());
        if(ag == null || buku == null){
            res.setErrorCode("90");
            res.setErrorMessage("Data tidak ditemukan");
            return res;
        }
        Peminjaman pm = new Peminjaman();
        pm.setAnggota(ag);
        pm.setBuku(buku);
        pm.setTglKembali(peminjaman.getTglKembali());
        pm.setTglPinjam(peminjaman.getTglPinjam());
        
        dao.save(pm);
        res.setErrorCode("00");
        res.setErrorMessage("Success");
        return res;
    }
    
    @RequestMapping(value ="/pinjam/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    private @ResponseBody ResponseUtil cariPinjamBuku(){
        ResponseUtil res = new ResponseUtil();
        List<Peminjaman> p = dao.findAll();
        if(p != null){
            res.setErrorCode("00");
            res.setObject(p);
        }else{
            res.setErrorCode("90");
            res.setErrorMessage("Data tidak ditemukan");
        }
        return res;
    }
    
    @RequestMapping(value = "/pinjam/tgl/{tglPinjam}/{tglKembali}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    private @ResponseBody ResponseUtil cariPinjam(
            @PathVariable ("tglPinjam") String tglPinjam,
            @PathVariable ("tglKembali") String tglKembali){
            ResponseUtil res = new ResponseUtil();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            List<Peminjaman> p = dao.findTglPinjam(sdf.parse(tglPinjam),sdf.parse(tglKembali));
            if(p.isEmpty()){
                res.setErrorCode("90");
                res.setErrorMessage("Data tidak ditemukan");
            }else{
                res.setErrorCode("00");
                res.setErrorMessage("Success");
                res.setObject(p);
            }
            return res;
        } catch (ParseException ex) {
            res.setErrorCode("50");
            res.setErrorMessage("Error format penulisan tanggal");
            return res;
        }
    }
}
