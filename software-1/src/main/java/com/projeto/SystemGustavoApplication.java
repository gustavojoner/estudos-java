package com.projeto;

import javax.swing.UIManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatGrayIJTheme;
import com.projeto.ui.LoginFrame;

@SpringBootApplication
public class SystemGustavoApplication {

	public static void main(String[] args) throws Exception {
		
//		LookAndFeel Biblioteca FlatLaf
		FlatLightLaf.setup();
		UIManager.setLookAndFeel(new FlatGrayIJTheme());
		
		new LoginFrame();
		SpringApplication.run(SystemGustavoApplication.class, args);
		
	}

}
