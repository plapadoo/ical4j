package net.fortuna.ical4j.validate;

import java.util.ServiceLoader;

/**
 * Created by fortuna on 13/09/15.
 */
public abstract class AbstractCalendarValidatorFactory {

    private static CalendarValidatorFactory instance;
    static {
        ClassLoader currentCl = Thread.currentThread().getContextClassLoader();
        try {
            Thread.currentThread().setContextClassLoader(AbstractCalendarValidatorFactory.class.getClassLoader());
            instance = ServiceLoader.load(CalendarValidatorFactory.class).iterator().next();
        } finally {
            Thread.currentThread().setContextClassLoader(currentCl);
        }
    }

    public static CalendarValidatorFactory getInstance() {
        return instance;
    }
}
