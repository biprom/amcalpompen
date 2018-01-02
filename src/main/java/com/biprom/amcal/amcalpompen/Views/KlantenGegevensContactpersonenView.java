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

    Personen persoon = new Personen();
    List<Personen> personenLijst = new ArrayList<>();

    public KlantenGegevensContactpersonenView() {
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }

    public List<Personen> returnCustomerContacts(){

        personenLijst.clear();

        persoon.setEmailAdres(tfContactEmail1.getValue());
        persoon.setGsmNummer(tfContactGSM1.getValue());
        persoon.setNaam(tfContactNaam1.getValue());
        persoon.setTelefoonNummer(tfContactTel1.getValue());
        persoon.setVoorNaam(tfContactNaam1.getValue());

        personenLijst.add(persoon);

         persoon.setEmailAdres(tfContactEmail2.getValue());
         persoon.setGsmNummer(tfContactGSM2.getValue());
         persoon.setNaam(tfContactNaam2.getValue());
         persoon.setTelefoonNummer(tfContactTel2.getValue());
         persoon.setVoorNaam(tfContactNaam2.getValue());

         personenLijst.add(persoon);

         persoon.setEmailAdres(tfContactEmail3.getValue());
         persoon.setGsmNummer(tfContactGSM3.getValue());
         persoon.setNaam(tfContactNaam3.getValue());
         persoon.setTelefoonNummer(tfContactTel3.getValue());
         persoon.setVoorNaam(tfContactNaam3.getValue());

         personenLijst.add(persoon);

         persoon.setEmailAdres(tfContactEmail4.getValue());
         persoon.setGsmNummer(tfContactGSM4.getValue());
         persoon.setNaam(tfContactNaam4.getValue());
         persoon.setTelefoonNummer(tfContactTel4.getValue());
         persoon.setVoorNaam(tfContactNaam4.getValue());

         personenLijst.add(persoon);

         persoon.setEmailAdres(tfContactEmail5.getValue());
         persoon.setGsmNummer(tfContactGSM5.getValue());
         persoon.setNaam(tfContactNaam5.getValue());
         persoon.setTelefoonNummer(tfContactTel5.getValue());
         persoon.setVoorNaam(tfContactNaam5.getValue());

         personenLijst.add(persoon);

         persoon.setEmailAdres(tfContactEmail6.getValue());
         persoon.setGsmNummer(tfContactGSM6.getValue());
         persoon.setNaam(tfContactNaam6.getValue());
         persoon.setTelefoonNummer(tfContactTel6.getValue());
         persoon.setVoorNaam(tfContactNaam6.getValue());

         personenLijst.add(persoon);

         persoon.setEmailAdres(tfContactEmail7.getValue());
         persoon.setGsmNummer(tfContactGSM7.getValue());
         persoon.setNaam(tfContactNaam7.getValue());
         persoon.setTelefoonNummer(tfContactTel7.getValue());
         persoon.setVoorNaam(tfContactNaam7.getValue());

         personenLijst.add(persoon);

         persoon.setEmailAdres(tfContactEmail8.getValue());
         persoon.setGsmNummer(tfContactGSM8.getValue());
         persoon.setNaam(tfContactNaam8.getValue());
         persoon.setTelefoonNummer(tfContactTel8.getValue());
         persoon.setVoorNaam(tfContactNaam8.getValue());

         personenLijst.add(persoon);

        return personenLijst;
    }
}
