package com.demo.example.ui.page.home;

import com.demo.ui.selenium.elements.WebLabel;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class ObservationItemPage extends HtmlElement {

    @FindBy(xpath = ".//*[@container = 'body'][contains(text(), '.S')]")
    private WebLabel projectCodeLabel;
    @FindBy(xpath = "(//*[@id='observation-panel']//*[contains(text(), 'uid')])[3]")
    private WebLabel membersOid;

    public String getName() {
        return projectCodeLabel.getText();
    }

    public String getMembersOid() {
        return membersOid.getText();
    }
}
