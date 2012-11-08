/*
 * Licensed to ElasticSearch and Shay Banon under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. ElasticSearch licenses this
 * file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.common.logging.log4j;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.elasticsearch.common.logging.support.AbstractESLogger;

/**
 *
 */
public class Log4jESLogger extends AbstractESLogger {

    private final org.apache.log4j.Logger logger;

    public Log4jESLogger(String prefix, Logger logger) {
        super(prefix);
        this.logger = logger;
    }

    public void setLevel(String level) {
        if ("error".equalsIgnoreCase(level)) {
            logger.setLevel(Level.ERROR);
        } else if ("warn".equalsIgnoreCase(level)) {
            logger.setLevel(Level.WARN);
        } else if ("info".equalsIgnoreCase(level)) {
            logger.setLevel(Level.INFO);
        } else if ("debug".equalsIgnoreCase(level)) {
            logger.setLevel(Level.DEBUG);
        } else if ("trace".equalsIgnoreCase(level)) {
            logger.setLevel(Level.TRACE);
        }
    }

    
    public String getName() {
        return logger.getName();
    }

    
    public boolean isTraceEnabled() {
        return logger.isTraceEnabled();
    }

    
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    
    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    
    public boolean isWarnEnabled() {
        return logger.isEnabledFor(Level.WARN);
    }

    
    public boolean isErrorEnabled() {
        return logger.isEnabledFor(Level.ERROR);
    }

    
    protected void internalTrace(String msg) {
        logger.trace(msg);
    }

    
    protected void internalTrace(String msg, Throwable cause) {
        logger.trace(msg, cause);
    }

    
    protected void internalDebug(String msg) {
        logger.debug(msg);
    }

    
    protected void internalDebug(String msg, Throwable cause) {
        logger.debug(msg, cause);
    }

    
    protected void internalInfo(String msg) {
        logger.info(msg);
    }

    
    protected void internalInfo(String msg, Throwable cause) {
        logger.info(msg, cause);
    }

    
    protected void internalWarn(String msg) {
        logger.warn(msg);
    }

    
    protected void internalWarn(String msg, Throwable cause) {
        logger.warn(msg, cause);
    }

    
    protected void internalError(String msg) {
        logger.error(msg);
    }

    
    protected void internalError(String msg, Throwable cause) {
        logger.error(msg, cause);
    }
}
