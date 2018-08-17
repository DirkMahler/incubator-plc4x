/*
 Licensed to the Apache Software Foundation (ASF) under one
 or more contributor license agreements.  See the NOTICE file
 distributed with this work for additional information
 regarding copyright ownership.  The ASF licenses this file
 to you under the Apache License, Version 2.0 (the
 "License"); you may not use this file except in compliance
 with the License.  You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing,
 software distributed under the License is distributed on an
 "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 KIND, either express or implied.  See the License for the
 specific language governing permissions and limitations
 under the License.
 */
package org.apache.plc4x.java.api.messages;

import org.hamcrest.core.IsEqual;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class PlcProprietaryResponseTest {
    @Test
    public void constructor() {
        new PlcProprietaryResponse<>(mock(PlcProprietaryRequest.class), new Object());
    }

    @Test
    public void getValue() {
        Object customResponse = new Object();
        Object response = new PlcProprietaryResponse<>(mock(PlcProprietaryRequest.class), customResponse).getResponse();
        assertThat(response, equalTo(customResponse));
    }

    @Test
    public void equalsAndHashCode() {
        Object customResponse = new Object();
        PlcProprietaryRequest request = mock(PlcProprietaryRequest.class);
        PlcProprietaryResponse SUT = new PlcProprietaryResponse<>(request, customResponse);
        PlcProprietaryResponse other = new PlcProprietaryResponse<>(request, customResponse);
        assertThat(SUT.hashCode(), IsEqual.equalTo(other.hashCode()));
        assertThat(SUT.equals(other), IsEqual.equalTo(true));
        assertThat(SUT.equals(new Object()), IsEqual.equalTo(false));
        assertEquals(SUT, SUT);
    }
}