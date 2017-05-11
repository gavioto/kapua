/*******************************************************************************
 * Copyright (c) 2011, 2017 Eurotech and/or its affiliates and others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Eurotech - initial API and implementation
 *     Red Hat Inc
 *******************************************************************************/
package org.eclipse.kapua.app.console.servlet;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.json.JsonObject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.utils.URIBuilder;
import org.eclipse.kapua.app.console.server.util.SsoLocator;
import org.eclipse.kapua.app.console.setting.ConsoleSetting;
import org.eclipse.kapua.app.console.setting.ConsoleSettingKeys;
import org.eclipse.kapua.sso.SingleSignOnLocator;

public class SsoCallbackServlet extends HttpServlet {

    private static final long serialVersionUID = -4854037814597039013L;

    private final ConsoleSetting settings = ConsoleSetting.getInstance();

    private SingleSignOnLocator locator;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.locator = SsoLocator.getLocator(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String authCode = req.getParameter("code");

        final JsonObject jsonObject = locator.getService().getAccessToken(authCode);

        // Get and clean jwks_uri property
        final String accessToken = jsonObject.getString("access_token");
        final String homeUri = settings.getString(ConsoleSettingKeys.SITE_HOME_URI);

        try {
            final URIBuilder redirect = new URIBuilder(homeUri);
            redirect.addParameter("access_token", accessToken);
            resp.sendRedirect(redirect.toString());
        } catch (final URISyntaxException e) {
            throw new ServletException("Failed to parse redirect URL: " + homeUri, e);
        }
    }
}
