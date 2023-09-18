/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.serial;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author jrpbj
 */
public class ConfigXML {
    
public Config getConfig(String pCaminhoXML) {
        Config config = new Config();
        try {
            XStream xStream = new XStream(new Dom4JDriver());
            xStream.alias("licenca", Config.class);
            xStream.alias("software", String.class);
            xStream.alias("ip", String.class);
            xStream.alias("dataGeracaoStr", String.class);
            xStream.alias("dataAtualStr", String.class);
            xStream.alias("diasValidadeStr", String.class);
            xStream.alias("nomePC", String.class);
            xStream.processAnnotations(Config.class);

            BufferedReader input = new BufferedReader(new FileReader(pCaminhoXML));
            config = (Config) xStream.fromXML(input);
            input.close();
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro: Arquivo de configurações não encontrado.");
            System.exit(0);
        }
        return config;
    }
    
}

