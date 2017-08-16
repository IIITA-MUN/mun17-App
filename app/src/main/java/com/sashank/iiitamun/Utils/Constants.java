package com.sashank.iiitamun.Utils;

import com.sashank.iiitamun.R;
import com.sashank.iiitamun.Utils.SecretariatPerson;

import java.util.ArrayList;

import static com.sashank.iiitamun.R.mipmap.ic_launcher;

/**
 * Created by sashank on 31/7/17.
 */


public class Constants {
    public static ArrayList<SecretariatPerson> secretariatList= new ArrayList<>();

    static {

        secretariatList.add(new SecretariatPerson(
                R.drawable.gjr,"Gaganjeet Reen","Secretary General",null,
                null,"gaganjeet.reen",true));

        secretariatList.add(new SecretariatPerson(
                R.drawable.aayushi,"Ayushi Asthana","Director General",null,
                        null,"ayushi.asthana.7",false));

        secretariatList.add(new SecretariatPerson(
                R.drawable.manasi,"Manasi Mohandas","Director General",null,
                        null,"manasi.mohandas.1",true));

        secretariatList.add(new SecretariatPerson(
                R.drawable.mantek,"Mantek Singh","Deputy Secretary General",null,
                        null,"mantek.singh",false));

        secretariatList.add(new SecretariatPerson(
                R.drawable.bhanu,"Bhanu Bhandari","USG Administration",null,
                        null,"falafelraider",true));

        secretariatList.add(new SecretariatPerson(
                R.drawable.maanas,"Maanas Vohra","USG International Press",null,
                        null,"maanas.vohra",false));

        secretariatList.add(new SecretariatPerson(
                ic_launcher,"Kartik Madaan","USG International Press",null,
                        null,"kartik.madaan.90",true));

        secretariatList.add(new SecretariatPerson(
                R.drawable.rishi,"Rishi Shukla", "USG Socio-Economic Affairs","7234047435",
                "iec2016007@iiita.ac.in","rishishukla5598",false));

        secretariatList.add(new SecretariatPerson(
                R.drawable.gali,"Niharika Gali","USG Delegate Affairs", null,
                null,"niharikagali",true));

        secretariatList.add(new SecretariatPerson(
                R.drawable.aditi,"Aditi Agrawal","USG Delegate Affairs",null,
                null,"aditi.agrawal.5817",false));

        secretariatList.add(new SecretariatPerson(
                R.drawable.dhvith,"Dhvit Mehta","USG Financial Affairs",null,
                null,"thismanisawesome",true));

        secretariatList.add(new SecretariatPerson(
                R.drawable.ravi,"Ravi Charan","USG Information Services",null,
                null,"ravi.charan.5680",false));

        secretariatList.add(new SecretariatPerson(
                R.drawable.sashank,"Sashank Mishra","USG Information Services","7275253323",
                "iwm2016001@iiita.ac.in","100000179816805",true));

        secretariatList.add(new SecretariatPerson(
                R.drawable.anmol,"Anmol Sethi","USG Delegate Welfare",null,
                null,"anmolsingh.sethi",false));

        secretariatList.add(new SecretariatPerson(
                R.drawable.ridam,"Ridam Arora","USG Delegate Welfare",null,
                null,"ridamarora89",true));

        secretariatList.add(new SecretariatPerson(
                R.drawable.sid,"Siddhant Srivastav","USG Creative Content",null,
                null,"siddhant.srivastav.3",false));

        secretariatList.add(new SecretariatPerson(
                R.drawable.kadambari,"Kadambari Anuranjana","USG Conference Services",null,
                null,"kadambari.kaveri",true));

    }
}
