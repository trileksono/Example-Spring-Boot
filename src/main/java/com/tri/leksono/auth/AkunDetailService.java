package com.tri.leksono.auth;

import com.tri.leksono.dao.AkunDao;
import com.tri.leksono.entity.AksesAkun;
import com.tri.leksono.entity.Akun;
import com.tri.leksono.entity.HakAkses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by tri on 5/14/16.
 */
@Component
public class AkunDetailService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AkunDao akunDAO;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Akun akun = akunDAO.findByNamaAkun(s);

        if(akun == null){
            throw new UsernameNotFoundException("Akun " + s + " tidak ditemukan.");
        }

        List<HakAkses> listRole = new ArrayList<>();
        for(AksesAkun akunAkses: akun.getListAksesAkun()){
            listRole.add(akunAkses.getHakAkses());
        }

        Collection<GrantedAuthority> grandtedUser = new ArrayList<>();
        for(HakAkses hakAkses : listRole){
            grandtedUser.add(new SimpleGrantedAuthority(hakAkses.getKodeAkses()));
        }

        User userDetails = new User(akun.getNamaAkun(),
                akun.getPassword(), akun.isAktif(),
                !akun.isKadaluarsa(), !akun.isHakAksesKadaluarsa(),
                !akun.isTerkunci(), grandtedUser);

        logger.debug("Load akun ====> ", s);

        return userDetails;
    }
}
