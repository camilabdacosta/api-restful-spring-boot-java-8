package com.ibm.apirestful.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaUtils {
    public static String gerarBCrypt(String senha) {
        if(senha == null) {
            return senha;
        }
        BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
        return bCryptEncoder.encode(senha);
    }

    /**
     *
     * @param senha
     * @param senhaEncoded
     * @return boolean
     */
        public static boolean senhaValida(String senha, String senhaEncoded){

    BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
       return bCryptEncoder.matches(senha, senhaEncoded);
        }
    }
