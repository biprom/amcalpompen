package com.biprom.amcal.amcalpompen.Views;

import com.biprom.amcal.amcalpompen.Design.KlantenGegevensContactpersonenDesign;
import com.biprom.amcal.amcalpompen.Entities.Personen;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.biprom.amcal.amcalpompen.Views.KlantenGegevensContactpersonenView.VIEW_NAME;

@Component
@SpringView(name = VIEW_NAME)
@UIScope
public class KlantenGegevensContactpersonenView extends KlantenGegevensContactpersonenDesign implements View {

    public static final String VIEW_NAME = "KlantenGegevensContactPersonen";

    Personen persoon1 = new Personen();
    Personen persoon2 = new Personen();
    Personen persoon3 = new Personen();
    Personen persoon4 = new Personen();
    Personen persoon5 = new Personen();
    Personen persoon6 = new Personen();
    Personen persoon7 = new Personen();
    Personen persoon8 = new Personen();

    List<Personen> personenLijst = new ArrayList<>();

    public KlantenGegevensContactpersonenView() {
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

    public List<Personen> returnCustomerContacts(){

        personenLijst.clear();

        persoon1.setEmailAdres(tfContactEmail1.getValue());
        persoon1.setGsmNummer(tfContactGSM1.getValue());
        persoon1.setNaam(tfContactNaam1.getValue());
        persoon1.setTelefoonNummer(tfContactTel1.getValue());
        persoon1.setVoorNaam(tfContactVoornaam1.getValue());

        personenLijst.add(persoon1);

         persoon2.setEmailAdres(tfContactEmail2.getValue());
         persoon2.setGsmNummer(tfContactGSM2.getValue());
         persoon2.setNaam(tfContactNaam2.getValue());
         persoon2.setTelefoonNummer(tfContactTel2.getValue());
         persoon2.setVoorNaam(tfContactVoornaam2.getValue());

         personenLijst.add(persoon2);

         persoon3.setEmailAdres(tfContactEmail3.getValue());
         persoon3.setGsmNummer(tfContactGSM3.getValue());
         persoon3.setNaam(tfContactNaam3.getValue());
         persoon3.setTelefoonNummer(tfContactTel3.getValue());
         persoon3.setVoorNaam(tfContactVoornaam3.getValue());

         personenLijst.add(persoon3);

         persoon4.setEmailAdres(tfContactEmail4.getValue());
         persoon4.setGsmNummer(tfContactGSM4.getValue());
         persoon4.setNaam(tfContactNaam4.getValue());
         persoon4.setTelefoonNummer(tfContactTel4.getValue());
         persoon4.setVoorNaam(tfContactVoornaam4.getValue());

         personenLijst.add(persoon4);

         persoon5.setEmailAdres(tfContactEmail5.getValue());
         persoon5.setGsmNummer(tfContactGSM5.getValue());
         persoon5.setNaam(tfContactNaam5.getValue());
         persoon5.setTelefoonNummer(tfContactTel5.getValue());
         persoon5.setVoorNaam(tfContactVoornaam5.getValue());

         personenLijst.add(persoon5);

         persoon6.setEmailAdres(tfContactEmail6.getValue());
         persoon6.setGsmNummer(tfContactGSM6.getValue());
         persoon6.setNaam(tfContactNaam6.getValue());
         persoon6.setTelefoonNummer(tfContactTel6.getValue());
         persoon6.setVoorNaam(tfContactVoornaam6.getValue());

         personenLijst.add(persoon6);

         persoon7.setEmailAdres(tfContactEmail7.getValue());
         persoon7.setGsmNummer(tfContactGSM7.getValue());
         persoon7.setNaam(tfContactNaam7.getValue());
         persoon7.setTelefoonNummer(tfContactTel7.getValue());
         persoon7.setVoorNaam(tfContactVoornaam7.getValue());

         personenLijst.add(persoon7);

         persoon8.setEmailAdres(tfContactEmail8.getValue());
         persoon8.setGsmNummer(tfContactGSM8.getValue());
         persoon8.setNaam(tfContactNaam8.getValue());
         persoon8.setTelefoonNummer(tfContactTel8.getValue());
         persoon8.setVoorNaam(tfContactVoornaam8.getValue());

         personenLijst.add(persoon8);

        return personenLijst;
    }
}
