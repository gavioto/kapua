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
package org.eclipse.kapua.processor.lifecycle.broker;

import org.eclipse.kapua.commons.core.ObjectContextConfig;
import org.eclipse.kapua.commons.core.ObjectFactory;
import org.eclipse.kapua.commons.util.xml.JAXBContextProvider;
import org.eclipse.kapua.message.transport.TransportMessage;
import org.eclipse.kapua.processor.commons.HttpServiceVerticle;
import org.eclipse.kapua.processor.commons.JAXBContextProviderImpl;
import org.eclipse.kapua.processor.commons.MessageProcessorConfig;
import org.eclipse.kapua.processor.commons.MessageProcessorVerticle;

import com.google.inject.TypeLiteral;

public class ProcessorContextConfig extends ObjectContextConfig {

    public ProcessorContextConfig() {
    }

    @Override
    protected void configure() {
        super.configure();
        bind(MainVerticle.class);
        bind(HttpServiceVerticle.class);
        bind(JAXBContextProvider.class).to(JAXBContextProviderImpl.class);
        bind(MessageProcessorVerticle.class).to(AmqpLifecycleProcessorVerticle.class);
        bind(new TypeLiteral<ObjectFactory<MessageProcessorConfig<byte[],TransportMessage>>>() {}).to(AmqpLifecycleProcessorConfigFactory.class);
    }

}