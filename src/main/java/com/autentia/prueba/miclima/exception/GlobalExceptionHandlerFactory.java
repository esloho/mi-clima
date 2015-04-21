package com.autentia.prueba.miclima.exception;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

/**
 * Factory of global handlers for exceptions in this application.
 * 
 * @author esloho
 *
 */
public class GlobalExceptionHandlerFactory extends ExceptionHandlerFactory {

    private final ExceptionHandlerFactory parent;

    /**
     * Construct from the parent ExceptionHandlerFactory.
     * 
     * @param parentFactory
     */
    public GlobalExceptionHandlerFactory(ExceptionHandlerFactory parentFactory) {
        this.parent = parentFactory;
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.faces.context.ExceptionHandlerFactory#getExceptionHandler()
     */
    @Override
    public ExceptionHandler getExceptionHandler() {
        final ExceptionHandler exceptionHandler = new GlobalExceptionHandler(
                this.parent.getExceptionHandler());
        return exceptionHandler;
    }

}
