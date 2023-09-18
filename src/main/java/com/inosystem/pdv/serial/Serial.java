/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.serial;

import com.inosystem.pdv.util.Mascara;
import com.thoughtworks.xstream.XStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author jrpbj
 */
public class Serial {
    
Config config = new Config();
    Mascara mascara = new Mascara();

    /**
     * gera o arquivo config.xml
     *
     * @param pConfing
     * @return boolean
     * @throws IOException
     */
    public boolean gerarArquivo(Config pConfing) throws IOException {
        String textoArquivo = new String();
        XStream xStream = new XStream();
        FileWriter fileWriter = new FileWriter("config/licenca.xml");
        PrintWriter printWriter = new PrintWriter(fileWriter);

        xStream.alias("licenca", Config.class);
        //crio o arquivo xml
        textoArquivo = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
        textoArquivo += xStream.toXML(pConfing);
        printWriter.printf(textoArquivo);
        fileWriter.close();
        return true;
    }

    public boolean imprimirLicenca() {
        XStream xStream = new XStream();
        CriptografiaReversivel criptografia = new CriptografiaReversivel();
        ConfigXML configXML = new ConfigXML();
        xStream.alias("licenca", Config.class);

        try {

//TODA VEZ QUE ABRIR O PROGRAMA
//testando se voltou a data do computador
            config = configXML.getConfig("config/licenca.xml");

//descriptografando os dados
            config.setSoftware(criptografia.descriptografar(config.getSoftware()));
            config.setDataAtualStr(criptografia.descriptografar(config.getDataAtualStr()));
            config.setDataGeracaoStr(criptografia.descriptografar(config.getDataGeracaoStr()));
            config.setDiasValidadeStr(criptografia.descriptografar(config.getDiasValidadeStr()));
            config.setNomePC(criptografia.descriptografar(config.getNomePC()));

        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Erro: Serial incorreto.");
            return false;
        }
        return true;
    }

    public boolean validarArquivoXML() throws Exception {
        XStream xStream = new XStream();
        CriptografiaReversivel criptografia = new CriptografiaReversivel();
        ConfigXML configXML = new ConfigXML();
        xStream.alias("licenca", Config.class);
        try {

//TODA VEZ QUE ABRIR O PROGRAMA
//testando se voltou a data do computador
            DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
            config = configXML.getConfig("config/licenca.xml");

//descriptografando os dados
            config.setSoftware(criptografia.descriptografar(config.getSoftware()));
            config.setDataAtualStr(criptografia.descriptografar(config.getDataAtualStr()));
            config.setDataGeracaoStr(criptografia.descriptografar(config.getDataGeracaoStr()));
            config.setDiasValidadeStr(criptografia.descriptografar(config.getDiasValidadeStr()));
            config.setNomePC(criptografia.descriptografar(config.getNomePC()));

// valida se o mac é o mesmo do arquivo
            if (!config.getNomePC().equals(InetAddress.getLocalHost().getHostName())) {
                System.err.println("alterou o nome do pc");
                return false;
            }
//data do computador anterior a data do arquivo
            if (new Date().before(mascara.converterDataStringParaDate(mascara.addBarras(config.getDataAtualStr())))) {
                System.err.println("alterou a data");
                JOptionPane.showMessageDialog(null, "A data do seu sistema está incorreta!\nAltere para a data correta para usar o sistema.");
                return false;
            }
//teste de validade
            if (new Date().after(retornarDataValidade(config.getDiasValidadeStr(), mascara.addBarras(config.getDataGeracaoStr())))) {
                System.err.println("Licença expirada");
                return false;
            }
//altero a data atual e criptografo todos os dados
            config.setSoftware(criptografia.criptografar(config.getSoftware()));
            config.setDataAtualStr(criptografia.criptografar(formater.format(new Date())));
            config.setDataGeracaoStr(criptografia.criptografar(config.getDataGeracaoStr()));
            config.setDiasValidadeStr(criptografia.criptografar(config.getDiasValidadeStr()));
            config.setNomePC(criptografia.criptografar(config.getNomePC()));

//gravando novo arquivo com nova data
            gerarArquivo(config);

        } catch (Exception ex) {
            System.err.println(ex);
            return false;
        }

        return true;
    }

    public Date retornarDataValidade(String dias, String pDataGeracao) throws Exception {
        Date dataVencimento = new Date();
        dataVencimento = mascara.addDias(Integer.parseInt(dias), new Mascara().converterDataStringParaDate(pDataGeracao));
        return dataVencimento;
    }

}

