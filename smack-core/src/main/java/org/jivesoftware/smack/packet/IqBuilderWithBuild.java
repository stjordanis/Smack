/**
 *
 * Copyright 2019 Florian Schmaus
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.util.Objects;

// TODO: Rename to IqBuilder.
public abstract class IqBuilderWithBuild<IB extends IqBuilderWithBuild<IB, I>, I extends IQ>
                extends AbstractIqBuilder<IB> {

    protected IqBuilderWithBuild(AbstractIqBuilder<?> other) {
        super(other);
    }

    protected IqBuilderWithBuild(XMPPConnection connection) {
        super(connection.getStanzaFactory().getStanzaIdSource());
    }

    protected IqBuilderWithBuild(String stanzaId) {
        super(stanzaId);
    }

    public IB ofType(IQ.Type type) {
        this.type = Objects.requireNonNull(type);
        return getThis();
    }

    public abstract I build();

}