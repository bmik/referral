package edu.uek.referral.logic.server.examination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bmik on 2015-06-10.
 */
public class ExaminationParameter {

    private static final List<String> PARAMETER_NAMES = new ArrayList<String>(Arrays.asList(
            "cholesterol ca³kowity",
            "frakcja LDL",
            "HDL (dla mê¿czyzn)",
            "HDL (dla kobiet)",
            "trójglicerydy"
            ));

    private static final List<String> PARAMETER_UNITS = new ArrayList<String>(Arrays.asList(
            "mg/d",
            "mmol/d",
            "ml",
            "%"
            ));

    public static String getParameterName(int index) {
        return PARAMETER_NAMES.get(index);
    }

    public static String getParameterUnit(int index) {
        return PARAMETER_UNITS.get(index);
    }

    public static int getParameterNamesSize() {
        return PARAMETER_NAMES.size();
    }

    public static int getParameterUnitsSize() {
        return PARAMETER_UNITS.size();
    }
}
