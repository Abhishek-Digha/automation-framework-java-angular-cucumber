package com.simonkay.javaframework.utility.localisation;

import com.simonkay.javaframework.utility.enums.Language;
import com.simonkay.javaframework.utility.exceptions.InvalidLanguageSpecifiedException;

public interface LanguageImplementor {
	String getResource(String value);
	Language getLanguage(String value) throws InvalidLanguageSpecifiedException;
}
