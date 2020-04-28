package main.view;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;


public class LanguageChanger {

    private ResourceBundle bundle;
    private List<Locale> locales;
    private int currentLocaleIndex = 0;


    /**
     * Constructs a {@code LanguageChanger} object.
     */
    public LanguageChanger() {

        this.locales = new ArrayList<>();
        this.locales.add(new Locale("en", "GB"));
        this.locales.add(new Locale("de", "DE"));
        this.locales.add(new Locale("fr", "FR"));
        this.updateBundle();
    }


    /**
     * Applies current locale to resource bundle.
     */
    private void updateBundle() {

        this.bundle = ResourceBundle.getBundle("languages", this.locales.get(this.currentLocaleIndex));
    }


    /**
     * Increments current locale pointer.
     */
    void changeLanguage() {

        this.currentLocaleIndex++;
        if(this.currentLocaleIndex > this.locales.size() - 1) this.currentLocaleIndex = 0;
        this.updateBundle();
    }


    /**
     * Resource bundle getter.
     * @return bundle
     */
    public ResourceBundle getBundle() {

        return this.bundle;
    }
}