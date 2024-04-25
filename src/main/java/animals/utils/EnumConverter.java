package animals.utils;

import data.CommandData;

public class EnumConverter {
    public <T extends Enum<T>> String getNamesFromEnum(Class<T> clazz, String delimiter) {
        T[] values = clazz.getEnumConstants();
        String[] comandsConsole = new String[CommandData.values().length];
        for (int i = 0; i < values.length; i++) {
            comandsConsole[i] = values[i].name().toLowerCase(); // toLowerCase() - в нижнем регистре

        }
        return String.join(delimiter, comandsConsole);
    }


}
