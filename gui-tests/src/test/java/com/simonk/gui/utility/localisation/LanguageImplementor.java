package com.simonk.gui.utility.localisation;

import com.simonk.gui.utility.enums.Language;
import com.simonk.gui.utility.exceptions.InvalidLanguageSpecifiedException;

public interface LanguageImplementor {
	String getResource(String value);
	Language getLanguage(String value) throws InvalidLanguageSpecifiedException;
}
