package com.autentia.prueba.miclima.exception;

import java.util.Iterator;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

import com.autentia.prueba.miclima.util.MiClimaConstants;

/**
 * Global handler of exceptions in this application.
 * 
 * @author esloho
 *
 */
public class GlobalExceptionHandler extends ExceptionHandlerWrapper {

    ExceptionHandler wrapped;

    /**
     * Construct from the parent ExceptionHandler.
     * 
     * @param parentWrapper
     */
    public GlobalExceptionHandler(ExceptionHandler parentWrapper) {
        this.wrapped = parentWrapper;
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.faces.context.ExceptionHandlerWrapper#getWrapped()
     */
    @Override
    public ExceptionHandler getWrapped() {
        return this.wrapped;
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.faces.context.ExceptionHandlerWrapper#handle()
     */
    @Override
    public void handle() throws FacesException {
        final Iterator<ExceptionQueuedEvent> exceptionsEventIterator = getHandledExceptionQueuedEvents()
                .iterator();

        while (exceptionsEventIterator.hasNext()) {
            final ExceptionQueuedEvent exceptionEvent = exceptionsEventIterator
                    .next();
            final ExceptionQueuedEventContext exceptionContext = (ExceptionQueuedEventContext) exceptionEvent
                    .getSource();
            final Throwable exception = exceptionContext.getException();

            final FacesContext fc = FacesContext.getCurrentInstance();
            final Map<String, Object> requestMap = fc.getExternalContext()
                    .getRequestMap();
            final NavigationHandler navigationHandler = fc.getApplication()
                    .getNavigationHandler();

            try {
                requestMap.put("exceptionMessage", exception.getMessage());
                navigationHandler.handleNavigation(fc, null,
                        MiClimaConstants.ERROR_PATH);
            } finally {
                exceptionsEventIterator.remove();
            }
        }

        getWrapped().handle();
    }
}
