package com.projeto;

import java.awt.Color;

import javax.swing.UIManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projeto.ui.LoginFrame;

@SpringBootApplication
public class SystemGustavoApplication {

	public static void main(String[] args) throws Exception {
		String str = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
		UIManager.setLookAndFeel(str);
		
//		NIMBUS DEFAULTS
//		https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/_nimbusDefaults.html#primary
//		UIManager.put("nimbusBase", new Color(200,200,200));
//		UIManager.put("nimbusBlueGrey", new Color(200,200,200));
//		UIManager.put("control", new Color(235,235,235));
		
		new LoginFrame();
		SpringApplication.run(SystemGustavoApplication.class, args);
		
		
	}

}
