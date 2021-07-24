package appAgenda;

import java.util.Calendar;

public class EContato extends Contato {
    protected String email, homepage;

    public EContato(String nome, Calendar dtnasc, String email, String hp) {
        super(nome, dtnasc);
        this.email = email;
        homepage = hp;
    }

    @Override
    public String getDados() {
        return super.getDados() + "email: " + email + "\n homepage: " + homepage + "\n Idade: ";
    }

    public String getEmail() {
        return email;
    }

    public String getHomepage() {
        return homepage;
    }
}