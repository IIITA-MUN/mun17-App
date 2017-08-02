package com.sashank.iiitamun.Utils;

import com.sashank.iiitamun.Utils.SecretariatPerson;

import java.util.ArrayList;

import static com.sashank.iiitamun.R.mipmap.ic_launcher;

/**
 * Created by sashank on 31/7/17.
 */


public class Constants {
    public static ArrayList<SecretariatPerson> secretariatList= new ArrayList<>();

    static {

        secretariatList.add(new SecretariatPerson(ic_launcher,"Gaganjeet Reen","Secretary General",null,null,null,true));

        secretariatList.add(new SecretariatPerson(ic_launcher,"Ayushi Asthana","Director General",null,null,null,false));

        secretariatList.add(new SecretariatPerson(ic_launcher,"Manasi Mohandas","Director General",null,null,null,true));

        secretariatList.add(new SecretariatPerson(ic_launcher,"Mantek Singh","Deputy Secretary General",null,null,null,false));

        secretariatList.add(new SecretariatPerson(ic_launcher,"Bhanu Bhandari","USG Administration",null,null,null,true));

        secretariatList.add(new SecretariatPerson(ic_launcher,"Maanas Vohra","USG International Press",null,null,null,false));

        secretariatList.add(new SecretariatPerson(ic_launcher,"Kartik Madaan","USG International Press",null,null,null,true));

        secretariatList.add(new SecretariatPerson(ic_launcher,"Rishi Shukla", "USG Socio-Economic Affairs",null,null,null,false));

        secretariatList.add(new SecretariatPerson(ic_launcher,"Niharika Gali","USG Delegate Affairs",null,null,null,true));

        secretariatList.add(new SecretariatPerson(ic_launcher,"Aditi Agrawal","USG Delegate Affairs",null,null,null,false));

        secretariatList.add(new SecretariatPerson(ic_launcher,"Dhvit Mehta","USG Financial Affairs",null,null,null,true));

        secretariatList.add(new SecretariatPerson(ic_launcher,"Ravi Charan","USG Information Services",null,null,null,false));

        secretariatList.add(new SecretariatPerson(ic_launcher,"Sashank Mishra","USG Information Services",null,null,null,true));

        secretariatList.add(new SecretariatPerson(ic_launcher,"Anmol Sethi","USG Delegate Welfare",null,null,null,false));

        secretariatList.add(new SecretariatPerson(ic_launcher,"Ridam Arora","USG Delegate Welfare",null,null,null,true));

        secretariatList.add(new SecretariatPerson(ic_launcher,"Siddhant Srivastav","USG Creative Content",null,null,null,false));

        secretariatList.add(new SecretariatPerson(ic_launcher,"Kadambari Anuranjana","USG Conference Services",null,null,null,true));

    }
}
