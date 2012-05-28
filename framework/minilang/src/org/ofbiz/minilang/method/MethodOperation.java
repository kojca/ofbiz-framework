/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *******************************************************************************/
package org.ofbiz.minilang.method;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.ofbiz.minilang.MiniLangElement;
import org.ofbiz.minilang.MiniLangException;
import org.ofbiz.minilang.SimpleMethod;
import org.w3c.dom.Element;

/**
 * An abstract class for Mini-language element models.
 */
public abstract class MethodOperation extends MiniLangElement {


    protected MethodOperation(Element element, SimpleMethod simpleMethod) {
        super(element, simpleMethod);
    }

    /**
     * Executes the operation.
     * Returns <code>true</code> if script execution should continue, or
     * <code>false</code> if script execution should stop.
     * 
     * @throws MiniLangException */
    public abstract boolean exec(MethodContext methodContext) throws MiniLangException;

    /** Create a string representation of the operation, using the current context.
     * <p><strong>Deprecated:</strong> No replacement.</p>
     */
    public abstract String expandedString(MethodContext methodContext);

    /** Create a string representation of the operation - similar to the original XML.
     * <p><strong>Deprecated:</strong> Use {@link #toString()}.</p>
     */
    public abstract String rawString();

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface DeprecatedOperation {
        String value();
    }

    public interface Factory<M extends MethodOperation> {

        M createMethodOperation(Element element, SimpleMethod simpleMethod) throws MiniLangException;

        String getName();
    }
}
