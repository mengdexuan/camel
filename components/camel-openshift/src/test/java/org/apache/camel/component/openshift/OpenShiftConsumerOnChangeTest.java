/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.openshift;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class OpenShiftConsumerOnChangeTest extends CamelTestSupport {

    private String username;
    private String password;

    @Override
    public void setUp() throws Exception {
        // INSERT credentials here
        username = null;
        password = null;
        super.setUp();
    }

    @Test
    public void testConsumer() throws Exception {
        if (username == null) {
            return;
        }

        getMockEndpoint("mock:result").expectedMinimumMessageCount(1);

        assertMockEndpointsSatisfied();
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                fromF("openshift:myApp?username=%s&password=%s&delay=5s", username, password)
                    .log("Event ${header.CamelOpenShiftEventType} for app ${body.name}")
                    .to("mock:result");
            }
        };
    }
}
