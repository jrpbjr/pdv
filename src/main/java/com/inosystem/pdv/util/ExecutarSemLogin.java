/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.util;

import com.inosystem.pdv.contoller.BancoController;
import com.inosystem.pdv.contoller.UsuarioController;
import com.inosystem.pdv.model.Config;
import com.inosystem.pdv.model.SessaoUsuario;
import com.inosystem.pdv.model.Usuario;
import com.inosystem.pdv.serial.ConfigXML;
import com.inosystem.pdv.serial.CriptografiaReversivel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jrpbj
 */
public class ExecutarSemLogin {

    Config modelConfig = new Config();
    ManipularXML manipularXML = new ManipularXML();
    ConfigXML configXML = new ConfigXML();
    CriptografiaReversivel criptografiaReversivel = new CriptografiaReversivel();

    private void carregarDadosDoBanco() {
        modelConfig = new Config();
        modelConfig = manipularXML.lerXmlConfig();
        SessaoUsuario.ipServidor = modelConfig.getIp();
        SessaoUsuario.nomeDoBanco = modelConfig.getNomeBanco();
        SessaoUsuario.usuarioBanco = modelConfig.getUsuario();
        SessaoUsuario.senhaBanco = modelConfig.getSenha();
        SessaoUsuario.caminhoMySQL = modelConfig.getCaminhoMySQL();
        SessaoUsuario.quantidadeMesas = modelConfig.getQuantidadeMesas();
    }

    public void autenticar() {
        carregarDadosDoBanco();
        Usuario modelUsuario = new Usuario();
        UsuarioController controllerUsuario = new UsuarioController();
        modelUsuario.setLogin("admin");
        modelUsuario.setSenha("123");

        try {
            if (controllerUsuario.getUsuarioController(modelUsuario)) {
                modelUsuario = controllerUsuario.getUsuarioController(modelUsuario.getLogin());
                SessaoUsuario.nome = modelUsuario.getNome();
                SessaoUsuario.codigo = modelUsuario.getCodigo();
                SessaoUsuario.login = modelUsuario.getLogin();
            } else {
                JOptionPane.showMessageDialog(null, "Usuário/Senha inválida.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            try {
                BancoController controllerBanco = new BancoController();
               
                if (controllerBanco.criarBancoCtrl()) {
                    new ViewBackup().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível criar o banco.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception ex) {
                Logger.getLogger(ViewLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
