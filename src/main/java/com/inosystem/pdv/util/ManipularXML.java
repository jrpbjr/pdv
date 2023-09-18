/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.util;

import com.inosystem.pdv.model.Config;
import com.inosystem.pdv.nfe.model.XmlNfe;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author jrpbj
 */
public class ManipularXML {
    
 /**
     * gera o arquivo config.xml
     *
     * @param pConfing
     * @return boolean
     * @throws IOException
     */
    public static void gravaXML(Config pConfig) {
        //Cria uma instância da classe XStream
        XStream xStream = new XStream(new DomDriver());
        //Escolher um nome para o xml
        xStream.alias("config", Config.class);
        //Grava no diretório padrão do projeto, fica na própria pasta do projeto.
        File arquivo = new File("C:\\Vendas\\config\\config.xml");
        FileOutputStream gravar;

        try {
            //grava o arquivo
            gravar = new FileOutputStream(arquivo);
            //insere os bytes no XML
            gravar.write(xStream.toXML(pConfig).getBytes());
            gravar.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static Config lerXmlConfig() {
        FileReader reader = null;
        try {
            //carrega o arquivo XML para um objeto reader
            reader = new FileReader("C:\\Vendas\\config\\config.xml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Cria o objeto xstream
        XStream xStream = new XStream(new DomDriver());
        //informamos as tags que serao lidas
        //como foi feito no metodo gerarXml002
        xStream.alias("config", Config.class);
        //cria um objeto Contato,
        //contendo os dados do xml
        Config model = (Config) xStream.fromXML(reader);
        //retornar arquivo
        return model;
    }

    public static XmlNfe lerXmlNFe(String pCaminho, String pNomeArquivo) {
        FileReader reader = null;
        try {
            //carrega o arquivo XML para um objeto reader
            reader = new FileReader(pCaminho);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Cria o objeto xstream
        XStream xStream = new XStream(new DomDriver());
        //informamos as tags que serao lidas
        //como foi feito no metodo gerarXml002
        xStream.alias(pNomeArquivo, Config.class);
        //cria um objeto Contato,
        //contendo os dados do xml
        XmlNfe model = (XmlNfe) xStream.fromXML(reader);
        //retornar arquivo
        return model;
    }
}
