/**
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.spring.xml;

import org.apache.camel.builder.Fluent;
import org.apache.camel.builder.FluentArg;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;

public class MethodInfo {
    final Method method;
    final Fluent methodAnnotation;
    final LinkedHashMap<String, Class> parameters;
    final LinkedHashMap<String, FluentArg> parameterAnnotations;

    public MethodInfo(Method method, Fluent fluentAnnotation, LinkedHashMap<String, Class> parameters, LinkedHashMap<String, FluentArg> annotations) {
        this.method = method;
        this.methodAnnotation = fluentAnnotation;
        this.parameters = parameters;
        this.parameterAnnotations = annotations;
    }

    public String getName() {
        return method.getName();
    }
}