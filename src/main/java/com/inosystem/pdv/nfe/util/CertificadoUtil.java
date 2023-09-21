/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.nfe.util;

import br.com.swconsultoria.nfe.exception.NfeException;
import br.com.swconsultoria.certificado.Certificado;
import br.com.swconsultoria.nfe.dom.ConfiguracoesNfe;

/**
 *
 * @author jrpbj
 */


/**
 * Classe Responsavel Por Carregar as informações do Certificado Digital
 * 
 * @author Samuel Oliveira
 * 
 */
public class CertificadoUtil {
    
public static ConfiguracoesNfe iniciaConfiguracoes() throws NfeException {

		try {
			Certificado certificado = ConfiguracoesIniciaisNfe.getInstance().getCertificado();
			if(!certificado.isValido()){
			    throw new CertificadoException("Certificado vencido.");
            }
			CertificadoService.inicializaCertificado(certificado, CertificadoUtil.class.getResourceAsStream("/Cacert"));
		} catch (CertificadoException e) {
			throw new NfeException(e.getMessage());
		}

		return ConfiguracoesNfe.getInstance();
	}

}
