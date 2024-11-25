package com.example.resturant;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.CheckBoxPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreference;


public class SettingsFragment extends PreferenceFragmentCompat {

    static SharedPreferences lightModeSharedPref;
    static String LIGHT_KEY="isLight";
    static SwitchPreference isLightSwitch;
    static boolean isLightBool;
    static String SHARED_PREFERENCES_SWITCH = "sharedPrefSwitch";
    SharedPreferences.Editor lightModeSharedPrefEditor;
    @SuppressLint("MissingInflatedId")

    @Override
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {


        setPreferencesFromResource(R.xml.shared_preferences,rootKey);


        isLightSwitch= (SwitchPreference) getPreferenceManager().findPreference("sharedPref_switch_light_dark_mode");

        lightModeSharedPref= getActivity().getSharedPreferences(LIGHT_KEY, Context.MODE_PRIVATE);
        lightModeSharedPrefEditor=lightModeSharedPref.edit();

        isLightBool = lightModeSharedPref.getBoolean(LIGHT_KEY,true);
        isLightSwitch.setChecked(isLightBool);

        isLightSwitch.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                if(newValue instanceof  Boolean){
                    isLightBool=((Boolean) newValue).booleanValue();
                    if(isLightBool==true){
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    }else{
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

                    }
                    lightModeSharedPrefEditor.putBoolean(LIGHT_KEY,isLightBool);
                    lightModeSharedPrefEditor.commit();
                    isLightSwitch.setChecked(isLightBool);
                }
                return true;
            }
        });

}
}
