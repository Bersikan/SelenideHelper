package general_helpers.element


import org.openqa.selenium.By

class ElementBuilder {
    private By section
    private By subSection
    private By element

    ElementBuilder setSection(By section) {
        this.section = section
        return this
    }

    ElementBuilder setSubSection(By subSection) {
        this.subSection = subSection
        return this
    }

    ElementBuilder setElement(By element) {
        this.element = element
        return this
    }

    Element build(){
        Element el = new Element(section, subSection, element)
        return el
    }
}
