package main.view;
import main.view.LanguageChanger;

import java.util.ResourceBundle;


public class ViewChanger {

    private static LanguageChanger languageChanger = new LanguageChanger();


    /**
     * bundle getter.
     * @return bundle
     */
    public static ResourceBundle getLanguage() {

        return languageChanger.getBundle();
    }


    /**
     * Changes to next language in languageList.
     */
    public static void changeLanguage() {
        languageChanger.changeLanguage();

    }

}