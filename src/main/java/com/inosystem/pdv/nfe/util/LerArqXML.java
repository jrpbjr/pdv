/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.nfe.util;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author jrpbj
 */
public class LerArqXML {

    private void lerarq() {
        //Aqui você informa o nome do arquivo XML.  
        File f = new File("C://Users//leand//Downloads//33180200776574001390550050153905141238119109.xml");

        //Criamos uma classe SAXBuilder que vai processar o XML  
        SAXBuilder sb = new SAXBuilder();

        //Este documento agora possui toda a estrutura do arquivo.  
        Document d;
        try {
            d = sb.build(f);
            //Recuperamos o elemento root  
            Element nfe = d.getRootElement();

            //Recuperamos os atributos filhos (Attributes)  
            List atributes = nfe.getAttributes();
            Iterator i_atr = atributes.iterator();

            //Iteramos com os atributos filhos  
            while (i_atr.hasNext()) {
                Attribute atrib = (Attribute) i_atr.next();
                System.out.println("\nattribute de (" + nfe.getName() + "):" + atrib.getName() + " - valor: " + atrib.getValue());
            }
            //Recuperamos os elementos filhos (children)  
            List elements = nfe.getChildren();
            Iterator i = elements.iterator();

            //Iteramos com os elementos filhos, e filhos do dos filhos  
            while (i.hasNext()) {
                Element element = (Element) i.next();
                System.out.println("element:" + element.getName());
                trataElement(element);
            }

        } catch (JDOMException ex) {
            Logger.getLogger(LerArqXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LerArqXML.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void trataElement(Element element) {

        //Recuperamos os atributos filhos (Attributes)  
        List atributes = element.getAttributes();
        Iterator i_atr = atributes.iterator();

        //Iteramos com os atributos filhos  
        while (i_atr.hasNext()) {
            Attribute atrib = (Attribute) i_atr.next();
            System.out.println("\nattribute de (" + element.getName() + "):" + atrib.getName() + " - valor: " + atrib.getValue());
        }
        //Recuperamos os elementos filhos (children)  
        List elements = element.getChildren();
        Iterator it = elements.iterator();

        //Iteramos com os elementos filhos, e filhos do dos filhos  
        while (it.hasNext()) {
            Element el = (Element) it.next();
            System.out.println("element(" + element.getName() + "):" + el.getName() + " - Valor: " + el.getText());

            //  aqui voce pode escolher qual(is) campo(s) quer manipular  
            if (el.getName().equals("nNF")) {
                //  grava_no_banco de dados(element.getAttributeValue("nNF"));  
                System.out.println("encontrou nNF . . . com valor: " + el.getText());
            }
            trataElement(el);
        }
    }

    public static void main(String[] args) {
        LerArqXML lexml = new LerArqXML();
        lexml.lerarq();
    }
}
