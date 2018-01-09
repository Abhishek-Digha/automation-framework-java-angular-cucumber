package com.simonk.gui.utility.localisation;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.simonk.gui.utility.enums.Language;
import com.simonk.gui.utility.exceptions.InvalidLanguageSpecifiedException;

public class LocaleHelper implements LanguageImplementor {
	private static final Logger LOG = LogManager.getLogger(LocaleHelper.class);
	
	private Language language;
	private ResourceBundle resource;
	
	public LocaleHelper(String lang) {
		try {
		language = getLanguage(lang);
		} catch (InvalidLanguageSpecifiedException ilse) {
			LOG.fatal("Invalid Language in settings, defaulting language would be naive, exiting" + ilse);
		}
	}
	
	@Override
	public String getResource(String value) {
		return resource.getString(value);		
	}

	@Override
	public Language getLanguage(String language) throws InvalidLanguageSpecifiedException {
			
		switch(language.toLowerCase()) {
		case "english":
			LOG.debug("Test language set to: English");
			resource = ResourceBundle.getBundle("localisation_resources.english", new Locale("en"));
			return Language.ENGLISH;
		case "italian":
			LOG.debug("Test language set to: Italian");
			resource = ResourceBundle.getBundle("localisation_resources.italian", new Locale("it"));
			return Language.ITALIAN;
		case "spanish":
			LOG.debug("Test language set to: Spanish");
			resource = ResourceBundle.getBundle("localisation_resources.spanish", new Locale("es"));
			return Language.SPANISH;
		case "french":
			LOG.debug("Test language set to: French");
			resource = ResourceBundle.getBundle("localisation_resources.french", new Locale("fr"));
			return Language.FRENCH;
		default: throw new InvalidLanguageSpecifiedException("Unsupported or incorrect language selected, "
				+ "system will exit, check framework configuration properties");	
		}				
	}
	
	
}
