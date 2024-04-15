package general_helpers.element

import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.By
import static com.codeborne.selenide.Selenide.$;

class Element {
    private By section
    private By subSection
    private By element

    Element(By section, By subSection, By element) {
        this.section = section
        this.subSection = subSection
        this.element = element
    }


    SelenideElement init() {
        if (section && !subSection && !element) {
            return $(section)
        }
        if (section && subSection && !element) {
            return $(section).$(subSection)
        }
        if (section && subSection && element) {
            return $(section).$(subSection).$(element)
        }
        if (section && !subSection && element) {
            return $(section).$(element)
        }

    }
}
