package com.projeto.ui.util;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Icones {

	ImageIcon shopTheme = new ImageIcon("src/main/resources/images/outline_shopping_cart_black_18dp.png");
	Image shopImage = shopTheme.getImage();
	Image shopThemeNew = shopImage.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH);
	ImageIcon shopIcon = new ImageIcon(shopThemeNew);
	
	ImageIcon darkTheme = new ImageIcon("src/main/resources/images/round_dark_mode_black_18dp.png");
	Image darkImage = darkTheme.getImage();
	Image darkThemeNew = darkImage.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH);
	ImageIcon darkIcon = new ImageIcon(darkThemeNew);
	
	ImageIcon lightTheme = new ImageIcon("src/main/resources/images/round_light_mode_black_18dp.png");
	Image lightImage = lightTheme.getImage();
	Image lightThemeNew = lightImage.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH);
	ImageIcon lightIcon = new ImageIcon(lightThemeNew);
	
	ImageIcon logoutTheme = new ImageIcon("src/main/resources/images/outline_logout_black_18dp.png");
	Image logoutImage = logoutTheme.getImage();
	Image logoutThemeNew = logoutImage.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH);
	ImageIcon logoutIcon = new ImageIcon(logoutThemeNew);
	
	ImageIcon powerTheme = new ImageIcon("src/main/resources/images/outline_power_settings_new_black_18dp.png");
	Image powerImage = powerTheme.getImage();
	Image powerThemeNew = powerImage.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH);
	ImageIcon powerIcon = new ImageIcon(powerThemeNew);

	ImageIcon exitTheme = new ImageIcon("src/main/resources/images/outline_cancel_black_18dp.png");
	Image exitImage = exitTheme.getImage();
	Image exitThemeNew = exitImage.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH);
	ImageIcon exitIcon = new ImageIcon(exitThemeNew);
	
	public ImageIcon getShopIcon() {
		return shopIcon;
	}
	
	public ImageIcon getDarkIcon() {
		return darkIcon;
	}
	
	public ImageIcon getLightIcon() {
		return lightIcon;
	}
	
	public ImageIcon getLogoutIcon() {
		return logoutIcon;
	}
	
	public ImageIcon getPowerIcon() {
		return powerIcon;
	}

	public ImageIcon getExitIcon() {
		return exitIcon;
	}
}