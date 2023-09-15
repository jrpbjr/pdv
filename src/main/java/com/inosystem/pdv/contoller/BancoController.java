/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.contoller;

import com.inosystem.pdv.dao.BancoDao;
import com.inosystem.pdv.model.Banco;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class BancoController {

    /**
     *
     * @author Jrpbjr
     */
    public class ControllerBanco {

        private BancoDao bancoDao = new BancoDao();

        public boolean criarBancoCtrl() {
            return this.bancoDao.criarBancoDAO();
        }

        /**
         * grava Banco
         *
         * @param pBanco
         * @return int
         */
        public int salvarBancoController(Banco pBanco) {
            return this.bancoDao.salvarBancoDAO(pBanco);
        }

        /**
         * recupera Banco
         *
         * @param pCodigo
         * @return Banco
         */
        public Banco getBancoController(int pCodigo) {
            return this.bancoDao.getBancoDAO(pCodigo);
        }

        /**
         * recupera Banco
         *
         * @param pNome
         * @return Banco
         */
        public Banco getBancoController(String pNome) {
            return this.bancoDao.getBancoDAO(pNome);
        }

        /**
         * recupera uma lista deBanco
         *
         * @return ArrayList
         */
        public ArrayList<Banco> getListaBancoController() {
            return this.bancoDao.getListaBancoDAO();
        }

        /**
         * atualiza Banco
         *
         * @param pBanco
         * @return boolean
         */
        public boolean atualizarBancoController(Banco pBanco) {
            return this.bancoDao.atualizarBancoDAO(pBanco);
        }

        /**
         * exclui Banco
         *
         * @param pCodigo
         * @return boolean
         */
        public boolean excluirBancoController(int pCodigo) {
            return this.bancoDao.excluirBancoDAO(pCodigo);
        }

    }
}
