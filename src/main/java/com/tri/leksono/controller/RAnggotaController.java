/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tri.leksono.controller;

import com.tri.leksono.dao.AnggotaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
    
    
}
