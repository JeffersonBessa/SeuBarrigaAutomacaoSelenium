package page;

import core.BasePage;
import core.DriverFactory;
import core.Properties;

public class LoginPage extends BasePage {

    public void accessInitialScreen(){
        DriverFactory.getDriver().get(Properties.URL);
    }

    public void setEmail(String email){
        write("email", email);
    }

    public void setSenha(String senha){
        write("senha", senha);
    }

    public void signIn(){
        clickButtonByText("Entrar");
    }

    public void resetTestMass(){
        clickLink("reset");
    }
}
