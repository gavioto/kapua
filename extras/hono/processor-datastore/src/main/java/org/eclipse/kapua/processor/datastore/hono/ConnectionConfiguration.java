/*******************************************************************************
 * Copyright (c) 2018 Eurotech and/or its affiliates and others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Eurotech - initial API and implementation
 *******************************************************************************/
package org.eclipse.kapua.processor.datastore.hono;

import org.eclipse.kapua.processor.datastore.hono.settings.HonoDatastoreSettings;
import org.eclipse.kapua.processor.datastore.hono.settings.HonoDatastoreSettingsKey;

public class ConnectionConfiguration {

    private String connectionHost;

    private int port;

    private String username;

    private String password;

    private int connectTimeout;

    private int maxReconnectAttempts;

    private int idelTimeout;

    public ConnectionConfiguration() {
        connectionHost = HonoDatastoreSettings.getInstance().getString(HonoDatastoreSettingsKey.CONNECTION_HOST);
        port = HonoDatastoreSettings.getInstance().getInt(HonoDatastoreSettingsKey.CONNECTION_PORT);
        username = HonoDatastoreSettings.getInstance().getString(HonoDatastoreSettingsKey.CONNECTION_USERNAME);
        password = HonoDatastoreSettings.getInstance().getString(HonoDatastoreSettingsKey.CONNECTION_PASSWORD);
        connectTimeout = HonoDatastoreSettings.getInstance().getInt(HonoDatastoreSettingsKey.CONNECT_TIMEOUT);
        maxReconnectAttempts = HonoDatastoreSettings.getInstance().getInt(HonoDatastoreSettingsKey.MAX_RECONNECTION_ATTEMPTS);
        idelTimeout = HonoDatastoreSettings.getInstance().getInt(HonoDatastoreSettingsKey.IDLE_TIMEOUT);
    }

    public String getConnectionHost() {
        return connectionHost;
    }

    public void setConnectionHost(String connectionHost) {
        this.connectionHost = connectionHost;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getMaxReconnectAttempts() {
        return maxReconnectAttempts;
    }

    public void setMaxReconnectAttempts(int maxReconnectAttempts) {
        this.maxReconnectAttempts = maxReconnectAttempts;
    }

    public int getIdelTimeout() {
        return idelTimeout;
    }

    public void setIdelTimeout(int idelTimeout) {
        this.idelTimeout = idelTimeout;
    }
}
