package com.sashank.iiitamun.Fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sashank.iiitamun.Adapters.AboutUsPagerAdapter;
import com.sashank.iiitamun.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class AboutUsFragment extends Fragment {

    public static final String ARG_SECTION_NUMBER = "section_number";

    int mResources[] = {R.drawable.iiita, R.drawable.effe17, R.drawable.mun_logo, R.drawable.sarasva_logo};

    String[] mTitles = {
            "IIIT ALLAHABAD",
            "EFFERVESCENCE",
            "IIITA MUN",
            "SARASVA"
    };

    String[] mDetails = {
            "The Indian Institute of Information Technology Allahabad (IIIT-A) was established in 1999, as a Center of Excellence in Information Technology and allied areas. The institute was conferred the “Deemed University” status by Government of India in the year 2000.\n" +
                    "\n" +
                    "The Institute has been conceived with the ambitious objectives of developing professional expertise and skilled manpower in Information Technology (IT) and related areas. The mission of IIIT, Allahabad is to be a unique and world class nucleating “Apex Center of Excellence” in the area of Information Technology and Allied Sciences, so as to enhance India’s Technological strength in IT and for become a pace-setting institution for other similar institutes to be established in the future. IIIT seeks to derive its strength from a linkage with sound Indian traditions of centuries past, and sets out to create knowledge-based resources in regional languages.\n" +
                    "\n" +
                    "The beautiful 100 acre campus, situated at Deoghat, Jhalwa, designed meticulously on the Penrose Geometry pattern, is being further topped by fine landscaping to give an all round soothing effect to create a stimulating environment.",
            "Effervescence, the cultural fest of IIIT Allahabad, has grown into one of the largest and most entertaining cultural festivals of India. The cultural spirits of all mingle to bring forth the fizz, frolic and festivity of this 3 day extravaganza.\n"
                    +"\n" +
                    "Effervescence is a lively journey with 3 days of high octane entertainment. The festivities comprise of a plethora of informal events in the morning, and in the evening, a full platter if dance, dramatics, music and literary competitions unfold. The final night of Effervescence has seen bands like Bombay Vikings, Euphoria, Silk Route and Strings, along with celebrities such as Neha Kakkar, Sona Mohapatra and Daler Mehndi performing live.\n" +
                    "\n" +
                    "Effervescence is the time that allows the youth to fully express themselves - be it through art, culture or entertainment.",
            "IIITA MUN is the first Model United Nations in the city of Allahabad. Started in 2014, it is an intiative which aims to establish a healthy MUNing culture. IIITA MUN will put to test one’s ability to research, persuade, and lead, testing the fledgling diplomat in them. Delegates will work with participants from all over the country in a highly competitive environment. In dissecting world affairs and creating policies in a conference of the highest quality, we hope to transform you from students into future leaders, all the while creating unforgettable memories.",
            "Sarasva is the Literary Society of the Indian Institute of Information Technology, Allahabad. The society has striven to promote debate, discussion and dialouge on campus through several events and initiatives including a TEDx, Model United Nations, Lit-a-thon, One on One and Group debates, Parliamentary Debates, Kavi Sammelans, creative writing, quizzing etc. The society also runs the Institute Newsletter which gathers and delivers news from around the campus apart from running a Media Team, Editorial Team and the International Press Team.\n\n" +
                    "Literature is the art of discovering something extraordinary about ordinary things and saying with ordinary words something extraordinary. At Sarasva we endeavour to push the boundaries of literature and quizzing in order to usher in a atmosphere of active dialouge.\n" +
                    "\n" +
                    "Yes, literature can be weird. It can be understood through tough thorough thought, though!"
    };

    public AboutUsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_about_us, container, false);

        int position = getArguments().getInt(ARG_SECTION_NUMBER);

        TextView mAboutDetails = (TextView) rootView.findViewById(R.id.tv_about_details);
        TextView mAboutTitle = (TextView) rootView.findViewById(R.id.tv_about_title);
        ImageView image = (ImageView) rootView.findViewById(R.id.iv_about_us);
        TextView mPageNumber = (TextView) rootView.findViewById(R.id.tv_page_number);


        image.setImageResource(mResources[position]);
        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/SourceSansPro-Regular.ttf");
        Typeface tfb = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/Nexa_Bold.otf");
        mAboutDetails.setText(mDetails[position]);
        mAboutDetails.setTypeface(tf);
        mAboutTitle.setText(mTitles[position]);
        mAboutTitle.setTypeface(tfb);

        String pageNo = Integer.toString(position + 1) + " / 4" ;
        mPageNumber.setText(pageNo);

        return rootView;
    }
}
